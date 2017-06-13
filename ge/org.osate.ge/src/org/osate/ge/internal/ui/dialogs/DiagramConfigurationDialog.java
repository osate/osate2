package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.osate.ge.internal.diagram.ContentsFilter;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.boTree.Completeness;

public class DiagramConfigurationDialog {
	interface Model {
		Collection<Object> getPotentialChildBusinessObjects(final Object bo); // TODO: Rename?
		RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo);
		String getName(final Object bo);
	}	
	
	private class InnerDialog extends TitleAreaDialog { // TODO: Just use regular Dialog?
		private CheckboxTreeViewer treeViewer;
		
		public InnerDialog(final Shell parentShell) {
			super(parentShell);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}
		
		@Override
		protected void configureShell(final Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("Configure Diagram");
			newShell.setMinimumSize(250, 140);
			newShell.setSize(500, 500);
		}
		
		@Override
	  	protected Control createDialogArea(final Composite parent) {
		    final Composite area = (Composite)super.createDialogArea(parent);
		 
		    final Composite container = new Composite(area, SWT.NONE);
		    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		    container.setLayout(GridLayoutFactory.fillDefaults().create());
		    
		    treeViewer = new CheckboxTreeViewer(container, SWT.FULL_SELECTION);

		    // Update item when checked
		    treeViewer.addCheckStateListener(new ICheckStateListener() {
				@Override
				public void checkStateChanged(final CheckStateChangedEvent event) {
					// Set is manual
					final BusinessObjectNode node = (BusinessObjectNode)event.getElement();
					node.setManual(event.getChecked());
					
					// Refresh
					treeViewer.refresh(node);
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
					return node.isManual();			
				}
			});
		    
		    // TODO: Configure... 
		    // TODO: Autosize columns
		    final TreeViewerColumn nameColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		    nameColumn.getColumn().setWidth(300);
		    nameColumn.getColumn().setText("Name");
		    nameColumn.setLabelProvider(new CellLabelProvider() {
				@Override
				public void update(final ViewerCell cell) {
					final BusinessObjectNode node = (BusinessObjectNode)cell.getElement();
					cell.setText(model.getName(node.getBusinessObject()));
				}
		    });
		    
		    // Dropdown Column for the Auto Contents Filter
		    final TreeViewerColumn autoContentsFilterColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		    autoContentsFilterColumn.getColumn().setWidth(100);
		    autoContentsFilterColumn.getColumn().setText("Auto Contents Filter"); // TODO: Change Label
		    autoContentsFilterColumn.setLabelProvider(new StyledCellLabelProvider(StyledCellLabelProvider.COLORS_ON_SELECTION) {		    	
				@Override
				public void update(final ViewerCell cell) {
					final BusinessObjectNode node = (BusinessObjectNode)cell.getElement();
					cell.setText(node.getAutoContentsFilter().toString());	
					cell.setForeground(Display.getCurrent().getSystemColor(canEditAutoContentsFilter(node) ? SWT.COLOR_LIST_FOREGROUND : SWT.COLOR_GRAY));
				}
		    });

		    autoContentsFilterColumn.setEditingSupport(new AutoContentsFilterEditingSupport(treeViewer));
		    
		    final Tree tree = treeViewer.getTree();
		    tree.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
			tree.setHeaderVisible(true);
			tree.setLinesVisible(true);
		    
			// Set the contents of the tree viewer
		    treeViewer.setContentProvider(new BusinessObjectTreeContentProvider());		    
		    // TODO: Sorting
		    
		    // TODO: Test data
		    final BusinessObjectNode rootNode = new BusinessObjectNode(null, null, null, false, ContentsFilter.DEFAULT, Completeness.UNKNOWN);
		    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("A"), "A", true, ContentsFilter.DEFAULT, Completeness.UNKNOWN);
		    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("B"), "B", true, ContentsFilter.DEFAULT, Completeness.UNKNOWN);
		    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("C"), "C", true, ContentsFilter.DEFAULT, Completeness.UNKNOWN);
		    new BusinessObjectNode(rootNode, new RelativeBusinessObjectReference("D"), "D", true, ContentsFilter.DEFAULT, Completeness.UNKNOWN);
		    
		    treeViewer.setInput(rootNode); // TODO

		    return area;
		}
		
		private void refresh(final Object element) {
			treeViewer.refresh(element);
		}
	}

	private boolean canEditAutoContentsFilter(final Object element) {
		return dlg.treeViewer.getChecked(element);
	}
	
	private class AutoContentsFilterEditingSupport extends EditingSupport {
		private final ComboBoxViewerCellEditor cellEditor;
		
		// TODO: Set value immediately?
				
		public AutoContentsFilterEditingSupport(final TreeViewer viewer) {
			super(viewer);
			this.cellEditor = new ComboBoxViewerCellEditor(viewer.getTree(), SWT.READ_ONLY);
			cellEditor.setContentProvider(new ArrayContentProvider());
			cellEditor.setInput(ContentsFilter.values());
			
			// TODO: Create a label provider to allow for specialized labels for contents filter options
		}

		@Override
		protected CellEditor getCellEditor(final Object element) {
			return cellEditor;
		}

		@Override
		protected boolean canEdit(final Object element) {
			return canEditAutoContentsFilter(element);
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
			dlg.refresh(element);
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

			return ((BusinessObjectNode)inputElement).getChildren().toArray();
		}

		@Override
		public Object[] getChildren(final Object parentElement) {
			final BusinessObjectNode node = (BusinessObjectNode)parentElement;
			return node.getChildren().toArray();
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
				for(final Object childBo : model.getPotentialChildBusinessObjects(node.getBusinessObject())) {
					final RelativeBusinessObjectReference childRef = model.getRelativeBusinessObjectReference(childBo);
					// Create a child node if it doesn't exist
					if(node.getChild(childRef) == null) {
						new BusinessObjectNode(node, childRef, childBo, false, ContentsFilter.DEFAULT, Completeness.UNKNOWN);
					}
				}
				populatedNodes.add(node);
			}
			
			return node.getChildren().size() != 0;
		}
	}
	
	private final Model model;
	private final InnerDialog dlg;
	
	protected DiagramConfigurationDialog(final Shell parentShell, final Model model) {
		this.model = Objects.requireNonNull(model);
		this.dlg = new InnerDialog(parentShell);
	}
	
	private void open() {
		// TODO: Return value
		/* == Dialog.OK*/
		dlg.open();
	}
	
	public static void show(final Shell parentShell, final Model model) {
		// TODO: Return value
		final DiagramConfigurationDialog dlg = new DiagramConfigurationDialog(parentShell, model);
		/*return */dlg.open();
	}
	
	public static void main (String [] args) {
		DiagramConfigurationDialog.show(null, new Model() {			
			@Override
			public RelativeBusinessObjectReference getRelativeBusinessObjectReference(final Object bo) {
				return new RelativeBusinessObjectReference(bo.toString());
			}
			
			@Override
			public Collection<Object> getPotentialChildBusinessObjects(final Object bo) {
				final Collection<Object> children = new ArrayList<>();
				children.add("C1");
				children.add("C2");
				children.add("C3");
				children.add("C4");
				return children;
			}
			
			@Override
			public String getName(final Object bo) {
				return bo.toString();
			}
		});
	}
}
