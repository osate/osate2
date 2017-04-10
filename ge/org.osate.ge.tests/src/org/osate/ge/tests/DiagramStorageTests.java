package org.osate.ge.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

import org.junit.Test;

// TODO: Rename
public class DiagramStorageTests {
	@Test
	public void testDiagramStorage() {
		// TODO: Create diagram
		// TODO: Serialize to memory
		// TODO: Deserialize from memory
		// TODO: Compare
		
		// WRITE Example
		byte[] data = null;
		try(final ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            JsonGeneratorFactory generatorFactory = Json.createGeneratorFactory(Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true));            
			try(JsonGenerator generator = generatorFactory.createGenerator(os)) {
				generator
				.writeStartObject()
					.write("reference", "test2")
					.write("test2", "test2")
					.write("test3", true)
					.writeStartObject("a")
					.writeEnd()
				.writeEnd();
			}

			// TODO: Creates whitespace at start. Investigate
			
			data = os.toByteArray();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final String json = new String(data); // TODO: Need to specify encoding?
		System.err.println("START:");
		System.err.println(json); 
		
		// TODO: Consider using the parser/streaming API
		//http://docs.oracle.com/javaee/7/tutorial/jsonp004.htm#BABDBHIA
		// More complicated?
			
		// TODO: Read Example
		System.err.println("READ:");
		try(final ByteArrayInputStream is = new ByteArrayInputStream(data)) {
			try(JsonReader reader = Json.createReader(is)) {
				final JsonObject test = reader.readObject();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO: Example of transforming JSON using the streaming API.
		System.err.println("TRANFORM");
		byte[] transformedData = null;
		try(final ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            JsonGeneratorFactory generatorFactory = Json.createGeneratorFactory(Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true));            
			try(JsonGenerator generator = generatorFactory.createGenerator(os)) {			
				try(final ByteArrayInputStream is = new ByteArrayInputStream(data)) {
					try(JsonParser parser = Json.createParser(is)) {
						String name = null;
						while(parser.hasNext()) {
							final Event e = parser.next();
							switch(e) {
							case START_OBJECT:
								if(name == null) {
									generator.writeStartObject();
								} else {
									generator.writeStartObject(name);
								}
								break;
								
							case END_OBJECT:
								generator.writeEnd();
								break;
								
							case START_ARRAY:
								if(name == null) {
									generator.writeStartArray();
								} else {
									generator.writeStartArray(name);
								}
								break;
								
							case END_ARRAY:
								generator.writeEnd();
								break;
								
							case KEY_NAME:
								name = parser.getString();
								break;
								
							case VALUE_STRING:
								String value = parser.getString();
								if("reference".equals(name)) {
									value = "TRANSFORMED";
								}
								
								generator.write(name, value);
								break;
								
							case VALUE_NUMBER:
								generator.write(name, parser.getBigDecimal());
								break;
								
							case VALUE_TRUE:
								generator.write(name, true);
								break;
								
							case VALUE_FALSE:
								generator.write(name, false);
								break;
								
							case VALUE_NULL:
								generator.writeNull(name);
								break;						
							}
						}
					}
				}
			}
			
			transformedData = os.toByteArray();
		} catch (Exception e) {
			System.err.println("Error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		final String transformedJson = new String(transformedData); // TODO: Need to specify encoding?
		System.err.println("TRANSFORMED:");
		System.err.println(transformedJson);		
	}
}
