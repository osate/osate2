package org.osate.ge.aadl2.internal;

import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.GetIconIdContext;
import org.osate.ge.businessobjecthandling.RenameContext;

public abstract class AadlBusinessObjectHandler implements BusinessObjectHandler {
	/**
	 * Returns the image ID based on EClass of the EObject. Returns an empty optional if the business object was not an EObject.
	 * This method assumes there is an image referenced for the AADL EClass of the EObject.
	 */
	@Override
	public final Optional<String> getIconId(final GetIconIdContext ctx) {
		return ctx.getBusinessObject(EObject.class).map(o -> AadlImages.getImage(o.eClass()));
	}

	/**
	 * Implementation which used {@link AadlNamingUtil} to check name validity. Handlers must override if this is not the desired behavior.
	 * {@link #canRename(org.osate.ge.businessobjecthandling.CanRenameContext)} must also be implemented.
	 */
	@Override
	public Optional<String> validateName(final RenameContext ctx) {
		return ctx.getBusinessObject(
				NamedElement.class)
				.map(namedElement -> AadlNamingUtil.checkNameValidity(namedElement, ctx.getNewName()));
	}
}
