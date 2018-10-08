package org.osate.ge.internal.ui.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
	public static List<DiagramElement> getSelectedDiagramElements(final ISelection selection) {
		return getAdaptedSelection(selection, DiagramElement.class);
	}

	public static List<DiagramNode> getSelectedDiagramNodes(final ISelection selection) {
		return getAdaptedSelection(selection, DiagramNode.class);
	}

	private static <T> List<T> getAdaptedSelection(final ISelection selection, final Class<T> adapter) {
		if (!(selection instanceof IStructuredSelection)) {
			return Collections.emptyList();
		}

		final IStructuredSelection ss = (IStructuredSelection) selection;
		final List<T> results = new ArrayList<>(ss.size());
		for (final Object sel : ss.toList()) {
			final T o = Adapters.adapt(sel, adapter);
			if (o == null) {
				return Collections.emptyList();
			}

			results.add(o);
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
				final EList<EObject> contents = OsateResourceUtil.getResource((IFile) selectedObject).getContents();
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
				final ReferenceService referenceService = (ReferenceService) PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getService(ReferenceService.class);
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

	public static IProject getProject(final Resource resource) {
		return getProject(resource.getURI());
	}

	public static IProject getProject(final URI resourceUri) {
		final IPath projectPath = new Path(resourceUri.toPlatformString(true)).uptoSegment(1);
		final IResource projectResource = ResourcesPlugin.getWorkspace().getRoot().findMember(projectPath);
		if(projectResource instanceof IProject) {
			return (IProject)projectResource;
		}

		throw new RuntimeException("Unable to receive project. Resource is of type " + projectResource.getClass().getName());
	}
}