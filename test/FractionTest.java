import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/** Testklass.
 * @author Jaanus
 */
public class FractionTest {

   @Test (timeout=1000)
   public void testPlus() { 
      Fraction f1 = new Fraction (2, 5);
      Fraction f2 = new Fraction (4, 15);
      Fraction sum = f1.plus(f2);
      assertEquals ("Wrong sum: <" + f1 + "> + <" + f2 + ">", 
         new Fraction (2, 3), sum);
      Fraction sm2 = sum.plus (sum);
      assertEquals ("Wrong sum.plus(sum): <2/3> + <2/3>",
         new Fraction (4, 3), sm2);
      assertEquals ("Do not change the arguments of the sum", 
         new Fraction (2, 3), sum);
      f1 = new Fraction (-1, 250);
      f2 = new Fraction (-1, 375);
      sum = f1.plus(f2);
      assertEquals ("Wrong sum: <" + f1 + "> + <" + f2 + ">",
         new Fraction (-1, 150), sum);
      f1 = new Fraction (1, 221);
      f2 = new Fraction (1, 323);
      sum = f1.plus (f2);
      assertEquals ("Wrong sum: <" + f1 + "> + <" + f2 + ">",
         new Fraction (32, 4199), sum);
      f1 = new Fraction (1, 39203);
      f2 = new Fraction (1, 41989);
      sum = f1.plus (f2);
      assertEquals ("Wrong sum: <" + f1 + "> + <" + f2 + ">",
         new Fraction (408, 8271833), sum);
      f1 = new Fraction (-2, 5);
      f2 = new Fraction (2, 5);
      sum = f1.plus(f2);
      assertEquals ("Wrong sum: <" + f1 + "> + <" + f2 + ">",
         new Fraction (0, 1), sum);
   }

   @Test (timeout=1000)
   public void testTimes() {
      Fraction f1 = new Fraction (2, 5);
      Fraction f2 = new Fraction (4, 15);
      Fraction prd = f1.times (f2);
      assertEquals ("Wrong product: <" + f1 + "> * <" + f2 + ">",
         new Fraction (8, 75), prd);
      f1 = new Fraction (-3, 5);
      f2 = new Fraction (-5, 7);
      prd = f1.times (f2);
      assertEquals ("Wrong product: <" + f1 + "> * <" + f2 + ">",
         new Fraction (3, 7), prd);
      Fraction pr2 = prd.times (prd);
      assertEquals ("Wrong prd.times(prd): <3/7> * <3/7>",
         new Fraction (9, 49), pr2);
      assertEquals ("Do not change the arguments of the product",
         new Fraction (3, 7), prd);
      f1 = new Fraction (0, 1);
      f2 = new Fraction (2, 3);
      prd = f1.times (f2);
      assertEquals ("Wrong product: <" + f1 + "> * <" + f2 + ">",
         new Fraction (0, 1), prd);
      f1 = new Fraction (3, 2);
      f2 = new Fraction (2, 3);
      prd = f1.times (f2);
      assertEquals ("Wrong product: <" + f1 + "> * <" + f2 + ">",
         new Fraction (1, 1), prd);
      f1 = new Fraction (3, 5);
      f2 = new Fraction (5, 7);
      prd = f1.times (f2);
      assertTrue ("Result must be reduced: 3/5 * 5/7 -> 3/7",
         prd.getDenominator()==7);
   } 

   @Test (expected=RuntimeException.class)
   public void testCreateZeroDenominator() {
      Fraction f = new Fraction (1, 0);
   }

   @Test (expected=RuntimeException.class)
   public void testZeroInverse() {
      Fraction f = new Fraction (0, 1);
      f.inverse();
   }

   @Test (timeout=1000)
   public void testClone() {
      Fraction f1 = new Fraction (2, 5);
      Fraction f2 = null;
      try {
         f2 = (Fraction)f1.clone();
      } catch (CloneNotSupportedException e) {};
      assertNotSame ("clone must differ from original", f2, f1);
      assertEquals ("clone must be equal to original", f1, f2);
      f1 = f2.plus(f1);
      assertEquals ("clone must be independent from original",
         new Fraction (2, 5), f2);
   }

   @Test (timeout=1000)
   public void testToString() {
      String s = new Fraction (1, 4).toString();
      assertTrue (s + " must represent quarter", 
         (s.indexOf('1') < s.indexOf('4')) && (s.indexOf('1') >= 0));
      s = new Fraction (-1, 5).toString();
      assertTrue (s + " does not contain minus", s.indexOf('-') >= 0);
   } 

