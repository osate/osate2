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