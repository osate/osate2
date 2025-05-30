/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.GetNameContext;
import org.osate.ge.internal.Activator;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModificationAdapter;
import org.osate.ge.internal.diagram.runtime.DiagramModificationListener;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.ModificationsCompletedEvent;
import org.osate.ge.internal.model.BusinessObjectProxy;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.ProjectProvider;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.internal.util.BusinessObjectProviderHelper;

import com.google.common.base.Strings;

public class AgeContentOutlinePage extends ContentOutlinePage {
	private static final String PREFERENCE_OUTLINE_LINK_WITH_EDITOR = "outline.linkWithEditor";
	private static final String PREFERENCE_SHOW_HIDDEN_ELEMENTS = "outline.showHiddenElements";
	private IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

	private InternalDiagramEditor editor;
	private ProjectProvider projectProvider;
	private ProjectReferenceService referenceService;
	private final ExtensionRegistryService extRegistry;
	private final BusinessObjectProviderHelper bopHelper;
	private final Action linkWithEditorAction = new ToggleLinkWithEditorAction();
	private final Action showHiddenElementsAction = new ToggleShowHiddenElementsAction();
	private final DiagramModificationListener diagramModificationListener = new DiagramModificationAdapter() {
		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent e) {
			if (!getTreeViewer().getTree().isDisposed() && getTreeViewer() != null) {
				getTreeViewer().refresh();
			}
		}
	};

	// Flag for indicating the the outline and editor selection is being synchronized.
	// Used to avoid adjusting either selection in response to a change to itself.
	// This is important to allow selecting items in the editor which aren't contained in the outline.
	private boolean synchronizingSelection = false;

	public AgeContentOutlinePage(final InternalDiagramEditor editor, final ProjectProvider projectProvider,
			final ExtensionRegistryService extRegistry, final ProjectReferenceService referenceService) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		preferences.addPreferenceChangeListener(preferenceChangeListener);

		this.projectProvider = Objects.requireNonNull(projectProvider, "projectProvider must not be null");
		this.referenceService = Objects.requireNonNull(referenceService, "referenceService must not be null");
		this.extRegistry = Objects.requireNonNull(extRegistry, "extRegistry must not be null");
		this.bopHelper = new BusinessObjectProviderHelper(extRegistry);
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		final IActionBars actionBars = pageSite.getActionBars();
		registerGlobalActionHandler(actionBars, ActionFactory.UNDO.getId());
		registerGlobalActionHandler(actionBars, ActionFactory.REDO.getId());
		registerGlobalActionHandler(actionBars, ActionFactory.COPY.getId());
		registerGlobalActionHandler(actionBars, ActionFactory.PASTE.getId());
		registerGlobalActionHandler(actionBars, ActionFactory.PRINT.getId());
		registerGlobalActionHandler(actionBars, ActionFactory.SAVE_AS.getId());
	}

	private void registerGlobalActionHandler(final IActionBars actionBars, final String actionId) {
		actionBars.setGlobalActionHandler(actionId, editor.getGlobalActionHandler(actionId));
	}

	@Override
	public void dispose() {
		if (editor != null) {
			editor.getDiagram().removeModificationListener(diagramModificationListener);
			preferences.removePreferenceChangeListener(preferenceChangeListener);
			editor = null;
		}

		projectProvider = null;
		referenceService = null;

		super.dispose();
	}

	private final IPreferenceChangeListener preferenceChangeListener = event -> {
		// Update the state of the button based on the new property value.
		// This will not trigger a synchronization.
		if (PREFERENCE_OUTLINE_LINK_WITH_EDITOR.equals(event.getKey())) {
			if (event.getNewValue() != null) {
				linkWithEditorAction.setChecked(Boolean.parseBoolean(event.getNewValue().toString()));
			}
		} else if (Objects.equals(event.getKey(), PREFERENCE_SHOW_HIDDEN_ELEMENTS)) {
			Display.getDefault().asyncExec(() -> showHiddenElementsAction.setChecked(isShowHiddenElementsEnabled()));
		}
	};

	@Override
	public void createControl(final Composite parent) {
		super.createControl(parent);

		final TreeViewer viewer = getTreeViewer();
		ContextHelpUtil.setHelp(viewer.getControl(), ContextHelpUtil.OUTLINE_VIEW);

		// A comparator is set to allow comparing tree elements of different types in a way where they will be equal if the relative reference is equal.
		// This is needed so that tree node will be preserved when elements are hidden and shown and the underlying object type changes.
		// If link with editor is enabled, selection may not be retained.
		viewer.setComparer(new IElementComparer() {
			@Override
			public int hashCode(final Object element) {
				if (element == null) {
					return 0;
				}

				return Objects.hashCode(getRelativeReferenceForElement(element)) + hashCode(getElementParent(element));
			}

			@Override
			public boolean equals(final Object element1, final Object element2) {
				final Object ref1 = getRelativeReferenceForElement(element1);
				final Object ref2 = getRelativeReferenceForElement(element2);
				final boolean referencesAreEqual = Objects.equals(ref1, ref2);
				if (!referencesAreEqual) {
					return false;
				}

				if (element1 == null || element2 == null) {
					return element1 == element2;
				}

				return equals(getElementParent(element1), getElementParent(element2));
			}
		});

		viewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
			}

			@Override
			public Object[] getElements(final Object inputElement) {
				if (inputElement instanceof InternalDiagramEditor) {
					final InternalDiagramEditor editor = (InternalDiagramEditor) inputElement;
					return getChildren(editor.getDiagram());
				}

				return new BusinessObjectContext[0];
			}

			@Override
			public Object[] getChildren(final Object parentElement) {
				if (parentElement instanceof BusinessObjectContext) {
					final BusinessObjectContext parent = ((BusinessObjectContext) parentElement);

					final List<BusinessObjectContext> children = new ArrayList<>();

					// DiagramNodes represent elements which are part of the diagram
					if (parent instanceof DiagramNode) {
						final DiagramNode parentNode = (DiagramNode) parent;

						// Add child diagram nodes
						parentNode.getChildren()
						.stream()
						.filter((de) -> !Strings.isNullOrEmpty(de.getUserInterfaceName())
								|| de.getBusinessObject() instanceof EObject)
						.forEach(children::add);

						// Add children which are hidden based on user preference
						if (showHiddenElementsAction.isChecked()) {
							// If the diagram is a contextless diagram, create a business object context which uses the current project as the business object
							final BusinessObjectContext parentForRetrieval;
							if (parentElement instanceof AgeDiagram && ((AgeDiagram) parentElement).getConfiguration()
									.getContextBoReference() == null) {
								parentForRetrieval = new BusinessObjectContext() {
									@Override
									public Collection<? extends BusinessObjectContext> getChildren() {
										return parentNode.getChildren();
									}

									@Override
									public BusinessObjectContext getParent() {
										return parent.getParent();
									}

									@Override
									public Object getBusinessObject() {
										return projectProvider.getProject();
									}
								};
							} else {
								parentForRetrieval = parent;
							}

							// Add children based on the objects returns by the business object provider for business objects which are not currently in the
							// diagram.
							getChildContextsFromProvider(parent, parentForRetrieval, childRef -> {
								return !children.stream()
										.map(AgeContentOutlinePage.this::getRelativeReferenceForElement)
										.anyMatch(childRef::equals);
							}).filter(this::includeHiddenBusinessObjectContext).forEachOrdered(children::add);
						}
					} else if (parent instanceof BusinessObjectContext) {
						// The parent is another type of business object context which is not included in the diagram

						// Add children which are hidden based on user preference
						if (showHiddenElementsAction.isChecked()) {
							getChildContextsFromProvider(parent, parent, childRef -> true)
							.filter(this::includeHiddenBusinessObjectContext)
							.forEachOrdered(children::add);
						}
					}

					return children.toArray();
				}

				return new BusinessObjectContext[0];
			}

			/**
			 * Filter returns whether a hidden business object context should be shown. This is implemented to be consistent with
			 * handling for diagram elements.
			 */
			private boolean includeHiddenBusinessObjectContext(final BusinessObjectContext boc) {
				final Object bo = boc.getBusinessObject();
				if (bo instanceof EObject) {
					return true;
				}

				final BusinessObjectHandler boh = extRegistry.getApplicableBusinessObjectHandler(bo);
				return boh != null && !Strings.isNullOrEmpty(boh.getName(new GetNameContext(bo)));
			}

			/**
			 * Creates a stream of business object contexts representing the children returned by the business object provider.
			 * Such contexts do not have a valid isChildren() method.
			 * @param parent is the context to use as the parent of returned contexts. This should be the DiagramNode if one exists.
			 * @param parentForRetrieval is the context to use when requesting children from the business object provider
			 * @param filterPredicate is a filter that can be used to filter results by the relative reference before the context is created
			 * @return A stream of child business object contexts
			 */
			private Stream<BusinessObjectContext> getChildContextsFromProvider(final BusinessObjectContext parent,
					final BusinessObjectContext parentForRetrieval,
					final Predicate<RelativeBusinessObjectReference> filterPredicate) {
				return bopHelper.getChildBusinessObjects(parentForRetrieval).stream().map(childBo -> {
					if (childBo instanceof BusinessObjectProxy) {
						return ((BusinessObjectProxy) childBo).resolve(referenceService);
					} else {
						return childBo;
					}
				}).filter(Objects::nonNull).filter(childBo -> {
					final RelativeBusinessObjectReference childRef = referenceService.getRelativeReference(childBo);
					return childRef != null && filterPredicate.test(childRef);
				}).map(childBo -> new BusinessObjectContext() {
					@Override
					public Collection<? extends BusinessObjectContext> getChildren() {
						// Returns an empty list. Shouldn't be needed. All children are hidden and such children will be provided by the content provider.
						return Collections.emptyList();
					}

					@Override
					public BusinessObjectContext getParent() {
						return parent;
					}

					@Override
					public Object getBusinessObject() {
						return childBo;
					}
				});
			}

			@Override
			public Object getParent(final Object element) {
				return getElementParent(element);
			}

			@Override
			public boolean hasChildren(final Object element) {
				if (element instanceof BusinessObjectContext) {
					return getChildren(element).length > 0;
				}

				return false;
			}
		});

		// Create a label provider that will be used by the tree's actual label provider which will be a StyledCellLabelProvider.
		// This label provider is also used by the custom comparator because the default one does not support text provided by the styled cell label provider.
		final LabelProvider innerLabelProvider = new LabelProvider() {
			@Override
			public String getText(final Object element) {
				if (element instanceof BusinessObjectContext) {
					final BusinessObjectContext boc = (BusinessObjectContext) element;
					return UiUtil.getDescription(boc, extRegistry);
				}

				return super.getText(element);
			}

			@Override
			public Image getImage(final Object element) {
				if (element instanceof DiagramElement) {
					final DiagramElement de = (DiagramElement) element;
					return UiUtil.getImage(de.getBusinessObjectHandler(), de.getBusinessObject()).orElse(null);
				} else if (element instanceof BusinessObjectContext) {
					final BusinessObjectContext boc = (BusinessObjectContext) element;
					final Object bo = boc.getBusinessObject();
					return UiUtil.getImage(extRegistry, bo).orElse(null);
				}

				return null;
			}
		};

		viewer.setLabelProvider(new StyledCellLabelProvider(StyledCellLabelProvider.COLORS_ON_SELECTION) {
			@Override
			public void update(final ViewerCell cell) {
				final Object element = cell.getElement();
				cell.setText(innerLabelProvider.getText(element));
				cell.setForeground(
						element instanceof DiagramNode ? null : Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
				cell.setImage(innerLabelProvider.getImage(element));
			}
		});

		viewer.setComparator(new ViewerComparator() {
			@Override
			public int compare(final Viewer viewer, final Object e1, final Object e2) {
				final String t1 = innerLabelProvider.getText(e1);
				final String t2 = innerLabelProvider.getText(e2);
				return getComparator().compare(t1, t2);
			}
		});

		viewer.addDoubleClickListener(event -> UiUtil.openPropertiesView());

		final MenuManager menuMgr = new MenuManager();
		menuMgr.setRemoveAllWhenShown(true);

		final Tree tree = viewer.getTree();
		final Menu menu = menuMgr.createContextMenu(tree);
		tree.setMenu(menu);
		getSite().registerContextMenu("org.osate.ge.editor.AgeDiagramEditor", menuMgr, viewer); // Allow contributions

		editor.addSelectionChangedListener(event -> updateOutlineSelectionIfLinked());
		editor.getDiagram().addModificationListener(diagramModificationListener);

		viewer.addSelectionChangedListener(this);
		viewer.setInput(editor);
	}

	private BusinessObjectContext getElementParent(final Object element) {
		if (element instanceof BusinessObjectContext) {
			return ((BusinessObjectContext) element).getParent();
		}

		return null;
	}

	/**
	 * Gets the relative reference for a tree element. If the specified value is not of the expected types or is null, then null is returned.
	 */
	private RelativeBusinessObjectReference getRelativeReferenceForElement(final Object element) {
		if (element instanceof DiagramElement) {
			return ((DiagramElement) element).getRelativeReference();
		} else if (element instanceof BusinessObjectContext) {
			final Object bo = ((BusinessObjectContext) element).getBusinessObject();
			return bo == null ? null : referenceService.getRelativeReference(bo);
		} else {
			return null;
		}
	}

	// Link With Editor action added to Outline menu
	@Override
	public void makeContributions(final IMenuManager menuManager, final IToolBarManager toolBarManager,
			final IStatusLineManager statusLineManager) {
		toolBarManager.add(linkWithEditorAction);
		menuManager.add(showHiddenElementsAction);
	}

	private void updateOutlineSelectionIfLinked() {
		if (!synchronizingSelection && linkWithEditorAction.isChecked()) {
			try {
				synchronizingSelection = true;
				final TreeViewer treeViewer = getTreeViewer();
				final Set<DiagramElement> outlineNodes = getCurrentlySelectedDiagramElements();
				if (treeViewer != null && treeViewer.getContentProvider() != null
						&& !outlineNodes.equals(editor.getSelectedDiagramElementSet())) {
					treeViewer.setSelection(buildDiagramNodeTreeSelectionFromEditor());
				}
			} finally {
				synchronizingSelection = false;
			}
		}
	}

	private TreeSelection buildDiagramNodeTreeSelectionFromEditor() {
		final Set<DiagramElement> selectedDiagramElements = editor.getSelectedDiagramElementSet();
		if (selectedDiagramElements == null) {
			return TreeSelection.EMPTY;
		}

		final TreePath[] treePaths = selectedDiagramElements.stream()
				.map((dn) -> new TreePath(new Object[] { dn }))
				.toArray(TreePath[]::new);
		return new TreeSelection(treePaths);
	}

	private void updateEditorSelectionIfLinked() {
		try {
			if (!synchronizingSelection && linkWithEditorAction.isChecked() && !getSelection().isEmpty()) {
				// Select TreeItems on editor
				synchronizingSelection = true;
				selectEditorDiagramElements();
			}
		} finally {
			synchronizingSelection = false;
		}
	}

	private void selectEditorDiagramElements() {
		// Compare using diagram nodes to allow selecting labels when link with editor is enabled
		final Set<DiagramElement> outlineElements = getCurrentlySelectedDiagramElements();
		final Set<DiagramElement> editorElements = editor.getSelectedDiagramElementSet();
		if (getTreeViewer() != null && getTreeViewer().getContentProvider() != null
				&& !outlineElements.equals(editorElements)) {
			editor.selectDiagramNodes(outlineElements);
			outlineElements.stream().findFirst().ifPresent(editor::reveal);
		}
	}

	@Override
	public void selectionChanged(final SelectionChangedEvent event) {
		updateEditorSelectionIfLinked();
		super.selectionChanged(event);
	};

	private class ToggleLinkWithEditorAction extends Action {
		public ToggleLinkWithEditorAction() {
			super("Link With Editor", SWT.TOGGLE);

			// Default Link With Editor enabled
			setChecked(getEnabledFromPreferenceStore());
			setImageDescriptor(
					PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_SYNCED));
		}

		@Override
		public void run() {
			preferences.putBoolean(PREFERENCE_OUTLINE_LINK_WITH_EDITOR, isChecked());
			updateOutlineSelectionIfLinked();
		}

		private boolean getEnabledFromPreferenceStore() {
			return preferences.getBoolean(PREFERENCE_OUTLINE_LINK_WITH_EDITOR, true);
		}
	};

	private class ToggleShowHiddenElementsAction extends Action {
		public ToggleShowHiddenElementsAction() {
			super("Show Hidden Elements", SWT.TOGGLE);

			// Default Link With Editor enabled
			setChecked(isShowHiddenElementsEnabled());
		}

		@Override
		public void setChecked(final boolean checked) {
			boolean wasChecked = isChecked();
			super.setChecked(checked);
			if (wasChecked != checked) {
				preferences.putBoolean(PREFERENCE_SHOW_HIDDEN_ELEMENTS, isChecked());

				final TreeViewer treeViewer = getTreeViewer();
				if (treeViewer != null) {
					treeViewer.refresh();
				}
			}
		}
	};

	private boolean isShowHiddenElementsEnabled() {
		return preferences.getBoolean(PREFERENCE_SHOW_HIDDEN_ELEMENTS, true);
	}

	/**
	 * Will never return null. Will remove anything selected in the tree that isn't a DiagramElement
	 * @return
	 */
	private Set<DiagramElement> getCurrentlySelectedDiagramElements() {
		final Object[] outlineSelection = ((IStructuredSelection) getSelection()).toArray();
		final Set<DiagramElement> diagramElements = new HashSet<>();
		for (final Object selectedBusinessObjectContext : outlineSelection) {
			if (selectedBusinessObjectContext instanceof DiagramElement) {
				diagramElements.add((DiagramElement) selectedBusinessObjectContext);
			}
		}

		return diagramElements;
	}
}
