package org.osate.ge.internal.ui.properties;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.dialogs.EditDimensionsDialog.EditDimensionDialog;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil.DragAndDropElement;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil.DragAndDropSupport;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil.ExecuteOrderChange;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil.UpDownButtonSelectionAdapter;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class SetDimensionsPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof ArrayableElement);
		}
	}

	private final String emptyString = "";
	private BusinessObjectSelection selectedBos;
	private TableViewer tableViewer;
	private Button modifyBtn;
	private Button addBtn;
	private Button deleteBtn;
	private Button upBtn;
	private Button downBtn;
	private int selectedIndex = 0; // Default table index and user selected index

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		FormData fd;

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite tableComposite = getWidgetFactory().createComposite(composite);
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.height = 140;
		fd.width = 250;
		tableComposite.setLayoutData(fd);
		tableViewer = createTableViewer(tableComposite);
		tableViewer.addSelectionChangedListener(event -> {
			final Table table = tableViewer.getTable();
			if (table.getSelectionIndex() >= 0) {
				selectedIndex = table.getSelectionIndex();
			}
			updateMoveButtons(table.getItemCount() - 1);
		});

		// Drag and drop support for changing call sequence
		final DragAndDropSupport dNDSupport = new DragAndDropSupport(tableViewer.getTable(), executeChangeOrder);
		final int operations = dNDSupport.getDragAndDropOperations();
		final Transfer[] types = dNDSupport.getTransferTypes();
		tableViewer.addDropSupport(operations, types, dNDSupport.dropTargetListener);
		tableViewer.addDragSupport(operations, types, dNDSupport.dragSourceListener);

		final TableViewerColumn portCol = InternalPropertySectionUtil.createTableColumnViewer(tableViewer,
				"Array Dimensions",
				SWT.RESIZE, new CellLabelProvider() {
			@Override
			public void update(final ViewerCell cell) {
				final DragAndDropElement element = (DragAndDropElement) cell.getElement();
				cell.setText("[" + element.getName() + "]");
			}
		});

		portCol.getColumn().setResizable(true);
		tableComposite.setLayout(createTableColumnLayout(portCol.getColumn()));
		modifyBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, null,
				modifyDimensionSelectionListener, "Modify...", SWT.PUSH);
		final int btnWidth = 60;
		fd = new FormData();
		fd.left = new FormAttachment(tableComposite, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(tableComposite, ITabbedPropertyConstants.VMARGIN, SWT.TOP);
		fd.width = btnWidth;
		modifyBtn.setLayoutData(fd);

// Add
		addBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				addDimensionSelectionListener, "Add", SWT.PUSH);
		fd = new FormData();
		fd.left = new FormAttachment(tableComposite, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(modifyBtn, -ITabbedPropertyConstants.VMARGIN);
		fd.width = btnWidth;
		addBtn.setLayoutData(fd);

// Delete
		deleteBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				deleteDimensionSelectionListener, "Delete", SWT.PUSH);
		fd = new FormData();
		fd.left = new FormAttachment(tableComposite, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(addBtn, -ITabbedPropertyConstants.VMARGIN);
		fd.width = btnWidth;
		deleteBtn.setLayoutData(fd);

		final UpDownButtonSelectionAdapter moveBtnSelectionListener = new UpDownButtonSelectionAdapter(tableViewer,
				executeChangeOrder);

// Up
		upBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, true, moveBtnSelectionListener,
				"Up",
				SWT.PUSH);
		fd = new FormData();
		fd.left = new FormAttachment(tableComposite, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(deleteBtn, -ITabbedPropertyConstants.VMARGIN);
		fd.width = btnWidth;
		upBtn.setLayoutData(fd);

// Down
		downBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, false,
				moveBtnSelectionListener,
				"Down", SWT.PUSH);
		fd = new FormData();
		fd.left = new FormAttachment(tableComposite, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(upBtn, -ITabbedPropertyConstants.VMARGIN);
		fd.width = btnWidth;
		downBtn.setLayoutData(fd);

		InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "Dimensions:");
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	private static TableViewer createTableViewer(final Composite tableComposite) {
		final TableViewer tableViewer = new TableViewer(tableComposite,
				SWT.NO_SCROLL | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);

		return tableViewer;
	}

