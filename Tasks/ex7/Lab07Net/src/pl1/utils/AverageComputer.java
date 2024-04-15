/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl1.utils;

import java.util.ArrayList;
import pl1.shapes.manager.IEvaluable;

/**
 *
 * @author Dan Krupa
 */
public class AverageComputer 
{
    public double Average(ArrayList<IEvaluable> shapelist)
    {
        double sum=0;
        for(int i = 0;i<shapelist.size();i++)
        {
            sum+=shapelist.get(i).calcArea();
        }
        System.out.println(sum/shapelist.size());
        return sum/shapelist.size();
    }
}
