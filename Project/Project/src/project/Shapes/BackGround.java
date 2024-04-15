/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import project.Interfaces.IVisuallyChangable;

/**
 *
 * @author Dan Krupa
 */
public class BackGround extends Rectangle implements IVisuallyChangable
{
     private static final double DefaultXcoor = 0;
    private static final double DefaultYcoor = 0;
    private static final int DefaultZcoor = 0;
    private static final double DefaultWidth = 1000;
    private static final double DefaultHeight = 1000;
    private static final Color DefaultColor = Color.WHITESMOKE;
    
    
    
    
    private static int index =0;
    private String name;
    private int z_index;
    private GraphicsContext gc;
   
    public BackGround() 
    {
        this(DefaultXcoor,DefaultYcoor,DefaultZcoor,DefaultWidth,DefaultHeight,DefaultColor);
       
    }    
    public BackGround(double width, double height,Paint fill) 
    {
        this(DefaultXcoor,DefaultYcoor,DefaultZcoor,width,height,fill);
       
    }
    public BackGround(double xcoor, double ycoor,int zcoor) 
    {
        this(xcoor,ycoor,zcoor,DefaultWidth,DefaultHeight,DefaultColor);
       
    }
    public BackGround(double xcoor, double ycoor,int zcoor, double width, double height) 
    {
        this(xcoor,ycoor,zcoor,width,height,DefaultColor);
       
    }
    public BackGround(double xcoor, double ycoor,int zcoor, double width, double height,Paint fill) 
    {
        super(xcoor, ycoor, width, height);
        z_index=zcoor;
        name = "BackGround"+index++;
        this.setFill(fill);
       
    }

    @Override
    public GraphicsContext getPaintContext()
    {
        return gc;
    }
    @Override
    public void setPaintContext(GraphicsContext g)
    {
        gc=g;
    }
    
    
    @Override
    public int getZ()
    {
       return z_index;
    }
    @Override
    public void setZ(int z)
    {
       z_index=z;
    }
     public String getName()
    {
       return name;
    }
    public void setName(String n)
    {
       name=n;
    }
    
    
    @Override
    public void draw()
    {
        gc.setFill(this.getFill());
        gc.setStroke(Color.YELLOW);
        gc.fillRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
        gc.strokeRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
    @Override
    public void erase()
    {
        gc.clearRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
    
    
    
    @Override
    public void setLocation(double x,double y)
    {
        //this.erase();
        this.setX(x);
        this.setY(y);
        //this.draw();
    }
    @Override
    public void setLocation(Point  p)
    {
        this.setLocation(p.getX(), p.getY());
    }
    
    
    public double getLeft()
    {
        return this.getX();
    }
    public double getRight()
    {
        return this.getX()+this.getWidth();
    }
    public double getTop()
    {
        return this.getY();
    }
    public double getBottom()
    {
        return this.getY()+this.getHeight();
    }

    @Override
    public void setSize(double w, double h) 
    {
        //this.erase();
        this.setWidth(w);
        this.setHeight(h);
        //this.draw();
    }

    @Override
    public void setSize(Point p) 
    {
        this.setSize(p.getX(), p.getY());
    }

    @Override
    public Point getLocation() 
    {
        return new Point(this.getX(),this.getY());
    }

    @Override
    public Point getSize() 
    {
        return new Point(this.getWidth(),this.getHeight());
    }
   
}
