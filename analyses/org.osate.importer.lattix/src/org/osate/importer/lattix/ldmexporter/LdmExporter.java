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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.impl.SubprogramCallImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.importer.model.Component;
import org.osate.importer.model.Connection;

public class LdmExporter {
	/*
	 * public static void searchProcesses (ComponentInstance ci, HashMap<ComponentInstance,Entity> listProcesses)
	 * {
	 * ComponentInstance p;
	 * 
	 * for (Element e : ci.getChildren())
	 * {
	 * if ((e instanceof ComponentInstance) &&
	 * (((ComponentInstance)e).getCategory() == ComponentCategory.PROCESS) &&
	 * ( ! listProcesses.containsKey(e)))
	 * {
	 * p = (ComponentInstance)e;
	 * listProcesses.put(p, new Entity(normalizeName(p)));
	 * }
	 * }
	 * }
	 */

	public static void searchSubprograms(SubprogramType ci, HashMap<String, Component> listComponents) {
		if (!listComponents.containsKey(ci)) {

			listComponents.put(normalizeName(ci), new Component(normalizeName(ci)));

		}
	}

	public static void searchSubprograms(SubprogramImplementation ci, HashMap<String, Component> listComponents) {
		System.out.println("SubprogramImplementation" + ci);
	}

	public static void searchSubprograms(ComponentInstance ci, HashMap<String, Component> listComponents) {
		ComponentInstance c;
		// System.out.println ("[LdmExporter] search for subprogram in " + ci.getName() + "|" + ci);
		for (Element e : ci.getChildren()) {
			if (e instanceof ComponentInstance) {
				c = (ComponentInstance) e;

				if (c.getCategory() == ComponentCategory.THREAD) {
					if (c.getComponentClassifier() instanceof ThreadImplementation) {
						ThreadImplementation ti = (ThreadImplementation) c.getComponentClassifier();

						for (SubprogramCall cs : ti.getSubprogramCalls()) {
							if (!(cs instanceof SubprogramCallImpl)) {
								continue;
							}

							SubprogramCallImpl sci = (SubprogramCallImpl) cs;

							if (sci.getCalledSubprogram() instanceof SubprogramType) {
								searchSubprograms((SubprogramType) sci.getCalledSubprogram(), listComponents);
							}
							if (sci.getCalledSubprogram() instanceof SubprogramImplementation) {
								searchSubprograms((SubprogramImplementation) sci.getCalledSubprogram(), listComponents);

							}
						}
					}
					// listComponents.put(c, new Entity(normalizeName(c)));
				}

				searchSubprograms(c, listComponents);
			}

		}
	}

	public static String normalizeName(Element p) {
		if (p instanceof NamedElement) {
			return ((NamedElement) p).getName();
		} else {
			return "unamed player";
		}
	}

	public static String normalizeName(String s) {
		return s;
	}

	public static void convert(SystemInstance systemInstance, String outputFile) throws Exception {
		HashMap<String, Component> mapFunctions;
		Connection entityConnection;

		mapFunctions = new HashMap<String, Component>();

		searchSubprograms(systemInstance, mapFunctions);

		for (String p : mapFunctions.keySet()) {
			System.out.println("[LdmExporter] Subprogram " + p);
		}
		for (ConnectionInstance ci : systemInstance.getAllEnclosingConnectionInstances()) {
			for (String spgSrcName : mapFunctions.keySet()) {
				String spgDstName;
				String thrSrcName;
				String thrDstName;

				if (ci.getSource().getContainingComponentInstance().getCategory() != ComponentCategory.THREAD) {
					continue;
				}
				if (ci.getDestination().getContainingComponentInstance().getCategory() != ComponentCategory.THREAD) {
					continue;
				}

				thrSrcName = ci.getSource().getContainingComponentInstance().getComponentClassifier().getName();
				thrDstName = ci.getDestination().getContainingComponentInstance().getComponentClassifier().getName();

				if (!(thrSrcName.equals("thr_" + spgSrcName + ".i"))) {
					continue;
				}

				// System.out.println ("thrsrc=" + thrSrcName);
				// System.out.println ("thrdst=" + thrDstName);
				spgDstName = thrDstName.replace(".i", "").replace("thr_", "");
				// System.out.println ("spgSrc=" + spgSrcName);
				// System.out.println ("spgDst=" + spgDstName);

				if ((spgDstName != null) && (mapFunctions.containsKey(spgDstName)) && (spgDstName != spgSrcName)) {
					System.out.println("[LdmExporter] Function " + spgSrcName + " connected to " + spgDstName);
					entityConnection = new Connection(mapFunctions.get(spgSrcName), mapFunctions.get(spgDstName));
					mapFunctions.get(spgSrcName).addConnection(entityConnection);
					mapFunctions.get(spgDstName).addConnection(entityConnection);
				}
				/*
				 * if (ci.getSource() != fi)
				 * {
				 * continue;
				 * }
				 * ComponentInstance dest = connection.getDestination().getContainingComponentInstance();
				 * 
				 * if ((dest != null) && (mapFunctions.containsKey(dest)) && (p != dest))
				 * {
				 * System.out.println("[LdmExporter] Function " + normalizeName (p) + " connected to " + normalizeName (dest));
				 * entityConnection = new EntityConnection(mapFunctions.get(p), mapFunctions.get(dest));
				 * mapFunctions.get(p).addConnection (entityConnection);
				 * mapFunctions.get(dest).addConnection (entityConnection);
				 * }
				 */
			}
		}
		/*
		 * for (Element p : mapFunctions.keySet())
		 * {
		 * for (FeatureInstance fi : p.getFeatureInstances())
		 * {
		 * if ((fi.getCategory() == FeatureCategory.DATA_PORT) ||
		 * (fi.getCategory() == FeatureCategory.EVENT_PORT))
		 * {
		 * for (ConnectionInstance connection : fi.getAllEnclosingConnectionInstances())
		 * {
		 * if (connection.getSource() != fi)
		 * {
		 * continue;
		 * }
		 * ComponentInstance dest = connection.getDestination().getContainingComponentInstance();
		 * 
		 * if ((dest != null) && (mapFunctions.containsKey(dest)) && (p != dest))
		 * {
		 * System.out.println("[LdmExporter] Function " + normalizeName (p) + " connected to " + normalizeName (dest));
		 * entityConnection = new EntityConnection(mapFunctions.get(p), mapFunctions.get(dest));
		 * mapFunctions.get(p).addConnection (entityConnection);
		 * mapFunctions.get(dest).addConnection (entityConnection);
		 * }
		 * 
		 * }
		 * }
		 * }
		 * }
		 */
		LdmWriter.writeFile(outputFile, mapFunctions.values());
	}
}
