/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Interfaces;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Dan Krupa
 */
public interface IDrawable 
{
    
    public void setPaintContext(GraphicsContext g);
    public GraphicsContext getPaintContext();
    public void draw();
    public void erase();
    
    
}
