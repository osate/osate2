package org.osate.ge.internal.ui.handlers;

import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.diagram.runtime.filtering.ContentFilterProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class ShowContentFilterHandler extends AbstractHandler {
	public static final String PARAM_CONTENTS_FILTER_ID = "contentsFilterId";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Get the content filter
		final String contentFilterId = (String) event.getParameters().get(PARAM_CONTENTS_FILTER_ID);
		if (contentFilterId == null) {
			throw new RuntimeException("Unable to get content filter");
		}

		final ContentFilterProvider contentFilterProvider = getContentFilterProvider();
		final ContentFilter filter = contentFilterProvider.getContentFilterById(contentFilterId)
				.orElseThrow(() -> new RuntimeException("Unable to get content filter"));

		// Show elements matching the filter
		ShowContentsUtil.addContentsToSelectedElements(event, (parentElement,
				childBo) -> filter.isApplicable(parentElement.getBusinessObject()) && filter.test(childBo));

		return null;
	}

	private ContentFilterProvider getContentFilterProvider() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		return extService;
	}
}
