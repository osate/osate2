package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;

public class Module {
	private List<Command> 			commands;
	private ComponentInstance 		aadlComponent;
	private int 					nStates;
	
	
	public Module (ComponentInstance ci)
	{
		this.commands 			= new ArrayList<Command>();
		this.aadlComponent 		= ci;
		this.nStates 			= 0;
	}
	
	public Module (ComponentInstance ci, int ns)
	{
		this (ci);
		this.nStates 			= ns;
	}
	
	public String getPrismCode ()
	{
		StringBuffer sb = new StringBuffer ();
		sb.append ("module " + aadlComponent.getName() + "\n");
		sb.append ("endmodule\n");
		return sb.toString();
	}
}
