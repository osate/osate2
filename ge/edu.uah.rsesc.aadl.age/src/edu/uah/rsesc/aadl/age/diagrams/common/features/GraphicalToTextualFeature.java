package edu.uah.rsesc.aadl.age.diagrams.common.features;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;

public class GraphicalToTextualFeature extends AbstractCustomFeature {
	private final BusinessObjectResolutionService bor;		
	@Inject
	public GraphicalToTextualFeature(final IFeatureProvider fp, final BusinessObjectResolutionService bor) {	
		super(fp);
		this.bor = bor;
	}
	@Override
    public String getName() {
        return "Switch to Textual View";
    }
 
    @Override
    public String getDescription() {
        return "View the textual representation of this part";
    }

    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		return bo instanceof NamedElement;
	}
    
    @Override
    public boolean canExecute(ICustomContext context) 
    {   	
    	final ICustomContext customCtx = (ICustomContext)context;
    	PictogramElement[] pes = customCtx.getPictogramElements();
    	
		final PictogramElement pe = pes[0];	
		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
    	 if (pes != null && pes.length == 1 && !(pe instanceof Diagram))
    	 { 
             if(bo instanceof NamedElement) 
             {
                 return true;
        	 }
    	 }
    	 return false;
    }
    
	@Override
	public void execute(ICustomContext context) 
	{	
		final Element bo = (Element)bor.getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
		Resource res = bo.eResource();
		final IResource ires = OsateResourceUtil.convertToIResource(res);
		final IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		
		try
		{
			ICompositeNode node = NodeModelUtils.findActualNodeFor(bo);
			
			int offset = node.getTotalEndOffset();
			int line = node.getTotalEndLine();		
	
			IMarker marker_p;
			marker_p = ires.createMarker(AadlConstants.AADLGOTOMARKER);
			marker_p = ires.createMarker(AadlConstants.AADLGOTOMARKER);
			marker_p.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
			String dest = EcoreUtil.getURI(bo).toString();
			marker_p.setAttribute(IMarker.MESSAGE, "Going to "+ dest);
			marker_p.setAttribute(IMarker.LOCATION, offset);
			marker_p.setAttribute(IMarker.LINE_NUMBER, line);
			marker_p.setAttribute(EValidator.URI_ATTRIBUTE, dest);
			IDE.openEditor(page, marker_p);
			// editor opened --- get rid of goto marker
			ires.deleteMarkers(AadlConstants.AADLGOTOMARKER, false, IResource.DEPTH_ZERO);
		} 
		catch (final CoreException e) 
		{
			//System.err.println("CoreException: " + e.getMessage());
			throw new RuntimeException(e);
		}	
	}
}