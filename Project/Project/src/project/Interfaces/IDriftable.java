/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Interfaces;

/**
 *
 * @author Dan Krupa
 */
public interface IDriftable 
{
 
    public void setVerticalSpeed(double yspeed);
    public double getVerticalSpeed();
    
    public void setHorizontalSpeed(double xspeed);
    public double getHorizontalSpeed();
    
   public void move();
}
