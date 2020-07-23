/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *
 */
package org.osate.aadl2.instance.presentation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.action.CollapseAllAction;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.edit.ui.action.ExpandAllAction;
import org.eclipse.emf.edit.ui.action.FindAction;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.emf.edit.ui.action.RevertAction;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.provider.EndToEndFlowInstanceItemProvider.EndToEndFlowInstanceFlowElementItemProvider;
import org.osate.aadl2.instance.provider.SystemOperationModeItemProvider.SubModeItemProvider;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.UiUtil;

/**
 * This is the action bar contributor for the Instance model editor.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InstanceActionBarContributor extends EditingDomainActionBarContributor
		implements ISelectionChangedListener {
	/**
	 * This keeps track of the active editor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IEditorPart activeEditorPart;

	/**
	 * This keeps track of the current selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ISelectionProvider selectionProvider;

	protected Object currentSelection;
	/**
	 * This action opens the Properties view.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction showPropertiesViewAction = new Action(
			Aadl2EditorPlugin.INSTANCE.getString("_UI_ShowPropertiesView_menu_item")) //$NON-NLS-1$
	{
		@Override
		public void run() {
			try {
				getPage().showView("org.eclipse.ui.views.PropertySheet"); //$NON-NLS-1$
			} catch (PartInitException exception) {
				Aadl2EditorPlugin.INSTANCE.log(exception);
			}
		}
	};

	/**
	 * This action refreshes the viewer of the current editor if the editor
	 * implements {@link org.eclipse.emf.common.ui.viewer.IViewerProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IAction refreshViewerAction = new Action(
			Aadl2EditorPlugin.INSTANCE.getString("_UI_RefreshViewer_menu_item")) //$NON-NLS-1$
	{
		@Override
		public boolean isEnabled() {
			return activeEditorPart instanceof IViewerProvider;
		}

		@Override
		public void run() {
			if (activeEditorPart instanceof IViewerProvider) {
				Viewer viewer = ((IViewerProvider) activeEditorPart).getViewer();
				if (viewer != null) {
					viewer.refresh();
				}
			}
		}
	};

	/**
	 * This creates an instance of the contributor.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceActionBarContributor() {
		super(ADDITIONS_LAST_STYLE);
		loadResourceAction = new LoadResourceAction();
		validateAction = new ValidateAction();
		controlAction = new ControlAction();
		findAction = FindAction.create();
		revertAction = new RevertAction();
		expandAllAction = new ExpandAllAction();
		collapseAllAction = new CollapseAllAction();
	}

	/**
	 * This adds Separators for editor additions to the tool bar.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void contributeToToolBar(IToolBarManager toolBarManager) {
		super.contributeToToolBar(toolBarManager);
		toolBarManager.add(new Separator("instance-settings")); //$NON-NLS-1$
		toolBarManager.add(new Separator("instance-additions")); //$NON-NLS-1$
	}

	/**
	 * This adds to the menu bar a menu and some separators for editor additions,
	 * as well as the sub-menus for object creation items.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void contributeToMenu(IMenuManager menuManager) {
		super.contributeToMenu(menuManager);

		IMenuManager submenuManager = new MenuManager(Aadl2EditorPlugin.INSTANCE.getString("_UI_InstanceEditor_menu"), //$NON-NLS-1$
				"org.osate.aadl2.instanceMenuID"); //$NON-NLS-1$
		menuManager.insertAfter("additions", submenuManager); //$NON-NLS-1$
		submenuManager.add(new Separator("settings")); //$NON-NLS-1$
		submenuManager.add(new Separator("actions")); //$NON-NLS-1$
		submenuManager.add(new Separator("additions")); //$NON-NLS-1$
		submenuManager.add(new Separator("additions-end")); //$NON-NLS-1$

		// Add your contributions.
		// Ensure that you remove @generated or mark it @generated NOT

		addGlobalActions(submenuManager);
	}

	/**
	 * When the active editor changes, this remembers the change and registers with it as a selection provider.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setActiveEditor(IEditorPart part) {
		super.setActiveEditor(part);
		activeEditorPart = part;

		// Switch to the new selection provider.
		//
		if (selectionProvider != null) {
			selectionProvider.removeSelectionChangedListener(this);
		}
		if (part == null) {
			selectionProvider = null;
		} else {
			selectionProvider = part.getSite().getSelectionProvider();
			selectionProvider.addSelectionChangedListener(this);

			// Fake a selection changed event to update the menus.
			//
			if (selectionProvider.getSelection() != null) {
				selectionChanged(new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection()));
			}
		}
	}

	/**
	 * This implements {@link org.eclipse.jface.viewers.ISelectionChangedListener},
	 * handling {@link org.eclipse.jface.viewers.SelectionChangedEvent}s by querying for the children and siblings
	 * that can be added to the selected object and updating the menus accordingly.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection && ((IStructuredSelection) selection).size() == 1) {
			currentSelection = ((IStructuredSelection) selection).getFirstElement();
		}
	}

	/**
	 * This populates the pop-up menu before it appears.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void menuAboutToShow(IMenuManager menuManager) {
		super.menuAboutToShow(menuManager);
		if (selectionProvider.getSelection() instanceof EndToEndFlowInstanceFlowElementItemProvider) {
			menuManager.insertAfter(gotoSrcTextAction.getId(), gotoFlowElement);
		} else if (selectionProvider.getSelection() instanceof SubModeItemProvider) {
			menuManager.insertAfter(gotoSrcTextAction.getId(), gotoModeInstance);
		}
	}

	/**
	 * This inserts global actions before the "additions-end" separator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	protected void addGlobalActions(IMenuManager menuManager) {
		menuManager.insertAfter("additions-end", new Separator("ui-actions")); //$NON-NLS-1$ //$NON-NLS-2$
		menuManager.insertAfter("ui-actions", showPropertiesViewAction); //$NON-NLS-1$
		menuManager.insertAfter("ui-actions", gotoSrcTextAction);

		refreshViewerAction.setEnabled(refreshViewerAction.isEnabled());
		menuManager.insertAfter("ui-actions", refreshViewerAction); //$NON-NLS-1$

		super.addGlobalActions(menuManager);
	}

	/**
	 * This ensures that a delete action will clean up all references to deleted objects.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean removeAllReferencesOnDelete() {
		return true;
	}

	protected IAction gotoSrcTextAction = new Action(Aadl2EditorPlugin.INSTANCE.getString("_UI_GotoSource_menu_item")) {
		{
			setId("Aadl2ActionBarContributor.gotoSrcTextAction");
		}

		@Override
		public void run() {
			if (activeEditorPart instanceof InstanceEditor) {
				InstanceEditor editor = (InstanceEditor) activeEditorPart;

				if (currentSelection instanceof InstanceObject) {
					if (editor.isDirty()) {
						editor.doSave(null);
					}
					UiUtil.gotoInstanceObjectSource(activeEditorPart.getSite().getPage(),
							(InstanceObject) currentSelection);
				} else if (currentSelection instanceof PropertyAssociationInstance) {
					if (editor.isDirty()) {
						editor.doSave(null);
					}
					UiUtil.gotoInstanceObjectSource(activeEditorPart.getSite().getPage(),
							(PropertyAssociationInstance) currentSelection);
				} else if (currentSelection instanceof EndToEndFlowInstanceFlowElementItemProvider) {
					if (editor.isDirty()) {
						editor.doSave(null);
					}
					UiUtil.gotoInstanceObjectSource(activeEditorPart.getSite().getPage(),
							((EndToEndFlowInstanceFlowElementItemProvider) currentSelection).getFlowElement());
				} else if (currentSelection instanceof SubModeItemProvider) {
					if (editor.isDirty()) {
						editor.doSave(null);
					}
					UiUtil.gotoInstanceObjectSource(activeEditorPart.getSite().getPage(),
							((SubModeItemProvider) currentSelection).getSubMode());
				}
			}
		}
	};

	protected IAction gotoFlowElement = new Action("Goto Flow Element") {
		@Override
		public void run() {
			gotoInstanceObject(
					((EndToEndFlowInstanceFlowElementItemProvider) currentSelection).getFlowElement());
		}
	};

	protected IAction gotoModeInstance = new Action("Goto Mode Instance") {
		@Override
		public void run() {
			gotoInstanceObject(((SubModeItemProvider) currentSelection).getSubMode());
		}
	};

	private void gotoInstanceObject(InstanceObject io) {
		IFile instanceFile = OsateResourceUtil.toIFile(io.eResource().getURI());
		try {
			IMarker gotoMarker = instanceFile.createMarker(AadlConstants.AADLGOTOMARKER);
			gotoMarker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(io).toString());
			IDE.openEditor(getPage(), gotoMarker);
			instanceFile.deleteMarkers(AadlConstants.AADLGOTOMARKER, false, IResource.DEPTH_ZERO);
		} catch (CoreException e) {
			Aadl2EditorPlugin.INSTANCE.log(e);
		}
	}

}
