package EAnalysis.BinPacking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class MacroPreprocessor {
	public class MacroEntry {
		public String macroName;

		public String macroSubstitution;

		public MacroEntry(String n, String s) {
			macroName = n;
			macroSubstitution = s;
		}
	}

	MacroEntry[] macros;

	public void loadMacros(File file) {
		Vector v = new Vector();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;

			while ((line = reader.readLine()) != null) {
				if (line.indexOf("@define") != -1) {
					StringTokenizer tokenizer = new StringTokenizer(line);
					String macroName = null;
					String macroSubstitution = null;
					String token = null;
					String define = null;
					while (tokenizer.hasMoreTokens()
							&& (define == null || macroName == null || macroSubstitution == null)) {
						token = tokenizer.nextToken();
						if (define == null) {
							if (token.indexOf("@define") != -1)
								define = token;
						} else if (macroName == null)
							macroName = token;
						else
							macroSubstitution = token;
					}
					v.add(new MacroEntry(macroName, macroSubstitution));
				}
			}
			macros = new MacroEntry[v.size()];
			for (int i = 0; i < v.size(); i++) {
				macros[i] = (MacroEntry) v.get(i);
				System.out.println(
						"Macro name(" + macros[i].macroName + ") substitution(" + macros[i].macroSubstitution + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void substituteMacrosInFile(File file) {
		try {
			File temp = File.createTempFile("TMP", "MPP");
			PrintWriter writer = new PrintWriter(new FileOutputStream(temp));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < macros.length; i++) {
					System.out.println("\t Testing macro[name(" + macros[i].macroName + ") substitition("
							+ macros[i].macroSubstitution + ")]");
					int start = 0;
					int searchStart = 0;
					String newLine;
					while ((searchStart < line.length())
							&& (start = line.indexOf(macros[i].macroName, searchStart)) != -1) {
						newLine = line.substring(searchStart, start - 1);
						newLine += macros[i].macroSubstitution;
						searchStart = newLine.length() - 1;
						newLine += line.substring(start, line.length() - 1);
						line = newLine;
						System.out.println("searchStart(" + searchStart + ")");
					}
					System.out.println("new Line(" + line + ")");
				}
				writer.println(line);
			}
			writer.close();
			reader.close();
			String fname = file.getAbsolutePath();
			file.renameTo(new File("tmp.old"));
			temp.renameTo(new File(fname));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		MacroPreprocessor preprocessor = new MacroPreprocessor();
		if (args.length < 2) {
			System.out.println("Usage MacroPreprocessor <macrofile> <files>");
			return;
		}

		preprocessor.loadMacros(new File(args[0]));
		for (int i = 1; i < args.length; i++) {
			preprocessor.substituteMacrosInFile(new File(args[i]));
		}
	}
}