package org.osate.mylyn.aadl.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.mylyn.context.core.AbstractContextStructureBridge;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public final class AadlStructureBridge extends AbstractContextStructureBridge {
	public final static String CONTENT_TYPE = "AADL";

	private final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();

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
			return EcoreUtil.getURI((Element) object).toString();
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
		if (aadlElement != null && aadlElement.eContainer() != null) {
			return getHandleIdentifier(aadlElement.eContainer());
		}
		return null;
	}

	@Override
	public Object getObjectForHandle(final String handle) {
		return resourceSet.getEObject(URI.createURI(handle), true);
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
			return "";
		} else {
			return "";
		}
	}

	@Override
	public boolean canBeLandmark(String handle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptsObject(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canFilter(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDocument(String handle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getHandleForOffsetInObject(Object resource, int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType(String elementHandle) {
		// TODO Auto-generated method stub
		return null;
	}

}
