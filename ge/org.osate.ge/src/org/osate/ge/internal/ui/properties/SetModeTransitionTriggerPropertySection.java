package org.osate.ge.internal.ui.properties;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.TriggerPort;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog;
import org.osate.ge.internal.ui.dialogs.ModeTransitionTriggerSelectionDialog.ModeTransitionTriggerInfo;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

import com.google.common.collect.Streams;

public class SetModeTransitionTriggerPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				if (bo instanceof ModeTransition) {
					final ModeTransition mt = (ModeTransition) bo;
					return mt.getContainingClassifier() instanceof ComponentClassifier;
				}

				return false;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private TableViewer tableViewer;
	private Button chooseBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		FormData fd;

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite tableComposite = getWidgetFactory().createComposite(composite);
		fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.height = 150;
		fd.width = 325;
		tableComposite.setLayoutData(fd);

		tableViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.HIDE_SELECTION);
		// Hide selection and highlighting
		tableViewer.getTable().addListener(SWT.EraseItem, event -> event.detail &= ~SWT.HOT & ~SWT.SELECTED);
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());

		tableViewer.getTable().setHeaderVisible(true);
		final TableViewerColumn portCol = InternalPropertySectionUtil.createTableColumnViewer(tableViewer,
				"Trigger Port",
				SWT.NONE,
				new CellLabelProvider() {
			@Override
			public void update(final ViewerCell cell) {
				cell.setText((String) cell.getElement());
			}
		});

		portCol.getColumn().setResizable(false);
		tableComposite.setLayout(createTableColumnLayout(portCol.getColumn()));

		chooseBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, null,
				setModeTransitionTriggerSelectionListener, "Choose...", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(tableComposite, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(tableComposite, 0, SWT.CENTER);
		chooseBtn.setLayoutData(fd);

		InternalPropertySectionUtil.createSectionLabel(composite,
				getWidgetFactory(), "Triggers:");
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	private final SelectionAdapter setModeTransitionTriggerSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final ModeTransition modeTransition = selectedBos.boStream(ModeTransition.class)
					.collect(Collectors.toList()).get(0);
			final ComponentClassifier cc = (ComponentClassifier) modeTransition.getContainingClassifier();
			final ModeTransitionTriggerInfo[] selectedTriggers = ModeTransitionTriggerSelectionDialog
					.promptForTriggers(cc, modeTransition);
			if (selectedTriggers != null) {
				selectedBos.modify(ModeTransition.class, mt -> {
					// Remove all trigger port triggers from the mode transition
					mt.getOwnedTriggers().clear();

					// Add the selected ones to it
					for (final ModeTransitionTriggerInfo selectedPort : selectedTriggers) {
						final ModeTransitionTrigger mtt = mt.createOwnedTrigger();
						mtt.setTriggerPort(selectedPort.port);
						mtt.setContext(selectedPort.context);
					}
				});
			}
		}
	};

	private static TableColumnLayout createTableColumnLayout(final TableColumn numColumn) {
		final TableColumnLayout tcl = new TableColumnLayout(false);
		tcl.setColumnData(numColumn, new ColumnWeightData(100, 20));
		return tcl;
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final List<ModeTransition> modeTransitions = selectedBos.boStream(ModeTransition.class)
				.collect(Collectors.toList());
		final Set<String> input;
		if (modeTransitions.size() == 1) {
			input = modeTransitions.stream().flatMap(mt -> mt.getOwnedTriggers().stream())
					.map(mtt -> mtt.getTriggerPort().getName()).collect(Collectors.toSet());
		} else {
			final Iterator<ModeTransition> it = modeTransitions.iterator();
			// Intersection of trigger ports from selected transitions
			final Set<TriggerPort> intTriggerPorts = it.next().getOwnedTriggers().stream()
					.map(mtt -> mtt.getTriggerPort()).collect(Collectors.toSet());
			// Difference of trigger ports from selected transitions
			final Set<TriggerPort> diffTriggerPorts = new HashSet<>(intTriggerPorts);
			while (it.hasNext()) {
				final Set<TriggerPort> nextTriggerPorts = it.next().getOwnedTriggers().stream()
						.map(mtt -> mtt.getTriggerPort()).collect(Collectors.toSet());
				intTriggerPorts.retainAll(nextTriggerPorts);
				diffTriggerPorts.addAll(nextTriggerPorts);
			}

			input = Streams.concat(intTriggerPorts.stream().map(tp -> tp.getName()),
					diffTriggerPorts.stream().filter(tp -> !intTriggerPorts.contains(tp))
					.map(tp -> "<" + tp.getName() + ">")) // Annotate triggers not in common with brackets
					.collect(Collectors.toSet());
		}

		tableViewer.setInput(input);
	}
}
