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

package org.osate.importer.lattix.vdid;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LdmGenerator {

	public static void writeMatrix(String path, List<String> comps, HashMap<String, List<String>> deps)
			throws IOException {
		FileWriter fw = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		bw.write("\n");
		bw.write("<lattix version=\"6.0\">\n");
		bw.write("<properties>\n");
		bw.write("<property name=\"lattix.dependency.calcType\" value=\"class\"/>\n");
		bw.write("<property name=\"lattix.dependency.identityStyle\" value=\"percent\"/>\n");
		bw.write("<property name=\"lattix.project.name\" value=\"test\"/>\n");
		bw.write("<property name=\"lattix.project.plugins\" value=\"lattix.plugin.java\"/>\n");
		bw.write("</properties>\n");
		bw.write("<source>\n");
		bw.write("<sourceset id=\"lattix.plugin.manual\">\n");
		bw.write(
				"<file name=\"manual\" kind=\"manual\" date=\"31/12/1969 19:00:00\" dateadded=\"12/11/2012 13:04:47\" type=\"lattix.plugin.manual\">\n");
		for (String s : comps) {
			bw.write("<base name=\"$root." + s + "\" kind=\"manual\">\n");
			List<String> ltmp = deps.get(s);
			if (ltmp != null) {
				for (String tmp : ltmp) {
					bw.write("<uses name=\"$root." + tmp + "\" kind=\"Manual\"/>\n)");

				}
			}
			bw.write("</base>\n");
		}

		bw.write("</file>\n");
		bw.write("</sourceset>\n");
		bw.write("<sourceset id=\"lattix.plugin.java\">\n");
		bw.write("<properties>\n");
		bw.write("<property name=\"lattix.plugin.java.ignoreDupAtoms\" value=\"true\"/>\n");
		bw.write("<property name=\"lattix.plugin.java.memberDependencies\" value=\"all\"/>\n");
		bw.write("<property name=\"lattix.plugin.java.ext\" value=\"jar\"/>\n");
		bw.write(
				"<property name=\"lattix.plugin.java.defaultRules\" value=\"source=$root,access=can-use,target=java.**;source=$root,access=can-use,target=javax.**;source=$root,access=can-use,target=org.xml.sax.**;source=$root,access=can-use,target=org.w3c.dom.**\"/>\n");
		bw.write("<property name=\"lattix.plugin.java.dependency_line_numbers\" value=\"true\"/>\n");
		bw.write("<property name=\"lattix.plugin.java.memberProcessing\" value=\"none\"/>\n");
		bw.write("</properties>\n");
		bw.write("<comp>\n");
		bw.write("<atomKinds>\n");
		bw.write(
				"<atomKind id=\"CLASS\" name=\"PluginJavaKindClass\" supportsDependencies=\"true\" supportsMembers=\"true\" isMember=\"false\" imageName=\"class.gif\">\n");
		bw.write("<atomPropDefs>\n");
		bw.write(
				"<atomPropDef id=\"visibility\" name=\"PluginJavaAtomPropVisibility\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"sourcefile\" name=\"PluginJavaAtomPropSourceFile\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"revision\" name=\"PluginJavaAtomPropSourceRevision\" decimalPrecision=\"3\" type=\"2\" flags=\"0\"/>\n");
		bw.write(
				"<atomPropDef id=\"final\" name=\"PluginJavaAtomPropFinal\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"abstract\" name=\"PluginJavaAtomPropAbstract\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"codesize\" name=\"PluginJavaAtomPropCodeSize\" decimalPrecision=\"0\" type=\"3\" flags=\"3\" formatResString=\"PluginJavaAtomPropCodeSizeFormat\"/>\n");
		bw.write("</atomPropDefs>\n");
		bw.write("</atomKind>\n");
		bw.write(
				"<atomKind id=\"INTERFACE\" name=\"PluginJavaKindInterface\" supportsDependencies=\"true\" supportsMembers=\"true\" isMember=\"false\" imageName=\"interface.gif\">\n");
		bw.write("<atomPropDefs>\n");
		bw.write(
				"<atomPropDef id=\"visibility\" name=\"PluginJavaAtomPropVisibility\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"sourcefile\" name=\"PluginJavaAtomPropSourceFile\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"revision\" name=\"PluginJavaAtomPropSourceRevision\" decimalPrecision=\"3\" type=\"2\" flags=\"0\"/>\n");
		bw.write(
				"<atomPropDef id=\"codesize\" name=\"PluginJavaAtomPropCodeSize\" decimalPrecision=\"0\" type=\"3\" flags=\"3\" formatResString=\"PluginJavaAtomPropCodeSizeFormat\"/>\n");
		bw.write("</atomPropDefs>\n");
		bw.write("</atomKind>\n");
		bw.write(
				"<atomKind id=\"CLASS.METHOD\" name=\"PluginJavaKindMethod\" supportsDependencies=\"true\" supportsMembers=\"false\" isMember=\"true\" imageName=\"method.gif\">\n");
		bw.write("<atomPropDefs>\n");
		bw.write(
				"<atomPropDef id=\"visibility\" name=\"PluginJavaAtomPropVisibility\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"static\" name=\"PluginJavaAtomPropStatic\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"abstract\" name=\"PluginJavaAtomPropAbstract\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"synchronized\" name=\"PluginJavaAtomPropSynchronized\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"final\" name=\"PluginJavaAtomPropFinal\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write("</atomPropDefs>\n");
		bw.write("</atomKind>\n");
		bw.write(
				"<atomKind id=\"INTERFACE.METHOD\" name=\"PluginJavaKindMethod\" supportsDependencies=\"true\" supportsMembers=\"false\" isMember=\"true\" imageName=\"method.gif\">\n");
		bw.write("<atomPropDefs>\n");
		bw.write(
				"<atomPropDef id=\"visibility\" name=\"PluginJavaAtomPropVisibility\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"static\" name=\"PluginJavaAtomPropStatic\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"abstract\" name=\"PluginJavaAtomPropAbstract\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"synchronized\" name=\"PluginJavaAtomPropSynchronized\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"final\" name=\"PluginJavaAtomPropFinal\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write("</atomPropDefs>\n");
		bw.write("</atomKind>\n");
		bw.write(
				"<atomKind id=\"CLASS.FIELD\" name=\"PluginJavaKindField\" supportsDependencies=\"true\" supportsMembers=\"false\" isMember=\"true\" imageName=\"field.gif\">\n");
		bw.write("<atomPropDefs>\n");
		bw.write(
				"<atomPropDef id=\"visibility\" name=\"PluginJavaAtomPropVisibility\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"static\" name=\"PluginJavaAtomPropStatic\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"final\" name=\"PluginJavaAtomPropFinal\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write("</atomPropDefs>\n");
		bw.write("</atomKind>\n");
		bw.write(
				"<atomKind id=\"INTERFACE.FIELD\" name=\"PluginJavaKindField\" supportsDependencies=\"true\" supportsMembers=\"false\" isMember=\"true\" imageName=\"field.gif\">\n");
		bw.write("<atomPropDefs>\n");
		bw.write(
				"<atomPropDef id=\"visibility\" name=\"PluginJavaAtomPropVisibility\" decimalPrecision=\"3\" type=\"2\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"static\" name=\"PluginJavaAtomPropStatic\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write(
				"<atomPropDef id=\"final\" name=\"PluginJavaAtomPropFinal\" decimalPrecision=\"3\" type=\"1\" flags=\"4\"/>\n");
		bw.write("</atomPropDefs>\n");
		bw.write("</atomKind>\n");
		bw.write("</atomKinds>\n");
		bw.write("<depKinds>\n");
		bw.write("<depKind id=\"2\" name=\"DependencyKindClassRef\"/>\n");
		bw.write("<depKind id=\"3\" name=\"DependencyKindInvokes\"/>\n");
		bw.write("<depKind id=\"4\" name=\"DependencyKindInherits\"/>\n");
		bw.write("<depKind id=\"5\" name=\"DependencyKindDataMemeberRef\"/>\n");
		bw.write("<depKind id=\"6\" name=\"DependencyKindConstructs\"/>\n");
		bw.write("<depKind id=\"7\" name=\"DependencyKindAnnotation\"/>\n");
		bw.write("<depKind id=\"3.1\" name=\"JavaDependencyKindInvokesVirtual\"/>\n");
		bw.write("<depKind id=\"3.2\" name=\"JavaDependencyKindInvokesStatic\"/>\n");
		bw.write("<depKind id=\"3.3\" name=\"JavaDependencyKindInvokesInterface\"/>\n");
		bw.write("<depKind id=\"4.1\" name=\"JavaDependencyKindExtends\"/>\n");
		bw.write("<depKind id=\"4.2\" name=\"JavaDependencyKindImplements\"/>\n");
		bw.write("<depKind id=\"6.1\" name=\"JavaDependencyKindConstructNull\"/>\n");
		bw.write("<depKind id=\"6.2\" name=\"JavaDependencyKindConstructArgs\"/>\n");
		bw.write("<depKind id=\"7.1\" name=\"JavaDependencyKindAnnotationRuntimeVisible\"/>\n");
		bw.write("<depKind id=\"7.2\" name=\"JavaDependencyKindAnnotationRuntimeInvisible\"/>\n");
		bw.write("</depKinds>\n");
		bw.write("</comp>\n");
		bw.write(
				"<file name=\"C:UsersjdelangeDesktop[*.jar]\" kind=\"file\" relative-path=\".\" date=\"31/12/1969 19:00:00\" dateadded=\"12/11/2012 13:13:25\" origdate=\"09/11/2012 12:13:55\" type=\"lattix.plugin.java\"/>\n");
		bw.write("</sourceset>\n");
		bw.write("</source>\n");
		bw.write("<partitions>\n");
		bw.write("<partition name=\"$root\" type=\"root\">\n");
		bw.write("<rule name=\"generic\">\n");
		bw.write("<access verb=\"can-use\" nametype=\"partition\" name=\"$root\"/>\n");
		bw.write("<access verb=\"can-use\" nametype=\"language\" name=\"java.**\"/>\n");
		bw.write("<access verb=\"can-use\" nametype=\"language\" name=\"javax.**\"/>\n");
		bw.write("<access verb=\"can-use\" nametype=\"language\" name=\"org.xml.sax.**\"/>\n");
		bw.write("<access verb=\"can-use\" nametype=\"language\" name=\"org.w3c.dom.**\"/>\n");
		bw.write("</rule>\n");

		for (String s : comps) {
			bw.write("<partition name=\"" + s + "\" type=\"leaf\">\n");
			bw.write("<atom name=\"$root." + s
					+ "\" kind=\"manual\" sourceIndex=\"0\" comp=\"lattix.plugin.manual\">\n");
			bw.write("<property name=\"reason\" value=\"manual\"/>\n");
			bw.write("</atom>\n");
			bw.write("</partition>\n");/*
										 * List<String> ltmp = deps.get(s);
										 * if (ltmp != null)
										 * {
										 * for (String tmp : ltmp)
										 * {
										 * bw.write ("<rule name=\"rule\">\n");
										 * bw.write ("<access verb=\"can-use\" nametype=\"partition\" name=\"$root/"+tmp+"\"/>\n");
										 * bw.write ("</rule>\n");
										 * }
										 * }
										 */
		}

		bw.write("</partition>\n");
		bw.write("</partitions>\n");
		bw.write("<workitems>\n");

		for (String s : comps) {
			List<String> ltmp = deps.get(s);
			if (ltmp != null) {
				for (String tmp : ltmp) {
					bw.write("<workitem name=\"Create Manual Dependency\" type=\"createDependency\" priority=\"0\">\n");
					bw.write("<data>\n");
					bw.write("<dependency strength=\"1\" compid=\"lattix.plugin.manual\" kind=\"Manual\" name=\"" + s
							+ "\" isNew=\"true\">\n");
					bw.write("<sourcePart>\n");
					bw.write("<partitionref name=\"$root/" + tmp + "\"/>\n");
					bw.write("</sourcePart>\n");
					bw.write("<targetPart>\n");
					bw.write("<partitionref name=\"$root/" + s + "\"/>\n");
					bw.write("</targetPart>\n");
					bw.write("<sourceAtom name=\"$root." + s
							+ "\" isNew=\"true\" addAtomToPart=\"true\" kind=\"manual\"/>\n");
					bw.write("<targetAtom name=\"$root." + tmp
							+ "\" isNew=\"true\" addAtomToPart=\"true\" kind=\"manual\"/>\n");
					bw.write("</dependency>\n");
					bw.write("</data>\n");
					bw.write("</workitem>\n");
				}
			}
		}

		bw.write("<partitions>\n");
		bw.write("<workitem index=\"0\">\n");
		bw.write("<partition id=\"0\">\n");
		bw.write("<partition name=\"wef\" type=\"leaf\"/>\n");
		bw.write("</partition>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem index=\"1\">\n");
		bw.write("<partition id=\"0\">\n");
		bw.write("<partition name=\"s2\" type=\"leaf\"/>\n");
		bw.write("</partition>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem index=\"4\">\n");
		bw.write("<partition id=\"0\">\n");
		bw.write("<partition name=\"s2\" type=\"leaf\"/>\n");
		bw.write("</partition>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem index=\"10\">\n");
		bw.write("<partition id=\"0\">\n");
		bw.write("<partition name=\"wef\" type=\"leaf\"/>\n");
		bw.write("</partition>\n");
		bw.write("</workitem>\n");
		bw.write("</partitions>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"createSubsystem\" priority=\"0\">\n");
		bw.write("<data index=\"0\">\n");
		bw.write("<parentPartition>\n");
		bw.write("<partitionref name=\"$root\"/>\n");
		bw.write("</parentPartition>\n");
		bw.write("<data name=\"wef\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref workItemIndex=\"0\" name=\"0\"/>\n");
		bw.write("</partition>\n");
		bw.write("</data>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"createSubsystem\" priority=\"0\">\n");
		bw.write("<data index=\"1\">\n");
		bw.write("<parentPartition>\n");
		bw.write("<partitionref name=\"$root\"/>\n");
		bw.write("</parentPartition>\n");
		bw.write("<data name=\"s2\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref workItemIndex=\"1\" name=\"0\"/>\n");
		bw.write("</partition>\n");
		bw.write("</data>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"createSubsystem\" priority=\"0\">\n");
		bw.write("<data index=\"2\">\n");
		bw.write("<parentPartition>\n");
		bw.write("<partitionref name=\"$root\"/>\n");
		bw.write("</parentPartition>\n");
		bw.write("<data name=\"s3\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref name=\"$root/s3\"/>\n");
		bw.write("</partition>\n");
		bw.write("</data>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"createSubsystem\" priority=\"0\">\n");
		bw.write("<data index=\"3\">\n");
		bw.write("<parentPartition>\n");
		bw.write("<partitionref name=\"$root\"/>\n");
		bw.write("</parentPartition>\n");
		bw.write("<data name=\"s1\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref name=\"$root/s1\"/>\n");
		bw.write("</partition>\n");
		bw.write("</data>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Delete Subsystem\" type=\"deleteSubsystem\" priority=\"0\">\n");
		bw.write("<data retainChildren=\"false\">\n");
		bw.write("<delete index=\"1\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref workItemIndex=\"1\" name=\"0\"/>\n");
		bw.write("</partition>\n");
		bw.write("<parent>\n");
		bw.write("<partitionref name=\"$root\"/>\n");
		bw.write("</parent>\n");
		bw.write("</delete>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"createSubsystem\" priority=\"0\">\n");
		bw.write("<data index=\"2\">\n");
		bw.write("<parentPartition>\n");
		bw.write("<partitionref name=\"$root\"/>\n");
		bw.write("</parentPartition>\n");
		bw.write("<data name=\"4\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref name=\"$root/s2\"/>\n");
		bw.write("</partition>\n");
		bw.write("</data>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"createSubsystem\" priority=\"0\">\n");
		bw.write("<data index=\"0\">\n");
		bw.write("<parentPartition>\n");
		bw.write("<partitionref name=\"$root/s3\"/>\n");
		bw.write("</parentPartition>\n");
		bw.write("<data name=\"hg\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref name=\"$root/s3/s3sub\"/>\n");
		bw.write("</partition>\n");
		bw.write("</data>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Create Manual Dependency\" type=\"createDependency\" priority=\"0\">\n");
		bw.write("<data>\n");
		bw.write(
				"<dependency strength=\"1\" compid=\"lattix.plugin.manual\" kind=\"Manual\" name=\"s1\" isNew=\"true\">\n");
		bw.write("<sourcePart>\n");
		bw.write("<partitionref name=\"$root/s2\"/>\n");
		bw.write("</sourcePart>\n");
		bw.write("<targetPart>\n");
		bw.write("<partitionref name=\"$root/s1\"/>\n");
		bw.write("</targetPart>\n");
		bw.write("<sourceAtom name=\"$root.4\" isNew=\"true\" addAtomToPart=\"true\" kind=\"manual\"/>\n");
		bw.write("<targetAtom name=\"$root.s1\" isNew=\"true\" addAtomToPart=\"true\" kind=\"manual\"/>\n");
		bw.write("</dependency>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"editSubsystem\" priority=\"0\">\n");
		bw.write("<data>\n");
		bw.write("<namedelta value=\"s2\" oldValue=\"4\"/>\n");
		bw.write("<partitionData>\n");
		bw.write("<partition>\n");
		bw.write("<partitionref name=\"$root/s2\"/>\n");
		bw.write("</partition>\n");
		bw.write("</partitionData>\n");
		bw.write("<atom>\n");
		bw.write("<atomname value=\"s2\" oldValue=\"$root.4\"/>\n");
		bw.write("<atomkind value=\"manual\" state=\"same\"/>\n");
		bw.write("</atom>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Create Manual Dependency\" type=\"createDependency\" priority=\"0\">\n");
		bw.write("<data>\n");
		bw.write(
				"<dependency strength=\"2\" compid=\"lattix.plugin.manual\" kind=\"Manual\" name=\"s3\" isNew=\"true\">\n");
		bw.write("<sourcePart>\n");
		bw.write("<partitionref name=\"$root/s2\"/>\n");
		bw.write("</sourcePart>\n");
		bw.write("<targetPart>\n");
		bw.write("<partitionref name=\"$root/s3\"/>\n");
		bw.write("</targetPart>\n");
		bw.write("<sourceAtom name=\"s2\" isNew=\"false\" addAtomToPart=\"false\" kind=\"manual\"/>\n");
		bw.write("<targetAtom name=\"$root.s3\" isNew=\"true\" addAtomToPart=\"true\" kind=\"manual\"/>\n");
		bw.write("</dependency>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Delete Subsystem\" type=\"deleteSubsystem\" priority=\"0\">\n");
		bw.write("<data retainChildren=\"false\">\n");
		bw.write("<delete index=\"0\">\n");
		bw.write("<partition>\n");
		bw.write("<partitionref workItemIndex=\"0\" name=\"0\"/>\n");
		bw.write("</partition>\n");
		bw.write("<parent>\n");
		bw.write("<partitionref name=\"$root\"/>\n");
		bw.write("</parent>\n");
		bw.write("</delete>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("<workitem name=\"Edit Subsystem\" type=\"editSubsystem\" priority=\"0\">\n");
		bw.write("<data>\n");
		bw.write("<nameDelta value=\"s3sub\" oldValue=\"hg\"/>\n");
		bw.write("<partitionData>\n");
		bw.write("<partition>\n");
		bw.write("<partitionref name=\"$root/s3/s3sub\"/>\n");
		bw.write("</partition>\n");
		bw.write("</partitionData>\n");
		bw.write("</data>\n");
		bw.write("</workitem>\n");
		bw.write("</workitems>\n");
		bw.write("<workspace>\n");
		bw.write("<properties>\n");
		bw.write("<property name=\"lattix.workspace.activeViewIndex\" value=\"0\"/>\n");
		bw.write("</properties>\n");
		bw.write("<views>\n");
		bw.write("<view name=\"$root\" type=\"grid\">\n");
		bw.write("<rootpartition name=\"$root\"/>\n");
		bw.write("<properties>\n");
		bw.write("<property name=\"lattix.view.closable\" value=\"false\"/>\n");
		bw.write("<property name=\"lattix.display.rowSize\" value=\"122\"/>\n");
		bw.write("<property name=\"lattix.view.state\">\n");
		bw.write("<property name=\"$root\">\n");
		bw.write("<property name=\"expanded\" value=\"true\"/>\n");
		bw.write("</property>\n");
		bw.write("</property>\n");
		bw.write("<property name=\"lattix.view.zoomValue\" value=\"100%\"/>\n");
		bw.write("<property name=\"lattix.view.context.sourceSelection\">\n");
		bw.write("<value>$root/s3/s3sub</value>\n");
		bw.write("</property>\n");
		bw.write("<property name=\"lattix.view.context.targetSelection\">\n");
		bw.write("<value>$root/s3/s3sub</value>\n");
		bw.write("</property>\n");
		bw.write("</properties>\n");
		bw.write("</view>\n");
		bw.write("</views>\n");
		bw.write("</workspace>\n");
		bw.write("</lattix>\n");
		bw.close();
		fw.close();
	}
}