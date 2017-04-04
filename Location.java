import java.lang.Object;

public class Location implements Cloneable
{ 
   private double x; // The x coordinate of this Location
   private double y; // The y coordinate of this Location
   
   public Location(double xInitial, double yInitial)
      {
         x = xInitial;
         y = yInitial;
      }
   
   public Location clone( )
      {  // Clone a Location object.
         Location answer;
         
         try
         {
            answer = (Location) super.clone( );
         }
         catch (CloneNotSupportedException e)
         {  // This exception should not occur. But if it does, it would probably
            // indicate a programming error that made super.clone unavailable.
            // The most common error would be forgetting the "Implements Cloneable"
            // clause at the start of this class.
            throw new RuntimeException
               ("This class does not implement Cloneable.");
         }
         
         return answer;
      }
    
   public boolean equals(Object obj)
      {
         if (obj instanceof Location)
         {
            Location candidate = (Location) obj;
            return (candidate.x == x) && (candidate.y == y);
         }
         else
            return false;
      }
   public void rotate90( )
      {
         double xNew;
         double yNew;
         
         // For a 90 degree clockwise rotations, the new x is the original y
         // and the new y is -1 times the original x.
         xNew = y;
         yNew = -x;
         x = xNew;
         y = yNew;
      }
   public String toString( )
      {
          return "(x=" + x + "  y=" + y + ")";
      }
      
   public static double distance(Location p1, Location p2)
      {
         double a, b, c_squared;

         // Check whether one of the locations is null.
         if ((p1 == null)  ||  (p2 == null))
            return Double.NaN;
                  
         // Calculate differences in x and y coordinates.
         a = p1.x - p2.x;
         b = p1.y - p2.y;
         
         // Use Pythagorean Theorem to calculate the square of the distance.
         // between the locations.
         c_squared = a*a + b*b;
         
         return Math.sqrt(c_squared);
      }
   
      public static void main(String[] args) {
      final double STILL_X = -2.0;
      final double STILL_Y = -1.5;
      final int ROTATIONS = 2;
      
      Location still = new Location(STILL_X, STILL_Y);
      Location mobile = still.clone();
      printData(still, mobile);
      
      System.out.println("I will rotate one location by two 90-degree turns.");
      specifiedRotation(mobile,ROTATIONS);
      printData(still,mobile);
   }
   
   
   
   public static void specifiedRotation(Location p, int n)
   {
      while (n>0)
      {
         p.rotate90();
         n--;
      }
   }
   
   
   
   
   public static void printData(Location s, Location m)
   {
      System.out.println("The still location is at: " + s.toString());
      System.out.println("The mobile location is at: " + m.toString());
      System.out.println("Distance between them: " + Location.distance(s,m));
      if (s.equals(m))
         System.out.println("These two location have equal coordinates.");
      else
         System.out.println("These two location have differnt coordinates.");
   }
}