/**
 * A solver for use with lower triangular matrices.
 * <p>
 * Forward substitution can be used when the provided system of equations form
 * an lower triangular matrix.  In other words, it solves the system Lx = b, 
 * where L is upper triangular.
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.solver;

import jLA.core.Matrix;

public class ForwardSubstitution
{
   /**
    * Solve the system of equations.
    *
    * @param 	A	The lower-triangular matrix
    * @param	b	The solution vector
    *
    * @return		The solution vector x for the system Ax=b
    *
    * @since	1.0.0
    */
   public static Matrix solve(Matrix A, Matrix b)
   {
      // Check that the matrices match the necessary conditions

      if(!A.isLowerTriangular())
      {
         // Throw an exception
      }

      // Make sure b is a vector
      if(b.getSize()[1] != 1)
      {
         // Throw an exception
      }

      Matrix x = new Matrix(b.getSize()[0], b.getSize()[1]);
      Matrix bCopy = b.copy();

      // Loop over columns
      for(int j=0; j<A.getSize()[1]; j++)
      {

         // Stop if matrix is singular
         if(A.get(j, j) == 0)
         { 
            // Matrix is singular, throw an error
         }

         // Compute solution component
         x.set(j, 0, bCopy.get(j,0)/A.get(j,j));

         // Update right-hand side
         for(int i=j+1; i<A.getSize()[0]; i++)
         {
            bCopy.set(i, 0, bCopy.get(i,0) - A.get(i,j) * x.get(j,0));
         }
      }

      return x;
   }
}
