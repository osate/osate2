package org.osate.ge.internal.viewModels;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;

import com.google.common.base.Strings;

/**
 * Class that stores a {@link NamedElement} or an {@link IEObjectDescription}. Supports comparison between the two using qualified names. Intended to be used as a view model
 * object when selecting named elements.
 */
class NamedElementOrDescription {
	private final Object value;
	private final String qualifiedName;
	private final String lcQualifiedName;

	public NamedElementOrDescription(final NamedElement namedElement) {
		this.value = Objects.requireNonNull(namedElement, "eobj must not be null");
		this.qualifiedName = Strings.nullToEmpty(namedElement.getQualifiedName());
		this.lcQualifiedName = qualifiedName.toLowerCase();
	}

	public NamedElementOrDescription(final IEObjectDescription desc) {
		this.value = Objects.requireNonNull(desc, "desc must not be null");
		this.qualifiedName = Strings.nullToEmpty(desc.getQualifiedName().toString("::"));
		this.lcQualifiedName = qualifiedName.toLowerCase();
	}

	/**
	 * Gets the value as an EObject. Resolves it if is a proxy.
	 * @param resourceSet the resource set to use to resolve proxies.
	 * @return the EObject
	 */
	public EObject getResolvedValue(final ResourceSet resourceSet) {
		// We need to get an actual EObject to determine children.
		EObject eobj;
		if (value instanceof IEObjectDescription) {
			eobj = ((IEObjectDescription) value).getEObjectOrProxy();
		} else {
			eobj = (EObject) value;
		}

		// Resolve the EObject if it is a proxy
		if (eobj != null && eobj.eIsProxy()) {
			eobj = EcoreUtil.resolve(eobj, resourceSet);
		}

		return eobj;
	}

	public String getQualifiedName() {
		return qualifiedName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lcQualifiedName);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NamedElementOrDescription other = (NamedElementOrDescription) obj;
		return Objects.equals(lcQualifiedName, other.lcQualifiedName);
	}
}