   @Test (expected=RuntimeException.class)
   public void testDivideByZero() {
      Fraction f1 = new Fraction (1, 5);
      Fraction f2 = new Fraction (0, 1);
      Fraction q = f1.divideBy (f2);
   }

   @Test (timeout=1000)
   public void testMinus() {
      Fraction f1 = new Fraction (2, 5);
      Fraction f2 = new Fraction (4, 15);
      Fraction dif = f1.minus (f2);
      assertEquals ("Wrong difference: <" + f1 + "> - <" + f2 + ">", 
         new Fraction (2, 15), dif);
      Fraction df2 = dif.minus (dif);
      assertEquals ("Wrong difference: <2/15> - <2/15>",
         new Fraction (0, 1), df2);
      assertEquals ("Do not change the arguments of the difference", 
         new Fraction (2, 15), dif);
      f1 = new Fraction (-2, 5);
      f2 = new Fraction (-4, 15);
      dif = f1.minus (f2);
      assertEquals ("Wrong difference: <" + f1 + "> - <" + f2 + ">",
         new Fraction (-2, 15), dif);
   }

   @Test (timeout=1000)
   public void testDivideBy() {
      Fraction f1 = new Fraction (-2, 7);
      Fraction f2 = new Fraction (-1, 14);
      Fraction f = f1.divideBy (f2);
      assertEquals ("Wrong quotient: <" + f1 + "> / <" + f2 + ">",
         new Fraction (4, 1), f);
      f = f2.divideBy (f1);
      assertEquals ("Wrong quotient: <" + f1 + "> / <" + f2 + ">",
         new Fraction (1, 4), f);
      Fraction f3 = f.divideBy (f);
      assertEquals (f.toString() + " divided by itself", 
         new Fraction (1, 1), f3);
      assertEquals ("Do not change the arguments of the quotient",
         new Fraction (1, 4), f);
   }

   @Test (timeout=1000)
   public void testOpposite() {
      Fraction f1 = new Fraction (1, 6);
      Fraction f2 = f1.opposite();
      assertEquals ("Wrong opposite", new Fraction (-1, 6), f2);
      assertEquals ("Do not change the argument of opposite",
         new Fraction (1, 6), f1);
      f1 = new Fraction (-4, 75);
      f2 = f1.opposite();
      assertEquals ("Wrong opposite", new Fraction (4, 75), f2);
      f1 = new Fraction (0, 1);
      f2 = f1.opposite();
      assertEquals ("zero must be neutral to opposite", f1, f2);
   }

   @Test (timeout=1000)
   public void testInverse() {
      Fraction f1 = new Fraction (2, 3);
      Fraction f2 = f1.inverse();
      assertEquals ("Wrong inverse ", new Fraction (3, 2), f2);
      assertEquals ("Do not change the argument of inverse",
         new Fraction (2, 3), f1);
      f1 = new Fraction (-4, 75);
      f2 = f1.inverse();
      assertEquals ("Wrong inverse", new Fraction (-75, 4), f2);
      assertTrue ("Denominator must always be positive", 
         f2.getDenominator() > 0);
      f1 = new Fraction (1, 1);
      f2 = f1.inverse();
      assertEquals ("1 must be neutral to inverse", f1, f2);
   }

   @Test (timeout=1000)
   public void testGetters() {
      Fraction f1 = new Fraction (2, 3);
      int num = f1.getNumerator();
      assertEquals ("wrong numerator ", 2, num);
      f1 = new Fraction (-4, 75);
      num = f1.getNumerator();
      assertEquals ("Wrong numerator", -4, num);
      f1 = new Fraction (0, 7);
      num = f1.getNumerator();
      assertEquals ("Wrong numerator", 0, num);
      f1 = new Fraction (2, 3);
      int den = f1.getDenominator();
      assertEquals ("wrong denominator ", 3, den);
      f1 = new Fraction (-4, 75);
      den = f1.getDenominator();
      assertEquals ("Wrong denominator", 75, den);
   }

   @Test (timeout=1000)
   public void testIntegerPart() {
      Fraction f1 = new Fraction (2, 3);
      int i = f1.integerPart();
      assertEquals ("wrong integer part ", 0, i);
      f1 = new Fraction (3, 2);
      i = f1.integerPart();
      assertEquals ("wrong integer part ", 1, i);
      f1 = new Fraction (32, 3);
      i = f1.integerPart();
      assertEquals ("wrong integer part ", 10, i);
      f1 = new Fraction (33, 3);
      i = f1.integerPart();
      assertEquals ("wrong integer part ", 11, i);
      f1 = new Fraction (-33, 3);
      i = f1.integerPart();
      assertEquals ("wrong integer part ", -11, i);
   }

