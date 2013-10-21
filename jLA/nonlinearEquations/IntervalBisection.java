/**
 * A solver for nonlinear equations which uses interval bisection
 * <p>
 * Interval bisection assumes that, at two endpoints of a given interval, the
 * function crosses 0.  In addition, the function must be continuous
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */
package jLA.nonlinearEquations;

import jLA.core.Function;

public class IntervalBisection
{
   /**
    * Determine where the function is zero
    *
    * @param 	f	The function to solve
    * @param	a	The lower endpoint of the initial interval
    * @param	b	The upper endpoint of the initial interval
    * @param	tol	How close the solution needs to be to the exact one
    * @param	maxIter	The maximum number of iterations to run this solver
    *
    * @return		The value x such that f(x) = 0
    *
    * @since	1.0.0
    */
   public static double solve(Function f, double a, double b, double tol, int maxIter)
   {
      // Make sure a is less than b, swap otherwise
      if(a > b)
      {
         double tmp = b;
         b = a;
         a = tmp;
      }

      // Calculate an initial midpoint, in case the user provides an interval
      // smaller than the tolerance
      double midpoint = a + (b - a) / 2;
      double fm = f.f(midpoint);

      // Check that the values of f crosses 0 between the two intervals
      double fa = f.f(a);
      double fb = f.f(b);

      if(fa*fb >= 0)
      {
         // Throw an error - they don't necessarily cross 0
      }

      // Perform the iteration until convergence or maxIter is reached
      int iterNum = 0;

      while(iterNum < maxIter && (b - a) > tol)
      {
         midpoint = a + (b - a) / 2;
         fm = f.f(midpoint);

         // Replace either a or b with midpoint, depending on who has the 
         // same sign
         if(fm*fa >= 0)
         {
            a = midpoint;
            fa = fm;
         }
         else
         {
            b = midpoint;
            fb = fm;
         }

         iterNum = iterNum + 1;
      }

      return midpoint;
   }
}
