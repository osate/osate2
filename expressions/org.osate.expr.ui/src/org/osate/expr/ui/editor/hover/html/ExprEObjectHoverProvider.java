package org.osate.expr.ui.editor.hover.html;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.osate.aadl2.Type;
import org.osate.expr.ExprTypeSystem;
import org.osate.expr.evaluation.ExprInterpreter;
import org.osate.expr.expr.TypeDecl;
import org.osate.expr.expr.Value;
import org.osate.expr.expr.VarDecl;
import org.osate.expr.typing.ExprStringRepresentation;

import com.google.inject.Inject;

public class ExprEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	ExprTypeSystem typeSystem;

	@Inject
	ExprInterpreter interpreter;

	@Inject
	ExprStringRepresentation stringRep;

	@Override
	protected String getFirstLine(EObject eObject) {
		if (eObject instanceof TypeDecl) {
			return super.getFirstLine(eObject);
		}
		Result<Type> result = typeSystem.type(eObject);

		if (result.failed()) {
			return "no type";
		} else {
			String label = getLabel(eObject);
			Type type = result.getValue();
			String typeString = stringRep.string(type);
			String valueString = "";

			if (eObject instanceof VarDecl) {
				Result<Value> value = interpreter.interpretExpression(((VarDecl) eObject).getValue());
				if (!value.failed()) {
					valueString = " = " + stringRep.string(value.getValue());
				}
			}
			if (label != null) {
				return "<b>" + label + ": " + typeString + "</b>" + valueString;
			}
			return typeString;
		}
	}

}
