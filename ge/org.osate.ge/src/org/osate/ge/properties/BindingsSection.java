package org.osate.ge.properties;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeNodeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.osate.ge.services.PropertyService;
import org.osate.ge.services.PropertyService.BindingType;
import org.osate.ge.ui.editor.AgeDiagramEditor;

/**
 * Property section for setting whether particular binding types are shown in the diagram.
 * @author philip.alldredge
 *
 */
public class BindingsSection extends GFPropertySection implements ITabbedPropertyConstants {
	private Tree tree; 
	private CheckboxTreeViewer treeViewer;

    @Override
    public void createControls(Composite parent,
        TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
 
        final TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        factory.setBorderStyle(SWT.NO_SCROLL);
        final Composite composite = factory.createFlatFormComposite(parent);
        
        FormData data;
        tree = factory.createTree(composite, SWT.MULTI | SWT.CHECK);
        treeViewer = new CheckboxTreeViewer(tree);
        treeViewer.setContentProvider(new TreeNodeContentProvider());
        
        final TreeNode[] treeNodes = new TreeNode[2];
        treeNodes[0] = new TreeNode("Actual");
        createChildren(treeNodes[0], new BindingTypeNodeData("Connection", BindingType.ACTUAL_CONNECTION), new BindingTypeNodeData("Function", BindingType.ACTUAL_FUNCTION), new BindingTypeNodeData("Memory", BindingType.ACTUAL_MEMORY), new BindingTypeNodeData("Processor", BindingType.ACTUAL_PROCESSOR));     
        treeNodes[1] = new TreeNode("Allowed");        
        createChildren(treeNodes[1], new BindingTypeNodeData("Connection", BindingType.ALLOWED_CONNECTION), new BindingTypeNodeData("Memory", BindingType.ALLOWED_MEMORY), new BindingTypeNodeData("Processor", BindingType.ALLOWED_PROCESSOR));
        treeViewer.setAutoExpandLevel(TreeViewer.ALL_LEVELS);
        treeViewer.setInput(treeNodes);
        
        // Add a check state listener for adjusting the check status of parents and children as appropriate and updating property values when selections are made and 
        treeViewer.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(final CheckStateChangedEvent event) {
				final TreeNode treeNode = (TreeNode)event.getElement();			
				final TreeNode parent = treeNode.getParent();
				final PropertyService propertyService = getPropertyService();
				
				final AgeDiagramEditor editor = (AgeDiagramEditor)getPart();
				
				editor.getEditingDomain().getCommandStack().execute(new RecordingCommand(editor.getEditingDomain(), "Set Binding Visibility") {
					@Override
					protected void doExecute() {
						if(parent == null) {
							treeViewer.setGrayed(treeNode, false);
							final boolean checked = event.getChecked();
							for(final TreeNode child : treeNode.getChildren()) {
								if(checked != treeViewer.getChecked(child)) {
									treeViewer.setChecked(child, checked);
									
									// Apply the setting
									updatePropertyValue(child, propertyService);
								}							
							}
						} else {
							// Apply the setting
							updatePropertyValue(treeNode, propertyService);					
							updateContainerTreeNodeState(parent);
						}
						
						// Update the visibility of the connection and connection decorators
						updateBindingVisibility();
					}				
				});
			}        	
        });
        
        treeViewer.setLabelProvider(new LabelProvider() {
        	public String getText(final Object element) {
        		final TreeNode node = (TreeNode)element;
        		final Object value = node.getValue();
        		if(value instanceof BindingTypeNodeData) {
        			return ((BindingTypeNodeData) value).label;
        		} else {
        			return node.getValue().toString();
        		}
        	}
        });

        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        tree.setLayoutData(data);
 
        final CLabel showLabel = factory.createCLabel(composite,  "Show:");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(tree, -HSPACE);
        data.top = new FormAttachment(tree, 0, SWT.CENTER);
        showLabel.setLayoutData(data);
    }
 
    /** 
     * Updates the diagram's binding connection visibility to reflect the current property values. Must be called within a command.
     */
    private void updateBindingVisibility() {
    	final Diagram diagram = getDiagram();
		final PropertyService propertyService = getPropertyService();
		for(final Connection connection : getDiagram().getConnections()) {
			final BindingType bindingType = propertyService.getBindingType(connection);
			if(bindingType != null) {
				final boolean showBindingType = propertyService.getShowConnectionBindingType(diagram, bindingType);
				if(showBindingType != connection.isVisible()) {
					connection.setVisible(showBindingType); 
					for(final ConnectionDecorator cd : connection.getConnectionDecorators()) {
						cd.setVisible(showBindingType);
					}
				}
			}
		}
    }
    
    /**
     * Updates the checked and grayed states of a container tree node
     * @param container a tree node that contains children
     */
    private void updateContainerTreeNodeState(final TreeNode container) {
    	// Update checked/gray state of the parent node
		boolean grayParent = false;
		boolean checkParent = false;
		for(final TreeNode sibling : container.getChildren()) {
			if(treeViewer.getChecked(sibling)) {
				checkParent = true;
			} else {
				grayParent = true;
			}
		}

		treeViewer.setChecked(container, checkParent);
		treeViewer.setGrayed(container, grayParent);
    }
    
    private void createChildren(final TreeNode node, BindingTypeNodeData ... properties) {
    	final TreeNode[] children = new TreeNode[properties.length];
    	for(int i = 0; i < properties.length; i++) {
    		children[i] = new TreeNode(properties[i]);
    		children[i].setParent(node);;
    	}
    	node.setChildren(children);
    }
    
    private void updatePropertyValue(final TreeNode bindingTypeNode, final PropertyService propertyService) {
    	final BindingTypeNodeData bindingType = (BindingTypeNodeData)bindingTypeNode.getValue();
    	final boolean showBindingType = treeViewer.getChecked(bindingTypeNode);
    	propertyService.setShowConnectionBindingType(getDiagram(), bindingType.bindingType, showBindingType);
    }
    
    @Override
    public void refresh() {
    	final PictogramElement pe = getSelectedPictogramElement();
    	final PropertyService propertyService = getPropertyService();
    	if(pe instanceof Diagram && propertyService != null) {
    		final Diagram diagram = (Diagram)pe;
	    	for(final TreeNode tn : (TreeNode[])treeViewer.getInput()) {
	    		for(final TreeNode bindingTreeNode : tn.getChildren()) {
	    			final BindingTypeNodeData bindingType = (BindingTypeNodeData)bindingTreeNode.getValue();
	    			boolean showBindingType = propertyService.getShowConnectionBindingType(diagram, bindingType.bindingType);
	    			treeViewer.setChecked(bindingTreeNode, showBindingType);					
	    		}
	    		
	    		updateContainerTreeNodeState(tn);
	    	}
    	}
    }
    
    private PropertyService getPropertyService() {
    	return (PropertyService) getPart().getAdapter(PropertyService.class);
    }
    
    private static class BindingTypeNodeData {
    	public final String label;
    	public final PropertyService.BindingType bindingType;
    	
    	/**
    	 * 
    	 * @param label
    	 * @param key is the binding type name as accepted by the property service.
    	 */
    	public BindingTypeNodeData(final String label, final PropertyService.BindingType bindingType) {
    		this.label = label;
    		this.bindingType = bindingType;
    	}
    }
}
