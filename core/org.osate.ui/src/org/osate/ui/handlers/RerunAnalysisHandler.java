package org.osate.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.rerun.RerunManager;
import org.osate.ui.rerun.Runner;

/**
 * Command handler that reruns that most immediately performed runner.
 *
 * @since 6.0
 */
public final class RerunAnalysisHandler extends AbstractHandler {
	private final RerunManager rerunManager = OsateUiPlugin.getRerunManager();

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// Get the most recent run, if any
		final List<Runner> runs = rerunManager.getPastRuns();
		if (!runs.isEmpty()) {
			System.out.println("Rerunning \"" + runs.get(0).getName() + "\"");
		} else {
			System.err.println("No past runs!");
		}

		// API says to return null
		return null;
	}

}
