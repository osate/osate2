package org.osate.ge.ba.properties;

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
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.ba.model.BehaviorAnnexState;
import org.osate.ge.ui.PropertySectionUtil;

public class SetBehaviorStateFinalPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof BehaviorAnnexState);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Button setFinalStateBtn;

	private final SelectionListener finalStateListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			final Button btn = (Button) e.widget;
			selectedBos.modify("Set Final State",
					boc -> boc.getBusinessObject(BehaviorAnnexState.class)
							.map(behaviorAnnexState -> behaviorAnnexState.getEmfContainer() instanceof BehaviorAnnex)
							.isPresent(),
					boc -> boc.getBusinessObject(BehaviorAnnexState.class).map(BehaviorAnnexState::getState)
							.orElseThrow(() -> new RuntimeException("Cannot get behavior state")),
					(behaviorState, boc) -> {
						final BehaviorAnnex behaviorAnnex = (BehaviorAnnex) behaviorState.eContainer();
						// Clear final states
						for (final BehaviorState state : behaviorAnnex.getStates()) {
							state.setFinal(false);
						}

						// Set final state
						behaviorState.setFinal(btn.getSelection());
						btn.setEnabled(false);
					});
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		final Label sectionLabel = PropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "Final:");
		setFinalStateBtn = PropertySectionUtil.createButton(getWidgetFactory(), composite, SWT.NONE,
				finalStateListener, "", SWT.CHECK);

		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(sectionLabel, 0, SWT.CENTER);
		setFinalStateBtn.setLayoutData(fd);
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final Set<BehaviorState> behaviorStates = selectedBos.boStream(BehaviorAnnexState.class)
				.map(BehaviorAnnexState::getState).collect(Collectors.toSet());
		// Only allow editing 1 element
		final boolean isSingleSelection = behaviorStates.size() == 1;
		final BehaviorState selectedState = behaviorStates.iterator().next();
		final boolean isFinalState = selectedState.isFinal();
		// Set button enabled and selection state
		if (isSingleSelection) {
			// Do not allow to set final if any transitions are leaving state, this would break diagram
			final BehaviorAnnex ownedBehaviorAnnex = (BehaviorAnnex) selectedState.eContainer();
			final boolean isEnabled = !ownedBehaviorAnnex.getTransitions().stream()
					.filter(bt -> bt.getSourceState() == selectedState).findAny().isPresent();
			setFinalStateBtn.setSelection(isEnabled && isFinalState);
			setFinalStateBtn.setEnabled(isEnabled && !isFinalState);
		} else {
			// Set selection state for first selection
			setFinalStateBtn.setSelection(isFinalState);
			// Always disabled for multiple selection
			setFinalStateBtn.setEnabled(false);
		}
	}
}
