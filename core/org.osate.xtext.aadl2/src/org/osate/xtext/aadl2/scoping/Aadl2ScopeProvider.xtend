/*
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
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
package org.osate.xtext.aadl2.scoping;

import java.util.ArrayList
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.Scopes
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AccessType
import org.osate.aadl2.BehavioredImplementation
import org.osate.aadl2.CallContext
import org.osate.aadl2.CalledSubprogram
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.aadl2.Element
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.ModalElement
import org.osate.aadl2.PackageSection
import org.osate.aadl2.PrivatePackageSection
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.SubprogramCall
import org.osate.aadl2.SubprogramGroupAccess
import org.osate.aadl2.SubprogramGroupSubcomponent
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.eclipse.xtext.scoping.Scopes.scopeFor

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class Aadl2ScopeProvider extends PropertiesScopeProvider {
	//Reference is from TypeExtension in Aadl2.xtext
	def scope_TypeExtension_extended(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from ImplementationExtension and ComponentImplementationReference in Aadl2.xtext
	def scope_ComponentImplementation(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from GroupExtension in Aadl2.xtext
	def scope_GroupExtension_extended(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from FeatureGroupPrototype in Aadl2.xtext
	def scope_FeatureGroupPrototype_constrainingFeatureGroupType(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from FeatureGroupType in Aadl2.xtext
	def scope_FeatureGroupType_inverse(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from Realization in Aadl2.xtext
	def scope_Realization_implemented(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from SubprogramCall in Aadl2.xtext
	def scope_SubprogramCall_context(Element context, EReference reference) {
		var scope = scope_Classifier(context, reference)
		context.getContainerOfType(typeof(BehavioredImplementation))?.members.filter[it instanceof CallContext].scopeFor(scope) ?: scope
	}
	
	//Reference is from SubprogramCall in Aadl2.xtext
	def scope_SubprogramCall_calledSubprogram(Element context, EReference reference) {
		var scope = scope_Classifier(context, reference)
		val callContext = context.getContainerOfType(typeof(SubprogramCall))?.context
		if (callContext == null) {
			//No call context.  Add prototypes, subprogram accesses, and subprogram subcomponents from the classifier to the scope.
			scope = context.getContainerOfType(typeof(Classifier)).members.filter[it instanceof CalledSubprogram].scopeFor(scope)
		} else {
			scope = IScope::NULLSCOPE
			var Classifier callContextNamespace
			switch (callContext) {
				ComponentType: {
					//Reference is in the form of "component_type.implementation" or "package::component_type.implementation".  Add all implementations of the type from the type's package to the scope.
					val packageClassifiers = new ArrayList(callContext.getContainerOfType(typeof(AadlPackage)).publicSection.ownedClassifiers)
					val packageSectionForComponentType = callContext.getContainerOfType(typeof(PackageSection))
					if (packageSectionForComponentType instanceof PrivatePackageSection && packageSectionForComponentType == context.getContainerOfType(typeof(PrivatePackageSection))) {
						packageClassifiers.addAll(packageSectionForComponentType.ownedClassifiers)
					}
					scope = packageClassifiers.filter(typeof(CalledSubprogram)).filter(typeof(ComponentImplementation)).filter[type == callContext].scopeFor(
						[QualifiedName::create(name.substring(name.lastIndexOf('.') + 1))], IScope::NULLSCOPE
					)
					callContextNamespace = callContext
				}
				SubprogramGroupSubcomponent:
					callContextNamespace = callContext.componentType
				SubprogramGroupAccess:
					if (callContext.kind == AccessType::REQUIRES && callContext.subprogramGroupFeatureClassifier instanceof Classifier) {
						callContextNamespace = callContext.subprogramGroupFeatureClassifier as Classifier
					}
				FeatureGroup:
					callContextNamespace = callContext.featureGroupType
			}
			scope = callContextNamespace?.members.filter[it instanceof CalledSubprogram].scopeFor(scope) ?: scope
		}
		scope
	}
	
	//Reference is from Prototype in Aadl2.xtext
	def scope_ComponentPrototype_constrainingClassifier(Element element, EReference reference) {
		scope_Classifier(element, reference)
	}

	// mode references
	def scope_Mode(ModalElement context, EReference reference) {
		if (reference == Aadl2Package::eINSTANCE.modalElement_InMode) {
			val classifier = context.containingClassifier

			val modes = switch (classifier) {
				ComponentClassifier: classifier.allModes
				default: #[]
			}

			Scopes::scopeFor(modes)
		}
	}

	def scope_Mode(Subcomponent context, EReference reference) {
		switch reference {
			case Aadl2Package::eINSTANCE.modeBinding_DerivedMode: {
				val modes = context.classifier.allModes
				Scopes::scopeFor(modes)
			}
			case Aadl2Package::eINSTANCE.modeBinding_ParentMode: {
				val modes = context.containingComponentImpl.allModes
				Scopes::scopeFor(modes)
			}
		}
	}

	// subcomponent references
	def scope_Subcomponent(ComponentImplementation context, EReference reference) {
		val subcomponents = context.allSubcomponents
		Scopes::scopeFor(subcomponents)
	}
}
