package org.osate.ge.internal.ui.properties;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class InheritedElementNoticePropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest,
					bo -> bo instanceof Element);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Composite composite;
	private Composite warningComposite;
	private Font boldFont;
	private TabbedPropertySheetPage propertySheetPage;

	@Override
	public void dispose() {
		if (boldFont != null) {
			boldFont.dispose();
			boldFont = null;
		}
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		this.propertySheetPage = aTabbedPropertySheetPage;

		composite = getWidgetFactory().createComposite(parent);
		composite.setLayout(GridLayoutFactory.fillDefaults().create());
		warningComposite = getWidgetFactory().createFlatFormComposite(composite);
		warningComposite.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());

		final Label lbl = getWidgetFactory().createLabel(warningComposite,
				"One or more of the selected elements is an inherited element. Modifications will update the declared model element. See OSATE Graphical Editor User Guide for details.");

		warningComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		lbl.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		lbl.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_FOREGROUND));

		final FontDescriptor boldDescriptor = FontDescriptor.createFrom(lbl.getFont()).setStyle(SWT.BOLD);
		boldFont = boldDescriptor.createFont(lbl.getDisplay());
		lbl.setFont(boldFont);

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final boolean visible = selectedBos.bocStream()
				.anyMatch(boc -> !(boc.getBusinessObject() instanceof Classifier
						|| boc.getBusinessObject() instanceof InstanceObject) && boc.getParent() != null
						&& ((Element) boc.getBusinessObject()).getContainingClassifier() != null
						&& boc.getParent().getBusinessObject() != ((Element) boc.getBusinessObject())
						.getContainingClassifier());

		warningComposite.setVisible(visible);
		warningComposite.setLayoutData(
				GridDataFactory.createFrom((GridData) warningComposite.getLayoutData()).exclude(!visible).create());
		propertySheetPage.getControl().pack(true);
		propertySheetPage.getControl().requestLayout();

	}
}
