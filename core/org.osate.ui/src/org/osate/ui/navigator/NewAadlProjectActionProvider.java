package org.osate.ui.navigator;

import java.util.stream.Stream;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.navigator.wizards.WizardShortcutAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.wizards.IWizardDescriptor;

public class NewAadlProjectActionProvider extends CommonActionProvider {
	private IAction action;
	
	@Override
	public void init(ICommonActionExtensionSite aSite) {
		if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			IWorkbenchWindow window = ((ICommonViewerWorkbenchSite) aSite.getViewSite()).getWorkbenchWindow();
			IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry()
					.findWizard("org.osate.ui.wizards.AadlProjectWizardID");
			action = new WizardShortcutAction(window, descriptor);
		}
	}
	
	@Override
	public void fillContextMenu(IMenuManager menu) {
		if (action != null) {
			Stream.of(menu.getItems())
				.filter(item -> item instanceof IMenuManager)
				.map(item -> (IMenuManager) item)
				.filter(item -> "common.new.menu".equals(item.getId()))
				.findFirst()
				.ifPresent(newMenu -> {
					IContributionItem[] items = newMenu.getItems();
					newMenu.removeAll();
					newMenu.add(action);
					Stream.of(items).forEach(item -> newMenu.add(item));
				});
		}
	}
	
	@Override
	public void dispose() {
		action = null;
	}
}