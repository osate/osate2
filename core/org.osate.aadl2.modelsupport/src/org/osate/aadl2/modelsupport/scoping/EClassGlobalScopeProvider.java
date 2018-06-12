package org.osate.aadl2.modelsupport.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.common.base.Predicate;

/**
 * Global scope provider that can build scopes for EClasses.
 * It just exposes methods that are not public in DefaultGlobalScopeProvider.
 *
 */
public class EClassGlobalScopeProvider extends DefaultGlobalScopeProvider implements IEClassGlobalScopeProvider {

	@Override
	public IScope getScope(Resource resource, EClass type, Predicate<IEObjectDescription> filter) {
		return getScope(resource, true, type, filter);
	}

	@Override
	public IScope getScope(Resource resource, EClass type) {
		return getScope(resource, type, null);
	}

}
