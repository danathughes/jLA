/**
 * An exception for attempting operations requiring vectors.
 * <p>
 * Examples include solving a system of linear equations
 *
 * 
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */
package jLA.core;

public class NotVectorException extends Exception
{
   /**
    * Creates a new exception with no message.
    *
    * @since	1.0.0 
    */
   public NotVectorException() {}


   /**
    * Creates a new exception with a message.
    *
    * @param	message	A reason for throwing this exception
    *
    * @since	1.0.0 
    */
   public NotVectorException(String message)
   {
      super(message);
   }


   /**
    * Creates a new exception with a cause.
    *
    * @since	1.0.0 
    */
   public NotVectorException(Throwable cause)
   {
      super(cause);
   }


   /**
    * Creates a new exception with a message and a cause.
    *
    * @param	message	A reason for throwing this exception
    *
    * @since	1.0.0 
    */
   public NotVectorException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
