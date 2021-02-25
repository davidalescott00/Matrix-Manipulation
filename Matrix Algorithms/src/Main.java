/* * 
 * Main method works as a workbench for testing efficiency of matrix object operations.
 * Works by iteratively creating larger square matrices and performing both plus and times
 * While recording timer. 
 * 
 * @author David Scott 
 * @date   <2/11/21> 
 * */

public class Main {
    
	/**
	 * Iteratively create larger square matrices with random doubles between 0 and 1.
	 * Call multiply and add methods.
	 * @param: Takes string array of arguments
	*/
    public static void main(String[] args) {
        
        for(int i = 1; i < 1001; i++) {
            Matrix matrix = Matrix.create(i, i);
            multiplyMatrices(matrix);
            addMatrices(matrix);
        }

    }
    
    /**
	 * Creates and uses timer to measure efficiency of the times operation on a matrix and itself.
	 * Reports results.
	 * @param: Takes square matrix to be multiplied by itself.
	*/
    private static void multiplyMatrices(Matrix matrix) {
        Timer timer = new Timer();
        timer.start();
        matrix.times(matrix);
        timer.stop();
        System.out.println("Multiply " + matrix.getSize() + ": " + timer.toString());
    }
    
    /**
   	 * Creates and uses timer to measure efficiency of the plus operation on a matrix and itself.
   	 * Reports results.
   	 * @param: Takes square matrix to be added by itself.
   	*/
    private static void addMatrices(Matrix matrix) {
        Timer timer = new Timer();
        timer.start();
        matrix.plus(matrix);
        timer.stop();
        System.out.println("Add " +matrix.getSize() + ": " + timer.toString());
    }
}