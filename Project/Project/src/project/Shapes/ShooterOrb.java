/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Shapes;

import javafx.scene.paint.Paint;

/**
 *
 * @author Dan Krupa
 */
public class ShooterOrb extends Oval 
{
    
    public ShooterOrb() 
    {
        super();
    }    
    public ShooterOrb(double width, double height,Paint fill) 
    {
        super(width,height,fill);
       
    }
    public ShooterOrb(double centerXcoor, double centerYcoor,int zcoor) 
    {
        super(centerXcoor,centerYcoor,zcoor);
    }
    public ShooterOrb(double centerXcoor, double centerYcoor,int zcoor, double width, double height) 
    {
        super(centerXcoor,centerYcoor,zcoor,width,height);
       
    }
    public ShooterOrb(double centerXcoor, double centerYcoor,int zcoor, double width, double height,Paint fill) 
    {
        super(centerXcoor, centerYcoor,zcoor, width, height,fill);
        name = "ShooterOrb"+index++;
        
       
    }
    
    
    
    
    
    
    public Bullet shoot()
    {
       return new Bullet(this.getCenterX(),this.getCenterY(),this.getZ(),this.getWidth(),this.getHeight(),this.getFill());
          
    
    }
    
    
}
