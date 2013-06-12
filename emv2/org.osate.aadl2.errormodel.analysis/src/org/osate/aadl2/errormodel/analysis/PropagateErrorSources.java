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
package org.osate.aadl2.errormodel.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Connection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.util.Aadl2InstanceUtil;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateOrTypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.ErrorModelState;
import org.osate.xtext.aadl2.errormodel.util.ErrorModelStateAdapterFactory;
import org.osate.xtext.aadl2.errormodel.util.PropagationPath;

/**
 * @author phf
 */
public class PropagateErrorSources {
	protected WriteToFile report ;
	protected AnalysisModel faultModel ;
	protected EList<EObject> visited ;
	protected int maxLevel = 5;

	public PropagateErrorSources(String reportType, ComponentInstance root){
		report = new WriteToFile(reportType, root);
		faultModel = new AnalysisModel(root);
		visited = new UniqueEList<EObject>();
		
	}

	public PropagateErrorSources(String reportType, ComponentInstance root, int maxLevel){
		report = new WriteToFile(reportType, root);
		faultModel = new AnalysisModel(root);
		visited = new UniqueEList<EObject>();
		this.maxLevel = maxLevel;
	}
	
	public void setMaxDepth(int maxLevel){
		this.maxLevel = maxLevel;
	}
	
	public EList<ComponentInstance> getSubcomponents() {
		return faultModel.getSubcomponents();
	}
	
	public void addText(String text){
		if (report != null)
			report.addOutput(text);
	}
	
	public int getMaxLevel(){
		return this.maxLevel;
	}
	
	public void addTextNewline(String text){
		if (report != null)
			report.addOutputNewline(text);
	}
	
	public void addNewline(){
		if (report != null)
			report.addOutputNewline("");
	}
	
	public void saveReport(){
		report.saveToFile();
	}

	
	public void reportHeading( ){
		report.addOutput("Component, Initial Failure Mode, 1st Level Effect");
		for (int i = 2; i <= this.maxLevel; i++) {
			report.addOutput(", Failure Mode, "+(i==2?"second":i==3?"third":Integer.toString(i)+"th")+" Level Effect");
		}
		report.addOutputNewline(", Severity");	
	}
	
	
	/**
	 * Put an entry into the report based on the prefix, entryText and any postfix processing based on level
	 * @param entryText String assumed to provide any comma before each entry
	 * @param curLevel last level reported
	 */
	public void reportEntry(String entryText,int curLevel){
		report.addOutput(entryText);
		for (int i = curLevel; i < maxLevel; i++) {
			report.addOutput(", , ");
		}
		report.addOutputNewline(", "+"Severe");	
	}

	/**
	 * traverse error flow if the component instance is an error source
	 * @param ci component instance
	 */
	public void startErrorFlows(ComponentInstance ci)
	{
		Collection<ErrorSource> eslist = EMV2Util.getAllErrorSources(ci.getComponentClassifier());
		String componentText = generateItemText(ci);
		List<ErrorType> handledTypes = new ArrayList<ErrorType>();
		
		for (ErrorBehaviorEvent event : EMV2Util.getAllErrorBehaviorEvents(ci))
		{
			List<ErrorBehaviorState> states = new ArrayList<ErrorBehaviorState> ();
			for (ErrorBehaviorTransition trans : EMV2Util.getAllErrorBehaviorTransitions(ci))
			{
				if (trans.getCondition() instanceof ConditionElement)
				{
					ConditionElement conditionElement = (ConditionElement) trans.getCondition(); 
					if (conditionElement.getIncoming() instanceof ErrorPropagation)
					{
						continue;
					}
					if (conditionElement.getIncoming().getName().equalsIgnoreCase(event.getName()))
					{
						states.add (trans.getTarget());
					}
				}
			}
			
			for (OutgoingPropagationCondition opc : EMV2Util.getAllOutgoingPropagationConditions(ci))
			{
				boolean used = false;
				for (ErrorBehaviorState s : states)
				{
					if (s.getName().equalsIgnoreCase(opc.getState().getName()))
					{
						used = true;
					}
				}
				
				if (used)
				{
					ErrorPropagation ep = opc.getOutgoing();
					
					TypeSet ts = opc.getTypeTokenConstraint();
					if (ts == null)
					{
						ts = ep.getTypeSet();
					}
					ErrorBehaviorState failureMode = null;

					EList<TypeToken> result = EM2TypeSetUtil.generateAllTypeTokens(ts);
					for (TypeToken typeToken : result)
					{
						for (int i = 0 ; i < typeToken.getType().size() ; i++)
						{
							handledTypes.add (typeToken.getType().get(i));
						}
						String failuremodeText = generateFailureModeText(failureMode!=null?failureMode:typeToken);
						traceErrorPaths(ci,ep,typeToken,2,componentText+", "+ "internal event " + event.getName());
					}
					
					//OsateDebug.osateDebug("event=" + event.getName() + "state=" + opc.getState().getName() + "|outgoing=" + opc.getOutgoing());
				}
			}

		}
		for (ErrorSource errorSource : eslist)
		{
			ErrorPropagation ep = errorSource.getOutgoing();
			TypeSet ts = errorSource.getTypeTokenConstraint();
			if (ts == null) ep.getTypeSet();
			ErrorBehaviorStateOrTypeSet fmr = errorSource.getFailureModeReference();
			ErrorBehaviorState failureMode = null;
			if (fmr instanceof ErrorBehaviorState){
				// XXX TODO how about the other case
				failureMode = (ErrorBehaviorState) fmr;
			}
			EList<TypeToken> result = EM2TypeSetUtil.generateAllTypeTokens(ts);
			for (TypeToken typeToken : result)
			{

				String failuremodeText = generateFailureModeText(failureMode!=null?failureMode:typeToken);
				
				if (failureMode == null)
				{
					for (int i = 0 ; i < typeToken.getType().size() ; i++)
					{
						if (! handledTypes.contains (typeToken.getType().get(i)))
						{
							traceErrorPaths(ci,ep,typeToken,2,componentText+", "+failuremodeText);
						}
					}
				}
				else
				{
					traceErrorPaths(ci,ep,typeToken,2,componentText+", "+failuremodeText);
				}
			}
		}
		
	}
	
