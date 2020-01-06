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

package org.osate.xtext.aadl2.properties.ui.quickfix;

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.ArrayRange
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.Namespace
import org.osate.aadl2.NumberValue
import org.osate.aadl2.PackageSection
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertySet
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RealLiteral
import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil
import org.osate.xtext.aadl2.properties.util.AadlProject
import org.osate.xtext.aadl2.properties.util.CommunicationProperties
import org.osate.xtext.aadl2.properties.util.GetProperties
import org.osate.xtext.aadl2.properties.util.MemoryProperties
import org.osate.xtext.aadl2.properties.validation.PropertiesJavaValidator

class PropertiesQuickfixProvider extends DefaultQuickfixProvider {
	/**
	 * QuickFix for adding a required with statement for a referenced package or property set.
	 * The issue data array is expected to have three elements:
	 * 
	 * issue.getData()[0]: The name of the package or property set
	 * issue.getData()[1]: The URI String of the referenced AadlPackage or PropertySet.
	 * issue.getData()[2]: The URI String of the Namespace where the with statement should be inserted.
	 */
	@Fix(PropertiesJavaValidator.MISSING_WITH)
	def void fixMissingWith(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add '" + issue.getData.get(0) + "' to the with clauses", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val ResourceSet resourceSet = element.eResource().getResourceSet();
					val ModelUnit requiredModelUnit = resourceSet.getEObject(
						URI.createURI(issue.getData.get(1)), true) as ModelUnit;
					val Namespace contextNS = resourceSet.getEObject(URI.createURI(issue.getData().get(2)),
						true) as Namespace;
					var EList<ModelUnit> imports;
					if (contextNS instanceof PropertySet) {
						imports = contextNS.getImportedUnits();
					} else {
						imports = (contextNS as PackageSection).getImportedUnits();
					}
					imports.add(requiredModelUnit);
				}
			});
	}

	/**
	 * QuickFix for swapping Upper and Lower bounds in a range value when the upper is less than the lower
	 */
	@Fix(PropertiesJavaValidator.UPPER_LESS_THAN_LOWER)
	def void fixUpperLessThanLower(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Switch upper and lower bounds of the range", null, null, new ISemanticModification() {
			override void apply(EObject element, IModificationContext context) throws Exception {
				var oldMin = (element as RangeValue).minimum
				var oldMax = (element as RangeValue).maximum;
				(element as RangeValue).minimum = oldMax;
				(element as RangeValue).maximum = oldMin;
			}
		});
	}

	/**
	 * QuickFix for swapping Upper and Lower bounds in an array index range value when the upper is less than the lower
	 */
	@Fix(PropertiesJavaValidator.ARRAY_RANGE_UPPER_LESS_THAN_LOWER)
	def void fixArrayRangeUpperLessThanLower(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Switch upper and lower bounds of the range", null, null, new ISemanticModification() {
			override void apply(EObject element, IModificationContext context) throws Exception {
				var oldMin = (element as ArrayRange).lowerBound
				var oldMax = (element as ArrayRange).upperBound;
				(element as ArrayRange).lowerBound = oldMax;
				(element as ArrayRange).upperBound = oldMin
			}
		});
	}

	/**
	 * QuickFix for changing Upper bounds in an array index range value to maximum allowed by dimension of the type
	 * 
	 * issue.getData(0) = maximum dimension value;
	 */
	@Fix(PropertiesJavaValidator.ARRAY_RANGE_UPPER_GREATER_THAN_MAXIMUM)
	def void fixArrayRangeUpperGreaterThanMaximum(Issue issue, IssueResolutionAcceptor acceptor) {
		val maxAllowed = Long.valueOf(issue.data.head);
		acceptor.accept(issue,
			"Change upper bound of the range to maximum defined by type's dimension (" + maxAllowed + ")", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					(element as ArrayRange).upperBound = maxAllowed
				}
			});
	}

	/**
	 * QuickFix for changing index in an array to maximum allowed by dimension of the type
	 * 
	 * issue.getData(0) = maximum dimension value;
	 */
	@Fix(PropertiesJavaValidator.ARRAY_INDEX_GREATER_THAN_MAXIMUM)
	def void fixArrayIndexGreaterThanMaximum(Issue issue, IssueResolutionAcceptor acceptor) {
		val maxAllowed = Long.valueOf(issue.data.head);
		acceptor.accept(issue, "Change index of array to maximum defined by type's dimension (" + maxAllowed + ")",
			null, null, new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					(element as ArrayRange).lowerBound = maxAllowed
				}
			});
	}

	/**
	 * QuickFix for changing Lower bound in an array index range from 1 to 0
	 */
	@Fix(PropertiesJavaValidator.ARRAY_LOWER_BOUND_IS_ZERO)
	def void fixArrayRangeLowerBoundIsZero(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change '0' to '1'", null, null, new ISemanticModification() {
			override void apply(EObject element, IModificationContext context) throws Exception {
				(element as ArrayRange).lowerBound = 1
			}
		});
	}

	/**
	 * QuickFix for making a negative delta positive
	 */
	@Fix(PropertiesJavaValidator.DELTA_NEGATIVE)
	def void fixNegativeDelta(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make delta value positive", null, null, new ISemanticModification() {
			override void apply(EObject element, IModificationContext context) throws Exception {
				switch element {
					IntegerLiteral: element.value = -(element.value)
					RealLiteral: element.value = -(element.value)
				}
			}
		});
	}

	/**
	 * QuickFixes for adding unit
	 * 
	 * 	 * issue.getData() unitTypeNames
	 */
	@Fix(PropertiesJavaValidator.MISSING_NUMBERVALUE_UNITS)
	def void fixMissingUnits(Issue issue, IssueResolutionAcceptor acceptor) {

		val iter = issue.data.iterator
		while (iter.hasNext) {
			val utName = iter.next
			val nextUri = iter.next
			acceptor.accept(
				issue,
				"Add units '" + utName + "' to number",
				null,
				null,
				new ISemanticModification() {
					override void apply(EObject element, IModificationContext context) throws Exception {
						val ResourceSet resourceSet = element.eResource().getResourceSet();
						val UnitLiteral unitLiteral = resourceSet.getEObject(URI.createURI(nextUri),
							true) as UnitLiteral;
						(element as NumberValue).unit = unitLiteral
					}
				}
			);
		}
	}

	/**
	 * QuickFix for changing deprecate Byte_Count to Memory_Size
	 */
	@Fix(PropertiesJavaValidator.BYTE_COUNT_DEPRECATED)
	def void fixDeprecatedByteCount(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Replace Byte_Count values with Memory_Size",
			null,
			null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val pa = (element as PropertyAssociation)
					val ownedValues = pa.ownedValues
					pa.property = Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.MEMORY_SIZE)
					for (ModalPropertyValue mpv : ownedValues) {
						val ownedVal = mpv.ownedValue
						switch ownedVal {
							NumberValue:
								ownedVal.unit = GetProperties.findUnitLiteral(pa, AadlProject.SIZE_UNITS,
									ownedVal.unit.name)
						}
					}
				}
			}
		)
	}

	/**
	 * QuickFix for changing deprecate Data_Volume to Data_Rate
	 */
	@Fix(PropertiesJavaValidator.DATA_VOLUME_DEPRECATED)
	def void fixDeprecatedDataVolume(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Replace Data_Volume values with Data_Rate",
			null,
			null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val pa = (element as PropertyAssociation)
					val ownedValues = pa.ownedValues
					pa.property = Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), CommunicationProperties.DATA_RATE)
					for (ModalPropertyValue mpv : ownedValues) {
						val ownedVal = mpv.ownedValue
						switch ownedVal {
							NumberValue:
								ownedVal.unit = GetProperties.findUnitLiteral(pa, AadlProject.DATA_RATE_UNITS,
									ownedVal.unit.name)
						}
					}
				}
			}
		)
	}

	/**
	 * QuickFix for changing deprecate SEI::Data_Rate to Data_Rate
	 */
	@Fix(PropertiesJavaValidator.SEI_DATA_RATE_DEPRECATED)
	def void fixDeprecatedSEIDataRate(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Replace SEI::Data_Rate with SEI::Message_Rate",
			null,
			null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val pa = (element as PropertyAssociation)
					val ownedValues = pa.ownedValues
					pa.property = Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), "SEI::Message_Rate")
					for (ModalPropertyValue mpv : ownedValues) {
						val ownedVal = mpv.ownedValue
						switch ownedVal {
							NumberValue: ownedVal.unit = GetProperties.findUnitLiteral(pa.property, ownedVal.unit.name)
						}
					}
				}
			}
		)
	}

	/**
	 * QuickFix for changing deprecate Source_Code_Size to Code_Size
	 */
	@Fix(PropertiesJavaValidator.SOURCE_CODE_SIZE_DEPRECATED)
	def void fixDeprecatedSourceCodeSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Replace Source_Code_Size with Code_Size",
			null,
			null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val pa = (element as PropertyAssociation)
					pa.property = Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.CODE_SIZE)
				}
			}
		)
	}

	/**
	 * QuickFix for changing deprecate Source_Data_Size to Data_Size
	 */
	@Fix(PropertiesJavaValidator.SOURCE_DATA_SIZE_DEPRECATED)
	def void fixDeprecatedSourceDataSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Replace Source_Data_Size with Data_Size",
			null,
			null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val pa = (element as PropertyAssociation)
					pa.property = Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.DATA_SIZE)
				}
			}
		)
	}

	/**
	 * QuickFix for changing deprecate Source_Heap_Size to Heap_Size
	 */
	@Fix(PropertiesJavaValidator.SOURCE_HEAP_SIZE_DEPRECATED)
	def void fixDeprecatedSourceHeapSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Replace Source_Heap_Size with Heap_Size",
			null,
			null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val pa = (element as PropertyAssociation)
					pa.property = Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.HEAP_SIZE)
				}
			}
		)
	}

	/**
	 * QuickFix for changing deprecate Source_Stack_Size to Stack_Size
	 */
	@Fix(PropertiesJavaValidator.SOURCE_STACK_SIZE_DEPRECATED)
	def void fixDeprecatedSourceStackSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(
			issue,
			"Replace Source_Stack_Size with Stack_Size",
			null,
			null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val pa = (element as PropertyAssociation)
					pa.property = Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.STACK_SIZE)
				}
			}
		)
	}

}
