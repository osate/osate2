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
package org.osate.xtext.aadl2.ba;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.modelsupport.scoping.DelegatingEClassGlobalScopeProvider;
import org.osate.xtext.aadl2.ba.naming.BehaviorAnnexQualifiedNameProvider;
import org.osate.xtext.aadl2.ba.scoping.BehaviorAnnexImportedNamespaceAwareLocalScopeProvider;
import org.osate.xtext.aadl2.ba.serializer.BehaviorAnnexSerializer;
import org.osate.xtext.aadl2.ba.serializer.BehaviorAnnexTransientValueService;
import org.osate.xtext.aadl2.formatting2.regionaccess.Aadl2TextRegionAccessBuilder;
import org.osate.xtext.aadl2.naming.Aadl2QualifiedNameConverter;
import org.osate.xtext.aadl2.properties.valueconversion.PropertiesValueConverter;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Runtime bindings for the standalone and embedded Behavior Annex Xtext language.
 */
public class BehaviorAnnexRuntimeModule extends AbstractBehaviorAnnexRuntimeModule {
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return PropertiesValueConverter.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return BehaviorAnnexQualifiedNameProvider.class;
	}

	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return Aadl2QualifiedNameConverter.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class)
				.annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(BehaviorAnnexImportedNamespaceAwareLocalScopeProvider.class);
	}

	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return DelegatingEClassGlobalScopeProvider.class;
	}

	public Class<? extends TextRegionAccessBuilder> bindTextRegionAccessBuilder() {
		return Aadl2TextRegionAccessBuilder.class;
	}

	@Override
	public Class<? extends ISerializer> bindISerializer() {
		return BehaviorAnnexSerializer.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> bindITransientValueService() {
		return BehaviorAnnexTransientValueService.class;
	}
}
