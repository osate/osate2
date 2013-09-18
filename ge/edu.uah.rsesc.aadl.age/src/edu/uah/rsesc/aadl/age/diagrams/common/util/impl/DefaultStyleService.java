package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import org.eclipse.graphiti.mm.algorithms.styles.Style;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.ui.PlatformUI;

import edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService;
import edu.uah.rsesc.aadl.age.styles.StyleProvider;

// TODO: Consider removing class
public class DefaultStyleService implements StyleService {	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getStyle(org.eclipse.graphiti.mm.pictograms.Diagram, java.lang.String)
	 */
	@Override
	public Style getStyle(final Diagram diagram, final String styleId) {
		final StyleProvider styleProvider = (StyleProvider)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(StyleProvider.class);
		return styleProvider.getStyle(diagram, styleId);
	}
	
	private Style getImplementationStyleConditionally(final Diagram diagram, final String styleId, final boolean getImplementation) {
		final String finalStyleId = getImplementation ? (styleId + "-implementation") : styleId;
		return getStyle(diagram, finalStyleId);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSystemStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getSystemStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "system", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getProcessStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getProcessStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "process", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getThreadGroupStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getThreadGroupStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "thread-group", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getThreadStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getThreadStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "thread", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getSubprogramStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "subprogram", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramGroupStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getSubprogramGroupStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "subprogram-group", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getDataStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getDataStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "data", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getAbstractStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getAbstractStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "abstract", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getVirtualBusStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getVirtualBusStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "virtual-bus", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getVirtualProcessorStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getVirtualProcessorStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "virtual-processor", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getBusStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getBusStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "bus", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getProcessorStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getProcessorStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "processor", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getDeviceStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getDeviceStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "device", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getMemoryStyle(org.eclipse.graphiti.mm.pictograms.Diagram, boolean)
	 */
	@Override
	public Style getMemoryStyle(final Diagram diagram, final boolean isImplementation) {
		return getImplementationStyleConditionally(diagram, "memory", isImplementation);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureGroupStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureGroupStyle(final Diagram diagram) {
		return getImplementationStyleConditionally(diagram, "feature-group", false);
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getShadedStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getShadedStyle(final Diagram diagram) {
		return getStyle(diagram, "shaded");
	}
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getImplementsStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getImplementsStyle(final Diagram diagram) {
		return getStyle(diagram, "implements");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFlowSpecificationStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFlowSpecificationStyle(final Diagram diagram) {
		return getStyle(diagram, "flow_specification");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getExtendsStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getExtendsStyle(final Diagram diagram) {
		return getStyle(diagram, "extends");
    }	
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getGeneralizationArrowHeadStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getGeneralizationArrowHeadStyle(final Diagram diagram) {
		return getStyle(diagram, "generalization-arrowhead");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getDecoratorStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getDecoratorStyle(final Diagram diagram) {
		return getStyle(diagram, "decorator");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getModeTransitionTrigger(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getModeTransitionTrigger(final Diagram diagram) {
		return getStyle(diagram, "mode_transition_trigger");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getLabelStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getLabelStyle(final Diagram diagram) {
		return getStyle(diagram, "label");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureStyle(final Diagram diagram) {
		return getStyle(diagram, "feature");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramAccessStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getSubprogramAccessStyle(final Diagram diagram) {
		return getStyle(diagram, "subprogram_access");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getSubprogramGroupAccessStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getSubprogramGroupAccessStyle(final Diagram diagram) {
		return getStyle(diagram, "subprogram_group_access");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getBackgroundStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getBackgroundStyle(final Diagram diagram) {
		return getStyle(diagram, "background");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureGroupLargeCircleStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureGroupLargeCircleStyle(final Diagram diagram) {
		return getStyle(diagram, "feature_group_large_circle");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getFeatureGroupSmallCircleStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getFeatureGroupSmallCircleStyle(final Diagram diagram) {
		return getStyle(diagram, "feature_group_small_circle");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getModeStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getModeStyle(final Diagram diagram) {
		return getStyle(diagram, "mode");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getInitialModeStyle(org.eclipse.graphiti.mm.pictograms.Diagram)
	 */
	@Override
	public Style getInitialModeStyle(final Diagram diagram) {
		return getStyle(diagram, "mode-initial");
    }
	
	/* (non-Javadoc)
	 * @see edu.uah.rsesc.aadl.age.diagrams.common.util.StyleService#getInSelectedModeColor()
	 */
	@Override
	public IColorConstant getInSelectedModeColor() {
		return ColorConstant.BLUE;
	}
}
