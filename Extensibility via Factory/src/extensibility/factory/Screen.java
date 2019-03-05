package extensibility.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.Point;

public class Screen {
    private List<Shape> listOfShapes;
    
    public Screen(List<Shape> shapesList) {
        this.listOfShapes = shapesList;
    }
    
    public void addShape (Shape newShape) {
         listOfShapes.add(newShape);
    }
    
    public void deletShape (Shape delShape) {
        listOfShapes.remove(delShape);
    }
    
    public int getSize() {
        return listOfShapes.size();
    }
    //Use collection sort to sort the shapes in the screen list
    public void sortByArea () {
        Collections.sort(listOfShapes, (a, b) -> {
            return Double.compare(a.getArea(),b.getArea());
        });
    }
    
    public void sortByPerimeter () {
        Collections.sort(listOfShapes, (a, b) -> {
            return Double.compare(a.getPerimeter(),b.getPerimeter());
        });
    }
    
    public void sortByTime () {
        Collections.sort(listOfShapes, (a, b) -> {
            return a.getTime().compareTo(b.getTime());
        });
    }
    
    public void sortByOrigin () {
        Collections.sort(listOfShapes, (a, b) -> {
            return Double.compare(a.getOrigin(),b.getOrigin());
        });
    }
    
    public List<Shape> enclosingPoint (Point p){
        List<Shape> enclose = new ArrayList<Shape> ();
        for (Shape item:listOfShapes) {
            if (item.isPointEnclosed(p)) {
                enclose.add(item);
            }
        }
        return enclose;
    }


}
