package org.osate.ge.internal.ui.dialogs;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.osate.ge.internal.ui.util.ContextHelpUtil;

import com.google.common.collect.ImmutableMap;

/**
 * Dialog intended to allow the user to update ghosted business objects so that they will be restored.
 * @param <ElementType> the type of element being modified by the user.
 * @param <BusinessObjectType> the type of the business object being selected by the user. Is not required to be a raw business object.
 */
public class RestoreMissingDiagramElementsDialog<ElementType, BusinessObjectType> {
	public interface Model<ElementType, BusinessObjectType> {
		Collection<ElementType> getElements();

		String getParentLabel(ElementType element);

		String getMissingReferenceLabel(ElementType element);

		Collection<BusinessObjectType> getAvailableBusinessObjects(ElementType element);

		String getBusinessObjectLabel(BusinessObjectType bo);
	}

	/**
	 * Result only contains a mapping for elements for which the user has specified an updated business object
	 */
	public static class Result<ElementType, BusinessObjectType> {
		private Map<ElementType, BusinessObjectType> objectToNewBoMap;

		private Result(final Map<ElementType, BusinessObjectType> objectToNewBoMap) {
			this.objectToNewBoMap = objectToNewBoMap;
		}

		public Map<ElementType, BusinessObjectType> getObjectToNewBoMap() {
			return objectToNewBoMap;
		}
	}

	private static class BrokenElement<ElementType, BusinessObjectType> {
		private final ElementType element;
		private BusinessObjectType newBo;

		private BrokenElement(final ElementType element, final BusinessObjectType newBo) {
			this.element = element;
			this.newBo = newBo;
		}

		private void setNewBusinessObject(final BusinessObjectType newBo) {
			this.newBo = newBo;
		}
	}

	private class InnerDialog extends Dialog {
		private TableViewer tableViewer;

		final Collection<BrokenElement<ElementType, BusinessObjectType>> updatedElements = model.getElements().stream()
				.map(ob -> new BrokenElement<ElementType, BusinessObjectType>(ob, null)).collect(Collectors.toList());

