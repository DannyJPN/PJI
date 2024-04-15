/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pj1.zt02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class BalikSlovZeSouboru extends BalikSlov {

  private String fileName;
private ArrayList<String> words;
  /**
   * @param fileName
   */
  public BalikSlovZeSouboru(String fileName) throws FileNotFoundException {
    super();
    this.fileName = fileName;
    
   Scanner scnum = new Scanner(new BufferedReader(new FileReader(fileName)));
   ArrayList<String> words = new ArrayList<>();
    Pattern p = Pattern.compile("[\\p{Punct}\\s]+");
    while(scnum.findWithinHorizon(p, 0)!=null)
    {
        words.add(scnum.match().group());
    
    }
              
    this.words=words;
    
  }

  @Override
  public Collection<String> vratSlova() {
    
    return this.words;
  }

}
