package org.osate.ui.navigator;

import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * <p>
 * Represents an expanded element, below the file level, in the AADL Navigator. The purpose of this class is to allow
 * the navigator to hold onto URIs of EObjects instead of holding onto EObjects themselves.
 * </p>
 * Handlers and selection listeners can load an EObject from its URI:
 * <pre>
 *     NavigatorEObjectNode node = [some navigator node];
 *     EObject eObject = new ResourceSetImpl().getEObject(node.getUri(), true);
 * </pre>
 * <p>
 * The {@link #getEClass()} method is useful for determining the type of EObject without actually having to load it.
 * This is used internally when testing the {@code org.osate.ui.navigatorNodeSuperType} property in a
 * <a href="https://wiki.eclipse.org/Command_Core_Expressions">Command Core Expression</a>. This example tests if a node
 * represents a {@link ComponentInstance}.
 * </p>
 * <pre>
 * {@code
 * <adapt
 *       type="org.osate.ui.navigator.NavigatorEObjectNode">
 *    <test
 *       property="org.osate.ui.navigatorNodeSuperType"
 *       value="ComponentInstance"
 *       forcePluginActivation="true">
 *    </test>
 * </adapt>
 * }
 * </pre>
 */
public class NavigatorEObjectNode {
	private final URI uri;
	private final EClass eClass;

	NavigatorEObjectNode(EObject eObject) {
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
		return obj instanceof NavigatorEObjectNode && Objects.equals(uri, ((NavigatorEObjectNode) obj).uri);
	}
}