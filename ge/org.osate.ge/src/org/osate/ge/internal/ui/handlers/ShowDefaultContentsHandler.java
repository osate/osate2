package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.osate.ge.DiagramType;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.filtering.ContentFilterProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.ContentFilterUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class ShowDefaultContentsHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final DiagramType diagramType = diagram.getConfiguration().getDiagramType();
		final ContentFilterProvider contentFilterProvider = getContentFilterProvider();

		// Show elements matching the filter
		ShowContentsUtil.addContentsToSelectedElements(event, (parentElement,
				childBo) -> ContentFilterUtil.passesAnyContentFilter(childBo, diagramType
						.getApplicableDefaultContentFilters(parentElement.getBusinessObject(), contentFilterProvider)));

		return null;
	}

	private ContentFilterProvider getContentFilterProvider() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		return extService;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedDiagramElements().size() > 0);
	}
}