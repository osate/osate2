package org.osate.ui.handlers;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Menu;
import org.osate.ui.OsateUiPlugin;

/**
 * @since 6.0
 */
public final class RerunAnalysisDynamicMenuContribution extends ContributionItem {
	private static final String ID = "org.osage.ui.rerunDynamic";
	private static final String ICON = "icons/rerun_analysis.gif";

	private final IMenuListener menuListener = manager -> fillMenu(manager);

	private final class TestAction extends Action {
		public TestAction(final int id) {
			super("Action " + id, OsateUiPlugin.getImageDescriptor(ICON));
		}

		@Override
		public void run() {
			System.out.println(getText());
		}
	}

	private final TestAction[] actions = new TestAction[10];

	public RerunAnalysisDynamicMenuContribution() {
		super(ID);
		for (int i = 0; i < 10; i++) {
			actions[i] = new TestAction(i + 1);
		}
	}

	@Override
	public void setParent(IContributionManager parent) {
		super.setParent(parent);
		System.out.println("setParent: parent is " + parent);
	}

	@Override
	public void fill(Menu menu, int index) {
		System.out.println("fill() called with index = " + index);
		System.out.println("  parent is " + getParent());

		if (getParent() != null) {
			((MenuManager) getParent()).setRemoveAllWhenShown(true);
			((MenuManager) getParent()).addMenuListener(menuListener);
		}
	}

	private volatile int count = 0;

	private void fillMenu(final IMenuManager menuManager) {
		System.out.println("Fill menu");

		count += 1;
		if (count == 11) {
			count = 1;
		}
		for (int i = 0; i < count; i++) {
			menuManager.add(actions[i]);
		}
	}
}
