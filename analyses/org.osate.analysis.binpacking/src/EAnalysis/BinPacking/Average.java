/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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