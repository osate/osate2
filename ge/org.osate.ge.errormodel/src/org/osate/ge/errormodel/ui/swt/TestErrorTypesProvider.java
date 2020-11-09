package org.osate.ge.errormodel.ui.swt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.osate.ge.errormodel.ui.viewmodels.NamedObjectsProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelFactory;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

public class TestErrorTypesProvider implements NamedObjectsProvider<ErrorTypes> {
	private final List<ErrorTypes> values = new ArrayList<>();

	public TestErrorTypesProvider() {
		values.add(createType("T1"));
		values.add(createType("T2"));
		values.add(createType("T3"));
	}

	@Override
	public Stream<ErrorTypes> getValues() {
		return values.stream();
	}

	@Override
	public String getName(final ErrorTypes type) {
		return type.getName();
	}

	private static ErrorType createType(final String name) {
		final ErrorType newValue = ErrorModelFactory.eINSTANCE.createErrorType();
		newValue.setName(name);
		return newValue;
	}

}
