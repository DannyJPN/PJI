/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Shapes;

/**
 *
 * @author Dan Krupa
 */
public class Point {
    private double x;
    private double y;
    
    public Point(double xcoor,double ycoor)
    {
        x=xcoor;
        y=ycoor;
    }

    public Point() 
    {
        this(0,0);
    }
    
    public double getX()
    {
        return x;
    }
    public void setX(double newx)
    {
        x=newx;
    }
    
    public double getY()
    {
        return y;
    }
    public void setY(double newy)
    {
        y=newy;
    }
    
}
