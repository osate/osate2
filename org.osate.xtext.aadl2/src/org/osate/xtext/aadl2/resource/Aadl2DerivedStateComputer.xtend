/*
 * /**
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

package org.osate.xtext.aadl2.resource;

import com.google.inject.ConfigurationException
import com.google.inject.Singleton
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.DerivedStateAwareResource
import org.eclipse.xtext.resource.IDerivedStateComputer
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.Classifier
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.NamedElement
import org.osate.aadl2.PackageSection
import org.osate.annexsupport.AnnexParseUtil
import org.osate.core.OsateCorePlugin

// TODO: cache injectors per resource
@Singleton
public class Aadl2DerivedStateComputer implements IDerivedStateComputer {

	override installDerivedState(DerivedStateAwareResource resource, boolean preLinkingPhase) {
		val annexElements = resource.allAnnexElements
		val injectors = collectInjectors(annexElements)

		for (injector : injectors) {
			try {
				val dsc = injector.getInstance(IDerivedStateComputer)
				dsc.installDerivedState(resource, preLinkingPhase)
			} catch (ConfigurationException e) {
				// ignore: no derived state for this annex
			}
		}
	}

	override discardDerivedState(DerivedStateAwareResource resource) {
		val annexElements = resource.allAnnexElements
		val injectors = collectInjectors(annexElements)

		injectors.forEach [ injector |
			try {
				injector.getInstance(IDerivedStateComputer).discardDerivedState(resource)
			} catch (ConfigurationException e) {
				// ignore: no derived state for this annex
			}
		]
	}

	static def getAllAnnexElements(Resource resource) {
		val allContents = EcoreUtil.getAllContents(resource, false)
		val result = new ArrayList<NamedElement>
		while (allContents.hasNext) {
			val object = allContents.next as EObject
			val parent = object.eContainer
			if (!(parent instanceof AadlPackage)) {
				if (parent instanceof PackageSection) {
					if (object instanceof DefaultAnnexLibrary) {
						if (object.parsedAnnexLibrary != null) {
							result += object.parsedAnnexLibrary
						}
						allContents.prune
					}
				} else if (parent instanceof Classifier) {
					if (object instanceof DefaultAnnexSubclause) {
						if (object.parsedAnnexSubclause != null) {
							result += object.parsedAnnexSubclause
						}
					}
					allContents.prune
				} else if (parent != null) {
					allContents.prune
				}
			}
		}
		result
	}

	static def collectInjectors(List<NamedElement> annexElements) {
		val names = new HashSet<String>
		val injectors = new ArrayList
		for (annex : annexElements) {
			if (!names.contains(annex.name)) {
				val annexParseResult = AnnexParseUtil.getParseResult(annex)
				if (annexParseResult != null) {
					val grammarName = getGrammarName(annexParseResult.rootNode)
					val injector = OsateCorePlugin.getDefault().getInjector(grammarName)
					if(injector != null) injectors += injector
					names += annex.name
				}
			}
		}
		injectors
	}

	static def getGrammarName(INode node) {
		val grammarResource = node.grammarElement.eResource()
		val grammar = grammarResource.contents.head

		if(grammar instanceof Grammar) grammar.name else null
	}

}
