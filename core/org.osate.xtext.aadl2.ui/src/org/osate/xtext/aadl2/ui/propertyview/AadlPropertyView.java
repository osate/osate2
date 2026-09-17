/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ui.propertyview;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BehavioralFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.serializer.InstanceEnabledSerializerBinding;
import org.osate.xtext.aadl2.ui.MyAadl2Activator;

import com.google.inject.Inject;

/**
 * View that displays the AADL property value associations within a given AADL model element.
 */
public class AadlPropertyView extends ViewPart {
	private static final String HIDE_UNDEFINED_TOOL_TIP = "Hide undefined properties";

	private static final String SHOW_UNDEFINED_TOOL_TIP = "Show undefined properties";

	private static final String COLLAPSE_ALL_TOOL_TIP = "Collapse All";

	private static final String SHOW_ONLY_IMPORTED_PROPERTIES = "Show imported properties only";

	private static final String SHOW_ALL_AVAILABLE_PROPERTIES = "Show all available properties";

	private static final String HIDE_DEFAULT_TOOL_TIP = "Hide default property values";

	private static final String SHOW_DEFAULT_TOOL_TIP = "Show default property values";

	private static final String NO_PROPERTIES_TO_SHOW = "No properties to show: Please select a single AADL element that can have properties.";

	private static final String POPULATING_VIEW = "Populating AADL Property Values view.";

	/** Page book for switching between the tree viewer and the "no properties" message. */
	private PageBook pageBook;

	/** Tree for displaying properties. The underlying model is a list of property sets. */
	TreeViewer treeViewer;

	private Composite treeViewerComposite;

	/** The label for the no results message. */
	private Label noPropertiesLabel;

	private Label populatingViewLabel;

	/** Action for toggling the display of nonexistent properties. */
	Action showUndefinedAction;

	Action showDefaultAction;

	private Action removeElementAction;

	private Action openDefinitionAction;

	private Action openPropertyAssociationAction;

	private Action makeLocalAction;

	private Action makeLocalContainedAction;

	private Action createLocalAssociationAction;

	boolean nextEditIsLocalCreation;

	private Action createLocalContainedAssociationAction;

	boolean nextEditIsLocalContainedCreation;

	private Action showOnlyImportedPropertiesAction;

	/** The editing domain for the viewer's input. */
	private EditingDomain editingDomain;

	IXtextDocument xtextDocument;

	Resource resourceFromSelection;

	/** Only show properties from this group, or all properties if empty. */
	private List<FilterCriterion> currentPropertyGroup = new ArrayList<>();

	@Inject
	@InstanceEnabledSerializerBinding
	ISerializer serializer;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private IURIEditorOpener editorOpener;

	@Inject
	private IResourceDescriptionsProvider resourceDescriptionsProvider;

	private URI previousSelectionURI;

	private CachePropertyLookupJob cachePropertyLookupJob;

	private final Object jobLock = new Object();

	// If the URIs were resolved to EObjects, this would be a Map<PropertySet, Map<Property, PropertyAssociation>>.
	final Map<URI, Map<URI, URI>> cachedPropertyAssociations = Collections.synchronizedMap(new LinkedHashMap<>());

	private final List<FilterCriterion> importedPropertyGroups = new ArrayList<>();

	private Set<URI> filteredPropertySets;

	private final ISelectionListener selectionListener = this::updateSelection;

	private final IPartListener partListener = new IPartListener() {
		@Override
		public void partOpened(IWorkbenchPart part) {
		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {
			if (part instanceof XtextEditor editor) {
				var selectionProvider = editor.getInternalSourceViewer().getSelectionProvider();
				if (selectionProvider instanceof IPostSelectionProvider postSelectionProvider) {
					postSelectionProvider.removePostSelectionChangedListener(selectionChangedListener);
				}
			}
		}

		@Override
		public void partClosed(IWorkbenchPart part) {
			if (part instanceof XtextEditor editor && xtextDocument == editor.getDocument()) {
				xtextDocument = null;
			}
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {
		}

		@Override
		public void partActivated(IWorkbenchPart part) {
			if (part instanceof XtextEditor editor) {
				var selectionProvider = editor.getInternalSourceViewer().getSelectionProvider();
				if (selectionProvider instanceof IPostSelectionProvider postSelectionProvider) {
					postSelectionProvider.addPostSelectionChangedListener(selectionChangedListener);
				}
			}
		}
	};

	private final ISelectionChangedListener selectionChangedListener = event -> {
		var editor = getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor instanceof XtextEditor xtextEditor) {
			updateSelection(xtextEditor, event.getSelection());
		}
	};

	// Calling IURIEditorOpener.open causes a model change event, which must be ignored.
	private boolean modelListenerEnabled = true;

	private final IXtextModelListener xtextModelListener = resource -> {
		if (modelListenerEnabled) {
			runCachePropertyLookupJob(getInput(), null);
		}
	};

	@Override
	public void createPartControl(Composite parent) {
		pageBook = new PageBook(parent, SWT.NULL);

		noPropertiesLabel = new Label(pageBook, SWT.LEFT);
		noPropertiesLabel.setText(NO_PROPERTIES_TO_SHOW);
		noPropertiesLabel.setAlignment(SWT.CENTER);
		noPropertiesLabel.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));

