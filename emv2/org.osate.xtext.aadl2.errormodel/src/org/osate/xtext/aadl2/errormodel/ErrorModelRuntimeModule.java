/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.xtext.aadl2.errormodel;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.osate.xtext.aadl2.errormodel.naming.ErrorModelQualifiedNameConverter;
import org.osate.xtext.aadl2.errormodel.scoping.ErrorModelGlobalScopeProvider;
import org.osate.xtext.aadl2.errormodel.scoping.ErrorModelImportedNamespaceAwareLocalScopeProvider;
import org.osate.xtext.aadl2.errormodel.serializer.ErrorModelCrossReferenceSerializer;
import org.osate.xtext.aadl2.errormodel.serializer.ErrorModelSerializer;
import org.osate.xtext.aadl2.errormodel.valueconversion.ErrorModelValueConverter;
import org.osate.xtext.aadl2.formatting2.regionaccess.Aadl2TextRegionAccessBuilder;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ErrorModelRuntimeModule extends org.osate.xtext.aadl2.errormodel.AbstractErrorModelRuntimeModule {

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return ErrorModelValueConverter.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return org.osate.xtext.aadl2.errormodel.naming.ErrorModelQualifiedNameProvider.class;
	}

	public Class<? extends IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return ErrorModelQualifiedNameConverter.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> bindITransientValueService() {
		return org.osate.xtext.aadl2.errormodel.serializer.EMV2TransientValueService.class;
	}

	public Class<? extends ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return ErrorModelCrossReferenceSerializer.class;
	}

	@Override
	public Class<? extends ISerializer> bindISerializer() {
		return ErrorModelSerializer.class;
	}

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
				.to(ErrorModelImportedNamespaceAwareLocalScopeProvider.class);
	}

	public Class<? extends TextRegionAccessBuilder> bindTextRegionAccessBuilder() {
		return Aadl2TextRegionAccessBuilder.class;
	}

	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return ErrorModelGlobalScopeProvider.class;
	}
}
