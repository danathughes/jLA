package jLA.core;

public class MatrixSizeMismatchException extends Exception
{
   public MatrixSizeMismatchException() {}

   public MatrixSizeMismatchException(String message)
   {
      super(message);
   }

   public MatrixSizeMismatchException(Throwable cause)
   {
      super(cause);
   }

   public MatrixSizeMismatchException(String message, Throwable cause)
   {
      super(message, cause);
   }
}
