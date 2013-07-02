package edu.uah.rsesc.aadl.age.editor;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.internal.editor.DomainModelChangeListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

import edu.uah.rsesc.aadl.age.diagram.PackageFeatureProvider;
import edu.uah.rsesc.aadl.age.xtext.AgeXtextUtil;
import edu.uah.rsesc.aadl.age.xtext.ModelChangeListener;

public class AgeDiagramEditor extends DiagramEditor {
	public static final String DIAGRAM_EDITOR_ID = "edu.uah.rsesc.aadl.age.editor.AgeDiagramEditor";
	public static final String EXTENSION = ".aadl_diagram";
	
	private ModelChangeListener modelListener = new ModelChangeListener() {
		@Override
		public void modelChanged() {
			// TODO: Check which resource changed.
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// TODO: Fix cast
				//	((PackageFeatureProvider)getDiagramTypeProvider().getFeatureProvider()).setDomainResourceSet(resource.getResourceSet());
			
					
					// Update the entire diagram
					// TODO: See if this calls the classifiers update or just the diagram one.. May need to pass lots of items to the update?
					getDiagramTypeProvider().getNotificationService().updatePictogramElements(new PictogramElement[] { getDiagramTypeProvider().getDiagram() });
				}

			});
			
		}
		
	};
	
	public AgeDiagramEditor() {
	}
	
	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new AgeUpdateBehavior(this);
	}
	
	@Override
	protected void registerBusinessObjectsListener() {
		AgeXtextUtil.addModelListener(modelListener);
	//	domainModelListener = new DomainModelChangeListener(this);
//		TransactionalEditingDomain eDomain = getEditingDomain();
		//eDomain.addResourceSetListener(domainModelListener);
	}
	
	@Override
	protected void unregisterDiagramResourceSetListener() {
		AgeXtextUtil.removeModelListener(modelListener);
	}
	
	
}
