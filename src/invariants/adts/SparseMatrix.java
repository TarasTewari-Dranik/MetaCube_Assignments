package invariants.adts;

public class SparseMatrix {
    private final int[][] compactMatrix;
    private final int rowNumbers;
    private final int columnNumbers;
    private int row = 0;
    private int column = 1;
    private int nonZeroElement = 2;

    
    public SparseMatrix (int [][] matrix) {
        this.rowNumbers = matrix.length;
        this.columnNumbers = matrix[0].length;
        this.compactMatrix = matrixConstruction(matrix);
    }
    
    private int getRowNumbers () {
        return this.rowNumbers;
    }
    
    private int getColumnNumbers () {
        return this.columnNumbers;
    }
    // Rebresent Sparse Matrix as non zero 2D array of integers element
    private int [][] matrixConstruction (int [][] initialMatrix){
        int size = 0; 
        //Calculating non zero elements
        for (int i = 0; i < initialMatrix.length; i++) 
            for (int j = 0; j < initialMatrix[0].length; j++) 
                if (initialMatrix[i][j] != 0) 
                    size++; 
        // 0 - row index, 1 - column index, 2 - non zero element
        int [][] reducedMatrix = new int [3][size]; 
        int k = 0; 
        for (int i = 0; i < initialMatrix.length; i++) 
            for (int j = 0; j < initialMatrix[0].length; j++) 
                if (initialMatrix[i][j] != 0) { 
                    reducedMatrix[row][k] = i; 
                    reducedMatrix[column][k] = j; 
                    reducedMatrix[nonZeroElement][k] = initialMatrix[i][j]; 
                    k++; 
                } 
        return reducedMatrix;
    }
    
    public SparseMatrix add(SparseMatrix matrixToAdd){
        if (rowNumbers != matrixToAdd.getRowNumbers() || columnNumbers != matrixToAdd.getColumnNumbers()) {
            throw new ArithmeticException ("Matrices can't be added");
        } else {
            //Temporary matrix to store sum of appropriate ellements
            int [][] tempMatrix  = new int [rowNumbers][columnNumbers];
            for (int i=0; i < compactMatrix[0].length; i++) {
                tempMatrix [compactMatrix[row][i]] [compactMatrix[column][i]] = compactMatrix[nonZeroElement][i];
            }
            for (int j=0; j < matrixToAdd.compactMatrix[0].length; j++) {
                tempMatrix [matrixToAdd.compactMatrix[row][j]][matrixToAdd.compactMatrix[column][j]] = tempMatrix [matrixToAdd.compactMatrix[row][j]][matrixToAdd.compactMatrix[column][j]]+matrixToAdd.compactMatrix[nonZeroElement][j];
            }
            //Convert to sprce Matrix
            SparseMatrix addMatrix = new SparseMatrix(tempMatrix);
            return addMatrix;
        }
        
    }
    
    //Fast transpose of Sparce Matrix
    public int[][] transpose() {
        int [][] tempMatrix = new int [3][compactMatrix[0].length];
        int [] counter = new int [columnNumbers];
        //Determine the number of elements in each column of the original matrix.
        for (int i = 0; i < compactMatrix[0].length; i++) counter[compactMatrix[column][i]]+=1;
        int[] index = new int[columnNumbers];
        //Determine the starting positions of each row in the transpose matrix.
        for (int i = 1; i < columnNumbers; i++)
            index[i] = index[i-1] + counter[i-1];
        for (int i = 0; i < compactMatrix[0].length; i++) {
            //Determine the positions of each element.
            int insert = index[compactMatrix[column][i]]++;
            tempMatrix [row][insert] = compactMatrix[column][i];
            tempMatrix [column][insert] = compactMatrix[row][i];
            tempMatrix [nonZeroElement][insert] = compactMatrix [nonZeroElement][i];
        }
        
        return tempMatrix;
    }
    
    
    
    public int[][] multiplication(SparseMatrix matrixToMulti) {
        if (columnNumbers != matrixToMulti.getRowNumbers()) {
            throw new ArithmeticException ("Matrices can't be multiply");
        } else {
            //Transpose matrixToMulti
            int [][] transposeMatrixToMulti = matrixToMulti.transpose();
            int i, j;
            int k = 0;
            int [][] tempMatrix  = new int [3][transposeMatrixToMulti[0].length];
            for (i=0; i < compactMatrix[0].length;) {
                //Current row
                int r = compactMatrix[0][i];
                for (j=0; j < transposeMatrixToMulti[0].length;) {
                    //Current column
                    int c = transposeMatrixToMulti[0][j];
                    int tempMulti = i;
                    int tempToMulti = j;
                    int sum = 0;
                    while (tempMulti < compactMatrix[0].length && compactMatrix[0][tempMulti] == r
                            && tempToMulti < transposeMatrixToMulti[0].length && transposeMatrixToMulti[0][tempToMulti]==c) {
                        if (compactMatrix[1][tempMulti] < transposeMatrixToMulti[1][tempToMulti]) tempMulti++;
                        else if (compactMatrix[1][tempMulti] > transposeMatrixToMulti[1][tempToMulti]) tempToMulti++;
                        else //If compactMatrix row has the same column as the row of transposeMatrixToMulti they can be multiply and sumup
                            sum += compactMatrix[2][tempMulti++] * transposeMatrixToMulti[2][tempToMulti++];
                    }
                    
                    if (sum != 0) {
                        tempMatrix [0][k] = r;
                        tempMatrix [1][k] = c;
                        tempMatrix [2][k]=sum;
                        k++;
                    }
                    //Going to the next column
                    while (j<transposeMatrixToMulti[0].length && transposeMatrixToMulti[0][j] == c) j++;
                }
                //Going to the next row
                while (i < compactMatrix[0].length && compactMatrix[0][i] == r) i++;
            }
            
            return tempMatrix;
        }
    }
    
    
    
    public boolean symmetricalMatrix (SparseMatrix matrix) {
        //Symmetric matrix should be square matrix
        if (rowNumbers != columnNumbers) {
            return false;
        } else {
            //If matrix symmetric, original matrix should be equal to the transpose of this matrix
            int[][] transposeMatrix = matrix.transpose();
            for (int i=0; i < compactMatrix[0].length;i++) {
                if (transposeMatrix[row][i]!=compactMatrix[row][i]||transposeMatrix[column][i]!=compactMatrix[column][i]||transposeMatrix[nonZeroElement][i]!=compactMatrix[nonZeroElement][i]) return false;
            }
            return true;
        }
    }
    

}
