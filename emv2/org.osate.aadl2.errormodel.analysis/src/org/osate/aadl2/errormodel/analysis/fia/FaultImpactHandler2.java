package org.osate.aadl2.errormodel.analysis.fia;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.slicer.SlicerRepresentation;
import org.osate.slicer.SlicerRepresentation.ErrorStateValidity;
import org.osate.ui.handlers.AaxlReadOnlyHandlerAsJob;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

/**
 * @since 1.2
 */
public class FaultImpactHandler2 extends AaxlReadOnlyHandlerAsJob {

	@Override
	protected String getMarkerType() {
		return "org.osate.aadl2.errormodel.analysis.handlers";
	}

	@Override
	protected String getActionName() {
		// TODO Auto-generated method stub
		return "Fault Impact Analysis";
	}

	@Override
	protected void doAaxlAction(IProgressMonitor monitor, Element root) {
		// TODO Auto-generated method stub
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
		runAnalysis(root);
		monitor.done();
	}

	public boolean runAnalysis(Element root) {
		boolean result = true;
		SystemInstance si;
		if (root instanceof InstanceObject) {
			si = ((InstanceObject) root).getSystemInstance();
		} else {
			System.err.println("A SystemInstance was not received");
			return false;
		}

		SlicerRepresentation slicer = new SlicerRepresentation();
		slicer.buildGraph(si);
		Property sinkAcceptability;

		for (ErrorSinkInstance esi : slicer.getErrorSinks(ErrorStateValidity.INVALID)) {

			// TODO: Replace usiing Fault Impact Analysis generated methods

			sinkAcceptability = FaultImpactAnalysisProperties.getAcceptable_Property(esi);
			if (!PropertyUtils.getBooleanValue(esi, sinkAcceptability)) {
				System.err.println("An unacceptable error state is reachable!");
				result = false;
			}
		}
		return result;
	}
}
