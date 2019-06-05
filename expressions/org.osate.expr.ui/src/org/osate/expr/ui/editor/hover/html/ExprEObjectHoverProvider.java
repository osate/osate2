package org.osate.expr.ui.editor.hover.html;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.osate.aadl2.Type;
import org.osate.expr.ExprTypeSystem;
import org.osate.expr.evaluation.ExprInterpreter;
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
	protected String getFirstLine(EObject o) {
		Result<Type> result = typeSystem.type(o);

		if (result.failed()) {
			return "no type";
		} else {
			String label = getLabel(o);
			Type type = result.getValue();
			String str = stringRep.string(type);

			if (o instanceof VarDecl) {
				Result<Value> value = interpreter.interpretExpression(((VarDecl) o).getValue());
				if (!value.failed()) {
					str += value.getValue();
				}
			}
			if (label != null) {
				str = "<b>" + label + "</b>: " + str;
			}
			return str;
		}
	}

}
