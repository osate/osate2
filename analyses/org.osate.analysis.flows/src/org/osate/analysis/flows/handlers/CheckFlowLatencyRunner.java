package org.osate.analysis.flows.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.analysis.flows.FlowLatencyAnalysisSwitch;
import org.osate.analysis.flows.FlowanalysisPlugin;
import org.osate.analysis.flows.internal.utils.FlowLatencyUtil;
import org.osate.result.AnalysisResult;
import org.osate.ui.rerun.Runner;

final class CheckFlowLatencyRunner implements Runner {
	private static final String NAME = "Check Flow Latency";
	private static final String ICON = "icons/checkFlowLatency.gif";
	private static final ImageDescriptor ICON_DESCRIPTOR = FlowanalysisPlugin.getImageDescriptor(ICON);

	// must not be null
	private final URI instanceURI;
	// null if all the SOMs should be used, or refers to the specific SOM's URI
	private final URI somURI;
	private final boolean asynchronousSystem;
	private final boolean majorFrameDelay;
	private final boolean worstCaseDeadline;
	private final boolean bestCaseEmptyQueue;
	private final boolean disableQueuingLatency;

	public CheckFlowLatencyRunner(final SystemInstance systemInstance, final SystemOperationMode som,
			final boolean asynchronousSystem, final boolean majorFrameDelay, final boolean worstCaseDeadline,
			final boolean bestCaseEmptyQueue, final boolean disableQueuingLatency) {
		instanceURI = EcoreUtil.getURI(systemInstance);
		somURI = som == null ? null : EcoreUtil.getURI(som);
		this.asynchronousSystem = asynchronousSystem;
		this.majorFrameDelay = majorFrameDelay;
		this.worstCaseDeadline = worstCaseDeadline;
		this.bestCaseEmptyQueue = bestCaseEmptyQueue;
		this.disableQueuingLatency = disableQueuingLatency;
	}

	@Override
	public boolean equals(final Object other) {
		if (other instanceof CheckFlowLatencyRunner) {
			final CheckFlowLatencyRunner otherRunner = (CheckFlowLatencyRunner) other;
			return instanceURI.equals(otherRunner.instanceURI) && asynchronousSystem == otherRunner.asynchronousSystem
					&& ((somURI == null && otherRunner.somURI == null) || somURI.equals(otherRunner.somURI))
					&& majorFrameDelay == otherRunner.majorFrameDelay
					&& worstCaseDeadline == otherRunner.worstCaseDeadline
					&& bestCaseEmptyQueue == otherRunner.bestCaseEmptyQueue
					&& disableQueuingLatency == otherRunner.disableQueuingLatency;
		} else {
			return false;
		}
	}

	@Override
	public String getName() {
		return NAME + " " + getDescription();
	}

	@Override
	public URI getInstanceURI() {
		return instanceURI;
	}

	@Override
	public String getDescription() {
		return asynchronousSystem + " " + majorFrameDelay + " " + worstCaseDeadline + " " + bestCaseEmptyQueue + " "
				+ disableQueuingLatency;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return ICON_DESCRIPTOR;
	}

	@Override
	public void run(final IProgressMonitor monitor) {
		// XXX: taken from CheckFlowLatency.analyzeInstanceModel()
		// XXX: Need better code sharing!

		final ResourceSetImpl resourceSet = new ResourceSetImpl();
		final SystemInstance systemInstance = (SystemInstance) resourceSet.getEObject(instanceURI, true);
		final SystemOperationMode som = somURI == null ? null
				: (SystemOperationMode) resourceSet.getEObject(somURI, true);

		monitor.beginTask("Check flow latency", 1);
		AnalysisResult latResult = FlowLatencyUtil.createLatencyAnalysisResult(systemInstance, asynchronousSystem,
				majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);

		// Note: analyzeInstanceModel is called for each mode. We add the results to the same 'latreport'
		FlowLatencyAnalysisSwitch flas = new FlowLatencyAnalysisSwitch(monitor, systemInstance);
//		flas.invokeOnSOM(systemInstance, xx, asynchronousSystem,
//				majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
		latResult.getResults().addAll(flas.finalizeResults());
		monitor.done();

	}

}
