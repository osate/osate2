package org.osate.xtext.aadl2.linking;


import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.xtext.aadl2.properties.linking.NameResolver;


	public class MyLinkingService extends DefaultLinkingService {

		@Override
		public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
		throws IllegalNodeException
		{
			List<EObject> l = super.getLinkedObjects(context, reference, node);
			if (!l.isEmpty()) 
			{
				return l;
			}
			final EClass requiredType = reference.getEReferenceType();
			if (requiredType == null)
				return Collections.<EObject> emptyList();
			final String s = getCrossRefNodeAsString(node);
			return NameResolver.getMyLinkedObject(context, reference, s);
		};
		

}
