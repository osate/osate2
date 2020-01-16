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
package org.osate.aadl2.modelsupport;

import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * <p>
 * Simple wrapper which is used to store the URI of an EObject instead of an EObject. One place where this is used is in
 * the AADL Navigator to represent expanded elements below the file level.
 * </p>
 * Handlers and selection listeners can load an EObject from its URI:
 * <pre>
 *     EObjectURIWrapper wrapper = [some wrapper];
 *     EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
 * </pre>
 * <p>
 * The {@link #getEClass()} method is useful for determining the type of EObject without actually having to load it.
 * This is used internally when testing the {@code org.osate.aadl2.modelsupport.wrapperSuperType} property in a
 * <a href="https://wiki.eclipse.org/Command_Core_Expressions">Command Core Expression</a>. This example tests if a
 * wrapper represents a {@link ComponentInstance}.
 * </p>
 * <pre>
 * {@code
 * <adapt
 *       type="org.osate.aadl2.modelsupport.EObjectURIWrapper">
 *    <test
 *       property="org.osate.aadl2.modelsupport.wrapperSuperType"
 *       value="ComponentInstance"
 *       forcePluginActivation="true">
 *    </test>
 * </adapt>
 * }
 * </pre>
 */
public class EObjectURIWrapper {
	private final URI uri;
	private final EClass eClass;
	
	public EObjectURIWrapper(EObject eObject) {
		uri = EcoreUtil.getURI(eObject);
		eClass = eObject.eClass();
	}
	
	public URI getUri() {
		return uri;
	}
	
	public EClass getEClass() {
		return eClass;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(uri);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof EObjectURIWrapper && Objects.equals(uri, ((EObjectURIWrapper) obj).uri);
	}
}