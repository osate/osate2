/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
