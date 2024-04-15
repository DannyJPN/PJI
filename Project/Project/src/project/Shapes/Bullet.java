/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Shapes;

import javafx.scene.paint.Paint;
import project.Interfaces.IDriftable;

/**
 *
 * @author Dan Krupa
 */
public class Bullet extends Oval implements IDriftable
{
    private double xspeed;
    private double yspeed;

    
    public Bullet() 
    {
        super();
    }    
    public Bullet(double width, double height,Paint fill) 
    {
        super(width,height,fill);
       
    }
    public Bullet(double centerXcoor, double centerYcoor,int zcoor) 
    {
        super(centerXcoor,centerYcoor,zcoor);
    }
    public Bullet(double centerXcoor, double centerYcoor,int zcoor, double width, double height) 
    {
        super(centerXcoor,centerYcoor,zcoor,width,height);
       
    }
    public Bullet(double centerXcoor, double centerYcoor,int zcoor, double width, double height,Paint fill) 
    {
        super(centerXcoor, centerYcoor,zcoor, width, height,fill);
        name = "Bullet"+index++;
        
       
    }
    
    
    @Override
    public void setVerticalSpeed(double yspeed)
    {
        this.yspeed=yspeed;
    }

    @Override
    public double getVerticalSpeed() 
    {
        return this.yspeed;
    }

    @Override
    public void setHorizontalSpeed(double xspeed) 
    {
        this.xspeed = xspeed;
    }

    @Override
    public double getHorizontalSpeed() 
    {
        return this.xspeed;
    }

    @Override
    public void move() 
    {
        //this.erase();
        this.setCenterPoint(this.getCenterX()+this.getHorizontalSpeed(),this.getCenterY()+this.getVerticalSpeed() );
        //this.draw();
    }
    
    
    
}
