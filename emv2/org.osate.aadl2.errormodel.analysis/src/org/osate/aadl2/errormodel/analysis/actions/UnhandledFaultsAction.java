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
package org.osate.aadl2.errormodel.analysis.actions;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.PropagationPath;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathEnd;

public final class UnhandledFaultsAction extends AaxlReadOnlyActionAsJob {
	protected String getMarkerType() {
		return "org.osate.aadl2.errormodel.analysis.FaultImpactMarker";
	}

	protected String getActionName() {
		return "UnhandledFaults";
	}

	public void doAaxlAction(IProgressMonitor monitor, Element obj) {
		monitor.beginTask("UnhandledFaults", IProgressMonitor.UNKNOWN);

		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject){
			si = ((InstanceObject)obj).getSystemInstance();
		}
		else return;

		setCSVLog("UnhandledFaults", si);
		AnalysisModel model = new AnalysisModel(si);
		EList<PropagationPath> pathlist = model.getPropagationPaths();
		for (PropagationPath path : pathlist) {
			checkPropagationPathErrorTypes(path);
		}
		for (ComponentInstance ci : EMV2Util.getComponentInstancesWithEMV2Subclause(si))
		{
			checkComponent (ci, model);
		}
		monitor.done();
	}
	
	protected void processMatchingErrorPropagation(ConnectionInstance connectionInstance){
		EList<ConnectionReference> connrefs = connectionInstance.getConnectionReferences();
		ErrorPropagation srcprop = null;
		ErrorPropagation dstprop = null;
		ErrorPropagation srccontain = null;
		ErrorPropagation dstcontain = null;
		for (ConnectionReference connectionReference : connrefs) {
			ConnectionInstanceEnd src = connectionReference.getSource();
			ConnectionInstanceEnd dst = connectionReference.getDestination();
			if (srcprop == null && src instanceof FeatureInstance){
				srcprop = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
			}
			if (srccontain == null && src instanceof FeatureInstance){
				srccontain = EMV2Util.getOutgoingErrorContainment((FeatureInstance)src);
			}
			// determine outgoing and find outgoing. if incoming then incoming.
			// once matched, make dst the source and look for the next dst with prop/containment
//			connectionReference.getConnection().ge
			if (dst instanceof FeatureInstance){
				ErrorPropagation founddst = EMV2Util.getIncomingErrorPropagation((FeatureInstance)dst);
				if (founddst != null){
					dstprop = founddst;
				}
			}
			if (dst instanceof FeatureInstance){
				ErrorPropagation founddst = EMV2Util.getIncomingErrorContainment((FeatureInstance)dst);
				if (founddst != null){
					dstcontain = founddst;
				}
			}
		}
		if (srcprop != null & dstprop != null){
			// need to check whether all error types are handled by the destination
			checkConnectionErrorTypes(connectionInstance, srcprop, srccontain, dstprop, dstcontain);
		}
		if (connectionInstance.isBidirectional()){
			srcprop = null;
			dstprop = null;
			srccontain = null;
			dstcontain = null;
			for (ConnectionReference connectionReference : connrefs) {
				ConnectionInstanceEnd src = connectionReference.getSource();
				ConnectionInstanceEnd dst = connectionReference.getDestination();
				if (srcprop == null && dst instanceof FeatureInstance){
					srcprop = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)dst);
				}
				if (srccontain == null && dst instanceof FeatureInstance){
					srccontain = EMV2Util.getOutgoingErrorContainment((FeatureInstance)dst);
				}
				if (src instanceof FeatureInstance){
					ErrorPropagation founddst = EMV2Util.getOutgoingErrorPropagation((FeatureInstance)src);
					if (founddst != null){
						dstprop = founddst;
					}
				}
				if (src instanceof FeatureInstance){
					ErrorPropagation founddst = EMV2Util.getOutgoingErrorContainment((FeatureInstance)src);
					if (founddst != null){
						dstcontain = founddst;
					}
				}
			}
			if (srcprop != null & dstprop != null){
				// need to check whether all error types are handled by the destination
				checkConnectionErrorTypes(connectionInstance, srcprop, srccontain, dstprop, dstcontain);
			}
		}
	}
	

	protected void checkConnectionErrorTypes(ConnectionInstance connectionInstance,ErrorPropagation srcprop,ErrorPropagation srccontain,ErrorPropagation dstprop,ErrorPropagation dstcontain){

		if (srcprop != null && dstprop != null){
			if(! EM2TypeSetUtil.contains(dstprop.getTypeSet(),srcprop.getTypeSet())){
				error(connectionInstance,"Outgoing propagation  "+EMV2Util.getPrintName(srcprop)+EMV2Util.getPrintName(srcprop.getTypeSet()) +" has error types not handled by incoming propagation "+EMV2Util.getPrintName(dstprop)+EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (srccontain != null && dstcontain != null){
			if(! EM2TypeSetUtil.contains(srccontain.getTypeSet(),dstcontain.getTypeSet())){
				error(connectionInstance,"Outgoing containment  "+EMV2Util.getPrintName(srcprop)+EMV2Util.getPrintName(srcprop.getTypeSet()) +" does not contain error types listed by incoming containment "+EMV2Util.getPrintName(dstprop)+EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if ( srcprop == null&&srccontain == null && (dstprop != null||dstcontain != null)){
				// has an EMV2 subclause but no propagation specification for the feature
				warning(connectionInstance,"Connection source has no error propagation/containment but target does: "+(dstprop!=null?EMV2Util.getPrintName(dstprop):EMV2Util.getPrintName(dstcontain)));
		}
		if ( dstprop == null  && dstcontain == null && (srcprop != null||srccontain != null)){
				// has an EMV2 subclause but no propagation specification for the feature
				error(connectionInstance,"Connection target has no error propagation/containment but source does: "+(srcprop!=null?EMV2Util.getPrintName(srcprop):EMV2Util.getPrintName(srccontain)));
		}
	}

	protected void checkPropagationPathErrorTypes(PropagationPath path){
		ErrorPropagation srcprop = path.getPathSrc().getErrorPropagation();
		ErrorPropagation dstprop = path.getPathDst().getErrorPropagation();
		if (srcprop != null && dstprop != null){
			if(! EM2TypeSetUtil.contains(dstprop.getTypeSet(),srcprop.getTypeSet())){
				error(path.getConnectionInstance()!=null?path.getConnectionInstance():path.getSrcCI(),"Outgoing propagation  "+EMV2Util.getPrintName(srcprop)+EMV2Util.getPrintName(srcprop.getTypeSet()) +" has error types not handled by incoming propagation "+EMV2Util.getPrintName(dstprop)+EMV2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if ( dstprop == null   && srcprop != null){
				// has an EMV2 subclause but no propagation specification for the feature
				error(path.getConnectionInstance()!=null?path.getConnectionInstance():path.getSrcCI(),"Connection target has no error propagation/containment but source does: "+EMV2Util.getPrintName(srcprop));
		}
	}
	
	protected void checkComponent(ComponentInstance componentInstance, AnalysisModel model)
	{
		for (ErrorPropagation ep : EMV2Util.getAllOutgoingErrorPropagations(componentInstance.getComponentClassifier()))
		{
			OsateDebug.osateDebug("ci=" + componentInstance.getName() + "ep =" + EMV2Util.getPrintName(ep));
			if (model.getAllPropagationPaths(componentInstance, ep).size() == 0)
			{
				error(componentInstance,"Outgoing propagation " +EMV2Util.getPrintName(ep) + " not correctly handled");

				//OsateDebug.osateDebug("Component " + componentInstance + " does not handle OUT propagation " + ep.getName());
				continue;
			}
			
			for (PropagationPath pp : model.getAllPropagationPaths(componentInstance, ep))
			{
				ErrorPropagation ep2 = pp.getPathDst().getErrorPropagation();
				
				OsateDebug.osateDebug("epts =" + EMV2Util.getPrintName(ep.getTypeSet()));
				OsateDebug.osateDebug("ep2ts =" + EMV2Util.getPrintName(ep2.getTypeSet()));
				EList<TypeToken> srcTokens = EM2TypeSetUtil.generateAllLeafTypeTokens (ep.getTypeSet(),EMV2Util.getContainingTypeUseContext(ep));
				EList<TypeToken> dstTokens = EM2TypeSetUtil.generateAllLeafTypeTokens (ep2.getTypeSet(),EMV2Util.getContainingTypeUseContext(ep));
//			
//				for (TypeToken tt1 : srcTokens)
//				{
//					if (! EM2TypeSetUtil.contains (ep2.getTypeSet(), tt1))
//					{
//						error(componentInstance, "Error type " + EMV2Util.getPrintName(tt1)  +  " between " + EMV2Util.getPrintName(ep) + "/" + EMV2Util.getPrintName(ep.getTypeSet()) + " and " + EMV2Util.getPrintName(ep2) + "/" + EMV2Util.getPrintName(ep2.getTypeSet()));
//
//					}
//					
//				}
				for (TypeToken tt1 : dstTokens)
				{
					if (! EM2TypeSetUtil.contains (ep.getTypeSet(), tt1))
					{
						error(componentInstance, "Type " + EMV2Util.getPrintName(tt1)  +  " is not propagated by the error source " + EMV2Util.getPrintName(ep) + "/" + EMV2Util.getPrintName(ep.getTypeSet()) + " but is expected by the error sink " + EMV2Util.getPrintName(ep2) + "/" + EMV2Util.getPrintName(ep2.getTypeSet()));

					}
					
				}
//				if (!(EM2TypeSetUtil.contains(, ep2.getTypeSet()) && EM2TypeSetUtil.contains(ep2.getTypeSet(), ep.getTypeSet())))
//				{
//					error(componentInstance, "Some errors are not handled between " + EMV2Util.getPrintName(ep) + "/" + EMV2Util.getPrintName(ep.getTypeSet()) + " and " + EMV2Util.getPrintName(ep2) + "/" + EMV2Util.getPrintName(ep2.getTypeSet()));
//					continue;
				
			}
		}
		for (ErrorPropagation ep : EMV2Util.getAllIncomingErrorPropagations(componentInstance.getComponentClassifier()))
		{
			if (model.getAllPropagationSourceEnds(componentInstance, ep).size() == 0)
			{
				error(componentInstance,"Incoming propagation " +EMV2Util.getPrintName(ep) + " not correctly handled");

				//OsateDebug.osateDebug("Component " + componentInstance + " does not handle IN propagation " + ep.getName());
			}
		}
	}


}
