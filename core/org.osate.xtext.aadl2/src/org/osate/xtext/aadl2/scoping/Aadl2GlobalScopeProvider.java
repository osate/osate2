package org.osate.xtext.aadl2.scoping;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2Util;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class Aadl2GlobalScopeProvider extends DefaultGlobalScopeProvider {
	
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	public boolean hasDuplicates(final NamedElement target) {
		Resource context = target.eResource();
		if (context == null || context.getResourceSet() == null)
			return false;
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context));
		Collections.reverse(containers);
		Iterator<IContainer> iter = containers.iterator();
		QualifiedName qn = qualifiedNameConverter.toQualifiedName(target.getName());
		boolean foundOne =false;
		while (iter.hasNext()) {
			IContainer container = iter.next();
			Iterable<IEObjectDescription> res = container.getExportedObjects(target.eClass(), qn, true);
			Iterator<IEObjectDescription> it = res.iterator();
			if (it.hasNext()){
				if (foundOne) return true;
				foundOne = true;
				it.next();
				if (it.hasNext()) return true;
			}
		}
		return false;
	}
	
	public List <IEObjectDescription> getDuplicates(final NamedElement target) {
		if (target.getName() == null || target.getName().isEmpty()){
			return Collections.EMPTY_LIST;
		}
		Resource context = target.eResource();
		if (context == null || context.getResourceSet() == null)
			return Collections.EMPTY_LIST;
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context));
//		Collections.reverse(containers);
		QualifiedName qn = qualifiedNameConverter.toQualifiedName(target.getName());
		boolean foundOne =false;
		List <IEObjectDescription> ielist = new Stack<IEObjectDescription>();
		for (IContainer container : containers) {
			Iterable<IEObjectDescription> res = container.getExportedObjects(target.eClass(), qn, true);
			for (IEObjectDescription ieObjectDescription : res) {
				if (foundOne) 
					ielist.add(ieObjectDescription);
				foundOne = true;
			}
		}
		return ielist;
	}

}
