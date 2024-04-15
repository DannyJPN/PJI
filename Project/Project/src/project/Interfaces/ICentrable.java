/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Interfaces;

import project.Shapes.Point;

/**
 *
 * @author Dan Krupa
 */
public interface ICentrable 
{
    public double getCenterX();
    public double getCenterY();
    public Point getCenterPoint();
    public void setCenterX(double cx);
    public void setCenterY(double cy);
    public void setCenterPoint(double cx,double cy);
    public void setCenterPoint(Point p);
    
    
}
