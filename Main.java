package specification.assignment.marksheet;
import java.text.DecimalFormat;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Students"+"\n");
        int num = input.nextInt();
        float[] grades = new float[num];
        for (int i = 0; i < grades.length; i++){
            System.out.println("Please enter grade for Student number "+(i+1));
            grades[i] = input.nextFloat();
        }
        System.out.println("Please enter threshold to indicate percentage of passed students ");
        float threshold = input.nextFloat();
        DecimalFormat df = new DecimalFormat(".##");
        System.out.printf("Average of all grades " +df.format(new Marksheet().averageGrades(grades))+"\n");
        System.out.printf("Maximum of all grades"+df.format(new Marksheet().maxGrade(grades))+"\n");
        System.out.printf("Minimum of all grades"+df.format(new Marksheet().minGrade(grades))+"\n");
        System.out.printf("Percentage of students passed"+df.format(new Marksheet().percentageStudentsPassed(grades,threshold))+"\n");
    }
}
