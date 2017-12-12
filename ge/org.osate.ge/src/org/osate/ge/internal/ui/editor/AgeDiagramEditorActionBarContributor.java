package org.osate.ge.internal.ui.editor;

import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.ZoomComboContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;

public class AgeDiagramEditorActionBarContributor extends org.eclipse.graphiti.ui.editor.DiagramEditorActionBarContributor {
	final ModeContributionItem selectedModeItem;
	final FlowContributionItem selectedFlowItem;
	DummyContributionItem dummyItem;

	public AgeDiagramEditorActionBarContributor() {
		selectedModeItem = new ModeContributionItem("org.osate.ge.ui.editor.items.selected_mode");
		selectedFlowItem = new FlowContributionItem("org.osate.ge.ui.editor.items.selected_flow");
		dummyItem = new DummyContributionItem("org.osate.ge.ui.editor.items.dummy");
	}

	@Override
	public void dispose() {
		selectedModeItem.setActiveEditor(null);
		selectedFlowItem.setActiveEditor(null);
		super.dispose();
	}

	@Override
	public void contributeToToolBar(final IToolBarManager tbm) {
		// Don't call base class. Want to override completely.
		// super.contributeToToolBar(tbm);

		tbm.add(getAction(GEFActionConstants.ZOOM_OUT));
		tbm.add(getAction(GEFActionConstants.ZOOM_IN));
		ZoomComboContributionItem zoomCombo = new ZoomComboContributionItem(getPage());
		tbm.add(zoomCombo);

		tbm.add(new Separator());

		tbm.add(selectedModeItem);
		tbm.add(new Separator());
		tbm.add(selectedFlowItem);
		tbm.add(new Separator());
		tbm.add(dummyItem);
	}

	@Override
	public void contributeToMenu(IMenuManager menubar) {
		// Forked from Graphiti version so that the Align menu can be removed.
		// Don't call base class.
		// super.contributeToMenu(menubar);
		IMenuManager editMenu = menubar.findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);

		// Create view menu ...
		MenuManager viewMenu = new MenuManager("View", MENU_ID_VIEW);
		viewMenu.add(getAction(GEFActionConstants.ZOOM_IN));
		viewMenu.add(getAction(GEFActionConstants.ZOOM_OUT));
		viewMenu.add(getAction(GEFActionConstants.TOGGLE_GRID_VISIBILITY));
		viewMenu.add(getAction(GEFActionConstants.TOGGLE_SNAP_TO_GEOMETRY));

		// ... and add it. The position of the view menu differs depending on
		// which menus exist (see Bugzilla
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=381437)
		if (editMenu != null) {
			// Edit menu exists --> place view menu directly in front of it
			menubar.insertAfter(IWorkbenchActionConstants.M_EDIT, viewMenu);
		} else if (menubar.findMenuUsingPath(IWorkbenchActionConstants.M_FILE) != null) {
			// File menu exists --> place view menu behind it
			menubar.insertAfter(IWorkbenchActionConstants.M_FILE, viewMenu);
		} else {
			// Add view menu as first entry
			IContributionItem[] contributionItems = menubar.getItems();
			if (contributionItems != null && contributionItems.length > 0) {
				// Any menu exists --> place view menu in front of it it
				menubar.insertBefore(contributionItems[0].getId(), viewMenu);
			} else {
				// No item exists --> simply add view menu
				menubar.add(viewMenu);
			}
		}

		addSaveAsImageEntryToMenu(menubar);
	}

	@Override
	public final void setActiveEditor(final IEditorPart editor) {
		super.setActiveEditor(editor);
		selectedModeItem.setActiveEditor(editor);
		selectedFlowItem.setActiveEditor(editor);
	}

}
