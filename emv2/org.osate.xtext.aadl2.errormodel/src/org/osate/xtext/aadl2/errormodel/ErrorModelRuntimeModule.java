/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE
 */
package org.osate.xtext.aadl2.errormodel;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.osate.xtext.aadl2.errormodel.naming.ErrorModelQualifiedNameConverter;
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
}
