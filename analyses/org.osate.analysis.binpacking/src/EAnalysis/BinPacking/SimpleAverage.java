package EAnalysis.BinPacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SimpleAverage {
	public static void main(String args[]) {
		if (args.length != 2) {
			System.out.println("Usage: SimpleAverage <output file> <filename-regex>");
			return;
		}

		String outFileName = args[0];
		String regex = args[1];

		TreeMap samples = new TreeMap();
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(outFileName));
			File dir = new File(".");
			String[] files = dir.list();
			double col1 = 0.0;
			double col2 = 0.0;
			long frequency = 0;
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i]; // prefix+Integer.toString(i)+sufix;

				if (!fileName.matches(regex))
					continue;

				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				System.out.println("Reading filename(" + fileName + ")");
				String line;
				while ((line = reader.readLine()) != null) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					double c1 = Double.parseDouble(tokenizer.nextToken());
					double c2 = Double.parseDouble(tokenizer.nextToken());
					frequency++;
					if (Double.isNaN(c1) || Double.isNaN(c2))
						continue;
					col1 += c1;
					col2 += c2;
				}
			}
			col1 = col1 / frequency;
			col2 = col2 / frequency;
			writer.println(col1 + " " + col2);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}