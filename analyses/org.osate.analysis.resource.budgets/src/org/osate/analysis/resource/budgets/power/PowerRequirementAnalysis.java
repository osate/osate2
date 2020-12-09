package org.osate.analysis.resource.budgets.power;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.ResultType;
import org.osate.result.util.ResultUtil;
import org.osate.ui.dialogs.Dialog;

public class PowerRequirementAnalysis {
	private static final String INITIAL_MODE_LABEL = "Initial Mode";
	private static final String CHOOSE_MODE_LABEL = "Choose Mode...";
	private static final String ALL_MODES_LABEL = "All Modes";

	private static final String[] ALL_MODE_CHOICE_LABELS = { INITIAL_MODE_LABEL, CHOOSE_MODE_LABEL, ALL_MODES_LABEL };

	private static final int INITIAL_MODE = 0;
	private static final int CHOOSE_MODE = 1;

	private static final int DEFAULT_MODE_CHOICE = INITIAL_MODE;

	private int lastDefaultModeChoice = DEFAULT_MODE_CHOICE;

	public PowerRequirementAnalysis() {
		super();
	}

	public AnalysisResult invoke(final IProgressMonitor monitor, final SystemInstance systemInstance) {
		final IProgressMonitor pm = monitor == null ? new NullProgressMonitor() : monitor;
		return analyzeBody(pm, systemInstance);
	}

	private AnalysisResult analyzeBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			final SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			final AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Power  Requirements", root);
			analysisResult.setResultType(ResultType.SUCCESS);
			analysisResult.setMessage("Power requirements analysis of " + root.getFullName());

			final SystemInstance si = root;
			final int whichMode;

			if (si.getSystemOperationModes().size() > 1) {
				whichMode = Dialog.askQuestion("Choose Mode",
						"Please choose in which mode(s) the model should be analyzed.", ALL_MODE_CHOICE_LABELS,
						lastDefaultModeChoice);
			} else {
				// A system with no modes still has at least one SOM named NORMAL_SOM_NAME aka "no modes"
				whichMode = INITIAL_MODE;
			}

			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();
				final Result somResult = ResultUtil.createResult(
						Aadl2Util.isPrintableSOMName(som) ? Aadl2Util.getPrintableSOMMembers(som) : "", som,
						ResultType.SUCCESS);
				analysisResult.getResults().add(somResult);

				// final BusLoadModel model = BusLoadModel.buildModel(root, som);

				// Analyze the model
				// model.visit(new PowerAnalysisVisitor(somResult));
			}
			monitor.done();

			return analysisResult;
		} else {
			Dialog.showError("Power Requirements Analysis Error", "Can only check system instances");
			return null;
		}
	}
}