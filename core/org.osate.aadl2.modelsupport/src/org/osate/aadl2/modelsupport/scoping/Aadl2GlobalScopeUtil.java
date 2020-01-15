/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.modelsupport.scoping;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * Find all AADL elements by EClass in the global scope.
	 *
	 * @since 2.3.5
	 *
	 * @param context The starting point for the global scope.
	 * @param eClass The meta class of the element to find.
	 * @return The EObjects that match the class.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> getAll(EObject context, EClass eClass) {
		IScope scope = globalScope.getScope(context.eResource(), eClass);
		Iterable<IEObjectDescription> descs = scope.getAllElements();
		List<T> eobjs = new ArrayList<T>();

		for (IEObjectDescription desc : descs) {
			T result = null;

			if (desc != null) {
				EObject o = desc.getEObjectOrProxy();

				if (o.eIsProxy()) {
					o = EcoreUtil.resolve(o, context);
				}
				result = o.eIsProxy() ? null : (T) o;
			}
			if (result != null) {
				eobjs.add(result);
			}
		}
		return eobjs;
	}

	/**
	 * Find all AADL element EObjectDescriptions by EClass in the global scope.
	 *
	 * @since 2.3.5
	 *
	 * @param context The starting point for the global scope.
	 * @param eClass The meta class of the element to find.
	 * @return The EObjectDescriptions that match the class.
	 */
	public static Iterable<IEObjectDescription> getAllEObjectDescriptions(EObject context, EClass eClass) {
		IScope scope = globalScope.getScope(context.eResource(), eClass);

		return scope.getAllElements();
	}

}
