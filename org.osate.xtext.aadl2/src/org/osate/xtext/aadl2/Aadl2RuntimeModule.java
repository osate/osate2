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
package org.osate.xtext.aadl2;

import org.eclipse.xtext.conversion.IValueConverterService;
import org.osate.xtext.aadl2.parsing.AnnexParserAgent;
import org.osate.xtext.aadl2.valueconversion.Aadl2ValueConverter;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class Aadl2RuntimeModule extends org.osate.xtext.aadl2.AbstractAadl2RuntimeModule {
	@Override
	public Class<? extends org.eclipse.xtext.linking.ILinkingService> bindILinkingService() {
		return org.osate.xtext.aadl2.linking.Aadl2LinkingService.class;
	}
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
	  return Aadl2ValueConverter.class;
	}
	@Override
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return org.osate.xtext.aadl2.naming.Aadl2QualifiedNameProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker() {
		return AnnexParserAgent.class;
	}

	public Class<? extends org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer> bindICrossReferenceSerializer() {
		return org.osate.xtext.aadl2.serializer.Aadl2CrossReferenceSerializer.class;
	}

	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IValueSerializer> bindITokenSerializer$IValueSerializer() {
		return org.osate.xtext.aadl2.serializing.Aadl2ValueSerializer.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> bindITransientValueService() {
		return org.osate.xtext.aadl2.serializing.Aadl2TransientValueService.class;
	}


//	//	@Override
//	public Class<? extends org.eclipse.xtext.resource.IFragmentProvider> bindIFragmentProvider() {
//		return org.osate.xtext.aadl2.util.Aadl2QualifiedNameFragmentProvider.class;
//	}

}
