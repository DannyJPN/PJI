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
public interface IAlterable {
    public void setWidth(double w);
    public void setHeight(double h);
    public void setLocation(double x,double y);
    public void setLocation(Point p);
    public void setSize(double w,double h);
    public void setSize(Point p);
    public double getWidth();
    public double getHeight();
    public double getX();
    public double getY();
    public Point getLocation();
    public Point getSize();
    public double getLeft();
    public double getRight();
    public double getTop();
    public double getBottom();

    
    
}
