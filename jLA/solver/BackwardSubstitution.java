/**
 * A solver for use with upper triangular matrices.
 * <p>
 * Backward substitution can be used when the provided system of equations form
 * an upper triangular matrix.  In other words, it solves the system Ux = b, 
 * where U is upper triangular.
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */
package jLA.solver;

import jLA.core.Matrix;

public class BackwardSubstitution
{
   /**
    * Solve the system of equations.
    *
    * @param 	A	The upper-triangular matrix
    * @param	b	The solution vector
    *
    * @return		The solution vector x for the system Ax=b
    *
    * @since	1.0.0
    */
   public static Matrix solve(Matrix A, Matrix b)
   {
      // Check that the matrices match the necessary conditions

      if(!A.isUpperTriangular())
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

      // Loop backwards over columns
      for(int j=A.getSize()[1]-1; j>=0; j--)
      {
         // Stop if the matrix is singular
         if(A.get(j, j) == 0)
         { 
            // Matrix is singular, throw an error
         }

         // Compute solution component
         x.set(j, 0, bCopy.get(j,0)/A.get(j,j));

         // Update right-hand side
         for(int i=0; i<j; i++)
         {
            bCopy.set(i, 0, bCopy.get(i,0) - A.get(i,j) * x.get(j,0));
         }
      }

      return x;
   }
}
