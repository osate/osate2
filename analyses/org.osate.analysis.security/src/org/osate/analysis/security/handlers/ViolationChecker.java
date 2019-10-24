package org.osate.analysis.security.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.analysis.security.RuleViolationChecker;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelReadOnlyHandler;

public class ViolationChecker extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {

	@Override
	protected String getActionName() {
		return "Check security violations";
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root, SystemOperationMode som) {
		invoke(monitor, null, root, som);
	}

	public void invoke(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {
		this.errManager = errManager != null ? errManager
				: new AnalysisErrorReporterManager(getAnalysisErrorReporterFactory());
		analyzeInstanceModel(monitor, this.errManager, root, som);
	}

	@Override
	protected boolean canAnalyzeDeclarativeModels() {
		return false;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
	}

	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			SystemInstance root, SystemOperationMode som) {
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
		final RuleViolationChecker checker = new RuleViolationChecker(errManager);
		checker.processPostOrderAll(root);
		monitor.done();
	}

}
