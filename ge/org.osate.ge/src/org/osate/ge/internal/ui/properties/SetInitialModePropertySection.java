package org.osate.ge.internal.ui.properties;

import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Mode;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class SetInitialModePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				if (bo instanceof Mode) {
					final Mode mode = (Mode) bo;
					return mode.getContainingClassifier() instanceof ComponentClassifier;
				}

				return false;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button setInitialModeBtn;

	private final SelectionListener initialModeListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			selectedBos.modify(Mode.class, mode -> {
				final ComponentClassifier cc = (ComponentClassifier) mode.getContainingClassifier();
				// Clear initial state of all modes
				for (final Mode m : cc.getOwnedModes()) {
					if (m.isInitial()) {
						m.setInitial(false);
					}
				}

				// Set selected mode initial state
				mode.setInitial(btn.getSelection());
			});
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Initial:");
		setInitialModeBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				initialModeListener, "", SWT.CHECK);

		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		setInitialModeBtn.setLayoutData(fd);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<Mode> modes = selectedBos.boStream(Mode.class).collect(Collectors.toSet());
		// Only allow editing 1 element
		final boolean isEnabled = modes.size() == 1;
		setInitialModeBtn.setEnabled(isEnabled);
		// Set initial selection
		setInitialModeBtn.setSelection(isEnabled && modes.iterator().next().isInitial());
	}
}
