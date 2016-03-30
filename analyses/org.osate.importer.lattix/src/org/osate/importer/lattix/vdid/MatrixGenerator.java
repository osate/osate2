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
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.importer.Utils;
import org.osate.importer.properties.CriticalityProperty;
import org.osate.importer.properties.SlocProperty;

public class MatrixGenerator extends AadlProcessingSwitchWithProgress {

	private HashMap<String, List<String>> dsmMatrix;
	private HashMap<String, Long> slocMatrix;
	private HashMap<String, Integer> criticalityMatrix;
	private HashMap<String, Integer> nbConnections;
	private List<String> connectionsAnalyzed;
	private ComponentInstance rootComponent;

	public MatrixGenerator(final IProgressMonitor monitor, ComponentInstance ci) {
		super(monitor, PROCESS_PRE_ORDER_ALL);
		dsmMatrix = new HashMap<String, List<String>>();
		nbConnections = new HashMap<String, Integer>();
		criticalityMatrix = new HashMap<String, Integer>();
		slocMatrix = new HashMap<String, Long>();
		connectionsAnalyzed = new ArrayList<String>();
		rootComponent = ci;
	}

	public MatrixGenerator(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr, ComponentInstance ci) {
		super(monitor, PROCESS_PRE_ORDER_ALL, errmgr);
		dsmMatrix = new HashMap<String, List<String>>();
		nbConnections = new HashMap<String, Integer>();
		criticalityMatrix = new HashMap<String, Integer>();
		slocMatrix = new HashMap<String, Long>();
		connectionsAnalyzed = new ArrayList<String>();
		rootComponent = ci;
	}

	public HashMap<String, List<String>> getMatrix() {
		return dsmMatrix;
	}

	public int getNbConnection(String componentSource, String componentDestination) {
		String nbConnectionStr;
		Integer tmpConnections;

		nbConnectionStr = componentSource + "|" + componentDestination;
		tmpConnections = nbConnections.get(nbConnectionStr);

		return tmpConnections.intValue();

	}

	private void addToList(String componentSource, String componentDestination, String portSource, String portDest) {
		List<String> sourceList;
		String nbConnectionStr;
		Integer tmpConnections;
		String connectionStr;

		nbConnectionStr = componentSource + "|" + componentDestination;
		connectionStr = componentSource + "|" + componentDestination + "|" + portSource + "|" + portDest;

		if (connectionsAnalyzed.contains(connectionStr)) {
			System.out.println("FOUND compSource=" + componentSource + " | " + "compDest=" + componentDestination
					+ " | " + "portSrc=" + portSource + " | " + "portDest=" + portDest);
			return;
		}

		connectionsAnalyzed.add(connectionStr);

		System.out.println("NOT FOUND compSource=" + componentSource + " | " + "compDest=" + componentDestination
				+ " | " + "portSrc=" + portSource + " | " + "portDest=" + portDest);

		if (!dsmMatrix.containsKey(componentSource)) {
			dsmMatrix.put(componentSource, new ArrayList<String>());
		}

		if (!nbConnections.containsKey(nbConnectionStr)) {
			nbConnections.put(nbConnectionStr, new Integer(0));
		}

		sourceList = dsmMatrix.get(componentSource);

		if (!sourceList.contains(componentDestination)) {
			sourceList.add(componentDestination);
		}

		tmpConnections = nbConnections.get(nbConnectionStr);
		nbConnections.put(nbConnectionStr, new Integer(tmpConnections.intValue() + 1));
		System.out.println("nb conn" + tmpConnections);

	}

