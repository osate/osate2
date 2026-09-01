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
package org.osate.xtext.aadl2.ba.tests;

import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;

import com.google.inject.Injector;

/**
 * Registers the standalone BA Xtext services before creating the AADL injector so integration tests exercise annex
 * parsing inside complete {@code .aadl} resources.
 */
public final class BehaviorAnnexEmbeddedInjectorProvider extends Aadl2InjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		new BehaviorAnnexStandaloneSetup().createInjectorAndDoEMFRegistration();
		return super.internalCreateInjector();
	}
}
