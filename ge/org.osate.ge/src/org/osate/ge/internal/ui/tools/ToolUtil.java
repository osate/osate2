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
package org.osate.ge.internal.ui.tools;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.util.ProjectUtil;

public class ToolUtil {
	/**
	 * Looks in ancestors and returns the first BOC which is associated with a ComponentImplementation.
	 * Returns null if any ancestor is not associated with a NamedElement.
	 * @param boc
	 * @return
	 */
	public static BusinessObjectContext findComponentImplementationBoc(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc;
		while(tmp != null) {
			if(tmp.getBusinessObject() instanceof ComponentImplementation) {
				return tmp;
			} else if(!(tmp.getBusinessObject() instanceof NamedElement)) {
				return null;
			}

			tmp = tmp.getParent();
		}

		return null;
	}

	private static BusinessObjectContext findContextAncestorBoc(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc.getParent();
		while(tmp != null) {
			if(tmp.getBusinessObject() instanceof Context) {
				return tmp;
			}

			tmp = tmp.getParent();
		}

		return null;
	}

	public static Context findContext(final BusinessObjectContext boc) {
		final BusinessObjectContext contextBoc = findContextAncestorBoc(boc);
		return contextBoc == null ? null : (Context)contextBoc.getBusinessObject();
	}

	/**
	 * Finds a context. If the context BOC is the specified owner BOC, null is returned. It is expected that the owner's business object will be a valid context and is a container
	 * of the specified BOC. In such cases the function will return a context only if it is inside the owner business object context.
	 * @param boc
	 * @param ownerBoc
	 * @return
	 */
	public static Context findContextExcludeOwner(final BusinessObjectContext boc,
			final BusinessObjectContext ownerBoc) {
		final BusinessObjectContext contextBoc = findContextAncestorBoc(boc);
		return contextBoc == null || contextBoc == ownerBoc ? null : (Context) contextBoc.getBusinessObject();
	}

	/**
	 * Get model diagnostics
	 */
	public static List<Diagnostic> getModelDiagnostics(final BusinessObjectContext boc) {
		// Find package to get entire model diagnostics
		final AadlPackage pkg = findPackage(boc).orElseThrow(() -> new RuntimeException("Cannot find package"));
		final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);
		final ResourceSet testResourceSet = ProjectUtil.getLiveResourceSet(project);

