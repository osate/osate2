package org.osate.expr.ui.editor.hover.html;

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider
import org.osate.expr.ExprTypeSystem
import org.osate.expr.typing.ExprStringRepresentation

class ExprEObjectHoverProvider extends DefaultEObjectHoverProvider {

	@Inject
	ExprTypeSystem ts;

//	@Inject
//	CommonInterpreter inter;

	@Inject
	ExprStringRepresentation csr;

	override def getFirstLine(EObject o) {
		val result = ts.type(o);

		if (result.failed()) {
			'no type '
		} else {
			val label = getLabel(o)
			val type = result.first
			var str = csr.string(type)


			str + if (label !== null) ' <b>' + label + '</b>' else ''
		}
	}

}
