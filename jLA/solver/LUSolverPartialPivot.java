/**
 * A solver for use with square matrices.
 * <p>
 * LU solving can be used with any square matrix.  It solves the system of
 * equations Ax = b by first performing LU factorization, then performing
 * forward and backward subsitution to solve for x.  More specifically, it
 * solves the system LUx = b by first solving Ly = b, then solving Ux = y.
 * <p>
 * Once the LU factorization has been performed, it is possible to reuse the
 * factorization to solve for multiple values of b.
 * <p>
 * Partial pivoting is used to provide more stable solutions, requiring only
 * the use of a pivot matrix when determining a solution to a given set of 
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.solver;

import jLA.factorization.LUFactorization;
import jLA.core.Matrix;

public class LUSolverPartialPivot
{
   private Matrix L = null;
   private Matrix U = null;
   private Matrix P = null;

   /**
    * Constructs the solver for the provided matrix
    * <p>
    * When a solver is created, it performs LU factorization on the given matrix
    * for use later, and maintains the pivot matrix
    *
    * @param	A	The matrix to find solutions from
    *
    * @since	1.0.0
    */

   public LUSolverPartialPivot(Matrix A)
   {
      // Split A into L and U
      Matrix[] LU = LUFactorization.factorWithPartialPivot(A);
      this.L = LU[0];
      this.U = LU[1];
      this.P = LU[2];
   }

   /**
    * Determine the solution of the system of equations Ax = b
    * <p>
    * This method uses the LU factorization calculated in the constructor to
    * determine the vector x which satisfies PAx = Pb.  The pivot matrix P is
    * included since pivoting was performed when determining the matrices L and
    * U.
    * 
    * @param	b	The vector b in the system Ax = b
    *
    * @return		The vector x which satisfies Ax = b
    *
    * @since	1.0.0
    */
   public Matrix solve(Matrix b)
   {
      // Check that the matrices match the necessary conditions
      if(b.getSize()[0] != L.getSize()[0])      
      {
         // Throw an exception - wrong size
      }

      Matrix x = null;
      // Perform forward-backward substitution to get x
      try 
      {
         Matrix bPermuted = P.multiply(b);
         Matrix y = ForwardSubstitution.solve(this.L, bPermuted);
         x = BackwardSubstitution.solve(this.U, y);
      }
      catch (Exception e)
      {
         // We know that L and U are the correct
      }

      return x;
   }
}
