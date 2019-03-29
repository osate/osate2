package org.osate.ui.navigator;

import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlElementContentProvider implements ITreeContentProvider {
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Stream<EObject> children;
		if (parentElement instanceof IFile) {
			String path = ((IFile) parentElement).getFullPath().toString();
			URI uri = URI.createPlatformResourceURI(path, true);
			Resource resource = new ResourceSetImpl().getResource(uri, true);
			children = resource.getContents().stream();
		} else if (parentElement instanceof ContributedAadlStorage) {
			URI uri = ((ContributedAadlStorage) parentElement).getUri();
			Resource resource = new ResourceSetImpl().getResource(uri, true);
			children = resource.getContents().stream();
		} else {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) parentElement;
			EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
			if (eObject instanceof AadlPackage || eObject instanceof PropertySet
					|| eObject instanceof ComponentInstance) {
				children = eObject.eContents().stream();
			} else if (eObject instanceof PackageSection) {
				children = eObject.eContents().stream()
						.filter(element -> element instanceof Classifier || element instanceof AnnexLibrary);
			} else if (eObject instanceof Classifier) {
				children = eObject.eContents().stream().filter(
						element -> element instanceof ClassifierFeature || element instanceof PropertyAssociation);
			} else {
				children = Stream.empty();
			}
		}
		return children.map(element -> new EObjectURIWrapper(element)).toArray();
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof EObjectURIWrapper) {
			return new ResourceSetImpl().getEObject(((EObjectURIWrapper) element).getUri(), true).eContainer();
		} else {
			return null;
		}
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IFile || element instanceof ContributedAadlStorage) {
			return true;
		} else {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) element;
			EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
			if (eObject instanceof AadlPackage || eObject instanceof PropertySet
					|| eObject instanceof ComponentInstance) {
				return !eObject.eContents().isEmpty();
			} else if (eObject instanceof PackageSection) {
				return eObject.eContents().stream()
						.anyMatch(member -> member instanceof Classifier || member instanceof AnnexLibrary);
			} else if (eObject instanceof Classifier) {
				return eObject.eContents().stream().anyMatch(
						member -> member instanceof ClassifierFeature || member instanceof PropertyAssociation);
			} else {
				return false;
			}
		}
	}
}