		populatingViewLabel = new Label(pageBook, SWT.LEFT);
		populatingViewLabel.setText(POPULATING_VIEW);
		populatingViewLabel.setAlignment(SWT.CENTER);
		populatingViewLabel.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));

		treeViewerComposite = new Composite(pageBook, SWT.NULL);
		var patternFilter = new PatternFilter() {
			@Override
			protected boolean isLeafMatch(Viewer viewer, Object element) {
				var thisTree = (TreeViewer) viewer;
				var labelProvider = (ColumnLabelProvider) thisTree.getLabelProvider(0);
				var contentProvider = (ITreeContentProvider) thisTree.getContentProvider();

				// First go up to the property set and property name. See issue #605.
				var current = element;
				var parentElement = contentProvider.getParent(element);
				while (contentProvider.getParent(parentElement) instanceof TreeEntry) {
					current = parentElement;
					parentElement = contentProvider.getParent(parentElement);
				}

				var propertySetName = Objects.requireNonNullElse(labelProvider.getText(parentElement), "");
				var propertyName = labelProvider.getText(current);
				return wordMatches(propertyName)
						&& (currentPropertyGroup.isEmpty() || isPropertyGroupMatch(propertyName, propertySetName));
			}

			@Override
			protected boolean isParentMatch(Viewer viewer, Object element) {
				return anyChildrenMatch((TreeViewer) viewer, element);
			}

			private boolean anyChildrenMatch(TreeViewer thisTree, Object element) {
				var contentProvider = (ITreeContentProvider) thisTree.getContentProvider();
				var children = contentProvider.getChildren(element);
				if (children != null && children.length > 0) {
					return Arrays.stream(children).anyMatch(child -> anyChildrenMatch(thisTree, child));
				}
				return isLeafMatch(thisTree, element);
			}

			private boolean isPropertyGroupMatch(String elementName, String parentName) {
				return currentPropertyGroup.stream()
						.anyMatch(criterion -> criterion.getParent() == null
								? Objects.equals(elementName, criterion.getElement())
								: Objects.equals(parentName, criterion.getParent())
										&& Objects.equals(elementName, criterion.getElement()));
			}
		};
		// Hack to kill the optimization that disables the filter when the text is empty.
		patternFilter.setPattern("org.eclipse.ui.keys.optimization.false");

		var treeColumnLayout = new TreeColumnLayout();
		var filteredTree = new FilteredTree(treeViewerComposite, SWT.BORDER | SWT.FULL_SELECTION, patternFilter, true) {
			@Override
			protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
				var viewer = super.doCreateTreeViewer(parent, style);
				viewer.getControl().setLayoutData(null);
				parent.setLayout(treeColumnLayout);
				return viewer;
			}
		};
		treeViewerComposite.setLayout(new GridLayout());
		filteredTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer = filteredTree.getViewer();

		var propertyColumn = new TreeViewerColumn(treeViewer, SWT.LEFT);
		propertyColumn.getColumn().setText("Property");
		treeColumnLayout.setColumnData(propertyColumn.getColumn(), new ColumnWeightData(1, true));
		propertyColumn.setLabelProvider(new PropertyColumnLabelProvider(this));

		var valueColumn = new TreeViewerColumn(treeViewer, SWT.LEFT);
		valueColumn.getColumn().setText("Value");
		treeColumnLayout.setColumnData(valueColumn.getColumn(), new ColumnWeightData(2, true));
		valueColumn.setLabelProvider(new ValueColumnLabelProvider(this));
		valueColumn.setEditingSupport(new ValueColumnEditingSupport(treeViewer, this));

		var statusColumn = new TreeViewerColumn(treeViewer, SWT.LEFT);
		statusColumn.getColumn().setText("Status");
		var gc = new GC(statusColumn.getColumn().getParent());
		var statusWidth = Arrays.stream(PropertyStatus.values())
				.mapToInt(status -> gc.stringExtent(status.toString()).x)
				.max()
				.orElse(0);
		treeColumnLayout.setColumnData(statusColumn.getColumn(), new ColumnPixelData(statusWidth + 5, true, true));
		gc.dispose();
		statusColumn.setLabelProvider(new StatusColumnLabelProvider(this));

		treeViewer.getTree().setLinesVisible(true);
		treeViewer.getTree().setHeaderVisible(true);
		treeViewer.setUseHashlookup(true);
		treeViewer.setContentProvider(new PropertyViewContentProvider(this));
		treeViewer.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (filteredPropertySets == null || !(element instanceof TreeEntry entry)) {
					return true;
				}
				return switch (entry.getTreeElement()) {
				case URI uri -> safeRead(resourceSet -> switch (resourceSet.getEObject(uri, true)) {
				case PropertySet propertySet -> filteredPropertySets.contains(propertySet.eResource().getURI());
				case null, default -> true;
				});
				case null, default -> true;
				};
			}
		});

		pageBook.showPage(noPropertiesLabel);
		getSite().getPage().addSelectionListener(selectionListener);
		getSite().getPage().addPartListener(partListener);
		var editor = getSite().getPage().getActiveEditor();
		if (editor instanceof XtextEditor xtextEditor) {
			var selectionProvider = xtextEditor.getInternalSourceViewer().getSelectionProvider();
			if (selectionProvider instanceof IPostSelectionProvider postSelectionProvider) {
				postSelectionProvider.addPostSelectionChangedListener(selectionChangedListener);
			}
		}
		createActions();
		createContextMenu();
	}

	@Override
	public void dispose() {
		synchronized (jobLock) {
			if (cachePropertyLookupJob != null) {
				cachePropertyLookupJob.cancel();
				cachePropertyLookupJob = null;
			}
		}
		getSite().getPage().removeSelectionListener(selectionListener);
		getSite().getPage().removePartListener(partListener);
		var editor = getSite().getPage().getActiveEditor();
		if (editor instanceof XtextEditor xtextEditor) {
			var selectionProvider = xtextEditor.getInternalSourceViewer().getSelectionProvider();
			if (selectionProvider instanceof IPostSelectionProvider postSelectionProvider) {
				postSelectionProvider.removePostSelectionChangedListener(selectionChangedListener);
			}
		}
		if (xtextDocument != null) {
			xtextDocument.removeModelListener(xtextModelListener);
		}
		super.dispose();
	}

	@Override
	public void setFocus() {
		treeViewer.getTree().setFocus();
	}

	boolean canEdit(Object element) {
		if (xtextDocument == null && !(resourceFromSelection instanceof XtextResource)) {
			return false;
		}
		return safeRead(resourceSet -> switch (((TreeEntry) element).getTreeElement()) {
		case URI treeElement -> switch (resourceSet.getEObject(treeElement, true)) {
		case Property property -> {
			var parent = (TreeEntry) ((TreeEntry) element).getParent();
			var associationURI = cachedPropertyAssociations.get(parent.getTreeElement()).get(treeElement);
			/*
			 * A property without an association takes its default value or is undefined, and neither is editable. The
			 * association is only resolved once the status says there is one.
			 */
			yield getPropertyStatusNeverUndefined(associationURI).isEditable()
					&& !((PropertyAssociation) resourceSet.getEObject(associationURI, true)).isModal();
		}
		case BasicPropertyAssociation fieldValue -> {
			var association = EcoreUtil2.getContainerOfType(fieldValue, PropertyAssociation.class);
			yield getPropertyStatusNeverUndefined(resourceSet, association).isEditable() && !association.isModal();
		}
		case null, default -> false;
		};
		case RangeElement rangeElement -> isEditableExpression(resourceSet, rangeElement.getExpressionURI());
		case ListElement listElement -> isEditableExpression(resourceSet, listElement.getExpressionURI());
		case null, default -> false;
		});
	}

	private boolean isEditableExpression(ResourceSet resourceSet, URI expressionURI) {
		var expression = (PropertyExpression) resourceSet.getEObject(expressionURI, true);
		var association = EcoreUtil2.getContainerOfType(expression, PropertyAssociation.class);
		return getPropertyStatusNeverUndefined(resourceSet, association).isEditable() && !association.isModal();
	}

	URI getInput() {
		return (URI) treeViewer.getInput();
	}

	private void createActions() {
		var collapseAllAction = new Action("Collapse All") {
			@Override
			public void run() {
				treeViewer.collapseAll();
			}
		};
		collapseAllAction.setImageDescriptor(MyAadl2Activator.getImageDescriptor("icons/propertyview/collapseall.gif"));
		collapseAllAction.setToolTipText(COLLAPSE_ALL_TOOL_TIP);
		getViewSite().getActionBars().getToolBarManager().add(collapseAllAction);

		showOnlyImportedPropertiesAction = new Action("Show Only Imported Property Groups", IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				setToolTipText(isChecked() ? SHOW_ONLY_IMPORTED_PROPERTIES : SHOW_ALL_AVAILABLE_PROPERTIES);
				if (isChecked()) {
					currentPropertyGroup = new ArrayList<>(importedPropertyGroups);
				} else {
					currentPropertyGroup.clear();
				}
				treeViewer.refresh();
			}
		};
		showOnlyImportedPropertiesAction.setEnabled(false);
		showOnlyImportedPropertiesAction
				.setImageDescriptor(MyAadl2Activator.getImageDescriptor("icons/propertyview/filter_ps.png"));
		showOnlyImportedPropertiesAction.setToolTipText(SHOW_ONLY_IMPORTED_PROPERTIES);
		getViewSite().getActionBars().getToolBarManager().add(showOnlyImportedPropertiesAction);

		showUndefinedAction = new Action(null, IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				setToolTipText(isChecked() ? HIDE_UNDEFINED_TOOL_TIP : SHOW_UNDEFINED_TOOL_TIP);
				treeViewer.refresh();
			}
		};
		showUndefinedAction
				.setImageDescriptor(MyAadl2Activator.getImageDescriptor("icons/propertyview/nonexistent_property.gif"));
		showUndefinedAction.setToolTipText(SHOW_UNDEFINED_TOOL_TIP);
		getViewSite().getActionBars().getToolBarManager().add(showUndefinedAction);

		showDefaultAction = new Action(null, IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				setToolTipText(isChecked() ? HIDE_DEFAULT_TOOL_TIP : SHOW_DEFAULT_TOOL_TIP);
				treeViewer.refresh();
			}
		};
		showDefaultAction
				.setImageDescriptor(MyAadl2Activator.getImageDescriptor("icons/propertyview/filter_properties.gif"));
		showDefaultAction.setToolTipText(SHOW_DEFAULT_TOOL_TIP);
		getViewSite().getActionBars().getToolBarManager().add(showDefaultAction);

		var propertySetFiltersAction = new Action("Property Set Filters...") {
			@Override
			public void run() {
				var workspacePropertySets = new LinkedHashMap<URI, String>();
				var descriptions = resourceDescriptionsProvider.getResourceDescriptions(new ResourceSetImpl());
				for (var description : descriptions.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertySet())) {
					var uri = description.getEObjectURI().trimFragment();
					if (uri.isPlatformResource()) {
						workspacePropertySets.put(uri, description.getName().toString());
					}
				}
				var dialog = new PropertySetFilterDialog(getViewSite().getShell(), workspacePropertySets,
						filteredPropertySets);
				if (dialog.open() == Window.OK) {
					filteredPropertySets = dialog.getSelectedPropertySets();
					treeViewer.refresh();
				}
			}
		};
		getViewSite().getActionBars().getMenuManager().add(propertySetFiltersAction);

		removeElementAction = createRemoveElementAction();
		openDefinitionAction = createOpenDefinitionAction();
		openPropertyAssociationAction = createOpenPropertyAssociationAction();
		makeLocalAction = createMakeLocalAction();
		makeLocalContainedAction = createMakeLocalContainedAction();

		createLocalAssociationAction = new Action("Create Local Property Association") {
			@Override
			public void run() {
				var selectedElement = selectedTreeEntry();
				nextEditIsLocalCreation = true;
				treeViewer.editElement(selectedElement, 1);
			}
		};

		createLocalContainedAssociationAction = new Action("Create Local Contained Property Association") {
			@Override
			public void run() {
				var selectedElement = selectedTreeEntry();
				nextEditIsLocalContainedCreation = true;
				treeViewer.editElement(selectedElement, 1);
			}
		};
	}

	private Action createRemoveElementAction() {
		return new Action("Remove") {
			@Override
			public void run() {
				var selectedElement = selectedTreeEntry();
				switch (selectedElement.getTreeElement()) {
				case URI treeElement -> removeModelElement(selectedElement, treeElement);
				case RangeElement rangeElement -> {
					modify(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							var expression = (PropertyExpression) state.getResourceSet()
									.getEObject(rangeElement.getExpressionURI(), true);
							((RangeValue) expression.getOwner()).setDelta(null);
						}
					});
					treeViewer.refresh(selectedElement.getParent());
				}
				case ListElement listElement -> {
					modify(new IUnitOfWork.Void<XtextResource>() {
						@Override
						public void process(XtextResource state) throws Exception {
							var expression = (PropertyExpression) state.getResourceSet()
									.getEObject(listElement.getExpressionURI(), true);
							((ListValue) expression.getOwner()).getOwnedListElements().remove(listElement.getIndex());
						}
					});
					treeViewer.refresh(selectedElement.getParent());
				}
				case null, default -> throw new AssertionError("Unexpected tree element");
				}
			}
		};
	}

	private void removeModelElement(TreeEntry selectedElement, URI treeElement) {
		Runnable postModificationUpdate = modify(
				resource -> switch (resource.getResourceSet().getEObject(treeElement, true)) {
				case Property property -> {
					var parent = (TreeEntry) selectedElement.getParent();
					var associationURI = cachedPropertyAssociations.get(parent.getTreeElement())
							.get(selectedElement.getTreeElement());
					var association = (PropertyAssociation) resource.getResourceSet().getEObject(associationURI, true);
					((NamedElement) association.getOwner()).getOwnedPropertyAssociations().remove(association);
					yield (Runnable) () -> runCachePropertyLookupJob(getInput(), null);
				}
				case BasicPropertyAssociation fieldValue -> {
					((RecordValue) fieldValue.getOwner()).getOwnedFieldValues().remove(fieldValue);
					yield (Runnable) () -> treeViewer.refresh(selectedElement.getParent());
				}
				case null, default -> throw new AssertionError("Unexpected model element");
				});
		postModificationUpdate.run();
	}

	private Action createOpenDefinitionAction() {
		return new Action("Open Property Definition") {
			@Override
			public void run() {
				var selectedElementURI = (URI) selectedTreeEntry().getTreeElement();
				var uriToOpen = safeRead(resourceSet -> switch (resourceSet.getEObject(selectedElementURI, true)) {
				case PropertySet propertySet -> selectedElementURI;
				case Property property -> selectedElementURI;
				case BasicProperty property -> selectedElementURI;
				case BasicPropertyAssociation fieldValue -> EcoreUtil.getURI(fieldValue.getProperty());
				case null, default -> null;
				});
				modelListenerEnabled = false;
				editorOpener.open(uriToOpen, true);
				modelListenerEnabled = true;
			}
		};
	}

	private Action createOpenPropertyAssociationAction() {
		return new Action("Open Property Association") {
			@Override
			public void run() {
				var selectedElement = selectedTreeEntry();
				var uriToOpen = safeRead(resourceSet -> {
					var parent = (TreeEntry) selectedElement.getParent();
					var associationObject = resourceSet
							.getEObject(cachedPropertyAssociations.get(parent.getTreeElement())
									.get(selectedElement.getTreeElement()), true);
					var association = switch (associationObject) {
					case PropertyAssociationInstance instance -> instance.getPropertyAssociation();
					case PropertyAssociation propertyAssociation -> propertyAssociation;
					case null, default -> null;
					};
					var inputElement = resourceSet.getEObject(getInput(), true);
					Element elementToOpen = association;
					if (inputElement instanceof RefinableElement refinableElement) {
						elementToOpen = association.getAppliesTos()
								.stream()
								.map(appliesTo -> appliesTo.getContainmentPathElements().getLast())
								.filter(path -> path.getNamedElement() instanceof RefinableElement candidate
										&& AadlUtil.isSameOrRefines(candidate, refinableElement))
								.<Element> map(path -> path)
								.findFirst()
								.orElse(association);
					}
					return EcoreUtil.getURI(elementToOpen);
				});
				modelListenerEnabled = false;
				editorOpener.open(uriToOpen, true);
				modelListenerEnabled = true;
			}
		};
	}

	private Action createMakeLocalAction() {
		return new Action("Make Local") {
			@Override
			public void run() {
				var selectedElement = selectedTreeEntry();
				var propertyURI = (URI) selectedElement.getTreeElement();
				var parent = (TreeEntry) selectedElement.getParent();
				var associationURI = cachedPropertyAssociations.get(parent.getTreeElement()).get(propertyURI);
				var postModificationUpdate = modify(resource -> {
					Runnable update = () -> {
					};
					var resourceSet = resource.getResourceSet();
					var inputElement = (NamedElement) resourceSet.getEObject(getInput(), true);
					resolveProperties(inputElement);
					if (associationURI != null) {
						var oldAssociation = (PropertyAssociation) resourceSet.getEObject(associationURI, true);
						var newAssociation = EcoreUtil.copy(oldAssociation);
						newAssociation.getAppliesTos().clear();
						if (oldAssociation.getAppliesTos().size() == 1) {
							((NamedElement) oldAssociation.getOwner()).getOwnedPropertyAssociations()
									.remove(oldAssociation);
							update = () -> runCachePropertyLookupJob(getInput(), null);
						} else if (oldAssociation.getAppliesTos().size() > 1) {
							removeAppliesTo(oldAssociation, inputElement);
						}
						inputElement.getOwnedPropertyAssociations().add(newAssociation);
					} else {
						var property = (Property) resourceSet.getEObject(propertyURI, true);
						createPropertyAssociation(inputElement, property, null);
					}
					return update;
				});
				postModificationUpdate.run();
			}
		};
	}

	private Action createMakeLocalContainedAction() {
		return new Action("Make Local Contained") {
			@Override
			public void run() {
				var selectedElement = selectedTreeEntry();
				var propertyURI = (URI) selectedElement.getTreeElement();
				var parent = (TreeEntry) selectedElement.getParent();
				var associationURI = cachedPropertyAssociations.get(parent.getTreeElement()).get(propertyURI);
				var postModificationUpdate = modify(resource -> {
					Runnable update = () -> {
					};
					var resourceSet = resource.getResourceSet();
					var inputElement = (NamedElement) resourceSet.getEObject(getInput(), true);
					resolveProperties(inputElement);
					if (associationURI != null) {
						var oldAssociation = (PropertyAssociation) resourceSet.getEObject(associationURI, true);
						var newAssociation = EcoreUtil.copy(oldAssociation);
						newAssociation.getAppliesTos().clear();
						newAssociation.getAppliesTos().add(createAppliesTo(inputElement));
						if (oldAssociation.getAppliesTos().isEmpty() && oldAssociation.getOwner() == inputElement) {
							inputElement.getOwnedPropertyAssociations().remove(oldAssociation);
							update = () -> runCachePropertyLookupJob(getInput(), null);
						} else if (oldAssociation.getAppliesTos().size() > 1) {
							removeAppliesTo(oldAssociation, inputElement);
						}
						((NamedElement) inputElement.getOwner()).getOwnedPropertyAssociations().add(newAssociation);
					} else {
						var property = (Property) resourceSet.getEObject(propertyURI, true);
						createPropertyAssociation((NamedElement) inputElement.getOwner(), property, inputElement);
					}
					return update;
				});
				postModificationUpdate.run();
			}
		};
	}

	private static void createPropertyAssociation(NamedElement owner, Property property, NamedElement appliesTo) {
		var association = owner.createOwnedPropertyAssociation();
		association.setProperty(property);
		association.createOwnedValue().setOwnedValue(EcoreUtil.copy(property.getDefaultValue()));
		if (appliesTo != null) {
			association.getAppliesTos().add(createAppliesTo(appliesTo));
		}
	}

	private static ContainedNamedElement createAppliesTo(NamedElement element) {
		var appliesTo = Aadl2Factory.eINSTANCE.createContainedNamedElement();
		appliesTo.createPath().setNamedElement(element);
		return appliesTo;
	}

	private static void removeAppliesTo(PropertyAssociation association, NamedElement inputElement) {
		association.getAppliesTos()
				.stream()
				.filter(appliesTo -> appliesTo.getPath().getNamedElement() == inputElement)
				.findFirst()
				.ifPresent(association.getAppliesTos()::remove);
	}

	private TreeEntry selectedTreeEntry() {
		return (TreeEntry) ((IStructuredSelection) treeViewer.getSelection()).getFirstElement();
	}

	/**
	 * When editing a raw XtextResource, this calls getProperty() for all property associations owned by the element.
	 * Under certain conditions the property reference is not updated, which can leave a broken proxy. Resolving the
	 * property before making a modification prevents that.
	 */
	public void resolveProperties(NamedElement element) {
		if (xtextDocument == null) {
			for (var association : element.getOwnedPropertyAssociations()) {
				association.getProperty();
			}
		}
	}

	<T> T modify(IUnitOfWork<T, XtextResource> work) {
		if (xtextDocument != null) {
			return xtextDocument.modify(work);
		}
		if (!(resourceFromSelection instanceof XtextResource resource)) {
			throw new IllegalStateException(
					"Unsupported case. Cannot modify model without an Xtext document or an Xtext resource");
		}

		class ModificationCommand extends RecordingCommand {
			private T result;

			ModificationCommand(TransactionalEditingDomain domain) {
				super(domain);
			}

			@Override
			protected void doExecute() {
				try {
					result = work.exec(resource);
				} catch (Exception e) {
					throw new IllegalStateException("Could not modify the property value", e);
				}
			}
		}

		var command = new ModificationCommand((TransactionalEditingDomain) editingDomain);
		editingDomain.getCommandStack().execute(command);

		// Run the serializer. Otherwise, an invalid modification could erase the resource. Undo first if serialization
		// fails because the resource may still be used by its owner, such as the graphical editor.
		var serializedSource = resource.getSerializer().serialize(resource.getContents().getFirst());
		if (serializedSource == null || serializedSource.trim().isEmpty()) {
			if (!editingDomain.getCommandStack().canUndo()
					|| editingDomain.getCommandStack().getUndoCommand() != command) {
				throw new IllegalStateException("Property modification failed and unable to undo. Unexpected state.");
			}
			editingDomain.getCommandStack().undo();
		}

		try {
			resource.save(SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		return command.result;
	}

	private void createContextMenu() {
		var menuManager = new MenuManager();
		menuManager.setRemoveAllWhenShown(true);
		menuManager.addMenuListener(manager -> {
			manager.add(openDefinitionAction);
			manager.add(openPropertyAssociationAction);
			manager.add(createLocalAssociationAction);
			manager.add(createLocalContainedAssociationAction);
			manager.add(makeLocalAction);
			manager.add(makeLocalContainedAction);
			manager.add(removeElementAction);
			disableContextMenuActions();

			var selection = (IStructuredSelection) treeViewer.getSelection();
			if (selection.size() == 1) {
				configureContextMenu((TreeEntry) selection.getFirstElement());
			}
			manager.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		});
		treeViewer.getControl().setMenu(menuManager.createContextMenu(treeViewer.getControl()));
		getSite().registerContextMenu(menuManager, treeViewer);
	}

	private void disableContextMenuActions() {
		openDefinitionAction.setEnabled(false);
		openPropertyAssociationAction.setEnabled(false);
		createLocalAssociationAction.setEnabled(false);
		createLocalContainedAssociationAction.setEnabled(false);
		makeLocalAction.setEnabled(false);
		makeLocalContainedAction.setEnabled(false);
		removeElementAction.setEnabled(false);
	}

	private void configureContextMenu(TreeEntry selectedElement) {
		if (selectedElement.getTreeElement() instanceof URI treeElementURI) {
			openDefinitionAction.setEnabled(safeRead(resourceSet -> {
				var treeElement = resourceSet.getEObject(treeElementURI, true);
				return treeElement instanceof PropertySet || treeElement instanceof Property
						|| treeElement instanceof BasicPropertyAssociation || treeElement instanceof BasicProperty;
			}));
			if (safeRead(resourceSet -> resourceSet.getEObject(treeElementURI, true) instanceof Property)) {
				configurePropertyContextMenu(selectedElement, treeElementURI);
			}
		}
		removeElementAction.setEnabled(canEdit(selectedElement) && canRemove(selectedElement));
	}

	private void configurePropertyContextMenu(TreeEntry selectedElement, URI propertyURI) {
		var parent = (TreeEntry) selectedElement.getParent();
		var propertyStatus = getPropertyStatus((URI) parent.getTreeElement(), propertyURI);
		openPropertyAssociationAction
				.setEnabled(EnumSet.of(PropertyStatus.INHERITED, PropertyStatus.LOCAL, PropertyStatus.LOCAL_CONTAINED)
						.contains(propertyStatus));
		var mayCreate = propertyStatus == PropertyStatus.INHERITED || propertyStatus == PropertyStatus.DEFAULT
				|| propertyStatus == PropertyStatus.UNDEFINED;
		createLocalAssociationAction.setEnabled(mayCreate && safeRead(resourceSet -> {
			var inputElement = resourceSet.getEObject(getInput(), true);
			return inputElement instanceof AadlPackage || inputElement instanceof Classifier
					|| supportsContainedAssociation(inputElement);
		}));
		createLocalContainedAssociationAction.setEnabled(mayCreate
				&& safeRead(resourceSet -> supportsContainedAssociation(resourceSet.getEObject(getInput(), true))));
		makeLocalAction.setEnabled(EnumSet.of(PropertyStatus.INHERITED, PropertyStatus.LOCAL_CONTAINED,
				PropertyStatus.LOCAL_SHARED, PropertyStatus.DEFAULT).contains(propertyStatus));
		makeLocalContainedAction.setEnabled(EnumSet
				.of(PropertyStatus.INHERITED, PropertyStatus.LOCAL, PropertyStatus.LOCAL_SHARED, PropertyStatus.DEFAULT)
				.contains(propertyStatus)
				&& safeRead(resourceSet -> supportsContainedAssociation(resourceSet.getEObject(getInput(), true))));
	}

	private static boolean supportsContainedAssociation(EObject element) {
		return element instanceof Subcomponent || element instanceof ModalPath || element instanceof BehavioralFeature
				|| element instanceof Prototype || element instanceof Feature || element instanceof ModeFeature;
	}

	private boolean canRemove(TreeEntry selectedElement) {
		return switch (selectedElement.getTreeElement()) {
		case URI treeElement -> safeRead(resourceSet -> switch (resourceSet.getEObject(treeElement, true)) {
		case Property property -> true;
		case BasicPropertyAssociation fieldValue ->
			((RecordValue) fieldValue.getOwner()).getOwnedFieldValues().size() >= 2;
		case null, default -> false;
		});
		case RangeElement rangeElement -> Objects.equals(rangeElement.getLabel(), RangeElement.DELTA_LABEL);
		case ListElement listElement -> true;
		case null, default -> false;
		};
	}

	private void updateSelection(IWorkbenchPart part, ISelection selection) {
		if (xtextDocument != null) {
			xtextDocument.removeModelListener(xtextModelListener);
		}
		var currentSelection = selectedEObject(part, selection);
		if (xtextDocument != null) {
			xtextDocument.addModelListener(xtextModelListener);
		}

		SelectionTarget selectionTarget;
		try {
			selectionTarget = selectionTarget(currentSelection);
		} catch (NullPointerException e) {
			selectionTarget = null;
		}
		var currentSelectionURI = selectionTarget == null ? null : selectionTarget.uri();
		var treeElementToSelect = selectionTarget == null ? null : selectionTarget.treeElement();
		if (currentSelectionURI != null) {
			editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(currentSelection);
			resourceFromSelection = currentSelection.eResource();
			if (Objects.equals(currentSelectionURI, previousSelectionURI)) {
				if (treeElementToSelect != null) {
					treeViewer.setSelection(new StructuredSelection(treeElementToSelect), true);
				}
				pageBook.showPage(treeViewerComposite);
			} else {
				previousSelectionURI = currentSelectionURI;
				runCachePropertyLookupJob(currentSelectionURI, treeElementToSelect);
			}
		} else {
			clearSelection();
		}

		var packageSection = getPackageSection(currentSelection);
		importedPropertyGroups.clear();
		if (packageSection != null) {
			for (ModelUnit unit : packageSection.getImportedUnits()) {
				if (unit instanceof PropertySet propertySet) {
					for (var property : propertySet.getOwnedProperties()) {
						importedPropertyGroups.add(new FilterCriterion(propertySet.getName(), property.getName()));
					}
				}
			}
			showOnlyImportedPropertiesAction.setEnabled(true);
		} else {
			showOnlyImportedPropertiesAction.setEnabled(false);
		}
	}

	private EObject selectedEObject(IWorkbenchPart part, ISelection selection) {
		if (selection.isEmpty()) {
			return null;
		}
		if (selection instanceof ITextSelection textSelection && part instanceof XtextEditor editor) {
			xtextDocument = editor.getDocument();
			return xtextDocument.readOnly(resource -> new EObjectAtOffsetHelper().resolveContainedElementAt(resource,
					textSelection.getOffset()));
		}
		if (!(selection instanceof IStructuredSelection structuredSelection) || selection instanceof ITextSelection
				|| structuredSelection.size() != 1) {
			return null;
		}
		return switch (structuredSelection.getFirstElement()) {
		case EObject object -> {
			xtextDocument = null;
			yield object;
		}
		case EObjectNode node -> {
			xtextDocument = node.getDocument();
			yield node.readOnly(resource -> resource);
		}
		case EObjectURIWrapper wrapper -> {
			xtextDocument = null;
			yield new ResourceSetImpl().getEObject(wrapper.getUri(), true);
		}
		case null, default -> {
			var selectedObject = structuredSelection.getFirstElement();
			var propertySource = Adapters.adapt(selectedObject, IAadlPropertySource.class);
			if (propertySource == null) {
				propertySource = Adapters.adapt(selection, IAadlPropertySource.class);
			}
			if (propertySource != null) {
				xtextDocument = propertySource.getDocument();
				yield propertySource.getNamedElement();
			}
			yield null;
		}
		};
	}

	private SelectionTarget selectionTarget(EObject selection) {
		/* These are declarations rather than model elements that can carry properties of their own. */
		if (selection instanceof PropertySet || selection instanceof Property || selection instanceof PropertyType
				|| selection instanceof PropertyConstant || selection instanceof PackageSection) {
			return null;
		}
		return switch (selection) {
		/* The properties of the element itself are shown, so there is nothing to select within them. */
		case NamedElement namedElement -> new SelectionTarget(EcoreUtil.getURI(namedElement), null);
		case PropertyAssociation association -> propertyAssociationTarget(association);
		/* The element named by the single containment path of an "applies to" clause. */
		case ContainmentPathElement pathElement when pathElement.getPath() == null
				&& pathElement.getOwner() instanceof ContainedNamedElement -> {
			var root = EcoreUtil.getURI(pathElement.getNamedElement());
			var association = EcoreUtil2.getContainerOfType(pathElement, PropertyAssociation.class);
			yield new SelectionTarget(root, propertyEntry(root, association.getProperty()));
		}
		case BasicPropertyAssociation fieldValue -> propertyValueTarget(fieldValue);
		case PropertyExpression expression -> propertyValueTarget(expression);
		case null, default -> null;
		};
	}

	private SelectionTarget propertyAssociationTarget(PropertyAssociation association) {
		URI root;
		if (association.getAppliesTos().isEmpty()) {
			root = EcoreUtil.getURI(association.getOwner());
		} else if (association.getAppliesTos().size() == 1
				&& association.getAppliesTos().getFirst().getContainmentPathElements().size() == 1) {
			root = EcoreUtil.getURI(
					association.getAppliesTos().getFirst().getContainmentPathElements().getFirst().getNamedElement());
		} else {
			return null;
		}
		return new SelectionTarget(root, propertyEntry(root, association.getProperty()));
	}

	private static TreeEntry propertyEntry(URI root, Property property) {
		var propertySet = EcoreUtil2.getContainerOfType(property, PropertySet.class);
		return new TreeEntry(new TreeEntry(root, EcoreUtil.getURI(propertySet)), EcoreUtil.getURI(property));
	}

	private SelectionTarget propertyValueTarget(Element selection) {
		var path = new ArrayDeque<>();
		if (selection instanceof BasicPropertyAssociation) {
			path.push(EcoreUtil.getURI(selection));
		}
		var currentElement = selection.getOwner();
		var previousElement = selection;
		while (currentElement != null && !(currentElement instanceof PropertyAssociation)) {
			switch (currentElement) {
			case ModalPropertyValue value when ((PropertyAssociation) value.getOwner()).isModal() ->
				path.push(EcoreUtil.getURI(value));
			case BasicPropertyAssociation fieldValue -> path.push(EcoreUtil.getURI(fieldValue));
			case ListValue listValue ->
				path.push(new ListElement(listValue.getOwnedListElements().indexOf(previousElement),
						EcoreUtil.getURI(previousElement)));
			case RangeValue rangeValue -> path.push(new RangeElement(rangeElementLabel(rangeValue, previousElement),
					EcoreUtil.getURI(previousElement)));
			case null, default -> {
			}
			}
			previousElement = currentElement;
			currentElement = currentElement.getOwner();
		}
		if (!(currentElement instanceof PropertyAssociation association)) {
			return null;
		}
		path.push(EcoreUtil.getURI(association.getProperty()));
		URI root = null;
		if (association.getAppliesTos().isEmpty()) {
			root = EcoreUtil.getURI(association.getOwner());
		} else if (association.getAppliesTos().size() == 1
				&& association.getAppliesTos().getFirst().getContainmentPathElements().size() == 1) {
			root = EcoreUtil.getURI(
					association.getAppliesTos().getFirst().getContainmentPathElements().getFirst().getNamedElement());
		}
		Object treeElement = new TreeEntry(root,
				EcoreUtil.getURI(EcoreUtil2.getContainerOfType(association.getProperty(), PropertySet.class)));
		for (var pathElement : path) {
			treeElement = new TreeEntry(treeElement, pathElement);
		}
		return new SelectionTarget(root, treeElement);
	}

	private static String rangeElementLabel(RangeValue range, Element element) {
		if (Objects.equals(element, range.getMinimum())) {
			return RangeElement.MINIMUM_LABEL;
		}
		if (Objects.equals(element, range.getMaximum())) {
			return RangeElement.MAXIMUM_LABEL;
		}
		if (Objects.equals(element, range.getDelta())) {
			return RangeElement.DELTA_LABEL;
		}
		return null;
	}

	private void clearSelection() {
		synchronized (jobLock) {
			if (cachePropertyLookupJob != null) {
				cachePropertyLookupJob.cancel();
				cachePropertyLookupJob = null;
			}
		}
		pageBook.showPage(noPropertiesLabel);
		editingDomain = null;
		resourceFromSelection = null;
		previousSelectionURI = null;
	}

	private static PackageSection getPackageSection(EObject selection) {
		var current = selection;
		while (current != null) {
			if (current instanceof PackageSection packageSection) {
				return packageSection;
			}
			if (!(current instanceof Element element)) {
				return null;
			}
			current = element.getOwner();
		}
		return null;
	}

	<T> T safeRead(Function<? super ResourceSet, ? extends T> operation) {
		return safeReadResource(resource -> operation.apply(resource.getResourceSet()));
	}

	<T> T safeReadResource(Function<? super Resource, ? extends T> operation) {
		if (xtextDocument != null) {
			return xtextDocument.readOnly(resource -> operation.apply(resource));
		}
		if (editingDomain instanceof TransactionalEditingDomain transactionalEditingDomain) {
			try {
				return TransactionUtil.runExclusive(transactionalEditingDomain, new RunnableWithResult.Impl<T>() {
					@Override
					public void run() {
						setResult(operation.apply(resourceFromSelection));
						setStatus(Status.OK_STATUS);
					}
				});
			} catch (InterruptedException e) {
				// Allow the operation to determine what the result should be.
				return operation.apply(null);
			}
		}
		return operation.apply(resourceFromSelection);
	}

	private CachePropertyLookupJob createCachePropertyLookupJob(URI elementURI, Object objectToSelect) {
		return new CachePropertyLookupJob(elementURI, this, getSite().getShell().getDisplay(), scopeProvider,
				() -> pageBook.showPage(populatingViewLabel), () -> {
					treeViewer.setInput(elementURI);
					if (objectToSelect != null) {
						treeViewer.setSelection(new StructuredSelection(objectToSelect), true);
					}
					pageBook.showPage(treeViewerComposite);
				});
	}

	PropertyStatus getPropertyStatus(URI propertySetURI, URI propertyURI) {
		return safeRead(resourceSet -> {
			var associationURI = cachedPropertyAssociations.get(propertySetURI).get(propertyURI);
			if (associationURI != null) {
				var association = (PropertyAssociation) resourceSet.getEObject(associationURI, true);
				var inputElement = resourceSet.getEObject(getInput(), true);
				if (Objects.equals(inputElement, association.getOwner())) {
					return PropertyStatus.LOCAL;
				}
				if (associationAppliesTo(association, inputElement)) {
					return association.getAppliesTos().size() > 1 ? PropertyStatus.LOCAL_SHARED
							: PropertyStatus.LOCAL_CONTAINED;
				}
				return PropertyStatus.INHERITED;
			}
			return ((Property) resourceSet.getEObject(propertyURI, true)).getDefaultValue() != null
					? PropertyStatus.DEFAULT
					: PropertyStatus.UNDEFINED;
		});
	}

	private PropertyStatus getPropertyStatusNeverUndefined(URI associationURI) {
		return associationURI == null ? PropertyStatus.DEFAULT
				: safeRead(resourceSet -> getPropertyStatusNeverUndefined(resourceSet,
						(PropertyAssociation) resourceSet.getEObject(associationURI, true)));
	}

	PropertyStatus getPropertyStatusNeverUndefined(ResourceSet resourceSet, PropertyAssociation association) {
		if (association == null) {
			return PropertyStatus.DEFAULT;
		}
		var inputElement = resourceSet.getEObject(getInput(), true);
		if (Objects.equals(inputElement, association.getOwner())) {
			return PropertyStatus.LOCAL;
		}
		return associationAppliesTo(association, inputElement) ? PropertyStatus.LOCAL_CONTAINED
				: PropertyStatus.INHERITED;
	}

	private static boolean associationAppliesTo(PropertyAssociation association, EObject inputElement) {
		return association.getAppliesTos()
				.stream()
				.anyMatch(appliesTo -> Objects.equals(inputElement,
						appliesTo.getContainmentPathElements().getLast().getNamedElement()));
	}

	void runCachePropertyLookupJob(URI elementURI, Object objectToSelect) {
		synchronized (jobLock) {
			if (cachePropertyLookupJob != null && cachePropertyLookupJob.getState() != Job.NONE) {
				cachePropertyLookupJob.cancel();
			}
			cachePropertyLookupJob = createCachePropertyLookupJob(elementURI, objectToSelect);
			cachePropertyLookupJob.schedule();
		}
	}

	private record SelectionTarget(URI uri, Object treeElement) {
	}
}
