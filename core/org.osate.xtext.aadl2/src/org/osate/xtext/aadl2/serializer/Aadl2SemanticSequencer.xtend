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