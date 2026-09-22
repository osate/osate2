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
package org.osate.xtext.aadl2.ba.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.ProcessorClassifier;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.errorreporting.AbstractAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.ParseUtil;
import org.osate.annexsupport.ParseResultHolder;
import org.osate.ba.aadlba.BehaviorPropertyConstant;
import org.osate.ba.aadlba.ClassifierFeaturePropertyReference;
import org.osate.ba.aadlba.ClassifierPropertyReference;
import org.osate.ba.aadlba.DataRepresentation;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.ba.aadlba.PropertySetPropertyReference;
import org.osate.ba.aadlba.SubprogramCallAction;
import org.osate.ba.aadlba.util.AadlBaSwitch;
import org.osate.ba.analyzers.AadlBaInitializationChecker;
import org.osate.ba.analyzers.AadlBaRulesCheckersDriver;
import org.osate.ba.analyzers.AadlBaTypeChecker;
import org.osate.ba.analyzers.AdaLikeDataTypeChecker;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.ba.utils.DimensionException;
import org.osate.ba.utils.SubprogramCallUtil;
import org.osate.utils.internal.names.DataModelProperties;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayIndex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ArrayDimension;
import org.osate.xtext.aadl2.ba.behaviorAnnex.AssignmentAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorIntegerLiteral;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorStateGroup;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTime;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorVariable;
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.InternalCondition;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ModeSwitchTrigger;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.TimedAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnaryExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression;
import org.osate.xtext.aadl2.ba.behaviorAnnex.util.BehaviorAnnexSwitch;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator.TranslationResult;

import com.google.inject.Inject;

/**
 * Runs the existing strict-model Behavior Annex checkers over the translated Xtext model and retargets their
 * diagnostics to the declarative source objects. Naming, syntax, and linking failures gate this adapter so semantic
 * checking does not cascade over an incomplete model. Literal spellings that the grammar accepts but translation
 * cannot represent are reported directly, since no strict object carries them.
 */
public final class BehaviorAnnexValidator extends AbstractBehaviorAnnexValidator {
	public static final String DECLARATION_NAME = "org.osate.xtext.aadl2.ba.declarationName";
	public static final String CHECKER_DIAGNOSTIC = "org.osate.xtext.aadl2.ba.checker";
	public static final String UNREPRESENTABLE_LITERAL = "org.osate.xtext.aadl2.ba.unrepresentableLiteral";
	public static final String INTERNAL_PORT_USE = "org.osate.xtext.aadl2.ba.internalPortUse";
	public static final String INTERNAL_CONDITION_PORT = "org.osate.xtext.aadl2.ba.internalConditionPort";
	public static final String EXTERNAL_CONDITION_TRIGGER = "org.osate.xtext.aadl2.ba.externalConditionTrigger";
	public static final String FROZEN_PORT = "org.osate.xtext.aadl2.ba.frozenPort";
	public static final String TIMEOUT_RESET_PORT = "org.osate.xtext.aadl2.ba.timeoutResetPort";
	public static final String TIMEOUT_RESET_PORT_TIME = "org.osate.xtext.aadl2.ba.timeoutResetPortTime";
	public static final String ITERATIVE_VARIABLE_TARGET = "org.osate.xtext.aadl2.ba.iterativeVariableTarget";
	public static final String ITERATED_VALUES = "org.osate.xtext.aadl2.ba.iteratedValues";
	public static final String ITERATOR_CLASSIFIER = "org.osate.xtext.aadl2.ba.iteratorClassifier";
	public static final String ARRAY_SIZE = "org.osate.xtext.aadl2.ba.arraySize";
	public static final String PROPERTY_REFERENCE_VALUE = "org.osate.xtext.aadl2.ba.propertyReferenceValue";
	public static final String PROPERTY_FIELD = "org.osate.xtext.aadl2.ba.propertyField";
	public static final String PROPERTY_REFERENCE_UNITS = "org.osate.xtext.aadl2.ba.propertyReferenceUnits";
	public static final String MODE_REFINEMENT = "org.osate.xtext.aadl2.ba.modeRefinement";
	public static final String EXTERNAL_CONDITION_IN_MODES = "org.osate.xtext.aadl2.ba.externalConditionInModes";
	public static final String UNARY_PLUS = "org.osate.xtext.aadl2.ba.unaryPlus";
	public static final String PORT_STATUS_DIRECTION = "org.osate.xtext.aadl2.ba.portStatusDirection";
	public static final String COMMUNICATION_ACTION = "org.osate.xtext.aadl2.ba.communicationAction";
	public static final String INTEGER_VALUE = "org.osate.xtext.aadl2.ba.integerValue";
	public static final String ASSIGNMENT_TARGET_DIRECTION = "org.osate.xtext.aadl2.ba.assignmentTargetDirection";
	public static final String PROCESSOR_BINDING = "org.osate.xtext.aadl2.ba.processorBinding";
	private static final URI VALIDATION_RESOURCE_URI = URI.createURI("validation:/behavior-annex.aadlba");

	@Inject
	private DeclarativeToStrictTranslator translator;

	@Override
	protected List<EPackage> getEPackages() {
		return List.of(BehaviorAnnexPackage.eINSTANCE);
	}

	@Override
	public boolean isLanguageSpecific() {
		// Embedded annex objects live in an AADL Xtext resource, but this validator owns only the BA EPackage.
		return false;
	}

	@Check(CheckType.NORMAL)
	public void checkBehaviorAnnex(final BehaviorAnnex source) {
		if (!(source.getContainingClassifier() instanceof ComponentClassifier owner)) {
			return;
		}
		var checks = new DeclarativeChecks(source);
		checks.doSwitch(source);
		for (var contents = source.eAllContents(); contents.hasNext();) {
			checks.doSwitch(contents.next());
		}
		var parseResult = ParseResultHolder.Factory.INSTANCE.adapt(source).getParseResult();
		if (!checkDeclarationNames(checks.declarations, owner) || parseResult != null && parseResult.hasSyntaxErrors()
				|| checks.hasUnresolvedReference || !checkCompleteModeStates(source, checks.completeStates, owner)) {
			return;
		}

		var translation = translator.translate(source, owner);
		// Each check describes a use no strict checker can reject, and a model can get each one wrong independently,
		// so report them all before deciding whether the strict checkers have a model to work on.
		var representable = true;
		for (var check : checks.pendingChecks) {
			representable &= check.test(translation);
		}
		// The strict model does carry a property reference that denotes no value, so this one is not a gate: the strict
		// checkers keep their model and whatever else they have to say about it.
		var propertyChecks = new PropertyReferenceChecks(translation);
		for (var contents = translation.getStrictAnnex().eAllContents(); contents.hasNext();) {
			propertyChecks.doSwitch(contents.next());
		}
		if (!representable) {
			return;
		}
		var strictAnnex = translation.getStrictAnnex();
		synchronized (strictAnnex) {
			var validationResource = new ResourceImpl(VALIDATION_RESOURCE_URI);
			validationResource.getContents().add(strictAnnex);
			try {
				// One declarative transition becomes one strict transition per source state, so a rule that constrains
				// the transition reports once per source state. Those reports collapse onto the same declarative
				// object with the same message, and repeating them tells the user nothing.
				var reported = new HashSet<Report>();
				var errorManager = new AnalysisErrorReporterManager(
						resource -> new ValidatorErrorReporter(resource, this, translation, reported));
				var dataTypeChecker = new AdaLikeDataTypeChecker(errorManager);
				var typeChecker = new AadlBaTypeChecker(strictAnnex, owner, dataTypeChecker, errorManager);
				if (typeChecker.checkResolution()) {
					typeChecker.checkResolvedTypes();
					new AadlBaInitializationChecker(strictAnnex, errorManager).check();
					new AadlBaRulesCheckersDriver(strictAnnex, owner, errorManager).process(strictAnnex);
				}
			} finally {
				validationResource.getContents().clear();
			}
		}
	}

