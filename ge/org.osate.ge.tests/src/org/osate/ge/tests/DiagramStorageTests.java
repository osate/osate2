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
					.write("test", "test2")
					.write("test", "test2")
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
		try(final ByteArrayInputStream is = new ByteArrayInputStream(data)) {
			try(JsonReader reader = Json.createReader(is)) {
				final JsonObject test = reader.readObject();
				System.err.println(test.getString("test"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO: For reference changing, need to read and write using stream API while only making small changes.
		
	}
}
