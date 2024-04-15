/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13net;

/**
 *
 * @author Dan Krupa
 */
public class Num<T extends Number>
{
    private T number;
    public Num(T value)
    {
        number=value;
    
    }
    public T GetValue()
    {
      return number;
        
    }
    public void SetValue(T num)
    {
        number=num;
    
    }
    @Override
    public String toString()
    {
        return "Value "+number.toString()+" is type of " + number.getClass();
    
    
    }                                                                           

}