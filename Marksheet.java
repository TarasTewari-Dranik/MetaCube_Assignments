package specification.assignment.marksheet;
/**
 * Reads in grades of n no of students. Assume n as a positive integer and grades will be between 0 and 100 both inclusive.
 * @author tarasdranik
 *
 */
public class Marksheet {
    /**
     * Return average of all grades.
     * @param gradesSheet array with grades
     * @throws aritnmetic exception if array is empty
     * @return float average which equal to average of grades
     */
    public float averageGrades (float[] gradesSheet){
        int n=gradesSheet.length;
        float sum = 0;
        float average = 0;
        for (float grade:gradesSheet){
            sum = sum+grade;
        }
        if (n == 0){
            throw new ArithmeticException("List of grades is empty"); 
        } else {
            average = sum/n;
        }
        return average;
    }
    /**
     * Return maximum of all grades
     * @param gradesSheet array with grades
     * @return float maxMark maximum of all grades
     */
    public float maxGrade (float[] gradesSheet){
        float maxMark = 0;
        for (float grade:gradesSheet){
            if (grade > maxMark){
                maxMark = grade;
            }
        }
        return maxMark;
    }
    /**
     * Return minimum of all grades.
     * @param gradesSheet array with grades
     * @return float minMark minimum of all grades
     */
    public float minGrade (float[] gradesSheet){
        float minMark = gradesSheet[0];
        for (int i = 1; i > gradesSheet.length; i++){
            if (minMark > gradesSheet[i]){
                minMark = gradesSheet[i];
            }
        }
        return minMark;
    }
    /**
     * Return percentage of students passed.
     * @param gradesSheet array with grades
     * @param threshold float number which indicates minimum mark to pass
     * @return float studentsPassed percentage of students passed
     */
    public float percentageStudentsPassed (float[] gradesSheet, float threshold){
        int n=gradesSheet.length;
        int counter=0;
        float studentsPassed = 0;
        for (float grade:gradesSheet){
            if (grade >=threshold){
                counter+=1;
            }
        }
        if (n == 0){
            throw new ArithmeticException("List of grades is empty"); 
        } else {
            studentsPassed = counter/n*100;
        }
        return studentsPassed;
    }
}
