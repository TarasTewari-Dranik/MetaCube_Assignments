package extensibility.factory;

import java.util.List;
import java.awt.Point;
import java.awt.Polygon;
import java.sql.Timestamp;

public class TriangleShape implements Shape{
    private Point point;
    private int sideA;
    private int sideB;
    private int sideC;
    private int[] xPoints;
    private int[] yPoints;
    private int numberPoints;
    private Timestamp timestamp;
    private Polygon myTriangle;
    
    public TriangleShape(Point p, List<Integer> parameters) {
        int a = parameters.get(0);
        int b = parameters.get(1);
        int c = parameters.get(2);
        int n = 3;
        this.numberPoints = n;
        this.point = p;
        this.sideA = a;
        this.sideB = b;
        this.sideC = c;
        //Coordinates of the nod of the Triangle 
        this.xPoints = new int[]{(int) p.getX(),parameters.get(3),parameters.get(5)};
        this.yPoints = new int[]{(int) p.getY(),parameters.get(4),parameters.get(6)};
        this.myTriangle = new Polygon(xPoints,yPoints,numberPoints);
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
    
    public double getArea() {
        double halfParameter = getPerimeter()/2;
        return Math.sqrt((halfParameter*(halfParameter - sideA)*(halfParameter - sideB)*(halfParameter - sideC)));
    }
    public double getPerimeter () {
        return sideA+sideB+sideC;
    }
    public double getOrigin () {
        return Math.sqrt(Math.pow(point.getX(),2)+Math.pow(point.getY(), 2));
    }
    
    public Timestamp getTime () {
        return timestamp;
    }
    

    public boolean isPointEnclosed(Point p) {
        return myTriangle.contains(p);
    }


}
