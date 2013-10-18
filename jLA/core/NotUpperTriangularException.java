/**
 * An exception for attempting operations requiring upper triangular matrices.
 * <p>
 * Examples include performing backward substitution. 
 *
 * 
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */
package jLA.core;

public class NotUpperTriangularException extends Exception
{
   /**
    * Creates a new exception with no message.
    *
    * @since	1.0.0 
    */
   public NotUpperTriangularException() {}


   /**
    * Creates a new exception with a message.
    *
    * @param	message	A reason for throwing this exception
    *
    * @since	1.0.0 
    */
   public NotUpperTriangularException(String message)
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
   public NotUpperTriangularException(Throwable cause)
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
   public NotUpperTriangularException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
