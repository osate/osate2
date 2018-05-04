package EAnalysis.BinPacking;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Avg {
	public static void main(String args[]) {
		if (args.length < 2) {
			System.out.println("Usage: Avg <output file> <input file list>");
			return;
		}

		String outFileName = args[0];

		try {
			boolean c2IsLong = true;
			boolean c1IsLong = true;
			long c1Long = 0;
			long c2Long = 0;
			double c2Double = 0.0;
			double c1Double = 0.0;
			int frequency = 0;

			for (int i = 1; i < args.length; i++) {
				System.out.print("Reading " + args[i]);
				BufferedReader reader = new BufferedReader(new FileReader(args[i]));
				String line;

				// Read until End of File
				while ((line = reader.readLine()) != null) {
					frequency++;
					StringTokenizer tokenizer = new StringTokenizer(line);
					String c1String = tokenizer.nextToken();
					try {
						c1Long += Long.parseLong(c1String);
						System.out.print(" long(" + c1Long + ") ");
					} catch (Exception castException) {
						c1IsLong = false;
						c1Double += Double.parseDouble(c1String);
						System.out.print(" double(" + c1Double + ") ");
					}

					String c2String = tokenizer.nextToken();

					try {
						c2Long += Long.parseLong(c2String);
						System.out.println(" long(" + c2Long + ")");
					} catch (Exception castException) {
						c2IsLong = false;
						c2Double += Double.parseDouble(c2String);
						System.out.println(" double(" + c2Double + ")");
					}

				}
			}

			String outLine = "";
			if (c1IsLong) {
				c1Long /= frequency;
				outLine += Long.toString(c1Long) + " ";
			} else {
				c1Double /= frequency;
				outLine += Double.toString(c1Double) + " ";
			}
			if (c2IsLong) {
				c2Long /= frequency;
				outLine += Long.toString(c2Long);
			} else {
				c2Double /= frequency;
				outLine += Double.toString(c2Double);
			}

			PrintWriter writer = new PrintWriter(new FileOutputStream(args[0]));
			writer.println(outLine);
			writer.close();
			System.out.println("Average: " + outLine + "\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}