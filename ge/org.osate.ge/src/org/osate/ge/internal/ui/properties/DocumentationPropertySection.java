package org.osate.ge.internal.ui.properties;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.xtext.util.Strings;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.ui.util.InternalPropertySectionUtil;
import org.osate.ge.internal.util.EObjectDocumentationUtil;
import org.osate.ge.ui.properties.PropertySectionUtil;

public class DocumentationPropertySection extends AbstractPropertySection {
	public static class Filter implements IFilter {
		@Override
		public boolean select(final Object toTest) {
			return PropertySectionUtil.isBoCompatible(toTest,
					bo -> EObjectDocumentationUtil.getDocumentationProvider(bo) != null);
		}
	}

	private BusinessObjectSelection selectedBos;
	private Text documentationField;

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	@Override
	public void createControls(final Composite parent, final TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		final Composite composite = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
		composite.setLayout(GridLayoutFactory.swtDefaults().numColumns(1).create());

		documentationField = getWidgetFactory().createText(composite, "",
				SWT.MULTI | SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
		documentationField.setEnabled(false);
		documentationField.setLayoutData(
				GridDataFactory.swtDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).hint(100, 100).create());

		InternalPropertySectionUtil.setPropertiesHelp(aTabbedPropertySheetPage.getControl());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		selectedBos = Adapters.adapt(selection, BusinessObjectSelection.class);
	}

	@Override
	public void refresh() {
		final List<EObject> bos = selectedBos.boStream(EObject.class).collect(Collectors.toList());
		final String doc = getDocumentation(bos);
		documentationField.setEnabled(doc != null);
		if (bos.size() > 1) {
			documentationField.setText("<Multiple diagram elements are selected>");
		} else {
			documentationField.setText(Strings.emptyIfNull(doc));
		}
	}

	private static String getDocumentation(final List<EObject> selectedBos) {
		if (selectedBos.size() == 1) {
			final EObject bo = selectedBos.get(0);
			return EObjectDocumentationUtil.getPlainTextDocumentation(bo);
		}

		return null;
	}
}
