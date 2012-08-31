/*
 *
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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
// we are not using it for unassigned values. We use token like PNAME instead
//	public Class<? extends org.eclipse.xtext.serializer.tokens.IValueSerializer> bindITokenSerializer$IValueSerializer() {
//		return org.osate.xtext.aadl2.serializing.Aadl2ValueSerializer.class;
//	}

	@Override
	public Class<? extends org.eclipse.xtext.parsetree.reconstr.ITransientValueService> bindITransientValueService() {
		return org.osate.xtext.aadl2.serializing.Aadl2TransientValueService.class;
	}


//		@Override
	public Class<? extends org.eclipse.xtext.resource.EObjectAtOffsetHelper> bindEObjectAtOffsetHelper() {
		return org.osate.xtext.aadl2.util.Aadl2EObjectAtOffsetHelper.class;
	}
	public Class<? extends org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper> bindHyperlinkHelper() {
		return org.osate.xtext.aadl2.util.Aadl2HyperlinkHelper.class;
	}

//	@Override
public Class<? extends org.eclipse.xtext.resource.DefaultLocationInFileProvider> bindDefaultLocationInFileProvider() {
	return org.osate.xtext.aadl2.util.Aadl2LocationInFile.class;
}
	
//	@Override
	public Class<? extends org.eclipse.xtext.ui.editor.doubleClicking.AbstractWordAwareDoubleClickStrategy> bindLexerTokenAndCharacterPairAwareStrategy() {
		return org.osate.xtext.aadl2.parsing.Aadl2TokenStrategy.class;
	}
	
	public Class<? extends org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return org.osate.xtext.aadl2.parsing.Aadl2DoubleClickStrategyProvider.class;
	}


	@Override
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return org.osate.xtext.aadl2.scoping.Aadl2GlobalScopeProvider.class;
	}


}
