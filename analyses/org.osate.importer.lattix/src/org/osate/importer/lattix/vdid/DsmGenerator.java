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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.importer.Utils;

import java.util.*;

public class DsmGenerator {
	public final static int DSM_TYPE_BOOLEAN = 0;

	private int dsmType;
	private MatrixGenerator matrix;
	private ComponentInstance mainComponent;
	private List<String> componentsList;
	private List<ComponentInstance> components;

	private int dsmDepth;

	public DsmGenerator(MatrixGenerator m, ComponentInstance ci) {
		String componentName;
		ComponentInstance subci;
		mainComponent = ci;
		matrix = m;
		dsmType = DSM_TYPE_BOOLEAN;
		dsmDepth = 0;
		componentsList = new ArrayList<String>();
		components = new ArrayList<ComponentInstance>();

		for (Element c : ci.getChildren()) {
			if (c instanceof ComponentInstance) {
				dsmDepth++;
				subci = (ComponentInstance) c;
				componentsList.add(Utils.getComponentName(subci));
				components.add(subci);
			}
		}
		// System.out.println ("[DSMGENERATOR] Depth=" + dsmDepth);
	}

	public DsmGenerator(MatrixGenerator m, ComponentInstance ci, int t) {
		this(m, ci);
		dsmType = t;
	}

	public int getDepth() {
		return this.dsmDepth;
	}

	public int[][] getDsm(int d) {
		String compSource;
		String compDest;
		int[][] res;

		res = new int[dsmDepth][dsmDepth];

		for (int i = 0; i < dsmDepth; i++) {
			for (int j = 0; j < dsmDepth; j++) {
				res[i][j] = 0;
			}

		}

		/*
		 * If we ask for depth 0, we return the
		 * identity matrix.
		 */
		if (d == 0) {
			for (int i = 0; i < dsmDepth; i++) {
				res[i][i] = 1;
			}

		} else {
			for (int i = 0; i < dsmDepth; i++) {
				compSource = componentsList.get(i);
				for (int j = 0; j < dsmDepth; j++) {
					compDest = componentsList.get(j);
					if ((compSource.equals(compDest) == false) && (isUsing(compSource, compDest, d))) {
						// System.out.println ("[DSMGENERATOR] Component " + compSource + " uses " + compDest + " at depth " + d);
						res[j][i] = 1;
					}
				}
			}
		}

		/*
		 * Print matrix
		 */
		for (int i = 0; i < dsmDepth; i++) {
			// System.out.println ("[DSMGENERATOR] Component " + i + "=" + componentsList.get(i));
		}
		/*
		 * System.out.println ("[DSMGENERATOR] Matrix for depth=" + d);
		 * System.out.print ("  ");
		 * for (int i = 0 ; i < dsmDepth ; i++)
		 * {
		 * System.out.print (componentsList.get(i) + " ");
		 * }
		 * System.out.print ("\n");
		 * for (int i = 0 ; i < dsmDepth ; i++)
		 * {
		 * System.out.print (componentsList.get(i) + " ");
		 * for (int j = 0 ; j < dsmDepth ; j++)
		 * {
		 * 
		 * System.out.print (res[i][j]);
		 * System.out.print (" ");
		 * }
		 * System.out.print ("\n");
		 * }
		 */
		return res;
	}

	private boolean isUsing(String src, String dst, int d) {
		List<String> deps;

		if (d < 1) {
			return false;
		}

		deps = matrix.getMatrix().get(src);

		if (deps == null) {
			// System.out.println ("[DSMGENERATOR] null list for " + src);
			return false;
		}
		for (String s : deps) {
			// System.out.println ("[DSMGENERATOR] Try to see if " + src + " uses " + s + " for depth" + d);
			if (d > 1) {
				return isUsing(s, dst, d - 1);
			} else {
				if (s.equals(src)) {
					// System.out.println ("[DSMGENERATOR] cyclic dependency " + src);
					continue;
				}

				if (s.equals(dst)) {
					// System.out.println ("[DSMGENERATOR] "+ src + " USES " + s);
					return true;
				}
			}
		}
		return false;
	}

	public List<ComponentInstance> getComponents() {
		return this.components;
	}

}
