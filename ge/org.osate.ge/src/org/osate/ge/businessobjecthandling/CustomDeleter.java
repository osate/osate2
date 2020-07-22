package org.osate.ge.businessobjecthandling;

/**
 * Interface which should be implemented by {@link BusinessObjectHandler} implementations to perform a custom delete operation.
 * This interface is only supported for business objects which implement {@link org.osate.ge.EmfContainerProvider}.
 * The only supported use is to allow deletion of business objects which do not implement {@link org.eclipse.emf.ecore.EObject}
 *
 * @since 2.0
 */
public interface CustomDeleter {
	/**
	 * Delete the business object specified in the context.
	 * @param ctx the context for the delete request.
	 */
	void delete(CustomDeleteContext ctx);
}
