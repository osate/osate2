/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 */
package org.osate.xtext.aadl2.ba.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.services.BehaviorAnnexGrammarAccess;

import com.google.inject.Inject;

/** Selects the BA subclause entry rule when serializing an object embedded in an AADL resource. */
public final class BehaviorAnnexSerializer extends Serializer {
	@Inject
	private BehaviorAnnexGrammarAccess grammarAccess;

	@Override
	protected ISerializationContext getIContext(EObject semanticObject) {
		if (semanticObject instanceof BehaviorAnnex) {
			return contextFinder.findByContents(semanticObject, null)
					.stream()
					.filter(context -> context.getParserRule() == grammarAccess.getAnnexSubclauseRule())
					.findFirst()
					.orElse(null);
		}
		return super.getIContext(semanticObject);
	}
}