	/**
	 * Collects checks during the one source-model walk. Translation must wait until all declarations and unresolved
	 * links have been checked, so the switch queues node-local checks rather than running them while visiting.
	 * The caller owns containment traversal; switch results never prune children.
	 */
	private final class DeclarativeChecks extends BehaviorAnnexSwitch<Void> {
		private final List<Declaration> declarations = new ArrayList<>();
		private final List<BehaviorState> completeStates = new ArrayList<>();
		private final List<Predicate<TranslationResult>> pendingChecks = new ArrayList<>();
		private final boolean inModes;
		private final ComponentClassifier owner;
		private boolean hasUnresolvedReference;

		private DeclarativeChecks(final BehaviorAnnex source) {
			inModes = DeclarativeToStrictTranslator.hasInModes(source);
			owner = (ComponentClassifier) source.getContainingClassifier();
		}

		@Override
		public Void doSwitch(final EObject object) {
			hasUnresolvedReference = hasUnresolvedReference || hasUnresolvedCrossReference(object);
			return super.doSwitch(object);
		}

		@Override
		public Void caseBehaviorVariable(final BehaviorVariable variable) {
			declarations.add(new Declaration(variable.getName(), variable,
					BehaviorAnnexPackage.eINSTANCE.getBehaviorVariable_Name(), false));
			return null;
		}

		@Override
		public Void caseBehaviorState(final BehaviorState state) {
			var complete = state.eContainer() instanceof BehaviorStateGroup group && group.isComplete();
			declarations.add(new Declaration(state.getName(), state,
					BehaviorAnnexPackage.eINSTANCE.getBehaviorState_Name(), complete));
			if (complete) {
				completeStates.add(state);
			}
			return null;
		}

		@Override
		public Void caseBehaviorTransition(final BehaviorTransition transition) {
			declarations.add(new Declaration(transition.getName(), transition,
					BehaviorAnnexPackage.eINSTANCE.getBehaviorTransition_Name(), false));
			if (inModes) {
				pendingChecks.add(translation -> {
					checkExternalConditionInModes(transition);
					return true;
				});
			}
			return null;
		}

		@Override
		public Void caseArrayDimension(final ArrayDimension dimension) {
			pendingChecks.add(translation -> checkArraySize(dimension));
			return null;
		}

		@Override
		public Void caseBehaviorTime(final BehaviorTime time) {
			pendingChecks.add(translation -> {
				checkIntegerValue(time.getValue(), "Behavior time", translation, owner);
				return true;
			});
			return null;
		}

		@Override
		public Void caseArrayIndex(final ArrayIndex index) {
			pendingChecks.add(translation -> {
				checkIntegerValue(index.getValue(), "Array index", translation, owner);
				return true;
			});
			return null;
		}

		@Override
		public Void caseTimedAction(final TimedAction action) {
			pendingChecks.add(translation -> checkProcessorBindings(action));
			return null;
		}

		@Override
		public Void caseForStatement(final ForStatement loop) {
			pendingChecks.add(translation -> checkIteratorClassifier(loop));
			pendingChecks.add(translation -> checkIteratedValues(loop, translation));
			return null;
		}

		@Override
		public Void caseReference(final Reference reference) {
			pendingChecks.add(translation -> checkInternalPortUse(reference, translation));
			return null;
		}

		@Override
		public Void caseInternalCondition(final InternalCondition condition) {
			pendingChecks.add(translation -> checkInternalConditionPorts(condition, translation));
			return null;
		}

		@Override
		public Void caseModeSwitchTrigger(final ModeSwitchTrigger trigger) {
			pendingChecks.add(translation -> checkExternalConditionTrigger(trigger, translation));
			return null;
		}

		@Override
		public Void caseDispatchCondition(final DispatchCondition condition) {
			pendingChecks.add(translation -> checkFrozenPorts(condition, translation));
			return null;
		}

		@Override
		public Void caseDispatchTriggerCondition(final DispatchTriggerCondition timeout) {
			pendingChecks.add(translation -> checkTimeoutResetPorts(timeout, translation));
			return null;
		}

		@Override
		public Void caseAssignmentAction(final AssignmentAction action) {
			pendingChecks.add(translation -> checkIteratorTarget(action.getTarget(), translation));
			pendingChecks.add(translation -> checkAssignmentTargetDirection(action.getTarget(), translation));
			return null;
		}

		@Override
		public Void caseCommunicationAction(final CommunicationAction action) {
			pendingChecks.add(translation -> checkCommunicationAction(action, translation, owner));
			if (action.isDequeue()) {
				pendingChecks.add(translation -> checkIteratorTarget(action.getTarget(), translation));
			}
			return null;
		}

		@Override
		public Void caseReferenceExpression(final ReferenceExpression expression) {
			if (expression.isCount() || expression.isFresh() || expression.isUpdated()) {
				pendingChecks.add(translation -> {
					checkPortStatusValue(expression, expression.getReference(), translation);
					return true;
				});
			}
			return null;
		}

		@Override
		public Void caseUnindexedReferenceExpression(final UnindexedReferenceExpression expression) {
			if (expression.isCount() || expression.isFresh() || expression.isUpdated()) {
				pendingChecks.add(translation -> {
					checkPortStatusValue(expression, expression.getReference(), translation);
					return true;
				});
			}
			return null;
		}
	}

	/** Checks property values and units together during the one strict-model walk owned by this adapter. */
	private final class PropertyReferenceChecks extends AadlBaSwitch<Void> {
		private final TranslationResult translation;
		private final Set<EObject> reportedUnits = new HashSet<>();

