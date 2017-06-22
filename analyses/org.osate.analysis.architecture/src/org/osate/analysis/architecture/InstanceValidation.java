package org.osate.analysis.architecture;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class InstanceValidation {
	private final AbstractAaxlHandler handler;
	private boolean isOK = true;

	public InstanceValidation(final AbstractAaxlHandler handler) {
		this.handler = handler;
	}

	public boolean checkReferenceProcessor(SystemInstance root) {
		isOK = true;
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkForReferenceProcessor(obj);
			}
		};
		mal.processPreOrderComponentInstance(root, ComponentCategory.THREAD);
		return isOK;
	}

	protected void checkForReferenceProcessor(Element obj) {
		if (obj instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) obj;
			double et = GetProperties.getMaximumComputeExecutionTimeinSec(ci);
			if (et != 0) {
				ComponentClassifier refproc = GetProperties.getReferenceProcessor(ci);
				if (refproc == null) {
					isOK = false;
					handler.error(ci, "Thread instance " + ci.getComponentInstancePath()
							+ " has execution time, but no Reference_Processor. Please this property.");
				}
			}
		}

	}

}
