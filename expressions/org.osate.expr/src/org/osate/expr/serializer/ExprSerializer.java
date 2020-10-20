package org.osate.expr.serializer;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.osate.expr.expr.ExprLibrary;
import org.osate.expr.expr.ExprSubclause;
import org.osate.expr.services.ExprGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class ExprSerializer extends Serializer {

	@Inject
	private ExprGrammarAccess grammarAccess;

	@Override
	protected ISerializationContext getIContext(final EObject semanticObject) {
		ISerializationContext result = null;
		final Function<ParserRule, Predicate<ISerializationContext>> contextRuleIs = //
				rule -> context -> Objects.equals(context.getParserRule(), rule);

		if (semanticObject instanceof ExprLibrary) {
			result = contextFinder.findByContents(semanticObject, null)
					.stream()
					.filter(contextRuleIs.apply(this.grammarAccess.getExprLibraryRule()))
					.findFirst()
					.orElseGet(null);
		} else if (semanticObject instanceof ExprSubclause) {
			result = contextFinder.findByContents(semanticObject, null)
					.stream()
					.filter(contextRuleIs.apply(this.grammarAccess.getExprSubclauseRule()))
					.findFirst()
					.orElseGet(null);
		} else {
			result = super.getIContext(semanticObject);
		}
		return result;
	}
}
