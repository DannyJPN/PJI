/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.kozusznik.pl1.lab08;

/**
 *
 * @author Stanislav
 */
public class Test<T> {
   private T var;
 
   public T get(){
      return this.var;
   }
 
   public void set(T t){
      this.var=t;
      System.out.println("var="+var+";");
      System.out.println("var is "+var.getClass()+";");
   }
 
   public static void main(String args[]){
 
      Test<String> type = new Test<String>();
      type.set("Text");
      //type.set(10);
 
      Test type1 = new Test(); //raw type
      type1.set("Text"); //valid
      type1.set(10); //valid and autoboxing support
   }
}