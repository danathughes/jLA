/**
 * A solver for least squares problem using augmented system
 * <p>
 * An augmented system embeds a least-squares problem into a larger, square
 * system of equations.
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.linearLeastSquares;

import jLA.solver.LUSolverPartialPivot;
import jLA.core.Matrix;
import jLA.core.MatrixSizeMismatchException;

public class AugmentedSystemSolver
{
   /**
    * Determine the least squares solution of the system of equations Ax = b
    * <p>
    * This method solves by creating an augmented system and solving using LU
    * factorization with partial pivoting.
    * <p>
    * Note that A does not need to be square.
    *
    * @param	A	The 
    * @param	b	The vector b in the system Ax = b
    *
    * @return		The vector x which satisfies Ax = b
    *
    * @throws	MatrixSizeMismatchError
    *			If the number of rows of A and b do not match
    *
    * @since	1.0.0
    */
   public static Matrix solve(Matrix A, Matrix b) throws MatrixSizeMismatchException
   {
      int m = A.getSize()[0];
      int n = A.getSize()[1];

      // The augmented system is an (m+n) x (m+n) matrix
      int N = m + n;

      // Create an augmented system of equations
      Matrix augmentedSystem = new Matrix(N,N);

      // The upper-left m x m region of this matrix is the identity
      for(int i=0; i<m; i++)
      {
         augmentedSystem.set(i,i,1);
      }

      // The upper-right region of this matrix is A
      // The lower-left region is A^T
      for(int i=0; i<m; i++)
      {
         for(int j=0; j<n; j++)
         {
            augmentedSystem.set(i, m+j, A.get(i,j));
            augmentedSystem.set(m+j, i, A.get(i,j));
         }
      }

      // Augment the b vector with zeros

      Matrix bAugmented = new Matrix(N,1);
      for(int i=0; i<m; i++)
      {
         bAugmented.set(i,0,b.get(i,0));
      }

      // Create an LU solver to solve the normal system of equations
      // Note - we can use Cholesky factorization here...
      LUSolverPartialPivot solver = new LUSolverPartialPivot(augmentedSystem);
      Matrix solution = solver.solve(bAugmented);

      // extract the x vector
      Matrix x = new Matrix(n,1);
      for(int i=0; i<n; i++)
      {
         x.set(i,0,solution.get(m+i,0));
      }

      return x;
   }
}
