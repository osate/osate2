package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableSet;

public class ToggleAllFiltersHandler extends AbstractHandler implements IElementUpdater {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get the extension registry
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = EclipseContextFactory.getServiceContext(bundle.getBundleContext())
				.get(ExtensionRegistryService.class);
		if (extService == null) {
			throw new RuntimeException("Unable to retrieve extension registry");
		}

		// Get diagram and selected elements
		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) activeEditor;
		final AgeFeatureProvider featureProvider = (AgeFeatureProvider) diagramEditor.getDiagramTypeProvider()
				.getFeatureProvider();
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}

		final boolean addFilters = !areAllApplicableFiltersEnabled();
		if (addFilters) {
			diagram.modify("Enable All Filters", m -> {
				// Update all applicable content filters which do not have a parent to each element
				for (final DiagramElement e : selectedDiagramElements) {
					final ImmutableSet<ContentFilter> newContentFilters = extService.getApplicableContentFilters(e.getBusinessObject()).stream().filter(cf -> cf.getParentId() == null)
							.collect(ImmutableSet.toImmutableSet());
					m.setContentFilters(e, newContentFilters);
				}
			});
		} else {
			diagram.modify("Disable All Filters", m -> {
				// Update the content filters of each element
				for (final DiagramElement e : selectedDiagramElements) {
					m.setContentFilters(e, ImmutableSet.of());
				}
			});
		}

		// Update the diagram
		final IUpdateContext updateCtx = new UpdateContext(diagramEditor.getGraphitiAgeDiagram().getGraphitiDiagram());
		diagramEditor.getDiagramBehavior().executeFeature(featureProvider.getUpdateFeature(updateCtx), updateCtx);

		return null;
	}

	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(AgeHandlerUtil.getSelectedDiagramElementsFromContext(evaluationContext).size() > 0);
	}

	@Override
	public void updateElement(final UIElement element, @SuppressWarnings("rawtypes") final Map parameters) {
		element.setChecked(areAllApplicableFiltersEnabled());
	}

	/**
	 * Returns whether all applicable filters which do not have a parent are enabled for all selected diagram elements.
	 * @return
	 */
	private boolean areAllApplicableFiltersEnabled() {
		final IWorkbenchWindow window = Objects.requireNonNull(PlatformUI.getWorkbench().getActiveWorkbenchWindow(),
				"Unable to retrieve workbench window");

		final List<DiagramElement> selectedDiagramElements = SelectionUtil
				.getSelectedDiagramElements(window.getActivePage().getSelection());
		final ContentFilterProvider contentFilterProvider = getContentFilterProvider();
		for (final DiagramElement de : selectedDiagramElements) {
			for (final ContentFilter filter : contentFilterProvider
					.getApplicableContentFilters(de.getBusinessObject())) {
				if (filter.getParentId() == null && !de.getContentFilters().contains(filter)) {
					return false;
				}
			}
		}

		return true;
	}

	private ContentFilterProvider getContentFilterProvider() {
		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extService = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");
		return extService;
	}
}