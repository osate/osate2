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
package org.osate.xtext.aadl2.ba.formatting2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.properties.formatting2.PropertiesFormatter;

/**
 * Formats BA sections and nested action blocks while applying consistent punctuation and expression spacing across
 * the complete annex subtree.
 */
public final class BehaviorAnnexFormatter extends PropertiesFormatter {
	private static final Set<String> NO_SPACE_BEFORE = Set.of(",", ";", ":", ")", "]", "}", ".", "::", "#", "'",
			"?", "!", ">>", "!<", "!>");
	private static final Set<String> NO_SPACE_AFTER = Set.of("(", "[", ".", "::", "#", "'", "!", "?", ">>", "!<",
			"!>", "-[");
	private static final Set<String> SPACED_OPERATORS = Set.of(":=", "=>", "=", "!=", "<", "<=", ">", ">=", "+", "-",
			"*", "/", "mod", "rem", "**", "and", "or", "xor", "..");

	@Override
	public void format(final Object object, final IFormattableDocument document) {
		switch (object) {
		case BehaviorAnnex annex -> _format(annex, document);
		case XtextResource resource -> _format(resource, document);
		case EObject eObject -> _format(eObject, document);
		case null -> _format((Void) null, document);
		default -> _format(object, document);
		}
	}

	@SuppressWarnings("unchecked")
	protected void _format(final BehaviorAnnex annex, final IFormattableDocument document) {
		var regions = textRegionExtensions.allSemanticRegions(annex);
		var semanticRegions = regions instanceof List<?> ? (List<ISemanticRegion>) regions
				: java.util.stream.StreamSupport.stream(regions.spliterator(), false).toList();
		var sectionKeywords = new ArrayList<ISemanticRegion>(3);
		for (var i = 0; i + 1 < semanticRegions.size(); i++) {
			document.append(semanticRegions.get(i), it -> {
				it.lowPriority();
				it.oneSpace();
			});
		}

		for (var region : semanticRegions) {
			var text = region.getText().toLowerCase();
			if (NO_SPACE_BEFORE.contains(text)) {
				document.prepend(region, it -> {
					it.highPriority();
					it.noSpace();
				});
			}
			if (NO_SPACE_AFTER.contains(text)) {
				document.append(region, it -> {
					it.highPriority();
					it.noSpace();
				});
			}
			if (SPACED_OPERATORS.contains(text)) {
				document.surround(region, it -> {
					it.highPriority();
					it.oneSpace();
				});
			}
			if (";".equals(text)) {
				document.append(region, it -> {
					it.highPriority();
					it.newLine();
				});
			}
			if (",".equals(text)) {
				document.append(region, it -> {
					it.highPriority();
					it.oneSpace();
				});
			}
			if ("variables".equals(text) || "states".equals(text) || "transitions".equals(text)) {
				sectionKeywords.add(region);
				document.prepend(region, it -> {
					it.highPriority();
					if ("variables".equals(text)) {
						it.noSpace();
					} else {
						it.newLine();
					}
				});
				document.append(region, it -> {
					it.highPriority();
					it.newLine();
				});
			}
			if ("if".equals(text) || "elsif".equals(text) || "while".equals(text) || "until".equals(text)
					|| "for".equals(text) || "forall".equals(text) || "computation".equals(text)
					|| "binding".equals(text)) {
				document.append(region, it -> {
					it.highPriority();
					it.oneSpace();
				});
			}
			if ("]->".equals(text)) {
				document.prepend(region, it -> {
					it.highPriority();
					it.noSpace();
				});
				document.append(region, it -> {
					it.highPriority();
					it.oneSpace();
				});
			}
		}
		for (var i = 0; i < sectionKeywords.size(); i++) {
			var start = sectionKeywords.get(i);
			var end = i + 1 < sectionKeywords.size() ? sectionKeywords.get(i + 1)
					: semanticRegions.getLast();
			document.interior(start, end, it -> it.indent());
		}

		for (var pair : textRegionExtensions.allRegionsFor(annex).keywordPairs("{", "}")) {
			var open = pair.getKey();
			var close = pair.getValue();
			document.prepend(open, it -> {
				it.highPriority();
				it.oneSpace();
			});
			document.append(open, it -> {
				it.highPriority();
				it.newLine();
			});
			document.prepend(close, it -> {
				it.highPriority();
				it.newLine();
			});
			document.interior(open, close, it -> it.indent());
		}
	}
}
