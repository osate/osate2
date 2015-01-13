package org.osate.assure.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;

public class AssureLinkingService extends DefaultLinkingService {
	/**
	 * returns the first linked object
	 */
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		final String name = getCrossRefNodeAsString(node);
		if (requiredType == null) {
			return Collections.<EObject> emptyList();
		}
		EObject searchResult = context.eResource().getResourceSet().getEObject(URI.createURI(name), true);
		if (searchResult != null) {
			return Collections.singletonList(searchResult);
		}
		List<EObject> superes = super.getLinkedObjects(context, reference, node);
		return superes;
	}
}
