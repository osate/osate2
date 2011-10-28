package org.osate.aadl2.modelsupport.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.core.OsateCorePlugin;

import com.google.inject.Injector;
/* Author: Robert Coop
 * Adapted by Peter Feiler
* See: http://coopology.com/2011/06/easily-load-xtext-files-and-objects-in-eclipse-plugin-or-rcp-projects-using-adapters/
*/
@SuppressWarnings("rawtypes")

public class ModelLoadingAdapter  implements IAdapterFactory {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger
        .getLogger(ModelLoadingAdapter.class);
    final private static Injector injector = OsateCorePlugin
        .getDefault().getInjector("org.osate.xtext.aadl2.Aadl2");
 
    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == ModelUnit.class) {
            if (injector==null) {
                log.error("Could not obtain injector for Aadl2");
                return null;
            }
 
            if (adaptableObject instanceof ISelection) {
                final ISelection sel = (ISelection)adaptableObject;
                if (!(sel instanceof IStructuredSelection)) return null;
                final IStructuredSelection selection = (IStructuredSelection) sel;
                if (!(selection.getFirstElement() instanceof IFile))
                    return null;
                adaptableObject = (IFile)selection.getFirstElement();
            }
            if (adaptableObject instanceof IFile) {
                final IFile file = (IFile)adaptableObject;
                if (!(file.getFileExtension().toLowerCase().equals("aadl")||file.getFileExtension().toLowerCase().equals("aadl2"))) return null;
 
                XtextResourceSet resourceSet = (XtextResourceSet) injector
                    .getInstance(XtextResourceSetProvider.class)
                    .get(file.getProject());
                resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
                Resource resource = resourceSet.getResource(URI.createURI(file.getLocationURI().toString()),true);
                ModelUnit model = (ModelUnit) resource.getContents().get(0);
                return model;
            }
        }
 
        return null;
    }
 
    @Override
    public Class[] getAdapterList() {
        return new Class[] { Element.class };
    }
    
    public static XtextResourceSet getResourceSet(){
    	if (injector==null) {
            log.error("Could not obtain injector for Aadl2");
            return null;
        }
        PredeclaredProperties.initPluginContributedAadl();
        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot root = workspace.getRoot();
        IProject project = root.getProject(PredeclaredProperties.PLUGIN_RESOURCES_DIRECTORY_NAME);

        XtextResourceSet resourceSet = (XtextResourceSet) injector
            .getInstance(XtextResourceSetProvider.class)
            .get(project);
        return resourceSet;
   	
    }
}