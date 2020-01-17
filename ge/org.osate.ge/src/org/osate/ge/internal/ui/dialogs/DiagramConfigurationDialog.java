/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.osate.ge.internal.ui.util.ContextHelpUtil;

import com.google.common.collect.ImmutableSet;

public class DiagramConfigurationDialog {
	public interface Model {
		boolean isProxy(Object bo);

		Object resolve(Object bo);

		Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc);

		RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo);

		String getName(BusinessObjectContext boc);

		ImmutableSet<ContentFilter> getDefaultContentFilters(Object bo);

		boolean shouldShowBusinessObject(Object bo);

		Map<String, Collection<String>> getAadlProperties();

		Object getBusinessObject(CanonicalBusinessObjectReference ref);

		Image getImage(Object bo);

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

		public InnerDialog(final Shell parentShell) {
			super(parentShell);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Configure Diagram");
			newShell.setMinimumSize(250, 400);
			newShell.setSize(1300, 1000);
			ContextHelpUtil.setHelp(newShell, ContextHelpUtil.DIAGRAM_CONFIG);
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
				contextBoDesc = "<None>";
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

			final Label modelElementLabel = new Label(container, SWT.NONE);
			modelElementLabel.setText("Model Elements:");
			modelElementLabel.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());

			boTreeViewer = new CheckboxTreeViewer(container,
					SWT.MULTI | SWT.FULL_SELECTION | SWT.BORDER);
			boTreeViewer.setUseHashlookup(true);

			// Update item when checked
			boTreeViewer.addCheckStateListener(event -> {
				final BusinessObjectNode node = (BusinessObjectNode) event.getElement();

				// Don't allow disabling the root node.
				if (isDisableable(node)) {
					if (event.getChecked()) {
						enableNode(node);
					} else {
						// Disable node and descendants
						disableNode(node);
					}

					// Update the selection
					boTreeViewer.setSelection(new StructuredSelection(node));
				}

				updateTree();
			});

			boTreeViewer.setCheckStateProvider(new ICheckStateProvider() {
				@Override
				public boolean isGrayed(final Object element) {
					final BusinessObjectNode node = (BusinessObjectNode) element;
					return !isDisableable(node);
				}

				@Override
				public boolean isChecked(final Object element) {
					final BusinessObjectNode node = (BusinessObjectNode) element;
					return enabledNodes.contains(node);
				}
			});

			boTreeViewer.setLabelProvider(new CellLabelProvider() {
				@Override
				public void update(final ViewerCell cell) {
					final BusinessObjectNode node = (BusinessObjectNode) cell.getElement();
					cell.setText(model.getName(node));
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

			// Expand the root element if there is only one child
			if (businessObjectTree.getChildren().size() == 1) {
				boTreeViewer.expandToLevel(2);
			}

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

		private boolean isDisableable(final BusinessObjectNode node) {
			return diagramConfigBuilder.getContextBoReference() == null || node.getParent() != businessObjectTree;
		}

		private void enableNode(final BusinessObjectNode node) {
			// Enable the node and all ancestors
			BusinessObjectNode tmp;
			for (tmp = node; tmp.getParent() != null; tmp = tmp.getParent()) {
				if (enabledNodes.add(tmp)) {
					enableDefaultChildren(tmp);
				} else {
					break;
				}
			}
		}

		/**
		 * Enables children based on the default content filters of the node.
		 * @param node
		 */
		private void enableDefaultChildren(final BusinessObjectNode node) {
			// Create children as needed
			ensureChildrenPopulated(node);

			// Enable children based on the defualt content filters
			for (BusinessObjectNode child : node.getChildren()) {
				if (!enabledNodes.contains(child)) {
					for (final ContentFilter contentFilter : model.getDefaultContentFilters(node.getBusinessObject())) {
						if (contentFilter.test(child.getBusinessObject())) {
							enableNode(child);
						}
					}
				}
			}
		}

		private void disableNode(final BusinessObjectNode node) {
			if (enabledNodes.remove(node)) {
				for (final BusinessObjectNode child : node.getChildren()) {
					disableNode(child);
				}
			}
		}

		/**
		 * Update all elements in the tree. Updating elements does not handle structural changes so it is much faster than refreshing.
		 */
		private void updateTree() {
			boTreeViewer.update(getVisibleElements(), null);
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

	private class BusinessObjectTreeContentProvider implements ITreeContentProvider {
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
			ensureChildrenPopulated(node);
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

			// Proxies always show as if they contain children to avoid needing to load the actual object when it isn't being used.
			if (model.isProxy(node.getBusinessObject())) {
				return true;
			}

			return getChildren(node).length != 0;
		}
	}

	private final Model model;
	private final InnerDialog dlg;
	private final DiagramConfigurationBuilder diagramConfigBuilder;
	private final BusinessObjectNode businessObjectTree;
	private final Object[] initialSelectionBoPath;
	private final Set<BusinessObjectNode> enabledNodes = new HashSet<>();
	private final Set<BusinessObjectNode> populatedNodes = new HashSet<>(); // Set of nodes which have had their children populated with nodes for potential
	// business objects

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

		// Add all nodes in specfified tree to the enabled nodes set
		enabledNodes.add(this.businessObjectTree);
		this.businessObjectTree.getAllDescendants().forEachOrdered(n -> enabledNodes.add((BusinessObjectNode) n));
	}

	/**
	 * A null return value indicates that the dialog was canceled.
	 * @return
	 */
	private Result open() {
		if (dlg.open() != Window.OK) {
			return null;
		}

		// Remove disabled nodes
		final List<BusinessObjectNode> nodesToRemove = new ArrayList<>();
		determineNodesToRemove(businessObjectTree, nodesToRemove);
		nodesToRemove.forEach(BusinessObjectNode::remove);

		return new Result(diagramConfigBuilder.build(), businessObjectTree);
	}

	/**
	 * Adds the specified node to the nodes to remove if it is disabled. If it is enabled, it checks children.
	 * @param node
	 * @param nodesToRemove
	 */
	private void determineNodesToRemove(final BusinessObjectNode node,
			final List<BusinessObjectNode> nodesToRemove) {
		if (enabledNodes.contains(node)) {
			for (final BusinessObjectNode child : node.getChildren()) {
				determineNodesToRemove(child, nodesToRemove);
			}
		} else {
			nodesToRemove.add(node);
		}
	}

	private void resolveIfProxy(final BusinessObjectNode node) {
		if (model.isProxy(node.getBusinessObject())) {
			final Object resolvedObject = model.resolve(node.getBusinessObject());
			node.setBusinessObject(resolvedObject);
		}
	}

	/**
	 * Populate children of the specified node if they have not been populated.
	 * @param node
	 */
	private void ensureChildrenPopulated(final BusinessObjectNode node) {
		if (!populatedNodes.contains(node)) {
			resolveIfProxy(node);

			// Create new business object nodes as needed
			for (final Object childBo : model.getChildBusinessObjects(node)) {
				final RelativeBusinessObjectReference childRef = model.getRelativeBusinessObjectReference(childBo);
				// Create a child node if it doesn't exist
				if (node.getChild(childRef) == null) {
					new BusinessObjectNode(node, UUID.randomUUID(), childRef, childBo, Completeness.UNKNOWN, true);
				}
			}
			populatedNodes.add(node);
		}
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
			public Image getImage(final Object bo) {
				return null;
			}

			@Override
			public Object resolve(final Object bo) {
				return bo;
			}

			@Override
			public boolean isProxy(Object bo) {
				return false;
			}
		};

		final DiagramConfiguration diagramConfig = new DiagramConfigurationBuilder(new CustomDiagramType(), false)
				.setContextBoReference(new CanonicalBusinessObjectReference("test")).addAadlProperty("test::prop1")
				.addAadlProperty("test_ps2::b").connectionPrimaryLabelsVisible(true).build();

		// Create a test business object tree
		final BusinessObjectNode rootNode = new BusinessObjectNode(null, UUID.randomUUID(), null, null,
				Completeness.UNKNOWN, true);
		new BusinessObjectNode(rootNode, UUID.randomUUID(), new RelativeBusinessObjectReference("A"), "A",
				Completeness.UNKNOWN, true);
		new BusinessObjectNode(rootNode, UUID.randomUUID(), new RelativeBusinessObjectReference("B"), "B",
				Completeness.UNKNOWN, true);
		new BusinessObjectNode(rootNode, UUID.randomUUID(), new RelativeBusinessObjectReference("C"), "C",
				Completeness.UNKNOWN, true);
		new BusinessObjectNode(rootNode, UUID.randomUUID(), new RelativeBusinessObjectReference("D"), "D",
				Completeness.UNKNOWN, true);

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
