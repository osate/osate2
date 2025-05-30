/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.diagram.runtime;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DiagramType;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.AadlReferenceUtil;
import org.osate.ge.aadl2.internal.diagramtypes.CustomDiagramType;
import org.osate.ge.aadl2.internal.diagramtypes.PackageDiagramType;
import org.osate.ge.aadl2.internal.diagramtypes.StructureDiagramType;
import org.osate.ge.diagram.Diagram;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.GraphicalEditorException;
import org.osate.ge.internal.businessobjecthandlers.InternalReferenceUtil;
import org.osate.ge.internal.diagram.runtime.types.UnrecognizedDiagramType;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.services.ExtensionRegistryService;
import org.osate.ge.internal.services.impl.DeclarativeReferenceType;

/**
 * Utility class with members related to reading and writing the diagram file format used by the editor.
 *
 */
public final class DiagramSerialization {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private DiagramSerialization() {
	}

	/**
	 * The version of the diagram file format. This number should be incremented when changes are made to the format. This value
	 * is stored in the diagram file and is used to detect potential compatibility issues.
	 */
	public final static int FORMAT_VERSION = 7;

	private static Comparator<DiagramElement> elementComparator = (e1, e2) -> e1.getRelativeReference()
			.compareTo(e2.getRelativeReference());

	/**
	 * Loads the serialized diagram
	 * @param uri the URI specifying the location of the diagram file
	 * @return the serialized diagram
	 */
	public static org.osate.ge.diagram.Diagram readMetaModelDiagram(final URI uri) {
		Objects.requireNonNull(uri, "uri must not be null");

		// Load the resource
		final ResourceSet rs = new ResourceSetImpl();
		final Resource resource = rs.createResource(uri);
		try {
			resource.load(Collections.singletonMap(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, true));
			if (resource.getContents().size() == 0
					|| !(resource.getContents().get(0) instanceof org.osate.ge.diagram.Diagram)) {
				throw new GraphicalEditorException("Unable to load diagram.");
			}

			final org.osate.ge.diagram.Diagram mmDiagram = (org.osate.ge.diagram.Diagram) resource.getContents().get(0);
			return mmDiagram;
		} catch (final IOException e) {
			throw new GraphicalEditorException(e);
		}
	}

