package org.osate.aadl2.modelsupport.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;

public interface IDelegatingEClassGlobalScopeProvider extends IEClassGlobalScopeProvider {

	abstract IEClassGlobalScopeProvider getDelegate();

	@Override
	default IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		return getDelegate().getScope(context, reference, filter);
	}

	@Override
	default IScope getScope(Resource resource, EClass type, Predicate<IEObjectDescription> filter) {
		return getDelegate().getScope(resource, type, filter);
	}

	@Override
	default IScope getScope(Resource resource, EClass type) {
		return getDelegate().getScope(resource, type);
	}

}
