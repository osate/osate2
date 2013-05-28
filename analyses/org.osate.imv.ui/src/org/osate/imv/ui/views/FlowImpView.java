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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.ColorCellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
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
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.Mode;
import org.osate.imv.model.FlowHighlighter;
import org.osate.imv.model.IImvModelProvider;
import org.osate.imv.model.ModeManager;
import org.osate.imv.ui.util.EmulatedNativeCheckBoxLabelProvider;


public class FlowImpView extends ViewPart implements PropertyChangeListener, IPartListener {

	public static final String ID = "org.osate.imv.ui.views.flowsView";

	private static final IImvModelProvider NO_ACTIVE_MODEL_PROVIDER = null;

	private TableViewer tableViewer;

	private Control parent;

	private Set<IImvModelProvider> modelProviderSet;

	private IImvModelProvider activeModelProvider = NO_ACTIVE_MODEL_PROVIDER;

	private ModeFilter modeFilter;


	public FlowImpView() {
		this.modelProviderSet = new HashSet<IImvModelProvider>();
	}

	@Override
	public void dispose() {
		this.getSite().getWorkbenchWindow().getPartService().removePartListener(this);
		for(Iterator<IImvModelProvider> it = this.modelProviderSet.iterator(); it.hasNext();) {
			IImvModelProvider next = it.next();
			next.removePropertyChangeListener(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY, this);
			next.removePropertyChangeListener(IImvModelProvider.CURRENT_MODE_PROPERTY, this);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;
		// Set bg color.
		parent.setBackground(ColorConstants.white);
		// Set layout manager.
		parent.setLayout(new FillLayout());
		// Create table viewer.
		this.tableViewer = createTableViewer(parent);
		// We will use an array content provider.
		this.tableViewer.setContentProvider(new ArrayContentProvider());
		// Set mode filter.
		this.tableViewer.addFilter(this.modeFilter = new ModeFilter());

		this.attemptToSetActiveEditor();

		this.getSite().getWorkbenchWindow().getPartService().addPartListener(this);
	}

	protected TableViewer createTableViewer(Composite parent) {
		TableViewer viewer = new TableViewer(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);

		// Configure table.
		final Table table = viewer.getTable();
		table.setHeaderVisible(false);
		table.setLinesVisible(true);

		// We do NOT want the cell background to be cleared when a row has focus or is selected.
		table.addListener(SWT.EraseItem, new Listener(){

			@Override
			public void handleEvent(Event event) {
				if (event.index == 1) {
					TableItem item = (TableItem) event.item;
					Object data = item.getData();
					if (data instanceof FlowHighlighter) {
						// Force background to be drawn.
						GC gc = event.gc;
						Color oldBg = gc.getBackground();
						Rectangle clipping = gc.getClipping();
						Rectangle rect = new Rectangle(clipping.x + 4, clipping.y + 4, clipping.width - 8, clipping.height - 8);
						gc.setBackground(((FlowHighlighter) data).getColor());
						gc.fillRoundRectangle(rect.x, rect.y, rect.width, rect.height, 2, 2);
						gc.setBackground(oldBg);
					}
				}

				if (event.index > 0) {
					event.detail &= ~SWT.SELECTED;
					event.detail &= ~SWT.FOCUSED;
				}
			}

		});


		// The first column contains a check box used for enabling/disabling highlighting for a particular
		// flow.
		TableViewerColumn col1 = createTableViewerColumn("Flow", 0, 300, viewer);
		// The first column contains a check box used for setting the feature
		// category inhibit status.
		col1.setLabelProvider(new EmulatedNativeCheckBoxLabelProvider(col1.getViewer()) {

			@Override
			protected boolean isChecked(Object element) {
				return ((FlowHighlighter)element).isHighlight();
			}

			public String getText(Object element) {
				String label = "";
				if(element instanceof FlowHighlighter) {
					if (((FlowHighlighter)element).getFlowImpl()!=null){
						label = " " + ((FlowHighlighter)element).getFlowImpl().getSpecification().getName();
					} else
						// phf: added ETEF
					if(((FlowHighlighter)element).getETEF()!=null){
						label = " " + ((FlowHighlighter)element).getETEF().getName();
					}
				}
				return label;
			}

		});

		col1.setEditingSupport(new EditingSupport(viewer) {

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new CheckboxCellEditor(tableViewer.getTable());
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected Object getValue(Object element) {
				return ((FlowHighlighter)element).isHighlight();
			}

			@Override
			protected void setValue(Object element, Object value) {
				// Set new value.
				((FlowHighlighter)element).setHighlight(((Boolean)value).booleanValue());
				// Update cell.
				tableViewer.refresh();
			}

		});

		// The seconds column contains a combo box editor for selecting the highlighter color.
		TableViewerColumn col2 = createTableViewerColumn("Color", 0, 200, viewer);

		col2.setLabelProvider(new ColumnLabelProvider() {
			public String getText(Object element) {
				  return null; // No label is displayed.
			}

		});

		col2.setEditingSupport(new EditingSupport(col2.getViewer()) {
			private ColorCellEditor cellEditor = null;

			@Override
			protected CellEditor getCellEditor(Object element) {
				if (cellEditor == null) {
					cellEditor = new ColorCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
				}
				return cellEditor;
			}

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected Object getValue(Object element) {
				if (element instanceof FlowHighlighter) {
					FlowHighlighter highlighter = (FlowHighlighter) element;
					return highlighter.getColor().getRGB();
				}
				return null;
			}

			@Override
			protected void setValue(Object element, Object value) {
				if (element instanceof FlowHighlighter && value instanceof RGB) {
					FlowHighlighter highlighter = (FlowHighlighter) element;
					Color newColor = new Color(Display.getCurrent(), (RGB)value);
					// only set new value if it differs from old one
					if (!highlighter.getColor().equals(newColor)) {
						highlighter.setColor(newColor);
						tableViewer.update(element, new String[]{FlowHighlighter.COLOR_PROPERTY});
					}
				}
			}
		});


		return viewer;
	}

	protected TableViewerColumn createTableViewerColumn(String title, final int columnNumber, int width, TableViewer viewer){
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setWidth(width);
		column.setMoveable(false);
		column.setText(title);
		column.setAlignment(SWT.CENTER);

		return viewerColumn;
	}

	@Override
	public void setFocus() {
		this.tableViewer.getControl().setFocus();
	}

	protected void handleContainerComponentChange() {
		if(activeModelProvider == NO_ACTIVE_MODEL_PROVIDER)
			return;

		this.modeFilter.setCurrentMode(this.activeModelProvider.getCurrentMode());
		this.tableViewer.setInput(this.activeModelProvider.getFlowHighlighters());
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getSource() != this.activeModelProvider)
			return;

		String propertyName = event.getPropertyName();

		if(propertyName.equals(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY)) {
			handleContainerComponentChange();
		} else if(propertyName.equals(IImvModelProvider.CURRENT_MODE_PROPERTY)) {
			this.modeFilter.setCurrentMode((Mode)event.getNewValue());
			this.tableViewer.refresh();
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
		if(this.modelProviderSet.add(modelProvider)) {
			modelProvider.addPropertyChangeListener(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY, this);
			modelProvider.addPropertyChangeListener(IImvModelProvider.CURRENT_MODE_PROPERTY, this);
		}

		this.handleContainerComponentChange();
	}

	protected void handleEditorClosed(IWorkbenchPart part) {
		IImvModelProvider modelProvider = (IImvModelProvider)part.getAdapter(IImvModelProvider.class);
		if(modelProvider != null) {
			if(this.modelProviderSet.remove(modelProvider)) {
				modelProvider.removePropertyChangeListener(IImvModelProvider.CONTAINER_COMPONENT_PROPERTY, this);
				modelProvider.removePropertyChangeListener(IImvModelProvider.CURRENT_MODE_PROPERTY, this);
			}

			if(this.activeModelProvider == modelProvider) {
				this.activeModelProvider = NO_ACTIVE_MODEL_PROVIDER;
			}
		}
	}

	private final class ModeFilter extends ViewerFilter {

		private Mode currentMode;

		public ModeFilter() {
			this.currentMode = ModeManager.ALL_MODES;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				final Object element) {
			boolean keepElement = false;

			if (element instanceof FlowHighlighter) {
				final FlowImplementation flowImpl = ((FlowHighlighter) element)
						.getFlowImpl();
				final EndToEndFlow etef = ((FlowHighlighter) element)
						.getETEF();
				if (flowImpl!=null){
					boolean prevEDeliver = flowImpl.eDeliver();
					flowImpl.eSetDeliver(false);

					List<Mode> inModesList = flowImpl.getInModes();

					// The flow will be visible if ALL_MODES is the current mode, or if the selected flow does not have a
					// a mode assignment (i.e. it exists in all modes).
					if (currentMode == ModeManager.ALL_MODES || inModesList.isEmpty()) {
						keepElement = true;
					} else {
						for (Iterator<Mode> modes = inModesList
								.iterator(); modes.hasNext();) {

							Mode mode = modes.next();
							if (currentMode.equals(mode)) {
								keepElement = true;
								break;
							}
						}
					}

					flowImpl.eSetDeliver(prevEDeliver);
				} else 	if (etef!=null){
					boolean prevEDeliver = etef.eDeliver();
					etef.eSetDeliver(false);

					List<Mode> inModesList = etef.getInModes();

					// The flow will be visible if ALL_MODES is the current mode, or if the selected flow does not have a
					// a mode assignment (i.e. it exists in all modes).
					if (currentMode == ModeManager.ALL_MODES || inModesList.isEmpty()) {
						keepElement = true;
					} else {
						for (Iterator<Mode> modes = inModesList
								.iterator(); modes.hasNext();) {

							Mode mode = modes.next();
							if (currentMode.equals(mode)) {
								keepElement = true;
								break;
							}
						}
					}

					etef.eSetDeliver(prevEDeliver);
				}
			}


			return keepElement;

		}


		public Mode getCurrentMode() {
			return currentMode;
		}

		public void setCurrentMode(Mode currentMode) {
			this.currentMode = currentMode;
		}

	}

}
