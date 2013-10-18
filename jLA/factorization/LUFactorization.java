/**
 * Converts a matrix into lower and upper triangular matrices.
 * <p>
 * LU factorization is useful for solving a system of linear equations without
 * explicitly inverting the matrix (which is more computationally expensive).
 * In addition, LU factorization with partial pivoting can provide more stable
 * solution to an system of equations.
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @since	1.0.0
 */

package jLA.factorization;

import java.util.LinkedList;
import java.util.Iterator;

import jLA.core.Matrix;
import jLA.core.MatrixSizeMismatchException;

public class LUFactorization
{
   /**
   * Simple LU factorization
   * <p>
   * Determines two matrices, L and U, such that A = LU.
   *
   * @param	A	The matrix to factor
   *
   * @return		The two matrices, L and U
   *
   * @since	1.0.0
   */
   public static Matrix[] factor(Matrix A)
   {
      // Ensure A is suitable for this

      // Start the two matrices
      int N = A.getSize()[0];    // How many columns in A?

      Matrix L = Matrix.identity(N);
      Matrix U = A.copy();

      // Perform the LU factorization
      for(int k=0; k<N-1; k++)
      {
         // Is the matrix singular?
         if(U.get(k,k) == 0)
         {
            // Throw an error here
         }

         // Set the L matrix values
         for(int i=k+1; i<N; i++)
         {
            L.set(i, k, U.get(i,k)/U.get(k,k));
         }

         // Set the U matrix values
         for(int j=k+1; j<N; j++)
         {
            for(int i=k+1; i<N; i++)
            {
               U.set(i,j, U.get(i,j) - L.get(i,k)*U.get(k,j));
            }
         }
      }

      // Set the lower triangle of U to 0
      for(int j=0; j<N-1; j++)
      {
         for(int i=j+1; i<N; i++)
         {
            U.set(i,j,0);
         }
      }

      // And return these two
      Matrix[] LU = new Matrix[2];
      LU[0] = L;
      LU[1] = U;
      return LU;
   }


   /**
    * Performs LU factorization with partial pivoting.
    * <p>
    * Partial pivoting can ensure that the factors L and U are more stable.
    * Partial pivoting involves swapping rows of the matrix when factoring the
    * matrix, and results in a factorization LU = PA.  To solve for this, the
    * solution vector must be first multiplied by P, i.e., we solve for x the
    * system of equations LUx = Pb.
    *
    * @param	A	The matrix to factor
    *
    * @return		The factors, L and U, and pivot matrix P
    *
    * @since	1.0.0
    */
   public static Matrix[] factorWithPartialPivot(Matrix A)
   {
      // Ensure A is suitable for this

      // Start the two matrices
      int N = A.getSize()[0];    // How many columns in A?

      Matrix L = Matrix.identity(N);
      Matrix U = A.copy();
      Matrix P = Matrix.identity(N);

      // Perform the LU factorization
      for(int k=0; k<N-1; k++)
      {
         // Find the index p of the biggest value
         int p = k;
         double max_val = U.get(p,k);
         for(int i=k; i<N; i++)
         {
            if(U.get(i,k) > max_val)
            {
               p=i;
               max_val = U.get(p,k);
            }
         }

         // Swap rows is necessary
         if(p != k)
         {
            for(int j=0; j<N; j++)
            {
               double tmp = U.get(k,j);
               U.set(k,j, U.get(p,j));
               U.set(p,j, tmp);

               // Also swap permutation matrix rows
               tmp = P.get(k,j);
               P.set(k,j, P.get(p,j));
               P.set(p,j, tmp);      
            }
            // Swap any rows in the lower diagonal matrix
            for(int j=0; j<k; j++)
            {
               double tmp = L.get(k,j);
               L.set(k,j, L.get(p,j));
               L.set(p,j, tmp);
            }
         }

         // Perform the factorization if a_kk is not zero, skip otherwise
         if(U.get(k,k) != 0)
         {
            // Set the L matrix values
            for(int i=k+1; i<N; i++)
            {
               L.set(i, k, U.get(i,k)/U.get(k,k));
            }

            // Set the U matrix values
            for(int j=k+1; j<N; j++)
            {
               for(int i=k+1; i<N; i++)
               {
                  U.set(i,j, U.get(i,j) - L.get(i,k)*U.get(k,j));
               }
            }
         }
      }

      // Set the lower triangle of U to 0
      for(int j=0; j<N-1; j++)
      {
         for(int i=j+1; i<N; i++)
         {
            U.set(i,j,0);
         }
      }

      // And return these two
      Matrix[] LU = new Matrix[3];
      LU[0] = L;
      LU[1] = U;
      LU[2] = P;
      return LU;

   }
}
