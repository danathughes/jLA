/**
 * A simple matrix class for playing around with numerical computing.  
 * <p>
 * This is a basic Matrix class for representing and performing various 
 * elementary operations.
 * <p>
 * This class is not to be considered efficient in terms of time or storage.
 * It was created to explore the algorithms in Michael Heath's textbook 
 * "Scientific Computing: An Introductory Survey".  This package should
 * not be used for any purpose where efficiency or accuracy is desired.  Learn
 * MatLAB or Octave instead if that is important.
 * 
 * @author	Dana Hughes	dana.hughes@colorado.edu
 * @version	1.0.0
 */

package jLA.core;

import jLA.core.MatrixSizeMismatchException;
import jLA.core.NotSquareMatrixException;
import java.lang.Math;

public class Matrix
{
   private int rows, cols;
   private double[][] matrix;


   /**
    * Generates an identity matrix of the given size.
    * <p>
    * An identity matrix is one which contains a 1 at each entry in the
    * diagonal, and 0 otherwise.
    *
    * @param	n	The rank (number of rows / columns of the matrix)
    *
    * @return		An identity matrix of rank n
    *
    * @since	1.0.0
    */
   public static Matrix identity(int n)
   {
      Matrix identity = new Matrix(n,n);
      for(int i=0; i<n; i++)
      {
         identity.set(i,i,1.0);
      }

      return identity;
   }


   /**
    * Creates a new matrix.
    * <p>
    * The matrix is initialized so that every entry is 0.  Clients should use
    * {@link #set(int, int, double)} to populate entries in the matrix.
    * 
    * @param	m	The number of rows in the matrix
    * @param	n	The number of columns in the matrix
    * 
    * @return		An m x n matrix with all zero entries
    *
    * @since	1.0.0 
    */
   public Matrix(int m, int n)
   {
      this.rows = m;
      this.cols = n;
      this.matrix = new double[m][n];
   }

   
   /**
    * Provides a String representation of the matrix.
    * <p>
    * The string is simply the entries of the matrix, with entries separated by
    * tab characters, and rows separated by newline characters.
    *
    * @return		A string representation of the matrix
    *
    * @since	1.0.0
    */
   public String toString()
   {
      String str = "";

      for(int i=0; i<this.rows; i++)
      {
         for(int j=0; j<this.cols; j++)
         {
            str = str + this.matrix[i][j] + "\t";
         }
         str = str + "\n";
      }

      return str;
   }


   /**
    * Gets the value of the matrix at location (i,j)
    *
    * @param	i	The row of the desired element
    * @param	j	The column of the desired element
    *
    * @return		The element at row i, column j
    *
    * @since	1.0.0
    */
   public double get(int i, int j)
   {
      return matrix[i][j];
   }


   /**
    * Sets the value of the matrix at location (i,j)
    *
    * @param	i	The row of the desired element to be set
    * @param	j	The column of the desired element to be set
    * @param	value	The new value of the element
    *
    * @since	1.0.0
    */
   public void set(int i, int j, double value)
   {
      matrix[i][j] = value;
   }


   /**
    * Gets the dimension of the matrix
    *
    * @return		A 2 element array consisting of the number of rows
    *			and number of columns
    */
   public int[] getSize()
   { 
      int[] size = new int[2];
      size[0] = this.rows;
      size[1] = this.cols;
      return size;
   }


   /**
    * Returns a copy of this matrix
    */
   public Matrix copy()
   {
      Matrix theCopy = new Matrix(this.rows, this.cols);

      for(int i=0; i<this.rows; i++)
      {
         for(int j=0; j<this.cols; j++)
         {
            theCopy.set(i, j, this.get(i, j));
         }
      }

      return theCopy;
   }

   /**
    * Indicates if this matrix is square
    *
    * @return		true if the matrix is square
    *
    * @since	1.0.0
    */
   public boolean isSquare()
   {
      return rows == cols;
   }