		private PropertyReferenceChecks(final TranslationResult translation) {
			this.translation = translation;
		}

		@Override
		public Void casePropertySetPropertyReference(final PropertySetPropertyReference reference) {
			checkPropertyReferenceValue(reference, translation);
			// Continue to casePropertyReference so this same reference is also checked for units.
			return null;
		}

		@Override
		public Void casePropertyReference(final PropertyReference reference) {
			if (reference.getProperties().isEmpty()) {
				return null;
			}
			if (checkEnumerators(reference, translation)) {
				checkPropertyReferenceUnits(reference,
						AadlBaUtils.getPropertyType(reference.getProperties().getLast().getProperty()), translation,
						reportedUnits);
			}
			return null;
		}

		@Override
		public Void caseBehaviorPropertyConstant(final BehaviorPropertyConstant constant) {
			if (constant.getProperty() != null) {
				checkPropertyReferenceUnits(constant, constant.getProperty().getPropertyType(), translation,
						reportedUnits);
			}
			return null;
		}
	}

	/**
	 * AS5506/3 Rev A D.3 requires each behavior-variable array size to be the integer value constant of D.7: an integer
	 * literal or a property reference. The shared integer-value grammar also accepts an ordinary reference expression,
	 * which names a value variable rather than a constant, and no strict checker constrains an array size. A reference
	 * expression with a property tail is a property reference, so reject only one without a tail. The value a property
	 * reference denotes belongs to a component instance, so whether it can be read from the declarative model says
	 * nothing about the legality of the declaration and is not checked here.
	 *
	 * @return {@code true} when the declared array size is an integer value constant
	 */
	private boolean checkArraySize(final ArrayDimension dimension) {
		var size = dimension.getSize();
		if (size instanceof ReferenceExpression reference && reference.getProperty() == null) {
			var written = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(size));
			error("Array size '" + written + "' must be an integer literal or a property reference", size, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ARRAY_SIZE);
			return false;
		}
		return true;
	}

	/**
	 * AS5506/3 Rev A D.6 restricts every classifier in a computation binding to a processor classifier. The grammar
	 * resolves a general component classifier, while the strict model can carry only processor classifiers, so reject
	 * each invalid entry before translation's category filter can silently discard it.
	 *
	 * @return {@code true} when every written binding is a processor classifier
	 */
	private boolean checkProcessorBindings(final TimedAction action) {
		var valid = true;
		for (var i = 0; i < action.getProcessors().size(); i++) {
			var classifier = action.getProcessors().get(i);
			if (!(classifier instanceof ProcessorClassifier)) {
				error("'" + classifier.getQualifiedName() + "' is not a processor classifier: computation bindings can only"
						+ " name processor classifiers", action,
						BehaviorAnnexPackage.eINSTANCE.getTimedAction_Processors(), i, PROCESSOR_BINDING);
				valid = false;
			}
		}
		return valid;
	}

	/**
	 * D.7 uses the broad {@code integer_value} syntax for behavior-time magnitudes and array indices, so the parser can
	 * put a reference to any value variable in either position. Check the translated value because it has the resolved
	 * declaration and the same data-representation rules used by the strict type checker. An unknown representation is
	 * not a proven mismatch and retains its resolution or classifier diagnostics without an additional error here.
	 */
	private void checkIntegerValue(final org.osate.xtext.aadl2.ba.behaviorAnnex.IntegerValue value,
			final String position, final TranslationResult translation, final ComponentClassifier owner) {
		var strict = translation.getStrict(value);
		if (strict == null && value instanceof ReferenceExpression reference) {
			strict = translation.getStrict(reference.getProperty() == null ? reference.getReference()
					: reference.getProperty());
		}
		if (!(strict instanceof Element strictValue)) {
			return;
		}
		try {
			var type = AadlBaUtils.getTypeHolder(strictValue, owner);
			if (type.getDataRep() != DataRepresentation.INTEGER
					&& type.getDataRep() != DataRepresentation.UNKNOWN) {
				error(position + " must have integer type, found '" + type + "'", value, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INTEGER_VALUE);
			}
		} catch (DimensionException | UnsupportedOperationException exception) {
			// Existing dimension, resolution, or unsupported-type diagnostics own values that cannot be classified here.
		}
	}

	/**
	 * The AS5506/3 Rev A D.6 {@code for} and {@code forall} productions write the iterator classifier as a
	 * data_unique_component_classifier_reference, and an iterative variable is typed by a data classifier alone, so a
	 * classifier of any other category has nothing to become in the strict model. Because the same production leaves the
	 * classifier out altogether, letting it pass would not leave the declaration rejected either: the iterated values
	 * would supply the iterator's type as if nothing had been written. Report it on the reference the loop writes.
	 *
	 * @return {@code true} when the written iterator classifier is a data classifier
	 */
	private boolean checkIteratorClassifier(final ForStatement loop) {
		if (loop.getDataClassifier() != null && !(loop.getDataClassifier() instanceof DataClassifier)) {
			error("'" + loop.getDataClassifier().getName() + "' is not a data classifier: a for or forall iterator can"
					+ " only name a data component classifier", loop,
					BehaviorAnnexPackage.eINSTANCE.getForStatement_DataClassifier(),
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ITERATOR_CLASSIFIER);
			return false;
		}
		return true;
	}

	/**
	 * D.5 defines {@code count}, {@code fresh}, and {@code updated} in terms of receiving or freezing input, so none has
	 * a defined value on an outgoing port. The D.7 value-variable grammar nevertheless names a general port for all
	 * three suffixes, and neither D.5 nor D.7 states a corresponding legality rule. Enforce the semantics shared by the
	 * three definitions, while accepting both incoming and bidirectional ports because both are frozen on input.
	 */
	private void checkPortStatusValue(final EObject value, final EObject reference,
			final TranslationResult translation) {
		if (translation.getResolvedReference(reference) instanceof Port port
				&& AadlBaUtils.getDirectionType(port) == DirectionType.OUT) {
			var written = NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(value));
			error("Port status value '" + written + "' is defined only for a port that is frozen on input, but '"
					+ port.getName() + "' is an outgoing port. AS5506/3 Rev. A states no corresponding legality rule.",
					value, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, PORT_STATUS_DIRECTION);
		}
	}

	/**
	 * The first AS5506/3 Rev A D.7 property_reference alternative writes a property value name after {@code #} with no
	 * element before it, so the reference names a property definition without naming anything that holds a value for it.
	 * The only value such a reference can denote is the default value of the property, and translation puts that default
	 * in the property name holder. A property with no default value leaves the definition itself there, which denotes no
	 * value at all, and no strict checker rejects it. Report the reference as written. A reference that names a property
	 * type keeps its own value, an enumeration literal, so it is not one of these.
	 */
	private void checkPropertyReferenceValue(final PropertySetPropertyReference reference,
			final TranslationResult translation) {
		// A property-set property reference is the translation of the alternative that names no element, and its
		// first property name holds the default value when the property has one.
		if (reference.getProperties().isEmpty()
				|| !(reference.getProperties().getFirst().getProperty().getElement() instanceof Property property)) {
			return;
		}
		var written = sourceFor(reference, translation);
		error("Property reference '" + NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(written))
				+ "' has no value: property '" + property.getName() + "' has no default value and the reference"
				+ " names no element that has a value for it", written, null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, PROPERTY_REFERENCE_VALUE);
	}

	/**
	 * A field selected on {@code Data_Model::Enumerators} names an enumerator of the prefixed enumeration, and the
	 * enumerators are exactly the strings of that list, so a field that resolved to nothing is a name that is not one
	 * of them. Only this property is checked: an unresolved holder is not an error in general, because a legal range
	 * bound and a record field of a property that has no value also resolve to nothing.
	 *
	 * @return {@code true} when the reference selects no unknown enumerator
	 */
	private boolean checkEnumerators(final PropertyReference reference, final TranslationResult translation) {
		var primary = reference.getProperties().getFirst().getProperty().getElement();
		if (!(primary instanceof Property property)
				|| !DataModelProperties.ENUMERATORS.equalsIgnoreCase(property.getName())) {
			return true;
		}
		var resolved = true;
		for (var holder : reference.getProperties().subList(1, reference.getProperties().size())) {
			if (holder.getProperty() == null || holder.getProperty().getElement() != null) {
				continue;
			}
			var written = sourceFor(holder, translation);
			var name = written instanceof NamedPropertyField field ? field.getName()
					: NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(written));
			error("'" + name + "' is not an enumerator of '" + enumerationName(reference) + "'", written, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, PROPERTY_FIELD);
			resolved = false;
		}
		return resolved;
	}

	private static String enumerationName(final PropertyReference reference) {
		if (reference instanceof ClassifierPropertyReference classifierReference
				&& classifierReference.getClassifier() != null) {
			return classifierReference.getClassifier().getQualifiedName();
		}
		if (reference instanceof ClassifierFeaturePropertyReference featureReference
				&& featureReference.getComponent() != null
				&& featureReference.getComponent().getElement() != null) {
			return featureReference.getComponent().getElement().getName();
		}
		return DataModelProperties.ENUMERATORS;
	}

	/**
	 * D.7 permits only unitless or time-valued property references. Inspect the declared type of the selected property
	 * or record field, including when its holder carries a default expression. Prefixed references stay symbolic:
	 * neither an effective instance value nor its written unit is needed to check the declared units type.
	 */
	private void checkPropertyReferenceUnits(final EObject value, final PropertyType declaredType,
			final TranslationResult translation, final Set<EObject> reported) {
		var type = AadlUtil.getBasePropertyType(declaredType);
		if (type instanceof RangeType range) {
			type = range.getNumberType();
		}
		if (!(type instanceof NumberType number)) {
			return;
		}
		var units = number.getUnitsType();
		if (units != null && !"AADL_Project::Time_Units".equalsIgnoreCase(units.getQualifiedName())) {
			var source = sourceFor(value, translation);
			// Translation can copy a condition for multiple source states; report the written reference once.
			if (reported.add(source)) {
				error("Behavior Annex property references must be unitless or use AADL_Project::Time_Units", source,
						null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, PROPERTY_REFERENCE_UNITS);
			}
		}
	}

	/**
	 * AS5506/3 Rev A names an internal port in the D.3 internal_condition production and in the D.6 target and
	 * communication_action productions only. The grammar accepts a generic reference everywhere else, so an internal
	 * port can be written where the standard admits an incoming port and where the strict model has nothing to carry
	 * it. Report each such reference and leave the strict-model checkers out of it, the way a linking failure already
	 * gates them.
	 *
	 * @return {@code true} when the reference uses an internal port as the standard admits
	 */
	private boolean checkInternalPortUse(final Reference reference, final TranslationResult translation) {
		if (translation.getResolvedReference(reference) instanceof InternalFeature internalPort
				&& !isStandardInternalPortUse(reference)) {
			error("'" + internalPort.getName() + "' is an internal port: it can only be an assignment or dequeue"
					+ " target, the port of a send action, or a port of an internal condition", reference, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, INTERNAL_PORT_USE);
			return false;
		}
		return true;
	}

	/** Checks written operands before strict translation can hide an invalid target or extra send value. */
	private boolean checkCommunicationAction(CommunicationAction action, TranslationResult translation,
			ComponentClassifier owner) {
		var reference = action.getReference();
		if (reference == null) {
			return true; // Wildcard lock and unlock actions have no individual target.
		}
		var resolved = translation.getResolvedReference(reference);
		if (resolved instanceof InternalFeature && !action.isSend()) {
			return true; // checkInternalPortUse already diagnoses this use.
		}
		if (action.isLock() || action.isUnlock()) {
			return resolved instanceof DataAccess access && isRequiredAccess(reference, access, translation)
					|| communicationError(reference, "A lock or unlock action requires a required data access");
		}
		if (action.isFreeze()) {
			return resolved instanceof Port && hasDirection(reference, translation, true)
					|| communicationError(reference, "A freeze action requires an incoming port");
		}
		if (action.isDequeue()) {
			var valid = (resolved instanceof EventPort || resolved instanceof EventDataPort)
					&& hasDirection(reference, translation, true);
			if (!valid) {
				return communicationError(reference, "A dequeue action requires an incoming event or event data port");
			}
			if (action.getTarget() != null) {
				if (resolved instanceof EventPort) {
					return communicationError(action, "An event port dequeue action cannot assign a data value");
				}
				if (referenceRoot(action.getTarget(), translation) instanceof ForStatement) {
					return true; // checkIteratorTarget owns the diagnostic for a dequeue into an iterator.
				}
				return isWritable(action.getTarget(), translation)
						|| communicationError(action.getTarget(), "A dequeue target must be writable");
			}
			return true;
		}
		if (resolved instanceof Port || resolved instanceof InternalFeature) {
			var valid = true;
			if (resolved instanceof Port && !hasDirection(reference, translation, false)) {
				valid = communicationError(reference, "A port send action requires an outgoing port");
			}
			if (action.getParameters().size() > 1) {
				valid = communicationError(action, "A port send action accepts at most one value");
			} else if (resolved instanceof EventPort && !action.getParameters().isEmpty()) {
				valid = communicationError(action, "An event port send action cannot carry a value");
			}
			return valid;
		}
		if (!(translation.getStrict(action) instanceof SubprogramCallAction call) || call.getSubprogram() == null) {
			return communicationError(reference,
					"A send or call action requires a port, internal feature, or callable subprogram");
		}
		var classifier = SubprogramCallUtil.getClassifier(call.getSubprogram(), owner);
		if (classifier == null) {
			return true; // An unconstrained, unbound prototype has no signature to check yet.
		}
		var formals = SubprogramCallUtil.getFormals(classifier);
		if (formals.size() != action.getParameters().size()) {
			return communicationError(action,
					"Subprogram call requires " + formals.size() + " actuals but has " + action.getParameters().size());
		}
		var valid = true;
		for (var i = 0; i < formals.size(); i++) {
			var formal = formals.get(i);
			var actual = action.getParameters().get(i);
			var actualReference = plainReference(actual);
			if (formal instanceof Parameter parameter) {
				if (parameter.isOut() && (actualReference == null || !isWritable(actualReference, translation))) {
					valid = communicationError(actual, "Actual for " + parameter.getDirection().getLiteral()
							+ " parameter '" + formal.getName() + "' must be a writable target");
				} else if (parameter.isIn() && !isReadable(actual, translation)) {
					valid = communicationError(actual, "Actual for " + parameter.getDirection().getLiteral()
							+ " parameter '" + formal.getName() + "' must be readable");
				}
			} else if (formal instanceof DataAccess) {
				if (actualReference == null || !isDataReference(actualReference, translation)) {
					valid = communicationError(actual,
							"Actual for data access '" + formal.getName() + "' must reference data");
				}
				// Access_Right is an effective instance property, not a source-level direction.
			} else if (formal instanceof Port port) {
				if (actualReference == null
						|| !(translation.getResolvedReference(actualReference) instanceof Port actualPort)
						|| port.eClass() != actualPort.eClass()
						|| port.isIn() && !hasDirection(actualReference, translation, true)
						|| port.isOut() && !hasDirection(actualReference, translation, false)) {
					valid = communicationError(actual, "Actual for port '" + formal.getName()
							+ "' must reference a port of the same category and direction");
				}
			} else {
				// Do not omit an unrepresentable formal and shift every subsequent actual to the wrong feature.
				valid = communicationError(actual,
						"Feature '" + formal.getName() + "' is not supported as a Behavior Annex call parameter");
			}
		}
		return valid;
	}

	private boolean communicationError(EObject source, String message) {
		error(message, source, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, COMMUNICATION_ACTION);
		return false;
	}

	private static Reference plainReference(org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression) {
		return expression instanceof ReferenceExpression reference && reference.getProperty() == null
				&& !reference.isCount() && !reference.isFresh() && !reference.isUpdated() && !reference.isDequeue()
						? reference.getReference()
						: null;
	}

	/** Direction of an owner feature, accounting for each enclosing inverse feature group. */
	private static boolean hasDirection(Reference reference, TranslationResult translation, boolean incoming) {
		var inverse = featureInversion(reference, translation);
		return inverse != null && translation.getResolvedReference(reference) instanceof DirectedFeature feature
				&& (incoming ^ inverse ? feature.isIn() : feature.isOut());
	}

	private static boolean isRequiredAccess(Reference reference, DataAccess access, TranslationResult translation) {
		var inverse = featureInversion(reference, translation);
		return inverse != null && (access.getKind() == AccessType.REQUIRES) != inverse;
	}

	/** Returns null for paths that do not name a feature of the owner or its feature groups. */
	private static Boolean featureInversion(Reference reference, TranslationResult translation) {
		var segments = new ArrayList<>(reference.getSegments());
		for (var tail : reference.getTails()) {
			if (!".".equals(tail.getSeparator())) {
				return null;
			}
			segments.add(tail.getSegment());
		}
		var inverse = false;
		for (var i = 0; i < segments.size() - 1; i++) {
			if (!(translation.getResolvedReference(segments.get(i)) instanceof FeatureGroup group)) {
				return null;
			}
			inverse ^= group.isInverse();
			var type = group.getAllFeatureGroupType();
			inverse ^= type != null && type.getInverse() != null;
		}
		return inverse;
	}

	private static boolean isDataReference(Reference reference, TranslationResult translation) {
		var root = referenceRoot(reference, translation);
		return root instanceof DataSubcomponent || root instanceof DataAccess || root instanceof Parameter
				|| root instanceof BehaviorVariable;
	}

	private static EObject referenceRoot(Reference reference, TranslationResult translation) {
		var segments = new ArrayList<>(reference.getSegments());
		reference.getTails().forEach(tail -> segments.add(tail.getSegment()));
		for (var segment : segments) {
			var resolved = translation.getResolvedReference(segment);
			if (!(resolved instanceof FeatureGroup)) {
				return resolved;
			}
		}
		return null;
	}

	private static boolean isWritable(Reference reference, TranslationResult translation) {
		if (!(translation.getStrict(reference) instanceof org.osate.ba.aadlba.Target)
				|| reference.getSegments().isEmpty()
				|| translation.getResolvedReference(reference) instanceof EventPort) {
			return false;
		}
		var root = referenceRoot(reference, translation);
		if (root instanceof ForStatement) {
			return false;
		}
		if (root instanceof Parameter parameter) {
			return parameter.isOut();
		}
		if (translation.getResolvedReference(reference) instanceof Port) {
			return hasDirection(reference, translation, false);
		}
		return isDataReference(reference, translation)
				|| translation.getResolvedReference(reference) instanceof org.osate.aadl2.EventDataSource;
	}

	private static boolean isReadable(org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression expression,
			TranslationResult translation) {
		if (expression instanceof ReferenceExpression reference && !isReadableReference(reference, translation)) {
			return false;
		}
		for (var contents = expression.eAllContents(); contents.hasNext();) {
			if (contents.next() instanceof ReferenceExpression reference
					&& !isReadableReference(reference, translation)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isReadableReference(ReferenceExpression expression, TranslationResult translation) {
		if (expression.getProperty() != null || expression.isCount() || expression.isFresh() || expression.isUpdated()
				|| expression.isDequeue()) {
			return true;
		}
		var reference = expression.getReference();
		var root = referenceRoot(reference, translation);
		if (root instanceof Parameter parameter) {
			return parameter.isIn();
		}
		if (translation.getResolvedReference(reference) instanceof Port port) {
			return !(port instanceof EventPort) && hasDirection(reference, translation, true);
		}
		return isDataReference(reference, translation) || root instanceof ForStatement;
	}

	private static boolean isStandardInternalPortUse(final Reference reference) {
		if (reference.eContainer() instanceof AssignmentAction assignment) {
			return assignment.getTarget() == reference;
		}
		if (reference.eContainer() instanceof CommunicationAction action) {
			return action.getTarget() == reference || action.isSend() && action.getReference() == reference;
		}
		return reference.eContainer() instanceof InternalCondition condition
				&& condition.getInternalPorts().contains(reference);
	}

	/**
	 * The AS5506/3 Rev A D.3 internal_condition production lists internal_port_names, so every name in an internal
	 * condition must denote an internal event or internal event data feature of the owner. Any other name the annex can
	 * see, and any name it cannot resolve at all, has no internal port holder to become: translation drops it, and the
	 * condition would otherwise reach the strict checkers silently short of the ports the user wrote. Report the name
	 * as written, since an unresolved one has no element to name.
	 *
	 * @return {@code true} when the internal condition lists internal ports only
	 */
	private boolean checkInternalConditionPorts(final InternalCondition condition,
			final TranslationResult translation) {
		var accepted = true;
		for (var port : condition.getInternalPorts()) {
			if (!(translation.getResolvedReference(port) instanceof InternalFeature)) {
				error("'" + NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(port)) + "' is not an"
						+ " internal port: an internal condition can only list internal event or internal event data"
						+ " features", port, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						INTERNAL_CONDITION_PORT);
				accepted = false;
			}
		}
		return accepted;
	}

	/**
	 * D.3 external conditions name incoming event or event data ports. Also admit outgoing ports of a direct
	 * subcomponent, retaining that subcomponent as the strict port holder's context. Invalid names and reference
	 * paths cannot be represented faithfully, so report every written trigger and gate the strict checkers.
	 */
	private boolean checkExternalConditionTrigger(final ModeSwitchTrigger trigger,
			final TranslationResult translation) {
		if (trigger.getReference() != null) {
			var reference = trigger.getReference();
			var kind = externalConditionTriggerKind(reference, translation);
			if (kind != ExternalTriggerKind.VALID) {
				error("'" + NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(reference))
						+ "' is not an external-condition trigger: expected an incoming event or event data port"
						+ " of the component, or an outgoing event or event data port of a subcomponent", reference,
						null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, EXTERNAL_CONDITION_TRIGGER);
				// A wrong-direction port is still represented completely. Keep independent strict diagnostics,
				// including the prohibition on external conditions in subprograms, whose event ports are all out.
				return kind != ExternalTriggerKind.UNREPRESENTABLE;
			}
		}
		return true;
	}

	private enum ExternalTriggerKind {
		VALID, WRONG_DIRECTION, UNREPRESENTABLE
	}

	private static ExternalTriggerKind externalConditionTriggerKind(Reference reference,
			TranslationResult translation) {
		var resolved = translation.getResolvedReference(reference);
		if (!(resolved instanceof EventPort) && !(resolved instanceof EventDataPort)) {
			return ExternalTriggerKind.UNREPRESENTABLE;
		}
		var segments = new ArrayList<ReferenceSegment>(reference.getSegments());
		for (var tail : reference.getTails()) {
			if (!".".equals(tail.getSeparator())) {
				return ExternalTriggerKind.UNREPRESENTABLE;
			}
			segments.add(tail.getSegment());
		}
		var subcomponent = false;
		var inverse = false;
		for (var i = 0; i < segments.size() - 1; i++) {
			var segment = segments.get(i);
			var prefix = translation.getResolvedReference(segment);
			if (i == 0 && prefix instanceof Subcomponent) {
				// A context identifies a direct subcomponent, not an array element or a nested subcomponent path.
				if (!segment.getIndexes().isEmpty()) {
					return ExternalTriggerKind.UNREPRESENTABLE;
				}
				subcomponent = true;
			} else if (prefix instanceof FeatureGroup group) {
				inverse ^= group.isInverse();
				var type = group.getAllFeatureGroupType();
				inverse ^= type != null && type.getInverse() != null;
			} else {
				return ExternalTriggerKind.UNREPRESENTABLE;
			}
		}
		var port = (Port) resolved;
		var incoming = subcomponent ^ inverse ? port.isOut() : port.isIn();
		return incoming ? ExternalTriggerKind.VALID : ExternalTriggerKind.WRONG_DIRECTION;
	}

	/**
	 * The D.4 frozen-port list names incoming ports. A generic reference can instead resolve to a behavior variable or
	 * another declaration that has no strict {@code ActualPortHolder} representation. Report each such name at its
	 * source location and gate strict checking of the incomplete translated condition. Direction and the remaining D.4
	 * dispatch compatibility rules remain outside this representation boundary.
	 *
	 * @return {@code true} when every frozen-list reference denotes a port
	 */
	private boolean checkFrozenPorts(final DispatchCondition condition, final TranslationResult translation) {
		var accepted = true;
		for (var port : condition.getFrozenPorts()) {
			if (!(translation.getResolvedReference(port) instanceof Port)) {
				error("'" + NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(port))
						+ "' is not a frozen port: a frozen list can only name an incoming port", port, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, FROZEN_PORT);
				accepted = false;
			}
		}
		return accepted;
	}

	/**
	 * The AS5506/3 Rev A D.4 timeout_reset_port production names an event port or an event data port, and the
	 * production that takes the list, completion_relative_timeout_catch, requires a behavior time; the bare
	 * {@code timeout} is the dispatch relative catch and takes no list. The grammar accepts a generic reference here and
	 * leaves the time optional, so a timeout can list a name the strict model has no reset port for, and can list ports
	 * with no time to keep them beside. Report either, and leave the strict-model checkers out of a timeout short of the
	 * ports the user wrote. Report a name as written, since an unresolved one has no element to name.
	 *
	 * @return {@code true} when the reset-port list belongs to a completion relative timeout and lists
	 *         event or event data ports only
	 */
	private boolean checkTimeoutResetPorts(final DispatchTriggerCondition timeout,
			final TranslationResult translation) {
		if (timeout.getResetPorts().isEmpty()) {
			return true;
		}
		var accepted = true;
		if (timeout.getTime() == null) {
			error("A timeout with reset ports is a completion relative timeout, which must specify a behavior time",
					timeout, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, TIMEOUT_RESET_PORT_TIME);
			accepted = false;
		}
		for (var port : timeout.getResetPorts()) {
			var resolved = translation.getResolvedReference(port);
			if (!(resolved instanceof EventPort) && !(resolved instanceof EventDataPort)) {
				error("'" + NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(port)) + "' is not a"
						+ " timeout reset port: a completion relative timeout can only list event or event data"
						+ " ports", port, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, TIMEOUT_RESET_PORT);
				accepted = false;
			}
		}
		return accepted;
	}

	/**
	 * D.6 admits a target that names a behavior variable, a feature, or a data component, and forbids naming the
	 * element variable of an enclosing {@code for} or {@code forall}. The assignment action and the port dequeue action
	 * share that target production, and no strict checker can see either shape of the violation in either action: an
	 * iterator holder does not implement strict {@code Target}, so '{@code i := ...}' and '{@code p?(i)}' reach the
	 * checkers with no target at all, while '{@code i.field := ...}' and '{@code p?(i.field)}' become ordinary data
	 * component references that type check. Only the first segment of a target can name an iterator, and it is the
	 * segment the rule constrains, since writing one data element of the iterator writes part of the iterator.
	 *
	 * @return {@code true} when the assignment or dequeue target does not name an iterator
	 */
	private boolean checkIteratorTarget(final Reference target, final TranslationResult translation) {
		if (target == null || target.getSegments().isEmpty()) {
			return true;
		}
		var name = target.getSegments().get(0);
		if (translation.getResolvedReference(name) instanceof ForStatement loop) {
			error("Iterative variable '" + loop.getVariable()
					+ "' cannot be an assignment target: Behavior Annex D.6.(L2) legality rule failed.", name, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ITERATIVE_VARIABLE_TARGET);
			return false;
		}
		return true;
	}

	/**
	 * The AS5506/3 Rev A D.6 target production names an outgoing_port_name, and D.6 says in words that an assignment
	 * action assigns to an outgoing port: the action writes its target, while an incoming port holds a value the
	 * component reads. The only strict check an assignment target reaches is the type comparison of D.6's own legality
	 * rule, and an incoming data port of the assigned type passes it, so nothing rejects a write to a port the owner can
	 * only read. Check the port the target path passes through rather than the element the path ends at, because writing
	 * one data element of an incoming port's value writes that port too, and count each enclosing inverse feature group,
	 * which exchanges the direction its owner sees. Report the segment that names the port, which is the one the
	 * production constrains.
	 *
	 * @return {@code true} when the assignment target does not write a port the owner can only read
	 */
	private boolean checkAssignmentTargetDirection(final Reference target, final TranslationResult translation) {
		if (target == null) {
			return true;
		}
		var segments = new ArrayList<EObject>(target.getSegments());
		for (var tail : target.getTails()) {
			if (!".".equals(tail.getSeparator())) {
				return true; // A qualified name denotes a package or a classifier, not a feature of the owner.
			}
			segments.add(tail.getSegment());
		}
		var inverse = false;
		for (var segment : segments) {
			var resolved = translation.getResolvedReference(segment);
			if (resolved instanceof FeatureGroup group) {
				inverse ^= group.isInverse();
				var type = group.getAllFeatureGroupType();
				inverse ^= type != null && type.getInverse() != null;
			} else if (resolved instanceof Port port) {
				if (inverse ? port.isIn() : port.isOut()) {
					return true;
				}
				error("'" + port.getName() + "' is an incoming port" + (inverse ? " in an inverse feature group" : "")
						+ ": an assignment writes its target, and the AS5506/3 Rev. A D.6 target production admits an"
						+ " outgoing port, an internal port, an outgoing parameter, or a data component", segment, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ASSIGNMENT_TARGET_DIRECTION);
				return false;
			} else {
				// Every other target category is either checked elsewhere or has no port direction to constrain.
				return true;
			}
		}
		return true;
	}

	/**
	 * The AS5506/3 Rev A D.6 element_values production admits an integer range, an event data port name, or an array
	 * data component reference, and a data component reference starts with a data subcomponent, a data access feature,
	 * a local variable, or a data access feature prototype. D.6 gives the iterator of a for or forall the name scope of
	 * the construct, where it acts as a local variable, so an enclosing iterator is one of those names as well. The
	 * iterated values share the D.7 integer value grammar with the rest of the annex, which also accepts an integer
	 * literal, a property reference, and names that denote none of the above, and the strict model has no element values
	 * to carry any of them: translation drops them, and the loop would otherwise reach the strict checkers iterating
	 * nothing at all. Report the values as written, since an integer range never fails here and everything else is one
	 * expression.
	 *
	 * @return {@code true} when the loop iterates values the strict model can carry
	 */
	private boolean checkIteratedValues(final ForStatement loop, final TranslationResult translation) {
		if (loop.getValues() == null || !(translation.getStrict(loop) instanceof ForOrForAllStatement strict)
				|| strict.getIteratedValues() != null) {
			return true;
		}
		error("'" + NodeModelUtils.getTokenText(NodeModelUtils.findActualNodeFor(loop.getValues()))
				+ "' cannot be iterated: a for or forall iterates an integer range, an event data port, a parameter,"
				+ " or an array data component reference", loop.getValues(), null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, ITERATED_VALUES);
		return false;
	}

	/**
	 * D.3 names share one namespace, including inherited features, data subcomponents, and modes of the owner.
	 * Check the declarations before resolving references so missing classifiers cannot hide duplicate names, and
	 * skip the strict checkers when names are ambiguous instead of validating an arbitrary resolution.
	 */
	private boolean checkDeclarationNames(final List<Declaration> declarations, final ComponentClassifier owner) {
		Map<String, List<Declaration>> byName = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		for (var declaration : declarations) {
			// Transitions need not have a label; partially edited declarations may also lack a name.
			if (declaration.name() != null && !declaration.name().isEmpty()) {
				byName.computeIfAbsent(declaration.name(), key -> new ArrayList<>()).add(declaration);
			}
		}
		Map<String, String> enclosingNames = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		for (var feature : owner.getAllFeatures()) {
			if (feature.getName() != null) {
				enclosingNames.put(feature.getName(), "feature");
			}
		}
		if (owner instanceof ComponentImplementation implementation) {
			for (var subcomponent : implementation.getAllSubcomponents()) {
				if (subcomponent instanceof DataSubcomponent && subcomponent.getName() != null) {
					enclosingNames.put(subcomponent.getName(), "data subcomponent");
				}
			}
		}
		var modeNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for (var mode : owner.getAllModes()) {
			if (mode.getName() != null) {
				modeNames.add(mode.getName());
			}
		}

		var valid = true;
		for (var sameName : byName.values()) {
			for (var declaration : sameName) {
				if (sameName.size() > 1) {
					error("Duplicate Behavior Annex identifier '" + declaration.name() + "'", declaration.source(),
							declaration.feature(), DECLARATION_NAME);
					valid = false;
				}
				// A complete state may represent a same-named mode, but cannot reuse a feature or data name.
				var enclosingKind = enclosingNames.get(declaration.name());
				if (enclosingKind == null && modeNames.contains(declaration.name()) && !declaration.complete()) {
					enclosingKind = "mode";
				}
				if (enclosingKind != null) {
					error("Behavior Annex identifier '" + declaration.name() + "' conflicts with an enclosing "
							+ enclosingKind + " identifier", declaration.source(), declaration.feature(),
							DECLARATION_NAME);
					valid = false;
				}
			}
		}
		return valid;
	}

	/**
	 * In a subclause without an {@code in modes} statement, one complete state that names a mode makes the subclause a
	 * mode refinement. D.3 then requires every complete state in that subclause to name a mode.
	 */
	private boolean checkCompleteModeStates(final BehaviorAnnex source, final List<BehaviorState> completeStates,
			final ComponentClassifier owner) {
		if (!DeclarativeToStrictTranslator.canRefineModes(source)) {
			return true;
		}
		var modeNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for (var mode : owner.getAllModes()) {
			modeNames.add(mode.getName());
		}
		var firstModeState = completeStates.stream().filter(state -> modeNames.contains(state.getName())).findFirst();
		if (firstModeState.isEmpty()) {
			return true;
		}
		var modeStateName = firstModeState.orElseThrow().getName();
		var valid = true;
		for (var state : completeStates) {
			if (!modeNames.contains(state.getName())) {
				valid = false;
				error("Complete state '" + state.getName() + "' must be a mode identifier because complete state '"
						+ modeStateName + "' is a mode identifier: Behavior Annex D.3 legality rule failed.", state,
						BehaviorAnnexPackage.eINSTANCE.getBehaviorState_Name(), MODE_REFINEMENT);
			}
		}
		return valid;
	}

	/**
	 * D.3 does not allow an external condition in a subclause that carries an {@code in modes} statement: such a
	 * subclause applies in the modes it lists rather than describing mode transitions of its owner. Core AADL keeps the
	 * statement on the enclosing subclause and the strict model does not carry it, so this rule is checked here, like
	 * the complete-state mode-refinement rule, rather than by the strict-model checkers.
	 */
	private void checkExternalConditionInModes(final BehaviorTransition transition) {
		var condition = transition.getCondition();
		if (condition != null && condition.getModeSwitch() != null) {
			error("A Behavior Annex subclause with an in modes statement cannot use an external condition:"
					+ " Behavior Annex D.3 consistency rule failed.", condition, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, EXTERNAL_CONDITION_IN_MODES);
		}
	}

	private record Declaration(String name, EObject source, EStructuralFeature feature, boolean complete) {
	}

	/** AS5506/3 Rev. A D.7 defines minus as the only unary adding operator. */
	@Check(CheckType.FAST)
	public void checkUnaryPlus(final UnaryExpression expression) {
		if ("+".equals(expression.getOperator())) {
			warning("Unary plus is not part of AS5506/3 Rev. A", expression,
					BehaviorAnnexPackage.eINSTANCE.getUnaryExpression_Operator(), UNARY_PLUS);
		}
	}

	/**
	 * The integer literal terminal admits based, exponent, and long decimal spellings whose value the AADL integer
	 * reader cannot represent. Translation cannot carry such a literal into the strict model, so name the offending
	 * spelling on the literal itself rather than letting it become zero.
	 */
	@Check(CheckType.FAST)
	public void checkIntegerLiteral(final BehaviorIntegerLiteral literal) {
		checkIntegerLiteral(literal.getValue(), literal,
				BehaviorAnnexPackage.eINSTANCE.getBehaviorIntegerLiteral_Value());
	}

	@Check(CheckType.FAST)
	public void checkTransitionPriority(final BehaviorTransition transition) {
		checkIntegerLiteral(transition.getPriority(), transition,
				BehaviorAnnexPackage.eINSTANCE.getBehaviorTransition_Priority());
	}

	private void checkIntegerLiteral(final String value, final EObject owner, final EStructuralFeature feature) {
		if (value == null) {
			return;
		}
		try {
			ParseUtil.parseAadlInteger(value);
		} catch (final IllegalArgumentException exception) {
			error("Cannot represent integer literal " + value + ": " + exception.getMessage(), owner, feature,
					UNREPRESENTABLE_LITERAL);
		}
	}

	private static boolean hasUnresolvedCrossReference(final EObject object) {
		for (var reference : object.eClass().getEAllReferences()) {
			if (reference.isContainment() || reference.isContainer()) {
				continue;
			}
			var value = object.eGet(reference, false);
			if (value instanceof EObject target && target.eIsProxy()) {
				return true;
			}
			if (value instanceof List<?> targets) {
				for (var target : targets) {
					if (target instanceof EObject eObject && eObject.eIsProxy()) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void reportError(final Element strict, final String message, final TranslationResult translation,
			final Set<Report> reported) {
		var source = sourceFor(strict, translation);
		if (reported.add(new Report(source, Severity.ERROR, message))) {
			error(message, source, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CHECKER_DIAGNOSTIC);
		}
	}

	private void reportWarning(final Element strict, final String message, final TranslationResult translation,
			final Set<Report> reported) {
		var source = sourceFor(strict, translation);
		if (reported.add(new Report(source, Severity.WARNING, message))) {
			warning(message, source, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CHECKER_DIAGNOSTIC);
		}
	}

	private void reportInfo(final Element strict, final String message, final TranslationResult translation,
			final Set<Report> reported) {
		var source = sourceFor(strict, translation);
		if (reported.add(new Report(source, Severity.INFO, message))) {
			info(message, source, null, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, CHECKER_DIAGNOSTIC);
		}
	}

	private static EObject sourceFor(final EObject strict, final TranslationResult translation) {
		for (var current = strict; current != null; current = current.eContainer()) {
			var source = translation.getDeclarative(current);
			if (source != null) {
				return source;
			}
		}
		return translation.getDeclarative(translation.getStrictAnnex());
	}

	/** A diagnostic already handed to Xtext, so that the same message is not repeated on the same source object. */
	private record Report(EObject source, Severity severity, String message) {
	}

	private static final class ValidatorErrorReporter extends AbstractAnalysisErrorReporter {
		private final BehaviorAnnexValidator validator;
		private final TranslationResult translation;
		private final Set<Report> reported;

		private ValidatorErrorReporter(final Resource resource, final BehaviorAnnexValidator validator,
				final TranslationResult translation, final Set<Report> reported) {
			super(resource);
			this.validator = validator;
			this.translation = translation;
			this.reported = reported;
		}

		@Override
		protected void errorImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportError(where, message, translation, reported);
		}

		@Override
		protected void warningImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportWarning(where, message, translation, reported);
		}

		@Override
		protected void infoImpl(final Element where, final String message, final String[] attributes,
				final Object[] values) {
			validator.reportInfo(where, message, translation, reported);
		}

		@Override
		protected void deleteMessagesImpl() {
			// Xtext owns the diagnostic lifecycle.
		}
	}
}
