package org.osate.ge.internal.ui.handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.graphiti.AgeFeatureProvider;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class SetDescendantsToAutomaticHandler extends AbstractHandler implements IElementUpdater {
	@Override
	public void setEnabled(final Object evaluationContext) {
		setBaseEnabled(getManualDescendants().size() > 0);
	}

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

		// Get editor and various services
		final AgeDiagramEditor diagramEditor = (AgeDiagramEditor) activeEditor;
		final AgeFeatureProvider featureProvider = (AgeFeatureProvider) diagramEditor.getDiagramTypeProvider()
				.getFeatureProvider();
		final List<DiagramElement> selectedDiagramElements = AgeHandlerUtil.getSelectedDiagramElements(event);
		final AgeDiagram diagram = UiUtil.getDiagram(selectedDiagramElements);
		if (diagram == null) {
			throw new RuntimeException("Unable to get diagram");
		}


		// Hide all manual descendants
		diagram.modify("Reset Manual Descendants", m -> {
			for (final DiagramElement e : getManualDescendants()) {
				if (e.isManual()) {
					m.setManual(e, false);
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
		element.setText("Reset Manual Descendants (" + getManualDescendants().size() + ")");
	}

	// Returns the manual descendants of the selected diagram elements
	private static final Set<DiagramElement> getManualDescendants() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return Collections.emptySet();
		}

		final List<DiagramElement> diagramElements = SelectionUtil
				.getSelectedDiagramElements(window.getActivePage().getSelection());

		return getManualDescendants(diagramElements);
	}

	private static Set<DiagramElement> getManualDescendants(final Collection<DiagramElement> elementsToCheck) {
		final Set<DiagramElement> manualElements = new HashSet<>();
		for (final DiagramElement e : elementsToCheck) {
			addManualDescendants(manualElements, e);
		}

		return manualElements;
	}

	private static void addManualDescendants(final Set<DiagramElement> manualElements, final DiagramElement e) {
		// Set all descendants of the specified element as automatic/not manual
		for (final DiagramElement child : e.getDiagramElements()) {
			if (child.isManual()) {
				manualElements.add(child);
			}

			addManualDescendants(manualElements, child);
		}
	}
}
