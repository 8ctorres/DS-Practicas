/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2;

/**
 *
 * @author carlos.torres
 * @author d.s.vega
 */
public class Polymers {
  /**
  * Given a polymer represented with the letters of the alphabet ( uppercase
  * and lowercase excluding ~N), it processes the chain reactions of said
  * polymer ( due to adjoint units of the same type but different polarity ,
  * for example : aA ).
  * It returns the polymer without the reactive pairs (it can be an empty
  * string ) and it throws an IllegalArgumentException if the String passed
  * as parameter is null .
  */

  public static String processPolymer(String polymer) {
    if (polymer == null) throw new IllegalArgumentException();
    if (polymer == "") return "";
    StringBuilder poly = new StringBuilder(polymer);
    int i = 0;
    while (i < poly.length() - 1) {
      i = (i < 0)? 0 : i;  //If the previous elimination was at index [0,1]
      if (Math.abs((int) poly.charAt(i) - (int) poly.charAt(i + 1)) == 32) {
        poly.delete(i, i + 2);
        i--;
      } else
        i++;
    }
    return poly.toString();
  }

  /**
  * Given a polymer returns the monomer ( existing in the polymer ) whose
  * elimination ( both in its positive and negative form ) results , after the
  * consequent chain reactions , in the smallest polymer .
  * It returns the positive form ( lowercase ) of the monomer . In case of a
  * tie , the one with the lowest alphabetical order is returned .
  * An IllegalArgumentException is thrown if the original polymer is null or
  * if it is a empty string .
  */
  public static char minProcessedPolymer(String polymer) {
    if (polymer == null || "".equals(polymer))
      throw new IllegalArgumentException();

    boolean memory[] = new boolean[26];
    int minlength = polymer.length();
    int monoindex = 0;
    for (int i = 0; i < polymer.length(); i++) {
    //This section checks that the monomer to be evaluated hasn't been evaluated before.
        int lettertoindex = Character.toUpperCase(polymer.charAt(i)) - 65;
        if (memory[lettertoindex] == false) {
            memory[lettertoindex] = true;
    //This section eliminates the selected monomer from the polymer
            StringBuilder poly = new StringBuilder(polymer); //Mutable string
            for (int j = 0; j < poly.length(); j++) { 
                if (poly.charAt(j) == Character.toLowerCase(polymer.charAt(i)) || 
                        poly.charAt(j) == Character.toUpperCase(polymer.charAt(i))) {
                    //If the monomer is found:
                    poly = poly.deleteCharAt(j);
                    j--; 
                }
            }
    //The last section checks if the processed polymer without the monomer is the shortest so far
            int currentlength = processPolymer(poly.toString()).length();
            if (currentlength < minlength) {
                minlength = currentlength;
                monoindex = i;
            }
          }
      }
      return polymer.charAt(monoindex);
  };
}
