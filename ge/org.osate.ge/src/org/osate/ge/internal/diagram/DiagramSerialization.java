package org.osate.ge.internal.diagram;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonString;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.osate.ge.internal.DockArea;

/**
 * Class to help read and write the native JSON diagram format used by the editor.
 *
 */
public class DiagramSerialization {
	private final static String FIELD_CONTEXT_BO = "context_bo";
	private final static String FIELD_ENABLED_AADL_PROPERTIES = "enabled_aadl_properties";
	private final static String FIELD_ELEMENTS = "elements";
	private final static String FIELD_BO = "bo";
	private final static String FIELD_AUTO_CONTENTS_FILTER = "auto_contents_filter";
	private final static String FIELD_IS_MANUAL = "is_manual";
	private final static String FIELD_POSITION = "position";
	private final static String FIELD_SIZE = "size";
	private final static String FIELD_DOCK_AREA = "dock_area";
	private final static String FIELD_BENDPOINTS = "bendpoints";
	private final static String FIELD_PRIMARY_LABEL_POSITION = "primary_label_position";
	private final static String FIELD_X = "x";
	private final static String FIELD_Y = "y";
	private final static String FIELD_WIDTH = "width";
	private final static String FIELD_HEIGHT = "height";
	
	private static Comparator<DiagramElement> elementComparator = new Comparator<DiagramElement>() {
		@Override
		public int compare(final DiagramElement e1, final DiagramElement e2) {
			return e1.getRelativeReference().compareTo(e2.getRelativeReference());
		}
	};
	
	public static void read(final AgeDiagram ageDiagram,
			final InputStream is) {
		try(JsonReader reader = Json.createReader(is)) {
			final JsonObject jsonDiagram = reader.readObject();
		
			// Read the diagram configuration
			final DiagramConfigurationBuilder configBuilder = new DiagramConfigurationBuilder(ageDiagram.getConfiguration());

			final JsonArray contextBoRefSegs = jsonDiagram.getJsonArray(FIELD_CONTEXT_BO);
			if(contextBoRefSegs != null) {
				final String[] segs = contextBoRefSegs.stream().map(v -> ((JsonString)v).getString()).toArray(String[]::new);
				configBuilder.setContextBoReference(new CanonicalBusinessObjectReference(segs));
			}
			
			final JsonArray enabledAadlProperties = jsonDiagram.getJsonArray(FIELD_ENABLED_AADL_PROPERTIES);
			if(enabledAadlProperties != null) {
				for(int i = 0; i < enabledAadlProperties.size(); i++) {
					configBuilder.addAadlProperty(enabledAadlProperties.getString(i));
				}
			}
			
			ageDiagram.setDiagramConfiguration(configBuilder.build());
			
			// Require a context business object
			if(ageDiagram.getConfiguration().getContextBoReference() == null) {
				throw new RuntimeException("Contextless diagrams are not supported");
			}
			
			//  Read elements
			ageDiagram.modify(new DiagramModifier() {
				@Override
				public void modify(final DiagramModification m) {
					readElements(m, ageDiagram, jsonDiagram);
				}
			});
			
		}
	}
	
	private static void readElements(final DiagramModification m, final DiagramNode container, final JsonObject jsonContainer) {
		final JsonArray jsonElements = jsonContainer.getJsonArray(FIELD_ELEMENTS);
		if(jsonElements != null) {
			for(int i = 0; i < jsonElements.size(); i++) {
				final JsonObject jsonChild = jsonElements.getJsonObject(i);
				createElement(m, container, jsonContainer, jsonChild);
			}
		}
	}	
	
