package specification.assignment.area.calculation;
import java.util.Scanner;


public class Main {
    

    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Area of which shape do you want to calculate?"+"\n");
            System.out.print("1 for Triangle; 2 for Rectangle; 3 for Square;4 for Circle; O for Exit"+"\n");
            choice = input.nextInt();
            switch (choice) {
            case 1:
                System.out.print("Provide width"+"\n");
                double widthTriangle = input.nextDouble();
                System.out.print("Provide height"+"\n");
                double heightTriangle = input.nextDouble();
                System.out.printf("Area of triangle is " +new Area().triangleArea(widthTriangle, heightTriangle)+"\n");
                break;
            case 2:
                System.out.print("Provide width"+"\n");
                double widthRectangle = input.nextDouble();
                System.out.print("Provide height"+"\n");
                double heightRectangle = input.nextDouble();
                System.out.printf("Area of rectangle is " +new Area().rectangleArea(widthRectangle, heightRectangle)+"\n");
                break;
            case 3:
                System.out.print("Provide width"+"\n");
                double widthSquare = input.nextDouble();
                System.out.printf("Area of square is " +new Area().squareArea(widthSquare)+"\n");
                break;
            case 4:
                System.out.print("Provide radius"+"\n");
                double radius = input.nextDouble();
                System.out.printf("Area of square is " +new Area().circleArea(radius)+"\n");
                break;
            default:
                break;
            }
        } while (choice != 0);
    }
}
