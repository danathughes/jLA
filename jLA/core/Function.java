/**
 * A simple function class for playing around with numerical computing.  
 * <p>
 * This is a basic function class for representing user defined functions.
 * <p>
 * Users should extend this class with specific function to solve.  Users can
 * use this class to work with nonlinear solvers, etc.
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.core;


public abstract class Function
{

   /**
    * f calculates the value of a function at the given point
    *
    * @param	point	The point to calculate this function at
    * 
    * @return		The value of the function at this point
    *
    * @since 	1.0.0
    */
   public abstract double f(double x);


   /**
    * df calculates the derivative of a function at the given point
    *
    * @param	point	The point to calculate the derivated at
    *
    * @return		The derivative of the function at thils point
    *
    * @since	1.0.0
    */
    public abstract double df(double x);
}
