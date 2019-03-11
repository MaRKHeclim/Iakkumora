package Tools;

//import java.lang.Math;

public class MathFunctions
{
    public static double getDistance(double x1, double y1, double x2, double y2) //Euclidian distance
    {
        return Math.hypot(x2 - x1, y2 - y1);
    }
    
    public static double getManhattanDistance(double x1, double y1, double x2, double y2)
    {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
    
    public static double getMinkowskiDistance(double x1, double y1, double x2, double y2, double p)
    {
        return Math.pow(Math.pow(x2 - x1, p) + Math.pow(y2 - y1, p), 1 / p);
    }
    
    public static int fastfloor(double x)
    {
        return x > 0 ? (int)x : (int)x - 1;
    }
    
    public static int fastceil(double x)
    {
        return x > 0 ? (int)x + 1 : (int)x;
    }
    
    public static double getAngleDegInt(int m1x, int m1y, int m2x, int m2y){
        //double degrees =  Math.toDegrees(Math.atan2(m1y - m2y, m2x - m1x ));
        return Math.toDegrees(Math.atan2(m1y - m2y, m2x - m1x ));
    }
    
    public static double getAngleRad(double m1x, double m1y, double m2x, double m2y){
        //double degrees =  (Math.atan2(m1y - m2y, m2x - m1x ));
        return (Math.atan2(m1y - m2y, m2x - m1x ));
    }
    
    public static double scale(double x, double fromMin, double fromMax, double toMin, double toMax)
    {
        return (x - fromMin) / (fromMax - fromMin) * (toMax - toMin) + toMin;
    }
}
