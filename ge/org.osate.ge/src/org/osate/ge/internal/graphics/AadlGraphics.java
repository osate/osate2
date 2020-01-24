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
package org.osate.ge.internal.graphics;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AccessCategory;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Mode;
import org.osate.aadl2.PortCategory;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.BusGraphicBuilder;
import org.osate.ge.graphics.internal.DeviceGraphicBuilder;
import org.osate.ge.graphics.internal.FeatureGraphic;
import org.osate.ge.graphics.internal.FeatureGraphicBuilder;
import org.osate.ge.graphics.internal.FeatureGraphicType;
import org.osate.ge.graphics.internal.FeatureGroupTypeGraphicBuilder;
import org.osate.ge.graphics.internal.FlowIndicatorBuilder;
import org.osate.ge.graphics.internal.MemoryGraphicBuilder;
import org.osate.ge.graphics.internal.ModeGraphicBuilder;
import org.osate.ge.graphics.internal.OrthogonalLineBuilder;
import org.osate.ge.graphics.internal.ParallelogramBuilder;
import org.osate.ge.graphics.internal.ProcessorGraphicBuilder;

/**
 * Helper class for retrieving the appropriate graphic for an AADL element
 *
 */
public class AadlGraphics {
	private static final Graphic defaultGraphic = RectangleBuilder.create().build(); // Fallback graphic when a specialized graphic is not supported
	private static final Graphic abstractGraphic = RectangleBuilder.create().build();
	private static final Graphic busGraphic = BusGraphicBuilder.create().build();
	private static final Graphic dataGraphic = RectangleBuilder.create().build();
	private static final Graphic deviceGraphic = DeviceGraphicBuilder.create().build();
	private static final Graphic memoryGraphic = MemoryGraphicBuilder.create().build();
	private static final Graphic processGraphic = ParallelogramBuilder.create().horizontalOffset(20).build();
	private static final Graphic processorGraphic = ProcessorGraphicBuilder.create().build();
	private static final Graphic subprogramGraphic = EllipseBuilder.create().build();
	private static final Graphic subprogramGroupGraphic = EllipseBuilder.create().build();
	private static final Graphic systemGraphic = RectangleBuilder.create().rounded().build();
	private static final Graphic threadGraphic = ParallelogramBuilder.create().horizontalOffset(20).build();
	private static final Graphic threadGroupGraphic = RectangleBuilder.create().rounded().build();
	private static final Graphic virtualBusGraphic = BusGraphicBuilder.create().build();
	private static final Graphic virtualProcessorGraphic = ProcessorGraphicBuilder.create().build();
	private static final Graphic featureGroupTypeGraphic = FeatureGroupTypeGraphicBuilder.create().build();
	private static final Graphic flowSourceGraphic = FlowIndicatorBuilder.create()
			.sourceTerminator(ArrowBuilder.create().small().build())
			.destinationTerminator(OrthogonalLineBuilder.create().build()).build();
	private static final Graphic flowSinkGraphic = FlowIndicatorBuilder.create()
			.sourceTerminator(ArrowBuilder.create().small().reverse().build())
			.destinationTerminator(OrthogonalLineBuilder.create().build()).build();
	private static final Graphic flowPathGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().build()).build();
	private static final Graphic initialModeGraphic = ModeGraphicBuilder.create().initialMode().build();
	private static final Graphic modeGraphic = ModeGraphicBuilder.create().build();
	private static final Graphic modeTransitionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().build()).build();
	private static final Style topCenteredLabelStyle = StyleBuilder.create().labelsTop().labelsHorizontalCenter()
			.build();
	private final static Style dashedStyle = StyleBuilder.create(topCenteredLabelStyle).dashed().build();
	private final static Style implStyle = StyleBuilder.create(topCenteredLabelStyle).lineWidth(4.0).build();
	private final static Style dashedImplStyle = StyleBuilder.create(dashedStyle, implStyle).build();

	public static Graphic getGraphic(final Classifier classifier) {
		if(classifier instanceof ComponentClassifier) {
			return getGraphic((ComponentClassifier)classifier);
		} else if(classifier instanceof FeatureGroupType) {
			return featureGroupTypeGraphic;
		}

		return defaultGraphic;
	}

	public static Style getStyle(final Classifier classifier) {
		if (classifier instanceof ComponentClassifier) {
			return getStyle((ComponentClassifier) classifier);
		}

		return topCenteredLabelStyle;
	}

	public static FeatureGraphic getFeatureGraphic(final EClass featureClass, DirectionType direction) {
		final FeatureGraphicBuilder builder = FeatureGraphicBuilder.create();

		// Configure the feature type
		final Aadl2Package aadl2Pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		if(featureClass == aadl2Pkg.getAbstractFeature()) {
			builder.abstractFeature();
		} else if(featureClass == aadl2Pkg.getEventPort()) {
			builder.eventPort();
		} else if(featureClass == aadl2Pkg.getDataPort() || featureClass == aadl2Pkg.getParameter()) {
			builder.dataPort();
		} else if(featureClass == aadl2Pkg.getEventDataPort()) {
			builder.eventDataPort();
		} else if(featureClass == aadl2Pkg.getSubprogramAccess()) {
			builder.subprogramAccess();
		} else if(featureClass == aadl2Pkg.getSubprogramGroupAccess()) {
			builder.subprogramGroupAccess();
		} else if(featureClass == aadl2Pkg.getDataAccess()) {
			builder.dataAccess();
		} else if(featureClass == aadl2Pkg.getBusAccess()) {
			builder.busAccess();
		} else if(featureClass == aadl2Pkg.getFeatureGroup()) {
			builder.featureGroup();
		} else if(featureClass == aadl2Pkg.getPortProxy()) {
			builder.portProxy();
		} else if(featureClass == aadl2Pkg.getEventSource()) {
			builder.eventSource();
		} else if(featureClass == aadl2Pkg.getEventDataSource()) {
			builder.eventDataSource();
		} else if(featureClass == aadl2Pkg.getSubprogramProxy()) {
			builder.subprogramProxy();
		}

		switch(direction) {
		case IN:
			builder.input();
			break;

		case OUT:
			builder.output();
			break;

		case IN_OUT:
			builder.bidirectional();
			break;
		}

		return builder.build();
	}

	public static String getFeatureAnnotation(final EClass featureClass) {
		final Aadl2Package aadl2Pkg = Aadl2Factory.eINSTANCE.getAadl2Package();
		if (aadl2Pkg.getProcessorFeature().isSuperTypeOf(featureClass)) {
			return "<processor>";
		} else if (aadl2Pkg.getInternalFeature().isSuperTypeOf(featureClass)) {
			return "<internal>";
		}

		return null;
	}

	public static Color getDefaultBackgroundColor(final FeatureGraphicType featureGraphicType) {
		if (featureGraphicType == FeatureGraphicType.SUBPROGRAM_ACCESS
				|| featureGraphicType == FeatureGraphicType.BUS_OR_DATA_ACCESS) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}

	public static FeatureGraphic getFeatureGraphic(final PortCategory portCategory, final DirectionType direction) {
		final FeatureGraphicBuilder builder = FeatureGraphicBuilder.create();

		switch(portCategory) {
		case DATA:
			builder.dataPort();
			break;

		case EVENT:
			builder.eventPort();
			break;

		case EVENT_DATA:
			builder.eventDataPort();
			break;

		default:
		}

		switch(direction) {
		case IN:
			builder.input();
			break;

		case OUT:
			builder.output();
			break;

		case IN_OUT:
			builder.bidirectional();
			break;
		}

		return builder.build();
	}

	public static FeatureGraphic getFeatureGraphic(final AccessCategory accessCategory, final DirectionType direction) {
		final FeatureGraphicBuilder builder = FeatureGraphicBuilder.create();

		switch(accessCategory) {
		case BUS:
			builder.busAccess();
			break;

		case DATA:
			builder.dataAccess();
			break;

		case SUBPROGRAM:
			builder.subprogramAccess();
			break;

		case SUBPROGRAM_GROUP:
			builder.subprogramGroupAccess();
			break;

		default:
			break;
		}

		switch(direction) {
		case IN:
			builder.input();
			break;

		case OUT:
			builder.output();
			break;

		case IN_OUT:
			builder.bidirectional();
			break;
		}

		return builder.build();
	}

	private static Graphic getGraphic(final ComponentClassifier cc) {
		return getGraphic(cc.getCategory());
	}

	public static Graphic getGraphic(final ComponentCategory cc) {
		switch(cc) {
		case ABSTRACT:
			return abstractGraphic;

		case BUS:
			return busGraphic;

		case DATA:
			return dataGraphic;

		case DEVICE:
			return deviceGraphic;

		case MEMORY:
			return memoryGraphic;

		case PROCESS:
			return processGraphic;

		case PROCESSOR:
			return processorGraphic;

		case SUBPROGRAM:
			return subprogramGraphic;

		case SUBPROGRAM_GROUP:
			return subprogramGroupGraphic;

		case SYSTEM:
			return systemGraphic;

		case THREAD:
			return threadGraphic;

		case THREAD_GROUP:
			return threadGroupGraphic;

		case VIRTUAL_BUS:
			return virtualBusGraphic;

		case VIRTUAL_PROCESSOR:
			return virtualProcessorGraphic;

		default:
			return defaultGraphic;
		}
	}

	public static Graphic getModeGraphic(final Mode mode) {
		return mode.isInitial() ? initialModeGraphic : modeGraphic;
	}

	public static Graphic getModeTransitionGraphic() {
		return modeTransitionGraphic;
	}

	public static Graphic getFlowSpecificationGraphic(final FlowSpecification fs) {
		switch (fs.getKind()) {
		case PATH:
			return flowPathGraphic;

		case SOURCE:
			return flowSourceGraphic;

		case SINK:
			return flowSinkGraphic;

		default:
			return null;
		}
	}

	private static Style getStyle(final ComponentClassifier cc) {
		return getStyle(cc.getCategory(), cc instanceof ComponentImplementation);
	}

	public static Style getStyle(final ComponentCategory cc, final boolean isImplementation) {
		final boolean isDashed = cc == ComponentCategory.ABSTRACT || cc == ComponentCategory.THREAD || cc == ComponentCategory.THREAD_GROUP
				|| cc == ComponentCategory.SUBPROGRAM_GROUP || cc == ComponentCategory.VIRTUAL_BUS
				|| cc == ComponentCategory.VIRTUAL_PROCESSOR;

		if (isImplementation) {
			return isDashed ? dashedImplStyle : implStyle;
		} else {
			return isDashed ? dashedStyle : topCenteredLabelStyle;
		}

	}
}
