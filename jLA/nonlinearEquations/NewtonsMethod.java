/**
 * A solver for nonlinear equations which uses Newton's method
 * <p>
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */
package jLA.nonlinearEquations;

import jLA.core.Function;

public class NewtonsMethod
{
   /**
    * Determine where the function is zero
    *
    * @param 	f	The function to solve
    * @param	initial	The initial guess for the solver
    * @param	maxIter	The maximum number of iterations to run this solver
    *
    * @return		The value x such that f(x) = 0
    *
    * @since	1.0.0
    */
   public static double solve(Function f, double initial, int maxIter)
   {
      // Perform the iteration until convergence or maxIter is reached
      int iterNum = 0;

      double x = initial;

      while(iterNum < maxIter)
      {
         // Update the value of x
         x = x - f.f(x)/f.df(x);

         iterNum = iterNum + 1;
      }

      return x;
   }
}
