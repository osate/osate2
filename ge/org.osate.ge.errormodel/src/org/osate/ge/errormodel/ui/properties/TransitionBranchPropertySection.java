package org.osate.ge.errormodel.ui.properties;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.BranchValue;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.TransitionBranch;

import com.google.common.base.Objects;

public class TransitionBranchPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest, bo -> {
				return bo instanceof TransitionBranch;
			});
		}
	}

	private BusinessObjectSelection selectedBos;
	private Text valueField;
	private Button saveBtn;

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite container = getWidgetFactory().createFlatFormComposite(parent);

		InternalPropertySectionUtil.createSectionLabel(container, getWidgetFactory(), "Value:");

		valueField = getWidgetFactory().createText(container, "", SWT.SINGLE);

		FormData fd = new FormData();
		fd.width = 150;
		fd.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		fd.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		valueField.setLayoutData(fd);

		// Create the button that will update the diagram. This button won't actually do anything because the BOs are updated when the focus is lost.
		// However, it is useful to have it so that the user can easily see the result of the change without without having to change property tabs/selection.
		saveBtn = getWidgetFactory().createButton(container, "Save", SWT.PUSH);

		fd = new FormData();
		fd.left = new FormAttachment(valueField, ITabbedPropertyConstants.HSPACE);
		fd.top = new FormAttachment(valueField, 0, SWT.CENTER);
		saveBtn.setLayoutData(fd);

		valueField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (valueField.isEnabled()) {
					String value = valueField.getText();
					if (value.startsWith(".")) {
						value = "0" + value;
					}

					final String newValueStr = value;

					selectedBos.modify(TransitionBranch.class, branch -> {
						final BranchValue newValue = (BranchValue) EcoreUtil
								.create(ErrorModelPackage.eINSTANCE.getBranchValue());
						newValue.setRealvalue(newValueStr);
						branch.setValue(newValue);
					});
				}
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
		final List<TransitionBranch> branches = selectedBos.boStream(TransitionBranch.class)
				.collect(Collectors.toList());
		boolean editable = true;
		if (branches.size() == 0) {
			editable = false;
			valueField.setText("");
		} else {
			final TransitionBranch firstBranch = branches.get(0);
			final String firstDisplayValue = getDisplayValue(firstBranch);
			boolean displayFirstValue = firstDisplayValue != null
					&& branches.stream().allMatch(b -> Objects.equal(firstDisplayValue, getDisplayValue(b)));
			editable = displayFirstValue && hasRealValueOrNull(firstBranch);
			if (displayFirstValue) {
				valueField.setText(firstDisplayValue);
			} else {
				valueField.setText("<Multiple Values>");
			}
		}

		valueField.setEnabled(editable);
		saveBtn.setEnabled(editable);
	}

	private static boolean hasRealValueOrNull(final TransitionBranch branch) {
		final BranchValue value = branch.getValue();
		if (value == null) {
			return true;
		}

		return value.getRealvalue() != null;
	}

	private static String getDisplayValue(final TransitionBranch branch) {
		final BranchValue value = branch.getValue();
		if (value == null) {
			return "";
		}

		if (value.getRealvalue() != null) {
			return value.getRealvalue();
		} else if (value.getSymboliclabel() != null) {
			return value.getSymboliclabel().getQualifiedName();
		} else if (value.isOthers()) {
			return "<Others>";
		} else {
			return "<Unsupported Value>";
		}
	}
}
