/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;
import project.Interfaces.ICentrable;
import project.Interfaces.IVisuallyChangable;

/**
 *
 * @author Dan Krupa
 */
public class Oval extends Ellipse implements IVisuallyChangable,ICentrable
{
    private static final double DefaultXcoor = 0;
    private static final double DefaultYcoor = 0;
    private static final int DefaultZcoor = 0;
    private static final double DefaultWidth = 0;
    private static final double DefaultHeight = 0;
    private static final Color DefaultColor = Color.WHITE;
    
    
    
    
    protected static int index =0;
    protected String name;
    protected int z_index;
    protected GraphicsContext gc;
   
    public Oval() 
    {
        this(DefaultXcoor,DefaultYcoor,DefaultZcoor,DefaultWidth,DefaultHeight,DefaultColor);
       
    }    
    public Oval(double width, double height,Paint fill) 
    {
        this(DefaultXcoor,DefaultYcoor,DefaultZcoor,width,height,fill);
       
    }
    public Oval(double centerXcoor, double centerYcoor,int zcoor) 
    {
        this(centerXcoor,centerYcoor,zcoor,DefaultWidth,DefaultHeight,DefaultColor);
       
    }
    public Oval(double centerXcoor, double centerYcoor,int zcoor, double width, double height) 
    {
        this(centerXcoor,centerYcoor,zcoor,width,height,DefaultColor);
       
    }
    public Oval(double centerXcoor, double centerYcoor,int zcoor, double width, double height,Paint fill) 
    {
        super(centerXcoor, centerYcoor, width, height);
        z_index=zcoor;
        name = "Oval"+index++;
        this.setFill(fill);
       
    }

    

    @Override
    public void setLocation(double x, double y) 
    {
        this.setCenterX(x+this.getWidth()/2);
        this.setCenterY(y+this.getHeight()/2);
    }

    @Override
    public void setLocation(Point p) 
    {
        this.setLocation(p.getX()+this.getWidth()/2,p.getY()+this.getHeight()/2);
    }

    @Override
    public void setSize(double w, double h) 
    {
        this.setWidth(w);
        this.setHeight(h);
    }

    @Override
    public void setSize(Point p) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getWidth() 
    {
        return this.getRadiusX();
    }

    @Override
    public double getHeight() 
    {
        return this.getRadiusY();
    }

    @Override
    public double getX() 
    {
        return this.getCenterX()-this.getWidth()/2;
    }

    @Override
    public double getY() 
    {
        return this.getCenterY()-this.getHeight()/2;
    }

    @Override
    public Point getLocation() 
    {
        return new Point(getX(),getY());
    }

    @Override
    public Point getSize() {
        return new Point(getHeight(),getWidth());
    }

    @Override
    public void setPaintContext(GraphicsContext g) 
    {
        this.gc = g;
       
    }

    @Override
    public GraphicsContext getPaintContext() 
    {
        return gc;
    }

    @Override
    public void draw() 
    {
        gc.setFill(this.getFill());
        gc.setStroke(Color.ORANGE);
        gc.fillOval(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }

    @Override
    public void erase()
    {
        gc.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void setZ(int zcoor) 
    {
        this.z_index=zcoor;
    }

    @Override
    public int getZ() 
    {
        return this.z_index;
    }

    @Override
    public void setWidth(double w) 
    {
        this.setRadiusX(w);
    }

    @Override
    public void setHeight(double h) 
    {
        this.setRadiusY(h);
    }

    @Override
    public Point getCenterPoint() 
    {
         return new Point(this.getCenterX(),this.getCenterY());
    }

    @Override
    public void setCenterPoint(double cx, double cy) 
    {
        this.setCenterX(cx);
        this.setCenterY(cy);
        
    }

    @Override
    public void setCenterPoint(Point p) 
    {
        this.setCenterPoint(p.getX(), p.getY());
    }

    @Override
    public double getLeft()
    {
        return this.getX();
    }
    @Override
    public double getRight()
    {
        return this.getX()+this.getWidth();
    }
    @Override
    public double getTop()
    {
        return this.getY();
    }
    @Override
    public double getBottom()
    {
        return this.getY()+this.getHeight();
    }

    
}
