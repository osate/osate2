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
import java.util.Collections;
import java.util.HashSet;
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
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.util.ProjectUtil;

import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

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
	public static Set<Diagnostic> getAllReferencedPackageDiagnostics(final BusinessObjectContext boc) {
		// Find root to get all referenced package diagnostics
		final BusinessObjectContext root = findRoot(boc)
				.orElseThrow(() -> new RuntimeException("Cannot find root"));

		// Get get referenced packages
		final Set<NamedElement> packages = root.getAllDescendants().map(queryable -> {
			final Object bo = queryable.getBusinessObject();
			if (bo instanceof Element) {
				final Element element = (Element) bo;
				if (element.getElementRoot() instanceof AadlPackage) {
					return (AadlPackage) element.getElementRoot();
				}
			}

			return null;
		}).filter(Predicates.notNull()).collect(Collectors.toSet());

		// Collect errors and warnings for root elements
		final Set<Diagnostic> diagnostics = new HashSet<>();
		for (final NamedElement pkg : packages) {
			final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);
			final ResourceSet resourceSet = ProjectUtil.getLiveResourceSet(project);

			// Model error and warning diagnostics
			final Set<Diagnostic> rootDiagnostics = getDiagnostics(new DiagnosticBuilder(getMessagePrefix(pkg)), pkg,
					resourceSet);
			diagnostics.addAll(rootDiagnostics);
		}

		return diagnostics;
	}

	private static String getMessagePrefix(final NamedElement ne) {
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
	 * @param elementToModify is the element to modify
	 * @param getModifiedObject performs the modification and returns modified eObject
	 * @return a set of error and warning diagnostics found during validation
	 */
	public static Set<Diagnostic> getModificationDiagnostics(final Element elementToModify,
			final Function<ResourceSet, EObject> getModifiedObject) {
		final IProject project = ProjectUtil.getProjectForBoOrThrow(elementToModify);
		final ResourceSet resourceSet = ProjectUtil.getLiveResourceSet(project);
		// Make modification
		final EObject modifiedObject = getModifiedObject.apply(resourceSet);

		// Model error and warning diagnostics
		final Set<Diagnostic> diagnostics = getDiagnostics(
				new DiagnosticBuilder(getMessagePrefix(elementToModify.getElementRoot())),
				modifiedObject,
				resourceSet);
		return diagnostics;
	}

	// Get error and warning diagnostics
	private static Set<Diagnostic> getDiagnostics(final DiagnosticBuilder diagnosticBuilder,
			final EObject eObjectToValidate,
			final ResourceSet resourceSet) {
		// Serialize
		final Optional<String> serializedSrc = getSerializedSource(eObjectToValidate);
		if (!serializedSrc.isPresent()) {
			return Sets.newHashSet(diagnosticBuilder.build(Diagnostic.ERROR, "Serialization Error"));
		}

		final XtextResource resource = getXtextResource(resourceSet, eObjectToValidate.eResource().getURI());
		loadResource(resource, serializedSrc.get());

		final Builder<DiagnosticWrapper> diagnostics = Stream.builder();

		// Concrete Syntax Validation
		final Stream<DiagnosticWrapper> syntaxDiagnostics = resource.validateConcreteSyntax().stream()
				.filter(diagnostic -> isErrorOrWarning(diagnostic.getSeverity()))
				.map(diagnostic -> diagnosticBuilder.build(diagnostic));
		addToBuilder(diagnostics, syntaxDiagnostics);

		final EObject serializedObject = resourceSet.getEObject(EcoreUtil.getURI(eObjectToValidate), true);
		final Diagnostic validationDiagnostic = Diagnostician.INSTANCE.validate(serializedObject,
				Collections.singletonMap(Diagnostician.VALIDATE_RECURSIVELY, true));
		if (isErrorOrWarning(validationDiagnostic.getSeverity())) {
			// Validation Diagnostics
			final Stream<DiagnosticWrapper> qualifiedDiagnostics = getDiagnosticDescendants(validationDiagnostic)
					.filter(diagnostic -> diagnostic instanceof FeatureBasedDiagnostic)
					.map(diagnostic -> diagnosticBuilder.build(diagnostic));
			addToBuilder(diagnostics, qualifiedDiagnostics);
		}

		// Errors
		final Stream<DiagnosticWrapper> resourceErrors = getResourceDiagnostics(resource.getErrors(),
				diagnosticBuilder,
				Diagnostic.ERROR);
		addToBuilder(diagnostics, resourceErrors);

		// Warnings
		final Stream<DiagnosticWrapper> resourceWarnings = getResourceDiagnostics(resource.getWarnings(),
				diagnosticBuilder,
				Diagnostic.WARNING);
		addToBuilder(diagnostics, resourceWarnings);

		return diagnostics.build().collect(Collectors.toSet());
	}

	private static void addToBuilder(final Builder<DiagnosticWrapper> builder,
			final Stream<DiagnosticWrapper> diagnosticsToAdd) {
		diagnosticsToAdd.forEach(diagnostic -> builder.add(diagnostic));
	}

	private static class DiagnosticBuilder {
		private final String msgPrefix;

		public DiagnosticBuilder(final String msgPrefix) {
			this.msgPrefix = msgPrefix;
		}

		public DiagnosticWrapper build(final int severity, final String msg) {
			return new DiagnosticWrapper(severity, getDetailedDiagnosticMessage(this.msgPrefix, msg));
		}

		public DiagnosticWrapper build(final Diagnostic diagnostic) {
			return new DiagnosticWrapper(diagnostic.getSeverity(),
					getDetailedDiagnosticMessage(this.msgPrefix, diagnostic.getMessage()));
		}

		public DiagnosticWrapper build(final int severity,
				final org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic) {
			return new DiagnosticWrapper(severity,
					getDetailedDiagnosticMessage(this.msgPrefix, diagnostic.getMessage()));
		}

		private static String getDetailedDiagnosticMessage(final String prefix, final String message) {
			return new StringBuilder(prefix).append(message).toString();
		}
	}

	private static class DiagnosticWrapper extends BasicDiagnostic {
		public DiagnosticWrapper(final int severity, final String message) {
			this.severity = severity;
			this.message = message;
		}

		@Override
		public boolean equals(final Object o) {
			if (o == null) {
				return false;
			}
			if (o == this) {
				return true;
			}
			if (getClass() != o.getClass()) {
				return false;
			}

			final DiagnosticWrapper e = (DiagnosticWrapper) o;
			return (this.message.equalsIgnoreCase(e.getMessage()));
		}

		@Override
		public int hashCode() {
			return this.message.hashCode();
		}
	}

	private static boolean isErrorOrWarning(final int severity) {
		return severity == Diagnostic.ERROR || severity == Diagnostic.WARNING;
	}

	private static Stream<DiagnosticWrapper> getResourceDiagnostics(
			final List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics,
			final DiagnosticBuilder diagnosticBuilder,
			final int severity) {
		return diagnostics.stream()
				.map(diagnostic -> diagnosticBuilder.build(severity, diagnostic));
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
