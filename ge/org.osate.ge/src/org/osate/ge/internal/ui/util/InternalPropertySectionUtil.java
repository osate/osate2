/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.ui.util;

import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * Utility class containing members used to implement property section
 *
 */
public final class InternalPropertySectionUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private InternalPropertySectionUtil() {
	}

	/**
	 * Creates a combo viewer
	 * @param container the container for the viewer
	 * @param lblWidth the width of the label
	 * @param selectionListener the selection listener for the combo viewer
	 * @param lblProvider the label provider for the combo viewer
	 * @return the new combo viewer
	 */
	public static ComboViewer createComboViewer(final Composite container, final int lblWidth,
			final SelectionListener selectionListener, final LabelProvider lblProvider) {
		final ComboViewer comboViewer = new ComboViewer(container);
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(lblProvider);

		final Combo combo = comboViewer.getCombo();
		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, lblWidth);
		combo.setLayoutData(fd);
		combo.addSelectionListener(selectionListener);
		// Disable scroll so selection listeners are not constantly called resulting in a burst of AADL modifications.
		combo.addListener(SWT.MouseVerticalWheel, event -> event.doit = false);
		return comboViewer;
	}

	/**
	 * Sets the context help ID for the specified control to be that of the properties view
	 * @param control the control for which to set the context help ID
	 * @see ContextHelpUtil#PROPERTIES_VIEW
	 */
	public static void setPropertiesHelp(final Control control) {
		ContextHelpUtil.setHelp(control, ContextHelpUtil.PROPERTIES_VIEW);
	}

	/**
	 * Creates a button
	 * @param widgetFactory the widget factory used to create the button
	 * @param composite the composite to which the button will be added
	 * @param data the data from the button
	 * @param listener the selection listener for the button
	 * @param txt the text for the button
	 * @param style the style for the button
	 * @return the new button
	 */
	public static Button createButton(final TabbedPropertySheetWidgetFactory widgetFactory, final Composite composite,
			final Object data, final SelectionListener listener, final String txt, final int style) {
		final Button btn = widgetFactory.createButton(composite, txt, style);
		btn.setData(data);
		btn.addSelectionListener(listener);
		return btn;
	}

	/**
	 * Creates a composite with a row layout
	 * @param widgetFactory the factory to use to create the composite
	 * @param parent the component to which the new composite will be added.
	 * @param offset the horizontal offset for the composite. This typically matches the label width of other widgets
	 * @return the new composite
	 */
	public static Composite createRowLayoutComposite(final TabbedPropertySheetWidgetFactory widgetFactory,
			final Composite parent, final int offset) {
		final Composite container = widgetFactory.createComposite(parent);
		container.setLayout(RowLayoutFactory.fillDefaults().wrap(false).create());
		final FormData ld = new FormData();
		ld.left = new FormAttachment(0, offset);
		ld.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		container.setLayoutData(ld);
		return container;
	}

	/**
	 * Creates a new table viewer column
	 * @param tableViewer the table viewer for which the column is being created
	 * @param colHeader the header of the column
	 * @param style the style of the table viewer column
	 * @param cellLabelProvider the label provider which provides the text for the cells
	 * @return the new table viewer column
	 */
	public static TableViewerColumn createTableColumnViewer(final TableViewer tableViewer, final String colHeader,
			final int style, final CellLabelProvider cellLabelProvider) {
		final TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, style);
		tableViewerColumn.getColumn().setText(colHeader);
		tableViewerColumn.setLabelProvider(cellLabelProvider);
		return tableViewerColumn;
	}

	/**
	 * Helper class for implementing drag and drop for a table.
	 *
	 */
	public static class DragAndDropSupport {
		private final int operations = DND.DROP_MOVE;
		private final Transfer[] types = new Transfer[] { LocalSelectionTransfer.getTransfer() };
		private final Table table;
		private final ExecuteOrderChange execute;
		private DragAndDropElement dragElement; // Element moving indices
		private DragAndDropElement dropElement; // Element dropped upon

		/**
		 * Creates a new instance for use with a table
		 * @param table the table whose items uses {@link DragAndDropElement} instances for its data
		 * @param execute the function to use to modify the order
		 */
		public DragAndDropSupport(final Table table,
				final ExecuteOrderChange execute) {
			this.table = table;
			this.execute = execute;
		}

		/**
		 * Drag source adapter which updates {@link #dragElement} when a drag starts
		 * @see TableViewer#addDropSupport(int, Transfer[], org.eclipse.swt.dnd.DropTargetListener)
		 */
		public final DragSourceAdapter dragSourceListener = new DragSourceAdapter() {
			@Override
			public void dragStart(final DragSourceEvent event) {
				dragElement = (DragAndDropElement) table.getSelection()[0].getData();
			}
		};

		/**
		 * Drop target adapter for handling dropping
		 * Drag element will be placed above targeted element
		 * @see TableViewer#addDropSupport(int, Transfer[], org.eclipse.swt.dnd.DropTargetListener)
		 */
		public final DropTargetAdapter dropTargetListener = new DropTargetAdapter() {
			@Override
			public void drop(final DropTargetEvent event) {
				final int curIndex = dragElement.getIndex() - 1;
				final int newIndex = getNewIndex(dropElement, curIndex);
				execute.apply(newIndex, curIndex, dragElement);
				dragElement = null;
				dropElement = null;
			}

			private int getNewIndex(final DragAndDropElement targetElement, final int dragIndex) {
				// Set in last index
				if (targetElement == null) {
					return table.getItemCount() - 1;
				}

				final int targetIndex = targetElement.getIndex() - 1;
				// If dragging up, subtract 1
				return dragIndex < targetIndex ? targetIndex - 1 : targetIndex;
			}

			@Override
			public void dragOver(final DropTargetEvent event) {
				final TableItem tableItem;
				final DragAndDropElement dragTargetItem;
				if (event.item instanceof TableItem) {
					tableItem = (TableItem) event.item;
					dragTargetItem = (DragAndDropElement) tableItem.getData();
				} else {
					tableItem = null;
					dragTargetItem = null;
				}

				if (dragTargetItem != dropElement) {
					if (dragTargetItem != null) {
						// Scroll while dragging
						if (dragTargetItem.getIndex() > 1) {
							table.showItem(table.getItem(dragTargetItem.getIndex() - 2));
						}

						if (dragTargetItem.getIndex() < table.getItemCount()) {
							table.showItem(table.getItem(dragTargetItem.getIndex()));
						}
					}

					// Cleans up lines drawn for previous targeted index
					table.redraw();
				}

				// Set next target element
				dropElement = dragTargetItem;

				// Draw the drop index line
				final GC gc = new GC(table);
				gc.setLineWidth(3);
				final Rectangle bounds = getBounds(tableItem);
				gc.drawLine(bounds.x, bounds.height, bounds.width, bounds.height);
				gc.dispose();
			}

			// Bounds used for drawing target index line
			private Rectangle getBounds(final TableItem targetItem) {
				final Rectangle bounds;
				final int y;

				// Draw below last item for last index
				if (targetItem == null) {
					bounds = table.getItem(table.getItemCount() - 1).getBounds();
					y = bounds.y + bounds.height;
				} else {
					bounds = targetItem.getBounds();
					y = bounds.y + 1;
				}

				return new Rectangle(bounds.x - 5, y, bounds.x + table.getBounds().width, y);
			}

			@Override
			public void dragLeave(final DropTargetEvent event) {
				// Cleans up any leftover lines
				table.redraw();
			}
		};

		/**
		 * Returns supported drag and drop operations
		 * @return supported drag and drop operations
		 */
		public int getDragAndDropOperations() {
			return operations;
		}

		/**
		 * Returns the supported transfer types
		 * @return the supported transfer types
		 */
		public Transfer[] getTransferTypes() {
			return types;
		}
	}

	/**
	 * The data type for items supported by {@link DragAndDropSupport}
	 * @see TableItem#setData(Object)
	 */
	public static class DragAndDropElement {
		private final String name;
		private final int index;

		/**
		 * Creates a new instance
		 * @param name the name of the item. Ignored by {@link DragAndDropSupport}
		 * @param index the index of the item
		 */
		public DragAndDropElement(final String name, final int index) {
			this.name = name;
			this.index = index;
		}

		/**
		 * Returns the name of the item
		 * @return the name of the item
		 */
		public String getName() {
			return name;
		}

		/**
		 * Returns the index of the item
		 * @return the index of the item
		 */
		public int getIndex() {
			return index;
		}
	}

	/**
	 * Selection listener used to increase or decrease and item's index.
	 * The listener must be attached to a button which has a boolean data value.
	 * If the value is true then the item is moved "up" by decreasing its index
	 * If the value is false then the item is moved "down" by increasing its index.
	 *
	 * @see Button#setData(Object)
	 */
	public static class UpDownButtonSelectionAdapter extends SelectionAdapter {
		private final TableViewer tableViewer;
		private final ExecuteOrderChange executeChangeOrder;

		/**
		 * Creates a new instance which moves the item selected in the specified table viewer
		 * @param tableViewer the table viewer containing the items adjusted by this listener.
		 * @param executeChangeOrder the object to use to change the index of an element
		 */
		public UpDownButtonSelectionAdapter(final TableViewer tableViewer,
				final ExecuteOrderChange executeChangeOrder) {
			this.tableViewer = tableViewer;
			this.executeChangeOrder = executeChangeOrder;
		}

		@Override
		public void widgetSelected(final SelectionEvent e) {
			if (!tableViewer.getStructuredSelection().isEmpty()) {
				final DragAndDropElement dNDElement = (DragAndDropElement) tableViewer.getStructuredSelection()
						.getFirstElement();
				final boolean direction = (boolean) ((Button) e.widget).getData();
				final int targetIndex = dNDElement.getIndex() + (direction ? -1 : 1);
				final int newIndex = getNewIndex(tableViewer.getTable().getItemCount(), targetIndex);
				executeChangeOrder.apply(newIndex, dNDElement.getIndex() - 1, dNDElement);
			}
		}

		private static int getNewIndex(final int totalSize, final int newIndex) {
			if (newIndex < 1) {
				return 0;
			}

			return (newIndex > totalSize ? totalSize : newIndex) - 1;
		}
	}

	/**
	 * Functional interface for reordering elements
	 */
	public interface ExecuteOrderChange {
		/**
		 * Changes the index of the specified item
		 * @param newIndex the new index of the item
		 * @param curIndex the current index of the item
		 * @param element the item to reorder
		 */
		public void apply(final Integer newIndex, final Integer curIndex, final DragAndDropElement element);
	}
}
