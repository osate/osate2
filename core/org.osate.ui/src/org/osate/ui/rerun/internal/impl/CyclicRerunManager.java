package org.osate.ui.rerun.internal.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.osate.ui.rerun.RerunManager;
import org.osate.ui.rerun.Runner;

public final class CyclicRerunManager implements RerunManager {
	private static final int MAX_SIZE = 10;
	private static final List<Runner> runners = new LinkedList<>();

	@Override
	public synchronized void ran(final Runner runner) {
		/*
		 * Do not add the run if it is identical to the most recently
		 * added runner.
		 */
		if (runners.isEmpty() || !runners.get(0).equals(runner)) {
			if (runners.size() == MAX_SIZE) {
				runners.remove(MAX_SIZE - 1);
			}
			runners.add(0, runner);
		}
	}

	@Override
	public synchronized List<Runner> getPastRuns() {
		return Collections.unmodifiableList(new ArrayList<Runner>(runners));
	}
}
