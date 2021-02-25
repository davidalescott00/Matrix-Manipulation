import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MatrixTest {

	/**
	 * Tests addition method between normal matrices
	 * @result Expects matrix result to be double its inital values.
	 */
	@Test
	void testNormalPlus() {
		List<Double> list = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		
		Matrix plusTest = new Matrix(list, 3, 2);
		String expectedSum = "2.0 4.0 \n" + "6.0 8.0 \n" + "10.0 12.0 \n";

		plusTest = plusTest.plus(plusTest);
		assertEquals(expectedSum, plusTest.toString());
	}
	
	/**
	 * Tests error throwing with plus method.
	 * @result Expects a Runtime exception dimensions of matrices differ
	 */
	@Test
	void testErrorPlus() {
		List<Double> list = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		Matrix m1 = new Matrix(list, 1, 2);
		Matrix m2 = new Matrix(list, 3, 4);

		assertThrows(RuntimeException.class, () -> {
			m1.plus(m2);
		});
	}

	/**
	 * Tests addition with an empty matrix
	 * @result Expects an empty matrix.
	 */
	@Test
	void testEmptyPlus() {
		Matrix emptyPlusTest = new Matrix(2, 2);
		String expectedSum = "0.0 0.0 \n" + "0.0 0.0 \n";

		emptyPlusTest = emptyPlusTest.plus(emptyPlusTest);
		assertEquals(expectedSum, emptyPlusTest.toString());
	}

	/**
	 * Tests error throwing with multiplication method.
	 * @result Expects a Runtime exception if columnsthis != rowsthat
	 */
	@Test
	void testErrorTimes() {
		List<Double> list = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		Matrix m1 = new Matrix(list, 3, 2);
		Matrix m2 = new Matrix(list, 5, 6);

		assertThrows(RuntimeException.class, () -> {
			m1.times(m2);
		});
	}

	/**
	 * Tests multiplication method with empty matrices.
	 * @result Expects an empty matrix. 
	 */
	@Test
	void testEmptyTimes() {
		Matrix emptyPlusTest = new Matrix(2, 2);
		emptyPlusTest = emptyPlusTest.times(emptyPlusTest);

		String expectedSum = "0.0 0.0 \n" + "0.0 0.0 \n";
		assertEquals(expectedSum, emptyPlusTest.toString());
	}

	/**
	 * Tests multiplication method with normal matrices
	 * @result Expects R1: 4 * 2 + 5 * 6  + 8 * 9 R2: -1 * 2 + 4 * 6 + 8 * 9 
	 */
	@Test
	void testNormalTimes() {
		List<Double> l1 = Arrays.asList(4.0, 5.0, 8.0, -1.0, 4.0, 6.0);
		List<Double> l2 = Arrays.asList(2.0, 6.0, 9.0);

		Matrix m1 = new Matrix(l1, 2, 3);
		Matrix m2 = new Matrix(l2, 3, 1);

		Matrix result = m1.times(m2);

		String expectedProduct = "110.0 \n" + "76.0 \n";
		assertEquals(expectedProduct, result.toString());
	}

}
