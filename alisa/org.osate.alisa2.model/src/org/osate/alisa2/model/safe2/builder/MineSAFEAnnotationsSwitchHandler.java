package org.osate.alisa2.model.safe2.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;

/* see
 * /org.osate.analysis.architecture.tests/src/org/osate/analysis/architecture/tests/CheckBindingConstraintsTest.xtend
 * and
 * /org.osate.core.tests/models/issue1620 + /org.osate.core.tests/src/org/osate/core/tests/issues/Issue1620Test.xtend
 * and
 * http://osate.org/dev/writing-tests.html#examples
 * */
public class MineSAFEAnnotationsSwitchHandler extends AadlProcessingSwitchWithProgress {

	private MineSAFEAnnotationsSwitchHandler(IProgressMonitor pm) {
		super(pm);
		// TODO Auto-generated constructor stub
	}

	public MineSAFEAnnotationsSwitchHandler() {
		this(new NullProgressMonitor());
	}

	public boolean propFound = false;

	@Override
	protected void initSwitches() {
		instanceSwitch = new MineSAFEAnnotationsSwitch();

	}

	private class MineSAFEAnnotationsSwitch extends InstanceSwitch<String> {

		@Override
		public String casePropertyAssociation(PropertyAssociation obj) {
			propFound = true;
			return DONE;
		}
	}
}
