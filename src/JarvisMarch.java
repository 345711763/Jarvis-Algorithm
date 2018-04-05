import java.util.Iterator;  
import java.util.LinkedList;  
import java.util.List;  
  
public class JarvisMarch {  
    private int numberOfPoints;  
  
    public int getNumberOfPoints() {  
        return numberOfPoints;  
    }  
    private List<Point> hullVertices;  //all hull vertices
    private List<Integer> indexList;  //all hull vertices' index in the array " points"
    private PointFactory factory;  
    private Point[] points;  // all points
    private int indexOfLowestPoint; 
    public Point[] getPoints() {  
        return points;  
    }  
    public JarvisMarch(int numberOfPoints) {  
        factory = PointFactory.getInstance(numberOfPoints);  
        indexList = new LinkedList<Integer>(); 
        hullVertices = new LinkedList<Point>();  
        indexOfLowestPoint = factory.getIndexOfLowestPoint();  
        points = factory.getPoints();  
        addHullVertex(indexOfLowestPoint); 
    } 
 
    private void addHullVertex(int index) {  
        indexList.add(index);  
        hullVertices.add(points[index]);  
    }  
  
    public void calculateHullVertices() {  
        for (int i = getIndexOfNextHullPoint(indexOfLowestPoint); i != indexOfLowestPoint; i = getIndexOfNextHullPoint(i)) {  
            addHullVertex(i);  
        }    
    }  
    public int getIndexOfNextHullPoint(int currentIndex) {
        int delta;
        int minIndex=0;
        for(int i=0;i<points.length;i++)
        {
            if(i==currentIndex)
            {
                
            }
            if(i!=currentIndex)
            {
               if(minIndex==currentIndex)
                   minIndex=currentIndex+1;
               delta= (points[minIndex].getX()-points[currentIndex].getX())
                       *(points[i].getY()-points[currentIndex].getY())-(points[minIndex].getY()-points[currentIndex].getY())*
                       (points[i].getX()-points[currentIndex].getX());
               if(delta<0)
               {
                   minIndex=i;
               }
               if(delta==0)
               {
                   int distance1,distance2;
                   distance1=((points[currentIndex].getX()-points[minIndex].getX())^2)+((points[currentIndex].getY()-points[minIndex].getY())^2);
                   distance2=((points[currentIndex].getX()-points[i].getX())^2)+((points[currentIndex].getY()-points[i].getY())^2);
                   if(distance1<distance2)
                   {
                       minIndex=i;
                   }
               }
            }
        }
        return minIndex;
    }

    private void printHullVertices() {  
        Iterator<Point> pointIterator = hullVertices.iterator();  
        Iterator<Integer> indexIterator = indexList.iterator();  
        Point point;  
        int i;  
        int index = 0;  
        System.out.println("The hull points is: -> ");  
        while (pointIterator.hasNext()) {  
            i = indexIterator.next();  
            point = pointIterator.next();  
            System.out.print(i + ":(" + point.getX() + "," + point.getY() + ")  ");  
            index++;
        }  
        System.out.println();  
        System.out.println("****************************************************************");  
    }  
   
    public static void main(String[] args) {  
        JarvisMarch jarvis = new JarvisMarch(10);  
        Point[] points = jarvis.getPoints();  
        for(int i=0;i<points.length;i++)
        {       
            System.out.println("("+points[i].getX() + "," + points[i].getY() + ")"); 
        } 
        System.out.println("*****************************************************************");
        long start = System.currentTimeMillis();  
        jarvis.calculateHullVertices();
        jarvis.printHullVertices();
        System.out.println("The total running time is " + (System.currentTimeMillis() - start) + " millis.");  
    }  
}  