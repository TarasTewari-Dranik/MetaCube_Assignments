package extensibility.factory;

import java.util.List;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Point;
import java.sql.Timestamp;

public class RectangleShape implements Shape{
    private Point point;
    private int width;
    private int height;
    private Rectangle myRectangle;
    private Timestamp timestamp;
    
    public RectangleShape (Point p,List<Integer> parameters) {
        int widthRectangle = parameters.get(0);
        int heightRectangle = parameters.get(1);
        this.point = p;
        this.width = widthRectangle;
        this.height = heightRectangle;
        this.myRectangle  = new Rectangle(point,new Dimension (width,height));
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public double getArea() {
        return width*height;
    }
    public double getPerimeter () {
        return 2*(width+height);
    }
    
    public Timestamp getTime () {
        return timestamp;
    }
    
    public double getOrigin () {
        return Math.sqrt(Math.pow(point.getX(),2)+Math.pow(point.getY(), 2));
    }
    public boolean isPointEnclosed(Point enclosedPoint) {
        return myRectangle.contains(enclosedPoint);
    }

}