   /**
    * Indicates if this matrix is lower triangular
    *
    * @return		true if the matrix is lower triangular
    *
    * @since	1.0.0
    */
   public boolean isLowerTriangular()
   {
      // Assume true until shown otherwise
      boolean isLower = true;

      // Check that the upper portion are all zeros
      for(int i=0; i<this.rows; i++)
      {
         for(int j=i+1; j<this.cols; j++)
         {
            isLower = isLower && (this.get(i,j) == 0);
         }
      }

      return isLower;
   }


   /**
    * Indicates if this matrix is upper triangular
    *
    * @return		true if the matrix is upper triangular
    *
    * @since	1.0.0
    */
   public boolean isUpperTriangular()
   {
      // Assume true until shown otherwise
      boolean isUpper = true;

      // Check that the lower portion are all zeros
      for(int i=0; i<this.rows; i++)
      {
         for(int j=0; j<i; j++)
         {
            isUpper = isUpper && (this.get(i,j) == 0);
         }
      }

      return isUpper;
   }


   /**
    * Checks if these two matricies are equivalent
    *
    * @param	b	The matrix to compare this one to
    * 
    * @return		true if this matrix is equivalent to matrix b
    *
    * @since	1.0.0
    */
   public boolean equals(Matrix b)
   {
      boolean same = true;

      same = same && (this.rows == b.rows) && (this.cols == b.cols);

      if(same)
      {
         for(int i=0; i<this.rows; i++)
         {
            for(int j=0; j<this.cols; j++)
            {
               same = same && (this.get(i, j) == b.get(i, j));
            }
         }
      }

      return same;
   }


   /**
    * Gives the transpose of this matrix
    *
    * This method does not mutate this object, but rather creates a new
    * matrix. 
    *
    * @return		The transpose of this matrix
    *
    * @since	1.0.0
    */
   public Matrix transpose()
   {
      Matrix transposed_matrix = new Matrix(this.cols, this.rows);

      for(int i=0; i<this.rows; i++)
      {  
         for(int j=0; j<this.cols; j++)
         {
            transposed_matrix.set(j, i, this.get(i, j));
         }
      }

      return transposed_matrix;
   }


   /**
    * Adds this matrix to another
    *
    * This method does not mutate this object, but rather creates a new 
    * matrix.
    *
    * @param	b	The matrix to add to this matrix
    *
    * @return		The sum of this matrix and the matrix b
    * 
    * @since	1.0.0
    */
   public Matrix add(Matrix b) throws MatrixSizeMismatchException
   {
      if((this.rows != b.rows) && (this.cols != b.cols))
      {
         String msg = "Cannot add " + this.rows + "x" + this.cols + " matrix and " + b.rows + "x" + b.cols +" matrix.";
         throw new MatrixSizeMismatchException(msg);
      }

      Matrix sum = new Matrix(this.rows, this.cols);

      for(int i=0; i<this.rows; i++)
      {
         for(int j=0; j<this.cols; j++)
         {
            sum.set(i, j, this.get(i,j) + b.get(i,j));
         }
      }

      return sum;
   }


   /**
    * Multiplies this matrix to another
    *
    * The b matrix is multiplied to the right of this matrix, i.e., this 
    * method returns this*b, not b*this.  This method does not mutate this
    * object, but rather creates a new matrix.
    *
    * @param	b	The matrix to multiply to this matrix
    *
    * @return		The sum of this matrix and the matrix b
    * 
    * @since	1.0.0
    */
   public Matrix multiply(Matrix b) throws MatrixSizeMismatchException
   {
      if(this.cols != b.rows)
      {
         String msg = "Cannot multiply " + this.rows + "x" + this.cols + " matrix and " + b.rows + "x" + b.cols +" matrix.";
         throw new MatrixSizeMismatchException(msg);
      }

      Matrix product = new Matrix(this.rows, b.cols);

      // Sweet!!!  O(n^3)!!!
      for(int i=0; i<this.rows; i++)
      {
         for(int j=0; j<b.cols; j++)
         {
            for(int k=0; k<this.cols; k++)
            {
               product.set(i, j, product.get(i, j) + this.get(i,k) * b.get(k,j));
            }
         }
      }
      return product;
   }


