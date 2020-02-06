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
package org.osate.ge.internal.ui.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.internal.ui.navigator.DiagramGroup;
import org.osate.workspace.WorkspacePlugin;
public class SelectionUtil {
	private static EObjectAtOffsetHelper eObjectAtOffsetHelper = new EObjectAtOffsetHelper();

	// Returns the current selection as diagram elements.
	// If one or more of the selected objects cannot be adapted to DiagramElement then an empty list is returned.
	public static List<DiagramElement> getSelectedDiagramElements(final ISelection selection, final boolean ignoreInvalidType) {
		return getAdaptedSelection(selection, DiagramElement.class, ignoreInvalidType);
	}

	public static List<DiagramNode> getSelectedDiagramNodes(final ISelection selection, final boolean ignoreInvalidType) {
		return getAdaptedSelection(selection, DiagramNode.class, ignoreInvalidType);
	}

	/**
	 *
	 * @param ignoreInvalidType if true then the selection will skip over instances that cannot be adapted. If false, an empty list will be returned in such cases.
	 */
	private static <T> List<T> getAdaptedSelection(final ISelection selection, final Class<T> adapter,
			final boolean ignoreInvalidType) {
		if (!(selection instanceof IStructuredSelection)) {
			return Collections.emptyList();
		}

		final IStructuredSelection ss = (IStructuredSelection) selection;
		final List<T> results = new ArrayList<>(ss.size());
		for (final Object sel : ss.toList()) {
			final T o = Adapters.adapt(sel, adapter);
			if (o == null) {
				if (!ignoreInvalidType) {
					return Collections.emptyList();
				}
			} else {
				results.add(o);
			}
		}

		return results;
	}

	public static List<BusinessObjectContext> getSelectedBusinessObjectContexts(final ISelection selection) {
		if (!(selection instanceof IStructuredSelection)) {
			return Collections.emptyList();
		}

		final IStructuredSelection ss = (IStructuredSelection) selection;
		final List<BusinessObjectContext> bocs = new ArrayList<>(ss.size());
		for (final Object sel : ss.toList()) {
			final BusinessObjectContext boc = Adapters.adapt(sel, BusinessObjectContext.class);
			if (boc == null) {
				return Collections.emptyList();
			}

			bocs.add(boc);
		}

		return bocs;
	}

	/**
	 * Returns a business object which is a valid diagram context based on the currnent selection. Returns null if such a business object could not be determined based on the current selection.
	 * @param selection
	 * @param activeEditor
	 * @return
	 */
	public static Object getDiagramContext(final ISelection selection, final IEditorPart activeEditor) {
		Object contextBo = null;
		if (activeEditor instanceof XtextEditor) {
			final EObject selectedObject = getEObjectFromSelection((XtextEditor) activeEditor, selection);
			contextBo = findDiagramContextForSelectedObject(selectedObject);
		}

		if (contextBo == null && selection instanceof IStructuredSelection) {
			final IStructuredSelection ss = (IStructuredSelection) selection;
			if (ss.size() == 1) {
				contextBo = findDiagramContextForSelectedObject(ss.getFirstElement());
			}
		}

		return contextBo;
	}

