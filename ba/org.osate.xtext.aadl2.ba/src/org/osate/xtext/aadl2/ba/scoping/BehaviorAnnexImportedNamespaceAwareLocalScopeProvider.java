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
package org.osate.xtext.aadl2.ba.scoping;

import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * Makes OSATE's predeclared property sets available by simple name inside a BA subclause.
 */
public final class BehaviorAnnexImportedNamespaceAwareLocalScopeProvider
		extends ImportedNamespaceAwareLocalScopeProvider {
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		return AadlUtil.getPredeclaredPropertySetNames().stream()
				.map(name -> new ImportNormalizer(QualifiedName.create(name), true, ignoreCase))
				.toList();
	}
}
