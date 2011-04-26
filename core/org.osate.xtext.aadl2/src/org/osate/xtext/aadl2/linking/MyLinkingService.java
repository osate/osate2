package org.osate.xtext.aadl2.linking;


import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.Subcomponent;


	public class MyLinkingService extends DefaultLinkingService {

		@Override
		public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
		throws IllegalNodeException
		{
			final EClass requiredType = reference.getEReferenceType();
			if (requiredType == null)
				return Collections.<EObject> emptyList();
			final String s = getCrossRefNodeAsString(node);
			final EClass cl = Aadl2Package.eINSTANCE.getClassifier();
			if (cl.isSuperTypeOf(requiredType) ){
				// resolve classifier reference
				final int idx = s.lastIndexOf("::");
				String packname = "";
				String cname = s;
				PackageSection scope=null;
				scope = NameResolver.getContainingPackageSection(context);
				if (idx != -1 ){
					packname = s.substring(0, idx);
					cname = s.substring(idx+2);
					AadlPackage pack = NameResolver.findImportedPackage(packname, scope);
//					AadlPackage pack = NameResolver.findAadlPackage(scope,packname);
					if (pack != null){
						scope = pack.getOwnedPublicSection();
					}
				}
				if (scope != null){
					EObject e = NameResolver.findNamedElementInAadlPackage(cname,scope);
					if(e != null) {
//						context.eSet(reference, e);
						return Collections.singletonList((EObject)e);
					}
				}
				return Collections.<EObject> emptyList();
			} else if(Aadl2Package.eINSTANCE.getAadlPackage() == requiredType){
				// Resolve package reference
				/* find package */
				AadlPackage pack = NameResolver.findAadlPackage(context, s);
				if(pack != null) {
//					if (reference.isMany()){
//						EList<EObject> l = (EList<EObject>)context.eGet(reference);
//						l.add(pack);
//					} else {
//					context.eSet(reference, pack);
//					}
					return Collections.singletonList((EObject)pack);
				}
				PropertySet ps = NameResolver.findPropertySet(context, s);
				if (ps != null) {
					return Collections.singletonList((EObject)ps);
				}
			} else if(Aadl2Package.eINSTANCE.getConnectionEnd() == requiredType){
				Context cxt;
				if (reference.getFeatureID()==Aadl2Package.PORT_CONNECTION__DESTINATION){
					cxt = ((PortConnection)context).getDestinationContext();
				} else {
					cxt = ((PortConnection)context).getSourceContext();
				}
				ConnectionEnd ce = NameResolver.findPortConnectionEnd((PortConnection)context, cxt, s);
				if(ce != null) {
//					context.eSet(reference, ce);
					return Collections.singletonList((EObject)ce);
				}
			} else if(Aadl2Package.eINSTANCE.getPort()== requiredType){
				EObject searchResult = NameResolver.findNamedElement(NameResolver.getContainingClassifier(context),s);
					if(searchResult != null) {
//						context.eSet(reference, searchResult);
						return Collections.singletonList((EObject)searchResult);
					}
			} else if(Aadl2Package.eINSTANCE.getFeature()== requiredType){
				EObject searchResult = NameResolver.findNamedElement(NameResolver.getContainingClassifier(context),s);
					if(searchResult != null) {
//						context.eSet(reference, searchResult);
						return Collections.singletonList((EObject)searchResult);
					}
			} else if(Aadl2Package.eINSTANCE.getMode()== requiredType){
				EObject searchResult = NameResolver.findNamedElement(NameResolver.getContainingClassifier(context),s);
					if(searchResult != null) {
//						context.eSet(reference, searchResult);
						return Collections.singletonList((EObject)searchResult);
					}
			} else if(Aadl2Package.eINSTANCE.getContext() == requiredType){
				EObject searchResult = NameResolver.findNamedElement(NameResolver.getContainingClassifier(context),s);
				if (searchResult instanceof FeatureGroup || searchResult instanceof Subcomponent || searchResult instanceof DataPort ||
						searchResult instanceof EventDataPort){
					if(searchResult != null) {
//						context.eSet(reference, searchResult);
						return Collections.singletonList((EObject)searchResult);
					}
				}
			}

			return Collections.emptyList();
		};
		

}
