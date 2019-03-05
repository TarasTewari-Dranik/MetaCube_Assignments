package extensibility.factory;

import java.util.List;
import java.awt.Point;
import java.awt.Polygon;
import java.sql.Timestamp;

public class PolygonShape implements Shape{
    private Point point;
    private int sideLength;
    private int sidesNumber;
    //Coordinates of the nod of the Polygon
    private int[] xPoints;
    private int[] yPoints;
    private Polygon myPolygon;
    private Timestamp timestamp;
    
    public PolygonShape (Point p, List<Integer> parameters) {
        int side = parameters.get(0);
        int sidesN = parameters.get(1);
        this.xPoints = new int[sidesNumber];
        this.yPoints = new int[sidesNumber];
        this.point = p;
        this.sideLength = side;
        this.sidesNumber = sidesN;
        xPoints[0] = (int) point.getX();
        yPoints[0] = (int) point.getY();
        int j = 1;
        for (int i=2; i<parameters.size();i++) {
            if (i%2 == 0) {
                xPoints[j] = parameters.get(i);
            } else {
                yPoints[j] = parameters.get(i);
                j = j+1;
            }
        }
        this.myPolygon = new Polygon(xPoints,yPoints,sidesNumber);
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public Timestamp getTime () {
        return timestamp;
    }
    
    public double getArea() {
        double apothem = sideLength/2/Math.tan(Math.PI/sidesNumber); // Calculates apothem of the Polygon.
        return apothem*getPerimeter()/2;
    }
    public double getPerimeter () {
        return sidesNumber*sideLength;
    }
    public double getOrigin () {
        return Math.sqrt(Math.pow(point.getX(),2)+Math.pow(point.getY(), 2));
    }
    public boolean isPointEnclosed(Point p) {
        return myPolygon.contains(p);
    }


}