	private static void createElement(final DiagramModification m, final DiagramNode container, final JsonObject jsonContainer, final JsonObject jsonChild) {
		final JsonArray boRefSegs = jsonChild.getJsonArray(FIELD_BO);
		if(boRefSegs == null) {
			throw new RuntimeException("Invalid element. Business Object not specified");
		}
		
		final String[] refSegs = boRefSegs.stream().map(v -> ((JsonString)v).getString()).toArray(String[]::new);
		final RelativeBusinessObjectReference relReference = new RelativeBusinessObjectReference(refSegs);
		final DiagramElement newElement = new DiagramElement(container, null, null, relReference, null);
		final String autoContentsFilterId = jsonChild.getString(FIELD_AUTO_CONTENTS_FILTER, null);
		if(autoContentsFilterId != null) {
			final ContentsFilter autoContentsFilter = ContentsFilter.getById(autoContentsFilterId);
			if(autoContentsFilter != null) {
				newElement.setAutoContentsFilter(autoContentsFilter);
			}
		}
		newElement.setManual(jsonChild.getBoolean(FIELD_IS_MANUAL, false));
		
		// Size and Position
		newElement.setPosition(readPoint(jsonChild, FIELD_POSITION));
		newElement.setSize(readDimension(jsonChild, FIELD_SIZE));
		
		// Dock Area
		final String dockAreaId = jsonChild.getString(FIELD_DOCK_AREA, null);
		if(dockAreaId != null) {
			final DockArea dockArea = DockArea.getById(dockAreaId);
			if(dockArea != null) {
				newElement.setDockArea(dockArea);
			}
		}
		
		// Bendpoints
		final JsonArray bendpointsJson = jsonChild.getJsonArray(FIELD_BENDPOINTS);
		if(bendpointsJson != null) {
			final List<Point> bendpoints = new ArrayList<>(bendpointsJson.size());
			for(int i = 0; i < bendpointsJson.size(); i++) {
				bendpoints.add(jsonObjectToPoint(bendpointsJson.getJsonObject(i)));
			}
			newElement.setBendpoints(bendpoints);
		}
		
		// Primary Label Position (Only Supported for Connections)
		newElement.setConnectionPrimaryLabelPosition(readPoint(jsonChild, FIELD_PRIMARY_LABEL_POSITION));

		// Add the element
		m.addElement(newElement);		
		
		// Create children
		readElements(m, newElement, jsonChild);
	}
	
	private static Point readPoint(final JsonObject owner, final String name) {
		final JsonObject jsonPoint = owner.getJsonObject(name);
		if(jsonPoint == null) {
			return null;
		}
		
		return new Point(jsonPoint.getInt(FIELD_X, 0), jsonPoint.getInt(FIELD_Y, 0));
	}
	
	private static Point jsonObjectToPoint(final JsonObject jsonPoint) {
		if(jsonPoint == null) {
			return null;
		}
		
		return new Point(jsonPoint.getInt(FIELD_X, 0), jsonPoint.getInt(FIELD_Y, 0));
	}
	
	private static Dimension readDimension(final JsonObject owner, final String name) {
		final JsonObject jsonDimension = owner.getJsonObject(name);
		if(jsonDimension == null) {
			return null;
		}
		
		return new Dimension(jsonDimension.getInt(FIELD_WIDTH, 0), jsonDimension.getInt(FIELD_HEIGHT, 0));
	}
	
