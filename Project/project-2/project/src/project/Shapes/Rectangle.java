/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Stanislav
 */
public class Rectangle extends javafx.scene.shape.Rectangle 
{
    static int index =0;
    String name;
    int z_index;

    public Rectangle(double xcoor, double ycoor,int zcoor, double width, double height) 
    {
        super(xcoor, ycoor, width, height);
        z_index=zcoor;
        name = "Rect"+index++;
     
       
    }

    public int getZ()
    {
       return z_index;
    }
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
    
    
    public void Draw(GraphicsContext gc)
    {
        gc.setFill(this.getFill());
        gc.setStroke(this.getStroke());
        gc.fillRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
    public void Erase(GraphicsContext gc)
    {
        gc.clearRect(this.getX(),this.getY(),this.getWidth(),this.getHeight());
    }
    
  
    
    
    
}
