package org.osate.assure.ui.handlers;

import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
		// TODO Auto-generated constructor stub
	}
	  public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
		    return new ActionBarAdvisor(configurer);
		  }

		  public void preWindowOpen() {
		    IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		    configurer.setInitialSize(new Point(400, 300));
		    configurer.setShowStatusLine(false);
		    configurer.setShowCoolBar(true);
		    configurer.setTitle("RCP Application");
		  }
}