   @Test (timeout=1000)
   public void testFractionPart() {
      Fraction f1 = new Fraction (2, 3);
      Fraction i = f1.fractionPart();
      assertEquals ("wrong fraction part ", new Fraction (2, 3), i);
      f1 = new Fraction (3, 2);
      i = f1.fractionPart();
      assertEquals ("wrong fraction part ", new Fraction (1, 2), i);
      f1 = new Fraction (32, 3);
      i = f1.fractionPart();
      assertEquals ("wrong fraction part ", new Fraction (2, 3), i);
      f1 = new Fraction (33, 3);
      i = f1.fractionPart();
      assertEquals ("wrong fraction part ", new Fraction (0, 1), i);
      f1 = new Fraction (-33, 3);
      i = f1.fractionPart();
      assertEquals ("wrong fraction part ", new Fraction (0, 1), i);
      f1 = new Fraction (-5, 4);
      i = f1.fractionPart();
      assertTrue ("wrong fraction part " + i.toString() 
         + " for " + f1.toString(), 
         i.equals (new Fraction (-1, 4)) || i.equals (new Fraction (3, 4)));
   }

   @Test (timeout=1000)
   public void testEquals() {
      Fraction f1 = new Fraction (2, 5);
      Fraction f2 = new Fraction (4, 10);
      assertTrue ("2/5 must be equal to 4/10", f1.equals (f2));
      assertFalse ("2/5 is not 3/5", f1.equals (new Fraction (3, 5)));
   }

   @Test (timeout=1000)
   public void testCompareTo() {
      Fraction f1 = new Fraction (2, 5);
      Fraction f2 = new Fraction (4, 7);
      assertTrue ("2/5 must be less than 4/7", f1.compareTo (f2) < 0);
      assertTrue ("2/5 must be equal to 4/10", 
         f1.compareTo (new Fraction (4, 10)) == 0);
      assertTrue ("4/7 must be greater than 2/5", f2.compareTo (f1) > 0);
      f1 = new Fraction (-2, 5);
      f2 = new Fraction (-4, 7);
      assertTrue ("-2/5 must be greater than -4/7", f1.compareTo (f2) > 0);
      assertTrue ("-2/5 must be equal to -4/10", 
         f1.compareTo (new Fraction (-4, 10)) == 0);
      assertTrue ("-4/7 must be less than -2/5", f2.compareTo (f1) < 0);
   }

   @Test (timeout=1000)
   public void testToFraction() {
      Fraction f1 = Fraction.toFraction (Math.PI, 7);
      Fraction f2 = new Fraction (22, 7);
      assertTrue ("Math.PI must be nearly 22/7", f1.equals (f2));
      f1 = Fraction.toFraction (-10., 2);
      f2 = new Fraction (-20, 2);
      assertTrue ("-10. must be -20/2", f1.equals (f2));
   }

   @Test (timeout=1000)
   public void testToDouble() {
      Fraction f = new Fraction (2, 5);
      assertEquals ("2/5 must be nearly 0.4", 0.4, f.toDouble(), 0.00001);
      f = new Fraction (-17, 100);
      assertEquals ("-17/100 must be nearly -0.17", -0.17, 
         f.toDouble(), 0.00001);
   }

   @Test (timeout=1000)
   public void testValueOf() {
      Fraction f = new Fraction (2, 5);
      assertEquals ("valueOf must read back what toString outputs. ", 
         f, Fraction.valueOf (f.toString()));
      f = new Fraction (-17, 100);
      assertEquals ("valueOf must read back what toString outputs. ", 
         f, Fraction.valueOf (f.toString()));
   }

   @Test (timeout=1000)
   public void testHashCode() {
      Fraction q1 = new Fraction (1, 2);
      int h1 = q1.hashCode();
      Fraction q2 = new Fraction (1, 2);
      int h2 = q2.hashCode();
      Fraction q3 = null;
      try {
         q3 = (Fraction)q1.clone();
      } catch (CloneNotSupportedException e) {};
      int h3 = q3.hashCode();
      assertTrue ("hashCode has to be same for equal objects", h1 == h2);
      assertTrue ("hashCode has to be same for clone objects", h1 == h3);
      assertTrue ("hashCode has to be same for the same object", 
         h1 == q1.hashCode());
      q2 = new Fraction (0, 2);
      h2 = q2.hashCode();
      q3 = new Fraction (1, 3);
      h3 = q3.hashCode();
      assertFalse ("hashCode does not depend on numerator", h1 == h2);
      assertFalse ("hashCode does not depend on denominator", h1 == h3);
   }

}

