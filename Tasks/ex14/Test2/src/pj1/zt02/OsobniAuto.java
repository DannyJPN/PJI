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
public class OsobniAuto extends Auto implements TransportOsob
{

    private int pocetOsob;
    public OsobniAuto(String typ) {
        super(typ);
    }

    @Override
    public void jed() 
    {
         System.out.println(this.getTyp()+": jedu a vezu "+this.pocetOsob);
    
    }

    @Override
    public void transportuj() 
    {
        this.jed();
    }
    
}
