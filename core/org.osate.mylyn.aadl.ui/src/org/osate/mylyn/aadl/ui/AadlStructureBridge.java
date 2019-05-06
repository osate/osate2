package org.osate.mylyn.aadl.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.mylyn.context.core.AbstractContextStructureBridge;
import org.eclipse.mylyn.context.core.ContextCore;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.Element;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.UiUtil;

public final class AadlStructureBridge extends AbstractContextStructureBridge {
	private static final String ORG_OSATE2_AADL2 = "org.osate.aadl2";

	public final static String CONTENT_TYPE = "AADL";

	private final ResourceSet resourceSet = new ResourceSetImpl();
	private final ILabelProvider modelElementLabelProvider = UiUtil.getModelElementLabelProvider();

	public AadlStructureBridge() {
		super();
	}

	@Override
	public String getContentType() {
		return CONTENT_TYPE;
	}

	@Override
	public Object getAdaptedParent(final Object object) {
		return super.getAdaptedParent(object);
	}

	@Override
	public String getHandleIdentifier(final Object object) {
		// Use the URI as the identifier
		if (object instanceof Element) {
			final String uriString = EcoreUtil.getURI((Element) object).toString();
			return uriString;
		} else if (object instanceof EObjectNode) {
			return ((EObjectNode) object).getEObjectURI().toString();
		} else if (object instanceof IAdaptable) {
			final Object adapter = ((IAdaptable) object).getAdapter(Element.class);
			if (adapter instanceof Element) {
				return EcoreUtil.getURI((Element) adapter).toString();
			}
		}
		return null;
	}

	@Override
	public String getParentHandle(final String handle) {
		final Element aadlElement = (Element) getObjectForHandle(handle);
		if (aadlElement != null) {
			if (aadlElement.eContainer() != null) {
				return getHandleIdentifier(aadlElement.eContainer());
			} else {
				final AbstractContextStructureBridge parentBridge = ContextCore.getStructureBridge(parentContentType);
				if (parentBridge != null && ContextCore.CONTENT_TYPE_RESOURCE.equals(parentBridge.getContentType())) {
					final Resource eRsrc = aadlElement.eResource();
					final IFile iRsrc = OsateResourceUtil.toIFile(eRsrc.getURI());
					return parentBridge.getHandleIdentifier(iRsrc);
				}
			}
		}
		return null;
	}

	@Override
	public Object getObjectForHandle(final String handle) {
		/*
		 * The parent ResourceStructureBridge might call us with handles for resources, in this case we fail
		 * and return null.
		 */
		try {
			return resourceSet.getEObject(URI.createURI(handle), true);
		} catch (final Exception e) {
			return null;
		}
	}

	@Override
	public List<String> getChildHandles(final String handle) {
		final Object object = getObjectForHandle(handle);
		if (object instanceof Element) {
			final Element aadlElement = (Element) object;
			final List<String> childHandles = new ArrayList<String>();
			for (final Element child : aadlElement.getChildren()) {
				final String childHandle = getHandleIdentifier(child);
				if (childHandle != null) {
					childHandles.add(childHandle);
				}
			}
			return childHandles;
		}
		return Collections.emptyList();
	}

	@Override
	public String getLabel(final Object object) {
		if (object instanceof Element) {
			return modelElementLabelProvider.getText(object);
		} else {
			return "";
		}
	}

	@Override
	public boolean canBeLandmark(final String handle) {
		// Must be a component classifier, feature, subcomponent, etc, or a property declaration in a property set.
		final Element aadlElement = (Element) getObjectForHandle(handle);
		final boolean isLandmark = aadlElement instanceof PropertySet || aadlElement instanceof AadlPackage
				|| aadlElement instanceof PackageSection || aadlElement instanceof Classifier
				|| aadlElement instanceof ClassifierFeature
				|| aadlElement instanceof PropertyConstant || aadlElement instanceof PropertyType
				|| aadlElement instanceof Property;
		return isLandmark;
	}

	@Override
	public boolean acceptsObject(final Object object) {
		if (object instanceof IResource) {
			final Object adapter = ((IResource) object).getAdapter(Element.class);
			return adapter instanceof Element;
		} else if (object instanceof Element) {
			return true;
		} else if (object instanceof EObjectNode) {
			/* These nodes come from the Aadl2OutlinePage. Check that the type name begins with "org.osate.aadl2" */
			final EObjectNode eObjectNode = (EObjectNode) object;
			final String instanceTypeName = eObjectNode.getEClass().getInstanceTypeName();
			return instanceTypeName.startsWith(ORG_OSATE2_AADL2);
		} else {
			return false;
		}
	}

	@Override
	public boolean canFilter(final Object element) {
		/*
		 * I don't really know what this does, but if I return false, then the context pane
		 * of the task editor shows things that don't make sense. All the implementations in
		 * mylyn basically return true. So we return true here.
		 */
		return true;
	}

	@Override
	public boolean isDocument(final String handle) {
		// Packages and Property Sets can be opened in the editor
		final Element aadlElement = (Element) getObjectForHandle(handle);
		return aadlElement instanceof PropertySet || aadlElement instanceof AadlPackage;
	}

	@Override
	public String getHandleForOffsetInObject(Object resource, int offset) {
		/*
		 * XXX Not sure what this does exactly, seems to be related to markers. Wait and see on this.
		 * Not even sure when or why this gets called. Definitely safe to return null, as other
		 * implementations do so.
		 */
		return null;
	}

	@Override
	public String getContentType(final String parentHandle) {
		// Not sure how great a test this really is
		if (parentHandle.endsWith(".aadl")) {
			return parentContentType;
		}
		return CONTENT_TYPE;
	}
}
