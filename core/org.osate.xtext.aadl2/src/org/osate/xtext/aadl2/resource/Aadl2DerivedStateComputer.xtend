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
import org.osate.annexsupport.AnnexUtil

// TODO: cache injectors per resource
@Singleton
class Aadl2DerivedStateComputer implements IDerivedStateComputer {

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
		try {
			while (allContents.hasNext) {
				val object = allContents.next as EObject
				val parent = object.eContainer
				if (!(parent instanceof AadlPackage)) {
					if (parent instanceof PackageSection) {
						if (object instanceof DefaultAnnexLibrary) {
							if (object.parsedAnnexLibrary !== null) {
								result += object.parsedAnnexLibrary
							}
							allContents.prune
						}
					} else if (parent instanceof Classifier) {
						if (object instanceof DefaultAnnexSubclause) {
							if (object.parsedAnnexSubclause !== null) {
								result += object.parsedAnnexSubclause
							}
						}
						allContents.prune
					} else if (parent !== null) {
						allContents.prune
					}
				}
			}
		} catch (IndexOutOfBoundsException e) {
		}
		result
	}

	static def collectInjectors(List<NamedElement> annexElements) {
		val names = new HashSet<String>
		val injectors = new ArrayList
		for (annex : annexElements) {
			if (!names.contains(annex.name)) {
				val annexParseResult = AnnexParseUtil.getParseResult(annex)
				if (annexParseResult !== null) {
					val injector = AnnexUtil.getInjector(annexParseResult)
					if(injector !== null) injectors += injector
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