	public static void write(final AgeDiagram diagram, final OutputStream os) {
		JsonGeneratorFactory generatorFactory = Json.createGeneratorFactory(Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true));            
		try(JsonGenerator generator = generatorFactory.createGenerator(os)) {			
			generator.writeStartObject();
			
			final DiagramConfiguration config = diagram.getConfiguration();
			writeCanonicalReference(generator, FIELD_CONTEXT_BO, config.getContextBoReference());
			
			generator.writeStartArray(FIELD_ENABLED_AADL_PROPERTIES);
			for(final String enabledPropertyName : config.getEnabledAadlPropertyNames()) {
				generator.write(enabledPropertyName);
			}
			generator.writeEnd();
			
			writeElements(generator, diagram.getDiagramElements());			
			generator.writeEnd();			
		}
	}
	
	// Does not write anything if the reference is null
	private static void writeCanonicalReference(final JsonGenerator generator, final String fieldName, final CanonicalBusinessObjectReference ref) {
		if(ref != null) {
			generator.writeStartArray(fieldName);
			for(final String seg : ref.toSegmentArray()) {
				generator.write(seg);
			}
			generator.writeEnd();
		}
	}
	
	private static void writeElements(final JsonGenerator generator, Collection<DiagramElement> elements) {
		// Filter out decorations which don't have applicable fields set. For example non-moveable decorators.
		// Sort elements to ensure a consistent ordering after serialization
		elements = elements.stream().filter(e -> !e.isDecoration() || e.hasPosition()).sorted(elementComparator).collect(Collectors.toList());
		
		// Sort children in some way to ensure a consistent serialization order. The underlying collection is not a list.
		if(elements.size() > 0) {
			generator.writeStartArray(FIELD_ELEMENTS);
			for(final DiagramElement e : elements) {
				writeElement(generator, e);
			}
			generator.writeEnd();
		}
	}
	
	private static void writeElement(final JsonGenerator generator, final DiagramElement e) {
		generator.writeStartObject();

		// Write BO Reference
		generator.writeStartArray(FIELD_BO);
		for(final String seg : e.getRelativeReference().toSegmentArray()) {
			generator.write(seg);
		}
		generator.writeEnd();
		
		if(e.getAutoContentsFilter() != ContentsFilter.DEFAULT) {
			generator.write(FIELD_AUTO_CONTENTS_FILTER, e.getAutoContentsFilter().id);
		}
		
		if(e.isManual()) {
			generator.write(FIELD_IS_MANUAL, true);
		}

		// Shape Specific
		if(e.hasPosition()) {
			generator.
			writeStartObject(FIELD_POSITION).
				write(FIELD_X, e.getX()).
				write(FIELD_Y, e.getY()).
			writeEnd();
		}
		
		if(e.hasSize()) {
			generator.
			writeStartObject(FIELD_SIZE).
				write(FIELD_WIDTH, e.getWidth()).
				write(FIELD_HEIGHT, e.getHeight()).
			writeEnd();
		}
		
		if(e.getDockArea() != null && e.getDockArea() != DockArea.GROUP) { // Don't serialize null or group dock areas
			generator.write(FIELD_DOCK_AREA, e.getDockArea().id);
		}
		
		// Connection Specific
		if(e.getBendpoints().size() > 0) {
			generator.writeStartArray(FIELD_BENDPOINTS);
			for(final Point bendpoint : e.getBendpoints()) {
				generator.writeStartObject().
					write(FIELD_X, bendpoint.x).
					write(FIELD_Y, bendpoint.y).
				writeEnd();
			}
			generator.writeEnd();
		}

		if(e.getConnectionPrimaryLabelPosition() != null) {
			generator.
			writeStartObject(FIELD_PRIMARY_LABEL_POSITION).
				write(FIELD_X, e.getConnectionPrimaryLabelPosition().x).
				write(FIELD_Y, e.getConnectionPrimaryLabelPosition().y).
			writeEnd();
		}
		
		writeElements(generator, e.getDiagramElements());
		
		generator.writeEnd();
	}
	
	// TODO: Rename
	public static CanonicalBusinessObjectReference getCanonicalObjectReference(final InputStream is) {
		final List<String> referenceSegments = new ArrayList<>();
		try(final JsonParser parser = Json.createParser(is)) {
			int objectDepth = 0;
			String name = null;
			boolean processingRootReference = false;
			while(parser.hasNext()) {
				final Event e = parser.next();
				switch(e) {
				case START_OBJECT:
					objectDepth++;
					break;
					
				case END_OBJECT:
					objectDepth--;
					break;
					
				case START_ARRAY:
					if(objectDepth == 1) {
						if(FIELD_CONTEXT_BO.equals(name)) {
							processingRootReference = true;
						}
					}
					break;
					
				case END_ARRAY:
					if(processingRootReference) {
						processingRootReference = false;
					}
					break;
					
				case KEY_NAME:
					name = parser.getString();
					break;
					
				case VALUE_STRING:
					if(processingRootReference) {
						referenceSegments.add(parser.getString());
					}
					break;
					
				case VALUE_NUMBER:
					break;
					
				case VALUE_TRUE:
					break;
					
				case VALUE_FALSE:
					break;
					
				case VALUE_NULL:
					break;						
				}
			}
		}
		
		if(referenceSegments.size() == 0) {
			return null;
		}
		
		return new CanonicalBusinessObjectReference(referenceSegments.toArray(new String[referenceSegments.size()]));
	}
}
