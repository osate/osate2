/*
 * <copyright>
 * Copyright  2012-2013 by Carnegie Mellon University, all rights reserved.
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



/**
 * Also, this class implement the following consistency rule from
 * the official documentation:
 * C1, C5, C7, C11, C12 
 * 
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AbstractConnectionEnd;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.errormodel.analysis.ComponentSelectionDialog;
import org.osate.aadl2.errormodel.analysis.fta.Event;
import org.osate.aadl2.errormodel.analysis.fta.FTAUtils;
import org.osate.aadl2.impl.ConnectedElementImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.util.OsateDebug;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.EventOrPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.SAndExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SOrExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.AnalysisModel;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Properties;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathRecord;
import org.osate.xtext.aadl2.errormodel.util.PropagationPathEnd;


public final class ContextTableAction extends AaxlReadOnlyActionAsJob {
	AnalysisModel model;
	static String ERROR_STATE_NAME;

	
	protected String getMarkerType() {
		return "org.osate.aadl2.errormodel.analysis.FaultImpactMarker";
	}

	protected String getActionName() {
		return "ContextTable";
	}
	
	
	public void doAaxlAction(IProgressMonitor monitor, Element obj) 
	{
		List<ComponentInstance> subcomponents;
		boolean firstPassed;
		
		monitor.beginTask("Generating Context Table", IProgressMonitor.UNKNOWN);
		// Get the system instance (if any)
		SystemInstance si;
		if (obj instanceof InstanceObject){
			si = ((InstanceObject)obj).getSystemInstance();
		}
		else return;
		
		/**
		 * Initialize the report to write
		 */
		WriteToFile report = new WriteToFile("ContextTable", si);
	
		final Display d = PlatformUI.getWorkbench().getDisplay();
		d.syncExec(new Runnable(){

			public void run() {
				IWorkbenchWindow window;
				Shell sh;
				window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				sh = window.getShell();
//				ComponentSelectionDialog csd;
//				csd = new ComponentSelectionDialog(sh, componentsList);
//				selectedComponents = csd.open();
				
				InputDialog fd = new InputDialog(sh, "Error State name", "Please specify the name of the error state name", "failed", null);
				if (fd.open() == Window.OK)
				{
					ERROR_STATE_NAME = fd.getValue();
				}
				else
				{
					ERROR_STATE_NAME = null;
				}
			}
		});
		
		report.addOutputNewline("Analyze for the hazard state " + ERROR_STATE_NAME);
		report.addOutput("\n");
		
		
		/**
		 * We get all the subcomponents of the system instance
		 * to analyze. We add a column for each of then.
		 */
		subcomponents = new ArrayList<ComponentInstance> ();
		firstPassed = false;
		
		for (ComponentInstance ci : si.getComponentInstances())
		{
			if (firstPassed == true)
			{
				report.addOutput(",");
			}
			
			firstPassed = true;
			report.addOutput(ci.getName());
			subcomponents.add(ci);
		}
		report.addOutput("\n");
		
		
		/**
		 * Then, for each state of the composite error state, we
		 * add a line and show the status for each other component.
		 * Either this is a DNM (Does Not Matter) or an error behavior
		 * status.
		 */
		for (CompositeState state : EMV2Util.getAllCompositeStates(si))
		{
			firstPassed = false;
			
			String stateName = state.getState().getName();
			if (state.getTypedToken() != null)
			{
				stateName += state.getTypedToken().getType().get(0).getName();
			}
			
			if (stateName.equalsIgnoreCase(ERROR_STATE_NAME))
			{
			
				List<ConditionElement> elements = new ArrayList<ConditionElement>();
	
				getAllConditionLeafs (state.getCondition(), elements);
				
				
				for (ComponentInstance ci : subcomponents)
				{
					if (firstPassed == true)
					{
						report.addOutput(",");
					}
					firstPassed = true;
					
					boolean found = false;
					for (ConditionElement el : elements)
					{
						SubcomponentElement sel = el.getSubcomponents().get(0);
						OsateDebug.osateDebug("el = "  + sel.getSubcomponent().getContainingClassifier());
						OsateDebug.osateDebug("ci = "  + ci.getComponentClassifier());
	
						if (sel.getSubcomponent().getClassifier() == ci.getComponentClassifier())
						{
							report.addOutput(el.getState().getName());
							found = true;
						}
						
						
					}
					
					if (! found)
					{
						report.addOutput("DNM");
	
					}
				}

				report.addOutput("\n");
			}
						
		}
		
		report.addOutput("\n");
		report.addOutputNewline("Error descriptions");
		report.addOutputNewline("DNM, Does not matter");
		for (ComponentInstance io : subcomponents)
		{
			for (ErrorBehaviorState ebs : EMV2Util.getErrorBehaviorStateMachine(io).getStates())
			{
				String txt = "";
				String description = EMV2Properties.getDescription(ebs, io);
				String failure     = EMV2Properties.getFailure(ebs, io);
				if (failure != null)
				{
					txt += failure;
				}
				
				if (description != null)
				{
					txt += description;
				}
				
				if (txt.length() > 0)
				{
					report.addOutputNewline(io.getName()+"/"+ebs.getName() + "," + txt);
				}
			}
		}
		report.addOutput("\n");
		
		
		report.saveToFile();
		
		monitor.done();
	}

	
	private void getAllConditionLeafs (ConditionExpression ce, List<ConditionElement> result)
	{
		if (ce instanceof SAndExpression)
		{
			SAndExpression sae = (SAndExpression) ce;
			for (ConditionExpression cetmp : sae.getOperands())
			{
				getAllConditionLeafs (cetmp, result);
			}
		}
		if (ce instanceof SOrExpression)
		{
			SOrExpression soe = (SOrExpression) ce;
			for (ConditionExpression cetmp : soe.getOperands())
			{
				getAllConditionLeafs (cetmp, result);
			}
		}
		
		if (ce instanceof ConditionElement)
		{
			result.add((ConditionElement)ce);
		}
	}
		

}
