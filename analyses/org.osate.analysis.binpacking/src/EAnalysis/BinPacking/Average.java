package EAnalysis.BinPacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Average {
	public static void main(String args[]) {
		if (args.length != 3) {
			System.out.println("Usage: Average <output file> <prefix> <sufix>");
			return;
		}

		String outFileName = args[0];
		String prefix = args[1];
		String sufix = args[2];

		TreeMap samples = new TreeMap();
		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(outFileName));
			File dir = new File(".");
			String[] files = dir.list();
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i];

				if (!(fileName.startsWith(prefix) && fileName.endsWith(sufix)))
					continue;

				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				System.out.println("Reading filename(" + fileName + ")");
				String line;
				while ((line = reader.readLine()) != null) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					int index = Integer.parseInt(tokenizer.nextToken());
					double value = Double.parseDouble(tokenizer.nextToken());
					Integer savedIndex = new Integer(index);
					SampleRecord record = (SampleRecord) samples.get(savedIndex);
					if (record == null) {
						record = new SampleRecord(index, 0.0, 0);
						samples.put(savedIndex, record);
					}
					record.value += value;
					record.frequency++;
				}
			}
			for (Iterator iter = samples.entrySet().iterator(); iter.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				int index = ((Integer) entry.getKey()).intValue();
				SampleRecord record = (SampleRecord) entry.getValue();
				record.value = record.value / record.frequency;
				writer.println(index + " " + record.value);
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}