/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pj1.zt02;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public abstract class BalikSlov {

  Set<Character> vowels =
      new HashSet<>(Arrays.asList("a,e,i,o,u,ú,ů,ě,ý,á,í,é,y".split(","))
          .stream().map(s -> s.charAt(0)).collect(Collectors.toList()));

  public int vratPocetSouhlasek(String string) {
    int result = 0;
    string = string.toLowerCase();
    for (int i = 0; i < string.length(); i++) {
			if (Character.isLetter(string.charAt(i)) && !vowels.contains(string
				.charAt(i)))
			{
			  result++;
      }
    }
    return result;
  }

  abstract public Collection<String> vratSlova();
  
  public int zjistiPocetSlov()
  {
      Collection<String> words = vratSlova();
        return words.size();
  }
  public double spocitejPrumernouDelkuSlova()
  {
        
      Collection<String> words = vratSlova();
       int totallength=0;
       for(int i = 0;i<words.size();i++)
        {
            totallength += words.toArray()[i].toString().length();
        }
        
        
        
  
    return totallength/zjistiPocetSlov();
  }
  
  public void tiskniPoctySouhlasek()
  {
      Collection<String> words = vratSlova();
      Map<String,Integer> consonants = new HashMap<>();
       for(int i = 0;i<words.size();i++)
        {
           consonants.put(words.toArray()[i].toString(), vratPocetSouhlasek(words.toArray()[i].toString()));
           
        }
       Set set = consonants.entrySet();
       for(int i = 0;i<set.toArray().length;i++)
        {
            System.out.println(set.toArray()[i]);
          
        }
       
       
  }
  
  
  
  public Collection<String> vratSlovaPodleSouhlasek()
  {
  Collection<String> words = vratSlova();
      Map<Integer,String> consonants = new HashMap<>();
       for(int i = 0;i<words.size();i++)
        {
           consonants.put( vratPocetSouhlasek(words.toArray()[i].toString()),words.toArray()[i].toString());
           
        }
     
       Map<Integer,String> sorted = new TreeMap<>();
       return sorted.values();
  
  }
}
