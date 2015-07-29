package org.osate.ge.ui.tools;

import org.osate.ge.ui.tools.annotations.Activate;
import org.osate.ge.ui.tools.annotations.CanActivate;
import org.osate.ge.ui.tools.annotations.Deactivate;
import org.osate.ge.ui.tools.annotations.Id;
import org.osate.ge.ui.tools.annotations.SelectionChanged;

public class CreateFlowImplementationTool {
	@Id
	public final static String ID = "org.osate.ge.ui.tools.CreateFlowImplementationTool";
	
	// TODO
	//@Icon
	//public final static ImageDescriptor ICON = Activator.getImageDescriptor("icons/CreateFlowImplementation.gif");	
	
	@CanActivate
	public boolean canActivate() {
		// TODO
		return true;
	}
	
	@Activate
	public void activate() {
		// TODO
	}
	
	@Deactivate
	public void deactivate() {
		// TODO
	}
	
	@SelectionChanged
	public void onSelectionChanged() {
		// TODO
	}	
}
