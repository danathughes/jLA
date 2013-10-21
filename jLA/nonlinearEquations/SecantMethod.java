/**
 * A solver for nonlinear equations which uses Secant method
 * <p>
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */
package jLA.nonlinearEquations;

import java.lang.Math;
import jLA.core.Function;

public class SecantMethod
{
   /**
    * Determine where the function is zero
    *
    * @param 	f	The function to solve
    * @param	x0	One initial guess for the solver
    * @param	x1	Another initial guess for the solver
    * @param	maxIter	The maximum number of iterations to run this solver
    *
    * @return		The value x such that f(x) = 0
    *
    * @since	1.0.0
    */
   public static double solve(Function f, double x0, double x1, double tol, int maxIter)
   {
      // Perform the iteration until convergence or maxIter is reached
      int iterNum = 0;

      double x2 = 0;

      while(Math.abs(x1 - x0) > tol && iterNum < maxIter)
      {
         // Determine the next value of x
         x2 = x1 - f.f(x1)*(x1-x0)/(f.f(x1) - f.f(x0));

         x0 = x1;
         x1 = x2;

         iterNum = iterNum + 1;
      }

      return x1;
   }
}
