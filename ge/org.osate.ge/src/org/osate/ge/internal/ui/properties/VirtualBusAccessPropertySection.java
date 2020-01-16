package org.osate.ge.internal.ui.properties;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.BusAccess;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

/**
 * Property section which adds a button to bus access features to toggle whether they are virtual bus access features.
 *
 */
public class VirtualBusAccessPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof BusAccess);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button virtualBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite container = InternalPropertySectionUtil.createRowLayoutComposite(getWidgetFactory(), composite,
				STANDARD_LABEL_WIDTH);

		virtualBtn = getWidgetFactory().createButton(container, "Virtual", SWT.CHECK);
		virtualBtn.setGrayed(false);
		virtualBtn.setSelection(false);
		virtualBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				final Button btn = (Button) e.widget;
				final boolean newVirtual = btn.getSelection();
				selectedBos.modify(BusAccess.class, a -> a.setVirtual(newVirtual));
			}
		});
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<BusAccess> selectedAccesses = selectedBos.boStream(BusAccess.class).collect(Collectors.toSet());

		final boolean allVirtual = selectedAccesses.stream().allMatch(a -> a.isVirtual());
		final boolean allNotVirtual = selectedAccesses.stream().allMatch(a -> !a.isVirtual());
		virtualBtn.setGrayed(allVirtual == allNotVirtual);
		virtualBtn.setSelection(!allNotVirtual);
	}
}
