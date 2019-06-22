package org.osate.aadl2.modelsupport.resources;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;

/* Author: Robert Coop
 * Adapted by Peter Feiler
 * Usage:	ModelUnit target = (ModelUnit)Platform.getAdapterManager().getAdapter(f, ModelUnit.class);
 * See: http://coopology.com/2011/06/easily-load-xtext-files-and-objects-in-eclipse-plugin-or-rcp-projects-using-adapters/
 */
@SuppressWarnings("rawtypes")
public class ModelLoadingAdapter implements IAdapterFactory {

	/**
	 * XXX: Notice - the methods dealing with EMF Index operations has been moved to the EMFIndexRetrieval Class in org.osate.xtext.aadl2.properties.util
	 */
	/*
	 * * Usage: ModelUnit target = (ModelUnit)Platform.getAdapterManager().getAdapter(f, ModelUnit.class);
	 */
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adapterType == ModelUnit.class || adapterType == Element.class || adapterType == InstanceObject.class
				|| adapterType == SystemInstance.class) {

			if (adaptableObject instanceof ISelection) {
				final ISelection sel = (ISelection) adaptableObject;
				if (!(sel instanceof IStructuredSelection)) {
					return null;
				}
				final IStructuredSelection selection = (IStructuredSelection) sel;
				if (!(selection.getFirstElement() instanceof IFile)) {
					return null;
				}
				adaptableObject = selection.getFirstElement();
			}
			if (adaptableObject instanceof IFile) {
				final IFile file = (IFile) adaptableObject;
				String ext = file.getFileExtension();
				if (ext == null) {
					return null;
				}
				if (ext.toLowerCase().equals("aadl") || ext.toLowerCase().equals("aadl2")) {
					ModelUnit model;
					ResourceSet resourceSet = new ResourceSetImpl();
					String sp = file.getFullPath().toString();
					Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(sp, false), true);
					if (!resource.getContents().isEmpty()) {
						model = (ModelUnit) resource.getContents().get(0);
					} else {
						model = null;
					}
					return model;
				} else if (ext.toLowerCase().equals("aaxl2")) {
					SystemInstance model;
					ResourceSet resourceSet = new ResourceSetImpl();
					String sp = file.getFullPath().toString();
					Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(sp, false), true);

					if (!resource.getContents().isEmpty()) {
						model = (SystemInstance) resource.getContents().get(0);
					} else {
						model = null;
					}
					return model;
				}

			}
		}

		return null;
	}

	@Override
	public Class[] getAdapterList() {
		return new Class[] { Element.class };
	}

}