package org.osate.ge.errormodel.ui.properties;

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
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;

public class ErrorBehaviorStatePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				return bo instanceof ErrorBehaviorState
						&& ((ErrorBehaviorState) bo).eContainer() instanceof ErrorBehaviorStateMachine;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button setInitialStateBtn;

	private final SelectionListener initialStateListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			selectedBos.modify(ErrorBehaviorState.class, state -> {
				final ErrorBehaviorStateMachine sm = (ErrorBehaviorStateMachine) state.eContainer();

				// Clear initial state of all states
				for (final ErrorBehaviorState tmpState : sm.getStates()) {
					if (tmpState.isIntial()) {
						tmpState.setIntial(false);
					}
				}

				// Set selected state as the initial state
				state.setIntial(btn.getSelection());
			});
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(),
				"Initial:");
		setInitialStateBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				initialStateListener, "", SWT.CHECK);

		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		setInitialStateBtn.setLayoutData(fd);
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<ErrorBehaviorState> states = selectedBos.boStream(ErrorBehaviorState.class)
				.collect(Collectors.toSet());
		// Only allow editing 1 element
		final boolean isEnabled = states.size() == 1;
		setInitialStateBtn.setEnabled(isEnabled);
		// Set initial selection
		setInitialStateBtn.setSelection(isEnabled && states.iterator().next().isIntial());
	}
}
