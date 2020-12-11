package org.osate.ui.rerun.internal.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.osate.ui.rerun.RerunManager;
import org.osate.ui.rerun.Runner;

public final class CyclicRerunManager implements RerunManager {
	private static final int MAX_SIZE = 10;
	private static final List<Runner> runners = new LinkedList<>();

	@Override
	public synchronized void ran(final Runner newRunner) {
		/*
		 * If the run equals any of the currently listed runs, we move that run to the top of
		 * the list. Otherwise, we remove the oldest run and add the new one. THis keeps
		 * repeated executions of the same analysis from polluting the list.
		 */
		boolean matched = false;
		final Iterator<Runner> i = runners.iterator();
		while (!matched && i.hasNext()) {
			final Runner oldRunner = i.next();
			if (newRunner.equals(oldRunner)) {
				matched = true;
				i.remove();
			}
		}
		if (!matched) {
			if (runners.size() == MAX_SIZE) {
				runners.remove(MAX_SIZE - 1);
			}
		}
		runners.add(0, newRunner);
	}

	@Override
	public synchronized List<Runner> getPastRuns() {
		return Collections.unmodifiableList(new ArrayList<Runner>(runners));
	}
}
