/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj1.zt02;

/**
 *
 * @author Dan Krupa
 */
public class NakladniAuto extends Auto
{

    private double hmotnostNakladu;
    public NakladniAuto(String typ) {
        super(typ);
    }

    @Override
    public void jed() 
    {
        System.out.println(this.getTyp()+": jedu a vezu naklad o hmotnosti "+this.hmotnostNakladu/1000);
    }
    
}
