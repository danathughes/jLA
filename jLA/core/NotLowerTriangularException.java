/**
 * An exception for attempting operations requiring lower triangular matrices.
 * <p>
 * Examples include performing forward substitution. 
 *
 * 
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */
package jLA.core;

public class NotLowerTriangularException extends Exception
{
   /**
    * Creates a new exception with no message.
    *
    * @since	1.0.0 
    */
   public NotLowerTriangularException() {}

   /**
    * Creates a new exception with a message.
    *
    * @param	message	A reason for throwing this exception
    *
    * @since	1.0.0 
    */
   public NotLowerTriangularException(String message)
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
   public NotLowerTriangularException(Throwable cause)
   {
      super(cause);
   }


   /**
    * Creates a new exception with a message and a cause.
    *
    * @param	message	A reason for throwing this exception
    * @param	cause	The cause of this if it was due to another exception
    *
    * @since	1.0.0 
    */
   public NotLowerTriangularException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
