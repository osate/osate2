package org.osate.xtext.aadl2.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.util.Triple;

public class NoCacheDerivedStateAwareResource extends DerivedStateAwareResource {
	@Override
	protected boolean isUnresolveableProxyCacheable(Triple<EObject, EReference, INode> triple) {
		return false;
	}
}
