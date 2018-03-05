package org.osate.ge.internal.diagram.runtime;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.osate.ge.ContentFilter;
import org.osate.ge.DiagramType;
import org.osate.ge.diagram.Diagram;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.diagram.runtime.filtering.ContentFilterProvider;
import org.osate.ge.internal.diagram.runtime.filtering.LegacyContentFilterMapping;
import org.osate.ge.internal.diagram.runtime.types.CustomDiagramType;
import org.osate.ge.internal.diagram.runtime.types.PackageDiagramType;
import org.osate.ge.internal.diagram.runtime.types.StructureDiagramType;
import org.osate.ge.internal.diagram.runtime.types.UnrecognizedDiagramType;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;

import com.google.common.collect.ImmutableSet;

/**
 * Class to help read and write the native diagram format used by the editor.
 *
 */
public class DiagramSerialization {
	public final static int FORMAT_VERSION = 5;

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

	public static AgeDiagram createAgeDiagram(final IProject project, final org.osate.ge.diagram.Diagram mmDiagram,
			final ExtensionRegistryService extRegistry) {
		Objects.requireNonNull(extRegistry, "extRegistry is null");

		// Set the id which should be used for new diagram elements.
		final AgeDiagram ageDiagram = new AgeDiagram(getMaxIdForChildren(mmDiagram) + 1);

		// Read the diagram configuration

		// Set the diagram type
		final String diagramTypeId;
		if (mmDiagram.getConfig() == null || mmDiagram.getConfig().getType() == null) {
			// Assign a diagram type ID if the diagram does not have specify one.
			String autoAssignedDiagramTypeId = CustomDiagramType.ID;

			// Set the diagram type based on the diagram's context
			if(mmDiagram.getConfig() != null) {
				final CanonicalBusinessObjectReference contextRef = convert(mmDiagram.getConfig().getContext());
				if (contextRef != null && contextRef.getSegments().size() > 1) {
					if (DeclarativeReferenceType.PACKAGE.getId().equals(contextRef.getSegments().get(0))) {
						autoAssignedDiagramTypeId = PackageDiagramType.ID;
					} else if (DeclarativeReferenceType.CLASSIFIER.getId().equals(contextRef.getSegments().get(0))) {
						autoAssignedDiagramTypeId = StructureDiagramType.ID;
					}
				}
			}

			diagramTypeId = autoAssignedDiagramTypeId;
		} else {
			diagramTypeId = mmDiagram.getConfig().getType();
		}
		final DiagramType diagramType = extRegistry.getDiagramTypeById(diagramTypeId)
				.orElseGet(() -> new UnrecognizedDiagramType(diagramTypeId));

		final DiagramConfigurationBuilder configBuilder = new DiagramConfigurationBuilder(diagramType,
				false);

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

			configBuilder.connectionPrimaryLabelsVisible(mmDiagramConfig.getConnectionPrimaryLabelsVisible());
		}

		ageDiagram.modify("Configure Diagram", m -> {
			m.setDiagramConfiguration(configBuilder.build());
		});

		// Require a context business object
		if (ageDiagram.getConfiguration().getContextBoReference() == null) {
			throw new RuntimeException("Contextless diagrams are not supported");
		}

		//  Read elements
		ageDiagram.modify("Read from File", m -> readElements(project, m, extRegistry,
				ageDiagram, mmDiagram, new HashSet<>(), false));

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

	private static void readElements(final IProject project, final DiagramModification m,
			final ContentFilterProvider contentFilterProvider,
			final DiagramNode container, final org.osate.ge.diagram.DiagramNode mmContainer,
			final Set<Long> usedIdSet, final boolean usingLegacyContentFilters) {
		for (final org.osate.ge.diagram.DiagramElement mmElement : mmContainer.getElement()) {
			createElement(project, m, contentFilterProvider, container, mmElement, usedIdSet,
					usingLegacyContentFilters);
		}
	}

