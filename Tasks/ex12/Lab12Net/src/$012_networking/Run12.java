/*******************************************************************************
 * Kožusznik Jan
 * Copyright (c) 2014 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/

package $012_networking;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class Run12 {

  public static void main(String[] args) throws MalformedURLException, IOException {
    String orig = "https://www.boredpanda.com/best-wildlife-photos-from-national-geographic-traveler-photo-contest-2013";
      
      new ImageDownloader("https://www.reflex.cz/kategorie/2160/fotogalerie").doIt();
  }

}
