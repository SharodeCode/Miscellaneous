import java.math.BigInteger;

public class Dice {

	public static void main(String[] args) {
		
		int numOfDice = 2;
		int numToRoll = 7;
		int numOfFaces = 6;
		
		System.out.println("Number of Dice: " + numOfDice);
		System.out.println("Number to Roll: " + numToRoll);
		System.out.println("Number of Faces on each Die: " + numOfFaces);
		
		System.out.println(probability(numOfDice, numToRoll, numOfFaces));
	}
	
	static double probability(int numberOfDice, int valueToRoll, int numOfFaces) {
		double result = 0;
		
		double denominator = Math.pow(numOfFaces, numberOfDice);
		long numerator = ProbabilityOfNumber(valueToRoll, numberOfDice, numOfFaces).longValue();
		
		result = numerator/denominator;
		
		return result;
	}

	static BigInteger ProbabilityOfNumber(int p, int n, int s) {
		BigInteger result = BigInteger.valueOf(0);

		int kmax = (int) Math.floor((p - n) / s);

		for(int i = 0; i <= kmax; i++) {
			long sign = (long) Math.pow(-1, i);
			
			BigInteger first = permutation(n, i);
			
			int a = (p - (s * i) - 1);
			int b = (p - (s * i) - n);
			
			BigInteger second = permutation(a, b);

			result = result.add(first.multiply(second).multiply(BigInteger.valueOf(sign)));
		}

		return result;
	}
	
	static BigInteger permutation(int n, int k) {
		
		if(k == 0 || n==k) {
			return BigInteger.valueOf(1);
		}

		BigInteger nFactorial = factorial(n);
		BigInteger kFactorial = factorial(k);

		BigInteger nMinuskFactorial = factorial(n-k);

		return nFactorial.divide((kFactorial.multiply(nMinuskFactorial)));
	}

	static BigInteger factorial(int n) {
		BigInteger result = BigInteger.valueOf(n);

		for(int i = (n - 1); i > 1; i--) {
			result = result.multiply(BigInteger.valueOf(i));
		}

		return result;
	}

}
