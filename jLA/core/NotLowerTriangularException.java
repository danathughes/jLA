package jLA.core;

public class NotLowerTriangularException extends Exception
{
   public NotLowerTriangularException() {}

   public NotLowerTriangularException(String message)
   {
      super(message);
   }

   public NotLowerTriangularException(Throwable cause)
   {
      super(cause);
   }

   public NotLowerTriangularException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
