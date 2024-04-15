/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Passive;

import java.util.Random;
import javafx.scene.paint.Color;

/**
 *
 * @author Dan Krupa
 */
public class ColorGenerator 
{
    Color [] baseset;
    public ColorGenerator(Color... set)
    {
        baseset=set;
    }
    public Color getRandomColor()
    {
            Random n = new Random();
            
          return baseset[n.nextInt(baseset.length)];  
            
    }
}