		// Model error and warning diagnostics
		final List<Diagnostic> diagnostics = getDiagnostics(pkg, testResourceSet);
		return diagnostics;
	}

	private static Optional<AadlPackage> findPackage(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc;
		while (tmp != null) {
			if (tmp.getBusinessObject() instanceof AadlPackage) {
				return Optional.of((AadlPackage) tmp.getBusinessObject());
			}

			tmp = tmp.getParent();
		}

		return Optional.empty();
	}

	/**
	 * Modifies an eObject and returns error and warning diagnostics
	 * @param objectToModify is the eObject to modify
	 * @param getModifiedObject performs the modification and returns modified eObject
	 * @return a list of error and warning diagnostics found during validation
	 */
	public static List<Diagnostic> getModificationDiagnostics(final EObject objectToModify,
			final Function<ResourceSet, EObject> getModifiedObject) {
		final IProject project = ProjectUtil.getProjectForBoOrThrow(objectToModify);
		final ResourceSet testResourceSet = ProjectUtil.getLiveResourceSet(project);
		// Make modification
		final EObject modifiedObject = getModifiedObject.apply(testResourceSet);

		// Model error and warning diagnostics
		final List<Diagnostic> diagnostics = getDiagnostics(modifiedObject, testResourceSet);
		return diagnostics;
	}

	// Get error and warning diagnostics
	private static List<Diagnostic> getDiagnostics(final EObject eObjectToValidate, final ResourceSet testResourceSet) {
		// Serialize
		final Optional<String> serializedSrc = getSerializedSource(eObjectToValidate);
		if (!serializedSrc.isPresent()) {
			return Arrays.asList(new DiagnosticWrapper(Diagnostic.ERROR, "Serialization Error"));
		}

		final XtextResource testResource = getXtextResource(testResourceSet, eObjectToValidate.eResource().getURI());
		loadResource(testResource, serializedSrc.get());

		final Builder<Diagnostic> diagnostics = Stream.builder();

		// Concrete Validation
		for (final Diagnostic diagnostic : testResource.validateConcreteSyntax()) {
			final int severity = diagnostic.getSeverity();
			if (isErrorOrWarning(severity)) {
				diagnostics.add(diagnostic);
			}
		}

		final EObject serializedObject = testResourceSet.getEObject(EcoreUtil.getURI(eObjectToValidate), true);
		final Diagnostic validationDiagnostic = Diagnostician.INSTANCE.validate(serializedObject,
				Collections.singletonMap(Diagnostician.VALIDATE_RECURSIVELY, true));
		final int severity = validationDiagnostic.getSeverity();
		if (isErrorOrWarning(severity)) {
			// Validation Diagnostics
			final Stream<Diagnostic> qualifiedDiagnostics = getDiagnosticDescendants(validationDiagnostic)
					.filter(diagnostic -> FeatureBasedDiagnostic.class.isInstance(diagnostic));
			addDiagnostics(diagnostics, qualifiedDiagnostics);
		}

		// Errors
		final Stream<Diagnostic> resourceErrors = testResource.getErrors().stream()
				.map(resourceDiagnostic -> new DiagnosticWrapper(Diagnostic.ERROR, resourceDiagnostic.getMessage()));
		addDiagnostics(diagnostics, resourceErrors);

		// Warnings
		final Stream<Diagnostic> resourceWarnings = testResource.getWarnings().stream()
				.map(resourceDiagnostic -> new DiagnosticWrapper(Diagnostic.WARNING, resourceDiagnostic.getMessage()));
		addDiagnostics(diagnostics, resourceWarnings);

		return diagnostics.build().collect(Collectors.toList());
	}

	private static class DiagnosticWrapper extends BasicDiagnostic {
		public DiagnosticWrapper(final int severity, final String message) {
			this.severity = severity;
			this.message = message;
		}
	}

	private static boolean isErrorOrWarning(final int severity) {
		return severity == Diagnostic.ERROR || severity == Diagnostic.WARNING;
	}

	// Add diagnostics to stream builder
	private static void addDiagnostics(final Builder<Diagnostic> diagnostics,
			final Stream<Diagnostic> diagnosticsToAdd) {
		diagnosticsToAdd.forEach(diagnostic -> diagnostics.add(diagnostic));
	}

	// Retrieves all diagnostics
	private static Stream<Diagnostic> getDiagnosticDescendants(final Diagnostic diagnostic) {
		if (diagnostic.getChildren().isEmpty()) {
			return Stream.of(diagnostic);
		}

		return Stream.concat(Stream.of(diagnostic), diagnostic.getChildren().stream()
				.flatMap(childDiagnostic -> getDiagnosticDescendants(childDiagnostic)));
	}

	private static Optional<String> getSerializedSource(final EObject modifiedObject) {
		String serializedSrc = null;
		try {
			serializedSrc = ((XtextResource) modifiedObject.eResource()).getSerializer()
					.serialize(modifiedObject.eResource().getContents().get(0));
		} catch (final RuntimeException e) {
			// Error serializing modified object
		}

		return Optional.ofNullable(serializedSrc);
	}

	private static void loadResource(final XtextResource resource, final String src) {
		try {
			resource.unload();
			resource.load(new ByteArrayInputStream(src.getBytes()), null);
		} catch (final IOException e) {
			throw new RuntimeException("Serialized source cannot be loaded");
		}
	}

	private static XtextResource getXtextResource(final ResourceSet resourceSet, final URI uri) {
		final XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);
		return resource != null ? resource : (XtextResource) resourceSet.createResource(uri);
	}


}
