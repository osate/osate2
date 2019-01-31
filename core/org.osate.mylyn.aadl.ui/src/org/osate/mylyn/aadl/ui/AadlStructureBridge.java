package org.osate.mylyn.aadl.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.mylyn.context.core.AbstractContextStructureBridge;
import org.eclipse.mylyn.context.core.ContextCore;
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
	public final static String CONTENT_TYPE = "AADL";

	private final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
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
		/*
		 * XXX: Not really sure what this should do. JavaStructureBridge tries to adapt an IFile to a
		 * Java element. Probably we want to see if an IFile refers to a package or property set
		 * and return the appropriate AObject.
		 */
		return super.getAdaptedParent(object);
	}

	@Override
	public String getHandleIdentifier(final Object object) {
		// Use the URI as the identifier
		if (object instanceof Element) {
			final String uriString = EcoreUtil.getURI((Element) object).toString();
			return uriString;
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
					final IResource iRsrc = OsateResourceUtil.convertToIResource(eRsrc);
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
		 * and reutrn null.
		 */
		try {
			return resourceSet.getEObject(URI.createURI(handle), true);
		} catch (final Exception e) {
			return null;
		}
	}

	@Override
	public List<String> getChildHandles(String handle) {
		final Object object = getObjectForHandle(handle);
		if (object instanceof Element) {
			final Element aadlElement = (Element) object;
			// XXX Do I need to filter the children to just include features, subcomponents, etc.
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
		// Must be a component classifier, feature, subcomponent, etc, or a property declation in a property set.
		final Element aadlElement = (Element) getObjectForHandle(handle);
		final boolean isLandmark = aadlElement instanceof PropertySet || aadlElement instanceof AadlPackage
				|| aadlElement instanceof PackageSection
				|| aadlElement instanceof Classifier || aadlElement instanceof ClassifierFeature
				|| aadlElement instanceof PropertyConstant || aadlElement instanceof PropertyType
				|| aadlElement instanceof Property;
		return isLandmark;
	}

	@Override
	public boolean acceptsObject(final Object object) {
		if (object instanceof IResource) {
			final Object adapter = ((IResource) object).getAdapter(Element.class);
			final boolean b = adapter instanceof Element;
			return b;
		} else {
			final boolean b = object instanceof Element;
			return b;
		}
	}

	@Override
	public boolean canFilter(final Object element) {
		// XXX Not entirely sure what this does, but returning true seems reasonable
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
		// XXX Not sure what this does exatcly, seems to be related to markers. Wait and see on this
		return null;
	}

	@Override
	public String getContentType(final String parentHandle) {
		// XXX Not sure how great a test this really is
		if (parentHandle.endsWith(".aadl")) {
			return parentContentType;
		}
		return CONTENT_TYPE;
	}
}
