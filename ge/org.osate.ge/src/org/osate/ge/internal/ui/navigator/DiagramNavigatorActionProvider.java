package org.osate.ge.internal.ui.navigator;

import java.util.Collections;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.DeleteResourceAction;
import org.eclipse.ui.actions.MoveResourceAction;
import org.eclipse.ui.actions.RenameResourceAction;
import org.eclipse.ui.ide.ResourceSelectionUtil;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.IExtensionStateModel;
import org.osate.ge.internal.Activator;

public class DiagramNavigatorActionProvider extends CommonActionProvider {
	private IExtensionStateModel stateModel;
	private StructuredViewer viewer;
	private boolean contibutedViewMenuActions = false;
	private DeleteResourceAction deleteAction;
	private RenameResourceAction renameAction;
	private MoveResourceAction moveAction;

	private IPropertyChangeListener propertyListener = event -> {
		updateActionCheckedStates();
	};

	private Action showAnnotationsAction = new Action("Show Decorations", Action.AS_CHECK_BOX) {
		@Override
		public void run() {
			DiagramNavigatorProperties.setShowAnnotations(stateModel, isChecked());
			refreshViewer();
		}
	};

	private Action groupByTypeAction = new Action("Group By Type", Action.AS_CHECK_BOX) {
		@Override
		public void run() {
			DiagramNavigatorProperties.setGroupByDiagramType(stateModel, isChecked());
			refreshViewer();
		}
	};

	private Action groupByContextAction = new Action("Group By Context", Action.AS_CHECK_BOX) {
		@Override
		public void run() {
			DiagramNavigatorProperties.setGroupByDiagramContext(stateModel, isChecked());
			refreshViewer();
		}
	};

	@Override
	public void init(final ICommonActionExtensionSite anActionSite) {
		super.init(anActionSite);
		stateModel = anActionSite.getExtensionStateModel();
		viewer = anActionSite.getStructuredViewer();

		stateModel.addPropertyChangeListener(propertyListener);

		final ISharedImages images = PlatformUI.getWorkbench().getSharedImages();
		final Tree tree = (Tree) anActionSite.getStructuredViewer().getControl();
		final IShellProvider sp = () -> anActionSite.getViewSite().getShell();

		deleteAction = new DeleteResourceAction(sp);
		deleteAction.setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		deleteAction.setImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_DELETE);

		moveAction = new MoveResourceAction(sp);
		moveAction.setActionDefinitionId(IWorkbenchCommandConstants.FILE_MOVE);

		renameAction = new RenameResourceAction(sp, tree);
		renameAction.setActionDefinitionId(IWorkbenchCommandConstants.FILE_RENAME);
	}

	@Override
	public void dispose() {
		stateModel.removePropertyChangeListener(propertyListener);
		super.dispose();
	}

	@Override
	public void fillContextMenu(final IMenuManager menu) {
		final IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();

		boolean selectionContainsOnlyResources = !selection.isEmpty() && ResourceSelectionUtil.allResourcesAreOfType(selection,
				IResource.PROJECT | IResource.FOLDER | IResource.FILE);

		if (selectionContainsOnlyResources) {
			deleteAction.selectionChanged(selection);
			menu.appendToGroup(ICommonMenuConstants.GROUP_EDIT, deleteAction);

			moveAction.selectionChanged(selection);
			menu.appendToGroup(ICommonMenuConstants.GROUP_REORGANIZE, moveAction);

			renameAction.selectionChanged(selection);
			menu.insertAfter(moveAction.getId(), renameAction);
		}

		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			final CommandContributionItem createDiagramContributionItem = new CommandContributionItem(
					new CommandContributionItemParameter(window, null, "org.osate.ge.commands.creatediagram",
							Collections.emptyMap(), null, null, null, null, null, null,
							CommandContributionItem.STYLE_PUSH, null, true));
			menu.add(createDiagramContributionItem);
		}
	}

	@Override
	public void fillActionBars(final IActionBars actionBars) {
		updateActionBars();

		// Configure actions
		actionBars.setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);
		actionBars.setGlobalActionHandler(ActionFactory.MOVE.getId(), moveAction);
		actionBars.setGlobalActionHandler(ActionFactory.RENAME.getId(), renameAction);

		// Add Actions to view menu
		if (!contibutedViewMenuActions) {
			contibutedViewMenuActions = true;
			final IMenuManager viewMenu = actionBars.getMenuManager();
			viewMenu.insertAfter(IWorkbenchActionConstants.MB_ADDITIONS, showAnnotationsAction);
			viewMenu.insertAfter(IWorkbenchActionConstants.MB_ADDITIONS, groupByContextAction);
			viewMenu.insertAfter(IWorkbenchActionConstants.MB_ADDITIONS, groupByTypeAction);

			// Set initial checked state
			updateActionCheckedStates();
		}

		super.fillActionBars(actionBars);
	}

	@Override
	public void updateActionBars() {
		final IStructuredSelection selection = (IStructuredSelection) getContext().getSelection();
		deleteAction.selectionChanged(selection);
		moveAction.selectionChanged(selection);
		renameAction.selectionChanged(selection);
		super.updateActionBars();
	}

	@Override
	public void restoreState(IMemento aMemento) {
		super.restoreState(aMemento);

		// Restore preferences.
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(DiagramNavigatorProperties.PROPERTY_SHOW_ANNOTATIONS, true);
		DiagramNavigatorProperties.setShowAnnotations(stateModel,
				store.getBoolean(DiagramNavigatorProperties.PROPERTY_SHOW_ANNOTATIONS));

		store.setDefault(DiagramNavigatorProperties.PROPERTY_GROUP_BY_DIAGRAM_TYPE, true);
		DiagramNavigatorProperties.setGroupByDiagramType(stateModel,
				store.getBoolean(DiagramNavigatorProperties.PROPERTY_GROUP_BY_DIAGRAM_TYPE));

		store.setDefault(DiagramNavigatorProperties.PROPERTY_GROUP_BY_DIAGRAM_CONTEXT, true);
		DiagramNavigatorProperties.setGroupByDiagramContext(stateModel,
				store.getBoolean(DiagramNavigatorProperties.PROPERTY_GROUP_BY_DIAGRAM_CONTEXT));
	}

	@Override
	public void saveState(final IMemento aMemento) {
		super.saveState(aMemento);

		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setValue(DiagramNavigatorProperties.PROPERTY_SHOW_ANNOTATIONS,
				DiagramNavigatorProperties.getShowAnnotations(stateModel));
		store.setValue(DiagramNavigatorProperties.PROPERTY_GROUP_BY_DIAGRAM_TYPE,
				DiagramNavigatorProperties.getGroupByDiagramType(stateModel));
		store.setValue(DiagramNavigatorProperties.PROPERTY_GROUP_BY_DIAGRAM_CONTEXT,
				DiagramNavigatorProperties.getGroupByDiagramContext(stateModel));

	}

	private void updateActionCheckedStates() {
		showAnnotationsAction.setChecked(DiagramNavigatorProperties.getShowAnnotations(stateModel));
		groupByContextAction.setChecked(DiagramNavigatorProperties.getGroupByDiagramContext(stateModel));
		groupByTypeAction.setChecked(DiagramNavigatorProperties.getGroupByDiagramType(stateModel));
	}

	private void refreshViewer() {
		viewer.getControl().setRedraw(false);
		try {
			viewer.refresh();
		} finally {
			viewer.getControl().setRedraw(true);
		}
	}
}
