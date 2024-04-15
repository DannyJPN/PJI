/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl1.shapes;


import pl1.canvas.Canvas;
import pl1.types.MyColor;

/**
 *
 * @author Dan Krupa
 */
public class EllipseInRectangle
{
    private Ellipse yelellipse;
    private Rectangle bluerect;
    private int width,height,x,y;
    public EllipseInRectangle(int x,int y,int w,int h)
    {
        this.x=x;
        this.y=y;
        this.width = w;
        this.height = h;
        bluerect = new Rectangle(this.x,this.y,this.width,this.height,MyColor.BLUE);
        yelellipse = new Ellipse(this.x,this.y,this.width,this.height,MyColor.YELLOW);
        
        
        
    }
    public EllipseInRectangle(int x,int y)
    {
        this(x,y,50,50);
    }
    public EllipseInRectangle()
    {
        this(0,0);
    }
    
    public void Paint()
    {
        bluerect.paint();
        yelellipse.paint();
    }
    public void Erase()
    {
        bluerect.erase();
        yelellipse.erase();
    
    
    }
    
    public void SetPosition(int newx,int newy)
    {
       this.x = newx;
       this.y = newy;
       
        
        bluerect.setPosition(this.x, this.y);
        yelellipse.setPosition(this.x, this.y);
    }
    
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    
    
}
