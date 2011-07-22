package org.osate.xtext.aadl2.ui.outline;

import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;

public class Aadl2OutlinePage extends OutlinePage {

	private Menu contextMenu;
	private static final String contextMenuID = "Aadl2OutlineContextMenu";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.outline.impl.OutlinePage#createC
	 * ontrol(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);

		configureContextMenu();
	}

	protected void configureContextMenu() {
		MenuManager manager = new MenuManager(contextMenuID, contextMenuID);
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		contextMenu = manager.createContextMenu(getTreeViewer().getTree());
		getTreeViewer().getTree().setMenu(contextMenu);

		IPageSite site = getSite();
		site.registerContextMenu(
				"org.osate.xtext.aadl2.ui.outline", manager, getTreeViewer()); //$NON-NLS-1$
	}

	protected void fillContextMenu(IMenuManager menu) {
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.outline.impl.OutlinePage#getDefa
	 * ultExpansionLevel()
	 */
	@Override
	protected int getDefaultExpansionLevel() {
		return 2;
	}

}
