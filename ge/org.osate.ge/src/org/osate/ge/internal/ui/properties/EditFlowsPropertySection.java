package org.osate.ge.internal.ui.properties;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowImplementation;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.ui.dialogs.EditFlowsDialog;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class EditFlowsPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> bo instanceof ComponentImplementation);
		}
	}

	private NamingService namingService;
	private BusinessObjectSelection selectedBos;
	private Button editFlowsBtn;

	private final SelectionListener editFlowsSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(final SelectionEvent e) {
			selectedBos.modify(ComponentImplementation.class, compImpl -> {
				// Show the edit flows dialog
				final EditFlowsDialog dlg = new EditFlowsDialog(Display.getCurrent().getActiveShell(), namingService,
						compImpl);
				if (dlg.open() != Window.CANCEL) {
					// Clear existing flows
					compImpl.getOwnedEndToEndFlows().clear();
					compImpl.getOwnedFlowImplementations().clear();

					for (final Flow flow : dlg.getFlows()) {
						if (flow instanceof EndToEndFlow) {
							compImpl.getOwnedEndToEndFlows().add((EndToEndFlow) flow);
							compImpl.setNoFlows(false);
						} else if (flow instanceof FlowImplementation) {
							compImpl.getOwnedFlowImplementations().add((FlowImplementation) flow);
							compImpl.setNoFlows(false);
						}
					}
				}
			});
		}
	};

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createFlatFormComposite(parent);

		editFlowsBtn = InternalPropertySectionUtil.createButton(getWidgetFactory(), composite, null,
				editFlowsSelectionListener,
				"Edit...", SWT.PUSH);
		final FormData fd = new FormData();
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		editFlowsBtn.setLayoutData(fd);
		InternalPropertySectionUtil.createSectionLabel(composite, getWidgetFactory(), "Flows:");
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
		namingService = Adapters.adapt(part, NamingService.class);
	}

	@Override
	public void refresh() {
		editFlowsBtn.setEnabled(selectedBos.bocStream().count() == 1);
	}
}
