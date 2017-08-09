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
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.ContentsFilter;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;

public class DiagramConfigurationDialog {
	public interface Model {
		Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc);
		RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo);
		String getName(BusinessObjectContext boc);
		Collection<ContentsFilter> getContentsFilters();
		ContentsFilter getDefaultContentsFilter(Object bo);
		boolean showBusinessObject(Object bo);
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
		
		public Result(final DiagramConfiguration diagramConfiguration,
				final BusinessObjectNode businessObjectTree) {
			this.diagramConfiguration = Objects.requireNonNull(diagramConfiguration, "diagramConfiguration must not be null");
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
		private CheckboxTreeViewer treeViewer;
		
		public InnerDialog(final Shell parentShell) {
			super(parentShell);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}
		
		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Configure Diagram");
			newShell.setMinimumSize(250, 400);
			newShell.setSize(800, 550);
		}

		@Override
	  	protected Control createDialogArea(final Composite parent) {
		    final Composite area = (Composite)super.createDialogArea(parent);
		 
		    final Composite container = new Composite(area, SWT.NONE);
		    container.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		    container.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		    
		    // Context Business Object
		    final Label contextBoLabel = new Label(container, SWT.NONE);
		    final String contextBoDesc;
		    if(diagramConfigBuilder.getContextBoReference() == null) {
		    	contextBoDesc = "<none>";
		    } else {
		    	final Object contextBo = model.getBusinessObject(diagramConfigBuilder.getContextBoReference());
		    	if(contextBo == null) {
		    		contextBoDesc = "<Unable to Retrieve Context>";
		    	} else {
		    		contextBoDesc = model.getContextDescription(contextBo);
		    	}		    	
		    }

		    contextBoLabel.setText("Context: " + contextBoDesc);
		    contextBoLabel.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());
		    		    
		    // Model Element Selection
		    final Label modelElementsLabel = new Label(container, SWT.NONE);
		    modelElementsLabel.setText("Model Elements:");
		    modelElementsLabel.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());
		    
		    treeViewer = new CheckboxTreeViewer(container, SWT.FULL_SELECTION | SWT.BORDER);
		    treeViewer.setUseHashlookup(true);
		    
		    // Update item when checked
		    treeViewer.addCheckStateListener(new ICheckStateListener() {
				@Override
				public void checkStateChanged(final CheckStateChangedEvent event) {
					// Set is manual
					final BusinessObjectNode node = (BusinessObjectNode)event.getElement();

					if(event.getChecked()) {
						// Set the node and all ancestors as being manual 
						BusinessObjectNode tmp;
						for(tmp = node; tmp.getParent() != null; tmp = tmp.getParent()) {
							tmp.setManual(true);
						}					
					} else {
						// Set the node and all descendants as being automatic
						setBranchIsManual(node, false);
					}
					
					updateTree();	
				}
		    });
		    
		    treeViewer.setCheckStateProvider(new ICheckStateProvider() {				
				@Override
				public boolean isGrayed(final Object element) {
					return false;
				}
				
				@Override
				public boolean isChecked(final Object element) {
					final BusinessObjectNode node = (BusinessObjectNode)element;
					return getEnabledState(node) == EnabledState.MANUALLY_ENABLED;
				}
			});
		    
		    //
		    // Create Columns
		    //
		    
		    // Name Column
		    final TreeViewerColumn nameColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		    nameColumn.getColumn().setWidth(600);
		    nameColumn.getColumn().setText("Name");
		    nameColumn.setLabelProvider(new StyledCellLabelProvider(StyledCellLabelProvider.COLORS_ON_SELECTION) {
				@Override
				public void update(final ViewerCell cell) {
					final BusinessObjectNode node = (BusinessObjectNode)cell.getElement();
					cell.setText(model.getName(node));
					cell.setForeground(isEnabled(node) ? null : Display.getCurrent().getSystemColor(SWT.COLOR_GRAY));
					cell.setImage(model.getImage(node.getBusinessObject()));
				}
		    });
		    
		    // Dropdown Column for Auto Contents Filter
		    final TreeViewerColumn autoContentsFilterColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		    autoContentsFilterColumn.getColumn().setWidth(100);
		    autoContentsFilterColumn.getColumn().setText("Auto Children");
		    autoContentsFilterColumn.setLabelProvider(new CellLabelProvider() {		    	
				@Override
				public void update(final ViewerCell cell) {
					final BusinessObjectNode node = (BusinessObjectNode)cell.getElement();
					cell.setText(isAutoContentsFilterEditable(node) && node.getAutoContentsFilter() != null ? node.getAutoContentsFilter().description() : "");	
				}
		    });

		    autoContentsFilterColumn.setEditingSupport(new AutoContentsFilterEditingSupport(treeViewer));
		    
		    final Tree tree = treeViewer.getTree();
		    tree.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).span(2, 1).minSize(SWT.DEFAULT, 100).hint(200, SWT.DEFAULT).create());
			tree.setHeaderVisible(true);
			tree.setLinesVisible(true);
		    
			// Set the contents of the tree viewer
		    treeViewer.setContentProvider(new BusinessObjectTreeContentProvider());
		    
		    // Set a ViewerComparator to use sort the tree
		    treeViewer.setComparator(new ViewerComparator() {
		    	@Override
		    	public int compare(final Viewer viewer, final Object e1, final Object e2) {
		    		final BusinessObjectNode n1 = (BusinessObjectNode)e1;
			    	final BusinessObjectNode n2 = (BusinessObjectNode)e2;
			    	return model.getName(n1).compareToIgnoreCase(model.getName(n2));	
		    	}
		    });	    

		    // AADL Properties Widgets
		    final Label aadlPropertiesLabel = new Label(container, SWT.NONE);
		    aadlPropertiesLabel.setText("AADL Properties:");
		    aadlPropertiesLabel.setLayoutData(GridDataFactory.swtDefaults().span(2, 1).create());
		    
		    final ListViewer enabledAadlPropertiesViewer = new ListViewer(container);
		    enabledAadlPropertiesViewer.getList().setLayoutData(GridDataFactory.fillDefaults().grab(true, false).hint(SWT.DEFAULT, 100).create());
		    enabledAadlPropertiesViewer.setContentProvider(new IStructuredContentProvider() { // Content provider uses a DiagramConfigurationBuilder as input			
				@Override
				public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
				}
				
				@Override
				public void dispose() {
				}
				
				@Override
				public Object[] getElements(final Object inputElement) {
					return ((DiagramConfigurationBuilder)inputElement).getEnabledAadlPropertiesLowercase().toArray();
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
					diagramConfigBuilder.addAadlProperty((String)e.widget.getData());
					enabledAadlPropertiesViewer.refresh();
				}
			};
			
			// Create a Menu Listener for the property set menus
			final MenuListener propertySetMenuListener = new MenuAdapter() {
				@Override
				public void menuShown(final MenuEvent e) {
					// Remove old menu items
					final Menu menu = (Menu)e.widget;
					for(final MenuItem item : menu.getItems()) {
						item.dispose();
					}
					
					final String propertySetName = (String)menu.getData();					
					
					// Create new menu items
					final Collection<String> propertySetProperties = aadlPropertySetToPropertiesMap.get(e.widget.getData());
					if(propertySetProperties != null) {
						for(final String propertyName : (Iterable<String>)propertySetProperties.stream().sorted()::iterator) {					
							final MenuItem propertyMenuItem = new MenuItem(menu, SWT.NONE);
							propertyMenuItem.setText(propertyName);
							final String qualifiedPropertyName = propertySetName + "::" + propertyName;
							propertyMenuItem.setData(qualifiedPropertyName);
							propertyMenuItem.addSelectionListener(propertyMenuItemSelectionListener);
							
							// Set enabled based on whether it is already in the list
							propertyMenuItem.setEnabled(!diagramConfigBuilder.getEnabledAadlPropertiesLowercase().contains(qualifiedPropertyName.toLowerCase()));
						}
					}
				}
			};
			
			// Sort properties and create menu items	
			for(String propertySetName : (Iterable<String>)aadlPropertySetToPropertiesMap.keySet().stream().sorted()::iterator) {
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
					if(enabledAadlPropertiesViewer.getSelection() instanceof StructuredSelection && !enabledAadlPropertiesViewer.getSelection().isEmpty()) {
						final String qualifiedPropertyName = (String)((StructuredSelection)enabledAadlPropertiesViewer.getSelection()).getFirstElement();
						diagramConfigBuilder.removeAadlProperty(qualifiedPropertyName);
						enabledAadlPropertiesViewer.refresh();
					}
				}		    	
		    });
		    		    
		    // Disable remove button whenever item isn't selected.
		    removePropertyBtn.setEnabled(false);
		    enabledAadlPropertiesViewer.addSelectionChangedListener(new ISelectionChangedListener() {
				@Override
				public void selectionChanged(final SelectionChangedEvent event) {
					removePropertyBtn.setEnabled(!event.getSelection().isEmpty());
				}		    	
		    });
		    
		    // Set the input for the tree
		    treeViewer.setInput(businessObjectTree);
		    
		    // Expand the root element
		    treeViewer.expandToLevel(2);
		    
		    // Set the initial selection
		    if(initialSelectionBoPath != null) {
		    	setSelection(initialSelectionBoPath);
		    }
		    
		    return area;
		}
		
		private void setBranchIsManual(final BusinessObjectNode node, final boolean value) {
			node.setManual(value);
			for(final BusinessObjectNode child : node.getChildren()) {
				setBranchIsManual(child, value);
			}
		}
		
		/**
		 * Update all elements in the tree. Updating elements does not handle structural changes so it is much faster than refreshing.
		 */
		private void updateTree() {
			treeViewer.update(getVisibleElements(), null);		
		}
		
		private void setSelection(final Object[] boPath) {
			// The tree is populated lazily so we need to reveal each level to ensure that the desired node exists.
		    BusinessObjectNode tmpNode = businessObjectTree;
		    for(final Object bo : boPath) {
		    	final RelativeBusinessObjectReference relRef = model.getRelativeBusinessObjectReference(bo);
		    	final BusinessObjectNode newNode = relRef == null ? null : tmpNode.getChild(relRef);
		    	if(newNode == null) {
		    		break;
		    	} else {
		    		tmpNode = newNode;
		    		treeViewer.expandToLevel(tmpNode, 1);
		    	}
		    }
		    
		    if(tmpNode != businessObjectTree) {
		    	treeViewer.setSelection(new StructuredSelection(tmpNode), true);
		    }		    
		}
		
		
		private Object[] getVisibleElements(){
			final ArrayList<Object> elements = new ArrayList<>();
			getVisibleElements(treeViewer.getTree().getItems(), elements);
			return elements.toArray();
		}
		
		private void getVisibleElements(final TreeItem[] items, final Collection<Object> elements){
			for(final TreeItem treeItem : items) {
				final Object element = treeItem.getData();
				if(element != null) {
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
	
	private class AutoContentsFilterEditingSupport extends EditingSupport {
		private final ComboBoxViewerCellEditor cellEditor;
		
		public AutoContentsFilterEditingSupport(final TreeViewer viewer) {
			super(viewer);
			this.cellEditor = new ComboBoxViewerCellEditor(viewer.getTree(), SWT.READ_ONLY);
			cellEditor.setContentProvider(new ArrayContentProvider());
			cellEditor.setInput(model.getContentsFilters());
			cellEditor.setLabelProvider(new LabelProvider() {		    	
				@Override
				public String getText(final Object o) {
					final ContentsFilter filter = (ContentsFilter)o;
					return filter == null ? "" : filter.description();
				}
		    });
		}

		@Override
		protected CellEditor getCellEditor(final Object element) {
			return cellEditor;
		}

		@Override
		protected boolean canEdit(final Object element) {
			return isAutoContentsFilterEditable((BusinessObjectNode)element);
		}

		@Override
		protected Object getValue(final Object element) {
			return ((BusinessObjectNode)element).getAutoContentsFilter();
		}

		@Override
		protected void setValue(final Object element, final Object value) {
			// Set the value
			final BusinessObjectNode node = (BusinessObjectNode)element;
			node.setAutoContentsFilter((ContentsFilter)value);
			dlg.updateTree();
		}		
	}
	
	private class BusinessObjectTreeContentProvider implements ITreeContentProvider {
		private final Set<BusinessObjectNode> populatedNodes = new HashSet<>(); // Set of nodes which have had their children populated with nodes for potential business objects
		
		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		}

		@Override
		public Object[] getElements(final Object inputElement) {
			final BusinessObjectNode node = (BusinessObjectNode)inputElement;
			if(node == null) {
				return new Object[0];
			}

			return getChildren(inputElement);
		}

		@Override
		public Object[] getChildren(final Object parentElement) {
			final BusinessObjectNode node = (BusinessObjectNode)parentElement;
			return node.getChildren().stream().filter(n -> model.showBusinessObject(n.getBusinessObject())).toArray();
		}

		@Override
		public Object getParent(final Object element) {
			final BusinessObjectNode node = (BusinessObjectNode)element;
			return node.getParent();
		}

		@Override
		public boolean hasChildren(final Object element) {
			final BusinessObjectNode node = (BusinessObjectNode)element;
			if(!populatedNodes.contains(node)) {
				// Create new business object nodes as needed
				for(final Object childBo : model.getChildBusinessObjects(node)) {
					final RelativeBusinessObjectReference childRef = model.getRelativeBusinessObjectReference(childBo);
					// Create a child node if it doesn't exist
					if(node.getChild(childRef) == null) {
						new BusinessObjectNode(node, childRef, childBo, false, model.getDefaultContentsFilter(childBo), Completeness.UNKNOWN);
					}
				}
				populatedNodes.add(node);
			}
			
			return getChildren(node).length != 0;
		}
	}
	
	private final Model model;
	private final InnerDialog dlg;
	private final DiagramConfigurationBuilder diagramConfigBuilder;
	private final BusinessObjectNode businessObjectTree;
	private final Object[] initialSelectionBoPath;

	protected DiagramConfigurationDialog(final Shell parentShell, 
			final Model model, 
			final DiagramConfiguration diagramConfig, 
			final BusinessObjectNode businessObjectTree,
			final Object[] initialSelectionBoPath) {
		this.model = Objects.requireNonNull(model);
		this.dlg = new InnerDialog(parentShell);
		this.diagramConfigBuilder = new DiagramConfigurationBuilder(Objects.requireNonNull(diagramConfig, "diagramConfig must not be null"));
		this.businessObjectTree = Objects.requireNonNull(businessObjectTree, "businessObjectTree must not be null").copy();
		this.initialSelectionBoPath = initialSelectionBoPath;
	}
	
	/**
	 * A null return value indicates that the dialog was canceled.
	 * @return
	 */
	private Result open() {
		return dlg.open() == Dialog.OK ? new Result(diagramConfigBuilder.build(), businessObjectTree) : null;		
	}
	
	// Returns whether the node is either manually or automatically enabled
	private boolean isEnabled(final BusinessObjectNode node) {
		return getEnabledState(node) != EnabledState.NOT_ENABLED;
	}
	
	private EnabledState getEnabledState(final BusinessObjectNode node) {
		if(node.isManual()) {
			return EnabledState.MANUALLY_ENABLED;
		} else if(node.getParent() != null && 
				isEnabled(node.getParent())) {
			final BusinessObjectNode parentNode = node.getParent();
			
			ContentsFilter parentActualContentFilter = parentNode.getAutoContentsFilter() == null ? model.getDefaultContentsFilter(parentNode.getBusinessObject()) : parentNode.getAutoContentsFilter();
			if(parentActualContentFilter.test(node.getBusinessObject()) ||
					BusinessObjectNode.hasManualDescendant(node)) {
				return EnabledState.IMPLICITLY_ENABLED;
			}
		}
		
		// Implicitly enabled because it is a top level node in a diagram with a context. In such diagrams, the root nodes are automatically added.
		if(diagramConfigBuilder.getContextBoReference() != null && node.getParent() != null && node.getParent().getParent() == null) {
			return EnabledState.IMPLICITLY_ENABLED;
		}
		
		return EnabledState.NOT_ENABLED;
	}
	
	// Only allow editing the auto contents filter if the node is a manual node.
	private static boolean isAutoContentsFilterEditable(final BusinessObjectNode node) {
		return node.isManual();
	}
	
	/**
	 * A null return value indicates that the dialog was canceled.
	 * @param initialSelectionBoPath is an array of business objects which form a path to the node that should be selected. May be null
	 * @return
	 */
	public static Result show(final Shell parentShell, 
			final Model model, 
			final DiagramConfiguration diagramConfig, 
			final BusinessObjectNode businessObjectTree,
			final Object[] initialSelectionBoPath) {
		final DiagramConfigurationDialog dlg = new DiagramConfigurationDialog(parentShell, model, diagramConfig, businessObjectTree, initialSelectionBoPath);
		return dlg.open();
	}

	enum TestContentsFilter implements ContentsFilter {
		FILTER1,
		FILTER2,
		NO_C1;

		@Override
		public String id() {
			return this.toString();
		}
		
		@Override
		public String description() {
			return this.toString() + " Desc";
		}		

		@Override
		public boolean test(final Object t) {
			if(this == NO_C1 && t.equals("C1")) {
				return false;
			}
			
			return true;
		}

	}
	
	public static void main (String [] args) {
		final Model model = new Model() {			
			@Override
			public RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
				return new RelativeBusinessObjectReference(bo.toString());
			}
			
			@Override
			public Collection<Object> getChildBusinessObjects(final BusinessObjectContext boc) {
				final Collection<Object> children = new ArrayList<>();
				for(int i = 1; i <= 100; i++) {
					children.add("C" + i);	
				}
				return children;
			}
			
			@Override
			public String getName(final BusinessObjectContext boc) {
				return boc.getBusinessObject().toString();
			}

			@Override
			public Collection<ContentsFilter> getContentsFilters() {
				return Arrays.asList(TestContentsFilter.values());
			}
			
			@Override
			public ContentsFilter getDefaultContentsFilter(final Object bo) {
				return TestContentsFilter.FILTER1;
			}
			
			@Override
			public Map<String, Collection<String>> getAadlProperties() {
				final Map<String, Collection<String>> result = new HashMap<>();
				result.put("test_ps1", Arrays.asList(new String[] { "a", "c", "b"}));
				result.put("test_ps2", Arrays.asList(new String[] { "a", "b", "c"}));
				result.put("test_ps3", Arrays.asList(new String[] { "d", "f", "e"}));
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
			public boolean showBusinessObject(final Object bo) {
				return !bo.equals("C3");
			}
			
			@Override 
			public Image getImage(final Object bo) {
				return null;
			}
		};
		
		final DiagramConfiguration diagramConfig = new DiagramConfigurationBuilder().
				setContextBoReference(new CanonicalBusinessObjectReference("test")).
				addAadlProperty("test::prop1").
				addAadlProperty("test_ps2::b").
				build();

		// Create a test business object tree
	    final BusinessObjectNode rootNode = new BusinessObjectNode(null, null, null, false, null, Completeness.UNKNOWN);
	    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("A"), "A", false, null, Completeness.UNKNOWN);
	    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("B"), "B", true, null, Completeness.UNKNOWN);
	    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("C"), "C", true, null, Completeness.UNKNOWN);
	    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("D"), "D", true, null, Completeness.UNKNOWN);	    
		
	    // Show the dialog
		final Result result = DiagramConfigurationDialog.show(null, model, diagramConfig, rootNode, new Object[] { "A", "C1", "C2", "C4"});
		if(result == null) {
			System.out.println("Dialog was canceled.");
		} else {
			System.out.println(result.getDiagramConfiguration());
			System.out.println(result.getBusinessObjectTree());
		}
	}
}
