package org.osate.ge.businessobjecthandling;

/**
 * Interface which should be implemented by {@link BusinessObjectHandler} implementations to perform a raw deletion operation. A raw deletion
 * operation is one which the business object provided is read only and the graphical editor does not perform any action to prepare the model
 * for modification. This interface should only be implemented in very rare circumstances. Typically the built-in deletion mechanism or
 * {@link CustomDeleter} should be used.
 *
 * @since 2.0
 */
public interface RawDeleter {
	/**
	 * Delete the business object specified in the context.
	 * @param ctx the context for the delete request.
	 */
	void delete(RawDeleteContext ctx);
}
