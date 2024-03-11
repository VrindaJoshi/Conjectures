
public class TwinPrimesConjecture {

	static int numTwinPrimes = 0;
	static long loopNum;

	public static void main(String[] args) {

		// for every number up until
		for (loopNum = 1; loopNum < 100000000; loopNum++) { // this program calculates the # of twin primes up until
															// 100000000
			checkTwins(loopNum);
		}

	}

	// check if a number is a twin prime
	private static void checkTwins(long num) {

		// if the number is a prime
		if (checkPrime(num)) {
			
			// add two to loop number
			loopNum+=2;

			// if the number 2 more is also prime
			if (checkPrime(num + 2)) {
				

				// add 1 to the number of twin primes
				numTwinPrimes++;

				// print running total
				System.out.println(numTwinPrimes);

				// check if the larger number is part of another pair
				checkTwins(num + 2);
			}

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
