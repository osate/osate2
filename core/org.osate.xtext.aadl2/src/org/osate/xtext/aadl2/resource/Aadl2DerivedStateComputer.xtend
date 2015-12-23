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

		if(grammar instanceof Grammar) (grammar as Grammar).name else null
	}

}
