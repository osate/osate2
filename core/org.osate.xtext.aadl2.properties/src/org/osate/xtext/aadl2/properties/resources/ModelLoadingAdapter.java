package org.osate.xtext.aadl2.properties.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.Property;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.core.OsateCorePlugin;
import com.google.inject.Inject;
import com.google.inject.Injector;
/* Author: Robert Coop
 * Adapted by Peter Feiler
* Usage:	ModelUnit target = (ModelUnit)Platform.getAdapterManager().getAdapter(f, ModelUnit.class);
* See: http://coopology.com/2011/06/easily-load-xtext-files-and-objects-in-eclipse-plugin-or-rcp-projects-using-adapters/
*/
@SuppressWarnings("rawtypes")

public class ModelLoadingAdapter  implements IAdapterFactory {
    
    /**
     * XXX: Notice - the methods dealing with EMF Index operations has been moved to the EMFIndexLookup Class in org.osate.xtext.aadl2.properties.util
     */
/*
 * * Usage:	ModelUnit target = (ModelUnit)Platform.getAdapterManager().getAdapter(f, ModelUnit.class);
 */
    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
        if (adapterType == ModelUnit.class || adapterType == Element.class) {
 
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
                String ext = file.getFileExtension();
                if (ext == null || !(ext.toLowerCase().equals("aadl")||ext.toLowerCase().equals("aadl2"))) return null;
 
                XtextResourceSet resourceSet = OsateResourceUtil.getResourceSet();
                String sp = file.getFullPath().toString();
                Resource resource = resourceSet.getResource(URI.createURI(sp),true);
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
    
    

}