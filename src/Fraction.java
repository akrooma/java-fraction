import java.util.*;

/** This class represents fractions of form n/d where n and d are integer 
 * numbers. Basic operations and arithmetics for fractions are provided.
 */
public class Fraction implements Comparable<Fraction> {

   /** Main method. Different tests. */
   public static void main (String[] param) {
      // TODO!!! Your debugging tests here
   }

   // TODO!!! instance variables here

   /** Constructor.
    * @param a numerator
    * @param b denominator > 0
    */
   public Fraction (int a, int b) {
      // TODO!!!
   }

   /** Public method to access the numerator field. 
    * @return numerator
    */
   public int getNumerator() {
      return 0; // TODO!!!
   }

   /** Public method to access the denominator field. 
    * @return denominator
    */
   public int getDenominator() { 
      return 1; // TODO!!!
   }

   /** Conversion to string.
    * @return string representation of the fraction
    */
   @Override
   public String toString() {
      return ""; // TODO!!!
   }

   /** Equality test.
    * @param m second fraction
    * @return true if fractions this and m are equal
    */
   @Override
   public boolean equals (Object m) {
      return false; // TODO!!!
   }

   /** Hashcode has to be equal for equal fractions.
    * @return hashcode
    */
   @Override
   public int hashCode() {
      return 0; // TODO!!!
   }

   /** Sum of fractions.
    * @param m second addend
    * @return this+m
    */
   public Fraction plus (Fraction m) {
      return null; // TODO!!!
   }

   /** Multiplication of fractions.
    * @param m second factor
    * @return this*m
    */
   public Fraction times (Fraction m) {
      return null; // TODO!!!
   }

   /** Inverse of the fraction. n/d becomes d/n.
    * @return inverse of this fraction: 1/this
    */
   public Fraction inverse() throws ArithmeticException {
      return null; // TODO!!!
   }

   /** Opposite of the fraction. n/d becomes -n/d.
    * @return opposite of this fraction: -this
    */
   public Fraction opposite() {
      return null; // TODO!!!
   }

   /** Difference of fractions.
    * @param m subtrahend
    * @return this-m
    */
   public Fraction minus (Fraction m) {
      return null; // TODO!!!
   }

   /** Quotient of fractions.
    * @param m divisor
    * @return this/m
    */
   public Fraction divideBy (Fraction m) throws ArithmeticException {
      return null; // TODO!!!
   }

   /** Comparision of fractions.
    * @param m second fraction
    * @return -1 if this < m; 0 if this==m; 1 if this > m
    */
   @Override
   public int compareTo (Fraction m) {
      return 0; // TODO!!!
   }

   /** Clone of the fraction.
    * @return new fraction equal to this
    */
   @Override
   public Object clone() throws CloneNotSupportedException {
      return null; // TODO!!!
   }

   /** Integer part of the (improper) fraction. 
    * @return integer part of this fraction
    */
   public int integerPart() {
      return 0; // TODO!!!
   }

   /** Extract fraction part of the (improper) fraction
    * (a proper fraction without the integer part).
    * @return fraction part of this fraction
    */
   public Fraction fractionPart() {
      return null; // TODO!!!
   }

   /** Approximate value of the fraction.
    * @return numeric value of this fraction
    */
   public double toDouble() {
      return 0.; // TODO!!!
   }

   /** Double value f presented as a fraction with denominator d > 0.
    * @param f real number
    * @param d positive denominator for the result
    * @return f as an approximate fraction of form n/d
    */
   public static Fraction toFraction (double f, int d) {
      return null; // TODO!!!
   }

   /** Conversion from string to the fraction. Accepts strings of form
    * that is defined by the toString method.
    * @param s string form (as produced by toString) of the fraction
    * @return fraction represented by s
    */
   public static Fraction valueOf (String s) {
      return null; // TODO!!!
   }
}

