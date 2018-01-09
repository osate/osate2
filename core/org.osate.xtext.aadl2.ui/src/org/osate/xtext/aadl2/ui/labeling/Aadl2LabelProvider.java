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
import org.osate.aadl2.ComponentCategory;
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
import org.osate.aadl2.NamedElement;
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
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;

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

	String image(NamedElement ele) {
		String imgName;
		imgName = ele.eClass().getName() + ".gif";
//		OsateDebug.osateDebug("Aadl2LabelProvider", "image name=" + imgName + ";container=" + ele.eContainer());
		return imgName;
	}

	String image(PropertyAssociation ele) {
		String imgName;
		imgName = "PropertyAssociation.gif";
//		OsateDebug.osateDebug("Aadl2LabelProvider", "image name=" + imgName + ";container=" + ele.eContainer());
		return imgName;
	}

	String image(ListValue ele) {
		String imgName;
		imgName = "ListValue.gif";
		return imgName;
	}

	String image(PropertyType ele) {
//		OsateDebug.osateDebug("Aadl2LabelProvider", "PropertyType");
//		OsateDebug.osateDebug("Aadl2LabelProvider", "proptype");

		return "PropertyType.gif";
	}

	String image(AadlInteger ele) {
		return "PropertyType.gif";
	}

	String image(ComponentInstance ele) {
		String imgName;
		ComponentCategory cat;
		imgName = null;
		cat = ele.getCategory();
		if (cat != null) {
			String name = cat.getLiteral();
			int idx = name.indexOf(" ");
			if (idx < 0) {
				imgName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase() + ".gif";
			} else {
				imgName = name.substring(0, 1).toUpperCase() + name.substring(1, idx).toLowerCase()
						+ name.substring(idx + 1, idx + 2).toUpperCase() + name.substring(idx + 2).toLowerCase()
						+ ".gif";
			}
		}
		if (ele instanceof SystemInstance) {
			imgName = "System.gif";
		}
		if (imgName == null) {
			imgName = ele.eClass().getName() + ".gif";
		}
//		OsateDebug.osateDebug("Aadl2LabelProvider", "image name2=" + imgName);

		return imgName;
	}

}
