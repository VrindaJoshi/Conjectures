import java.util.Scanner;

public class CollatzConjecture {

	public static void main(String[] args) {

		long number, modifiedNumber;
		int terms = 0;
		Scanner input = new Scanner(System.in);

		// get number
		System.out.println("enter any positive integer:");
		number = input.nextInt();

		modifiedNumber = number;

		// calculations
		while (modifiedNumber != 1) {
			terms++;
			if (modifiedNumber % 2 == 0)
				modifiedNumber /= 2;
			else if (modifiedNumber % 2 == 1)
				modifiedNumber = modifiedNumber * 3 + 1;
		}

		// output results
		System.out.printf("it took %d terms for %d to reach 1", terms, number);
	}

}
