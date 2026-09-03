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
package org.osate.xtext.aadl2.ba.ui.quickfix;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.Fixes;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.osate.xtext.aadl2.properties.ui.quickfix.PropertiesQuickfixProvider;

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
public class BehaviorAnnexQuickfixProvider extends PropertiesQuickfixProvider {
	private static final Map<String, String> SYNTAX_CORRECTIONS = Map.of(
			"elif", "elsif",
			"endif", "end if",
			"==", "=");
	private static final Pattern QUOTED_TOKEN = Pattern.compile("'([^']+)'");

	@Fixes({
			@Fix(Diagnostic.SYNTAX_DIAGNOSTIC),
			@Fix(Diagnostic.SYNTAX_DIAGNOSTIC_WITH_RANGE)
	})
	public void correctKnownSyntaxTypo(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var matcher = QUOTED_TOKEN.matcher(issue.getMessage());
		while (matcher.find()) {
			var token = matcher.group(1);
			var correction = getSyntaxCorrection(token);
			if (correction.isEmpty() || "==".equals(token)) {
				continue;
			}
			acceptor.accept(issue, "Replace '" + token + "' with '" + correction.orElseThrow() + "'",
					"Apply the Behavior Annex spelling.", null, context -> context.getXtextDocument()
							.replace(issue.getOffset(), issue.getLength(), correction.orElseThrow()));
			return;
		}
	}

	public static Optional<String> getSyntaxCorrection(final String token) {
		return Optional.ofNullable(SYNTAX_CORRECTIONS.get(token.toLowerCase()));
	}
}
