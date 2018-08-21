package org.osate.ui.navigator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class AadlElementContentProvider implements ITreeContentProvider {

	private static final Object[] NO_CHILDREN = new Object[0];
	private static final Object AADL_EXT = "aadl";
	private static final Object AAXL2_EXT = "aaxl2";

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof IFile) {
			IFile modelFile = (IFile) inputElement;
			if (AADL_EXT.equals(modelFile.getFileExtension())) {
				EList<EObject> contents = OsateResourceUtil.getResource(modelFile).getContents();
				if (null != contents && !contents.isEmpty()) {
					EObject root = contents.get(0);
					if (root instanceof AadlPackage) {
						return new AadlPackage[] { (AadlPackage) root };
					} else if (root instanceof PropertySet) {
						return new PropertySet[] { (PropertySet) root };
					}
				}
			} else if (AAXL2_EXT.equals(modelFile.getFileExtension())) {
				EList<EObject> contents = OsateResourceUtil.getResource(modelFile).getContents();
				if (null != contents && !contents.isEmpty()) {
					EObject root = contents.get(0);
					if (root instanceof InstanceObject) {
						return new InstanceObject[] { (InstanceObject) root };
					}
				}
			}
		}
		return NO_CHILDREN;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile modelFile = (IFile) parentElement;
			if (AADL_EXT.equals(modelFile.getFileExtension())) {
				EList<EObject> contents = OsateResourceUtil.getResource(modelFile).getContents();
				if (null != contents && !contents.isEmpty()) {
					EObject root = contents.get(0);
					if (root instanceof AadlPackage) {
						return new AadlPackage[] { (AadlPackage) root };
					} else if (root instanceof PropertySet) {
						return new PropertySet[] { (PropertySet) root };
					}
				}
			} else if (AAXL2_EXT.equals(modelFile.getFileExtension())) {
				EList<EObject> contents = OsateResourceUtil.getResource(modelFile).getContents();
				if (null != contents && !contents.isEmpty()) {
					EObject root = contents.get(0);
					if (root instanceof InstanceObject) {
						return new InstanceObject[] { (InstanceObject) root };
					}
				}
			}
		} else if (parentElement instanceof AadlPackage) {
			AadlPackage aadlPackage = (AadlPackage) parentElement;
			List<PackageSection> packageSections = new ArrayList<PackageSection>();
			PackageSection publicPackageSection = aadlPackage.getOwnedPublicSection();
			if (null != publicPackageSection) {
				packageSections.add(publicPackageSection);
			}
			PackageSection privatePackageSection = aadlPackage.getOwnedPrivateSection();
			if (null != privatePackageSection) {
				packageSections.add(privatePackageSection);
			}
			return packageSections.toArray();
		} else if (parentElement instanceof PackageSection) {
			PackageSection pkg = (PackageSection) parentElement;
			if (null != pkg) {
				return pkg.getOwnedClassifiers().toArray();
			}
		} else if (parentElement instanceof PropertySet) {
			List<Property> properties = ((PropertySet) parentElement).getOwnedProperties();
			List<PropertyType> propertyTypes = ((PropertySet) parentElement).getOwnedPropertyTypes();
			List<PropertyConstant> propertyConstants = ((PropertySet) parentElement).getOwnedPropertyConstants();
			List<Object> propertiesConstantsTypes = new ArrayList<Object>();
			propertiesConstantsTypes.addAll(properties);
			propertiesConstantsTypes.addAll(propertyConstants);
			propertiesConstantsTypes.addAll(propertyTypes);
			return propertiesConstantsTypes.toArray();
		} else if (parentElement instanceof ConnectionInstance) {
			return NO_CHILDREN;
		} else if (parentElement instanceof InstanceObject) {
			List<EObject> instances = ((InstanceObject) parentElement).eContents();
			List<EObject> finalInstances = new ArrayList<EObject>();
			for (EObject eObject : instances) {
				if (!(eObject instanceof PropertyAssociation)) {
					finalInstances.add(eObject);
				}
			}
			return finalInstances.toArray();
		} else if (parentElement instanceof Classifier) {
			return NO_CHILDREN;
		}
		return NO_CHILDREN;
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
		if (element instanceof IFile) {
			return true;
		}
		if (element instanceof AadlPackage) {
			return true;
		}
		return getChildren(element).length > 0;
	}

}
