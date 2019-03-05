package extensibility.factory;

import java.util.List;
import java.awt.Point;

public class ShapeFactory {
    public static Shape createShape (ShapeType shape, Point p, List<Integer> parameters) {
        if (shape == null) {
            return null;
        }
        if (shape == ShapeType.SQUARE) {
            return new SquareShape (p,parameters);
        } else if (shape == ShapeType.RECTANGLE) {
            return new RectangleShape (p,parameters);
        } else if (shape == ShapeType.CIRCLE) {
            return new CircleShape (p,parameters);
        } else if (shape == ShapeType.TRIANGLE) {
            return new TriangleShape (p,parameters);
        } else if (shape == ShapeType.POLYGON) {
            return new PolygonShape (p,parameters);
        }
        
        return null;
    }

}
