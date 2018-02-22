package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ContentFilter;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.types.CustomDiagramType;
import org.osate.ge.internal.util.ContentFilterUtil;
import org.osate.ge.internal.util.ManualBranchCache;

import com.google.common.collect.ImmutableSet;

public class DiagramConfigurationDialog {
	public interface Model {
		Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc);

		RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo);

		String getName(BusinessObjectContext boc);

		ImmutableSet<ContentFilter> getApplicableContentFilters(Object bo);

		ImmutableSet<ContentFilter> getDefaultContentFilters(Object bo);

		boolean shouldShowBusinessObject(Object bo);

		Map<String, Collection<String>> getAadlProperties();

		Object getBusinessObject(CanonicalBusinessObjectReference ref);

		Image getImage(Object bo);

		long getNewNodeId();

		/**
		 *
		 * @param contextBo must not be null
		 * @return
		 */
		String getContextDescription(Object contextBo);
	}

	public class Result {
		private final DiagramConfiguration diagramConfiguration;
		private final BusinessObjectNode businessObjectTree;

		public Result(final DiagramConfiguration diagramConfiguration, final BusinessObjectNode businessObjectTree) {
			this.diagramConfiguration = Objects.requireNonNull(diagramConfiguration,
					"diagramConfiguration must not be null");
			this.businessObjectTree = Objects.requireNonNull(businessObjectTree, "businessObjectTree must not be null");
		}

		public DiagramConfiguration getDiagramConfiguration() {
			return diagramConfiguration;
		}

		public BusinessObjectNode getBusinessObjectTree() {
			return businessObjectTree;
		}
	}

	private class InnerDialog extends Dialog {
		private CheckboxTreeViewer boTreeViewer;
		private CheckboxTreeViewer contentFiltersViewer;

		public InnerDialog(final Shell parentShell) {
			super(parentShell);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Configure Diagram");
			newShell.setMinimumSize(250, 400);
			newShell.setSize(900, 550);
		}

		@Override
		protected Control createDialogArea(final Composite parent) {
			final Composite area = (Composite) super.createDialogArea(parent);

			final Composite container = new Composite(area, SWT.NONE);
			container.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());

			// Diagram Type
			final Label diagramTypeLabel = new Label(container, SWT.NONE);
			diagramTypeLabel.setText("Diagram Type: " + diagramConfigBuilder.getDiagramType().getName());
			diagramTypeLabel.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());

			// Context Business Object
			final Label contextBoLabel = new Label(container, SWT.NONE);
			final String contextBoDesc;
			if (diagramConfigBuilder.getContextBoReference() == null) {
				contextBoDesc = "<none>";
			} else {
				final Object contextBo = model.getBusinessObject(diagramConfigBuilder.getContextBoReference());
				if (contextBo == null) {
					contextBoDesc = "<Unable to Retrieve Context>";
				} else {
					contextBoDesc = model.getContextDescription(contextBo);
				}
			}

			contextBoLabel.setText("Context: " + contextBoDesc);
			contextBoLabel.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());

			final Group modelElementSelectionGroup = new Group(container, SWT.NONE);
			modelElementSelectionGroup.setText("Model Elements:");
			modelElementSelectionGroup.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
			modelElementSelectionGroup
			.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).create());

			boTreeViewer = new CheckboxTreeViewer(modelElementSelectionGroup, SWT.FULL_SELECTION | SWT.BORDER);
			boTreeViewer.setUseHashlookup(true);

			// Update item when checked
			boTreeViewer.addCheckStateListener(event -> {
				// Set is manual
				final BusinessObjectNode node = (BusinessObjectNode) event.getElement();

				if (event.getChecked()) {
					// Set the node and all ancestors as being manual
					BusinessObjectNode tmp;
					for (tmp = node; tmp.getParent() != null; tmp = tmp.getParent()) {
						tmp.setManual(true);
					}
				} else {
					// Set the node and all descendants as being automatic
					setBranchIsManual(node, false);
				}

				// Reset the descendant checker cache
				manualBranchCache.reset();

				// Update the selection
				boTreeViewer.setSelection(new StructuredSelection(node));

				updateTree();
			});

			boTreeViewer.setCheckStateProvider(new ICheckStateProvider() {
				@Override
				public boolean isGrayed(final Object element) {
					return false;
				}

				@Override
				public boolean isChecked(final Object element) {
					final BusinessObjectNode node = (BusinessObjectNode) element;
					return getEnabledState(node) == EnabledState.MANUALLY_ENABLED;
				}
			});

			boTreeViewer.setLabelProvider(new StyledCellLabelProvider(StyledCellLabelProvider.COLORS_ON_SELECTION) {
				@Override
				public void update(final ViewerCell cell) {
					final BusinessObjectNode node = (BusinessObjectNode) cell.getElement();
					cell.setText(model.getName(node));
					cell.setForeground(isEnabled(node) ? null : Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
					cell.setImage(model.getImage(node.getBusinessObject()));
				}
			});

			final Tree tree = boTreeViewer.getTree();
			tree.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(1, 1).minSize(SWT.DEFAULT, 100)
					.hint(200, SWT.DEFAULT).create());
			tree.setLinesVisible(true);

			// Set the contents of the tree viewer
			boTreeViewer.setContentProvider(new BusinessObjectTreeContentProvider());

			// Set a ViewerComparator to use sort the tree
			boTreeViewer.setComparator(new ViewerComparator() {
				@Override
				public int compare(final Viewer viewer, final Object e1, final Object e2) {
					final BusinessObjectNode n1 = (BusinessObjectNode) e1;
					final BusinessObjectNode n2 = (BusinessObjectNode) e2;
					return model.getName(n1).compareToIgnoreCase(model.getName(n2));
				}
			});

			//
			// List for configuring the content filters
			//
			contentFiltersViewer = new CheckboxTreeViewer(modelElementSelectionGroup, SWT.BORDER);
			contentFiltersViewer.getTree().setLayoutData(GridDataFactory.fillDefaults().grab(false, true).span(1, 1)
					.minSize(SWT.DEFAULT, 100).hint(300, SWT.DEFAULT).create());
			contentFiltersViewer.setComparator(new ViewerComparator());
			contentFiltersViewer.setContentProvider(new ContentFilterTreeContentProvider());

			boTreeViewer.addSelectionChangedListener(event -> {
				final BusinessObjectNode selectedBoNode = getSelectedBusinessObjectNode();

				contentFiltersViewer.setInput(selectedBoNode == null ? null
						: model.getApplicableContentFilters(selectedBoNode.getBusinessObject()));

				contentFiltersViewer.getTree().setEnabled(selectedBoNode != null);
			});

			contentFiltersViewer.setCheckStateProvider(new ICheckStateProvider() {
				@Override
				public boolean isGrayed(final Object element) {
					final BusinessObjectNode selectedNode = getSelectedBusinessObjectNode();
					if (selectedNode == null) {
						return false;
					}

					final ContentFilter filter = (ContentFilter) element;

					// Should be grayed if any of descendants are in content filter set
					return ContentFilterUtil.anyDescendantsEnabled(filter, selectedNode.getContentFilters(),
							getCurrentApplicableContentFilters());
				}

				@Override
				public boolean isChecked(final Object element) {
					final BusinessObjectNode selectedNode = getSelectedBusinessObjectNode();
					if (selectedNode == null) {
						return false;
					}

					final ContentFilter filter = (ContentFilter) element;

					// Should be checked if in content filter set, any of it's children are in the set, or if it's parent is in the set.
					return selectedNode.getContentFilters().contains(element) || isGrayed(element)
							|| ContentFilterUtil.anyAncestorsEnabled(filter, selectedNode.getContentFilters(),
									getCurrentApplicableContentFilters());
				}
			});

			contentFiltersViewer.addCheckStateListener(event -> {
				final BusinessObjectNode selectedNode = getSelectedBusinessObjectNode();
				if (selectedNode == null) {
					return;
				}

				final ContentFilter updatedFilter = (ContentFilter) event.getElement();

				// Update the content filters
				final ImmutableSet<ContentFilter> newContentFilters = ContentFilterUtil.updateContentFilterSet(
						selectedNode.getContentFilters(), getCurrentApplicableContentFilters(), updatedFilter,
						event.getChecked());

				selectedNode.setContentFilters(newContentFilters);

				updateTree();
			});

			contentFiltersViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					return ((ContentFilter) element).getName();
				}
			});

			// AADL Properties Widgets
			final Label aadlPropertiesLabel = new Label(container, SWT.NONE);
			aadlPropertiesLabel.setText("AADL Properties:");
			aadlPropertiesLabel.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());

			final ListViewer enabledAadlPropertiesViewer = new ListViewer(container);
			enabledAadlPropertiesViewer.getList()
			.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).hint(SWT.DEFAULT, 100).create());
			enabledAadlPropertiesViewer.setContentProvider(new IStructuredContentProvider() { // Content provider uses a DiagramConfigurationBuilder as input
				@Override
				public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
				}

				@Override
				public void dispose() {
				}

				@Override
				public Object[] getElements(final Object inputElement) {
					return ((DiagramConfigurationBuilder) inputElement).getEnabledAadlPropertiesLowercase().toArray();
				}
			});

			// Configure Sorting
			enabledAadlPropertiesViewer.setComparator(new ViewerComparator());
			enabledAadlPropertiesViewer.setInput(diagramConfigBuilder); // Set the input

			final Composite propertyButtons = new Composite(container, SWT.NONE);
			propertyButtons.setLayout(RowLayoutFactory.swtDefaults().type(SWT.VERTICAL).fill(true).create());
			final Button addPropertyBtn = new Button(propertyButtons, SWT.PUSH);
			addPropertyBtn.setText("Add...");

			final Menu addPropertyMenu = new Menu(addPropertyBtn);

			final Map<String, Collection<String>> aadlPropertySetToPropertiesMap = model.getAadlProperties();

			// Property listener for individual property menu items
			final SelectionListener propertyMenuItemSelectionListener = new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					diagramConfigBuilder.addAadlProperty((String) e.widget.getData());
					enabledAadlPropertiesViewer.refresh();
				}
			};

			// Create a Menu Listener for the property set menus
			final MenuListener propertySetMenuListener = new MenuAdapter() {
				@Override
				public void menuShown(final MenuEvent e) {
					// Remove old menu items
					final Menu menu = (Menu) e.widget;
					for (final MenuItem item : menu.getItems()) {
						item.dispose();
					}

					final String propertySetName = (String) menu.getData();

					// Create new menu items
					final Collection<String> propertySetProperties = aadlPropertySetToPropertiesMap
							.get(e.widget.getData());
					if (propertySetProperties != null) {
						for (final String propertyName : (Iterable<String>) propertySetProperties.stream()
								.sorted()::iterator) {
							final MenuItem propertyMenuItem = new MenuItem(menu, SWT.NONE);
							propertyMenuItem.setText(propertyName);
							final String qualifiedPropertyName = propertySetName + "::" + propertyName;
							propertyMenuItem.setData(qualifiedPropertyName);
							propertyMenuItem.addSelectionListener(propertyMenuItemSelectionListener);

							// Set enabled based on whether it is already in the list
							propertyMenuItem.setEnabled(!diagramConfigBuilder.getEnabledAadlPropertiesLowercase()
									.contains(qualifiedPropertyName.toLowerCase()));
						}
					}
				}
			};

			// Sort properties and create menu items
			for (String propertySetName : (Iterable<String>) aadlPropertySetToPropertiesMap.keySet().stream()
					.sorted()::iterator) {
				final Menu propertySetMenu = new Menu(addPropertyMenu);
				final MenuItem propertySetMenuItem = new MenuItem(addPropertyMenu, SWT.CASCADE);
				propertySetMenuItem.setMenu(propertySetMenu);
				propertySetMenuItem.setText(propertySetName);
				propertySetMenu.setData(propertySetName);
				propertySetMenu.addMenuListener(propertySetMenuListener);
			}

			addPropertyBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// Show Menu
					addPropertyMenu.setVisible(true);
				}
			});

			final Button removePropertyBtn = new Button(propertyButtons, SWT.PUSH);
			removePropertyBtn.setText("Remove");
			removePropertyBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					if (enabledAadlPropertiesViewer.getSelection() instanceof StructuredSelection
							&& !enabledAadlPropertiesViewer.getSelection().isEmpty()) {
						final String qualifiedPropertyName = (String) ((StructuredSelection) enabledAadlPropertiesViewer
								.getSelection()).getFirstElement();
						diagramConfigBuilder.removeAadlProperty(qualifiedPropertyName);
						enabledAadlPropertiesViewer.refresh();
					}
				}
			});

			// Disable remove button whenever item isn't selected.
			removePropertyBtn.setEnabled(false);
			enabledAadlPropertiesViewer.addSelectionChangedListener(
					event -> removePropertyBtn.setEnabled(!event.getSelection().isEmpty()));

			// Set the input for the tree
			boTreeViewer.setInput(businessObjectTree);

			// Expand the root element
			boTreeViewer.expandToLevel(2);

			// Show Connection Primary Labels
			final Composite connectionPrimaryLabelsVisibleContainer = new Composite(container, SWT.NONE);
			connectionPrimaryLabelsVisibleContainer
			.setLayout(RowLayoutFactory.swtDefaults().type(SWT.HORIZONTAL).fill(true).create());
			connectionPrimaryLabelsVisibleContainer.setLayoutData(GridDataFactory.fillDefaults().span(2, 1).create());

			final Label hideConnectionPrimaryLabelsLabel = new Label(connectionPrimaryLabelsVisibleContainer, SWT.NONE);
			hideConnectionPrimaryLabelsLabel.setText("Hide Connection Labels:");

			final Button hideConnectionPrimaryLabelsVisibleBtn = new Button(connectionPrimaryLabelsVisibleContainer,
					SWT.CHECK);
			hideConnectionPrimaryLabelsVisibleBtn.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(final SelectionEvent e) {
					// Use default value if hide is unchecked.
					diagramConfigBuilder.connectionPrimaryLabelsVisible(
							hideConnectionPrimaryLabelsVisibleBtn.getSelection() ? Boolean.FALSE : null);
				}
			});
			hideConnectionPrimaryLabelsVisibleBtn.setSelection(
					Objects.equals(Boolean.FALSE, diagramConfigBuilder.getConnectionPrimaryLabelsVisible()));

			// Set the initial selection
			if (initialSelectionBoPath != null) {
				setSelection(initialSelectionBoPath);
			}

			return area;
		}

		@SuppressWarnings("unchecked")
		private final ImmutableSet<ContentFilter> getCurrentApplicableContentFilters() {
			return (ImmutableSet<ContentFilter>) contentFiltersViewer.getInput();
		}

		private final BusinessObjectNode getSelectedBusinessObjectNode() {
			final ISelection boNodeSelection = boTreeViewer.getSelection();
			final BusinessObjectNode selectedBoNode;
			if (boNodeSelection instanceof StructuredSelection && !boNodeSelection.isEmpty()) {
				selectedBoNode = (BusinessObjectNode) ((StructuredSelection) boNodeSelection).getFirstElement();
			} else {
				selectedBoNode = null;
			}

			return selectedBoNode;
		}

		private void setBranchIsManual(final BusinessObjectNode node, final boolean value) {
			node.setManual(value);
			for (final BusinessObjectNode child : node.getChildren()) {
				setBranchIsManual(child, value);
			}
		}

		/**
		 * Update all elements in the tree. Updating elements does not handle structural changes so it is much faster than refreshing.
		 */
		private void updateTree() {
			boTreeViewer.update(getVisibleElements(), null);
			contentFiltersViewer.refresh();
		}

		private void setSelection(final Object[] boPath) {
			// The tree is populated lazily so we need to reveal each level to ensure that the desired node exists.
			BusinessObjectNode tmpNode = businessObjectTree;
			for (final Object bo : boPath) {
				final RelativeBusinessObjectReference relRef = model.getRelativeBusinessObjectReference(bo);
				final BusinessObjectNode newNode = relRef == null ? null : tmpNode.getChild(relRef);
				if (newNode == null) {
					break;
				} else {
					tmpNode = newNode;
					boTreeViewer.expandToLevel(tmpNode, 1);
				}
			}

			if (tmpNode != businessObjectTree) {
				boTreeViewer.setSelection(new StructuredSelection(tmpNode), true);
			}
		}

		private Object[] getVisibleElements() {
			final ArrayList<Object> elements = new ArrayList<>();
			getVisibleElements(boTreeViewer.getTree().getItems(), elements);
			return elements.toArray();
		}

		private void getVisibleElements(final TreeItem[] items, final Collection<Object> elements) {
			for (final TreeItem treeItem : items) {
				final Object element = treeItem.getData();
				if (element != null) {
					elements.add(element);
				}

				getVisibleElements(treeItem.getItems(), elements);
			}
		}
	}

	private enum EnabledState {
		NOT_ENABLED, // Not enabled. Will not be in the final diagram.
		IMPLICITLY_ENABLED, // Enabled because of other rules. For example if one of its descendants is enabled.
		MANUALLY_ENABLED
	}

	private class BusinessObjectTreeContentProvider implements ITreeContentProvider {
		private final Set<BusinessObjectNode> populatedNodes = new HashSet<>(); // Set of nodes which have had their children populated with nodes for potential
		// business objects

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		}

		@Override
		public Object[] getElements(final Object inputElement) {
			final BusinessObjectNode node = (BusinessObjectNode) inputElement;
			if (node == null) {
				return new Object[0];
			}

			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(final Object parentElement) {
			final BusinessObjectNode node = (BusinessObjectNode) parentElement;
			return node.getChildren().stream().filter(n -> model.shouldShowBusinessObject(n.getBusinessObject()))
					.toArray();
		}

		@Override
		public Object getParent(final Object element) {
			final BusinessObjectNode node = (BusinessObjectNode) element;
			return node.getParent();
		}

		@Override
		public boolean hasChildren(final Object element) {
			final BusinessObjectNode node = (BusinessObjectNode) element;
			if (!populatedNodes.contains(node)) {
				// Create new business object nodes as needed
				for (final Object childBo : model.getChildBusinessObjects(node)) {
					final RelativeBusinessObjectReference childRef = model.getRelativeBusinessObjectReference(childBo);
					// Create a child node if it doesn't exist
					if (node.getChild(childRef) == null) {
						new BusinessObjectNode(node, model.getNewNodeId(), childRef, childBo, false,
								model.getDefaultContentFilters(childBo), Completeness.UNKNOWN);
					}
				}
				populatedNodes.add(node);
			}

			return getChildren(node).length != 0;
		}
	}

	private class ContentFilterTreeContentProvider implements ITreeContentProvider {
		private ImmutableSet<ContentFilter> input;

		@Override
		public void dispose() {
		}

		@SuppressWarnings("unchecked")
		@Override
		public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
			this.input = (ImmutableSet<ContentFilter>) newInput;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Object[] getElements(final Object inputElement) {
			return ((ImmutableSet<ContentFilter>) inputElement).stream().filter(cf -> cf.getParentId() == null)
					.toArray();
		}

		@Override
		public Object[] getChildren(final Object parentElement) {
			final ContentFilter parent = (ContentFilter) parentElement;
			return input.stream().filter(cf -> cf.getParentId() == parent.getId()).toArray();
		}

		@Override
		public Object getParent(final Object element) {
			final ContentFilter child = (ContentFilter) element;
			return input.stream().filter(cf -> cf.getId() == child.getParentId()).findFirst().orElse(null);
		}

		@Override
		public boolean hasChildren(final Object element) {
			final ContentFilter parent = (ContentFilter) element;
			return input.stream().anyMatch(cf -> cf.getParentId() == parent.getId());
		}
	}

	private final Model model;
	private final InnerDialog dlg;
	private final DiagramConfigurationBuilder diagramConfigBuilder;
	private final BusinessObjectNode businessObjectTree;
	private final Object[] initialSelectionBoPath;
	private final ManualBranchCache manualBranchCache = new ManualBranchCache();

	protected DiagramConfigurationDialog(final Shell parentShell, final Model model,
			final DiagramConfiguration diagramConfig, final BusinessObjectNode businessObjectTree,
			final Object[] initialSelectionBoPath) {
		this.model = Objects.requireNonNull(model);
		this.dlg = new InnerDialog(parentShell);
		this.diagramConfigBuilder = new DiagramConfigurationBuilder(
				Objects.requireNonNull(diagramConfig, "diagramConfig must not be null"));
		this.businessObjectTree = Objects.requireNonNull(businessObjectTree, "businessObjectTree must not be null")
				.copy();
		this.initialSelectionBoPath = initialSelectionBoPath;
	}

	/**
	 * A null return value indicates that the dialog was canceled.
	 * @return
	 */
	private Result open() {
		return dlg.open() == Window.OK ? new Result(diagramConfigBuilder.build(), businessObjectTree) : null;
	}

	// Returns whether the node is either manually or automatically enabled
	private boolean isEnabled(final BusinessObjectNode node) {
		return getEnabledState(node) != EnabledState.NOT_ENABLED;
	}

	private EnabledState getEnabledState(final BusinessObjectNode node) {
		if (node.isManual()) {
			return EnabledState.MANUALLY_ENABLED;
		} else if (node.getParent() != null && isEnabled(node.getParent())) {
			final BusinessObjectNode parentNode = node.getParent();

			// Check Parent Content Filters
			for (final ContentFilter contentFilter : parentNode.getContentFilters()) {
				if (contentFilter.test(node.getBusinessObject())) {
					return EnabledState.IMPLICITLY_ENABLED;
				}
			}

			if (manualBranchCache.isManualBranch(node)) {
				return EnabledState.IMPLICITLY_ENABLED;
			}
		}

		// Implicitly enabled because it is a top level node in a diagram with a context. In such diagrams, the root nodes are automatically added.
		if (diagramConfigBuilder.getContextBoReference() != null && node.getParent() != null
				&& node.getParent().getParent() == null) {
			return EnabledState.IMPLICITLY_ENABLED;
		}

		return EnabledState.NOT_ENABLED;
	}

	/**
	 * A null return value indicates that the dialog was canceled.
	 * @param initialSelectionBoPath is an array of business objects which form a path to the node that should be selected. May be null
	 * @return
	 */
	public static Result show(final Shell parentShell, final Model model, final DiagramConfiguration diagramConfig,
			final BusinessObjectNode businessObjectTree, final Object[] initialSelectionBoPath) {
		final DiagramConfigurationDialog dlg = new DiagramConfigurationDialog(parentShell, model, diagramConfig,
				businessObjectTree, initialSelectionBoPath);
		return dlg.open();
	}

	enum TestContentsFilter implements ContentFilter {
		FILTER1, FILTER2, NO_C1, PARENT, CHILD1, CHILD2, CHILD1A, CHILD1B;

		@Override
		public String getId() {
			return this.toString();
		}

		@Override
		public String getParentId() {
			if (this == CHILD1 || this == CHILD2) {
				return PARENT.getId();
			} else if (this == CHILD1A || this == CHILD1B) {
				return CHILD1.getId();
			}
			return null;
		}

		@Override
		public String getName() {
			return this.toString() + " Desc";
		}

		@Override
		public boolean test(final Object t) {
			if (this == NO_C1 && t.equals("C1")) {
				return false;
			}

			return true;
		}

		@Override
		public boolean isApplicable(final Object bo) {
			return true;
		}

	}

	public static void main(String[] args) {
		final Model model = new Model() {
			@Override
			public RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
				return new RelativeBusinessObjectReference(bo.toString());
			}

			@Override
			public Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc) {
				final Collection<Object> children = new ArrayList<>();
				for (int i = 1; i <= 100; i++) {
					children.add("C" + i);
				}
				return children;
			}

			@Override
			public String getName(final BusinessObjectContext boc) {
				return boc.getBusinessObject().toString();
			}

			@Override
			public ImmutableSet<ContentFilter> getApplicableContentFilters(final Object bo) {
				return ImmutableSet.copyOf(TestContentsFilter.values());
			}

			@Override
			public ImmutableSet<ContentFilter> getDefaultContentFilters(final Object bo) {
				return ImmutableSet.of(TestContentsFilter.FILTER1);
			}

			@Override
			public Map<String, Collection<String>> getAadlProperties() {
				final Map<String, Collection<String>> result = new HashMap<>();
				result.put("test_ps1", Arrays.asList(new String[] { "a", "c", "b" }));
				result.put("test_ps2", Arrays.asList(new String[] { "a", "b", "c" }));
				result.put("test_ps3", Arrays.asList(new String[] { "d", "f", "e" }));
				return result;
			}

			@Override
			public Object getBusinessObject(final CanonicalBusinessObjectReference ref) {
				return new Object();
			}

			@Override
			public String getContextDescription(final Object contextBo) {
				return "a::b::c (TestType)";
			}

			@Override
			public boolean shouldShowBusinessObject(final Object bo) {
				return !bo.equals("C3");
			}

			@Override
			public long getNewNodeId() {
				return -1;
			}

			@Override
			public Image getImage(final Object bo) {
				return null;
			}
		};

		final DiagramConfiguration diagramConfig = new DiagramConfigurationBuilder(new CustomDiagramType(), false)
				.setContextBoReference(new CanonicalBusinessObjectReference("test")).addAadlProperty("test::prop1")
				.addAadlProperty("test_ps2::b").connectionPrimaryLabelsVisible(true).build();

		// Create a test business object tree
		final BusinessObjectNode rootNode = new BusinessObjectNode(null, null, null, null, false, ImmutableSet.of(),
				Completeness.UNKNOWN);
		new BusinessObjectNode(rootNode, 0L, new RelativeBusinessObjectReference("A"), "A", false, ImmutableSet.of(),
				Completeness.UNKNOWN);
		new BusinessObjectNode(rootNode, 1L, new RelativeBusinessObjectReference("B"), "B", true, ImmutableSet.of(),
				Completeness.UNKNOWN);
		new BusinessObjectNode(rootNode, 2L, new RelativeBusinessObjectReference("C"), "C", true, ImmutableSet.of(),
				Completeness.UNKNOWN);
		new BusinessObjectNode(rootNode, 3L, new RelativeBusinessObjectReference("D"), "D", true, ImmutableSet.of(),
				Completeness.UNKNOWN);

		// Show the dialog
		final Result result = DiagramConfigurationDialog.show(null, model, diagramConfig, rootNode,
				new Object[] { "A", "C1", "C2", "C4" });
		if (result == null) {
			System.out.println("Dialog was canceled.");
		} else {
			System.out.println(result.getDiagramConfiguration());
			System.out.println(result.getBusinessObjectTree());
		}
	}
}
