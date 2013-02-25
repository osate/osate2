package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;

public class Module {
	private List<Command> 			commands;
	private ComponentInstance 		aadlComponent;
	private int 					nStates;
	private Model					associatedModel;
	
	public Module (ComponentInstance ci, Model m)
	{
		this.commands 			= new ArrayList<Command>();
		this.associatedModel    = m;
		this.aadlComponent 		= ci;
		this.nStates 			= 0;
	}
	
	public Module (ComponentInstance ci, Model m, int ns)
	{
		this (ci, m);
		this.nStates 			= ns;
	}
	
	public String getPrismCode ()
	{
		StringBuffer sb = new StringBuffer ();
		sb.append ("module " + aadlComponent.getName() + "\n");
		sb.append ("endmodule\n");
		return sb.toString();
	}
	
	public void process ()
	{
		ComponentErrorBehavior errorBehavior = EM2Util.getComponentErrorBehavior (aadlComponent.getComponentClassifier());
		ErrorBehaviorStateMachine stateMachine = EM2Util.getContainingErrorBehaviorStateMachine(aadlComponent.getComponentClassifier());
		
		
		if (stateMachine != null)
		{
			OsateDebug.osateDebug("state machine" );

			for (ErrorBehaviorState behaviorState : stateMachine.getStates())
			{
				OsateDebug.osateDebug("state" + behaviorState);

			}
		}
		
		if (errorBehavior != null)
		{
			OsateDebug.osateDebug("errors detections" );

			for (ErrorDetection ed : errorBehavior.getErrorDetections())
			{
				OsateDebug.osateDebug("error" + ed);
			}
		}
		
		for (Element e : aadlComponent.getChildren())
		{
			if (e instanceof ComponentInstance)
			{
				ComponentInstance ci = (ComponentInstance)e;
				Module m = new Module (ci, associatedModel);
				m.process ();
				this.associatedModel.addModule (m);
			}
		}
	}
}
