package extensibility.factory;
import java.awt.Point;
import java.sql.Timestamp;

public interface Shape {

    public double getArea();
    public double getPerimeter ();
  //Calculates the distance between 0,0 coordinate and point of origin of the Shape
    public double getOrigin ();
    public boolean isPointEnclosed(Point p);
    public Timestamp getTime ();
    
}
