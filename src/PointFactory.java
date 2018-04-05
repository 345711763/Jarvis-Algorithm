
public class PointFactory
{
    private Point[] points=null;
    private int newIndex;
    private int indexOfLowestPoint=0;
    public static PointFactory getInstance(int numberOfPoints) {  
        return new PointFactory(numberOfPoints);  
    }  
    public Point[] getPoints(){
        return points;
    }
    public int getIndexOfLowestPoint(){
        return indexOfLowestPoint;
    }
    private PointFactory(int numberOfPoints) {  
        points = new Point[numberOfPoints];  
        for (int i = 0; i < numberOfPoints; i++) {  
            points[i] = new Point();  
            newIndex = i;  
            checkNoSamePoints();  
        }  
        indexOfLowestPoint = getLowestPoint();  
    }  
    //to prove that randomly generated points are all different , if some points are the same ,they will be re-randomly generated.
    private void checkNoSamePoints() {  
        for(int i = 0; i < newIndex; i++) {  
                if(points[i].equals(points[newIndex])) {  
                    points[newIndex] = new Point();  
                    checkNoSamePoints();  
                }  
            }  
    }  
    
    public int getLowestPoint() {  
        int minIndex = 0;  
        for (int i = 1; i < points.length; i++) {  
            if (points[i].getY() < points[minIndex].getY()) {  
                minIndex = i;  
            } else if ((points[i].getY() == points[minIndex].getY())  
                    && (points[i].getX() < points[minIndex].getX())) {  
                minIndex = i;  
            }  
        }  
        return minIndex;  
    }  
  
}  
