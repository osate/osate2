package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.menus.UIElement;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.filtering.ContentFilterProvider;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.ContentFilterUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableSet;

public class ToggleContentFilterHandler extends AbstractHandler implements IElementUpdater {
	public static final String PARAM_CONTENTS_FILTER_ID = "contentsFilterId";

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get editor and various services
		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) activeEditor;
		final AgeFeatureProvider featureProvider = (AgeFeatureProvider) diagramEditor.getDiagramTypeProvider()
				.getFeatureProvider();
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements();
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final String contentFilterId = (String) event.getParameters().get(PARAM_CONTENTS_FILTER_ID);
		if (contentFilterId == null) {
			throw new RuntimeException("Unable to get content filter");
		}

		final ContentFilterProvider contentFilterProvider = getContentFilterProvider();
		final ContentFilter filter = contentFilterProvider.getContentFilterById(contentFilterId)
				.orElseThrow(() -> new RuntimeException("Unable to get content filter"));
		final boolean addFilter = !isFilterEnabled(filter, contentFilterProvider);

		final String modLabel = (addFilter ? "Enable " : "Disable ") + "Show " + filter.getName();
		diagram.modify(modLabel, m -> {
			// Update the content filters of each element for which the content filter is applicable
			for (final DiagramElement e : selectedDiagramElements) {
				// Update the content filters
				if (filter.isApplicable(e.getBusinessObject())) {
					final Set<ContentFilter> applicableContentFilters = contentFilterProvider
							.getApplicableContentFilters(e.getBusinessObject());
					final ImmutableSet<ContentFilter> newContentFilters = ContentFilterUtil.updateContentFilterSet(
							e.getContentFilters(), applicableContentFilters, filter, addFilter);
					m.setContentFilters(e, newContentFilters);
				}
			}
		});

		// Update the diagram
		final IUpdateContext updateCtx = new UpdateContext(diagramEditor.getGraphitiAgeDiagram().getGraphitiDiagram());
		diagramEditor.getDiagramBehavior().executeFeature(featureProvider.getUpdateFeature(updateCtx), updateCtx);

		return null;
	}


	@Override
	public void updateElement(final UIElement element, @SuppressWarnings("rawtypes") final Map parameters) {
		final String contentFilterId = (String) parameters.get(PARAM_CONTENTS_FILTER_ID);
		final ContentFilterProvider contentFilterProvider = getContentFilterProvider();
		final ContentFilter filter = contentFilterProvider.getContentFilterById(contentFilterId).orElseThrow(
				() -> new RuntimeException("Unable to retrieve content filter for ID: " + contentFilterId));

		element.setChecked(isFilterEnabled(filter,
				contentFilterProvider));
	}

	private ContentFilterProvider getContentFilterProvider() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		return extService;
	}

	// Returns true if the filter or any of its ancestors are enabled for all elements for which it is applicable
	private static final boolean isFilterEnabled(final ContentFilter contentFilter,
			final ContentFilterProvider contentFilterProvider) {
		final IWorkbenchWindow window = Objects.requireNonNull(PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
				"Unable to retrieve workbench window");

		final List<DiagramElement> selectedDiagramElements = SelectionUtil
				.getSelectedDiagramElements(window.getActivePage().getSelection());
		for (final DiagramElement de : selectedDiagramElements) {
			if (contentFilterProvider.getApplicableContentFilters(de.getBusinessObject())
					.contains(contentFilter)) {
				if (!de.getContentFilters().contains(contentFilter)
						&& !ContentFilterUtil.anyAncestorsEnabled(contentFilter,
								de.getContentFilters(),
								contentFilterProvider.getConfigurableContentFilters())) {
					return false;
				}
			}
		}

		return true;
	}
}
