package org.osate.xtext.aadl2.util;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.osate.aadl2.NamedElement;

import com.google.inject.Inject;

	public class Aadl2QualifiedNameFragmentProvider implements IFragmentProvider {

		  @Inject
		  private IQualifiedNameProvider qualifiedNameProvider;

	public String getFragment(EObject obj, Fallback fallback) {
		String qName = null;
		if (obj instanceof NamedElement) {
			qName = ((NamedElement) obj).getQualifiedName();
		} else {
			qName = qualifiedNameProvider.getFullyQualifiedName(obj).toString();
		}
		return qName != null ? qName : fallback.getFragment(obj);
	}

		  public EObject getEObject(Resource resource, 
		                            String fragment, 
		                            Fallback fallback) {
		    if (fragment != null) {
		      Iterator<EObject> i = EcoreUtil.getAllContents(resource, false);
		      while(i.hasNext()) {
		        EObject eObject = i.next();
		        String candidateFragment = (eObject.eIsProxy()) 
		            ? ((InternalEObject) eObject).eProxyURI().fragment()
		            : getFragment(eObject, fallback);
		        if (fragment.equals(candidateFragment)) 
		          return eObject;
		      }
		    }
		    return fallback.getEObject(fragment);
		  }
		}

