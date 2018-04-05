
public class Point
{
    private int x; // x-coordinate
    private int y; // y-coordinate
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    //determine whether two points are the same
    public boolean equals(Object obj){
        Point point2=(Point) obj;
        if((point2.getX()==this.getX())&& (point2.getY()==this.getY()))
            return true;
        else return false;
    } 
  public Point() {  
      this.x = (int) ((Math.random() * 760) + 20);  
      this.y = (int) ((Math.random() * 760) + 20);
  }
}