	/**
	 * get the text to be used for the item (Component or feature)
	 * that is the source of a failure mode
	 * @param ci component instance
	 * @return String
	 */
	public String generateItemText(ConnectionInstanceEnd io)
	{
		String result;
		
		if (io instanceof FeatureInstance)
		{
			FeatureInstance fi = (FeatureInstance)io;
			ComponentInstance ci = fi.getContainingComponentInstance();
			result = ci.getQualifiedName()+"."+fi.getName();
		}
		else if (io instanceof ComponentInstance)
		{
			ComponentInstance ci = (ComponentInstance)io;
			if ((ci.getContainingComponentInstance() != null) && (ci.getContainingComponentInstance() != ci.getSystemInstance()))
			{
				result = ci.getContainingComponentInstance().getName() + "/" + ci.getName();
			}
			else
			{
				result = ci.getQualifiedName();
			}
		}
		else 
		{
			result = io.getName();
		}
		return result;
	}
	
	/**
	 * get the text to be used for the item (Component or feature)
	 * that is the source of a failure mode
	 * @param ci component instance
	 * @return String
	 */
	public String generateConnectionText(ConnectionInstanceEnd src, ConnectionInstanceEnd dst, TypeToken token)
	{
		if ( (src != null) && (dst != null))
		{
			return (generateItemText(src)+EMV2Util.getPrintName(token)+"->"+generateItemText(dst));
		}
		return "uncomplete connection";
	}
	
	/**
	 * get the text for the failure mode
	 * @param io Error State or Type token
	 * @return String
	 */
	public String generateFailureModeText(EObject io){
		if (io instanceof ErrorBehaviorState){
			ErrorBehaviorState ev = (ErrorBehaviorState)io;
			return ev.getName();
		} else if (io instanceof TypeToken){
			return EMV2Util.getPrintName((TypeToken) io);
		} else if (io instanceof TypeSet){
			return EMV2Util.getTableName((TypeSet)io);
		} else {
			return "NoError";
		}
	}
	
	protected void setToken(InstanceObject io, TypeToken token){
		ErrorModelState st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(io, ErrorModelState.class);
		if (st != null) st.setToken(token);
	}
	
	protected TypeToken getToken(InstanceObject io){
		ErrorModelState st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(io, ErrorModelState.class);
		return st == null?null:st.getToken();
	}
	
	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateEffectText(ComponentInstance io, ErrorPropagation ep, TypeToken tt){
			return(generateItemText(io)+
					(ep!=null?"."+EMV2Util.getPrintName(ep):"")+
					(tt!=null?":"+EMV2Util.getPrintName(tt):""));
	}
	
	
	
