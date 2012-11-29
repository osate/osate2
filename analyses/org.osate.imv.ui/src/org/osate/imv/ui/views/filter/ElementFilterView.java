/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.ui.views.filter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.osate.imv.model.IImvModelProvider;



public class ElementFilterView extends ViewPart implements IPartListener {

	// View ID.
	public static final String ID = "edu.erau.osate.imv.ui.views.elementFilterView";

	private static final IImvModelProvider NO_ACTIVE_MODEL_PROVIDER = null;

	private Composite parent;

	private Action openFeatureFilterViewAction;
	private Action openComponentFilterViewAction;

	private FilterPanel featureFilterPanel;
	private FilterPanel componentFilterPanel;

	private IImvModelProvider activeModelProvider = NO_ACTIVE_MODEL_PROVIDER;

	private StackLayout stackLayout;

	public ElementFilterView() {
		// Explicitly do nothing.
	}

	@Override
	public void dispose() {
		this.getSite().getWorkbenchWindow().getPartService().removePartListener(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;

		createActions();
		createMenu();

		// We will use stack layout.
		stackLayout = new StackLayout();

		parent.setLayout(stackLayout); // Occupy entire control.

		featureFilterPanel = new FilterPanel(parent, SWT.NONE, "Features");
		componentFilterPanel = new FilterPanel(parent, SWT.NONE, "Components");

		stackLayout.topControl = featureFilterPanel;
		parent.layout();

		this.attemptToSetActiveEditor();

		this.getSite().getWorkbenchWindow().getPartService().addPartListener(this);
	}


	protected void createMenu() {
		IMenuManager menuMngr = this.getViewSite().getActionBars().getMenuManager();
		menuMngr.add(openFeatureFilterViewAction);
		menuMngr.add(openComponentFilterViewAction);
	}

	protected void createActions() {

		openFeatureFilterViewAction = new Action("Filter Features"){
			public void run() {
				stackLayout.topControl = featureFilterPanel;
				parent.layout();
			}
		};

		openComponentFilterViewAction = new Action("Filter Components"){
			public void run() {
				stackLayout.topControl = componentFilterPanel;
				parent.layout();
			}
		};

	}

	@Override
	public void setFocus() {
		parent.setFocus();
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		this.handleEditorActivation(part);
	}


	@Override
	public void partClosed(IWorkbenchPart part) {
		this.handleEditorClosed(part);
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
		// Not used.
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		// Not used.
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		// Not used.
	}

	protected void attemptToSetActiveEditor() {
		IWorkbenchPage activePage = this.getSite().getWorkbenchWindow().getActivePage();
		if(activePage != null) {
			IEditorPart activeEditor = activePage.getActiveEditor();
			if(activeEditor != null)
				this.handleEditorActivation(activeEditor);
		}
	}

	protected void handleEditorActivation(IWorkbenchPart part) {
		IImvModelProvider newModelProvider = (IImvModelProvider)part.getAdapter(IImvModelProvider.class);
		if(newModelProvider != null && newModelProvider != this.activeModelProvider) {
			this.setActiveModelProvider(newModelProvider);
		}
	}

	protected void setActiveModelProvider(IImvModelProvider modelProvider) {
		this.activeModelProvider = modelProvider;
		this.featureFilterPanel.setInput(modelProvider.getFeatureInhibitList());
		this.componentFilterPanel.setInput(modelProvider.getComponentInhibitList());
	}

	protected void handleEditorClosed(IWorkbenchPart part) {
		IImvModelProvider modelProvider = (IImvModelProvider)part.getAdapter(IImvModelProvider.class);
		if(modelProvider != null) {
			if(this.activeModelProvider == modelProvider) {
				this.activeModelProvider = NO_ACTIVE_MODEL_PROVIDER;
			}
		}
	}
}