	/**
	 * Converts the serialized diagram to a runtime diagram
	 * @param project the project in which the serialized diagram is contained.
	 * @param mmDiagram the serialized diagram
	 * @param extRegistry the Eclipse extension registry
	 * @return the runtime diagram
	 */
	public static AgeDiagram createAgeDiagram(final IProject project, final org.osate.ge.diagram.Diagram mmDiagram,
			final ExtensionRegistryService extRegistry) {
		Objects.requireNonNull(extRegistry, "extRegistry is null");

		// Set the id which should be used for new diagram elements.
		final AgeDiagram ageDiagram = new AgeDiagram();

		// Read the diagram configuration

		// Set the diagram type
		final String diagramTypeId;
		if (mmDiagram.getConfig() == null || mmDiagram.getConfig().getType() == null) {
			// Assign a diagram type ID if the diagram does not have specify one.
			String autoAssignedDiagramTypeId = CustomDiagramType.ID;

			// Set the diagram type based on the diagram's context
			if (mmDiagram.getConfig() != null) {
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

		final DiagramConfigurationBuilder configBuilder = new DiagramConfigurationBuilder(diagramType, false);

		if (mmDiagram.getConfig() != null) {
			final org.osate.ge.diagram.DiagramConfiguration mmDiagramConfig = mmDiagram.getConfig();
			configBuilder.contextBoReference(convert(mmDiagramConfig.getContext()));

			final org.osate.ge.diagram.AadlPropertiesSet enabledAadlProperties = mmDiagramConfig
					.getEnabledAadlProperties();
			if (enabledAadlProperties != null) {
				for (final String enabledProperty : enabledAadlProperties.getProperty()) {
					configBuilder.addAadlProperty(enabledProperty);
				}
			}

			configBuilder.connectionPrimaryLabelsVisible(mmDiagramConfig.getConnectionPrimaryLabelsVisible());
		}

		// Ensure UUIDs are valid and handle migration from legacy id's.
		final Map<Long, UUID> legacyIdToUuidMap = new HashMap<>();
		ensureIdsAreValid(mmDiagram, legacyIdToUuidMap);
		updateReferencesToLegacyIds(mmDiagram, legacyIdToUuidMap);

		ageDiagram.modify("Configure Diagram", m -> {
			m.setDiagramConfiguration(configBuilder.build());
		});

		// Read elements
		ageDiagram.modify("Read from File", m -> {
			readElements(project, m, ageDiagram, mmDiagram, legacyIdToUuidMap);
		});

		return ageDiagram;
	}

	/**
	 * Ensures all elements have a UUID. Migrates legacy id's to UUIDs.
	 * @param diagram
	 * @param legacyIdToUuidMap map to populate with a mapping form legacy id's to the UUIDs. Needed to migrate references.
	 */
	private static void ensureIdsAreValid(final org.osate.ge.diagram.Diagram diagram,
			Map<Long, UUID> legacyIdToUuidMap) {
		final Iterator<Object> it = EcoreUtil.getAllProperContents(diagram, true);
		while (it.hasNext()) {
			final Object o = it.next();
			if (o instanceof org.osate.ge.diagram.DiagramElement) {
				final org.osate.ge.diagram.DiagramElement e = (org.osate.ge.diagram.DiagramElement) o;
				if (e.getUuid() == null) {
					final UUID newUuid = UUID.randomUUID();
					e.setUuid(newUuid.toString());

					if (e.getId() != null) {
						legacyIdToUuidMap.put(e.getId(), newUuid);
					}
				}
			}
		}
	}

	private static void updateReferencesToLegacyIds(final org.osate.ge.diagram.Diagram diagram,
			Map<Long, UUID> legacyIdToUuidMap) {
		if (legacyIdToUuidMap.size() == 0) {
			return;
		}

		// Older versions of property value groups use legacy ids.
		final Iterator<Object> it = EcoreUtil.getAllProperContents(diagram, true);
		while (it.hasNext()) {
			final Object o = it.next();
			if (o instanceof org.osate.ge.diagram.RelativeBusinessObjectReference) {
				org.osate.ge.diagram.RelativeBusinessObjectReference ref = (org.osate.ge.diagram.RelativeBusinessObjectReference) o;
				if (ref.getSeg().size() == 3
						&& Objects.equals(ref.getSeg().get(0), AadlReferenceUtil.PROPERTY_VALUE_GROUP_KEY)) {
					final int idSegmentIndex = 2;
					final UUID referencedUuid = legacyIdToUuidMap.get(Long.parseLong(ref.getSeg().get(idSegmentIndex)));

					if (referencedUuid != null) {
						ref.getSeg().set(idSegmentIndex, referencedUuid.toString());
					}
				}
			}
		}
	}

	/**
	 * Converts a serialized relative business object reference to a runtime relative business object reference
	 * @param ref the reference to convert
	 * @return the runtime relative business object reference
	 */
	public static RelativeBusinessObjectReference convert(
			final org.osate.ge.diagram.RelativeBusinessObjectReference ref) {
		final String[] segs = toReferenceSegments(ref);
		return segs == null ? null : new RelativeBusinessObjectReference(segs);
	}

	/**
	 * Converts a serialized canonical business object reference to a runtime canonical business object reference
	 * @param ref the reference to convert
	 * @return the runtime canonical business object reference
	 */
	public static CanonicalBusinessObjectReference convert(
			final org.osate.ge.diagram.CanonicalBusinessObjectReference ref) {
		final String[] segs = toReferenceSegments(ref);
		return segs == null ? null : new CanonicalBusinessObjectReference(segs);
	}

	private static String[] toReferenceSegments(final org.osate.ge.diagram.Reference ref) {
		return ref == null || ref.getSeg().size() == 0 ? null : ref.getSeg().toArray(new String[ref.getSeg().size()]);
	}

	private static void readElements(final IProject project, final DiagramModification m, final DiagramNode container,
			final org.osate.ge.diagram.DiagramNode mmContainer, final Map<Long, UUID> legacyIdToUuidMap) {
		for (final org.osate.ge.diagram.DiagramElement mmElement : mmContainer.getElement()) {
			createElement(project, m, container, mmElement, legacyIdToUuidMap);
		}
	}

	private static void createElement(final IProject project, final DiagramModification m, final DiagramNode container,
			final org.osate.ge.diagram.DiagramElement mmChild, final Map<Long, UUID> legacyIdToUuidMap) {
		final String[] refSegs = toReferenceSegments(mmChild.getBo());
		if (refSegs == null) {
			throw new GraphicalEditorException("Invalid element. Invalid business object reference.");
		}

		final RelativeBusinessObjectReference relReference = new RelativeBusinessObjectReference(refSegs);
		final Object bo = InternalReferenceUtil.createEmbeddedObject(relReference, mmChild.getBoData());

		// Set the ID
		final UUID uuid = UUID.fromString(mmChild.getUuid());
		final DiagramElement newElement = new DiagramElement(container, bo, null, relReference, uuid);

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

		newElement.setStyle(StyleBuilder.create()
				.backgroundColor(background)
				.showAsImage(showAsImage)
				.imagePath(image)
				.fontColor(fontColor)
				.outlineColor(outline)
				.fontSize(fontSize)
				.lineWidth(lineWidth)
				.primaryLabelVisible(primaryLabelVisible)
				.build());

		// Bendpoints
		final org.osate.ge.diagram.BendpointList mmBendpoints = mmChild.getBendpoints();
		if (mmBendpoints == null) {
			newElement.setBendpoints(Collections.emptyList());
		} else {
			newElement.setBendpoints(mmBendpoints.getPoint()
					.stream()
					.map(DiagramSerialization::convertPoint)
					.collect(Collectors.toList()));
		}

		// Primary Label Position (Only Supported for Connections)
		newElement.setConnectionPrimaryLabelPosition(convertPoint(mmChild.getPrimaryLabelPosition()));

		// Add the element
		m.addElement(newElement);

		// Create children
		readElements(project, m, newElement, mmChild, legacyIdToUuidMap);
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

	/**
	 * Serialized the specified runtime diagram and writes is to a file.
	 * @param project the project in which the diagram is contained.
	 * @param diagram the runtime diagram to serialize
	 * @param uri the URI specifying the file to which to write the serialized diagram
	 */
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

		convertElementsToMetamodel(project, mmDiagram, diagram.getChildren());

		// Save the resource
		final ResourceSet rs = new ResourceSetImpl();
		final Resource resource = rs.createResource(uri);
		resource.getContents().add(mmDiagram);
		try {
			resource.save(Collections.emptyMap());
		} catch (IOException e) {
			throw new GraphicalEditorException(e);
		}
	}

	/**
	 * Serialized the specified runtime diagram elements and adds them to a serialized diagram element. Recursive
	 * @param project the project in which the diagram elements are contained
	 * @param mmContainer the container of the new diagram elements
	 * @param elements the elements to serialized
	 */
	private static void convertElementsToMetamodel(final IProject project,
			final org.osate.ge.diagram.DiagramNode mmContainer, Collection<DiagramElement> elements) {
		// Sort elements to ensure a consistent ordering after serialization
		elements = elements.stream().sorted(elementComparator).collect(Collectors.toList());

		if (elements.size() > 0) {
			for (final DiagramElement e : elements) {
				convertElementToMetamodel(project, mmContainer, e);
			}
		}
	}

	private static void convertElementToMetamodel(final IProject project,
			final org.osate.ge.diagram.DiagramNode mmContainer, final DiagramElement e) {
		// Write BO Reference
		final org.osate.ge.diagram.DiagramElement newElement = new org.osate.ge.diagram.DiagramElement();
		mmContainer.getElement().add(newElement);

		newElement.setUuid(e.getId().toString());
		newElement.setBo(e.getRelativeReference().toMetamodel());

		// Store embedded business object data.
		if (e.getBusinessObject() instanceof EmbeddedBusinessObject) {
			final EmbeddedBusinessObject bo = (EmbeddedBusinessObject) e.getBusinessObject();
			newElement.setBoData(bo.getData());
		}

		newElement.setManual(true);

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

		convertElementsToMetamodel(project, newElement, e.getChildren());
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
