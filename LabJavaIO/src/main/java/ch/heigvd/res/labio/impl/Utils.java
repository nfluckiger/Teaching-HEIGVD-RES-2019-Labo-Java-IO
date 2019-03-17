package ch.heigvd.res.labio.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {
    String[] result = {"", ""};

    //Windows
    if(lines.contains("\r\n")){
      result[0] = lines.substring(0, lines.indexOf("\r\n") + 2);
      result[1] = lines.substring(lines.indexOf("\r\n") + 2);
    }
    //Linux
    else if(lines.contains("\n")){
      result[0] = lines.substring(0, lines.indexOf("\n") + 1);
      result[1] = lines.substring(lines.indexOf("\n") + 1);
    }
    //Mac
    else if(lines.contains("\r")){
      result[0] = lines.substring(0, lines.indexOf("\r") + 1);
      result[1] = lines.substring(lines.indexOf("\r") + 1);
    }
    //Undeffined
    else {
      result[1] = lines;
    }

    return  result;
  }

}
