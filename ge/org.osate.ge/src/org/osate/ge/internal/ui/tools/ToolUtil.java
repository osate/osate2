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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.util.ProjectUtil;

import com.google.common.base.Predicates;

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
	 * Get the errors and warnings for referenced elements' root
	 */
	public static List<Diagnostic> getAllReferencedPackageDiagnostics(final BusinessObjectContext boc) {
		// Find root to get all referenced package diagnostics
		final BusinessObjectContext root = findRoot(boc)
				.orElseThrow(() -> new RuntimeException("Cannot find root"));

		// Get get root elements
		final Set<NamedElement> rootElements = root.getAllDescendants().map(queryable -> {
			final Object bo = queryable.getBusinessObject();
			return Element.class.isInstance(bo) ? bo : null;
		}).filter(Predicates.notNull()).map(bo -> ((Element) bo).getElementRoot()).collect(Collectors.toSet());

		// Collect errors and warnings for root elements
		final List<Diagnostic> diagnostics = new ArrayList<>();
		for (final NamedElement rootElement : rootElements) {
			final IProject project = ProjectUtil.getProjectForBoOrThrow(rootElement);
			final ResourceSet testResourceSet = ProjectUtil.getLiveResourceSet(project);

			// Model error and warning diagnostics
			final List<Diagnostic> rootDiagnostics = getDiagnostics(getErrorMessagePrefix(rootElement), rootElement,
					testResourceSet);
			diagnostics.addAll(rootDiagnostics);
		}

		return diagnostics;
	}

	private static String getErrorMessagePrefix(final NamedElement ne) {
		final StringBuilder builder = new StringBuilder("Package ");
		builder.append(ne.getName());
		return builder.append(": ").toString();
	}

	// Find the editor root boc
	private static Optional<BusinessObjectContext> findRoot(final BusinessObjectContext boc) {
		BusinessObjectContext tmp = boc;
		while (tmp.getParent() != null) {
			tmp = tmp.getParent();
		}

		return Optional.ofNullable(tmp);
	}

	/**
	 * Modifies an eObject and returns error and warning diagnostics
	 * @param objectToModify is the eObject to modify
	 * @param getModifiedObject performs the modification and returns modified eObject
	 * @return a list of error and warning diagnostics found during validation
	 */
	public static List<Diagnostic> getModificationDiagnostics(final Element objectToModify,
			final Function<ResourceSet, EObject> getModifiedObject) {
		final IProject project = ProjectUtil.getProjectForBoOrThrow(objectToModify);
		final ResourceSet testResourceSet = ProjectUtil.getLiveResourceSet(project);
		// Make modification
		final EObject modifiedObject = getModifiedObject.apply(testResourceSet);

		// Model error and warning diagnostics
		final List<Diagnostic> diagnostics = getDiagnostics(getErrorMessagePrefix(objectToModify.getElementRoot()),
				modifiedObject,
				testResourceSet);
		return diagnostics;
	}

	// Get error and warning diagnostics
	private static List<Diagnostic> getDiagnostics(final String errorMsgPrefix, final EObject eObjectToValidate,
			final ResourceSet testResourceSet) {

		// Serialize
		final Optional<String> serializedSrc = getSerializedSource(eObjectToValidate);
		if (!serializedSrc.isPresent()) {
			return Arrays.asList(new DiagnosticWrapper(Diagnostic.ERROR,
					getDetailedDiagnosticMessage(errorMsgPrefix, "Serialization Error")));
		}

		final XtextResource testResource = getXtextResource(testResourceSet, eObjectToValidate.eResource().getURI());
		loadResource(testResource, serializedSrc.get());

		final Builder<Diagnostic> diagnostics = Stream.builder();

		// Concrete Validation
		for (final Diagnostic diagnostic : testResource.validateConcreteSyntax()) {
			final int severity = diagnostic.getSeverity();
			if (isErrorOrWarning(severity)) {
				diagnostics.add(new DiagnosticWrapper(diagnostic.getSeverity(),
						getDetailedDiagnosticMessage(errorMsgPrefix, diagnostic.getMessage())));
			}
		}

		final EObject serializedObject = testResourceSet.getEObject(EcoreUtil.getURI(eObjectToValidate), true);
		final Diagnostic validationDiagnostic = Diagnostician.INSTANCE.validate(serializedObject,
				Collections.singletonMap(Diagnostician.VALIDATE_RECURSIVELY, true));
		final int severity = validationDiagnostic.getSeverity();
		if (isErrorOrWarning(severity)) {
			// Validation Diagnostics
			final Stream<Diagnostic> qualifiedDiagnostics = getDiagnosticDescendants(validationDiagnostic)
					.filter(diagnostic -> FeatureBasedDiagnostic.class.isInstance(diagnostic))
					.map(diagnostic -> new DiagnosticWrapper(diagnostic.getSeverity(),
							getDetailedDiagnosticMessage(errorMsgPrefix, diagnostic.getMessage())));
			addDiagnostics(diagnostics, qualifiedDiagnostics);
		}

		// Errors
		final Stream<Diagnostic> resourceErrors = testResource.getErrors().stream()
				.map(resourceDiagnostic -> new DiagnosticWrapper(Diagnostic.ERROR,
						getDetailedDiagnosticMessage(errorMsgPrefix, resourceDiagnostic.getMessage())));
		addDiagnostics(diagnostics, resourceErrors);

		// Warnings
		final Stream<Diagnostic> resourceWarnings = testResource.getWarnings().stream()
				.map(resourceDiagnostic -> new DiagnosticWrapper(Diagnostic.WARNING,
						getDetailedDiagnosticMessage(errorMsgPrefix, resourceDiagnostic.getMessage())));
		addDiagnostics(diagnostics, resourceWarnings);

		return diagnostics.build().collect(Collectors.toList());
	}

	private static String getDetailedDiagnosticMessage(final String prefix, final String msg) {
		return new StringBuilder(prefix).append(msg).toString();
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
