package jLA.core;

public class NotUpperTriangularException extends Exception
{
   public NotUpperTriangularException() {}

   public NotUpperTriangularException(String message)
   {
      super(message);
   }

   public NotUpperTriangularException(Throwable cause)
   {
      super(cause);
   }

   public NotUpperTriangularException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
