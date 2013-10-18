/**
 * Functionality to perform Gaussian transformations of a matrix  
 * <p>
 * The primary purpose of this class is to provide subfunctionality for
 * calculating the solution to a system of linear equations.  This is not used
 * in practice, and has generally be replaced by the functionality in the
 * LUFactorization class.
 * 
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 *
 * @see		LUFactorization
 */

package jLA.factorization;

import jLA.core.Matrix;


public class GaussTransformation
{
   /**
    * Creates an elementary elimination matrix.
    * <p>
    * The elementary elimination matrix produces a matrix which, when left-
    * multiplied by the provided solution vector, zeros out all entries below
    * the provided row.  This approach can be used to factorize a matrix and 
    * determine the solution of a set of linear equations, but LU factorization
    * is more likely to be used.
    *
    * @param	b	The solution vector to be zeroed out
    * @param	k	The row number below which entries should be zeroed
    *
    * @return		The elementary elimination matrix which zeros out rows
    *			in the solution below row k
    *
    * @since	1.0.0
    */
   public static Matrix createElementaryEliminationMatrix(Matrix b, int k)
   {
      // Ensure that b is a vector

      // Start with an identity matrix the size of A
      Matrix M = Matrix.identity(b.getSize()[0]);

      // Now, fill all elements in column k (the pivot)
      for(int i=k+1; i<M.getSize()[0]; i++)
      {
         M.set(i,k, -b.get(i,0)/b.get(k,0));
      } 

      return M;
   }
}
