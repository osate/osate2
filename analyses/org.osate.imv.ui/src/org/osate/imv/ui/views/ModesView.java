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

package org.osate.imv.ui.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.imv.model.IImvModelProvider;
import org.osate.imv.model.ModeManager;


public class ModesView extends ViewPart implements PropertyChangeListener, IPartListener {
	// View ID.
	public static final String ID = "org.osate.imv.ui.views.modesView";

	private static final IImvModelProvider NO_ACTIVE_MODEL_PROVIDER = null;

	/**
	 * List viewer will display the mode list for the active component.
	 */
	private TableViewer modeTableViewer;

	private TableViewer triggerTableViewer;

	private Control parent;

	private IImvModelProvider activeModelProvider = NO_ACTIVE_MODEL_PROVIDER;

	private Set<IImvModelProvider> modelProviderSet;

	public ModesView() {
		this.modelProviderSet = new HashSet<IImvModelProvider>();
	}

	@Override
	public void dispose() {
		this.getSite().getWorkbenchWindow().getPartService().removePartListener(this);
		for(Iterator<IImvModelProvider> it = this.modelProviderSet.iterator(); it.hasNext();)
			it.next().removePropertyChangeListener(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY, this);
	}

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;

		// Set bg color.
		parent.setBackground(ColorConstants.white);

		// Use grid layout with two columns of equal width.
		parent.setLayout(new GridLayout(2, true));
		GridData data = new GridData(GridData.FILL_BOTH);

		Composite col1Container = new Composite(parent, SWT.NONE);
		col1Container.setLayoutData(data);

		Composite col2Container = new Composite(parent, SWT.NONE);
		col2Container.setLayoutData(data);

		// Create table viewer for modes.
		modeTableViewer = createModeTableViewer(col1Container);
		// Create table viewer for enabled mode transitions.
		triggerTableViewer =  createTriggerTableViewer(col2Container);

		this.attemptToSetActiveEditor();

