package org.osate.ge.internal.diagram.runtime;

import java.awt.Color;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.osate.ge.diagram.Diagram;
import org.osate.ge.internal.DockArea;

/**
 * Class to help read and write the native diagram format used by the editor.
 *
 */
public class DiagramSerialization {
	public final static int FORMAT_VERSION = 1;

	private static Comparator<DiagramElement> elementComparator = (e1, e2) -> e1.getRelativeReference()
			.compareTo(e2.getRelativeReference());

	public static org.osate.ge.diagram.Diagram readMetaModelDiagram(final URI uri) {
		Objects.requireNonNull(uri, "uri must not be null");

		// Load the resource
		final ResourceSet rs = new ResourceSetImpl();
		final Resource resource = rs.createResource(uri);

		try {
			resource.load(Collections.singletonMap(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, true));
			if (resource.getContents().size() == 0
					|| !(resource.getContents().get(0) instanceof org.osate.ge.diagram.Diagram)) {
				throw new RuntimeException("Unable to load diagram.");
			}

			final org.osate.ge.diagram.Diagram mmDiagram = (org.osate.ge.diagram.Diagram) resource.getContents().get(0);
			return mmDiagram;
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static AgeDiagram createAgeDiagram(final org.osate.ge.diagram.Diagram mmDiagram) {
		// Set the id which should be used for new diagram elements.
		final AgeDiagram ageDiagram = new AgeDiagram(getMaxIdForChildren(mmDiagram) + 1);

		// Read the diagram configuration
		final DiagramConfigurationBuilder configBuilder = new DiagramConfigurationBuilder(
				ageDiagram.getConfiguration());

		if (mmDiagram.getConfig() != null) {
			final org.osate.ge.diagram.DiagramConfiguration mmDiagramConfig = mmDiagram.getConfig();
			configBuilder.setContextBoReference(convert(mmDiagramConfig.getContext()));

			final org.osate.ge.diagram.AadlPropertiesSet enabledAadlProperties = mmDiagramConfig
					.getEnabledAadlProperties();
			if (enabledAadlProperties != null) {
				for (final String enabledProperty : enabledAadlProperties.getProperty()) {
					configBuilder.addAadlProperty(enabledProperty);
				}
			}
		}

		ageDiagram.setDiagramConfiguration(configBuilder.build());

		// Require a context business object
		if (ageDiagram.getConfiguration().getContextBoReference() == null) {
			throw new RuntimeException("Contextless diagrams are not supported");
		}

		// Read elements
		ageDiagram.modify(m -> readElements(m, ageDiagram, mmDiagram, new HashSet<>()));

		return ageDiagram;
	}

	public static RelativeBusinessObjectReference convert(
			final org.osate.ge.diagram.RelativeBusinessObjectReference ref) {
		final String[] segs = toReferenceSegments(ref);
		return segs == null ? null : new RelativeBusinessObjectReference(segs);
	}

	public static CanonicalBusinessObjectReference convert(
			final org.osate.ge.diagram.CanonicalBusinessObjectReference ref) {
		final String[] segs = toReferenceSegments(ref);
		return segs == null ? null : new CanonicalBusinessObjectReference(segs);
	}

	private static String[] toReferenceSegments(final org.osate.ge.diagram.Reference ref) {
		return ref == null || ref.getSeg().size() == 0 ? null : ref.getSeg().toArray(new String[ref.getSeg().size()]);
	}

	private static long getMaxIdForChildren(final org.osate.ge.diagram.DiagramNode dn) {
		long max = -1;

		// Check children
		for (final org.osate.ge.diagram.DiagramElement child : dn.getElement()) {
			max = Math.max(getMaxId(child), max);
		}

		return max;
	}

	private static long getMaxId(final org.osate.ge.diagram.DiagramElement de) {
		long max = -1;
		if (de.getId() != null) {
			max = Math.max(max, de.getId());
		}

		max = Math.max(max, getMaxIdForChildren(de));

		return max;
	}

	private static void readElements(final DiagramModification m, final DiagramNode container,
			final org.osate.ge.diagram.DiagramNode mmContainer, final Set<Long> usedIdSet) {
		for (final org.osate.ge.diagram.DiagramElement mmElement : mmContainer.getElement()) {
			createElement(m, container, mmContainer, mmElement, usedIdSet);
		}
	}

	private static void createElement(final DiagramModification m, final DiagramNode container,
			final org.osate.ge.diagram.DiagramNode mmContainer, final org.osate.ge.diagram.DiagramElement mmChild,
			final Set<Long> usedIdSet) {
		final String[] refSegs = toReferenceSegments(mmChild.getBo());
		if (refSegs == null) {
			throw new RuntimeException("Invalid element. Business Object not specified");
		}

		final RelativeBusinessObjectReference relReference = new RelativeBusinessObjectReference(refSegs);
		final DiagramElement newElement = new DiagramElement(container, null, null, relReference);

		// Set the ID
		if (mmChild.getId() != null) {
			// OSATE 2.2.3 contained an issue that resulted in duplicate IDs. This checks for and removed duplicate ID's
			if(!usedIdSet.contains(mmChild.getId())) {
				newElement.setId(mmChild.getId().intValue());
			}
		}

		final String autoContentsFilterId = mmChild.getAutoContentsFilter();
		if (autoContentsFilterId != null) {
			final BuiltinContentsFilter autoContentsFilter = BuiltinContentsFilter.getById(autoContentsFilterId);
			if (autoContentsFilter != null) {
				newElement.setAutoContentsFilter(autoContentsFilter);
			}
		}
		newElement.setManual(mmChild.isManual());

		// Size and Position
		newElement.setPosition(convertPoint(mmChild.getPosition()));
		newElement.setSize(convertDimension(mmChild.getSize()));

		// Dock Area
		final String dockAreaId = mmChild.getDockArea();
		if (dockAreaId != null) {
			final DockArea dockArea = DockArea.getById(dockAreaId);
			if (dockArea != null) {
				newElement.setDockArea(dockArea);
			}
		}

		// Style
		final Color background = mmChild.getBackground() != null ? parseColor(mmChild.getBackground()) : null;
		final Color fontColor = mmChild.getFontColor() != null ? parseColor(mmChild.getFontColor()) : null;
		final Color outline = mmChild.getOutline() != null ? parseColor(mmChild.getOutline()) : null;
		final int lineWidth = mmChild.getLineWidth();
		final double fontSize = mmChild.getFontSize();

		newElement.setStyle(StyleBuilder.create().backgroundColor(background).fontColor(fontColor).outlineColor(outline)
				.fontSize(FontSize.getByValue(fontSize)).lineWidth(LineWidth.getByValue(lineWidth)).build());

		// Bendpoints
		final org.osate.ge.diagram.BendpointList mmBendpoints = mmChild.getBendpoints();
		if (mmBendpoints != null) {
			newElement.setBendpoints(mmBendpoints.getPoint().stream().map(DiagramSerialization::convertPoint)
					.collect(Collectors.toList()));
		}

		// Primary Label Position (Only Supported for Connections)
		newElement.setConnectionPrimaryLabelPosition(convertPoint(mmChild.getPrimaryLabelPosition()));

		// Add the element
		m.addElement(newElement);

		if(newElement.getId() != null) {
			usedIdSet.add(newElement.getId());
		}

		// Create children
		readElements(m, newElement, mmChild, usedIdSet);
	}

	private static Point convertPoint(final org.osate.ge.diagram.Point mmPoint) {
		if (mmPoint == null) {
			return null;
		}

		return new Point(mmPoint.getX(), mmPoint.getY());
	}

	private static Dimension convertDimension(final org.osate.ge.diagram.Dimension mmDimension) {
		if (mmDimension == null) {
			return null;
		}

		return new Dimension(mmDimension.getWidth(), mmDimension.getHeight());
	}

	public static void write(final AgeDiagram diagram, final URI uri) {
		// Convert from the runtime format to the metamodel format which is stored
		final org.osate.ge.diagram.Diagram mmDiagram = new Diagram();
		mmDiagram.setFormatVersion(FORMAT_VERSION);
		final org.osate.ge.diagram.DiagramConfiguration mmConfig = new org.osate.ge.diagram.DiagramConfiguration();
		mmDiagram.setConfig(mmConfig);

		// Populate the diagram configuration
		final DiagramConfiguration config = diagram.getConfiguration();
		mmConfig.setContext(
				config.getContextBoReference() == null ? null : config.getContextBoReference().toMetamodel());

		final org.osate.ge.diagram.AadlPropertiesSet enabledProperties = new org.osate.ge.diagram.AadlPropertiesSet();
		mmConfig.setEnabledAadlProperties(enabledProperties);
		for (final String enabledPropertyName : config.getEnabledAadlPropertyNames()) {
			enabledProperties.getProperty().add(enabledPropertyName);
		}

		convertElementsToMetamodel(mmDiagram, diagram.getDiagramElements());

		// Save the resource
		final ResourceSet rs = new ResourceSetImpl();
		final Resource resource = rs.createResource(uri);
		resource.getContents().add(mmDiagram);
		try {
			resource.save(Collections.emptyMap());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 *  Converts specified elements from runtime datastructure into a metamodel.
	 * @param mmContainer
	 * @param elements
	 */
	private static void convertElementsToMetamodel(final org.osate.ge.diagram.DiagramNode mmContainer,
			Collection<DiagramElement> elements) {
		// Sort elements to ensure a consistent ordering after serialization
		elements = elements.stream().sorted(elementComparator).collect(Collectors.toList());

		if (elements.size() > 0) {
			for (final DiagramElement e : elements) {
				convertElementToMetamodel(mmContainer, e);
			}
		}
	}

	private static void convertElementToMetamodel(final org.osate.ge.diagram.DiagramNode mmContainer,
			final DiagramElement e) {
		// Write BO Reference
		final org.osate.ge.diagram.DiagramElement newElement = new org.osate.ge.diagram.DiagramElement();
		mmContainer.getElement().add(newElement);

		// Set ID
		if (e.hasId()) {
			newElement.setId(e.getId());
		}

		newElement.setBo(e.getRelativeReference() == null ? null : e.getRelativeReference().toMetamodel());
		if (e.getAutoContentsFilter() != null) {
			newElement.setAutoContentsFilter(e.getAutoContentsFilter().id());
		}

		if (e.isManual()) {
			newElement.setManual(true);
		}

		// Shape Specific
		if (e.hasPosition()) {
			newElement.setPosition(e.getPosition().toMetamodel());
		}

		if (e.hasSize() && e.isSizeable()) {
			newElement.setSize(e.getSize().toMetamodel());
		}

		if (e.getDockArea() != null && e.getDockArea() != DockArea.GROUP) { // Don't serialize null or group dock areas
			newElement.setDockArea(e.getDockArea().id);
		}

		final Style currentStyle = e.getStyle();
		final java.awt.Color awtBackground = currentStyle.getBackgroundColor();
		if (awtBackground != null) {
			newElement.setBackground(awtColorToHex(awtBackground));
		}

		final java.awt.Color awtFontColor = currentStyle.getFontColor();
		if (awtFontColor != null) {
			newElement.setFontColor(awtColorToHex(awtFontColor));
		}

		final java.awt.Color awtOutline = currentStyle.getOutlineColor();
		if (awtOutline != null) {
			newElement.setOutline(awtColorToHex(awtOutline));
		}

		final FontSize fontSize = currentStyle.getFontSize();
		if (fontSize != null) {
			newElement.setFontSize(fontSize.getValue());
		}

		final LineWidth lineWidth = currentStyle.getLineWidth();
		if (lineWidth != null) {
			newElement.setLineWidth(lineWidth.getValue());
		}

		// Connection Specific
		if (e.getBendpoints().size() > 0) {
			final org.osate.ge.diagram.BendpointList mmBendpoints = new org.osate.ge.diagram.BendpointList();
			newElement.setBendpoints(mmBendpoints);

			for (final Point bendpoint : e.getBendpoints()) {
				mmBendpoints.getPoint().add(bendpoint.toMetamodel());
			}
		}

		if (e.getConnectionPrimaryLabelPosition() != null) {
			newElement.setPrimaryLabelPosition(e.getConnectionPrimaryLabelPosition().toMetamodel());
		}

		convertElementsToMetamodel(newElement, e.getDiagramElements());
	}

	// Create hex string from color
	private static String awtColorToHex(final java.awt.Color color) {
		return "#" + String.format("%02x", color.getRed()) + String.format("%02x", color.getGreen())
		+ String.format("%02x", color.getBlue());
	}

	// Create color from hex string
	private static Color parseColor(final String color) {
		return new Color(Integer.parseInt(color.substring(1, 3), 16), Integer.parseInt(color.substring(3, 5), 16),
				Integer.parseInt(color.substring(5), 16));
	}
}
