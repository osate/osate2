package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.ui.handlers.ToggleContentFilterHandler;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class ToggleFiltersContributionItem extends CompoundContributionItem {
	private final IContributionItem[] EMPTY = new IContributionItem[0];

	@Override
	protected IContributionItem[] getContributionItems() {
		final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			return EMPTY;
		}

		if (window.getActivePage() == null) {
			return EMPTY;
		}

		final IEditorPart activeEditor = window.getActivePage().getActiveEditor();
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			return EMPTY;
		}

		// Don't contribute commands if editor is not editable
		final AgeDiagramEditor editor = (AgeDiagramEditor) activeEditor;
		if (activeEditor == null || !editor.isEditable()) {
			return EMPTY;
		}

		final Bundle bundle = FrameworkUtil.getBundle(getClass());
		final ExtensionRegistryService extRegistry = Objects.requireNonNull(
				EclipseContextFactory.getServiceContext(bundle.getBundleContext()).get(ExtensionRegistryService.class),
				"Unable to retrieve extension registry");

		final List<DiagramElement> diagramElements = SelectionUtil
				.getSelectedDiagramElements(window.getActivePage().getSelection());
		final AgeDiagram diagram = UiUtil.getDiagram(diagramElements);
		if (diagram == null) {
			return EMPTY;
		}

		final Multimap<String, ContentFilter> parentToApplicableFiltersMap = HashMultimap.create();
		for (final ContentFilter contentFilter : extRegistry.getConfigurableContentFilters()) {
			for (final DiagramElement diagramElement : diagramElements) {
				if (contentFilter.isApplicable(diagramElement.getBusinessObject())) {
					parentToApplicableFiltersMap.put(contentFilter.getParentId(), contentFilter);
					break;
				}
			}
		}

		// Create command contributions
		final List<IContributionItem> contributions = new ArrayList<>();
		addContributionItems(contributions, null, parentToApplicableFiltersMap, window);

		if (contributions.size() != 0) {
			contributions.add(new Separator());
		}

		return contributions.toArray(new IContributionItem[contributions.size()]);
	}

	private void addContributionItems(final List<IContributionItem> contributions, final String parentId,
			final Multimap<String, ContentFilter> parentToApplicableFiltersMap, final IWorkbenchWindow window) {
		// Create command contributions
		parentToApplicableFiltersMap.get(parentId).stream()
		.sorted((cf1, cf2) -> cf1.getName().compareToIgnoreCase(cf2.getName())).forEachOrdered(filter -> {
			final Collection<ContentFilter> childFilters = parentToApplicableFiltersMap.get(filter.getId());
			if (childFilters.size() == 0) {
				final CommandContributionItem commandItem = new CommandContributionItem(
						new CommandContributionItemParameter(window, null, "org.osate.ge.toggleContentFilter",
								Collections.singletonMap(ToggleContentFilterHandler.PARAM_CONTENTS_FILTER_ID,
										filter.getId()),
								null, null, null, filter.getName(), null, null,
								CommandContributionItem.STYLE_CHECK, null, true));
				contributions.add(commandItem);
			} else {
				final MenuManager submenu = new MenuManager(filter.getName());
				final IContributionItem dynamicItem = new CompoundContributionItem(null) {
					@Override
					protected IContributionItem[] getContributionItems() {
						final List<IContributionItem> submenuContributions = new ArrayList<>();

						// All
						final CommandContributionItem commandItem = new CommandContributionItem(
								new CommandContributionItemParameter(window, null,
										"org.osate.ge.toggleContentFilter",
										Collections.singletonMap(
												ToggleContentFilterHandler.PARAM_CONTENTS_FILTER_ID,
												filter.getId()),
										null, null, null, "All", null, null,
										CommandContributionItem.STYLE_CHECK, null, true));
						submenuContributions.add(commandItem);

						submenuContributions.add(new Separator());

						addContributionItems(submenuContributions, filter.getId(), parentToApplicableFiltersMap,
								window);
						return submenuContributions.toArray(new IContributionItem[submenuContributions.size()]);
					}
				};
				submenu.add(dynamicItem);
				contributions.add(submenu);
			}
		});

	}
}