		this.getSite().getWorkbenchWindow().getPartService().addPartListener(this);
	}

	protected TableViewer createModeTableViewer(Composite parent){
		String title = "Modes";

		TableViewer viewer = new TableViewer(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);

		// Configure table.
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(false);

		// Highlight active mode.
		table.addListener(SWT.EraseItem, new Listener(){

			@Override
			public void handleEvent(Event event) {
				if(activeModelProvider == NO_ACTIVE_MODEL_PROVIDER)
					return;

				TableItem item = (TableItem)event.item;
				Mode mode = (Mode)item.getData();
				if(mode != null && mode.equals(activeModelProvider.getCurrentMode())){
					event.detail &= ~SWT.HOT; // Do not draw native backgrounds

					// Highlight background.
					GC gc = event.gc;
					Color oldBg = gc.getBackground();
					gc.setBackground(ColorConstants.yellow);
					gc.fillRectangle(gc.getClipping());
					gc.setBackground(oldBg);
				}
			}

		});

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				updateCurrentMode(event.getSelection());
			}

		});


		// Table layout.
		TableColumnLayout columnLayout = new TableColumnLayout();
		parent.setLayout(columnLayout);

		// The first column contains a check box used for setting the feature category inhibit status.
		TableViewerColumn col = createTableViewerColumn(title, 0, 100, viewer, columnLayout);
		col.setLabelProvider(new ColumnLabelProvider(){

			public Image getImage(Object element) {
				return null;
			}

			public String getText(Object element) {
				String label = "";

				if(element.equals(ModeManager.ALL_MODES)){
					label = "all modes";
				}else if(element instanceof Mode){
					Mode mode = (Mode)element;
					label = mode.getName();
					if(mode.isInitial()) label += " (initial mode)";
				}

				return label;
			}
		});

		// Content provider.
		viewer.setContentProvider(new IStructuredContentProvider(){

			private NamedElement containerComponent;

			@Override
			public void dispose() {
				// Do nothing.
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				this.containerComponent = (NamedElement) newInput;
			}

			@Override
			public Object[] getElements(Object inputElement) {
				Object[] elements = null;

				if(containerComponent != null) {
					if (containerComponent instanceof ComponentInstance){
						List<ModeInstance> modes = ((ComponentInstance)containerComponent).getModeInstances();
						elements = new Object[modes.size() + 1];

						// Add ALL_MODES to list of modes.
						elements[0] = ModeManager.ALL_MODES;

						for(int i = 0; i < modes.size(); i++) {
							elements[i + 1] = ((ModeInstance)modes.get(i)).getMode();
						}
					} else {
						List<Mode> modes = ((ComponentImplementation)containerComponent).getAllModes();
						elements = new Object[modes.size() + 1];

						// Add ALL_MODES to list of modes.
						elements[0] = ModeManager.ALL_MODES;

						for(int i = 0; i < modes.size(); i++) {
							elements[i + 1] = modes.get(i);
						}
					}
				}
				return elements; // Return mode list.
			}

		});


		return viewer;
	}

	protected TableViewer createTriggerTableViewer(Composite parent){
		String title = "Enabled Transitions";

		TableViewer viewer = new TableViewer(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				updateCurrentMode(event.getSelection());
			}

		});

		// Configure table.
		final Table table = viewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(false);

		// Table layout.
		TableColumnLayout columnLayout = new TableColumnLayout();
		parent.setLayout(columnLayout);

		// The first column contains a check box used for setting the feature category inhibit status.
		TableViewerColumn col = createTableViewerColumn(title, 0, 100, viewer, columnLayout);
		col.setLabelProvider(new ColumnLabelProvider(){

			public Image getImage(Object element) {
				return null;
			}

			public String getText(Object element) {
				String label = "";
				if(element instanceof ModeTransitionTableRow){
					ModeTransitionTableRow modeTransition = (ModeTransitionTableRow)element;
					ModeTransitionTrigger trigger = modeTransition.getTrigger();
					// Add trigger name to label.
					
					label = trigger.getTriggerPort().getQualifiedName() + ":   ";
					
					// Add source mode to label.
					label += modeTransition.getSource().getName();
					// Add transition symbol to label.
					label += " --> ";
					// Add destination modde to label
					label += modeTransition.getDestination().getName();
				}

				return label;
			}
		});

		// Content provider.
		viewer.setContentProvider(new IStructuredContentProvider(){

			@Override
			public void dispose() {
				// Do nothing.
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
				// Do nothing.
			}

			@Override
			public Object[] getElements(Object inputElement) {
				if(inputElement.equals(ModeManager.ALL_MODES))
					return new Object[0]; // Return empty array.


				List<ModeTransitionTableRow> modeTransitionList = new ArrayList<ModeTransitionTableRow>();
				if(inputElement instanceof Mode) {
					Mode mode = (Mode)inputElement;
					ComponentClassifier cl = (ComponentClassifier) mode.getContainingClassifier();
					for(Iterator<ModeTransition> transitionInstanceIt = cl.getAllModeTransitions().iterator(); transitionInstanceIt.hasNext();){
						ModeTransition transition = transitionInstanceIt.next();
						Mode source = transition.getSource();
						Mode destination = transition.getDestination();

						for(Iterator<ModeTransitionTrigger> it = transition.getOwnedTriggers().iterator(); it.hasNext();){
							modeTransitionList.add(new ModeTransitionTableRow(it.next(), source, destination));
						}
					}
				}

				return modeTransitionList.toArray();
			}

		});

		return viewer;
	}

	protected TableViewerColumn createTableViewerColumn(String title, final int columnNumber, int weight, TableViewer viewer, TableColumnLayout columnLayout){
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		columnLayout.setColumnData(column, new ColumnWeightData(weight));
		column.setText(title);
		column.setMoveable(false);
		return viewerColumn;
	}


	@Override
	public void setFocus() {
		parent.setFocus();
	}

	protected void updateCurrentMode(ISelection selection) {
		if(activeModelProvider == NO_ACTIVE_MODEL_PROVIDER)
			return;

		Object selectedElement = ((IStructuredSelection)selection).getFirstElement();

		if(selectedElement == null)
			return;

		Mode selectedMode = ModeManager.NO_MODES;
		if(selectedElement instanceof Mode) {
			selectedMode = (Mode)selectedElement;
		}else if(selectedElement instanceof ModeTransitionTableRow) {
			selectedMode = ((ModeTransitionTableRow)selectedElement).getDestination();
		}

		if(!selectedMode.equals(this.activeModelProvider.getCurrentMode()) && !selectedMode.equals(ModeManager.NO_MODES))
			updateCurrentMode(selectedMode);
	}

	protected void updateCurrentMode(Mode selectedMode) {
		if(activeModelProvider == NO_ACTIVE_MODEL_PROVIDER)
			return;

		// Reset the input for the enabled mode transitions based on the current mode.
		triggerTableViewer.setInput(selectedMode);
		// Update selection to be the current mode.
		modeTableViewer.setSelection(new StructuredSelection(selectedMode), true);
		// We need to redraw the table in order to highlight the correct mode.
		modeTableViewer.getTable().redraw();
		// Update the current mode.
		this.activeModelProvider.setCurrentMode(selectedMode);
	}

	protected void handleContainerComponentChange(NamedElement containerComp) {
		if(activeModelProvider == NO_ACTIVE_MODEL_PROVIDER)
			return;

		Mode newMode = this.activeModelProvider.getCurrentMode();
		// Update mode table viewer with the component instance.
		modeTableViewer.setInput(containerComp);
		// Update the mode transition table viewer with the current mode.
		triggerTableViewer.setInput(newMode);
		// Set the current mode.
		modeTableViewer.setSelection(new StructuredSelection(newMode), true);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String propertyName = event.getPropertyName();
		if(propertyName.equals(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY) && event.getSource() == this.activeModelProvider) {
			handleContainerComponentChange((NamedElement)event.getNewValue());
		}
	}


	public class ModeTransitionTableRow {
		private ModeTransitionTrigger trigger;
		private Mode source;
		private Mode destination;


		public ModeTransitionTableRow(ModeTransitionTrigger trigger, Mode source, Mode destination){
			Assert.isNotNull(trigger);
			Assert.isNotNull(source);
			Assert.isNotNull(destination);

			this.trigger = trigger;
			this.source = source;
			this.destination = destination;
		}

		public ModeTransitionTrigger getTrigger() {
			return trigger;
		}

		public Mode getDestination() {
			return destination;
		}

		public Mode getSource() {
			return source;
		}
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
		if(this.modelProviderSet.add(modelProvider))
			modelProvider.addPropertyChangeListener(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY, this);

		this.handleContainerComponentChange(modelProvider.getContainerComponent());
	}

	protected void handleEditorClosed(IWorkbenchPart part) {
		IImvModelProvider modelProvider = (IImvModelProvider)part.getAdapter(IImvModelProvider.class);
		if(modelProvider != null) {
			if(this.modelProviderSet.remove(modelProvider))
				modelProvider.removePropertyChangeListener(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY, this);

			if(this.activeModelProvider == modelProvider) {
				this.activeModelProvider = NO_ACTIVE_MODEL_PROVIDER;
			}
		}
	}

}
