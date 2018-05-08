/*
 * Copyright 2013 Carnegie Mellon University
 * 
 * The AADL/DSM Bridge (org.osate.importer.lattix ) (the �Content� or �Material�) 
 * is based upon work funded and supported by the Department of Defense under 
 * Contract No. FA8721-05-C-0003 with Carnegie Mellon University for the operation 
 * of the Software Engineering Institute, a federally funded research and development 
 * center.

 * Any opinions, findings and conclusions or recommendations expressed in this 
 * Material are those of the author(s) and do not necessarily reflect the 
 * views of the United States Department of Defense. 

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING 
 * INSTITUTE MATERIAL IS FURNISHED ON AN �AS-IS� BASIS. CARNEGIE MELLON 
 * UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, 
 * AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR 
 * PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF 
 * THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF 
 * ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
 * INFRINGEMENT.
 * 
 * This Material has been approved for public release and unlimited 
 * distribution except as restricted below. 
 * 
 * This Material is provided to you under the terms and conditions of the 
 * Eclipse Public License Version 1.0 ("EPL"). A copy of the EPL is 
 * provided with this Content and is also available at 
 * http://www.eclipse.org/legal/epl-v10.html.
 * 
 * Carnegie Mellon� is registered in the U.S. Patent and Trademark 
 * Office by Carnegie Mellon University. 
 * 
 * DM-0000232
 * 
 */

package org.osate.importer.lattix.ldmimporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.osate.aadl2.util.OsateDebug;
import org.osate.importer.lattix.common.Matrix;
import org.osate.importer.model.Component;

public class AadlProjectCreator {

	public static void createDirectories(String outputPath) {
		String outputPathFunctional;
		String outputPathRuntime;
		File ftmp;

		outputPathFunctional = outputPath + File.separatorChar + "functional";
		outputPathRuntime = outputPath + File.separatorChar + "runtime";

		ftmp = new File(outputPathFunctional);

		if (ftmp.exists() && ftmp.isFile()) {
			OsateDebug.osateDebug("Error, the following path is a file" + outputPathFunctional);
		}

		if (!ftmp.exists()) {
			ftmp.mkdir();
		}

		ftmp = new File(outputPathRuntime);

		if (ftmp.exists() && ftmp.isFile()) {
			OsateDebug.osateDebug("Error, the following path is a file" + outputPathRuntime);
		}

		if (!ftmp.exists()) {
			ftmp.mkdir();
		}
	}

	public static void createAadlFunctions(String outputFile, Matrix matrix) {
		FileWriter fstream;
		BufferedWriter out;

		try {
			fstream = new FileWriter(outputFile);
			out = new BufferedWriter(fstream);

			out.write("package imported::functions\n");

			out.write("public\n");

			out.write("with SEI;\n");
			out.write("with ARINC653;\n");

			for (Component e : matrix.getModules()) {
				out.write("abstract " + e.getAadlName() + "\n");
				if ((e.getIncomingDependencies().size() > 0) || (e.getOutgoingDependencies().size() > 0)) {
					out.write("features\n");
					for (Component e2 : e.getIncomingDependencies()) {
						out.write("   from_" + e2.getAadlName() + " : in event port;\n");
					}
					for (Component e2 : e.getOutgoingDependencies()) {
						out.write("   to_" + e2.getAadlName() + " : out event port;\n");
					}
				}
				out.write("properties\n");
				out.write("   SEI::nsloc => 100;\n");
				out.write("end " + e.getAadlName() + ";\n");
			}

			out.write("end imported::functions;\n");

			out.close();
			fstream.close();

		} catch (Exception e) {
			OsateDebug.osateDebug("Error: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void createProject(String outputPath, Matrix matrix) {
		String outputPathFunctional;
		String outputPathRuntime;
		String outputFileFunctional;

		outputPathFunctional = outputPath + File.separatorChar + "functional";
		outputPathRuntime = outputPath + File.separatorChar + "runtime";
		outputFileFunctional = outputPathFunctional + File.separatorChar + "functional.aadl";

		createDirectories(outputPath);

//		OsateDebug.osateDebug ("Create AADL functional project in " + outputFileFunctional);
		createAadlFunctions(outputFileFunctional, matrix);

	}

}
