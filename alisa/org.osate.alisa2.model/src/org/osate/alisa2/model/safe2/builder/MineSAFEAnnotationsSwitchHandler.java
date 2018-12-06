package org.osate.alisa2.model.safe2.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;

public class MineSAFEAnnotationsSwitchHandler extends AadlProcessingSwitchWithProgress {

	protected MineSAFEAnnotationsSwitchHandler(IProgressMonitor pm, int defTraversal, AnalysisErrorReporterManager errMgr) {
		super(pm, defTraversal, errMgr);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void initSwitches() {
		instanceSwitch = new MineSAFEAnnotationsSwitch();

	}

	private class MineSAFEAnnotationsSwitch extends InstanceSwitch<String> {

		@Override
		public String casePropertyAssociation(PropertyAssociation obj) {

			return DONE;
		}
	}
}