	/**
	 * traverse through the destination of the connection instance 
	 * @param conni
	 */
	protected void traceErrorPaths(ComponentInstance ci, ErrorPropagation ep, TypeToken tt, int depth, String entryText){
		EList<PropagationPath> paths = faultModel.getAllPropagationPaths(ci, ep);
		String effectText = ", "+generateEffectText(ci, ep,tt);
		if (paths.isEmpty()){
			reportEntry(entryText+effectText+", <no paths>, ", depth);
			return;
		}
		for (PropagationPath path : paths) {
			String connText=", "+generateConnectionText(path.getSrcCI(), path.getDstCI(),tt);
			ComponentInstance destci = path.getDstCI();
			ErrorPropagation destEP = path.getPathDst().getErrorPropagation();
			// we go to the end of the connection instance, not an enclosing component that may have an error model abstraction
			traceErrorFlows(destci, destEP, tt, depth, entryText+effectText+connText);
		}
	}
	
	
	/**
	 * traverse through the destination of the connection instance 
	 * @param conni
	 */
	protected void traceErrorFlows(ComponentInstance ci, ErrorPropagation ep, TypeToken tt, int depth, String entryText){
		if (ci == null)
		{
			return;
		}
		List<ErrorBehaviorState> treated = new ArrayList<ErrorBehaviorState>();

			Collection<ErrorFlow> efs = EMV2Util.getAllErrorFlows(ci.getComponentClassifier());
			if (!efs.isEmpty()){
				Collection<ErrorFlow> outefs=EMV2Util.findErrorFlowFromComponentInstance(ci, ep);
				for (ErrorFlow ef : outefs) {
					if (ef instanceof ErrorSink)
					{
						//OsateDebug.osateDebug("error sink" + ef.getName());
						/**
						 * We try to find additional error propagation for this error sink.
						 * For example, if the error sink triggers to switch to
						 * another behavior state and that states is used to propagate
						 * an error through an error source. Then, we do not consider
						 * it as an error sink but as an error path and continue 
						 * to trace the flow using this additional error propagation.
						 */
						EList<OutgoingPropagationCondition> additionalPropagations = EMV2Util.getAdditionalOutgoingPropagation (ci, ep);
						// process should have returned false, but for safety we check again
						if(additionalPropagations.size() == 0)
						{
							/**
							 * Here, we do not have any additional error propagation, we mark it as a sink.
							 */
							String maskText = ", "+generateItemText(ci)+": "+EMV2Util.getPrintName(tt)+" Masked";
							reportEntry(entryText+maskText, depth);
						}
						else
						{
							/**
							 * We continue to trace the propagation flows
							 * based on the additional errors propagated.
							 */
							for (OutgoingPropagationCondition opc : additionalPropagations)
							{
								ErrorPropagation outp = opc.getOutgoing();
								OsateDebug.osateDebug("ref" + outp.getFeaturerefs().get(0).getFeature().getName());

								if (! treated.contains(opc.getState()))
								{
									treated.add(opc.getState());
									traceErrorPaths(ci,outp,EMV2Util.mapToken(outp.getTypeSet().getElementType().get(0),ef),depth+1,entryText+", "+generateEffectText(ci, outp,outp.getTypeSet().getElementType().get(0)));
								}
							}
						}
					}
					else if (ef instanceof ErrorPath){ // error path
						ErrorPropagation outp = ((ErrorPath)ef).getOutgoing();
						traceErrorPaths(ci,outp,EMV2Util.mapToken(tt,ef),depth+1,entryText+", "+generateEffectText(ci, outp,tt));
					} 
				}
			} else{
				// no error flows: XXX need to fix ef being more than one. also no error flows. and no flows condition
				// try flows or propagate to all outgoing connections
				EList<FlowSpecificationInstance> flowlist = ci.getFlowSpecifications();
				if (!flowlist.isEmpty()){
					for (FlowSpecificationInstance flowSpecificationInstance : flowlist) {
						if (flowSpecificationInstance.getSource().getFeature() == EMV2Util.getErrorPropagationPoint(ep, ci)){
							FeatureInstance outfi = flowSpecificationInstance.getDestination();
							if (outfi != null){
								ErrorPropagation outp = EMV2Util.getOutgoingErrorPropagation(outfi);
								traceErrorPaths(ci,outp,EMV2Util.mapToken(tt,flowSpecificationInstance),depth+1,entryText+", "+generateEffectText(ci, ep,tt));
							}
						}
					}
				} else {
					// now all outgoing connections since we did not find flows
					EList<FeatureInstance> filist = ci.getFeatureInstances();
					for (FeatureInstance fi : filist) {
						if (fi.getDirection().outgoing()){
							ErrorPropagation outp = EMV2Util.getOutgoingErrorPropagation(fi);
							traceErrorPaths(ci,outp,EMV2Util.mapToken(tt,null),depth+1,entryText+","+generateEffectText(ci, ep,tt));
						}
					}
				}
			}
		}
	}


