package org.osate.xtext.aadl2.sandbox.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration;

public class SandboxLinkingService extends DefaultLinkingService {
	
	public static SandboxLinkingService eInstance = new SandboxLinkingService();

	public  List<EObject> getIndexedObjects(EObject context,
			EReference reference, String crossRefString) {

		final IScope scope = getScope(context, reference);
		QualifiedName qualifiedLinkName =  QualifiedName.create(crossRefString); //converter.toQualifiedName(crossRefString);
		IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName);
		if (eObjectDescription != null) 
			return Collections.singletonList(eObjectDescription.getEObjectOrProxy());
		return Collections.<EObject> emptyList();
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context,
			EReference reference, INode node) throws IllegalNodeException {
		EReference ref = SandboxPackage.eINSTANCE.getSystemInstanceProxy_InstanceRef();
		if (ref.equals(reference)){
			ResourceSet rset = context.eResource().getResourceSet();
			URI instanceURI = OsateResourceUtil
					.getInstanceModelURI((SystemImplementation)((SystemConfiguration)context.eContainer()).getSystemImplementation());
			Resource res = rset.getResource(instanceURI, true);
			if (res == null || res.getContents().isEmpty()){
				List <EObject> el = super.getLinkedObjects(context, ref, node);
				return el;
			}
			EObject root = res.getContents().get(0);
			List<EObject> el = Collections.singletonList((EObject) root);
			return el;
		} else {
			List <EObject> el = super.getLinkedObjects(context, reference, node);
			return el;
		}
	}

}
