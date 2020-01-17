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
package org.osate.xtext.aadl2.ui.labeling;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusImplementation;
import org.osate.aadl2.BusType;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.MemoryType;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupImplementation;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.VirtualBusImplementation;
import org.osate.aadl2.VirtualBusType;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.aadl2.instance.EndToEndFlowInstance;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 *
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class Aadl2LabelProvider extends AnnexAwareEObjectLabelProvider {

	@Inject
	public Aadl2LabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	String text(PropertyExpression pe) {

		if (pe instanceof BooleanLiteral) {
			return "boolean " + ((BooleanLiteral) pe).getValue() + "";
		}

		if (pe instanceof RealLiteral) {
			return "real " + ((RealLiteral) pe).getValue() + "";
		}

		if (pe instanceof IntegerLiteral) {
			return text((IntegerLiteral) pe);
		}

		if (pe instanceof StringLiteral) {
			return text((StringLiteral) pe);
		}

		if (pe instanceof NamedValue) {
			return text((NamedValue) pe);
		}

		if (pe instanceof ReferenceValue) {
			ReferenceValue rv = ((ReferenceValue) pe);
			List<ContainmentPathElement> cpe = rv.getContainmentPathElements();
			return "reference " + cpe.get(0).getNamedElement().getName();
		}

		if (pe instanceof RangeValue) {
			return text(((RangeValue) pe));
		}

		if (pe instanceof ListValue) {
			return text(((ListValue) pe));
		}

		if (pe instanceof RecordValue) {
			return text(((RecordValue) pe));
		}
//		OsateDebug.osateDebug("unknown pe=" + pe);
		return null;
	}

	// Labels and icons can be computed like this:

	String text(AadlPackage ele) {
		return "Package " + ele.getName();
	}

	String text(PublicPackageSection ele) {
		return "Package Public " + ele.getName();
	}

	String text(PrivatePackageSection ele) {
		return "Package Private " + ele.getName();
	}

	String text(SystemType ele) {
		return "System " + ele.getName();
	}

	String text(ProcessorType ele) {
		return "Processor " + ele.getName();
	}

	String text(DataType ele) {
		return "Data " + ele.getName();
	}

	String text(ProcessType ele) {
		return "Process " + ele.getName();
	}

	String text(ThreadGroupType ele) {
		return "Thread Group " + ele.getName();
	}

	String text(ThreadType ele) {
		return "Thread " + ele.getName();
	}

	String text(SubprogramType ele) {
		return "Subprogram " + ele.getName();
	}

	String text(SubprogramGroupType ele) {
		return "Subprogram Group " + ele.getName();
	}

	String text(AbstractType ele) {
		return "Abstract " + ele.getName();
	}

	String text(BusType ele) {
		return "Bus " + ele.getName();
	}

	String text(MemoryType ele) {
		return "Memory " + ele.getName();
	}

	String text(DeviceType ele) {
		return "Device " + ele.getName();
	}

	String text(VirtualBusType ele) {
		return "Virtual Bus " + ele.getName();
	}

	String text(VirtualProcessorType ele) {
		return "Virtual Processor " + ele.getName();
	}

	String text(SystemImplementation ele) {
		return "System Impl " + ele.getName();
	}

	String text(DataImplementation ele) {
		return "Data Impl " + ele.getName();
	}

	String text(ProcessorImplementation ele) {
		return "Processor Impl " + ele.getName();
	}

	String text(ProcessImplementation ele) {
		return "Process Impl " + ele.getName();
	}

	String text(ThreadGroupImplementation ele) {
		return "Thread Group Impl " + ele.getName();
	}

	String text(ThreadImplementation ele) {
		return "Thread Impl " + ele.getName();
	}

	String text(SubprogramImplementation ele) {
		return "Subprogram Impl " + ele.getName();
	}

	String text(SubprogramGroupImplementation ele) {
		return "Subprogram Group Impl " + ele.getName();
	}

	String text(AbstractImplementation ele) {
		return "Abstract Impl " + ele.getName();
	}

	String text(BusImplementation ele) {
		return "Bus Impl " + ele.getName();
	}

	String text(MemoryImplementation ele) {
		return "Memory Impl " + ele.getName();
	}

	String text(DeviceImplementation ele) {
		return "Device Impl " + ele.getName();
	}

	String text(VirtualBusImplementation ele) {
		return "Virtual Bus Impl " + ele.getName();
	}

	String text(VirtualProcessorImplementation ele) {
		return "Virtual Processor Impl " + ele.getName();
	}

	// Property set and properties
	String text(PropertySet ele) {
		return "Propertyset " + ele.getName();
	}

	String text(PropertyType ele) {
		if (ele.getName() == null) {
			return "Unnamed Property Type";
		}
		return "Property Type " + ele.getName();
	}

	String text(PropertyConstant ele) {
		return "Property Constant " + ele.getName();
	}

	String text(Property ele) {
		return "Property " + ele.getName();
	}

	String text(PropertyAssociation ele) {
		if (ele.getProperty() != null) {
			return "Property " + ele.getProperty().getName();
		}
		return "Property";
	}

	String text(AnnexSubclause as) {

		String ret;

		ret = "Annex";

		if (as.getName() != null) {
			ret += " " + as.getName();
		}
		return ret;
	}

	String text(BasicPropertyAssociation ele) {
		String val;
		String ret;

		val = null;
		ret = "Basic Property Association";
		if (ele.eContainer() instanceof RecordValue) {
//			OsateDebug.osateDebug("val=" + ele.getValue());
			ret = "Field " + ele.getProperty().getName();

			val = text(ele.getValue());
			if (val != null) {
				ret += ": " + val;
			}
		}
		return ret;
	}

	String text(ModalPropertyValue ele) {
		EList<Mode> ml = ele.getInModes();
		String label = "";
		if (ml.isEmpty()) {
			label = "Non-Modal Value";

//			OsateDebug.osateDebug("non modal value" + ele.getOwnedValue());
			if ((ele.getOwnedValue() != null) && (!(ele.getOwnedValue() instanceof RangeValue))
					&& (!(ele.getOwnedValue() instanceof RecordValue))
					&& (!(ele.getOwnedValue() instanceof ListValue))) {
				label += " " + text(ele.getOwnedValue());
			}

		} else {
			String modes = "";
			for (Mode m : ml) {
				modes = modes + " " + m.getName();
			}

			label = "Modal property value (" + modes + ")";
		}
		return label;
	}

	// these next ones we need only if we go deeper than classifiers
	String text(SystemSubcomponent ele) {
		return "System Subcomponent " + ele.getName();
	}

	String text(DataSubcomponent ele) {
		return "Data Subcomponent " + ele.getName();
	}

	String text(EventPort ele) {
		return "Event Port " + ele.getName();
	}

	String text(DataPort ele) {
		return "Data Port " + ele.getName();
	}

	String text(EventDataPort ele) {
		return "Event Data Port " + ele.getName();
	}

	String text(FeatureGroup ele) {
		return "Feature Group " + ele.getName();
	}

	String text(Feature ele) {
		return "Feature " + ele.getName();
	}

	String text(FlowImplementation flowimpl) {
		String ret;

		ret = "Flow Implementation";
		if (flowimpl.getName() != null) {
			ret += " " + flowimpl.getName();
		}
		return ret;
	}

	String text(EndToEndFlow etei) {
		String ret;

		ret = "End to End Flow";
		if (etei.getName() != null) {
			ret += " " + etei.getName();
		}
		return ret;
	}

	String text(EndToEndFlowInstance etei) {
		String ret;

		ret = "End to End Flow";
		if (etei.getName() != null) {
			ret += " " + etei.getName();
		}
		return ret;
	}

	String text(FlowSpecification flowspec) {
		String ret;

		ret = "Flow Specification";
		if (flowspec.getName() != null) {
			ret += " " + flowspec.getName();
		}
		return ret;
	}

//	String text(FlowEnd flowEnd) {
//
//		return "flowend";
//	}

	String text(BusAccess ele) {
		return ele.getKind().getName() + " Bus Access " + ele.getName();
	}

	String text(DataAccess ele) {
		return ele.getKind().getName() + " Data Access " + ele.getName();
	}

	String text(SubprogramAccess ele) {
		return ele.getKind().getName() + " Subprogram Access " + ele.getName();
	}

	String text(Mode ele) {
		return "Mode " + ele.getName();
	}

	String text(ModeTransition ele) {
		return "Mode Transition " + ele.getSource().getName() + " -> " + ele.getDestination().getName();
	}

	String text(NamedValue ele) {
		String ret;
		ret = "unknown value";

		if (ele.getNamedValue() instanceof EnumerationLiteral) {
			EnumerationLiteral el;
			el = (EnumerationLiteral) ele.getNamedValue();
			ret = el.getName();
		}
		return ret;
	}

	String text(IntegerLiteral ele) {
		String val;

		val = "" + ele.getValue();
		if (ele.getUnit() != null) {
			val += ele.getUnit().getName();
		}
		return val;
	}

	String text(RealLiteral ele) {
		String val;

		val = "" + ele.getValue();
		if (ele.getUnit() != null) {
			val += ele.getUnit().getName();
		}
		return val;
	}

	String text(BooleanLiteral ele) {
		return "" + ele.getValue();
	}

	String text(ContainedNamedElement ele) {
		String ret;

		if (ele.eContainer() instanceof PropertyAssociation) {
			ret = "Applies to: ";
		} else {
			ret = "Contained Named Element: ";
		}

		for (ContainmentPathElement cpe : ele.getContainmentPathElements()) {
			ret += cpe.getNamedElement().getName();
		}

		return ret;
	}

	String text(StringLiteral sl) {
		return "" + sl.getValue();
	}

	String text(ListValue ele) {
		return "List Value";
	}

	String text(RecordValue ele) {
		return "Record";
	}

	String text(RangeValue ele) {
		RangeValue rv;

		rv = ele;

//		OsateDebug.osateDebug("bla" + rv.getMaximumValue().getUnit().getName());

		return "range (" + text(rv.getMinimumValue()) + " .. " + text(rv.getMaximumValue()) + ")";
	}

	String text(NumberValue ele) {
		if (ele instanceof AadlInteger) {
			return text((AadlInteger) ele);
		}
		if (ele instanceof AadlReal) {
			return text((AadlReal) ele);
		}
		if (ele instanceof IntegerLiteral) {
			return text((IntegerLiteral) ele);
		}
		if (ele instanceof NamedValue) {
			return text((NamedValue) ele);
		}
		if (ele instanceof StringLiteral) {
			return text((StringLiteral) ele);
		}
		if (ele instanceof RealLiteral) {
			return text((RealLiteral) ele);
		}
		return "unknown number " + ele;
	}

	String text(AadlInteger ele) {
		return "Property Type " + ele.getName();
	}

	String text(AadlReal ele) {
		return "Property Type " + ele.getName();
	}

}
