package org.osate.ui.internal.instantiate;

import java.util.Collection;

import org.eclipse.core.resources.IFile;

/**
 * Records the state of one of the instantiation jobs, i.e, was it successful, was it cancelled, did it have
 * an error of some sort?
 *
 * <p>The job is <i>cancelled</i> if the user cancelled it via the progress monitor.  When {@link #cancelled}
 * is non-{@code true}, {@link #successful} must be {@code false}.
 *
 * <p>An <i>error</i> is a message that was generated by internals of the job when
 * the job found something wrong.  When {@link #errorMessage} is non-{@code null}, {@link #successful}
 * must be {@code false}.
 *
 * <P>An <i>exception<i> is an exception that was thrown during execution of the job.  Here we expect
 * this to be some low-level eclipse craziness that the job is not equipped to deal with.  It is expected
 * that a job either has an error, an exception, or neither, but never both.  When {@link #exception} is
 * non-{@code null}, {@link #successful} must be {@code false}.
 */
final class InternalJobResult {
	/**
	 * The result value for a job that has not been scheduled or executed yet.  This is used to
	 * initialize the set of results for a set of jobs.  It identifies a job as cancelled
	 * because a job that is cancelled by the user before it runs never updates its state
	 * in the shared list of jobs, so we must make its initial state as cancelled.
	 */
	public static final InternalJobResult NOT_EXECUTED = new InternalJobResult(false, true, null, null, null);

	/* Make everything final here so that this class is thread-safe immutable */
	public final boolean successful;
	public final boolean cancelled;
	public final String errorMessage;
	public final Exception exception;
	public final IFile aaxlFile;

	public InternalJobResult(final boolean successful, final boolean cancelled, final String errorMessage,
			final Exception exception, final IFile aaxlFile) {
		this.successful = successful;
		this.cancelled = cancelled;
		this.errorMessage = errorMessage;
		this.exception = exception;
		this.aaxlFile = aaxlFile;
	}

	/**
	 * @since 4.0
	 */
	public static boolean allSuccessful(final Collection<InternalJobResult> results) {
		boolean allSuccessful = true;
		for (final InternalJobResult r : results) {
			allSuccessful &= r.successful;
		}
		return allSuccessful;
	}
}
