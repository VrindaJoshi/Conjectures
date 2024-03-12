
public class GoldbachConjecture {
	
	static int dimensions = 20;

	static int[][] primeSumArray = new int[dimensions][dimensions];

	public static void main(String[] args) {

		fillHeaders();
		
		createSums();
		
		displayGrid();
		

	}

	private static void displayGrid() {
		
		for (int row = 0; row < dimensions; row++) {
		
			for (int index: primeSumArray[row]) {
				
				System.out.print(index);
				System.out.print("\t");
			
			}
			
			System.out.println();
				
		}
		
	}

	private static void createSums() {
		
		for (int row = 1; row < dimensions; row++) {
			
			for (int column = 1; column < dimensions; column++) {
				
				primeSumArray[row][column] = primeSumArray[row][0] + primeSumArray[0][column];
				
				if (primeSumArray[row][column]%2 != 0) {
					primeSumArray[row][column] = -1;
				}
				
			}
		}
		
	}

	private static void fillHeaders() {
		
		primeSumArray[0][0] = 0;
		
		boolean filled;
		
		// rows
		for (int index = 1; index < dimensions; index++) {
						
			filled = false;
			
			int potentialPrime = primeSumArray[index-1][0]+1;
						
			// get next prime
			while (!filled) {
				
				if(checkPrime(potentialPrime)) {
					primeSumArray[index][0] = potentialPrime;
					filled = true;
				} else {
					potentialPrime++;
				}
			}
			
		}
		
		// columns
		for (int index = 1; index < dimensions; index++) {
			primeSumArray[0][index] = primeSumArray[index][0];
		}
		
	}

	// check if a number is prime
	private static boolean checkPrime(long i) {

		// set number of factors to 0
		int numFactors = 0;

		for (int index = 1; index <= i; index++) {

			// if index is a factor
			if (i % index == 0) {

				numFactors++;

				// if not prime
				if (numFactors > 2)

					break;
			}
		}

		// if prime
		if (numFactors == 2)
			return true;
		else
			return false;

	}
}
