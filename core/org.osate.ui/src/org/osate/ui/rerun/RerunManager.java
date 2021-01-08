package org.osate.ui.rerun;

import java.util.List;

/**
 * Interface for classes that maintain a list of past runs.  The runs should be in most-recently
 * run order.  It is neither required nor prohibited that the entire history be kept.
 * @since 6.0
 */
public interface RerunManager {
	/**
	 * Record that a run occurred.
	 * @param runner The run that occurred.  Must not be {@code null}.
	 */
	public void ran(Runner runner);

	/**
	 * Get the list of past runs.
	 * @return The list of past runs.  Will never be {@code null}.  May be empty.
	 */
	public List<Runner> getPastRuns();

	/**
	 * Append the list of past runs to an existing list.
	 * @return The input list.
	 */
	public List<Runner> getPastRuns(final List<Runner> runners);

	/**
	 * Remove the given run from the list.  Has no effect if the run is not part of the list.
	 */
	public void remove(final Runner runner);
}
