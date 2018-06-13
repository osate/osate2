package org.osate.verify.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.verify.verify.ResoluteMethod;

import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

// @deprecated will be removed in OSATE version 2.3.5
// This removes the ability to refer to Resolute functions without qualification from within the Verify method registry
@Deprecated
public class VerifyLinkingService extends DefaultLinkingService {// PropertiesLinkingService {
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		String name = getCrossRefNodeAsString(node);
		EObject e = getLinkedObject(context, reference, name);
		if (e != null) {
			return Collections.singletonList(e);
		}
		return super.getLinkedObjects(context, reference, node);
	}

	private EObject getLinkedObject(EObject context, EReference reference, String name) {
//			name = name.replaceAll("::", ".");

		if (context instanceof ResoluteMethod) {
			return getFromScope(context, reference, name);
		}

		return null;
	}


	private EObject getFromScope(EObject context, EReference reference, String name) {
		for (IEObjectDescription description : getScope(context, reference).getAllElements()) {
			EClass ec = description.getEClass();
			if (!description.getName().isEmpty() && description.getName().getLastSegment().equalsIgnoreCase(name)
					&& ec == ResolutePackage.eINSTANCE.getFunctionDefinition()) {
				return description.getEObjectOrProxy();
			}
		}
		return null;
	}
}
