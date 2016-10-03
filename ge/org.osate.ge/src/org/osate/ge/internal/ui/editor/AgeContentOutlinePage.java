package org.osate.ge.internal.ui.editor;

import java.util.Objects;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.ge.internal.query.PictogramQuery;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.RootPictogramQuery;
import org.osate.ge.internal.services.BusinessObjectResolutionService;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.PropertyService;
import org.osate.ge.internal.services.InternalReferenceBuilderService;

// TODO: Labels
// TODO: Selections
// TODO: Context menu
// TODO: Overall container for package diagrams
public class AgeContentOutlinePage extends ContentOutlinePage {
	private AgeDiagramEditor editor;
	private QueryRunner queryRunner;
	private PictogramElement rootPictogramElement;
	private final PictogramQuery<Object> rootPictogramQuery = new RootPictogramQuery(() -> this.rootPictogramElement);
	private final PictogramQuery<Object> parentQuery = rootPictogramQuery.ancestor(1);
	private final PictogramQuery<Object> childrenQuery = rootPictogramQuery.children();
	private final BusinessObjectResolutionService bor;
	
	public AgeContentOutlinePage(final AgeDiagramEditor editor) {
		this.editor = Objects.requireNonNull(editor, "editor must not be null");
		this.bor = (BusinessObjectResolutionService)editor.getAdapter(BusinessObjectResolutionService.class);
		this.queryRunner = new QueryRunner((PropertyService)editor.getAdapter(PropertyService.class),
				(ConnectionService)editor.getAdapter(ConnectionService.class), 
				bor, 
				(InternalReferenceBuilderService)editor.getAdapter(InternalReferenceBuilderService.class));
	}

	public void createControl(final Composite parent) {
		super.createControl(parent);

		final TreeViewer viewer =  getTreeViewer();
		viewer.setContentProvider(new ITreeContentProvider() {
			@Override
			public void dispose() {
			}

			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			@Override
			public Object[] getElements(final Object inputElement) {
				if(inputElement instanceof AgeDiagramEditor) {
					final AgeDiagramEditor editor = (AgeDiagramEditor)inputElement;
					if(editor.getDiagramTypeProvider() != null) {
						return getChildren(editor.getDiagramTypeProvider().getDiagram());					
					}
				}
				
				return new Object[0];
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				if(parentElement instanceof PictogramElement) {
					rootPictogramElement = (PictogramElement)parentElement;
					return queryRunner.getPictogramElements(childrenQuery, null).toArray();
				}
				
				return new Object[0];
			}

			@Override
			public Object getParent(Object element) {
				if(element instanceof PictogramElement) {
					rootPictogramElement = (PictogramElement)element;
					final Object parent = queryRunner.getFirstResult(parentQuery, null);;
					return parent;
				}
				
				return false;
			}

			@Override
			public boolean hasChildren(final Object element) {
				if(element instanceof PictogramElement) {
					rootPictogramElement = (PictogramElement)element;
					return queryRunner.getFirstResult(childrenQuery, null) != null;
				}
				
				return false;
			}		
		});
		
		// TODO: Get label and icons from the same source that the OSATE text editor?
		viewer.setLabelProvider(new LabelProvider() {
	    	@Override
	    	public String getText(final Object element) {
	    		if(element instanceof PictogramElement) {
		    		final Object bo = bor.getBusinessObjectForPictogramElement((PictogramElement)element);
		    		if(bo instanceof NamedElement) {
		    			final NamedElement ne = (NamedElement)bo;
		    			String label = ne.eClass().getName(); // TODO: Fix
		    			if(ne.getName() != null) {
		    				label += " " + ne.getName();
		    			}
		    			
		    			return label;
		    		}
	    		}
	    		
	    		return "";
	    	}
	    });
	    
		viewer.addSelectionChangedListener(this);
		viewer.setInput(editor);
	}
}
