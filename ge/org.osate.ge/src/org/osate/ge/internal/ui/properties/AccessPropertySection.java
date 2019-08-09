package org.osate.ge.internal.ui.properties;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessType;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class AccessPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof Access);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button providesBtn;
	private Button requiresBtn;

	private final SelectionListener accessSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			if (btn.getSelection()) {
				final AccessType newType = (AccessType) e.widget.getData();
				selectedBos.modify(Access.class, a -> a.setKind(newType));
			}
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Composite directionContainer = InternalPropertySectionUtil.createRowLayoutComposite(getWidgetFactory(),
				composite,
				STANDARD_LABEL_WIDTH);

		providesBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), directionContainer,
				AccessType.PROVIDES,
				accessSelectionListener, "Provides", SWT.RADIO);
		requiresBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), directionContainer,
				AccessType.REQUIRES,
				accessSelectionListener, "Requires", SWT.RADIO);

		InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "Access Type:");
		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part,
			final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<Access> selectedAccesses = selectedBos.boStream(Access.class).collect(Collectors.toSet());

		// Get initial value for buttons
		final AccessType accessType = getAccessType(selectedAccesses);

		// Set selection
		providesBtn.setSelection(accessType == AccessType.PROVIDES);
		requiresBtn.setSelection(accessType == AccessType.REQUIRES);
	}

	private static AccessType getAccessType(final Set<Access> selectedAccesses) {
		final Iterator<Access> it = selectedAccesses.iterator();
		// Initial value of buttons
		final AccessType accessType = it.next().getKind();

		while (it.hasNext()) {
			// Check if all elements are of same access type
			if (accessType != it.next().getKind()) {
				return null;
			}
		}

		return accessType;
	}
}
