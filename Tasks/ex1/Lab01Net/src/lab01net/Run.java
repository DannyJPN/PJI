/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class Run {

  public static void main(String[] args) throws InterruptedException {
    //new Rectangle(20, 200, 50, 50, MyColor.BRICKY);
    //new Triangle();
    //new Arc(30,30,150,150,MyColor.GOLDEN,Direction8.NORTH,290);
    
    new LeafTree(100,100,100,500,25,40,15,MyColor.GREEN,MyColor.BROWN);
  }

}
