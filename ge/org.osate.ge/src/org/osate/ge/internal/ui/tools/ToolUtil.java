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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	 * Get the errors and warnings for referenced element's root
	 */
	public static Set<Diagnostic> getAllReferencedPackageDiagnostics(final BusinessObjectContext boc) {
		// Find root to get all referenced package diagnostics
		final BusinessObjectContext root = findRoot(boc)
				.orElseThrow(() -> new RuntimeException("Cannot find root"));

		// Get referenced packages of root boc
		final Set<AadlPackage> packages = getReferencedPackages(root);

		// Collect errors and warnings for referenced AADL packages
		final List<DiagnosticBuilder> diagnosticBuilders = new ArrayList<>();
		for (final AadlPackage pkg : packages) {
			final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);
			final ResourceSet resourceSet = ProjectUtil.getLiveResourceSet(project);
			final DiagnosticBuilder diagnosticBuilder = new DiagnosticBuilder(pkg);
			// Model error and warning diagnostics
			populateDiagnostics(diagnosticBuilder,
					pkg,
					resourceSet);

			diagnosticBuilders.add(diagnosticBuilder);
		}

		return diagnosticBuilders.stream().flatMap(DiagnosticBuilder::getDiagnostics)
				.collect(toDiagnosticTreeSet());
	}

	/**
	 * Search a boc's descendants for elements and collect each element's root element that are an AadlPackage.
	 * @param rootBoc the boc that contains descendants to iterate
	 * @return a set of AadlPackages that are referenced within a root boc
	 */
	private static Set<AadlPackage> getReferencedPackages(final BusinessObjectContext rootBoc) {
		return rootBoc.getAllDescendants().map(queryable -> {
			final Object bo = queryable.getBusinessObject();
			if (bo instanceof Element) {
				final Element element = (Element) bo;
				final NamedElement root = element.getElementRoot();
				return root instanceof AadlPackage ? (AadlPackage) root : null;
			}

			return null;
		}).filter(Predicates.notNull()).collect(Collectors.toCollection(HashSet::new));
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

		final List<DiagnosticBuilder> diagnosticBuilders = new ArrayList<>();
		final NamedElement root = elementToModify.getElementRoot();
		if (root instanceof AadlPackage) {
			final DiagnosticBuilder diagnosticBuilder = new DiagnosticBuilder((AadlPackage)root);
			// Model error and warning diagnostics
			populateDiagnostics(diagnosticBuilder,
					modifiedObject,
					resourceSet);
			diagnosticBuilders.add(diagnosticBuilder);
		}

		return diagnosticBuilders.stream().flatMap(DiagnosticBuilder::getDiagnostics)
				.collect(toDiagnosticTreeSet());
	}


	/**
	 * Converts a stream to a tree set of diagnostics sorted by severity and message.
	 * Diagnostics that have a severity of error Diagnostic.ERROR
	 * are grouped to the start of the tree set in alphabetical order.  Diagnostics that
	 * have another severity are grouped to the end of the tree set in alphabetical order.
	 * @return returns a tree set of diagnostics that are sorted by severity and message
	 */
	private static Collector<Diagnostic, ?, TreeSet<Diagnostic>> toDiagnosticTreeSet() {
		return Collectors.toCollection(() -> new TreeSet<Diagnostic>((d1, d2) -> {
			// Convert severity into a sorting value based on whether it is an error.
			final int severity1 = d1.getSeverity() == Diagnostic.ERROR ? 0 : 1;
			final int severity2 = d2.getSeverity() == Diagnostic.ERROR ? 0 : 1;
			int result = Integer.compare(severity1, severity2);

			// Compare messages for equal severity
			if (result == 0) {
				result = d1.getMessage().compareToIgnoreCase(d2.getMessage());
			}

			return result;
		}));
	}

	// Get error and warning diagnostics
	private static void populateDiagnostics(
			final DiagnosticBuilder diagnosticsBuilder,
			final EObject eObjectToValidate,
			final ResourceSet resourceSet) {
		// Serialize
		final Optional<String> serializedSrc = getSerializedSource(eObjectToValidate);
		if (!serializedSrc.isPresent()) {
			diagnosticsBuilder.addDiagnostic(Diagnostic.ERROR, "Serialization Error");
			return;
		}

		final XtextResource resource = getOrCreateXtextResource(resourceSet, eObjectToValidate.eResource().getURI());
		loadResource(resource, serializedSrc.get());

		// Concrete Syntax Validation
		resource.validateConcreteSyntax().stream()
		.filter(diagnostic -> isErrorOrWarning(diagnostic))
		.forEach(diagnostic -> diagnosticsBuilder.addDiagnostic(diagnostic));

		final EObject serializedObject = resourceSet.getEObject(EcoreUtil.getURI(eObjectToValidate), true);
		final Diagnostic validationDiagnostic = Diagnostician.INSTANCE.validate(serializedObject,
				Collections.singletonMap(Diagnostician.VALIDATE_RECURSIVELY, true));
		if (isErrorOrWarning(validationDiagnostic)) {
			// Validation Diagnostics
			getDiagnosticDescendants(validationDiagnostic)
			.filter(diagnostic -> diagnostic instanceof FeatureBasedDiagnostic)
			.forEach(diagnostic -> diagnosticsBuilder.addDiagnostic(diagnostic));
		}

		// Errors
		getResourceDiagnostics(resource.getErrors(),
				diagnosticsBuilder,
				Diagnostic.ERROR);

		// Warnings
		getResourceDiagnostics(resource.getWarnings(),
				diagnosticsBuilder,
				Diagnostic.WARNING);
	}

	/**
	 * Diagnostic builder to hold the diagnostics that contain an error or warning
	 * severity and a message created for an AadlPackage
	 *
	 * Possible severity values:
	 * 0x2 = Diagnostic.WARNING
	 * 0x4 = Diagnostic.ERROR
	 */
	private static class DiagnosticBuilder {
		private final Stream.Builder<Diagnostic> diagnostics = Stream.builder();
		private final String msgPrefix;

		public DiagnosticBuilder(final AadlPackage pkg) {
			this.msgPrefix = getMessagePrefix(pkg.getName());
		}

		private static String getMessagePrefix(final String pkgName) {
			return new StringBuilder("Package ").append(pkgName).append(": ")
					.toString();
		}

		public Stream<Diagnostic> getDiagnostics() {
			return diagnostics.build();
		}

		public void addDiagnostic(final Diagnostic diagnostic) {
			addDiagnostic(diagnostic.getSeverity(), diagnostic.getMessage());
		}

		public void addDiagnostic(final int severity,
				final org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic) {
			addDiagnostic(severity, diagnostic.getMessage());
		}

		// Only support error and warning severity levels
		public void addDiagnostic(final int severity, final String msg) {
			if (severity != Diagnostic.ERROR && severity != Diagnostic.WARNING) {
				throw new RuntimeException("Severity must be an error or warning");
			}
			diagnostics.add(new BasicDiagnostic(severity, "", 0, getDetailedDiagnosticMessage(msg), null));
		}

		private String getDetailedDiagnosticMessage(final String message) {
			return new StringBuilder(this.msgPrefix).append(message).toString();
		}
	}

	/**
	 * Diagnostics contain a severity level that can be Diagnostic.OK(0x0), Diagnostic.INFO(0x1),
	 * Diagnostic.WARNING(0x2), Diagnostic.ERROR(0x4), or Diagnostic.CANCEL(0x8).
	 * This returns true if the diagnostic's severity level is Diagnstic.ERROR or Diagnostic.WARNING
	 * @param diagnostic the diagnostic that contains the severity to check
	 * @return true if the diagnostic's severity is an error or warning
	 */
	private static boolean isErrorOrWarning(final Diagnostic diagnostic) {
		final int severity = diagnostic.getSeverity();
		return severity == Diagnostic.ERROR || severity == Diagnostic.WARNING;
	}

	private static void getResourceDiagnostics(
			final List<org.eclipse.emf.ecore.resource.Resource.Diagnostic> diagnostics,
			final DiagnosticBuilder diagnosticBuilder,
			final int severity) {
		diagnostics.stream().forEach(diagnostic -> diagnosticBuilder.addDiagnostic(severity, diagnostic));
	}

	/**
	 * Recursively collects a diagnostic and its descendants
	 * @param diagnostic the diagnostic to get descendants from
	 * @return a stream of diagnostics that contains the diagnostic its descendants
	 */
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

	private static XtextResource getOrCreateXtextResource(final ResourceSet resourceSet, final URI uri) {
		final XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);
		return resource != null ? resource : (XtextResource) resourceSet.createResource(uri);
	}


}
