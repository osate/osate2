package edu.uah.rsesc.aadl.age.diagrams.common.features;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

import javax.inject.Inject;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
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

	//TODO make work for any Named element
	//TODO use/justify not using ModeModelUtils.findActualNodeFor 
	//TODO handle exceptions
	//TODO fix null pointer (GraphicalToTextualFeature.java:104)    
    
    @Override
	public boolean isAvailable(final IContext context) {
		final ICustomContext customCtx = (ICustomContext)context;
		PictogramElement[] pes = customCtx.getPictogramElements();
		
		if(customCtx.getPictogramElements().length < 1) {
			return false;
		}
		final PictogramElement pe = pes[0];	
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
		
		return bo instanceof ComponentType || bo instanceof ComponentImplementation || bo instanceof FeatureGroupType;
	}
    
    @Override
    public boolean canExecute(ICustomContext context) {   	
    	final ICustomContext customCtx = (ICustomContext)context;
    	PictogramElement[] pes = customCtx.getPictogramElements();
    	
		final PictogramElement pe = pes[0];	
		
		final Object bo = bor.getBusinessObjectForPictogramElement(pe);
    	 if (pes != null && pes.length == 1 && !(pe instanceof Diagram)) { 
             if(bo instanceof Package || bo instanceof Classifier) {
                 return true;
        	 }
    	 }
    	 return false;
    }
    
	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();	
		int linenumber = 1;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();	
		
		if(context.getPictogramElements().length > 0){
			Object bo = AadlElementWrapper.unwrap(getBusinessObjectForPictogramElement(pes[0]));
			String elementName = ((NamedElement)bo).getName();
			
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();	
			
			String digramfile = page.getActiveEditor().getEditorInput().getName();

			int i = digramfile.indexOf("_diagram");
			int j = digramfile.indexOf("/resource") + 9;
			
			String packagefile = digramfile.substring(j, i);
			
			packagefile = packagefile.replaceFirst("diagrams", "packages");
			
			IResource resource = root.findMember(packagefile, false);

			IPath location = resource.getLocation();

			IFile textRepresnetation = workspace.getRoot().getFileForLocation(location);

			if (textRepresnetation.exists())
			{
				Scanner sc = null;
				try {
					sc = new Scanner(new File(textRepresnetation.getRawLocationURI()));
				} catch (FileNotFoundException e1) {
					// TODO Error:File not found
					e1.printStackTrace();
				}
				if (sc != null)
				{
					String currentLine = null;
					linenumber = 1;
					while (sc.hasNextLine())
					{
						currentLine = sc.nextLine();
						if (currentLine.contains(elementName))
						{
							break;
						}
						linenumber++;
					}
									
					if (currentLine != null)
					{
						HashMap<String, Object> map = new HashMap<String, Object>();
						map.put(IMarker.LINE_NUMBER, linenumber);
						IMarker marker = null;
						try{
							marker = textRepresnetation.createMarker(IMarker.TEXT);
					        marker.setAttributes(map);
					        try {
								IDE.gotoMarker(IDE.openEditor(page, (IFile) textRepresnetation, true, false), marker);
							} catch (PartInitException e) {
								// TODO Error Message:Editor Open
								e.printStackTrace();
							}
						} catch (CoreException e1) {
							// TODO Error Message:Marker
							e1.printStackTrace();
						}
						finally{
							try {
					            if (marker != null)
					                marker.delete();
					        } catch ( CoreException e ) {
					        	// TODO Error Message:Marker Delete
					        }
						}
					}
				}
			}				
		}
	}	
}  

