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
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.PropertyLookupException;
import org.osate.contribution.sei.names.SEI;
import org.osate.importer.properties.CriticalityProperty;
import org.osate.importer.properties.SlocProperty;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class MetricsReporter extends AadlProcessingSwitchWithProgress {

	private long sloc[];

	private int nProcessor[];
	private int nMemory[];
	private int nThread[];
	private int nProcess[];
	private int nBus[];
	private int nVirtualProcessor[];
	private int nVirtualBus[];
	private int nSystem[];
	private int nDevice[];
	private int nAbstract[];
	private int nData[];

	private int nConnection;

	public int getNbConnection() {
		return this.nConnection;
	}

	public int getNbDevice(int i) {
		return nDevice[i];
	}

	public int getNbDevice() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbDevice(i);
		}
		return sum;
	}

	public int getNbMemory(int i) {
		return nMemory[i];
	}

	public int getNbMemory() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbMemory(i);
		}
		return sum;
	}

	public int getNbBus(int i) {
		return this.nBus[i];
	}

	public int getNbBus() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbBus(i);
		}
		return sum;
	}

	public int getNbVirtualProcessor(int i) {
		return this.nVirtualProcessor[i];
	}

	public int getNbVirtualProcessor() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbVirtualProcessor(i);
		}
		return sum;
	}

	public int getNbVirtualBus(int i) {
		return this.nVirtualBus[i];
	}

	public int getNbVirtualBus() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbVirtualBus(i);
		}
		return sum;
	}

	public int getNbThread(int i) {
		return this.nThread[i];
	}

	public int getNbThread() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbThread(i);
		}
		return sum;
	}

	public int getNbProcess(int i) {
		return this.nProcess[i];
	}

	public int getNbProcess() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbProcess(i);
		}
		return sum;
	}

	public int getNbSystem(int i) {
		return this.nSystem[i];
	}

	public int getNbSystem() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbSystem(i);
		}
		return sum;
	}

	public int getNbProcessor(int i) {
		return this.nProcessor[i];
	}

	public int getNbProcessor() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbProcessor(i);
		}
		return sum;
	}

	public int getNbData(int i) {
		return this.nData[i];
	}

	public int getNbData() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbData(i);
		}
		return sum;
	}

	public int getNbAbstract(int i) {
		return this.nAbstract[i];
	}

	public int getNbAbstract() {
		int sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getNbAbstract(i);
		}
		return sum;
	}

	public long getSLOCS(int i) {
		return this.sloc[i];
	}

	public long getSLOCS() {
		long sum;
		sum = 0;
		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			sum += getSLOCS(i);
		}
		return sum;
	}

	private HashMap<String, List<String>> dsmMatrix;

	public MetricsReporter(final IProgressMonitor monitor) {
		super(monitor, PROCESS_PRE_ORDER_ALL);
		dsmMatrix = new HashMap<String, List<String>>();
		this.initMetrics();
	}

	public MetricsReporter(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr) {
		super(monitor, PROCESS_PRE_ORDER_ALL, errmgr);

		dsmMatrix = new HashMap<String, List<String>>();
		this.initMetrics();
	}

	public boolean useCriticalityLevel(int i) {
		if (this.sloc[i] != 0)
			return true;

		if (this.nProcessor[i] != 0)
			return true;

		if (this.nMemory[i] != 0)
			return true;

		if (this.nThread[i] != 0)
			return true;

		if (this.nProcess[i] != 0)
			return true;

		if (this.nBus[i] != 0)
			return true;

		if (this.nVirtualProcessor[i] != 0)
			return true;

		if (this.nVirtualBus[i] != 0)
			return true;

		if (this.nSystem[i] != 0)
			return true;

		if (this.nAbstract[i] != 0)
			return true;

		if (this.nDevice[i] != 0)
			return true;

		if (this.nData[i] != 0)
			return true;

		return false;
	}

	public void initMetrics() {
		this.sloc = new long[CriticalityProperty.NB_CRITICALITIES];
		this.nProcessor = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nMemory = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nThread = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nProcess = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nBus = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nVirtualProcessor = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nVirtualBus = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nSystem = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nAbstract = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nDevice = new int[CriticalityProperty.NB_CRITICALITIES];
		this.nConnection = 0;
		this.nData = new int[CriticalityProperty.NB_CRITICALITIES];

		for (int i = 0; i < CriticalityProperty.NB_CRITICALITIES; i++) {
			this.sloc[i] = 0;
			this.nProcessor[i] = 0;
			this.nMemory[i] = 0;
			this.nThread[i] = 0;
			this.nProcess[i] = 0;
			this.nBus[i] = 0;
			this.nVirtualProcessor[i] = 0;
			this.nVirtualBus[i] = 0;
			this.nSystem[i] = 0;
			this.nAbstract[i] = 0;
			this.nDevice[i] = 0;

			this.nData[i] = 0;
		}
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
				int crit;
				crit = CriticalityProperty.getCriticality(obj);
				sloc[crit] = sloc[crit] + SlocProperty.getSloc(obj);
				// System.out.println ("Adding slocs " + SlocProperty.getSloc(obj) + " to criticality level " + crit);
				switch (obj.getCategory()) {
				case THREAD:
					nThread[crit]++;
					return DONE;
				case PROCESS:
					nProcess[crit]++;
					return DONE;
				case PROCESSOR:
					nProcessor[crit]++;
					return DONE;
				case VIRTUAL_PROCESSOR:
					nVirtualProcessor[crit]++;
					return DONE;
				case MEMORY:
					nMemory[crit]++;
					return DONE;
				case BUS:
					nBus[crit]++;
					return DONE;
				case VIRTUAL_BUS:
					nVirtualBus[crit]++;
					return DONE;
				case DEVICE:
					nDevice[crit]++;
					return DONE;
				case ABSTRACT:
					nAbstract[crit]++;
					return DONE;
				case SYSTEM:
					nSystem[crit]++;
					return DONE;
				case DATA:
					nData[crit]++;
					return DONE;
				}
				return DONE;
			}

			public String caseConnectionInstance(ConnectionInstance ci) {
				nConnection++;
				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				return DONE;
			}
		};

	}

}
