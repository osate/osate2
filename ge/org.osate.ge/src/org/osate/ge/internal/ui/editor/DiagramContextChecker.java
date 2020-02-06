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
package org.osate.ge.internal.ui.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.services.SystemInstanceLoadingService;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;
import org.osate.ge.internal.services.impl.InstanceReferenceBuilder;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.internal.util.ProjectUtil;
import org.osate.ge.internal.util.ScopedEMFIndexRetrieval;

import com.google.common.base.Strings;

public class DiagramContextChecker {
	private final IProject project;
	private final ProjectReferenceService refService;
	private final SystemInstanceLoadingService systemInstanceLoader;

	public static class Result {
		private final boolean contextIsValid;
		private final boolean relinked;

		public Result(final boolean contextIsValid, final boolean relinked) {
			this.contextIsValid = contextIsValid;
			this.relinked = relinked;
		}

		public final boolean isContextValid() {
			return contextIsValid;
		}

		public final boolean wasContextUpdated() {
			return relinked;
		}
	}

	public DiagramContextChecker(final IProject project, final ProjectReferenceService refService,
			final SystemInstanceLoadingService systemInstanceLoader) {
		this.project = Objects.requireNonNull(project, "project must not be null");
		this.refService = Objects.requireNonNull(refService, "refService must not be null");
		this.systemInstanceLoader = Objects.requireNonNull(systemInstanceLoader,
				"systemInstanceLoader must not be null");
	}

	public Result checkContextFullBuild(final AgeDiagram diagram, final boolean promptToRelinkIfMissing) {
		return checkContext(diagram, promptToRelinkIfMissing, IncrementalProjectBuilder.FULL_BUILD);
	}

	public Result checkContextIncrementalBuild(final AgeDiagram diagram, final boolean promptToRelinkIfMissing) {
		return checkContext(diagram, promptToRelinkIfMissing, IncrementalProjectBuilder.INCREMENTAL_BUILD);
	}

