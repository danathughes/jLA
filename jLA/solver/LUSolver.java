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
 *
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.solver;

import jLA.factorization.LUFactorization;
import jLA.core.Matrix;

public class LUSolver
{
   private Matrix L = null;
   private Matrix U = null;

   /**
    * Constructs the solver for the provided matrix
    * <p>
    * When a solver is created, it performs LU factorization on the given matrix
    * for use later.
    *
    * @param	A	The matrix to find solutions from
    *
    * @since	1.0.0
    */
   public LUSolver(Matrix A)
   {
      // Split A into L and U
      Matrix[] LU = LUFactorization.factor(A);
      this.L = LU[0];
      this.U = LU[1];
   }

   /**
    * Determine the solution of the system of equations Ax = b
    * <p>
    * This method uses the LU factorization calculated in the constructor to
    * determine the vector x which satisfies Ax = b.
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
         Matrix y = ForwardSubstitution.solve(this.L, b);
         x = BackwardSubstitution.solve(this.U, y);
      }
      catch (Exception e)
      {
         // We know that L and U are the correct
      }

      return x;
   }
}
