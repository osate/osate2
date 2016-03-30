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

package org.osate.importer.lattix.ldmexporter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.osate.importer.model.Component;

public class LdmWriter {

	private static void writeHeader(Writer out) throws IOException {
		out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

		out.write("<lattix version=\"7.0\">\n");
		out.write(" <properties>\n");
		out.write("  <property name=\"lattix.project.xmlEncoding\" value=\"UTF-8\"/>\n");
		out.write("  <property name=\"lattix.project.useStringTableSaver\" value=\"false\"/>\n");
		out.write("  <property name=\"lattix.partition.homePartition\" value=\"true\"/>\n");
		out.write("  <property name=\"lattix.partition.cache.useWeakHashMaps\" value=\"true\"/>\n");
		out.write("  <property name=\"lattix.dependency.identityStyle\" value=\"none\"/>\n");
		out.write("  <property name=\"lattix.dependency.calcType\" value=\"class\"/>\n");
		out.write("  <property name=\"lattix.partition.flatPackage\" value=\"false\"/>\n");
		out.write("  <property name=\"lattix.partition.createFilePartition\" value=\"false\"/>\n");
		out.write("  <property name=\"lattix.partition.alg\" value=\"components\"/>\n");
		out.write("  <property name=\"lattix.partition.cache.storeEmptyDependencySets\" value=\"true\"/>\n");
		out.write("  <property name=\"lattix.project.name\" value=\"Project\"/>\n");
		out.write("  <property name=\"lattix.project.useAtomDB\" value=\"true\"/>\n");
		out.write(" </properties>\n");

	}

	private static void writeSources(Writer out, Collection<Component> entities) throws IOException {
		Iterator<Component> iter;
		out.write("<source>\n");
		out.write("  <sourceset id=\"lattix.plugin.manual\">\n");
		out.write(
				"  <file name=\"manual\" kind=\"manual\" date=\"31/12/1969 19:00:00\" dateadded=\"27/11/2012 20:24:53\" type=\"lattix.plugin.manual\" sourceIndex=\"0\">\n");

		iter = entities.iterator();
		while (iter.hasNext()) {
			Component e = iter.next();
			out.write("<base name=\"" + e.getAadlName() + "\" kind=\"manual\">\n");
			for (Component dest : e.getOutgoingDependencies()) {
				out.write("  <uses name=\"" + dest.getAadlName() + "\" kind=\"Manual\"/>\n");
			}
			out.write("</base>\n");
		}
		out.write("</file>\n");
		out.write("</sourceset>\n");
		out.write("</source>\n");

	}

	private static void writePartitions(Writer out, Collection<Component> entities) throws IOException {
		Iterator<Component> iter;
		out.write(" <partitions>\n");
		out.write("  <partition name=\"$root\" type=\"root\">\n");
		out.write("   <rule name=\"generic\">\n");
		out.write("   <access verb=\"can-use\" nametype=\"partition\" name=\"$root\"/>\n");
		out.write("  </rule>\n");

		iter = entities.iterator();
		while (iter.hasNext()) {
			Component e = iter.next();
			out.write("<partition name=\"" + e.getAadlName() + "\" type=\"leaf\">\n");
			out.write("  <atom name=\"" + e.getAadlName()
					+ "\" kind=\"manual\" sourceIndex=\"0\" comp=\"lattix.plugin.manual\">\n");
			out.write("     <property name=\"reason\" value=\"manual\"/>\n");
			out.write("  </atom>\n");
			out.write("</partition>\n");

		}
		out.write("</partition>\n");
		out.write("</partitions>\n");

	}

	private static void writeFooter(Writer out) throws IOException {
		out.write("</lattix>\n");
	}

	public static void writeFile(String fileName, Collection<Component> entities) throws Exception {

		FileWriter fstream = new FileWriter(fileName);
		BufferedWriter out = new BufferedWriter(fstream);
		writeHeader(out);
		writeSources(out, entities);
		writePartitions(out, entities);

		writeFooter(out);
		out.close();
		fstream.close();
	}
}
