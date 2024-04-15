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
public class Pair<T,V> 
{
    private T val1;
    private V val2;
   

    
    
    public void setVal1(T val)
    {
        val1=val;
    
    }
    public void setVal2(V val)
    {
        val2=val;
    
    }
    public T getVal1()
    {
        return val1;
    
    }
    public V getVal2()
    {
        return val2;
    
    }
            
}
