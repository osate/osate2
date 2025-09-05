package org.osate.result.util;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.osate.result.AnalysisResult;
import org.osate.result.Diagnostic;

/**
 * @since 3.2
 */
public abstract class AbstractCSVResultWriter {
	protected final PrintWriter printWriter;

	protected AbstractCSVResultWriter(final PrintWriter printWriter) {
		this.printWriter = printWriter;
	}

	/**
	 * Write the results from given Analysis Results object.
	 *
	 * @param analysisResult The analysis results to write.
	 * @param monitor The progress monitor to use; may be {@code null}.
	 */
	public final void writeAnalysisResults(final AnalysisResult analysisResult, final IProgressMonitor monitor) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 3);
		writeContentAsCSV(analysisResult, subMonitor.split(1));
	}

	protected abstract void writeContentAsCSV(AnalysisResult analysisResult, IProgressMonitor monitor);

	// ==== Low-level CSV format

	protected final void generateContentforDiagnostics(final PrintWriter pw, final List<Diagnostic> diagnostics,
			final IProgressMonitor monitor) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, diagnostics.size());
		for (final Diagnostic issue : diagnostics) {
			printItem(pw, issue.getDiagnosticType().getName() + ": " + issue.getMessage());
			pw.println();
			subMonitor.split(1);
		}
	}

	protected final void printItems(final PrintWriter pw, final String item1, final String... items) {
		printItem(pw, item1);
		for (final String nextItem : items) {
			printSeparator(pw);
			printItem(pw, nextItem);
		}
		pw.println();
	}

	protected final void printItem(final PrintWriter pw, final String item) {
		// TODO: Doesn't handle quotes in the item!
		pw.print('"');
		pw.print(item);
		pw.print('"');
	}

	protected final void printSeparator(final PrintWriter pw) {
		pw.print(',');
	}
}
