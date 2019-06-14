package org.osate.expr.typing;

import java.util.stream.Collectors;

import org.eclipse.xsemantics.runtime.StringRepresentation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Type;
import org.osate.expr.expr.BagType;
import org.osate.expr.expr.EBoolean;
import org.osate.expr.expr.EBooleanLiteral;
import org.osate.expr.expr.EInteger;
import org.osate.expr.expr.EIntegerLiteral;
import org.osate.expr.expr.EReal;
import org.osate.expr.expr.ERealLiteral;
import org.osate.expr.expr.EString;
import org.osate.expr.expr.EStringLiteral;
import org.osate.expr.expr.EnumType;
import org.osate.expr.expr.ListType;
import org.osate.expr.expr.MapType;
import org.osate.expr.expr.RangeType;
import org.osate.expr.expr.RecordType;
import org.osate.expr.expr.SetType;
import org.osate.expr.expr.TupleType;
import org.osate.expr.expr.UnionType;

public class ExprStringRepresentation extends StringRepresentation {

	protected String stringRep(Classifier t) {
		return t.getQualifiedName();
	}

	protected String stringRep(EBoolean t) {
		return "bool";
	}

	protected String stringRep(EInteger t) {
		return "int";
	}

	protected String stringRep(EReal t) {
		return "real";
	}

	protected String stringRep(EString t) {
		return "string";
	}

	protected String stringRep(RangeType t) {
		return "range of " + rep(t.getType());
	}

	protected String stringRep(ListType t) {
		return "list of " + rep(t.getType());
	}

	protected String stringRep(SetType t) {
		return "set of " + rep(t.getType());
	}

	protected String stringRep(BagType t) {
		return "bag of " + rep(t.getType());
	}

	protected String stringRep(MapType t) {
		return "map " + rep(t.getDomain()) + " -> " + rep(t.getImage());
	}

	protected String stringRep(TupleType t) {
		return t.getFields().stream().map(f -> rep(f.getType())).collect(Collectors.joining("tuple (", ", ", ")"));
	}

	protected String stringRep(RecordType t) {
		return t.getFields().stream().map(f -> f.getName() + rep(f.getType()))
				.collect(Collectors.joining("record (", ", ", ")"));
	}

	protected String stringRep(UnionType t) {
		String text = "union";
		return text;
	}

	protected String stringRep(EnumType t) {
		return t.getLiterals().stream().map(l -> l.getName())
				.collect(Collectors.joining("enum (", ", ", ")"));
	}

	protected String stringRep(EBooleanLiteral l) {
		return Boolean.toString(l.isValue());
	}

	protected String stringRep(EIntegerLiteral l) {
		return Long.toString(l.getValue());
	}

	protected String stringRep(ERealLiteral l) {
		return Double.toString(l.getValue());
	}

	protected String stringRep(EStringLiteral l) {
		return l.getValue();
	}

	private String rep(Type t) {
		return t != null ? stringRep(t) : "<null>";
	}
}
