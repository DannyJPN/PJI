/*******************************************************************************
 * Kožusznik Jan
 * Copyright (c) 2014 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/

package $012_networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class ImageDownloader {
  private URL url;

  /**
   * @param url
   * @throws MalformedURLException
   */
  public ImageDownloader(String url) throws MalformedURLException 
  {
        this.url = new URL(url);
  }

  public void doIt() throws IOException
  {
      URLConnection con = this.url.openConnection();
      
      
      
      Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(con.getInputStream())));
      String img="";
      Pattern p = Pattern.compile("<img\\s.*src\\s*=\\s*\"([^\"]*)\".*>");
      while(sc.findWithinHorizon(p, 0)!=null)
      {
          String line = sc.match().group(1);
          if(!line.isEmpty())
          {
              URL file = new URL( line  );
              String fn =line.substring(line.lastIndexOf("/")+1);
              Path target = FileSystems.getDefault().getPath("c:/Users/Dan Krupa/Dropbox/UNI", fn);
               System.out.println(target.toAbsolutePath().toString());
              
              Files.copy(file.openStream(),target,StandardCopyOption.REPLACE_EXISTING);
              
              
          }
          
      }
      
      sc.close();
  }
}
