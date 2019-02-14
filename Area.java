package specification.assignment.area.calculation;
/**
 * Calculates areas for different shapes
 * @author tarasdranik
 *
 */
public class Area {
    /**
     * Calculates area of a Triangle
     * @param width double number of triangle width, greater than zero
     * @param height double number of triangle height, greater than zero
     * @exception return 0 if ArithmeticException is occurred
     * @return double area - area of a triangle
     */
    public double triangleArea (double width, double height) {
        try {
            double area = 0.5 *width*height;
            return area;
        } catch (ArithmeticException exTriangl){
            return 0;
        }
    }
    /**
     * Calculates area of a Rectangle
     * @param width double number of Rectangle width, greater than zero
     * @param height double number of Rectangle width, greater than zero
     * @exception return 0 if ArithmeticException is occurred
     * @return double area  - area of a Rectangle
     */
    public double rectangleArea (double width, double height) {
        try{
            double area = width*height;
            return area;
        } catch (ArithmeticException exRectangle) {
            return 0;
        }
    }
    /**
     * Calculates area of Square
     * @param width double number of Square width, greater than zero
     * @exception return 0 if ArithmeticException is occurred
     * @return double area  - area of a Square
     */
    public double squareArea (double width) {
        try{
            double area = width*width;
            return area;
        } catch (ArithmeticException exSquare){
            return 0;
        }
    }
    /**
     * Calculates area of Circle
     * @param radius double number of Circle radius, greater than zero
     * @exception return 0 if ArithmeticException is occurred
     * @return double area  - area of a Circle
     */
    public double circleArea (double radius) {
        try {
            double pi=3.14;
            double area = pi*radius*radius;
            return area;
        } catch (ArithmeticException exCircle){
            return 0;
        }
    }

}
