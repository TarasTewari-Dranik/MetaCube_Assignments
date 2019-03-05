package extensibility.factory;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ShapeClassTest {
    
    private static final double DELTA = 1e-15;
    
    @Test
    public void ShapeFactoryTest() {
        Point p = new Point(5,10);
        List<Integer> parameters = new ArrayList<Integer>();
        parameters.add(10);
        parameters.add(20);
        Shape newRectangle = new RectangleShape(p,parameters);
        ShapeFactory factory = new ShapeFactory ();
        assertEquals(newRectangle.getArea(), factory.createShape(ShapeType.RECTANGLE,p,parameters).getArea(),DELTA);
    }
    
    @Test
    public void getOriginTest() {
        Point p = new Point(5,10);
        List<Integer> parameters = new ArrayList<Integer>();
        parameters.add(10);
        parameters.add(20);
        Shape newRectangle = new RectangleShape(p,parameters);
        ShapeFactory factory = new ShapeFactory ();
        assertEquals(newRectangle.getOrigin(), factory.createShape(ShapeType.RECTANGLE,p,parameters).getOrigin(),DELTA);
    }
    
    @Test
    public void screenTest() {
        Point p = new Point(5,10);
        List<Integer> parameters = new ArrayList<Integer>();
        parameters.add(10);
        parameters.add(20);
        List<Shape> allShapes = new ArrayList<Shape>();
        ShapeFactory factory = new ShapeFactory ();
        for (int i=0; i<5;i++) {
            allShapes.add(factory.createShape(ShapeType.RECTANGLE,p,parameters));
        }
        Screen drawShapes = new Screen(allShapes);
        Shape newRectangle = new RectangleShape(p,parameters);
        drawShapes.addShape(newRectangle);
        drawShapes.deletShape(newRectangle);
        int result = 5;
        assertEquals(result, drawShapes.getSize());
    }
    

}
