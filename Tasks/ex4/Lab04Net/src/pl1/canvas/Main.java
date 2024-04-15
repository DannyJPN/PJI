/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pl1.canvas;

import java.util.Random;
import pl1.shapes.*;
import pl1.types.Direction8;
import pl1.types.MyColor;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class Main {

  public static void main(String[] args) throws InterruptedException {
    Canvas.getInstance();
   Ball b = new Ball(123,50,120,MyColor.BLUE,Direction8.SOUTHWEST);
   Ball b2 = new Ball(200,60,80,MyColor.GREEN,Direction8.SOUTHEAST);
   
   for(int i = 0;i<new Random().nextInt(500)+100;i++)
   {

   b.Move(5);
   b2.Move(10);
  
 Thread.sleep(100);

   
   }
   
   
   
  }

}
