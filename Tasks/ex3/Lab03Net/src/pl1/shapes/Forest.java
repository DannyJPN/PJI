/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl1.shapes;

import java.util.ArrayList;
import java.util.Random;
import pl1.canvas.Canvas;
import pl1.types.MyColor;
/**
 *
 * @author Dan Krupa
 */
public class Forest {
    
    private int width,height;
    private int x,y;
    private int count;
    private ArrayList <LeafTree> trees;
    private Rectangle surface;
    Random n = new Random();
    public Forest(int x,int y,int w,int h,int count,int one_tree_width,int one_tree_height) throws InterruptedException
    {
    this.x=x;
    this.y=y;
    width=w;
    height = h;
    this.count = count;
    surface = new Rectangle(this.x,this.y,width,height,Canvas.getInstance().getColorOfBackground());
    trees = new ArrayList<>();
    for(int i = 0;i<count;i++)
    {
        trees.add(new LeafTree(surface.getX()+n.nextInt(surface.getWidth()-one_tree_width),surface.getY()+n.nextInt(surface.getHeight()-one_tree_height),one_tree_width, one_tree_height, one_tree_width/6, one_tree_height/2, 20,MyColor.GREEN,MyColor.BROWN));
    }
    
    
    
    
    
    }
    public void erase()
    {
    surface.erase();
    for(int i = 0;i<count;i++)
        {
        trees.get(i).erase();
        }
    }
    
     public void paint()
    {
    surface.paint();
    for(int i = 0;i<count;i++)
        {
        trees.get(i).paint();
        }
    }
    
    
}
