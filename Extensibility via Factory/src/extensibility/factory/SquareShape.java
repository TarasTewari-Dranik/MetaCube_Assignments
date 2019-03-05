package extensibility.factory;

import java.util.List;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Point;
import java.sql.Timestamp;

public class SquareShape implements Shape {
    private Point point;
    private int width;
    private Rectangle mySquare;
    private Timestamp timestamp;
    
    
    public SquareShape (Point p,List<Integer> parameters) {
        int widthSquare = parameters.get(0);
        this.point = p;
        this.width = widthSquare;
        this.mySquare  = new Rectangle(point,new Dimension (width,width));
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public double getArea() {
        return Math.pow(width, 2);
    }
    public double getPerimeter () {
        return 4*width;
    }
    
    public Timestamp getTime () {
        return timestamp;
    }
    
    //Calculates the distance between 0,0 coordinate and point of origin of the Shape
    public double getOrigin () {
        return Math.sqrt(Math.pow(point.getX(),2)+Math.pow(point.getY(), 2));
    }
    public boolean isPointEnclosed(Point enclosedPoint) {
        return mySquare.contains(enclosedPoint);
    }

}