   /**
    * Multiplies each element in the matrix with a scalar
    *
    * This method does not mutate this object, but rather creates a new 
    * matrix.
    *
    * @param	a	The scalar to multiply each element by
    *
    * @return		A matrix whose elements are multiplied by this scalar
    *
    * @since	1.0.0
    */
   public Matrix multiply(double a)
   {
      Matrix product = new Matrix(this.rows, this.cols);

      for(int i=0; i<rows; i++)
      {
         for(int j=0; j<cols; j++)
         {
            product.set(i, j, a*this.get(i,j));
         }
      }

      return product;
   }


   /**
    * Creates a submatrix omitting the given row and column
    * <p>
    * This method is used to help calculate the determinant of the matrix.  The
    * client should never need to access this directly.
    *
    * @param	omitRow	The row number to omit in the submatrix
    * @param	omitCol	The column number to omit in the submatrix
    *
    * @return	A submatrix of this matrix with a row and column removed
    *
    * @since	1.0.0
    */
   private Matrix createDetSubmatrix(int omitRow, int omitCol)
   {
      Matrix submatrix = new Matrix(this.rows - 1, this.cols - 1);

      for(int i=0; i<omitRow; i++)
      {
         for(int j=0; j<omitCol; j++)
         {
            submatrix.set(i, j, this.get(i, j));
         }
         for(int j=omitCol+1; j<this.cols; j++)
         {
            submatrix.set(i, j-1, this.get(i, j));
         }
      }

      for(int i=omitRow+1; i<this.rows; i++)
      {
         for(int j=0; j<omitCol; j++)
         {
            submatrix.set(i-1, j, this.get(i, j));
         }
         for(int j=omitCol+1; j<this.cols; j++)
         {
            submatrix.set(i-1, j-1, this.get(i, j));
         }
      }
      
      return submatrix;
   }


   /**
    * Calculates the determinant of this matrix
    *
    * @return		The determinant of this matrix
    *
    * @throws	NotSquareMatrixException	If the matrix is not square
    *                                           
    * @since	1.0.0
    */
   public double det() throws NotSquareMatrixException
   {
      double determinant = 0;
 
      if(this.rows != this.cols)
      {
         throw new NotSquareMatrixException();
      }

      // Base case - 1x1 Matrix
      if(this.rows == 1)
      {
         determinant = this.get(0,0);
      }
      else
      {
         for(int i=0; i < this.cols; i++)
         {
            Matrix submatrix = createDetSubmatrix(0, i);
            determinant += Math.pow(-1, i) * this.get(0,i) * submatrix.det();
         }
      }

      return determinant;
   }


   /**
    * Determines if the matrix is singular
    *
    * @return		true if the matrix is singular
    *
    * @throws	NotSquareMatrixException	If not square - no determinant
    *
    * @since	1.0.0
    */

   public boolean isSingular() throws NotSquareMatrixException
   {
      return this.det() == 0;
   }


   /**
    * Calculates the 1-norm of this matrix
    *
    * @return		the L1 norm of this matrix
    *
    * @since	1.0.0
    */

   public double norm1()
   {
      double norm = Double.NEGATIVE_INFINITY;

      for(int j=0; j<this.cols; j++)
      {
         double col_sum = 0;
         for(int i=0; i<this.rows; i++)
         {
            col_sum = col_sum + Math.abs(matrix[i][j]);
         }
         norm = Math.max(norm, col_sum);
      }

      return norm;
   }


   /**
    * Calculates the infinity-norm of this matrix
    *
    * @return		The L-infinity norm of this matrix
    */
   public double normInf()
   {
      double norm = Double.NEGATIVE_INFINITY;

      for(int i=0; i<this.rows; i++)
      {
         double row_sum = 0;
         for(int j=0; j<this.rows; j++)
         {
            row_sum = row_sum + Math.abs(matrix[i][j]);
         }
         norm = Math.max(norm, row_sum);
      }

      return norm;
   }
}
