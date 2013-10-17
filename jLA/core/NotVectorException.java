package jLA.core;

public class NotVectorException extends Exception
{
   public NotVectorException() {}

   public NotVectorException(String message)
   {
      super(message);
   }

   public NotVectorException(Throwable cause)
   {
      super(cause);
   }

   public NotVectorException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
