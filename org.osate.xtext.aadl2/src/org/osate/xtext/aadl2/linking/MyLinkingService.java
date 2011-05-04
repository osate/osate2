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
import org.osate.aadl2.CallContext;
import org.osate.aadl2.SubprogramCall;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Prototype;
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
				String packname = null;
				String cname = s;
				EObject e;
				PackageSection scope= NameResolver.getContainingPackageSection(context);
				if (idx != -1 ){
					packname = s.substring(0, idx);
					cname = s.substring(idx+2);
				} 
				e = NameResolver.findNamedElementInAadlPackage(packname,cname,scope);
					if(e != null && requiredType.isSuperTypeOf(e.eClass())) {
						// the result satisfied the expected class
						return Collections.singletonList((EObject)e);
					}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getAadlPackage() == requiredType){
				// Resolve package reference
				/* find package */
				AadlPackage pack = NameResolver.findAadlPackage(context, s);
				if(pack != null) {
					return Collections.singletonList((EObject)pack);
				}
				PropertySet ps = NameResolver.findPropertySet(context, s);
				if (ps != null) {
					return Collections.singletonList((EObject)ps);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getConnectionEnd() == requiredType){
				// resolve connection end
				Context cxt;
				if (reference.getFeatureID()==Aadl2Package.PORT_CONNECTION__DESTINATION){
					cxt = ((PortConnection)context).getDestinationContext();
				} else {
					cxt = ((PortConnection)context).getSourceContext();
				}
				ConnectionEnd ce = NameResolver.findPortConnectionEnd((PortConnection)context, cxt, s);
				if(ce != null) {
					return Collections.singletonList((EObject)ce);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getPort()== requiredType){
				EObject searchResult = NameResolver.getContainingClassifier(context).findNamedElement(s);
					if(searchResult != null && searchResult instanceof Port) {
						return Collections.singletonList((EObject)searchResult);
					}
					return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getFeature()== requiredType){
				// needs to handle refined if context is feature
				// Feature used in FlowSpec
				Classifier ns=NameResolver.getContainingClassifier(context);
				if (context instanceof Feature){
					// we need to resolve a refinement
					if (ns.getExtended() != null){
						ns = ns.getExtended();
					} else {
						return Collections.emptyList();
					}
				}
				EObject searchResult = ns.findNamedElement(s);
					if(searchResult != null && searchResult instanceof Feature) {
						return Collections.singletonList((EObject)searchResult);
					}
					return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getContext() == requiredType){
				// represents connection source/dest context as well as flowspec context
				// also used in triggerport
				EObject searchResult = NameResolver.getContainingClassifier(context).findNamedElement(s);
				if(searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
						return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getCallContext() == requiredType){
			EObject searchResult = NameResolver.getContainingClassifier(context).findNamedElement(s);
				if(searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList((EObject)searchResult);
				} 
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getCalledSubprogram() == requiredType){
				// if cxt then search in context
				Classifier ns = NameResolver.getContainingClassifier(context);
				CallContext cxt = null;
				if (reference.getFeatureID()==Aadl2Package.SUBPROGRAM_CALL__CONTEXT){
					cxt = ((SubprogramCall)context).getContext();
				}
			    EObject searchResult = ns.findNamedElement(s);
				if(searchResult != null && requiredType.isSuperTypeOf(searchResult.eClass())) {
					return Collections.singletonList((EObject)searchResult);
			    }
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getPrototype() == requiredType){
				// if context prototype then find in extension source (refined)
				// prototype binding as context
				Classifier ns=NameResolver.getContainingClassifier(context);
				if (context instanceof Prototype){
					// we need to resolve a refinement
					if (ns.getExtended() != null){
						ns = ns.getExtended();
					} else {
						return Collections.emptyList();
					}
				}
				EObject searchResult = ns.findNamedElement(s);
				if(searchResult != null && searchResult instanceof Prototype) {
					return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();

			}  else if(Aadl2Package.eINSTANCE.getSubcomponent() == requiredType){
				// if context Subcomponent then find in extension source (refined to)
				// prototype binding as context
				Classifier ns=NameResolver.getContainingClassifier(context);
				if (context instanceof Subcomponent){
					// we need to resolve a refinement
					if (ns.getExtended() != null){
						ns = ns.getExtended();
					} else {
						return Collections.emptyList();
					}
				}
				EObject searchResult = ns.findNamedElement(s);
				if(searchResult != null && searchResult instanceof Subcomponent) {
					return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();

			}  else if(Aadl2Package.eINSTANCE.getProperty() == requiredType ){
				// look for property definition in property set
				String psname = null;
				String pname = s;
				final int idx = s.lastIndexOf("::");
				if (idx != -1 ){
					psname = s.substring(0, idx);
					pname = s.substring(idx+2);
				} 
				EObject e = NameResolver.findNamedElementInPropertySet(psname,pname,NameResolver.getContainingClassifier(context));
				if(e != null && e instanceof Property) {
					return Collections.singletonList((EObject)e);
				}
				return Collections.<EObject> emptyList();

			}  else if(Aadl2Package.eINSTANCE.getPropertyType() == requiredType ){
				// look for property type  in property set
				String psname = null;
				String pname = s;
				final int idx = s.lastIndexOf("::");
				if (idx != -1 ){
					psname = s.substring(0, idx);
					pname = s.substring(idx+2);
				} 
				EObject e = NameResolver.findNamedElementInPropertySet(psname,pname,NameResolver.getContainingClassifier(context));
				if(e != null && e instanceof PropertyType) {
					return Collections.singletonList((EObject)e);
				}
				return Collections.<EObject> emptyList();

			}  else if(Aadl2Package.eINSTANCE.getPropertyConstant() == requiredType ){
				// look for property constant in property set
				String psname = null;
				String pname = s;
				final int idx = s.lastIndexOf("::");
				if (idx != -1 ){
					psname = s.substring(0, idx);
					pname = s.substring(idx+2);
				} 
				EObject e = NameResolver.findNamedElementInPropertySet(psname,pname,NameResolver.getContainingClassifier(context));
				if(e != null && e instanceof PropertyConstant) {
					return Collections.singletonList((EObject)e);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getMode() == requiredType){
				// referenced by mode transition and inmodes
				EObject searchResult = NameResolver.getContainingClassifier(context).findNamedElement(s);
				if(searchResult != null && searchResult instanceof Mode) {
					return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getModeTransition() == requiredType){
				// referenced by in modes
				EObject searchResult = NameResolver.getContainingClassifier(context).findNamedElement(s);
				if(searchResult != null && searchResult instanceof ModeTransition) {
					return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getFlowSpecification() == requiredType){
				// refined flow spec
				// referenced by flow implementation
				// also referenced in flow elements in impl and etef
				Classifier ns=NameResolver.getContainingClassifier(context);
				if (context instanceof FlowSpecification){
					// we need to resolve a refinement
					if (ns.getExtended() != null){
						ns = ns.getExtended();
					} else {
						return Collections.emptyList();
					}
				}
				EObject searchResult = ns.findNamedElement(s);
				if(searchResult != null && searchResult instanceof FlowSpecification) {
					return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getEndToEndFlow() == requiredType){
				// refined flow spec
				// referenced by flow implementation
				// also referenced in flow elements in impl and etef
				Classifier ns=NameResolver.getContainingClassifier(context);
				if (context instanceof EndToEndFlow){
					// we need to resolve a refinement
					if (ns.getExtended() != null){
						ns = ns.getExtended();
					} else {
						return Collections.emptyList();
					}
				}
				EObject searchResult = ns.findNamedElement(s);
				if(searchResult != null && searchResult instanceof EndToEndFlow) {
					return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();

			} else if(Aadl2Package.eINSTANCE.getConnection() == requiredType){
				// refined to, flow elements
				Classifier ns=NameResolver.getContainingClassifier(context);
				if (context instanceof Connection){
					// we need to resolve a refinement
					if (ns.getExtended() != null){
						ns = ns.getExtended();
					} else {
						return Collections.emptyList();
					}
				}
				EObject searchResult = ns.findNamedElement(s);
				if(searchResult != null && searchResult instanceof Connection) { 
					return Collections.singletonList((EObject)searchResult);
				}
				return Collections.<EObject> emptyList();
			}
			

			return Collections.emptyList();
		};
		

}
