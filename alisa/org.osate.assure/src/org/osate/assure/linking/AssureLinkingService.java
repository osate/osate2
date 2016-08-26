/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.instance.InstancePackage;

public class AssureLinkingService extends DefaultLinkingService {

	public AssureLinkingService() {
		super();
	}

//	@Inject
//	private IGlobalScopeProvider scopeProvider;

	// XXX may want to use our own global lookup service

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();
		final String name = getCrossRefNodeAsString(node);
//		if (EcorePackage.eINSTANCE.getEObject() == requiredType) {
		if (InstancePackage.eINSTANCE.getInstanceObject() == requiredType) {
			ResourceSet resset = context.eResource().getResourceSet();
			if (name.length() > 2) {
				String uriname = name;
				if (name.startsWith("\"")) {
					uriname = name.substring(1, name.length() - 1);
				}
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
		} else if (EcorePackage.eINSTANCE.getEObject() == requiredType) {
			ResourceSet resset = context.eResource().getResourceSet();
			if (name.length() > 2) {
				String uriname = name;
				if (name.startsWith("\"")) {
					uriname = name.substring(1, name.length() - 1);
				}
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

}