// Move call element
	private final ExecuteOrderChange<Integer, Integer, DragAndDropElement> executeChangeOrder = (newIndex, curIndex,
			dNDElement) -> {
				if (newIndex != curIndex) {
					selectedIndex = newIndex;
					selectedBos.modify(ArrayableElement.class, ae -> {
						final ArrayDimension dim = ae.getArrayDimensions().get(dNDElement.getIndex() - 1);
						ae.getArrayDimensions().move(newIndex, dim);
					});
				}
			};

			private static ArrayDimension createArrayDimensionDuplicate(final Aadl2Package pkg, final ArrayDimension dim) {
				final ArrayDimension newDim = (ArrayDimension) pkg.getEFactoryInstance().create(pkg.getArrayDimension());
				if (dim.getSize() != null) {
					final ArraySize newArraySize = (ArraySize) pkg.getEFactoryInstance().create(pkg.getArraySize());
					newArraySize.setSize(dim.getSize().getSize());
					newArraySize.setSizeProperty(dim.getSize().getSizeProperty());
					newDim.setSize(newArraySize);
				}

				return newDim;
			}

			private ArrayDimension getSelectedDimension() {
				final IStructuredSelection selection = tableViewer.getStructuredSelection();
				if (!selection.isEmpty()) {
					final Optional<ArrayableElement> optAe = selectedBos.boStream(ArrayableElement.class).findFirst();
					if (optAe.isPresent()) {
						return optAe.get().getArrayDimensions().get(selectedIndex);
					}
				}

				return null;
			}

			private final SelectionAdapter modifyDimensionSelectionListener = new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					selectedIndex = tableViewer.getTable().getSelectionIndex();
					final ArrayDimension dim = getSelectedDimension();
					if (dim != null && modifiedArrayDimension(dim, SelectionUtil.getProjectOrThrow(dim.eResource()))) {
						final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
						selectedBos.modify(ArrayableElement.class, ae -> {
							ae.getArrayDimensions().set(selectedIndex, createArrayDimensionDuplicate(pkg, dim));
						});
					}
				}
			};

			private final SelectionAdapter addDimensionSelectionListener = new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final Aadl2Package pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
					final ArrayDimension dim = (ArrayDimension) pkg.getEFactoryInstance().create(pkg.getArrayDimension());
					selectedBos.boStream(ArrayableElement.class).findAny().ifPresent(ele -> {
						if (modifiedArrayDimension(dim, SelectionUtil.getProjectOrThrow(ele.eResource()))) {
							selectedBos.modify(ArrayableElement.class, ae -> {
								ae.getArrayDimensions().add(createArrayDimensionDuplicate(pkg, dim));
							});
						}
					});
				}
			};

			private final SelectionAdapter deleteDimensionSelectionListener = new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					final boolean confirmDelete = MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Confirm",
							"Would you like to delete the selected dimension?");
					if (confirmDelete) {
						final int index = tableViewer.getTable().getSelectionIndex();
						selectedBos.modify(ArrayableElement.class, ae -> {
							ae.getArrayDimensions().remove(index);
						});
					}
				}
			};

			private static TableColumnLayout createTableColumnLayout(final TableColumn column) {
				final TableColumnLayout tcl = new TableColumnLayout();
				tcl.setColumnData(column, new ColumnWeightData(1, true));
				return tcl;
			}

// Prompt user
			private static boolean modifiedArrayDimension(final ArrayDimension dim, final IProject project) {
				// Show the editor dimension dialog. If the user selects OK, it will modify the passed in object.
				final EditDimensionDialog dlg = new EditDimensionDialog(Display.getCurrent().getActiveShell(), project, dim);
				if (dlg.open() == Window.CANCEL) {
					return false;
				}

				return true;
			}

			@Override
			public void setInput(final IWorkbenchPart part, final ISelection selection) {
				super.setInput(part, selection);
				selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
			}

			@Override
			public void refresh() {
				final List<ArrayableElement> arrayableElements = selectedBos.boStream(ArrayableElement.class)
						.collect(Collectors.toList());
				final Iterator<ArrayableElement> it = arrayableElements.iterator();
				ArrayableElement ae = it.next();
				boolean allowMultipleDimensions = !isFeature(ae);
				final List<String> arrayableDimensions = ae.getArrayDimensions().stream().map(ad -> getLabel(ad))
						.collect(Collectors.toList());
				boolean tableEnabled = true;
				while (it.hasNext()) {
					ae = it.next();
					if (allowMultipleDimensions) {
						allowMultipleDimensions = !isFeature(ae);
					}
					if (arrayableDimensions
							.equals(ae.getArrayDimensions().stream().map(ad -> getLabel(ad)).collect(Collectors.toList()))) {
					} else {
						// Table disabled and cleared
						tableEnabled = false;
						selectedIndex = 0;
						arrayableDimensions.clear();
						break;
					}
				}

				final int[] mutableIndex = { 0 };
				tableViewer.setInput(arrayableDimensions.stream().map(sc -> {
					mutableIndex[0] = ++mutableIndex[0];
					return new DragAndDropElement(sc, mutableIndex[0]);
				}).toArray());

				tableViewer.getTable().setSelection(selectedIndex);
				setControlsEnabled(tableEnabled, arrayableDimensions.size(), allowMultipleDimensions);
			}

			private static boolean isFeature(final ArrayableElement ae) {
				return ae instanceof Feature;
			}

			private void setControlsEnabled(final boolean tableEnabled, final int size, final boolean allowMultipleDimensions) {
				final boolean isEmpty = size == 0;
				tableViewer.getTable().setEnabled(tableEnabled);
				modifyBtn.setEnabled(!isEmpty);
				deleteBtn.setEnabled(!isEmpty);
				addBtn.setEnabled(tableEnabled && (isEmpty || allowMultipleDimensions));
				updateMoveButtons(size - 1);
			}

			private void updateMoveButtons(final int size) {
				upBtn.setEnabled(selectedIndex - 1 >= 0);
				downBtn.setEnabled(selectedIndex + 1 <= size);
			}

			private String getLabel(final ArrayDimension ad) {
				final ArraySize dimSize = ad.getSize();
				final String txt;
				if (dimSize == null) {
					txt = emptyString;
				} else if (dimSize.getSizeProperty() != null) {
					if (dimSize.getSizeProperty() instanceof Property) {
						txt = ((Property) dimSize.getSizeProperty()).getQualifiedName();
					} else if (dimSize.getSizeProperty() instanceof PropertyConstant) {
						txt = ((PropertyConstant) dimSize.getSizeProperty()).getQualifiedName();
					} else {
						txt = "<Unsupported case>";
					}
				} else {
					txt = Long.toString(dimSize.getSize());
				}

				return txt;
			}
}
