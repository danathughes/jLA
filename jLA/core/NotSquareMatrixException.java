package jLA.core;

public class NotSquareMatrixException extends Exception
{
   public NotSquareMatrixException() {}

   public NotSquareMatrixException(String message)
   {
      super(message);
   }

   public NotSquareMatrixException(Throwable cause)
   {
      super(cause);
   }

   public NotSquareMatrixException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
