package org.osate.examples.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.inject.Inject;

public class ExampleConfig {
	@Inject
	protected TestHelper testHelper;
	public String bundle = "org.osate.examples";
	public List<ExampleEntry> entries = new ArrayList<ExampleEntry>();

	public void addEntry(String entry, List<String> references) {
		ExampleEntry newEntry = new ExampleEntry();
		newEntry.entry = entry;
		newEntry.references = references;

		entries.add(newEntry);
	}

	@Test
	public void InstantionTest() throws Exception {
		testHelper.ValidationAndInstantiationTest(this);
	}
}