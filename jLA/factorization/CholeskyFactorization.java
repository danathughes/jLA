/**
 * Functionality to perform Cholesky factorization of a matrix  
 * 
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.2
 */
package jLA.factorization;

import jLA.core.Matrix;
import java.lang.Math;

public class CholeskyFactorization
{
   /**
   * Perform Cholesky factorization on this matrix.
   *
   * Cholesky factorization is a special case of LU factorization which can be
   * applied to matrices which are symmetric and positive definite.  The 
   * factorization is such that U is the transpose of L.  In other words, it
   * factors a matrix in such a way that A = L * L^T.
   *
   * @param	A	The matrix to be factored
   * 
   * @return		The lower diagonal matrix of this factorization
   *
   * @since	1.0.0
   */
   public static Matrix factor(Matrix A)
   {
      // Ensure that A is symmetric and positive definite

      // Start with a copy of A
      Matrix C = A.copy();
      int N = C.getSize()[0];

      // Perform the algorithm
      for(int k=0; k<N; k++)
      {
         C.set(k, k, Math.sqrt(C.get(k,k)));

         for(int i=k+1; i<N; i++)
         {
            C.set(i,k, C.get(i,k)/C.get(k,k));
         }
         for(int j=k+1; j<N; j++)
         {
            for(int i=k+1; i<N; i++)
            {
               C.set(i,j, C.get(i,j) - C.get(i,k)*C.get(j,k));
            }
         }
      }

      // Populate the upper triangular with zeros
      for(int i=0; i<N; i++)
      {
         for(int j=i+1; j<N; j++)
         {
            C.set(i,j,0);
         }
      }

      return C;
   }     
}
