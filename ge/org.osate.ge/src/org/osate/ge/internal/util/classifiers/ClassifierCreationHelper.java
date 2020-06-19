/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.util.classifiers;

import java.util.Objects;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.ge.internal.services.NamingService;
import org.osate.ge.internal.util.AadlNameUtil;
import org.osate.ge.internal.util.ProxyUtil;

public class ClassifierCreationHelper {
	private final NamingService namingService;
	private final ResourceSet resourceSet;

	public static class RenamedTypeDetails {
		public final String aliasName;
		public final boolean exists;

		public RenamedTypeDetails(final String aliasName, final boolean exists) {
			this.aliasName = Objects.requireNonNull(aliasName, "aliasName must not be null");
			this.exists = exists;
		}
	}

	public ClassifierCreationHelper(final NamingService namingService, final ResourceSet resourceSet) {
		this.namingService = Objects.requireNonNull(namingService, "namingService must not be null");
		this.resourceSet = Objects.requireNonNull(resourceSet, "resourceSet must not be null");
	}

	// Gets the name to use to reference a type from a specified section in another package.
	public RenamedTypeDetails getRenamedType(final PackageSection section, final AadlPackage typePackage,
			final String baseTypeName) {
		final String qualifiedTypeName = typePackage.getQualifiedName() + "::" + baseTypeName;

		// Look for an existing component type renames
		for (final ComponentTypeRename ctr : section.getOwnedComponentTypeRenames()) {
			if (AadlNameUtil.namesAreEqual(ctr.getRenamedComponentType().getQualifiedName(), qualifiedTypeName)
					&& ctr.getName() != null) {
				return new RenamedTypeDetails(ctr.getName(), true);
			}
		}

		final String baseAlias = qualifiedTypeName.replace("::", "_");
		return new RenamedTypeDetails(namingService.buildUniqueIdentifier(section, baseAlias), false);
	}

	// The returned name is the name of type and the complete "<type>.impl" for implementation.
	// Will return null if it is unable to build a name.
	public String getName(final ClassifierOperationPart primaryPart, final ClassifierOperationPart basePart) {
		return buildName(primaryPart.getType(), () -> getResolvedPackage(primaryPart.getSelectedPackage()),
				primaryPart.getIdentifier(), basePart);
	}

	public String buildName(final ClassifierOperationPartType primaryType, final AadlPackage pkg,
			final String identifier, final ClassifierOperationPart basePart) {
		return buildName(primaryType, () -> pkg, identifier, basePart);
	}

	public String buildName(final ClassifierOperationPartType primaryType, final Supplier<AadlPackage> primaryPkgSupplier,
			final String identifier, final ClassifierOperationPart basePart) {
		final String newName;
		if (primaryType == ClassifierOperationPartType.NEW_COMPONENT_IMPLEMENTATION) {
			if (basePart == null) {
				throw new RuntimeException("Base operation in invalid");
			}

			final AadlPackage primaryPkg = primaryPkgSupplier.get();
			final PackageSection section = primaryPkg.getPublicSection();

			// Determine details about the type specified by the base operation part.
			final String baseTypeName;
			final AadlPackage typePackage;

			// Get the name of the type and the package in which it is contained.
			if (ClassifierOperationPartType.isCreate(basePart.getType())) {
				typePackage = getResolvedPackage(basePart.getSelectedPackage());
				baseTypeName = basePart.getIdentifier();
			} else if (basePart.getType() == ClassifierOperationPartType.EXISTING) {
				final Classifier classifier = getResolvedClassifier(basePart.getSelectedClassifier());
				final ComponentType ct = getResolvedComponentType(classifier);
				if (ct == null) {
					return null;
				}
				typePackage = getPackage(ct);
				baseTypeName = ct.getName();
			} else {
				throw new RuntimeException("Invalid base operation part: " + basePart.getType());
			}

			// Handle type not being in same package as implementation
			final boolean samePackage = AadlNameUtil.namesAreEqual(primaryPkg, typePackage);

			final String localBaseTypeName = samePackage ? baseTypeName
					: getRenamedType(section, typePackage, baseTypeName).aliasName;

			newName = localBaseTypeName + "." + identifier;
		} else {
			newName = identifier;
		}

		return newName;
	}

	private static AadlPackage getPackage(final NamedElement ne) {
		if (ne == null) {
			return null;
		}

		final Namespace ns = ne.getNamespace();
		if (ns == null) {
			return null;
		}

		return ns.getOwner() instanceof AadlPackage ? (AadlPackage) ns.getOwner() : null;
	}

	private ComponentType getResolvedComponentType(final Classifier c) {
		if (c instanceof ComponentType) {
			return (ComponentType) c;
		} else if (c instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation) c;
			return ProxyUtil.resolveOrNull(ci.getType(), ComponentType.class, resourceSet);
		} else {
			throw new RuntimeException("Unexpected case: " + c);
		}
	}

	public AadlPackage getResolvedPackage(final Object value) {
		return ProxyUtil.resolveOrNull(value, AadlPackage.class, resourceSet);
	}

	public PublicPackageSection getResolvedPublicSection(final Object pkgValue) {
		final AadlPackage pkg = getResolvedPackage(pkgValue);
		return pkg == null ? null : pkg.getPublicSection();
	}

	public Classifier getResolvedClassifier(final Object value) {
		return ProxyUtil.resolveOrNull(value, Classifier.class, resourceSet);
	}
}
