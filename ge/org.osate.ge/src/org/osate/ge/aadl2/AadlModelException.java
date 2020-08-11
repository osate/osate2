package org.osate.ge.aadl2;

/**
 * Exception thrown to indicate that there was an unhandled problem with the underlying AADL model. In general, the graphical editor
 * will attempt to gracefully handle unexpected values in the AADL model. However, this exception is thrown when the graphical editor
 * does not handle the unexpected value.
 * @since 2.0
 *
 */
public class AadlModelException extends RuntimeException {
	/**
	 * Serializable version number for class
	 */
	private static final long serialVersionUID = 4833667000981390562L;

	public AadlModelException(final String message) {
		super(message);
	}
}