	private static Element findDiagramContextForSelectedObject(final Object selectedObject) {
		if (selectedObject instanceof IFile) {
			final String ext = ((IFile) selectedObject).getFileExtension();
			if (WorkspacePlugin.SOURCE_FILE_EXT.equalsIgnoreCase(ext)
					|| WorkspacePlugin.INSTANCE_FILE_EXT.equalsIgnoreCase(ext)) {
				URI uri = OsateResourceUtil.toResourceURI((IFile) selectedObject);
				final EList<EObject> contents = new ResourceSetImpl().getResource(uri, true).getContents();
				if (contents != null && !contents.isEmpty()) {
					final EObject root = contents.get(0);
					if (root instanceof AadlPackage) {
						return (AadlPackage) root;
					} else if (root instanceof ComponentInstance) {
						return (ComponentInstance) root;
					}
				}
			}
		} else if (selectedObject instanceof DiagramGroup) {
			final DiagramGroup dg = (DiagramGroup) selectedObject;
			if (dg.isContextReferenceValid()) {
				final ReferenceService referenceService = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getService(ReferenceService.class);
				if (referenceService == null) {
					return null;
				}

				final Object bo = referenceService.getProjectReferenceService(dg.getProject())
						.resolve(dg.getContextReference());
				if (bo instanceof AadlPackage) {
					return (AadlPackage) bo;
				} else if (bo instanceof Classifier) {
					return (Classifier) bo;
				} else if (bo instanceof SystemInstance) {
					return (SystemInstance) bo;
				}
			}
		} else if (selectedObject instanceof Element) {
			final Classifier classifier = findClassifier((Element) selectedObject);
			if (classifier != null) {
				return classifier;
			}

			final AadlPackage pkg = findPackage((Element) selectedObject);
			if (pkg != null) {
				return pkg;
			}
		} else if (selectedObject instanceof EObjectURIWrapper) {
			final EObjectURIWrapper wrapper = (EObjectURIWrapper) selectedObject;
			final EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);

			final Classifier classifier = findClassifier(eObject);
			if (classifier != null) {
				return classifier;
			}

			final AadlPackage pkg = findPackage(eObject);
			if (pkg != null) {
				return pkg;
			}
		}

		return null;
	}

	private static Classifier findClassifier(EObject obj) {
		while (obj instanceof Element) {
			if (obj instanceof Classifier) {
				return (Classifier) obj;
			} else if (obj instanceof Generalization) {
				final Classifier classifier = ((Generalization) obj).getGeneral();
				if (classifier != null) {
					return classifier;
				}
			}

			obj = obj.eContainer();
		}

		return null;
	}

	private static AadlPackage findPackage(EObject obj) {
		if (obj instanceof Element) {
			Element root = ((Element) obj).getElementRoot();
			if (root instanceof AadlPackage) {
				return (AadlPackage) root;
			}
		}

		return null;
	}

	private static EObject getEObjectFromSelection(XtextEditor editor, final ISelection selection) {
		// Check the selection before accessing the document
		if (selection instanceof IStructuredSelection) {
			final IStructuredSelection ss = (IStructuredSelection) selection;
			if (ss.size() != 1) {
				return null;
			}

			if (!(ss.getFirstElement() instanceof EObjectNode)) {
				return null;
			}
		} else if (!(selection instanceof ITextSelection)) {
			return null;
		}

		return editor.getDocument().readOnly(
				resource -> {
					EObject targetElement = null;
					if (selection instanceof IStructuredSelection) {
						final IStructuredSelection ss = (IStructuredSelection) selection;
						targetElement = ((EObjectNode) ss.getFirstElement()).getEObject(resource);
					} else if (selection instanceof ITextSelection) {
						final int offset = ((ITextSelection) selection).getOffset();
						targetElement = eObjectAtOffsetHelper.resolveContainedElementAt(resource, offset);

						// Check if the node for the semantic element that was retrieved by the offset helper starts after the line number of the node
						// retrieved using the offset. If it is, return the container. This prevents returning a classifier when the select is actually in
						// whitespace before the classifier.
						final IParseResult parseResult = resource.getParseResult();
						if(targetElement != null && parseResult != null) {
							final ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
							final INode targetElementNode = NodeModelUtils.getNode(targetElement);
							if(leaf.getStartLine() < targetElementNode.getStartLine()) {
								targetElement = targetElement.eContainer();
							}
						}

						// If there isn't a selected element, that usually means the selection is outside of the root package. Get the first EObject in the resource
						if(targetElement == null && resource.getContents().size() > 0) {
							targetElement = resource.getContents().get(0);
						}
					}

					return targetElement;
				});
	}

	public static IProject getProjectOrThrow(final Resource resource) {
		return getProjectOrThrow(resource.getURI());
	}

	public static IProject getProjectOrThrow(final URI resourceUri) {
		return getProject(resourceUri).orElseThrow(() -> new RuntimeException(
				"Unable to receive project. URI: " + resourceUri));
	}

	public static Optional<IProject> getProject(final URI resourceUri) {
		final IPath projectPath = new Path(resourceUri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if(projectResource instanceof IProject) {
			return Optional.of((IProject) projectResource);
		}

		return Optional.empty();
	}
}