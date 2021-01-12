package org.osate.analysis.flows.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.flows.FlowanalysisPlugin;
import org.osate.ui.rerun.Runner;

final class CheckFlowLatencyRunner implements Runner {
	private static final int BORDER = 0;
	private static final String NAME = "Check Flow Latency";
	private static final String ICON = "icons/checkFlowLatency.gif";
	private static final ImageDescriptor ICON_DESCRIPTOR = FlowanalysisPlugin.getImageDescriptor(ICON);

	private final String SYSTEM_LABEL = "System type: ";
	private final String[] SYSTEM_SETTINGS = new String[] { "Asynchronous system (AS)", "Synchronous system (SS)" };
	private final String PARTITION_LABEL = "Partition output policy: ";
	private final String[] PARTITION_SETTINGS = new String[] { "Major frame delayed (MF)", "Partition end (PE)" };
	private final String WORST_CASE_LABEL = "Worst-case processing time: ";
	private final String[] WORST_CASE_SETTINGS = new String[] { "Deadline (DL)",
			"Maximum compute execution time (ET)" };
	private final String BEST_CASE_LABEL = "Best-case queuing latency on incoming ports: ";
	private final String[] BEST_CASE_SETTINGS = new String[] { "Assume an empty queue (EQ)",
			"Assume a full queue (FQ)" };
	private final String QUEUING_LABEL = "Queuing latency in the results: ";
	private final String[] QUEUING_SETTINGS = new String[] { "Disabled", "Enabled" };

	// must not be null
	private final URI instanceURI;
//	// null if all the SOMs should be used, or refers to the specific SOM's URI
//	private final URI somURI;
	private final boolean asynchronousSystem;
	private final boolean majorFrameDelay;
	private final boolean worstCaseDeadline;
	private final boolean bestCaseEmptyQueue;
	private final boolean disableQueuingLatency;

	public CheckFlowLatencyRunner(final SystemInstance systemInstance,
			final boolean asynchronousSystem, final boolean majorFrameDelay, final boolean worstCaseDeadline,
			final boolean bestCaseEmptyQueue, final boolean disableQueuingLatency) {
		instanceURI = EcoreUtil.getURI(systemInstance);
//		somURI = som == null ? null : EcoreUtil.getURI(som);
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
//					&& ((somURI == null && otherRunner.somURI == null) || somURI.equals(otherRunner.somURI))
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
		return NAME;
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
	public Control createContents(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FormLayout());
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_GREEN));

		final Label systemLabel = new Label(composite, SWT.LEFT);
		systemLabel.setText(SYSTEM_LABEL);
		final Text systemText = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);
		systemText.setText(SYSTEM_SETTINGS[booleanToIndex(asynchronousSystem)]);

		final Label partitionLabel = new Label(composite, SWT.LEFT);
		partitionLabel.setText(PARTITION_LABEL);
		final Text partitionText = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);
		partitionText.setText(PARTITION_SETTINGS[booleanToIndex(majorFrameDelay)]);

		final Label worstCaseLabel = new Label(composite, SWT.LEFT);
		worstCaseLabel.setText(WORST_CASE_LABEL);
		final Text worstCaseText = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);
		worstCaseText.setText(WORST_CASE_SETTINGS[booleanToIndex(worstCaseDeadline)]);

		final Label bestCaseLabel = new Label(composite, SWT.LEFT);
		bestCaseLabel.setText(BEST_CASE_LABEL);
		final Text bestCaseText = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);
		bestCaseText.setText(BEST_CASE_SETTINGS[booleanToIndex(bestCaseEmptyQueue)]);

		final Label queuingLabel = new Label(composite, SWT.LEFT);
		queuingLabel.setText(QUEUING_LABEL);
		final Text queuingText = new Text(composite, SWT.SINGLE | SWT.READ_ONLY);
		queuingText.setText(QUEUING_SETTINGS[booleanToIndex(disableQueuingLatency)]);

		FormData data = new FormData();
		data.top = new FormAttachment(0, BORDER);
		data.left = new FormAttachment(0, BORDER);
		systemLabel.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(0, BORDER);
		data.left = new FormAttachment(systemLabel, BORDER);
		systemText.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(systemLabel, BORDER);
		data.left = new FormAttachment(0, BORDER);
		partitionLabel.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(systemText, BORDER);
		data.left = new FormAttachment(partitionLabel);
		partitionText.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(partitionLabel, BORDER);
		data.left = new FormAttachment(0, BORDER);
		bestCaseLabel.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(partitionText, BORDER);
		data.left = new FormAttachment(bestCaseLabel);
		bestCaseText.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(bestCaseLabel, BORDER);
		data.left = new FormAttachment(0, BORDER);
		worstCaseLabel.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(bestCaseText, BORDER);
		data.left = new FormAttachment(worstCaseLabel);
		worstCaseText.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(worstCaseLabel, BORDER);
		data.left = new FormAttachment(0, BORDER);
		queuingLabel.setLayoutData(data);

		data = new FormData();
		data.top = new FormAttachment(worstCaseText, BORDER);
		data.left = new FormAttachment(queuingLabel);
		queuingText.setLayoutData(data);

		return composite;
	}

	private static int booleanToIndex(final boolean value) {
		return value ? 0 : 1;
	}

	@Override
	public void run(final IProgressMonitor monitor) {
//		// XXX: taken from CheckFlowLatency.analyzeInstanceModel()
//		// XXX: Need better code sharing!
//
//		final ResourceSetImpl resourceSet = new ResourceSetImpl();
//		final SystemInstance systemInstance = (SystemInstance) resourceSet.getEObject(instanceURI, true);
//		final SystemOperationMode som = somURI == null ? null
//				: (SystemOperationMode) resourceSet.getEObject(somURI, true);
//
//		monitor.beginTask("Check flow latency", 1);
//		AnalysisResult latResult = FlowLatencyUtil.createLatencyAnalysisResult(systemInstance, asynchronousSystem,
//				majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
//
//		// Note: analyzeInstanceModel is called for each mode. We add the results to the same 'latreport'
//		FlowLatencyAnalysisSwitch flas = new FlowLatencyAnalysisSwitch(monitor, systemInstance);
////		flas.invokeOnSOM(systemInstance, xx, asynchronousSystem,
////				majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
//		latResult.getResults().addAll(flas.finalizeResults());
//		monitor.done();
	}

}
