/*
 * <copyright>
 * Copyright  2007 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.ui.navigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.model.WorkbenchContentProvider;
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
import org.osate.pluginsupport.PluginSupportUtil;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlNavigatorContentProvider extends WorkbenchContentProvider {

	private static final Object[] NO_CHILDREN = new Object[0];
	private static final Object AADL_EXT = "aadl";
	private static final Object AAXL2_EXT = "aaxl2";
	
	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof IWorkspaceRoot) {
			List<Object> result = new ArrayList<>(Arrays.asList(super.getChildren(element)));
			result.add(VirtualPluginResources.INSTANCE);
			return result.toArray();
		} else if (element instanceof VirtualPluginResources) {
			return PluginSupportUtil.getContributedAadl().stream().map(uri -> {
				OptionalInt firstSignificantIndex = getFirstSignificantIndex(uri);
				if (!firstSignificantIndex.isPresent() || firstSignificantIndex.getAsInt() == uri.segmentCount() - 1) {
					return new ContributedAadlStorage(uri);
				} else {
					return new ContributedDirectory(Collections.singletonList(uri.segment(firstSignificantIndex.getAsInt())));
				}
			}).distinct().toArray();
		} else if (element instanceof ContributedDirectory) {
			List<String> directoryPath = ((ContributedDirectory) element).getPath();
			Stream<URI> inDirectory = PluginSupportUtil.getContributedAadl().stream().filter(uri -> {
				OptionalInt firstSignificantIndex = getFirstSignificantIndex(uri);
				if (firstSignificantIndex.isPresent() && firstSignificantIndex.getAsInt() < uri.segmentCount() - 1) {
					List<String> uriDirectory = uri.segmentsList().subList(firstSignificantIndex.getAsInt(), uri.segmentCount() - 1);
					return directoryPath.equals(uriDirectory);
				} else {
					return false;
				}
			});
			
			return inDirectory.map(uri -> {
				int nextSignificantIndex = getFirstSignificantIndex(uri).getAsInt() + directoryPath.size();
				if (nextSignificantIndex == uri.segmentCount() - 1) {
					return new ContributedAadlStorage(uri);
				} else {
					ArrayList<String> newPath = new ArrayList<>(directoryPath);
					newPath.add(uri.segment(nextSignificantIndex));
					return new ContributedDirectory(newPath);
				}
			}).distinct().toArray();
		} else if (element instanceof IFile) {
			IFile modelFile = (IFile) element;
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
		} else if (element instanceof AadlPackage) {
			AadlPackage aadlPackage = (AadlPackage) element;
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
		} else if (element instanceof PackageSection) {
			PackageSection pkg = (PackageSection) element;
			if (null != pkg) {
				return pkg.getOwnedClassifiers().toArray();
			}
		} else if (element instanceof PropertySet) {
			List<Property> properties = ((PropertySet) element).getOwnedProperties();
			List<PropertyType> propertyTypes = ((PropertySet) element).getOwnedPropertyTypes();
			List<PropertyConstant> propertyConstants = ((PropertySet) element).getOwnedPropertyConstants();
			List<Object> propertiesConstantsTypes = new ArrayList<Object>();
			propertiesConstantsTypes.addAll(properties);
			propertiesConstantsTypes.addAll(propertyConstants);
			propertiesConstantsTypes.addAll(propertyTypes);
			return propertiesConstantsTypes.toArray();
		} else if (element instanceof ConnectionInstance) {
			return NO_CHILDREN;
		} else if (element instanceof InstanceObject) {
			List<EObject> instances = ((InstanceObject) element).eContents();
			List<EObject> finalInstances = new ArrayList<EObject>();
			for (EObject eObject : instances) {
				if (!(eObject instanceof PropertyAssociation)) {
					finalInstances.add(eObject);
				}
			}
			return finalInstances.toArray();
		} else if (element instanceof Classifier) {
			return NO_CHILDREN;
		}

		return super.getChildren(element);
	}
	
	@Override
	public Object getParent(Object element) {
		if (element instanceof VirtualPluginResources) {
			return ResourcesPlugin.getWorkspace().getRoot();
		} else if (element instanceof ContributedDirectory) {
			List<String> path = ((ContributedDirectory) element).getPath();
			if (path.size() == 1) {
				return VirtualPluginResources.INSTANCE;
			} else {
				ArrayList<String> newList = new ArrayList<>(path);
				newList.remove(path.size() - 1);
				return new ContributedDirectory(newList);
			}
		} else if (element instanceof ContributedAadlStorage) {
			URI uri = ((ContributedAadlStorage) element).getUri();
			int firstSignificantIndex = getFirstSignificantIndex(uri).getAsInt();
			if (firstSignificantIndex == uri.segmentCount() - 1) {
				return VirtualPluginResources.INSTANCE;
			} else {
				List<String> path = uri.segmentsList().subList(firstSignificantIndex, uri.segmentCount() - 1);
				return new ContributedDirectory(path);
			}
		} else {
			return super.getParent(element);
		}
	}
	
	private static OptionalInt getFirstSignificantIndex(URI uri) {
		return IntStream.range(2, uri.segmentCount()).filter(index -> {
			String segment = uri.segment(index);
			return !(segment.startsWith("resource") || segment.startsWith("package") || segment.startsWith("propert"));
		}).findFirst();
	}
}