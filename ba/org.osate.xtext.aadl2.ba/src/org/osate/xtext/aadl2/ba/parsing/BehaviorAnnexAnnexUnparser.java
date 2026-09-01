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
package org.osate.xtext.aadl2.ba.parsing;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexUnparser;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;

import com.google.inject.Inject;
import com.google.inject.Injector;

/** Serializes parsed BA subclauses without mutating their name or containment. */
public final class BehaviorAnnexAnnexUnparser implements AnnexUnparser {
	@Inject
	private ISerializer serializer;

	public BehaviorAnnexAnnexUnparser() {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy." + BehaviorAnnexStandaloneSetup.FILE_EXTENSION))
				.get(Injector.class);
		injector.injectMembers(this);
	}

	@Override
	public String unparseAnnexLibrary(AnnexLibrary library, String indent) {
		return null;
	}

	@Override
	public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		return serializer.serialize(subclause);
	}
}
