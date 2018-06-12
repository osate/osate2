package org.osate.aadl2.modelsupport.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IScope;
import org.osate.aadl2.modelsupport.util.AadlUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class Aadl2GlobalScopeUtil {

	@Inject
	static IEClassGlobalScopeProvider globalScope;

	@Inject
	static IQualifiedNameConverter qnameConverter;

	static {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class);
		globalScope = injector.getInstance(IEClassGlobalScopeProvider.class);
		qnameConverter = injector.getInstance(IQualifiedNameConverter.class);
	}

	@SuppressWarnings("unchecked")
	public static <T extends EObject> T get(EObject context, EClass eClass, String name) {
		T result = null;
		IScope scope = globalScope.getScope(context.eResource(), eClass);
		IEObjectDescription desc = scope.getSingleElement(qnameConverter.toQualifiedName(name));

		if (desc == null && name.lastIndexOf("::") == -1) {
			// could be a predeclared propertyset element
			for (String predeclared : AadlUtil.getPredeclaredPropertySetNames()) {
				desc = scope.getSingleElement(qnameConverter.toQualifiedName(predeclared + "::" + name));
				if (desc != null) {
					break;
				}
			}
		}
		if (desc != null) {
			EObject o = desc.getEObjectOrProxy();
			if (o.eIsProxy()) {
				o = EcoreUtil.resolve(o, context);
			}
			result = o.eIsProxy() ? null : (T) o;
		}
		return result;
	}

}
