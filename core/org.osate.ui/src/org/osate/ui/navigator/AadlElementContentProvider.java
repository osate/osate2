package org.osate.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ui.UiUtil;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlElementContentProvider extends AdapterFactoryContentProvider
		implements IResourceChangeListener, IResourceDeltaVisitor {

	private static final Object[] NO_CHILDREN = new Object[0];

	private static ResourceSet resourceSet = new ResourceSetImpl();

	public AadlElementContentProvider() {
		super(UiUtil.getAdapterFactory());
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			String path = ((IFile) parentElement).getFullPath().toString();
			URI uri = URI.createPlatformResourceURI(path, true);
			parentElement = resourceSet.getResource(uri, true);
		} else if (parentElement instanceof ContributedAadlStorage) {
			URI uri = ((ContributedAadlStorage) parentElement).getUri();
			parentElement = resourceSet.getResource(uri, true);
		} else if (parentElement instanceof ComponentImplementation) {
			return ((ComponentImplementation) parentElement).getOwnedAnnexSubclauses().toArray();
		} else if (!shouldExpand(parentElement)) {
			return NO_CHILDREN;
		}

		return super.getChildren(parentElement);
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject) element).eContainer();
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IFile || element instanceof ContributedAadlStorage) {
			return true;
		} else if (element instanceof ComponentImplementation) {
			return !((ComponentImplementation) element).getOwnedAnnexSubclauses().isEmpty();
		} else if (!shouldExpand(element)) {
			return false;
		}
		return super.hasChildren(element);
	}

	protected boolean shouldExpand(Object element) {
		return element instanceof AadlPackage || element instanceof PropertySet || element instanceof PackageSection
				|| element instanceof ComponentInstance;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		TreeViewer tv = (TreeViewer) viewer;
		if (tv.getComparer() == null) {
			tv.setComparer(new AadlElementComparer());
		}
		super.inputChanged(viewer, oldInput, newInput);
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			IResourceDelta delta = event.getDelta();
			delta.accept(this);
		} catch (CoreException e) {
			// ignore
		}
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource changedResource = delta.getResource();
		if (changedResource.getType() == IResource.FILE && changedResource.getFileExtension() != null
				&& (changedResource.getFileExtension().equals("aadl")
				|| changedResource.getFileExtension().equals("aaxl2"))) {
			try {
				String path = ((IFile) changedResource).getFullPath().toString();
				URI uri = URI.createPlatformResourceURI(path, true);
				Resource res = resourceSet.getResource(uri, true);
				res.unload();
				res.load(resourceSet.getLoadOptions());
			} catch (Exception e) {
				// ignore
			}
			return false;
		}
		return true;
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}

}