	protected final void initSwitches() {

		aadl2Switch = new Aadl2Switch<String>() {

			public String caseComponentType(ComponentType obj) {

				return DONE;
			}

			public String caseComponentImplementation(ComponentImplementation ci) {

				return DONE;
			}

			public String caseFlowSpecification(FlowSpecification obj) {

				return DONE;
			}

			public String caseEndToEndFlow(EndToEndFlow obj) {

				return DONE;
			}
		};

		instanceSwitch = new InstanceSwitch<String>() {
			public String caseComponentInstance(ComponentInstance obj) {
				String componentSource = null;
				String componentDestination = null;
				String portSource = null;
				String portDest = null;
				Integer criticalityValue;

				if (Utils.shallAnalyze(obj) == false) {
					System.out.println("Component = " + obj + "NOT ANALYZED");
					return DONE;
				}

				componentSource = Utils.getComponentName(obj);
				criticalityValue = CriticalityProperty.getCriticality(obj);
				System.out.println("Component = " + componentSource);

				if (criticalityValue != CriticalityProperty.INVALID_CRITICALITY) {
					criticalityMatrix.put(componentSource, criticalityValue);
				}

				slocMatrix.put(componentSource, SlocProperty.getSloc(obj));

				for (FeatureInstance f : obj.getFeatureInstances()) {

					System.out.println("  Feature= " + f);

					/*
					 * if (f.getDirection() == DirectionType.IN)
					 * {
					 * System.out.println ("   Direction = IN");
					 * 
					 * for (ConnectionInstance c : f.getAllEnclosingConnectionInstances())
					 * {
					 * 
					 * System.out.println ("   CONN SRC = " + c.getSource());
					 * System.out.println ("   CONN DST = " + c.getDestination());
					 * System.out.println ("   CONN SRC COMP = " + Utils.getComponentName(c.getSource().getContainingComponentInstance()));
					 * System.out.println ("   CONN DST COMP = " + Utils.getComponentName(c.getDestination().getContainingComponentInstance()));
					 * 
					 * }
					 * }
					 */
					if (f.getDirection() == DirectionType.OUT) {
						System.out.println("   Direction = OUT");

						for (ConnectionInstance c : f.getAllEnclosingConnectionInstances()) {
							portSource = c.getSource().getName();
							portDest = c.getDestination().getName();
							componentSource = Utils.getComponentName(c.getSource().getContainingComponentInstance());
							componentDestination = Utils
									.getComponentName(c.getDestination().getContainingComponentInstance());

							addToList(componentSource, componentDestination, portSource, portDest);

							System.out.println("   CONN = " + c);
							for (ConnectionReference cr : c.getConnectionReferences()) {
								/*
								 * System.out.println ("   CONN REF = " + cr);
								 * 
								 * System.out.println ("   CONN SRC = " + cr.getSource());
								 * System.out.println ("   CONN DST = " + cr.getDestination());
								 * System.out.println ("   CONN SRC COMP = " + cr.getSource().getComponentInstance());
								 * System.out.println ("   CONN DST COMP1 = " + cr.getDestination().getComponentInstance());
								 * System.out.println ("   CONN DST COMP2 = " + cr.getDestination().getContainingComponentInstance());
								 * System.out.println ("   CONN SRC PORT = " + cr.getSource().getName());
								 * System.out.println ("   CONN DST PORT = " + cr.getDestination().getName());
								 */
								if (Utils.shallAnalyze(cr.getDestination().getContainingComponentInstance())) {
									portSource = cr.getSource().getName();
									portDest = cr.getDestination().getName();
									componentSource = Utils
											.getComponentName(cr.getSource().getContainingComponentInstance());
									componentDestination = Utils
											.getComponentName(cr.getDestination().getContainingComponentInstance());

									addToList(componentSource, componentDestination, portSource, portDest);
								}
							}

						}

					}

				}

				switch (obj.getCategory()) {
				case THREAD:
					return DONE;
				case PROCESS:
					return DONE;
				case PROCESSOR:
					return DONE;
				case VIRTUAL_PROCESSOR:
					return DONE;
				case MEMORY:
					return DONE;
				case BUS:
					return DONE;
				case VIRTUAL_BUS:
					return DONE;
				case DEVICE:
					return DONE;
				}
				return DONE;
			}

			public String caseConnectionInstance(ConnectionInstance ci) {
				/*
				 * System.out.println ("Connection instance=" + ci);
				 * 
				 * for (ConnectionReference cr : ci.getConnectionReferences())
				 * {
				 * 
				 * System.out.println ("Connection reference       =" + cr);
				 * System.out.println ("Connection reference source=" + cr.getSource());
				 * System.out.println ("Connection reference dest  =" + cr.getDestination());
				 * ConnectionInstanceEnd cie = cr.getDestination();
				 * for ( ConnectionInstance conndests : cie.getDstConnectionInstances())
				 * {
				 * System.out.println ("conndest dest  =" + conndests.getDestination());
				 * 
				 * }
				 * 
				 * cie = cr.getSource();
				 * 
				 * for ( ConnectionInstance connsrcs : cie.getSrcConnectionInstances())
				 * {
				 * System.out.println ("connsrcs src  =" + connsrcs.getSource());
				 * 
				 * }
				 * 
				 * }
				 */
				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				return DONE;
			}
		};

	}

	public int getMaxConnections() {
		int max = 0;
		for (Integer i : nbConnections.values()) {
			if (i.intValue() > max) {
				max = i.intValue();
			}
		}
		return max;
	}

	public int getCriticality(String componentName) {
		try {
			return criticalityMatrix.get(componentName);
		} catch (Exception e) {
			return CriticalityProperty.INVALID_CRITICALITY;
		}
	}

	public long getSlocs(String componentName) {
		try {
			return slocMatrix.get(componentName);
		} catch (Exception e) {
			return 0;
		}
	}

}
