package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

public class Module {
	private List<Command> 	commands;
	private String 			name;
	private int 			nStates;
	
	
	public Module (String n, int ns)
	{
		this.commands 	= new ArrayList<Command>();
		this.name 		= n;
		this.nStates 	= ns;
	}
}
