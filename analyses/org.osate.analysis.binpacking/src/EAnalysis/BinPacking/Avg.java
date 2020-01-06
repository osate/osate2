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