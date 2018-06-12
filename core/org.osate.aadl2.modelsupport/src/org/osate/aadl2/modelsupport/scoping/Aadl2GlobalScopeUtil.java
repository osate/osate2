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

/**
 * Utility class that helps finding globally visible AADL elements by name.
 *
 * @since 2.3.4
 */
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

	/**
	 * Find an AADL element by EClass in the global scope. Simple names are also looked up
	 * in predeclared property sets.
	 *
	 * @since 2.3.4
	 *
	 * @param context The starting point for the global scope.
	 * @param eClass The meta class of the element to find.
	 * @param qname The qualified name to search.
	 * @return The EObject that matches class and name, null if the name cannot be found.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T get(EObject context, EClass eClass, String qname) {
		T result = null;
		IScope scope = globalScope.getScope(context.eResource(), eClass);
		IEObjectDescription desc = scope.getSingleElement(qnameConverter.toQualifiedName(qname));

		if (desc == null && qname.lastIndexOf("::") == -1) {
			// could be a predeclared propertyset element
			for (String predeclared : AadlUtil.getPredeclaredPropertySetNames()) {
				desc = scope.getSingleElement(qnameConverter.toQualifiedName(predeclared + "::" + qname));
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
