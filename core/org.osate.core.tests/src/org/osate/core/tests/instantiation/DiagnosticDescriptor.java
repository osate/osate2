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

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;

/**
 * Normalized description of one instantiation diagnostic.
 *
 * <p>
 * Reporter object identity is never compared; only severity, exact message text,
 * the normalized key of the reported element, and the resource that element
 * belongs to.
 * </p>
 */
public record DiagnosticDescriptor(String severity, String message, String targetKey, String resourceName) {

	/**
	 * Collect the queued diagnostics reported against {@code resource}, in report
	 * order.
	 *
	 * @throws IllegalArgumentException if the manager is not backed by
	 *             {@link QueuingAnalysisErrorReporter}; workspace-marker reporters
	 *             cannot be compared between runs
	 */
	public static List<DiagnosticDescriptor> of(AnalysisErrorReporterManager manager, Resource resource) {
		var reporter = manager.getReporter(resource);
		if (!(reporter instanceof QueuingAnalysisErrorReporter queuing)) {
			throw new IllegalArgumentException("Characterization requires a queuing in-memory error reporter, but got "
					+ (reporter == null ? "null" : reporter.getClass().getName()));
		}
		var diagnostics = new ArrayList<DiagnosticDescriptor>();
		for (var message : queuing.getErrors()) {
			Resource target = message.where == null ? null : message.where.eResource();
			String resourceName = target == null || target.getURI() == null ? InstanceKeys.NULL_KEY
					: target.getURI().lastSegment();
			diagnostics.add(new DiagnosticDescriptor(message.kind, message.message, InstanceKeys.any(message.where),
					resourceName));
		}
		return List.copyOf(diagnostics);
	}
}