	/**
	 * Checks the diagram context and optionally prompts the user to fix missing context.
	 * Throws an exception if the context is invalid.
	 * @param diagram
	 * @param promptToRelinkIfMissing
	 */
	private Result checkContext(final AgeDiagram diagram, final boolean promptToRelinkIfMissing,
			final int buildKind) {
		Objects.requireNonNull(diagram, "diagram must not be null");

		boolean relinked = false;

		// Contextless diagrams cannot have a broken context
		if(diagram.getConfiguration().getContextBoReference() != null) {
			Object contextBo = refService.resolve(diagram.getConfiguration().getContextBoReference());

			// If unable to resolve the context, rebuild the project
			if (contextBo == null) {
				try {
					project.build(buildKind, new NullProgressMonitor());
					contextBo = refService.resolve(diagram.getConfiguration().getContextBoReference());
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}

			// If the context is still not valid and the prompt flag is set, prompt the user for a new context and relink the diagram.
			if (contextBo == null && promptToRelinkIfMissing) {
				relinked = promptToRelink(diagram);
			}

			// Check the context again
			contextBo = refService.resolve(diagram.getConfiguration().getContextBoReference());
			if (contextBo == null) {
				return new Result(false, false);
			}
		}

		return new Result(true, relinked);
	}

	/**
	 * Returns whether or not the diagram context was adjusted.
	 * @param diagram
	 * @param missingContextRef
	 * @return
	 */
	private boolean promptToRelink(final AgeDiagram diagram) {
		final CanonicalBusinessObjectReference missingContextRef = diagram.getConfiguration().getContextBoReference();

		final List<String> refSegs = missingContextRef.getSegments();
		if (refSegs.size() < 2) {
			return false;
		}

		final boolean isPackageRef = DeclarativeReferenceType.PACKAGE.getId().equals(refSegs.get(0));
		final boolean isClassifierRef = DeclarativeReferenceType.CLASSIFIER.getId().equals(refSegs.get(0));
		final boolean isSystemInstance = InstanceReferenceBuilder.isSystemInstanceReference(refSegs);
		if (!isPackageRef && !isClassifierRef && !isSystemInstance) {
			return false;
		}

		// Determine the options to present to the user
		final Collection<?> options;
		String searchPrefix = "";
		if (isPackageRef || isClassifierRef) {
			// Find all packages
			final Collection<IEObjectDescription> packageDescriptions = ScopedEMFIndexRetrieval
					.getAllEObjectsByType(project, Aadl2Factory.eINSTANCE.getAadl2Package().getAadlPackage());

			if (isPackageRef) {
				options = packageDescriptions;
			} else if (isClassifierRef) {
				options = ScopedEMFIndexRetrieval.getAllEObjectsByType(project,
						Aadl2Factory.eINSTANCE.getAadl2Package().getClassifier());

				// Check if the package portion of the qualified name is a valid package.
				// If so, use it as the initial filter
				final String referencedClassifierQualifiedName = refSegs.get(1);
				final String[] qualifiedNameParts = referencedClassifierQualifiedName.split("::");
				if (qualifiedNameParts.length == 2) {
					final String pkgName = qualifiedNameParts[0];

					for (final IEObjectDescription desc : packageDescriptions) {
						if (desc.getName().toString("::").equalsIgnoreCase(pkgName)) {
							searchPrefix = pkgName.toLowerCase() + "::";
						}
					}
				}
			} else {
				options = Collections.emptyList();
			}
		} else if (isSystemInstance) {
			options = findInstanceModelFiles(project, new ArrayList<IPath>());
		} else {
			// Unexpected case: there is already a short circuit for the case where the reference isn't a package or classifier reference
			throw new RuntimeException("Unexpected case");
		}

		// Don't prompt if there aren't any options.
		if (options.size() == 0) {
			return false;
		}

		final ElementSelectionDialog dlg = new ElementSelectionDialog(null, "Missing Diagram Context",
				"Unable to find diagram context \"" + refService.getLabel(missingContextRef, project)
				+ "\".\nIf the model element has been renamed, select the new name for the model element.",
				options);
		dlg.setFilter(searchPrefix);
		if (dlg.open() != Window.OK) {
			return false;
		}

		final CanonicalBusinessObjectReference newContextCanonicalRef;
		final RelativeBusinessObjectReference newContextRelativeRef;

		final Object newContext;
		if (isSystemInstance) {
			final IPath systemInstancePath = (IPath) dlg.getFirstSelectedElement();
			newContextCanonicalRef = InstanceReferenceBuilder
					.getCanonicalBusinessObjectReferenceForSystemInstance(systemInstanceLoader, systemInstancePath);
			newContextRelativeRef = InstanceReferenceBuilder
					.getRelativeBusinessObjectReferenceForSystemInstance(systemInstanceLoader, systemInstancePath);

			// Create a dummy system instance. It will be replaced as part of the diagram updating process.
			newContext = InstanceFactory.eINSTANCE.createSystemInstance();
		} else {
			final EObject newContextProxy = (EObject) dlg.getFirstSelectedElement();

			// Find the live object
			final ResourceSet liveResourceSet = ProjectUtil.getLiveResourceSet(project);

			newContext = EcoreUtil.resolve(newContextProxy, liveResourceSet);
			if (((EObject) newContext).eIsProxy()) {
				throw new RuntimeException("Unable to retrieve non-proxy object for selection");
			}

			// Find canonical and relative reference
			newContextCanonicalRef = refService
					.getCanonicalReference(newContext);
			if (newContextCanonicalRef == null) {
				throw new RuntimeException("Unable to retrieve reference for new diagram context: " + newContext);
			}

			newContextRelativeRef = refService.getRelativeReference(newContext);
			if (newContextRelativeRef == null) {
				throw new RuntimeException(
						"Unable to retrieve relative reference for new diagram context: " + newContext);
			}
		}

		// Update the diagram
		diagram.modify("Update Diagram Context", m -> {
			// Update the diagram's context
			m.setDiagramConfiguration(new DiagramConfigurationBuilder(diagram.getConfiguration())
					.setContextBoReference(newContextCanonicalRef).build());

			// Update the root element
			if (diagram.getDiagramElements().size() == 1) {
				m.updateBusinessObject(diagram.getDiagramElements().stream().findAny().get(), newContext,
						newContextRelativeRef);
			}

		});

		return true;
	}

	/**
	 *
	 * @param parent
	 * @param results
	 * @return results
	 */
	private List<IPath> findInstanceModelFiles(final IResource res, final List<IPath> results) {
		if (res instanceof IFile && Strings.emptyToNull(res.getFileExtension()).equalsIgnoreCase("aaxl2")) {
			results.add(res.getFullPath());
		} else if (res instanceof IContainer) {
			final IContainer container = (IContainer) res;
			try {
				for (final IResource child : container.members()) {
					findInstanceModelFiles(child, results);
				}
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}

		return results;
	}
}
