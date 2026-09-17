/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Arrays;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.MemoryProperties;
import org.osate.xtext.aadl2.properties.validation.PropertiesValidator;

public class PropertiesQuickfixProvider extends DefaultQuickfixProvider {
	/**
	 * QuickFix for adding a required with statement for a referenced package or property set.
	 * The issue data array is expected to have three elements:
	 *
	 * issue.getData()[0]: The name of the package or property set
	 * issue.getData()[1]: The URI String of the referenced AadlPackage or PropertySet.
	 * issue.getData()[2]: The URI String of the Namespace where the with statement should be inserted.
	 */
	@Fix(PropertiesValidator.MISSING_WITH)
	public void fixMissingWith(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add '" + issue.getData()[0] + "' to the with clauses", null, null,
				(element, context) -> {
					var resourceSet = element.eResource().getResourceSet();
					var requiredModelUnit = (ModelUnit) resourceSet.getEObject(URI.createURI(issue.getData()[1]), true);
					var contextNS = (Namespace) resourceSet.getEObject(URI.createURI(issue.getData()[2]), true);
					EList<ModelUnit> imports;
					if (contextNS instanceof PropertySet propertySet) {
						imports = propertySet.getImportedUnits();
					} else {
						imports = ((PackageSection) contextNS).getImportedUnits();
					}
					imports.add(requiredModelUnit);
				});
	}

	/**
	 * QuickFix for swapping Upper and Lower bounds in a range value when the upper is less than the lower
	 */
	@Fix(PropertiesValidator.UPPER_LESS_THAN_LOWER)
	public void fixUpperLessThanLower(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Switch upper and lower bounds of the range", null, null, (element, context) -> {
			var range = (RangeValue) element;
			var oldMin = range.getMinimum();
			var oldMax = range.getMaximum();
			range.setMinimum(oldMax);
			range.setMaximum(oldMin);
		});
	}

	/**
	 * QuickFix for swapping Upper and Lower bounds in an array index range value when the upper is less than the lower
	 */
	@Fix(PropertiesValidator.ARRAY_RANGE_UPPER_LESS_THAN_LOWER)
	public void fixArrayRangeUpperLessThanLower(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Switch upper and lower bounds of the range", null, null, (element, context) -> {
			var range = (ArrayRange) element;
			var oldMin = range.getLowerBound();
			var oldMax = range.getUpperBound();
			range.setLowerBound(oldMax);
			range.setUpperBound(oldMin);
		});
	}

	/**
	 * QuickFix for changing Upper bounds in an array index range value to maximum allowed by dimension of the type
	 *
	 * issue.getData(0) = maximum dimension value;
	 */
	@Fix(PropertiesValidator.ARRAY_RANGE_UPPER_GREATER_THAN_MAXIMUM)
	public void fixArrayRangeUpperGreaterThanMaximum(Issue issue, IssueResolutionAcceptor acceptor) {
		var maxAllowed = Long.parseLong(issue.getData()[0]);
		acceptor.accept(issue,
				"Change upper bound of the range to maximum defined by type's dimension (" + maxAllowed + ")", null,
				null, (element, context) -> ((ArrayRange) element).setUpperBound(maxAllowed));
	}

	/**
	 * QuickFix for changing index in an array to maximum allowed by dimension of the type
	 *
	 * issue.getData(0) = maximum dimension value;
	 */
	@Fix(PropertiesValidator.ARRAY_INDEX_GREATER_THAN_MAXIMUM)
	public void fixArrayIndexGreaterThanMaximum(Issue issue, IssueResolutionAcceptor acceptor) {
		var maxAllowed = Long.parseLong(issue.getData()[0]);
		acceptor.accept(issue, "Change index of array to maximum defined by type's dimension (" + maxAllowed + ")",
				null, null, (element, context) -> ((ArrayRange) element).setLowerBound(maxAllowed));
	}

	/**
	 * QuickFix for changing Lower bound in an array index range from 1 to 0
	 */
	@Fix(PropertiesValidator.ARRAY_LOWER_BOUND_IS_ZERO)
	public void fixArrayRangeLowerBoundIsZero(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change '0' to '1'", null, null,
				(element, context) -> ((ArrayRange) element).setLowerBound(1));
	}

	/**
	 * QuickFix for making a negative delta positive
	 */
	@Fix(PropertiesValidator.DELTA_NEGATIVE)
	public void fixNegativeDelta(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make delta value positive", null, null, (element, context) -> {
			if (element instanceof IntegerLiteral integerLiteral) {
				integerLiteral.setValue(-integerLiteral.getValue());
			} else if (element instanceof RealLiteral realLiteral) {
				realLiteral.setValue(-realLiteral.getValue());
			}
		});
	}

	/**
	 * QuickFixes for adding unit
	 *
	 * issue.getData() unitTypeNames
	 */
	@Fix(PropertiesValidator.MISSING_NUMBERVALUE_UNITS)
	public void fixMissingUnits(Issue issue, IssueResolutionAcceptor acceptor) {
		var data = Arrays.asList(issue.getData()).iterator();
		while (data.hasNext()) {
			var utName = data.next();
			var nextUri = data.next();
			acceptor.accept(issue, "Add units '" + utName + "' to number", null, null, (element, context) -> {
				var resourceSet = element.eResource().getResourceSet();
				var unitLiteral = (UnitLiteral) resourceSet.getEObject(URI.createURI(nextUri), true);
				((NumberValue) element).setUnit(unitLiteral);
			});
		}
	}

	/**
	 * QuickFix for changing deprecate Byte_Count to Memory_Size
	 */
	@Fix(PropertiesValidator.BYTE_COUNT_DEPRECATED)
	public void fixDeprecatedByteCount(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace Byte_Count values with Memory_Size", null, null, (element, context) -> {
			var pa = (PropertyAssociation) element;
			var ownedValues = pa.getOwnedValues();
			pa.setProperty(
					Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.MEMORY_SIZE));
			for (var mpv : ownedValues) {
				if (mpv.getOwnedValue() instanceof NumberValue ownedVal) {
					ownedVal.setUnit(GetProperties.findUnitLiteral(pa, AadlProject.SIZE_UNITS,
							ownedVal.getUnit().getName()));
				}
			}
		});
	}

	/**
	 * QuickFix for changing deprecate Data_Volume to Data_Rate
	 */
	@Fix(PropertiesValidator.DATA_VOLUME_DEPRECATED)
	public void fixDeprecatedDataVolume(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace Data_Volume values with Data_Rate", null, null, (element, context) -> {
			var pa = (PropertyAssociation) element;
			var ownedValues = pa.getOwnedValues();
			pa.setProperty(Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(),
					CommunicationProperties.DATA_RATE));
			for (var mpv : ownedValues) {
				if (mpv.getOwnedValue() instanceof NumberValue ownedVal) {
					ownedVal.setUnit(GetProperties.findUnitLiteral(pa, AadlProject.DATA_RATE_UNITS,
							ownedVal.getUnit().getName()));
				}
			}
		});
	}

	/**
	 * QuickFix for changing deprecate SEI::Data_Rate to Data_Rate
	 */
	@Fix(PropertiesValidator.SEI_DATA_RATE_DEPRECATED)
	public void fixDeprecatedSEIDataRate(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace SEI::Data_Rate with SEI::Message_Rate", null, null, (element, context) -> {
			var pa = (PropertyAssociation) element;
			var ownedValues = pa.getOwnedValues();
			pa.setProperty(Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), "SEI::Message_Rate"));
			for (var mpv : ownedValues) {
				if (mpv.getOwnedValue() instanceof NumberValue ownedVal) {
					ownedVal.setUnit(GetProperties.findUnitLiteral(pa.getProperty(), ownedVal.getUnit().getName()));
				}
			}
		});
	}

	/**
	 * QuickFix for changing deprecate Source_Code_Size to Code_Size
	 */
	@Fix(PropertiesValidator.SOURCE_CODE_SIZE_DEPRECATED)
	public void fixDeprecatedSourceCodeSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace Source_Code_Size with Code_Size", null, null, (element, context) -> {
			var pa = (PropertyAssociation) element;
			pa.setProperty(
					Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.CODE_SIZE));
		});
	}

	/**
	 * QuickFix for changing deprecate Source_Data_Size to Data_Size
	 */
	@Fix(PropertiesValidator.SOURCE_DATA_SIZE_DEPRECATED)
	public void fixDeprecatedSourceDataSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace Source_Data_Size with Data_Size", null, null, (element, context) -> {
			var pa = (PropertyAssociation) element;
			pa.setProperty(
					Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.DATA_SIZE));
		});
	}

	/**
	 * QuickFix for changing deprecate Source_Heap_Size to Heap_Size
	 */
	@Fix(PropertiesValidator.SOURCE_HEAP_SIZE_DEPRECATED)
	public void fixDeprecatedSourceHeapSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace Source_Heap_Size with Heap_Size", null, null, (element, context) -> {
			var pa = (PropertyAssociation) element;
			pa.setProperty(
					Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.HEAP_SIZE));
		});
	}

	/**
	 * QuickFix for changing deprecate Source_Stack_Size to Stack_Size
	 */
	@Fix(PropertiesValidator.SOURCE_STACK_SIZE_DEPRECATED)
	public void fixDeprecatedSourceStackSize(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace Source_Stack_Size with Stack_Size", null, null, (element, context) -> {
			var pa = (PropertyAssociation) element;
			pa.setProperty(
					Aadl2GlobalScopeUtil.get(pa, Aadl2Package.eINSTANCE.getProperty(), MemoryProperties.STACK_SIZE));
		});
	}
}
