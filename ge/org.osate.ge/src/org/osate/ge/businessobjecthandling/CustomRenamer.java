package org.osate.ge.businessobjecthandling;

/**
 * Interface which should be implemented by {@link BusinessObjectHandler} implementations that do not support the built-in rename refactoring.
 * If this interface is implemented, the rename refactoring support will not be used for the applicable business object.
 *
 * @since 2.0
 */
public interface CustomRenamer {
	/**
	 * Renames the business object specified in the context.
	 * @param ctx the context for the rename request.
	 */
	void rename(RenameContext ctx);
}
