package extensibility.factory;

import java.util.List;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.sql.Timestamp;

public class CircleShape implements Shape{
    private Point point;
    private double radius;
    private Ellipse2D.Double myEllipse;
    private Timestamp timestamp;
    
    public CircleShape (Point p,List<Integer> parameters) {
        double radiusCircle = parameters.get(0);
        double correction = Math.sqrt(Math.pow(radiusCircle, 2)-radiusCircle/2); //Distance from the point on the circle (where task assume to draw the circle) to the point where shape starts
        this.point = p;
        this.radius = radiusCircle;
        this.myEllipse = new Ellipse2D.Double (p.getX()-correction,p.getY()-correction,2*radius,2*radius);
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }
    public double getPerimeter () {
        return 2*Math.PI*radius;
    }
    
    public Timestamp getTime () {
        return timestamp;
    }
    public double getOrigin () {
        return Math.sqrt(Math.pow(point.getX(),2)+Math.pow(point.getY(), 2));
    }
    
    public boolean isPointEnclosed(Point p) {
        return myEllipse.contains(p);
    }

}
