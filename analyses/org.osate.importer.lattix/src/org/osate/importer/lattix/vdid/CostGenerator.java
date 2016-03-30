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
import org.osate.importer.properties.CriticalityProperty;
import org.osate.importer.properties.SlocProperty;

import java.util.*;

public class CostGenerator {
	public final static int DSM_TYPE_BOOLEAN = 0;

	private MatrixGenerator matrix;
	private ComponentInstance mainComponent;
	private DsmGenerator dsmGenerator;
	HashMap<String, CostImpactReport> impactReports;

	private double total;
	private double cost;
	private int depth;

	public CostGenerator(MatrixGenerator m, ComponentInstance ci) {
		this(m, ci, DsmGenerator.DSM_TYPE_BOOLEAN);
	}

	public CostGenerator(MatrixGenerator m, ComponentInstance ci, int type) {
		mainComponent = ci;
		matrix = m;
		dsmGenerator = new DsmGenerator(matrix, mainComponent, type);
		depth = dsmGenerator.getDepth();
		cost = 0;
		total = 0;
		impactReports = new HashMap<String, CostImpactReport>();
	}

	public double getCost() {
		return this.cost;
	}

	public double getTotal() {
		return this.total;
	}

	public int getDepth() {
		return this.depth;
	}

	public void compute() {
		int[][][] dsms;
		int[][] dsm;
		CostImpactReport impactReport;
		String componentName;
		dsms = new int[depth][depth][depth];

		if (depth == 0) {
			System.out.println("[COSTGENERATOR] ERROR depth==0");
			return;
		}

		/*
		 * Compute all DSM matrixes
		 */
		for (int i = 0; i < depth; i++) {
			dsms[i] = dsmGenerator.getDsm(i);
		}

		/*
		 * Compute the final cost impact
		 */
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j < depth; j++) {
				for (int k = 0; k < depth; k++) {
					total += (double) dsms[i][j][k];
				}
			}
		}

		/*
		 * Compute the slocs impact for each component
		 */
		for (int c = 0; c < dsmGenerator.getComponents().size(); c++) {
			long slocs;
			int crit;
			String depName;
			ComponentInstance depInstance;
			ComponentInstance component;

			component = dsmGenerator.getComponents().get(c);
			componentName = Utils.getComponentName(component);

			impactReport = new CostImpactReport(componentName);
//			System.out.println ("Cost analysis for: " + componentName);
			for (int d = 0; d < depth; d++) {
//				System.out.println ("DEPTH=" + d);
				dsm = dsmGenerator.getDsm(d);

				for (int dep = 0; dep < dsmGenerator.getComponents().size(); dep++) {
					depInstance = dsmGenerator.getComponents().get(dep);
					depName = Utils.getComponentName(depInstance);

					slocs = SlocProperty.getSloc(depInstance);
					crit = CriticalityProperty.getCriticality(depInstance);
//					System.out.println ("   Looking for dep (depth="+d+"): " + depName + "(crit=" + crit + ";slocs=" + slocs + ";coeff="+ dsm[c][dep] +")");

					if (dsm[dep][c] > 0) {
//						System.out.println ("   Looking for dep (depth="+d+"): " + depName + "(crit=" + crit + ";slocs=" + slocs + ";coeff="+ dsm[c][dep] +")");
						impactReport.addSlocs(slocs * dsm[dep][c], crit);
					}
				}
			}
			impactReports.put(componentName, impactReport);
		}

		cost = total / (double) ((depth * depth));
		System.out.println("[COSTGENERATOR] Cost=" + cost + "(total = " + total + " depth=" + depth + ")");

	}

	public CostImpactReport getReport(String n) {
		return impactReports.get(n);
	}

	public ComponentInstance getMainComponent() {
		return this.mainComponent;
	}
}