		protected InnerDialog(final Shell parentShell) {
			super(parentShell);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Restore Missing Diagram Elements");
			newShell.setMinimumSize(250, 200);
			newShell.setSize(600, 400);
			ContextHelpUtil.setHelp(newShell, ContextHelpUtil.RESTORE_MISSING_DES);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = (Composite) super.createDialogArea(parent);

			final Composite container = new Composite(area, SWT.NONE);
			container.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			tableViewer = new TableViewer(container, SWT.FULL_SELECTION | SWT.BORDER);
			tableViewer.setUseHashlookup(true);

			// Parent Column
			final TableViewerColumn parentColumn = new TableViewerColumn(tableViewer, SWT.NONE);
			parentColumn.getColumn().setText("Container");
			parentColumn.setLabelProvider(new CellLabelProvider() {
				@Override
				public void update(final ViewerCell cell) {
					@SuppressWarnings("unchecked")
					final BrokenElement<ElementType, BusinessObjectType> updatedElement = (BrokenElement<ElementType, BusinessObjectType>) cell
					.getElement();
					cell.setText(model.getParentLabel(updatedElement.element));
				}
			});

			final BrokenElementColumnComparator comp = new BrokenElementColumnComparator();
			parentColumn.getViewer().setComparator(comp);
			final Table table = tableViewer.getTable();

			parentColumn.getColumn().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					comp.setColumn(0);
					int dir = comp.getDirection();
					table.setSortDirection(dir);
					table.setSortColumn(parentColumn.getColumn());
					tableViewer.refresh();
				}
			});

			// Missing Reference
			final TableViewerColumn missingReferenceColumn = new TableViewerColumn(tableViewer, SWT.NONE);
			missingReferenceColumn.getColumn().setText("Missing Reference");
			missingReferenceColumn.getViewer().setComparator(comp);

			missingReferenceColumn.getColumn().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					comp.setColumn(1);
					int dir = comp.getDirection();
					table.setSortDirection(dir);
					table.setSortColumn(missingReferenceColumn.getColumn());
					tableViewer.refresh();
				}
			});

			missingReferenceColumn.setLabelProvider(new CellLabelProvider() {
				@Override
				public void update(final ViewerCell cell) {
					@SuppressWarnings("unchecked")
					final BrokenElement<ElementType, BusinessObjectType> updatedElement = (BrokenElement<ElementType, BusinessObjectType>) cell
					.getElement();
					cell.setText(model.getMissingReferenceLabel(updatedElement.element));
				}
			});

			// Dropdown Column for New Business Object
			final TableViewerColumn newBusinessObjectColumn = new TableViewerColumn(tableViewer, SWT.READ_ONLY);
			final TableColumnLayout tcl = new TableColumnLayout();
			container.setLayout(tcl);

			tcl.setColumnData(parentColumn.getColumn(), new ColumnWeightData(15, true));
			tcl.setColumnData(missingReferenceColumn.getColumn(), new ColumnWeightData(10, true));
			tcl.setColumnData(newBusinessObjectColumn.getColumn(), new ColumnWeightData(10, true));

			newBusinessObjectColumn.getColumn().setText("New Reference");
			newBusinessObjectColumn.getColumn().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					comp.setColumn(2);
					int dir = comp.getDirection();
					table.setSortDirection(dir);
					table.setSortColumn(newBusinessObjectColumn.getColumn());
					tableViewer.refresh();
				}
			});

			newBusinessObjectColumn.setLabelProvider(new CellLabelProvider() {
				@Override
				public void update(final ViewerCell cell) {
					@SuppressWarnings("unchecked")
					final BrokenElement<ElementType, BusinessObjectType> updatedElement = (BrokenElement<ElementType, BusinessObjectType>) cell
					.getElement();
					cell.setText(getBusinessObjectLabel(updatedElement.newBo));
				}
			});

			newBusinessObjectColumn.setEditingSupport(new NewBusinessObjectEditingSupport(tableViewer));

			table.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).minSize(SWT.DEFAULT, 100)
					.hint(200, SWT.DEFAULT).create());
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			table.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());

			tableViewer.setContentProvider(ArrayContentProvider.getInstance());
			tableViewer.setInput(updatedElements);

			return area;
		}

		private class BrokenElementColumnComparator extends ViewerComparator {
			private int propertyIndex;
			private static final int DESCENDING = 1;
			private int direction = DESCENDING;

			private BrokenElementColumnComparator() {
				this.propertyIndex = 0;
				direction = 1 - DESCENDING;
			}

			private int getDirection() {
				return direction == 1 ? SWT.DOWN : SWT.UP;
			}

			private void setColumn(int column) {
				if (column == this.propertyIndex) {
					// Same column as last sort; toggle the direction
					direction = 1 - direction;
				} else {
					// New column; do an ascending sort
					this.propertyIndex = column;
					direction = DESCENDING;
				}
			}

			@SuppressWarnings("unchecked")
			@Override
			public int compare(final Viewer viewer, final Object e1, final Object e2) {
				final BrokenElement<ElementType, BusinessObjectType> ue1 = (BrokenElement<ElementType, BusinessObjectType>) e1;
				final BrokenElement<ElementType, BusinessObjectType> ue2 = (BrokenElement<ElementType, BusinessObjectType>) e2;

				int rc = 0;
				switch (propertyIndex) {
				case 0:
					final String ue1Label = model.getParentLabel(ue1.element);
					final String ue2Label = model.getParentLabel(ue2.element);
					rc = ue1Label.compareToIgnoreCase(ue2Label);
					break;
				case 1:
					final String curContextLabel1 = model.getMissingReferenceLabel(ue1.element);
					final String curContextLabel2 = model.getMissingReferenceLabel(ue2.element);
					rc = curContextLabel1.compareToIgnoreCase(curContextLabel2);
					break;
				case 2:
					final String newContextLabel1 = getBusinessObjectLabel(ue1.newBo);
					final String newContextLabel2 = getBusinessObjectLabel(ue2.newBo);
					rc = newContextLabel1.compareToIgnoreCase(newContextLabel2);
					break;
				default:
					rc = 0;
				}
				// If descending order, flip the direction
				if (direction == DESCENDING) {
					rc = -rc;
				}
				return rc;
			}

		}

		/**
		 * Returns a blank string if bo is null, otherwise delegates to the model.
		 * @param bo
		 * @return
		 */
		@SuppressWarnings("unchecked")
		private String getBusinessObjectLabel(final Object bo) {
			return bo == null ? "" : model.getBusinessObjectLabel((BusinessObjectType) bo);
		}

		private class NewBusinessObjectEditingSupport extends EditingSupport {
			private final ComboBoxViewerCellEditor editor;

			public NewBusinessObjectEditingSupport(final TableViewer viewer) {
				super(viewer);
				editor = new ComboBoxViewerCellEditor(viewer.getTable());
				editor.getViewer().setComparator(new ViewerComparator());
				editor.setContentProvider(ArrayContentProvider.getInstance());
				editor.setLabelProvider(new LabelProvider() {
					@Override
					public String getText(final Object element) {
						return getBusinessObjectLabel(element);
					}
				});
			}

			@SuppressWarnings("unchecked")
			@Override
			protected CellEditor getCellEditor(final Object element) {
				editor.setInput(model.getAvailableBusinessObjects(
						((BrokenElement<ElementType, BusinessObjectType>) element).element));
				return editor;
			}

			@Override
			protected boolean canEdit(final Object element) {
				return true;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected Object getValue(final Object element) {
				return ((BrokenElement<ElementType, BusinessObjectType>) element).newBo;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected void setValue(final Object element, final Object value) {
				final BrokenElement<ElementType, BusinessObjectType> updatedElement = (BrokenElement<ElementType, BusinessObjectType>) element;
				updatedElement.setNewBusinessObject((BusinessObjectType) value);
				tableViewer.update(element, null);
			}
		}
	}

	private final InnerDialog dlg;
	private final Model<ElementType, BusinessObjectType> model;

	private RestoreMissingDiagramElementsDialog(final Shell parentShell,
			final Model<ElementType, BusinessObjectType> model) {
		this.model = model;
		this.dlg = new InnerDialog(parentShell);
	}

	/**
	 * Returns null if there were no changes or if the user did not select OK.
	 * @return
	 */
	private Result<ElementType, BusinessObjectType> open() {
		if (dlg.open() == Window.OK) {
			final ImmutableMap<ElementType, BusinessObjectType> elementToNewBo = dlg.updatedElements.stream()
					.filter(ue -> ue.newBo != null)
					.collect(ImmutableMap.toImmutableMap(ue -> ue.element, ue -> ue.newBo));
			return elementToNewBo.isEmpty() ? null : new Result<>(elementToNewBo);
		} else {
			return null;
		}
	}

	/**
	 *
	 * @param ElementType
	 * @param ElementType
	 * @return see open()
	 */
	public static <ElementType, BusinessObjectType> Result<ElementType, BusinessObjectType> show(
			final Shell parentShell, final Model<ElementType, BusinessObjectType> ElementType) {
		final RestoreMissingDiagramElementsDialog<ElementType, BusinessObjectType> dlg = new RestoreMissingDiagramElementsDialog<>(
				parentShell, ElementType);
		return dlg.open();
	}

	public static void main(final String[] args) {
		final Model<Integer, Integer> model = new Model<Integer, Integer>() {
			@Override
			public Collection<Integer> getElements() {
				return IntStream.range(0, 100).boxed().collect(Collectors.toList());
			}

			@Override
			public String getParentLabel(Integer element) {
				return "Parent" + element;
			}

			@Override
			public String getMissingReferenceLabel(Integer element) {
				return "MissingRef" + element;
			}

			@Override
			public Collection<Integer> getAvailableBusinessObjects(Integer element) {
				return IntStream.range(0, 100).boxed().collect(Collectors.toList());
			}

			@Override
			public String getBusinessObjectLabel(Integer bo) {
				return "NewBo" + bo;
			}
		};

		final Result<Integer, Integer> result = RestoreMissingDiagramElementsDialog.show(new Shell(), model);
		if (result != null) {
			result.objectToNewBoMap.forEach((e, newBo) -> System.out
					.println(model.getParentLabel(e) + " : " + model.getBusinessObjectLabel(newBo)));
		}
	}
}
