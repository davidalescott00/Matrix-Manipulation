/* * 
 * The Matrix class is a 2 dimensional array with rows and columns.
 * The matrix can be constructed either empty with just dimensions specified,
 * or with a list of elements and dimensions to fill.
 * It features a create, plus and times method.
 * @author David Scott 
 * @date   <2/11/21> 
 * */

import java.util.ArrayList;
import java.util.List;


public class Matrix {
	private final int _rows; // number of rows
	private final int _columns; // number of columns
	private final double[][] _data; // M-by-N (rows x columns) array

	public Matrix(int rows, int columns) {
		// create M-by-N matrix of 0's - Basic Constructor
		_rows = rows;
		_columns = columns;
		_data = new double[_rows][_columns];
	}

	public Matrix(List<Double> items, int rows, int columns) {
		// Creates a matrix with given dimensions, fills with list elements
		// If list elements do not fill up matrix dimensions, add 0's
		// If list elements exceed matrix dimensions, ignore excess

		int count = 0; // This will point to list items
		_rows = rows;
		_columns = columns;
		_data = new double[_rows][_columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (count < items.size()) { // If we have not finished adding list elements

					_data[i][j] = items.get(count);
					count++;

				} else {
					// List has been exhausted
					_data[i][j] = 0.0;
				}

			}
		}
	}

	/**
	 * Creates a matrix with specified dimensions, but fills each cell with a double 
	 * randomly generated between 0 and 1.
	 * @param: Takes row and column sizes for random matrix creation.
	 * @returns Matrix with random doubles between 0 and 1 with specified dimensions
	 */
	public static Matrix create(int rows, int columns) {
		List<Double> numList = new ArrayList<Double>();
		
		for (int i = 0; i < rows * columns; i++) { // Rows * columns - gives number of elements in matrix
			numList.add(Math.random()); // For number of elements in matrix, random double 0<n<1
		}
		Matrix toReturn = new Matrix(numList, rows, columns);
		return toReturn;
	}

	/**
	 * Performs addition operation on a matrix and another.
	 * Both matrices have to be identical dimensions.
	 * @param: Takes a matrix to be added to current matrix.
	 * @returns Matrix holding result of addition operation.
	 * @throws RuntimeException if the matrices being added are not the same size.
	 */
	public Matrix plus(Matrix that) {
		
		if (this._rows != that._rows || this._columns != that._columns) {
			throw new RuntimeException("Dimensions of matrices differ");
		}
		List<Double> sums = new ArrayList<Double>();

		for (int i = 0; i < _rows; i++) {
			for (int j = 0; j < _columns; j++) {

				double s = this._data[i][j] + that._data[i][j]; //Records sum at each position
				sums.add(s);

			}
		}
		Matrix toReturn = new Matrix(sums, _rows, _columns); //List with sum results converted into matrix with original dimensions
		return toReturn;
	}
	
	/**
	 * Performs multiplication operation on a matrix and another.
	 * Matrix column size has to be the same as second matrix row size.
	 * @param: Takes a matrix to be multiplied to current matrix.
	 * @returns Matrix holding result of multiplication operation.
	 * @throws RuntimeException if matrix column size is different from second matrix row size.
	 */
	public Matrix times(Matrix that) throws RuntimeException{
		// If columnsthis != rowsthat, then aRuntimeException is thrown.
		if (this._columns != that._rows) {
			throw new RuntimeException("Column and row values different");
		}

		Double product = 0.0;
		List<Double> products = new ArrayList<Double>();
		for (int i = 0; i < this._rows; i++) {
			for (int j = 0; j < that._columns; j++) {
				for (int k = 0; k < this._columns; k++) {

					// Increment sum by product
					product += this._data[i][k] * that._data[k][j];

				}
				products.add(product);
				product = 0.0; // Product has to be reset for each grouping
			}
		}
		Matrix toReturn = new Matrix(products, this._rows, that._columns); // Create a matrix with result
		return toReturn;
	}

	/**
	 * Converts a matrix object to a string using string builder.
	 * Does not print anything but returns a string holding entire formatted matrix.
	 * @returns string holding entire formatted matrix.
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < _data.length; i++) {
			for (int j = 0; j < _data[i].length; j++) {

				str.append(_data[i][j] + " "); // Append each element of matrix to string

			}
			str.append("\n");
		}
		return str.toString();
	}
	/**
	 * Returns private row number of current matrix. 
	 * Used in timer tests to report current matrix size.
	 * @returns number of rows of current matrix.
	 */
	public int getSize() {
		return _rows; // Access row number for timing
	}
}
