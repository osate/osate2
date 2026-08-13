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
package org.osate.core.tests.instantiation;

import java.util.ArrayList;
import java.util.List;

/**
 * Renders an {@link InstanceSnapshot} as deterministic text lines.
 *
 * <p>
 * The rendering is what characterization tests assert against, and what the
 * baseline capture records. Two renderings differ exactly when the underlying
 * descriptors differ, so a failed assertion shows the difference directly rather
 * than reporting an opaque object mismatch.
 * </p>
 */
public final class InstanceReport {

	private InstanceReport() {
	}

	/**
	 * Semantic connection lines, keyed by structured identity and sorted, so the
	 * rendering is independent of collection order.
	 */
	public static List<String> connectionLines(InstanceSnapshot snapshot) {
		List<String> lines = new ArrayList<>();
		for (ConnectionDescriptor descriptor : snapshot.allConnections()) {
			lines.add(render(descriptor));
		}
		return InstanceKeys.sorted(lines);
	}

	/** End-to-end flow lines, keyed and sorted, independent of collection order. */
	public static List<String> flowLines(InstanceSnapshot snapshot) {
		List<String> lines = new ArrayList<>();
		for (FlowDescriptor descriptor : snapshot.allFlows()) {
			lines.add(render(descriptor));
		}
		return InstanceKeys.sorted(lines);
	}

	/** Diagnostic lines, in report order, which is itself part of the behavior. */
	public static List<String> diagnosticLines(InstanceSnapshot snapshot) {
		List<String> lines = new ArrayList<>();
		for (DiagnosticDescriptor diagnostic : snapshot.diagnostics()) {
			lines.add(diagnostic.severity() + " | " + diagnostic.message() + " | at " + diagnostic.targetKey() + " | in "
					+ diagnostic.resourceName());
		}
		return List.copyOf(lines);
	}

	/**
	 * Per-container collection order of connections, rendered for the approved
	 * ordering allowlist and for determinism checks. This is the only place where
	 * collection position is intentionally observable.
	 */
	public static List<String> connectionOrderLines(InstanceSnapshot snapshot) {
		List<String> lines = new ArrayList<>();
		snapshot.connectionOrderByContainer()
				.forEach((container, names) -> lines.add(container + " => " + String.join(", ", names)));
		return InstanceKeys.sorted(lines);
	}

	/** Per-container collection order of end-to-end flows. */
	public static List<String> flowOrderLines(InstanceSnapshot snapshot) {
		List<String> lines = new ArrayList<>();
		snapshot.flowOrderByContainer()
				.forEach((container, names) -> lines.add(container + " => " + String.join(", ", names)));
		return InstanceKeys.sorted(lines);
	}

	private static String render(ConnectionDescriptor descriptor) {
		ConnectionDescriptor.Key key = descriptor.key();
		StringBuilder line = new StringBuilder();
		line.append("name='").append(descriptor.name()).append('\'');
		line.append(" kind=").append(descriptor.kind());
		line.append(" complete=").append(descriptor.complete());
		line.append(" bidirectional=").append(descriptor.bidirectional());
		line.append(" container=").append(key.containerKey());
		line.append(" src=").append(key.sourceKey());
		line.append(" dst=").append(key.destinationKey());
		line.append(" declarations=").append(key.declarationKeys());
		line.append(" contexts=").append(key.contextKeys());
		line.append(" reverse=").append(key.reverseFlags());
		line.append(" soms=").append(descriptor.systemOperationModes());
		line.append(" properties=").append(descriptor.properties());
		return line.toString();
	}

	private static String render(FlowDescriptor descriptor) {
		FlowDescriptor.Key key = descriptor.key();
		return "flow='" + key.name() + "' container=" + key.containerKey() + " declaration=" + key.declarationKey()
				+ " elements=" + key.elementKeys() + " soms=" + descriptor.systemOperationModes();
	}

	/** Complete rendering, for baseline capture and for debugging output. */
	public static String full(InstanceSnapshot snapshot) {
		StringBuilder report = new StringBuilder();
		section(report, "connections", connectionLines(snapshot));
		section(report, "connection collection order", connectionOrderLines(snapshot));
		section(report, "end-to-end flows", flowLines(snapshot));
		section(report, "flow collection order", flowOrderLines(snapshot));
		section(report, "diagnostics", diagnosticLines(snapshot));
		return report.toString();
	}

	private static void section(StringBuilder report, String title, List<String> lines) {
		report.append("== ").append(title).append(" (").append(lines.size()).append(") ==\n");
		lines.forEach(line -> report.append(line).append('\n'));
	}
}
