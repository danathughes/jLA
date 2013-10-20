/**
 * A solver for least squares problem using normal equations
 * <p>
 * Normal equations solve least squares problems by setting the gradient of the
 * residual to zero.  In other words, it simply requires solving A^T Ax = A^T b
 * using a solver of choice.
 *<p>
 * In general, finding a least squares solution is useful for overdetermined 
 * systems, i.e., for the case where A has more rows than columns.
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.linearLeastSquares;

import jLA.solver.LUSolverPartialPivot;
import jLA.core.Matrix;
import jLA.core.MatrixSizeMismatchException;

public class NormalEquationSolver
{
   /**
    * Determine the least squares solution of the system of equations Ax = b
    * <p>
    * This method solves by determining the normal equations for this system
    * and solving using LU factorization with partial pivoting.
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
      // Convert to the normal equations, i.e., A^T A  and A^T b
      Matrix normalA = A.transpose().multiply(A);
      Matrix normalB = A.transpose().multiply(b);

      // Create an LU solver to solve the normal system of equations
      // Note - we can use Cholesky factorization here...
      LUSolverPartialPivot solver = new LUSolverPartialPivot(normalA);
      Matrix x = solver.solve(normalB);

      return x;
   }
}
