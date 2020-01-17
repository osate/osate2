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
package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * @author phf
 * @deprecated Unused. Will be removed in 2.7.
 */
@Deprecated
public class TraverseErrorPropagationPaths {
	protected WriteToFile report;
	protected AnalysisModel faultModel;
	protected EList<EObject> visited;
	protected int maxLevel = 5;

	public TraverseErrorPropagationPaths(String reportType, ComponentInstance root) {
		if (reportType != null) {
			report = new WriteToFile(reportType, root);
		}
		faultModel = new AnalysisModel(root);
		visited = new UniqueEList<EObject>();

	}

	public TraverseErrorPropagationPaths(String reportType, ComponentInstance root, int maxLevel) {
		if (reportType != null) {
			report = new WriteToFile(reportType, root);
		}
		faultModel = new AnalysisModel(root);
		visited = new UniqueEList<EObject>();
		this.maxLevel = maxLevel;
	}

	public TraverseErrorPropagationPaths(ComponentInstance root) {
		faultModel = new AnalysisModel(root);
		visited = new UniqueEList<EObject>();
	}

	public TraverseErrorPropagationPaths(ComponentInstance root, int maxLevel) {
		faultModel = new AnalysisModel(root);
		visited = new UniqueEList<EObject>();
		this.maxLevel = maxLevel;
	}

	public void setMaxDepth(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public Collection<ComponentInstance> getSubcomponents() {
		return faultModel.getSubcomponents();
	}

	public void addText(String text) {
		if (report != null) {
			report.addOutput(text);
		}
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void addTextNewline(String text) {
		if (report != null) {
			report.addOutputNewline(text);
		}
	}

	public void addNewline() {
		if (report != null) {
			report.addOutputNewline("");
		}
	}

	public void saveReport() {
		if (report != null) {
			report.saveToFile();
		}
	}

	/**
	 * traverse error flow if the component instance is an error source
	 * @param ci component instance
	 */
	public void startErrorFlows(ComponentInstance ci, Object param) {
		Collection<ErrorSource> eslist = EMV2Util.getAllErrorSources(ci.getComponentClassifier());
		for (ErrorSource errorSource : eslist) {
			EList<TypeToken> sourceTypes = initSource(ci, errorSource, param);
			NamedElement ne = errorSource.getSourceModelElement();
			if (ne instanceof ErrorPropagation) {
				ErrorPropagation ep = (ErrorPropagation) ne;
				for (TypeToken typeToken : sourceTypes) {
					Object newparam = processStart(ci, ep, typeToken, param);
					traverseErrorPaths(ci, ep, 2, typeToken, newparam);
				}
			}
		}
		saveReport();
	}


	/**
	 * traverse through the destination of the connection instance
	 * @param conni
	 */
	protected void traverseErrorPaths(ComponentInstance ci, ErrorPropagation ep, int depth, TypeToken tt,
			Object param) {
		EList<PropagationPathRecord> paths = faultModel.getAllPropagationPaths(ci, ep);
		if (paths.isEmpty()) {
			processEnd(ci, ep, depth, tt, param);
			return;
		}
		for (PropagationPathRecord path : paths) {
			processPath(path, param);
			ComponentInstance destci = path.getDstCI();
			ErrorPropagation destEP = path.getPathDst().getErrorPropagation();
			// we go to the end of the connection instance, not an enclosing component that may have an error model abstraction
			traverseErrorFlows(destci, destEP, depth, tt, param);
		}
	}

	/**
	 * traverse through the destination of the connection instance
	 * @param conni
	 */
	protected void traverseErrorFlows(ComponentInstance ci, ErrorPropagation inprop, int depth, TypeToken tt,
			Object param) {
		Collection<ErrorFlow> efs = EMV2Util.getAllErrorFlows(ci.getComponentClassifier());
		if (!efs.isEmpty()) {
			Collection<ErrorFlow> outefs = EMV2Util.findErrorFlowFrom(efs, inprop);
			for (ErrorFlow ef : outefs) {
				if (ef instanceof ErrorSink) {
					// process should have returned false, but for safety we check again
					processEnd(ci, inprop, depth, tt, param);
				} else if (ef instanceof ErrorPath) { // error path
					ErrorPropagation outprop = ((ErrorPath) ef).getOutgoing();
					Object newparam = processFlow(ci, inprop, outprop, tt, param);
					traverseErrorPaths(ci, outprop, depth + 1, EMV2Util.mapToken(tt, ef), newparam);
				}
			}
		} else {
			// no error flows: XXX need to fix ef being more than one. also no error flows. and no flows condition
			// try flows or propagate to all outgoing connections
			EList<FlowSpecificationInstance> flowlist = ci.getFlowSpecifications();
			if (!flowlist.isEmpty()) {
				for (FlowSpecificationInstance flowSpecificationInstance : flowlist) {
					if (flowSpecificationInstance.getSource().getFeature() == EMV2Util
							.getErrorPropagationFeature(inprop, ci)) {
						FeatureInstance outfi = flowSpecificationInstance.getDestination();
						if (outfi != null) {
							ErrorPropagation outprop = EMV2Util.getOutgoingErrorPropagation(outfi);
							Object newparam = processFlow(ci, inprop, outprop, tt, param);
							traverseErrorPaths(ci, outprop, depth + 1, EMV2Util.mapToken(tt, flowSpecificationInstance),
									newparam);
						}
					}
				}
			} else {
				// now all outgoing connections since we did not find flows
				EList<FeatureInstance> filist = ci.getFeatureInstances();
				for (FeatureInstance fi : filist) {
					if (fi.getFlowDirection().outgoing()) {
						ErrorPropagation outprop = EMV2Util.getOutgoingErrorPropagation(fi);
						Object newparam = processFlow(ci, inprop, outprop, tt, param);
						traverseErrorPaths(ci, outprop, depth + 1, EMV2Util.mapToken(tt, null), newparam);
					}
				}
			}
		}
	}

	protected EList<TypeToken> initSource(ComponentInstance ci, ErrorSource errorSource, Object param) {
		TypeSet ts = errorSource.getTypeTokenConstraint();
		NamedElement ne = errorSource.getSourceModelElement();
		if (ts == null && ne instanceof ErrorPropagation) {
			((ErrorPropagation) ne).getTypeSet();
		}
		ErrorBehaviorState failureMode = errorSource.getFailureModeReference();
		EList<TypeToken> sourceTokenSet = EMV2TypeSetUtil.generateAllLeafTypeTokens(ts,
				EMV2Util.getUseTypes(errorSource));
		return sourceTokenSet;
	}

	protected Object processSource(ComponentInstance ci, ErrorSource es, TypeToken tt, Object param) {
		ErrorBehaviorState failureMode = es.getFailureModeReference();
		return param;
	}

	protected Object processStart(ComponentInstance ci, ErrorPropagation ep, TypeToken tt, Object param) {
		return param;
	}

	protected Object processEnd(ComponentInstance ci, ErrorPropagation ep, int depth, TypeToken tt, Object param) {
		return param;
	}

	protected Object processFlow(ComponentInstance ci, ErrorPropagation inprop, ErrorPropagation outprop, TypeToken tt,
			Object param) {
		return param;
	}

	protected Object processPath(PropagationPathRecord path, Object param) {
		return param;
	}
}
