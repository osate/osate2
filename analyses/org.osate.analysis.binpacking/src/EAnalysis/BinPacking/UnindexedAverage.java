package EAnalysis.BinPacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnindexedAverage {
	public static void main(String args[]) {
		if (args.length != 4) {
			System.out.println("Usage: UnindexedAverage <output file> <prefix> <sufix> <#columns>");
			return;
		}

		String outFileName = args[0];
		String prefix = args[1];
		String sufix = args[2];
		int numCols = Integer.parseInt(args[3]);

		SampleRecord[] average = new SampleRecord[numCols];
		for (int k = 0; k < numCols; k++)
			average[k] = new SampleRecord(0, 0.0, 0);
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(outFileName));
			File dir = new File(".");
			String[] files = dir.list();
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i]; // prefix+Integer.toString(i)+sufix;

				if (!(fileName.startsWith(prefix) && fileName.endsWith(sufix)))
					continue;

				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				System.out.println("Reading filename(" + fileName + ")");
				String line;
				while ((line = reader.readLine()) != null) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					for (int j = 0; j < numCols; j++) {
						average[j].value = Double.parseDouble(tokenizer.nextToken());
						average[j].frequency++;
					}
				}
			}
			for (int j = 0; j < numCols; j++) {
				average[j].value /= average[j].frequency;
				writer.print(average[j].value + " ");
			}
			writer.println(" ");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}