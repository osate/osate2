/* Created on Sep 15, 2005
 */
package org.osate.aadl2.modelsupport.errorreporting;

/**
 * An internal error reporter to ignores internal error messages.
 * Contains a {@link #prototype singleton reference}.
 *
 * @author aarong
 */
public final class NullInternalErrorReporter extends AbstractInternalErrorReporter {
	/** Singleton reference. */
	public static final NullInternalErrorReporter prototype = new NullInternalErrorReporter();

	/**
	 * Private constructor to enforce singleton pattern.
	 */
	private NullInternalErrorReporter() {
		// do nothing
	}

	@Override
	public void internalErrorImpl(final String message) {
		// do nothing
	}

	@Override
	public void internalErrorImpl(final Exception e) {
		// do nothing
	}
}
