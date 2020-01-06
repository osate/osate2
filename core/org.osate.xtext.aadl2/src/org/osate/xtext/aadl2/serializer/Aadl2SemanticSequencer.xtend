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
package org.osate.xtext.aadl2.serializer

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.xtext.serializer.ISerializationContext
import org.eclipse.xtext.serializer.analysis.SerializationContext.RuleContext
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.FlowImplementation
import org.osate.aadl2.FlowKind
import org.osate.aadl2.FlowSpecification
import org.osate.annexsupport.AnnexRegistry
import org.osate.annexsupport.AnnexUnparserRegistry
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess

class Aadl2SemanticSequencer extends AbstractAadl2SemanticSequencer {

	@Inject
	Aadl2GrammarAccess grammarAccess

	package AnnexUnparserRegistry unparserRegistry

	def protected getAnnexUnparserRegistry() {
		unparserRegistry ?: (unparserRegistry = AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID) as AnnexUnparserRegistry)
	}

	override createSequence(ISerializationContext context, EObject semanticObject) {
		switch semanticObject {
			DefaultAnnexLibrary case context.parserRule == grammarAccess.annexLibraryRule || context.parserRule == grammarAccess.defaultAnnexLibraryRule: {
				val parsedLibrary = semanticObject.parsedAnnexLibrary
				val annexUnparser = annexUnparserRegistry.getAnnexUnparser(semanticObject.name)
				// serialize if there is an unparser and the annex has been parsed
				// otherwise use the original annex text
				if (parsedLibrary !== null && annexUnparser !== null) {
					try {
						performModification(semanticObject, new Runnable() {
							override run() {
								val text = '''{**«annexUnparser.unparseAnnexLibrary(parsedLibrary, "  ")»**}'''
								semanticObject.sourceText = text
							}
						})
					} catch (Exception e) {
						throw new RuntimeException('''Error while serializing «semanticObject.name» annex library''', e)
					}
				}
				sequence_DefaultAnnexLibrary(context, semanticObject)
			}
			DefaultAnnexSubclause case context.parserRule == grammarAccess.annexSubclauseRule || context.parserRule == grammarAccess.defaultAnnexSubclauseRule: {
				val parsedSubclause = semanticObject.parsedAnnexSubclause
				val annexUnparser = annexUnparserRegistry.getAnnexUnparser(semanticObject.name)
				// serialize if there is an unparser and the annex has been parsed
				// otherwise use the original annex text
				if (parsedSubclause !== null && annexUnparser !== null) {
					try {
						performModification(semanticObject, new Runnable() {
							override run() {
								val text = '''{**«annexUnparser.unparseAnnexSubclause(parsedSubclause, "  ")»**}'''
								semanticObject.sourceText = text
							}				
						})
					} catch (Exception e) {
						throw new RuntimeException('''Error while serializing «semanticObject.name» annex subclause''', e)
					}
				}
				sequence_DefaultAnnexSubclause(context, semanticObject)
			}
			default: super.createSequence(context, semanticObject)
		}
	}
	
	def protected performModification(EObject semanticObject, Runnable runnable) {
		val resourceSet = semanticObject?.eResource()?.getResourceSet()
		var TransactionalEditingDomain domain
		if(resourceSet !== null) {
			domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resourceSet);
		}
		
		if(domain === null) {
			runnable.run();
		} else {
			domain.commandStack.execute(new RecordingCommand(domain) {
				override protected doExecute() {
					runnable.run();
				}
			})
		}
				
		return domain
	} 
	
	override protected sequence_FlowPathSpec_FlowSinkSpec_FlowSourceSpec_FlowSpecRefinement(ISerializationContext context, FlowSpecification spec) {
		if (spec.refined !== null) {
			sequence_FlowSpecRefinement(new RuleContext(context, grammarAccess.flowSpecRefinementRule), spec)
		} else {
			switch(spec.kind) {
				case FlowKind.SOURCE:
					sequence_FlowSourceSpec(new RuleContext(context, grammarAccess.flowSourceSpecRule), spec)
				case FlowKind.PATH:
					sequence_FlowPathSpec(new RuleContext(context, grammarAccess.flowPathSpecRule), spec)
				case FlowKind.SINK:
					sequence_FlowSinkSpec(new RuleContext(context, grammarAccess.flowSinkSpecRule), spec)
			}
		}
	}
	
	override protected sequence_FlowPathImpl_FlowSinkImpl_FlowSourceImpl(ISerializationContext context, FlowImplementation impl) {
		switch(impl.kind) {
			case FlowKind.SOURCE:
				sequence_FlowSourceImpl(new RuleContext(context, grammarAccess.flowSourceImplRule), impl)
			case FlowKind.PATH:
				sequence_FlowPathImpl(new RuleContext(context, grammarAccess.flowPathImplRule), impl)
			case FlowKind.SINK:
				sequence_FlowSinkImpl(new RuleContext(context, grammarAccess.flowSinkImplRule), impl)
		}
	}
	
}