/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
