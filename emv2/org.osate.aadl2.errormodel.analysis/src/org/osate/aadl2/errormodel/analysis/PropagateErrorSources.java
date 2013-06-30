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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.WriteToFile;
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
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
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
	protected int maxLevel = 7;
	private Map<ComponentInstance,List<String>> alreadyTreated;
	

	public PropagateErrorSources(String reportType, ComponentInstance root){
		report = new WriteToFile(reportType, root);
		faultModel = new AnalysisModel(root);
		visited = new UniqueEList<EObject>();
		alreadyTreated = new HashMap<ComponentInstance,List<String>>();
		
	}

	public PropagateErrorSources(String reportType, ComponentInstance root, int maxLevel){
		this (reportType,root);
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
		report.addOutputNewline(", More");	
	}
	
	
	/**
	 * Put an entry into the report based on the prefix, entryText and any postfix processing based on level
	 * @param entryText String assumed to provide any comma before each entry
	 * @param curLevel last level reported
	 */
	public void reportEntry(String entryText,int curLevel){
		report.addOutputNewline(entryText);
//		for (int i = curLevel; i < maxLevel; i++) {
//			report.addOutput(", , ");
//		}
//		report.addOutputNewline(", "+"Severe");	
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
				if (opc.getTypeToken().isNoError())
				{
					continue;
				}
				
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

					EList<TypeToken> result = EM2TypeSetUtil.generateAllLeafTypeTokens(ts, EMV2Util.getContainingTypeUseContext(ep));
					for (TypeToken typeToken : result)
					{
						for (int i = 0 ; i < typeToken.getType().size() ; i++)
						{
							handledTypes.add (typeToken.getType().get(i));
						}
						String failuremodeText = generateOriginalFailureModeText(failureMode!=null?failureMode:typeToken);
						traceErrorPaths(ci,ep,typeToken,2,componentText+", "+ "internal event " + event.getName());
					}
					
					//OsateDebug.osateDebug("event=" + event.getName() + "state=" + opc.getState().getName() + "|outgoing=" + opc.getOutgoing());
				}
			}

		}
		for (ErrorSource errorSource : eslist)
		{
			Collection<ErrorPropagation> eplist = EMV2Util.getOutgoingPropagationOrAll(errorSource);
			TypeSet ts = errorSource.getTypeTokenConstraint();
			ErrorBehaviorStateOrTypeSet fmr = errorSource.getFailureModeReference();
			ErrorBehaviorState failureMode = null;
			if (fmr instanceof ErrorBehaviorState){
				// XXX TODO how about the other case
				failureMode = (ErrorBehaviorState) fmr;
			}
			for (ErrorPropagation ep : eplist){
				TypeSet tsep = ep.getTypeSet();
				EList<TypeToken> result = ts!=null?ts.getTypeTokens():tsep.getTypeTokens();
				//EM2TypeSetUtil.generateAllLeafTypeTokens(ts,EMV2Util.getContainingTypeUseContext(errorSource));
				for (TypeToken typeToken : result)
				{

					String failuremodeText = generateOriginalFailureModeText(failureMode!=null?failureMode:typeToken);

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
	 * get the text for the failure mode
	 * @param io Error State or Type token
	 * @return String
	 */
	public String generateOriginalFailureModeText(EObject io){
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
	
	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generatePropagationPointText(ComponentInstance io, ErrorPropagation ep){
			return(generateItemText(io)+
					(ep!=null?"."+EMV2Util.getPrintName(ep):""));
	}
	
	
	/**
	 * report on io object with optional error propagation.
	 * report on attached ErrorModelState if present
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateErrorPropText( ErrorPropagation ep, TypeToken tt){
			return(
					(ep!=null?EMV2Util.getPrintName(ep):"")+
					(tt!=null?" "+EMV2Util.getPrintName(tt):""));
	}
	
	/**
	 * report on Failure mode.
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateFailureModeText( ComponentInstance ci,ErrorPropagation ep, TypeToken tt){
			return  generateComponentErrorPropText(ci,ep,tt);//generateErrorPropText(ep, tt);
	}
	
	/**
	 * report on ci object with optional error propagation.
	 * note: error propagation ep can be null.
	 * @param io Instance Object
	 * @param ep Error Propagation
	 */
	public String generateComponentErrorPropText( ComponentInstance ci,ErrorPropagation ep, TypeToken tt){
			return generateItemText(ci)+"."+
					generateErrorPropText(ep, tt);
	}
	
	
	/**
	 * traverse through the destination of the connection instance 
	 * @param conni
	 */
	protected void traceErrorPaths(ComponentInstance ci, ErrorPropagation ep, TypeToken tt, int depth, String entryText){
		// TODO this is the place where we can limit the depth of propagation path generation
//		if (depth > maxLevel){
//			reportEntry(entryText+" <more>,,", depth);
//			return;
//		}
		FeatureInstance fi = EMV2Util.findFeatureInstance(ep, ci);
		ErrorModelState st=null;
		if (fi != null){
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(fi, ErrorModelState.class);
		} else {
			st = (ErrorModelState) ErrorModelStateAdapterFactory.INSTANCE.adapt(ci, ErrorModelState.class);
		}
		if (st.visited(tt)){
			// we were there before.
			String effectText = ", "+generateErrorPropText(ep,tt);
			reportEntry(entryText+effectText+" -> <Cycle>,,", depth);
			return;
		} else {
			st.setVisitToken(tt);
		}
		EList<PropagationPath> paths = faultModel.getAllPropagationPaths(ci, ep);
		String effectText = ", "+generateErrorPropText(ep,tt);
		if (paths.isEmpty()){
			reportEntry(entryText+effectText+" -> <no paths>,,", depth);
		} else {
			for (PropagationPath path : paths) {
				ComponentInstance destci = path.getDstCI();
				ErrorPropagation destEP = path.getPathDst().getErrorPropagation();
				// we go to the end of the connection instance, not an enclosing component that may have an error model abstraction
				String connText=" -> "+generateItemText(destci);
				traceErrorFlows(destci, destEP, tt, depth, entryText+effectText+connText);
			}
		}
		st.removeVisitedToken( tt);
	}
	
	
	/**
	 * traverse through the destination of the connection instance 
	 * @param conni
	 */
	protected void traceErrorFlows(ComponentInstance ci, ErrorPropagation ep, TypeToken tt, int depth, String entryText)
	{
		if (ci == null)
		{
			return;
		}
		/**
		 * With alreadyTreated, we have a cache that keep track of existing report
		 * text for each component. For each component, we maintain a list of existing
		 * entryText already reported. So, we do not duplicate the error report for each component
		 * and make sure to report each entry only once.
		 */
		if (! alreadyTreated.containsKey(ci))
		{
			alreadyTreated.put(ci, new ArrayList<String>());
		}
		if (alreadyTreated.get(ci).contains(entryText))
		{
			return;
		}
		
		alreadyTreated.get(ci).add(entryText);
		
		List<ErrorPropagation> treated = new ArrayList<ErrorPropagation>();
		boolean handled = false;
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
					if (EM2TypeSetUtil.contains(ef.getTypeTokenConstraint(), tt)){
						String maskText = ", "+generateFailureModeText(ci,ep,tt)+" [Masked],";
						reportEntry(entryText+maskText, depth);
						handled = true;
					} else {
						Collection<TypeToken> intersection = EM2TypeSetUtil.getConstrainedTypeTokens(ef.getTypeTokenConstraint(), tt);
						for (TypeToken typeToken : intersection) {
							String maskText = ", "+generateFailureModeText(ci,ep,typeToken)+" [Masked],";
							reportEntry(entryText+maskText, depth);
							handled = true;
						}
					}
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

						/**
						 * We try to address all potential error propagation cases.
						 */
						if (! treated.contains(opc))
						{
							TypeToken newtt = EMV2Util.mapToken(outp.getTypeSet().getTypeTokens().get(0),ef);
							treated.add(outp);
							traceErrorPaths(ci,outp,newtt,depth+1,entryText+", from state " + opc.getState().getName() +" " +generateFailureModeText(ci,ep,tt));
						}
					}
					handled = true;
				}
			}
			else if (ef instanceof ErrorPath){ // error path
				Collection<ErrorPropagation> eplist = EMV2Util.getOutgoingPropagationOrAll((ErrorPath)ef);
				if (EM2TypeSetUtil.contains(ef.getTypeTokenConstraint(), tt)){
					TypeToken newtt = EMV2Util.mapToken(tt,ef);
					for (ErrorPropagation outp : eplist) {
						traceErrorPaths(ci,outp,newtt,depth+1,entryText+", "+generateFailureModeText(ci, ep,tt));
						handled = true;
					}
				} else {
					Collection<TypeToken> intersection = EM2TypeSetUtil.getConstrainedTypeTokens(ef.getTypeTokenConstraint(), tt);
					for (TypeToken typeToken : intersection) {
						TypeToken newtt = EMV2Util.mapToken(typeToken,ef);
						for (ErrorPropagation outp : eplist) {
							traceErrorPaths(ci,outp,newtt,depth+1,entryText+", "+generateFailureModeText(ci, ep,typeToken));
							handled = true;
						}
					}
				}
			} 
		}
		if (!handled){
			// no error flows:. and no flows condition
			// try flows or propagate to all outgoing error propagations
			EList<FlowSpecificationInstance> flowlist = ci.getFlowSpecifications();
			if (!flowlist.isEmpty()){
				for (FlowSpecificationInstance flowSpecificationInstance : flowlist) {
					if (flowSpecificationInstance.getSource() != null&&
							flowSpecificationInstance.getSource().getFeature() == EMV2Util.getErrorPropagationFeature(ep, ci)){
						FeatureInstance outfi = flowSpecificationInstance.getDestination();
						if (outfi != null){
							ErrorPropagation outp = EMV2Util.getOutgoingErrorPropagation(outfi);
							if (outp != null){
								TypeToken newtt = EMV2Util.mapToken(tt,flowSpecificationInstance);
								if (EM2TypeSetUtil.contains(outp.getTypeSet(), newtt)){
									traceErrorPaths(ci,outp,newtt,depth+1,entryText+", "+generateFailureModeText(ci, ep,tt)+" [FlowPath]");
									handled = true;
								} else {
									Collection<TypeToken> intersection = EM2TypeSetUtil.getConstrainedTypeTokens(outp.getTypeSet(), newtt);
									for (TypeToken typeToken : intersection) {
										traceErrorPaths(ci,outp,typeToken,depth+1,entryText+", "+generateFailureModeText(ci, ep,tt)+" [FlowPath]");
										handled = true;
									}
								}
							}
						} else {
							// do all since we have a flow sink
							EList<FeatureInstance> filist = ci.getFeatureInstances();
							for (FeatureInstance fi : filist) {
								if (fi.getDirection().outgoing()){
									ErrorPropagation outp = EMV2Util.getOutgoingErrorPropagation(fi);
									if (outp != null){
										TypeToken newtt = EMV2Util.mapToken(tt,null);
										if (EM2TypeSetUtil.contains(outp.getTypeSet(), newtt)){
											traceErrorPaths(ci,outp,newtt,depth+1,entryText+","+generateFailureModeText(ci,ep,tt)+" [FlowSink]");
											handled = true;
										} else {
											Collection<TypeToken> intersection = EM2TypeSetUtil.getConstrainedTypeTokens(outp.getTypeSet(), newtt);
											for (TypeToken typeToken : intersection) {
												traceErrorPaths(ci,outp,typeToken,depth+1,entryText+","+generateFailureModeText(ci,ep,tt)+" [FlowSink]");
												handled = true;
											}
										}
									}
								}
							}
						}
					}
				}
			} else {
				// now all outgoing connections since we did not find flows
				EList<FeatureInstance> filist = ci.getFeatureInstances();
				for (FeatureInstance fi : filist) {
					if (fi.getDirection().outgoing()){
						ErrorPropagation outp = EMV2Util.getOutgoingErrorPropagation(fi);
						if (outp!=null){
							TypeToken newtt = EMV2Util.mapToken(tt,null);
							traceErrorPaths(ci,outp,newtt,depth+1,entryText+","+generateFailureModeText(ci,ep,tt)+" [AllOut]");
							if (EM2TypeSetUtil.contains(outp.getTypeSet(), newtt)){
								traceErrorPaths(ci,outp,newtt,depth+1,entryText+","+generateFailureModeText(ci,ep,tt)+" [AllOut]");
								handled = true;
							} else {
								Collection<TypeToken> intersection = EM2TypeSetUtil.getConstrainedTypeTokens(outp.getTypeSet(), newtt);
								for (TypeToken typeToken : intersection) {
									traceErrorPaths(ci,outp,typeToken,depth+1,entryText+","+generateFailureModeText(ci,ep,tt)+" [AllOut]");
									handled = true;
								}
							}
						}
					}
				}
			}
		}
	}
}


