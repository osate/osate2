package org.osate.ui.handlers;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.dialogs.AnalysisRunsDialog;
import org.osate.ui.rerun.RerunManager;
import org.osate.ui.rerun.Runner;

/**
 * @since 6.0
 */
public final class RerunAnalysisDynamicMenuContribution extends ContributionItem {
	private final RerunManager rerunManager = OsateUiPlugin.getRerunManager();

	private static final String ID = "org.osage.ui.rerunDynamic";
	private static final String ICON = "icons/rerun_analysis.gif";
	private static final ImageDescriptor ICON_DESCRIPTOR = OsateUiPlugin.getImageDescriptor(ICON);

	private final IMenuListener menuListener = manager -> fillMenu(manager);
	private final Separator separator = new Separator();
	private final Action showConfigurationsAction = new Action("Analysis Configurations...") {
		@Override
		public void run() {
			System.out.println("Hi!");
			final AnalysisRunsDialog d = new AnalysisRunsDialog(Display.getDefault().getActiveShell());
			d.open();
		}
	};

	// TODO: This should be shared with or the same as RerunAnalysisHandler
	private static final class RerunAction extends Action {
		final Runner runner;

		public RerunAction(final Runner runner) {
			super(runner.getName(), RerunAnalysisDynamicMenuContribution.getImageDescriptor(runner));
			this.runner = runner;
		}

		@Override
		public void run() {
			System.out.println(runner.getName());
			runner.run(new NullProgressMonitor());
		}
	}

	private static final ImageDescriptor getImageDescriptor(final Runner runner) {
		ImageDescriptor id = runner.getImageDescriptor();
		if (id == null) {
			id = ICON_DESCRIPTOR;
		}
		return id;
	}

	public RerunAnalysisDynamicMenuContribution() {
		super(ID);
	}

	@Override
	public void fill(final Menu menu, final int index) {
		if (getParent() != null) {
			((MenuManager) getParent()).setRemoveAllWhenShown(true);
			((MenuManager) getParent()).addMenuListener(menuListener);
		}
	}

	private void fillMenu(final IMenuManager menuManager) {
		final List<Runner> runners = rerunManager.getPastRuns();
		for (final Runner runner : runners) {
			menuManager.add(new RerunAction(runner));
		}
		menuManager.add(separator);
		menuManager.add(showConfigurationsAction);
	}
}
