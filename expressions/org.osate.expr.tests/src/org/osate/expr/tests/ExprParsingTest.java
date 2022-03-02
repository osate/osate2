package org.osate.expr.tests;

import java.util.stream.Collectors;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.expr.expr.ExprModel;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ExprInjectorProvider.class)
class ExprParsingTest {
	@Inject
	ParseHelper<ExprModel> parseHelper;

	@Test
	void loadModel() throws Exception {
		var model = new StringBuilder();
		model.append("library\n");
		model.append("val x: int = 12;\n");
		model.append("var y: int;\n");
		model.append("def one(): int = {1};\n");
		model.append("type L: list of int;\n");
		model.append("type R: real;\n");
		var result = parseHelper.parse(model.toString());
		var resourceSet = result.eResource().getResourceSet();
		Assertions.assertNotNull(result);
		var errors = result.eResource().getErrors();
		Assertions.assertTrue(errors.isEmpty(),
				errors.stream()
						.map(e -> "  " + e.toString())
						.collect(Collectors.joining(", ", "Unexpected errors:\n", "")));
	}
}