	private static void createElement(final IProject project, final DiagramModification m,
			final ContentFilterProvider contentFilterProvider,
			final DiagramNode container, final org.osate.ge.diagram.DiagramElement mmChild, final Set<Long> usedIdSet,
			boolean usingLegacyContentFilters) {
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

		ImmutableSet.Builder<ContentFilter> contentFilterSetBuilder = ImmutableSet.builder();
		if (mmChild.getContentFilters() != null) {
			for (final String contentFilterId : mmChild.getContentFilters().getFilter()) {
				contentFilterProvider.getContentFilterById(contentFilterId).ifPresent(contentFilter -> {
					contentFilterSetBuilder.add(contentFilter);
				});
			}
		}

		final String legacyFilterId = mmChild.getAutoContentsFilter();
		if (legacyFilterId != null) {
			usingLegacyContentFilters = true;

			// Get legacy content filters
			LegacyContentFilterMapping.getById(legacyFilterId).ifPresent(legacyMapping -> {
				// Add the equivalent content filters to the content filter set.
				for (final String contentFilterId : legacyMapping.getContentFilterIds()) {
					contentFilterProvider.getContentFilterById(contentFilterId).ifPresent(contentFilter -> {
						contentFilterSetBuilder.add(contentFilter);
					});
				}
			});
		}
		newElement.setContentFilters(contentFilterSetBuilder.build());
		newElement.setManual(mmChild.isManual());

		// Need to set default mode transition trigger connections, default annex library, and default annex subclauses as manual if loading diagrams which use the legacy content filter.
		// Current filters do not include those objects because of issues with layout(mode transition trigger connections) or questionable usefulness(annex elements)
		if(usingLegacyContentFilters) {
			final String firstSegment = newElement.getRelativeReference().getSegments().get(0);
			if (DeclarativeReferenceType.ANNEX_LIBRARY.getId().equals(firstSegment)
					|| DeclarativeReferenceType.ANNEX_SUBCLAUSE.getId().equals(firstSegment)
					|| DeclarativeReferenceType.MODE_TRANSITION_TRIGGER.getId().equals(firstSegment)) {
				// Set the element and its parents as manual
				for (DiagramElement tmp = newElement; tmp
						.getParent() instanceof DiagramElement; tmp = (DiagramElement) tmp.getParent()) {
					tmp.setManual(true);
				}
			}
		}

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
		final Boolean showAsImage = mmChild.getShowAsImage();
		final Color background = mmChild.getBackground() != null ? parseColor(mmChild.getBackground()) : null;
		final IPath image = mmChild.getImage() != null
				? project.getFile(Path.fromPortableString(mmChild.getImage())).getFullPath()
						: null;
				final Color fontColor = mmChild.getFontColor() != null ? parseColor(mmChild.getFontColor()) : null;
				final Color outline = mmChild.getOutline() != null ? parseColor(mmChild.getOutline()) : null;
				final Double lineWidth = mmChild.getLineWidth();
				final Double fontSize = mmChild.getFontSize();
				final Boolean primaryLabelVisible = mmChild.getPrimaryLabelVisible();

				newElement.setStyle(StyleBuilder.create().backgroundColor(background).showAsImage(showAsImage).imagePath(image)
						.fontColor(fontColor).outlineColor(outline)
						.fontSize(fontSize).lineWidth(lineWidth).primaryLabelVisible(primaryLabelVisible).build());

				// Bendpoints
				final org.osate.ge.diagram.BendpointList mmBendpoints = mmChild.getBendpoints();
				if (mmBendpoints == null) {
					newElement.setBendpoints(Collections.emptyList());
				} else {
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
				readElements(project, m, contentFilterProvider, newElement, mmChild, usedIdSet, usingLegacyContentFilters);
	}

	private static Point convertPoint(final org.osate.ge.diagram.Point mmPoint) {
		if (mmPoint == null) {
			return null;
		}

		return new Point((int) Math.round(mmPoint.getX()), (int) Math.round(mmPoint.getY()));
	}

	private static Dimension convertDimension(final org.osate.ge.diagram.Dimension mmDimension) {
		if (mmDimension == null) {
			return null;
		}

		return new Dimension((int) Math.round(mmDimension.getWidth()), (int) Math.round(mmDimension.getHeight()));
	}

	public static void write(final IProject project, final AgeDiagram diagram, final URI uri) {
		// Convert from the runtime format to the metamodel format which is stored
		final org.osate.ge.diagram.Diagram mmDiagram = new Diagram();
		mmDiagram.setFormatVersion(FORMAT_VERSION);
		final org.osate.ge.diagram.DiagramConfiguration mmConfig = new org.osate.ge.diagram.DiagramConfiguration();
		mmDiagram.setConfig(mmConfig);

		// Populate the diagram configuration
		final DiagramConfiguration config = diagram.getConfiguration();
		mmConfig.setType(config.getDiagramType().getId());
		mmConfig.setContext(
				config.getContextBoReference() == null ? null : config.getContextBoReference().toMetamodel());

		mmConfig.setConnectionPrimaryLabelsVisible(config.getConnectionPrimaryLabelsVisible());

		final org.osate.ge.diagram.AadlPropertiesSet enabledProperties = new org.osate.ge.diagram.AadlPropertiesSet();
		mmConfig.setEnabledAadlProperties(enabledProperties);
		for (final String enabledPropertyName : config.getEnabledAadlPropertyNames()) {
			enabledProperties.getProperty().add(enabledPropertyName);
		}

		convertElementsToMetamodel(project, mmDiagram, diagram.getDiagramElements());

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
	 * @param project
	 * @param mmContainer
	 * @param elements
	 */
	private static void convertElementsToMetamodel(IProject project, final org.osate.ge.diagram.DiagramNode mmContainer,
			Collection<DiagramElement> elements) {
		// Sort elements to ensure a consistent ordering after serialization
		elements = elements.stream().sorted(elementComparator).collect(Collectors.toList());

		if (elements.size() > 0) {
			for (final DiagramElement e : elements) {
				convertElementToMetamodel(project, mmContainer, e);
			}
		}
	}

	private static void convertElementToMetamodel(final IProject project,
			final org.osate.ge.diagram.DiagramNode mmContainer,
			final DiagramElement e) {
		// Write BO Reference
		final org.osate.ge.diagram.DiagramElement newElement = new org.osate.ge.diagram.DiagramElement();
		mmContainer.getElement().add(newElement);

		// Set ID
		if (e.hasId()) {
			newElement.setId(e.getId());
		}

		newElement.setBo(e.getRelativeReference() == null ? null : e.getRelativeReference().toMetamodel());

		final org.osate.ge.diagram.ContentFilters contentFilters = new org.osate.ge.diagram.ContentFilters();
		newElement.setContentFilters(contentFilters);
		for (final ContentFilter contentFilter : e.getContentFilters()) {
			contentFilters.getFilter().add(contentFilter.getId());
		}

		if (e.isManual()) {
			newElement.setManual(true);
		}

		// Shape Specific
		if (e.hasPosition()) {
			newElement.setPosition(e.getPosition().toMetamodel());
		}
		if (e.hasSize() && DiagramElementPredicates.isResizeable(e)) {
			newElement.setSize(e.getSize().toMetamodel());
		}

		if (e.getDockArea() != null && e.getDockArea() != DockArea.GROUP) { // Don't serialize null or group dock areas
			newElement.setDockArea(e.getDockArea().id);
		}

		final Style currentStyle = e.getStyle();
		final org.osate.ge.graphics.Color backgroundColor = currentStyle.getBackgroundColor();
		if (backgroundColor != null) {
			newElement.setBackground(colorToHex(backgroundColor));
		}

		final IPath image = currentStyle.getImagePath();
		if (image != null) {
			// Get image path relative to the diagram's project
			final String portablePath = image.makeRelativeTo(project.getFullPath()).toPortableString();
			newElement.setImage(portablePath);
			newElement.setShowAsImage(currentStyle.getShowAsImage());
		}

		final org.osate.ge.graphics.Color fontColor = currentStyle.getFontColor();
		if (fontColor != null) {
			newElement.setFontColor(colorToHex(fontColor));
		}

		final org.osate.ge.graphics.Color outlineColor = currentStyle.getOutlineColor();
		if (outlineColor != null) {
			newElement.setOutline(colorToHex(outlineColor));
		}

		final Double fontSize = currentStyle.getFontSize();
		if (fontSize != null) {
			newElement.setFontSize(fontSize);
		}

		final Double lineWidth = currentStyle.getLineWidth();
		if (lineWidth != null) {
			newElement.setLineWidth(lineWidth);
		}

		if (currentStyle.getPrimaryLabelVisible() != null) {
			newElement.setPrimaryLabelVisible(currentStyle.getPrimaryLabelVisible());
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

		convertElementsToMetamodel(project, newElement, e.getDiagramElements());
	}

	// Create hex string from color
	private static String colorToHex(final org.osate.ge.graphics.Color color) {
		return "#" + String.format("%02x", color.getRed()) + String.format("%02x", color.getGreen())
		+ String.format("%02x", color.getBlue());
	}

	// Create color from hex string
	private static Color parseColor(final String color) {
		return new Color(Integer.parseInt(color.substring(1, 3), 16), Integer.parseInt(color.substring(3, 5), 16),
				Integer.parseInt(color.substring(5), 16));
	}
}
