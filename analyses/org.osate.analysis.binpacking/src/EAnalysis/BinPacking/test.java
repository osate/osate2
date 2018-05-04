package EAnalysis.BinPacking;

public class test {
	public static void main(String args[]) {
		long[] moduleSizes = new long[1000];
		int numSize = 0;

		long procSize = 4000000000l;
		long nextSize = procSize / 2;
		long difference = (procSize / 4) - 1;
		while (((procSize % difference) == 0) && ((procSize % (nextSize - difference)) == 0))
			difference--;
		moduleSizes[0] = (procSize / 2) - difference;
		while (difference > 20) {
			long nextDifference = (difference / 2) - 1;
			while (((procSize % nextDifference) == 0) && ((procSize % (difference - nextDifference)) == 0))
				nextDifference--;
			moduleSizes[++numSize] = difference - nextDifference;
			difference = nextDifference;
		}

		nextSize = difference;
		while (nextSize > 1) {
			nextSize = 0;
			while ((procSize % difference) == 0) {
				difference--;
				nextSize++;
			}
			moduleSizes[++numSize] = difference;
		}
		if (nextSize != 0)
			moduleSizes[++numSize] = nextSize;

		System.out.println("Sizes");
		long sum = 0;
		for (int i = 0; i <= numSize; i++) {
			System.out.println("\t size[" + i + "] = " + moduleSizes[i]);
			sum += moduleSizes[i];
		}
		System.out.println("sum(" + sum + ") sum*2(" + (sum * 2) + ")");
	}
}