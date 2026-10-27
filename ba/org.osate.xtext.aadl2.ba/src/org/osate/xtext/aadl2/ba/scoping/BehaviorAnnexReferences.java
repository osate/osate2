/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ba.scoping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.StringLiteral;
import org.osate.ba.aadlba.DataRepresentation;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.utils.internal.PropertyUtils;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariableGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceTail;

/** Declarative reference and type operations shared by scoping and strict-model construction.
 * @since 2.0*/
public final class BehaviorAnnexReferences {
	private BehaviorAnnexReferences() {
	}

	public static ComponentClassifier owner(EObject context) {
		var annex = EcoreUtil2.getContainerOfType(context, BehaviorAnnex.class);
		return annex != null && annex.getContainingClassifier() instanceof ComponentClassifier classifier
				? classifier
				: null;
	}

	public static EObject target(EObject segment) {
		var result = switch (segment) {
		case ReferenceSegment reference -> reference.getName();
		case UnindexedReferenceSegment reference -> reference.getName();
		case NamedPropertyField field -> field.getName();
		case null, default -> null;
		};
		return result == null || result.eIsProxy() ? null : result;
	}

	public static List<EObject> segments(EObject reference) {
		var result = new ArrayList<EObject>();
		if (reference instanceof Reference indexed) {
			result.addAll(indexed.getSegments());
			indexed.getTails().forEach(tail -> result.add(tail.getSegment()));
		} else if (reference instanceof UnindexedReference unindexed) {
			result.addAll(unindexed.getSegments());
			unindexed.getTails().forEach(tail -> result.add(tail.getSegment()));
		}
		return result;
	}

	public static EObject lastTarget(EObject reference) {
		var segments = segments(reference);
		return segments.isEmpty() ? null : target(segments.getLast());
	}

	public static Classifier referenceClassifier(EObject reference) {
		var path = segments(reference);
		return path.isEmpty() ? null : segmentClassifier(path.getLast());
	}

	public static Classifier segmentClassifier(EObject segment) {
		return classifier(target(segment), bindingContext(segment));
	}

	public static Classifier bindingContext(EObject segment) {
		var container = segment == null ? null : segment.eContainer();
		if (container instanceof ReferenceTail
				|| container instanceof UnindexedReferenceTail) {
			var path = segments(container.eContainer());
			var index = path.indexOf(segment);
			if (index > 0) {
				return segmentClassifier(path.get(index - 1));
			}
		}
		return segment == null ? null : owner(segment);
	}

	public static String name(EObject declaration) {
		return switch (declaration) {
		case NamedElement named -> named.getName();
		case BehaviorVariable variable -> variable.getName();
		case ForStatement iterator -> iterator.getVariable();
		case StringLiteral literal -> literal.getValue();
		case null, default -> null;
		};
	}

	/** Retains the written spelling for diagnostics, including an unresolved or incomplete reference. */
	public static String writtenName(EObject source) {
		if (source instanceof NamedPropertyField field && field.getSelector() != null) {
			return field.getSelector();
		}
		var feature = source.eClass().getEStructuralFeature("name");
		if (feature != null) {
			var nodes = NodeModelUtils.findNodesForFeature(source, feature);
			if (!nodes.isEmpty()) {
				return NodeModelUtils.getTokenText(nodes.getFirst());
			}
		}
		return name(target(source));
	}

	public static Classifier classifier(EObject declaration, Classifier owner) {
		return classifier(declaration, owner, Collections.newSetFromMap(new IdentityHashMap<>()));
	}

	private static Classifier classifier(EObject declaration, Classifier owner, Set<EObject> visited) {
		if (declaration == null || declaration.eIsProxy() || !visited.add(declaration)) {
			return null;
		}
		if (declaration instanceof BehaviorVariable variable) {
			return ((BehaviorVariableGroup) variable.eContainer()).getDataClassifier();
		}
		if (declaration instanceof ForStatement loop) {
			if (loop.getDataClassifier() != null) {
				return loop.getDataClassifier();
			}
			if (loop.getValues() != null && loop.getValues().getUpper() == null
					&& loop.getValues().getLower() instanceof ReferenceExpression expression
					&& expression.getProperty() == null && !expression.isCount()) {
				var type = classifier(lastTarget(expression.getReference()), owner, visited);
				return elementClassifier(type);
			}
			return null;
		}
		if (declaration instanceof StringLiteral literal) {
			return structMemberClassifier(literal);
		}
		if (declaration instanceof Classifier classifier) {
			return classifier;
		}
		if (declaration instanceof Element element) {
			try {
				return AadlBaUtils.getClassifier(element, owner);
			} catch (UnsupportedOperationException exception) {
				return null;
			}
		}
		return null;
	}

	public static Classifier elementClassifier(Classifier classifier) {
		var visited = Collections.newSetFromMap(new IdentityHashMap<Classifier, Boolean>());
		while (classifier instanceof DataClassifier data && visited.add(classifier)
				&& AadlBaUtils.getDataRepresentation(data) == DataRepresentation.ARRAY) {
			var base = AadlBaUtils.getBaseType(data);
			classifier = base == null ? null : base.getClassifier();
		}
		return classifier;
	}

	/** Names are existing contained literals; scoping never creates detached StructUnionElement targets. */
	public static List<StringLiteral> structMembers(Classifier classifier) {
		classifier = elementClassifier(classifier);
		if (!(classifier instanceof DataClassifier data)) {
			return List.of();
		}
		var representation = AadlBaUtils.getDataRepresentation(data);
		if (representation != DataRepresentation.STRUCT && representation != DataRepresentation.UNION) {
			return List.of();
		}
		var result = new ArrayList<StringLiteral>();
		for (var value : PropertyUtils.findPropertyExpression(data, "Element_Names")) {
			if (value instanceof ListValue names) {
				for (var name : names.getOwnedListElements()) {
					if (name instanceof StringLiteral literal && structMemberClassifier(literal) != null) {
						result.add(literal);
					}
				}
			}
		}
		return result;
	}

	public static DataClassifier structMemberClassifier(StringLiteral literal) {
		var classifier = EcoreUtil2.getContainerOfType(literal, Classifier.class);
		if (classifier == null) {
			return null;
		}
		var names = PropertyUtils.findPropertyExpression(classifier, "Element_Names");
		var types = PropertyUtils.findPropertyExpression(classifier, "Base_Type");
		for (var i = 0; i < names.size() && i < types.size(); i++) {
			if (names.get(i) instanceof ListValue nameList && types.get(i) instanceof ListValue typeList) {
				var index = nameList.getOwnedListElements().indexOf(literal);
				if (index >= 0 && index < typeList.getOwnedListElements().size()
						&& typeList.getOwnedListElements().get(index) instanceof ClassifierValue value
						&& value.getClassifier() instanceof DataClassifier data) {
					return data;
				}
			}
		}
		return null;
	}
}
