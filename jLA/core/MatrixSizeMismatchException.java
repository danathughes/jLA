/**
 * An exception for attempting operations on matrices with non-compatible sizes.
 * <p>
 * Examples include performing matrix multiplication or addition. 
 *
 * 
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.core;

public class MatrixSizeMismatchException extends Exception
{
   /**
    * Creates a new exception with no message.
    *
    * @since	1.0.0 
    */
   public MatrixSizeMismatchException() {}


   /**
    * Creates a new exception with a message.
    *
    * @param	message	A reason for throwing this exception
    *
    * @since	1.0.0 
    */
   public MatrixSizeMismatchException(String message)
   {
      super(message);
   }


   /**
    * Creates a new exception with a cause.
    *
    * @param	cause	The cause of this if it was due to another exception
    *
    * @since	1.0.0 
    */
   public MatrixSizeMismatchException(Throwable cause)
   {
      super(cause);
   }


   /**
    * Creates a new exception with a message and cause.
    *
    * @param	message	A reason for throwing this exception
    * @param	cause	The cause of this if it was due to another exception
    *
    * @since	1.0.0 
    */
   public MatrixSizeMismatchException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
