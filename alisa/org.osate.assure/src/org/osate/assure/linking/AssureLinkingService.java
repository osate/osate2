package org.osate.assure.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider;
import org.osate.xtext.aadl2.properties.util.PSNode;

import com.google.inject.Inject;
import com.rockwellcollins.atc.resolute.linking.ResoluteLinkingService;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

public class AssureLinkingService extends DefaultLinkingService {

	public AssureLinkingService() {
		super();
	}

//	@Inject
//	private IGlobalScopeProvider scopeProvider;

	// XXX may want to use our own global lookup service
	@Inject
	public ResoluteLinkingService resoluteLinkingService;

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();
		final String name = getCrossRefNodeAsString(node);
		if (InstancePackage.eINSTANCE.getInstanceObject() == requiredType) {
			ResourceSet resset = context.eResource().getResourceSet();
			if (name.length() > 2) {
				String uriname = name.substring(1, name.length() - 1);
				try {
					URI rooturi = URI.createURI(uriname);
					EObject searchResult = resset.getEObject(rooturi, true);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					return Collections.<EObject> emptyList();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
//		} else if (Aadl2Package.eINSTANCE.getClassifier() == requiredType) {
//			String qname = name.replace("::", ".");
//			IEObjectDescription res = ((CommonGlobalScopeProvider) scopeProvider).getGlobalEObjectDescription(context,
//					Aadl2Package.eINSTANCE.getClassifier(), qname);
		}
		return super.getLinkedObjects(context, reference, node);
	}

	final static PSNode psNode = new PSNode();

	public FunctionDefinition resolveResoluteFunction(FnCallExpr proof, String resoluteFunctionName) {
		psNode.setText(resoluteFunctionName);
		List<EObject> boundList = resoluteLinkingService.getLinkedObjects(proof,
				ResolutePackage.eINSTANCE.getFnCallExpr_Fn(), psNode);
		if (boundList.size() > 0) {
			return (FunctionDefinition) boundList.get(0);
		}
		return null;
	}

	@Inject
	private IGlobalScopeProvider scopeProvider;

	public FunctionDefinition findResoluteFunction(FnCallExpr proof, String resoluteFunctionName) {
		FunctionDefinition fd = (FunctionDefinition) ((CommonGlobalScopeProvider) scopeProvider).getGlobalEObject(
				proof, ResolutePackage.eINSTANCE.getFunctionDefinition(), resoluteFunctionName);
		return fd;
	}

}
