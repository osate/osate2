/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.errormodel.util;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.aadl2.GraphicalAnnexUtil;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.Color;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelGeUtil {
	private ErrorModelGeUtil() {
	}

	private static ErrorModelLibrary getOrCreateErrorModelLibrary(final AadlPackage pkg) {
		return GraphicalAnnexUtil.getOrCreateParsedAnnexLibrary(pkg, EMV2Util.ErrorModelAnnexName,
				ErrorModelPackage.eINSTANCE.getErrorModelLibrary(), ErrorModelLibrary.class);
	}

	public static Optional<ErrorModelLibrary> getErrorModelLibrary(final AadlPackage pkg) {
		return GraphicalAnnexUtil.getFirstParsedAnnexLibrary(pkg, EMV2Util.ErrorModelAnnexName,
				ErrorModelLibrary.class);
	}

	public static ErrorModelSubclause getOrCreateErrorModelSubclause(final Classifier classifier) {
		return GraphicalAnnexUtil.getOrCreateParsedAnnexSubclause(classifier, EMV2Util.ErrorModelAnnexName,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause(), ErrorModelSubclause.class);
	}

	public static Optional<ErrorModelSubclause> getFirstErrorModelSubclause(final Classifier classifier) {
		return GraphicalAnnexUtil.getFirstParsedAnnexSubclause(classifier, EMV2Util.ErrorModelAnnexName,
				ErrorModelSubclause.class);
	}

	public static Stream<ErrorModelSubclause> getAllErrorModelSubclauses(final Classifier classifier) {
		return GraphicalAnnexUtil.getAllParsedAnnexSubclauses(classifier, EMV2Util.ErrorModelAnnexName,
				ErrorModelSubclause.class);
	}

	public static Stream<ErrorModelSubclause> getAllInheritedErrorModelSubclauses(final Classifier classifier) {
		if (classifier == null) {
			return Stream.empty();
		}

		Stream<Classifier> classifiers = classifier.getSelfPlusAllExtended().stream();
		if (classifier instanceof ComponentImplementation) {
			final ComponentType ct = ((ComponentImplementation) classifier).getType();
			if (ct != null) {
				classifiers = Stream.concat(classifiers, ct.getSelfPlusAllExtended().stream());
			}
		}
		return classifiers.flatMap(tmpClassifier -> getAllErrorModelSubclauses(tmpClassifier));
	}

	public static final Style topCenteredLabelStyle = StyleBuilder.create().labelsTop().labelsHorizontalCenter()
			.build();

	public static final Style centeredStyle = StyleBuilder.create().labelsCenter().build();

	public static final Style transitionConnectionStyle = StyleBuilder.create().backgroundColor(Color.BLACK).build();
	public static final Graphic transitionConnectionGraphic = ConnectionBuilder.create()
			.destinationTerminator(ArrowBuilder.create().small().filled().build()).build();

	/**
	 * Creates an operation which allows prompting the user and then modifies the error model library of a package.
	 * @param <PromptResult> is a type of result that is returned by the prompter function.
	 * @param packageBoc is the business object context of the package to be modified.
	 * @param prompter is a function that will return results of prompting the user. If it returns an empty optional,
	 * 	the modification portion of the operation will not be executed.
	 * @param modifier a function that is executed to perform the model operation.
	 * @return an optional describing the operation. If the business object context does not have an {@link AadlPackage}
	 * as a business object, an empty optional will be returned.
	 */
	public static <PromptResult> Optional<Operation> createErrorModelLibraryPromptAndModifyOperation(
			final BusinessObjectContext packageBoc, final Supplier<Optional<PromptResult>> prompter,
			BiFunction<ErrorModelLibrary, PromptResult, StepResult<?>> modifier) {
		return packageBoc.getBusinessObject(AadlPackage.class).map(readonlyPkg -> {
			return Operation.createWithBuilder(b -> {
				b.supply(() -> prompter.get().map(v -> StepResult.forValue(v)).orElseGet(() -> StepResult.abort()))
						.modifyModel(null, (tag, promptResult) -> {
							// Select the object to modify. If an error model library exists, modify it. Otherwise, modify the package.
							final Optional<ErrorModelLibrary> readonlyLibrary = getErrorModelLibrary(readonlyPkg);
							if (readonlyLibrary.isPresent()) {
								return readonlyLibrary.get();
							} else {
								return readonlyPkg;
							}
						}, (tag, boToModify, promptResult) -> {
							// Get or create the error model library as needed
							final ErrorModelLibrary lib;
							if (boToModify instanceof AadlPackage) {
								lib = getOrCreateErrorModelLibrary((AadlPackage) boToModify);
							} else {
								lib = (ErrorModelLibrary) boToModify;
							}

							// Perform the modification
							return modifier.apply(lib, promptResult);
						});
			});
		});
	}

	/**
	 * Creates an operation to modify the error model library of a package. If the specified {@link BusinessObjectContext} doesn't contain a
	 * {@link AadlPackage} business object, an empty optional is returned. If the error model library doesn't exist, it is created.
	 * @param <ResultUserType>
	 * @param packageBoc the business object being modified. Must be the business object context for a package.
	 * @param modifier is the function that will modify the error model library
	 * @return an optional containing the operation.
	 */
	public static <ResultUserType> Optional<Operation> createErrorModelLibraryModifyOperation(
			final BusinessObjectContext packageBoc,
			final Function<ErrorModelLibrary, StepResult<ResultUserType>> modifier) {
		return createErrorModelLibraryPromptAndModifyOperation(packageBoc, () -> Optional.of(true),
				(lib, promptResult) -> modifier.apply(lib));
	}

	/**
	 * Creates an operation which allows prompt the user and then modifies the first error model subclause of a classifier or subcomponent.
	 * If the specified {@link BusinessObjectContext} doesn't contain an appropriate business object, an empty optional is returned.
	 * If a error model subclause doesn't exist in the classifier, it is created.
	 * @param <ResultUserType>
	 * @param boc the business object being modified. Must be the business object context for a classifier or subcomponent.
	 * @param prompter is a function that will return results of prompting the user. If it returns an empty optional,
	 * 	the modification portion of the operation will not be executed.
	 * @param modifier a function that is executed to perform the model operation.
	 * @return an optional describing the operation. If the business object context does not have a classifier or subcomponent
	 * as a business object, an empty optional will be returned.
	 */
	public static <PromptResult> Optional<Operation> createErrorModelSubclausePromptAndModifyOperation(
			final BusinessObjectContext boc, final Supplier<Optional<PromptResult>> prompter,
			BiFunction<ErrorModelSubclause, PromptResult, StepResult<?>> modifier) {
		final Object readonlyBo = boc.getBusinessObject();
		final Classifier readonlyClassifier;
		if (readonlyBo instanceof Classifier) {
			readonlyClassifier = (Classifier) readonlyBo;
		} else if (readonlyBo instanceof Subcomponent) {
			readonlyClassifier = ((Subcomponent) readonlyBo).getAllClassifier();
		} else {
			readonlyClassifier = null;
		}

		if (readonlyClassifier == null) {
			return Optional.empty();
		}

		return Optional.of(Operation.createWithBuilder(b -> {
			b.supply(() -> prompter.get().map(v -> StepResult.forValue(v)).orElseGet(() -> StepResult.abort()))
					.modifyModel(null, (tag, promptResult) -> {
						// Select the object to modify. If an error model subclause exists, modify it. Otherwise, modify the classifier.
						final Optional<ErrorModelSubclause> readonlySubclause = getFirstErrorModelSubclause(
								readonlyClassifier);
						if (readonlySubclause.isPresent()) {
							return readonlySubclause.filter(subclause -> subclause.getContainingClassifier() != null)
									.orElse(null);
						} else {
							return readonlyClassifier;
						}
					}, (tag, boToModify, promptResult) -> {
						// Get or create the error model subclause as needed
						final ErrorModelSubclause subclause;
						if (boToModify instanceof Classifier) {
							subclause = getOrCreateErrorModelSubclause((Classifier) boToModify);
						} else {
							subclause = (ErrorModelSubclause) boToModify;
						}

						// Perform the modification
						return modifier.apply(subclause, promptResult);
					});
		}));
	}

	/**
	 * Creates an operation to modify the first error model subclause of a classifier or subcomponent.
	 * If the specified {@link BusinessObjectContext} doesn't contain an appropriate business object, an empty optional is returned.
	 * If a error model subclause doesn't exist in the classifier, it is created.
	 * @param <ResultUserType>
	 * @param boc the business object being modified. Must be the business object context for a classifier or subcomponent.
	 * @param modifier is the function that will modify the error model subclause
	 * @return an optional containing the operation.
	 */
	public static <ResultUserType> Optional<Operation> createErrorModelSubclauseModifyOperation(
			final BusinessObjectContext boc, final Function<ErrorModelSubclause, StepResult<ResultUserType>> modifier) {
		return createErrorModelSubclausePromptAndModifyOperation(boc, () -> Optional.of(true),
				(subclause, promptResult) -> modifier.apply(subclause));
	}

	/**
	 * Walks up the business object context tree and returns the classifier for the first classifier or subcomponent.
	 * @param boc the first business object context to check
	 * @return the classifier
	 */
	public static Optional<Classifier> getClassifier(BusinessObjectContext boc) {
		return getClassifierSourceBoc(boc).flatMap(t -> {
			final Object bo = t.getBusinessObject();
			return getClassifierFromBusinessObject(bo);
		});
	}

	/**
	 * Returns the classifier associated with the specified business object. In order to return a classifier, the business object must be a
	 * subcomponent or a classifier
	 * @param bo the business object for which to retrieve the classifier.
	 * @return the classifier
	 */
	public static Optional<Classifier> getClassifierFromBusinessObject(Object bo) {
		if (bo instanceof Classifier) {
			return Optional.of((Classifier) bo);
		} else if (bo instanceof Subcomponent) {
			final ComponentClassifier cc = ((Subcomponent) bo).getAllClassifier();
			return Optional.ofNullable(cc);
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Walks up the business object context tree and returns the first business object context which references a classifier
	 * or subcomponent.
	 * @param boc the first business object context to check
	 * @return the classifier
	 */
	public static Optional<BusinessObjectContext> getClassifierSourceBoc(BusinessObjectContext boc) {
		while (boc != null) {
			final Object bo = boc.getBusinessObject();
			if (bo instanceof Classifier || bo instanceof Subcomponent) {
				return Optional.of(boc);
			}
			boc = boc.getParent();
		}

		return Optional.empty();
	}

	/**
	 * Creates a list containing the URIs of named elements between the specified root(exclusive) the specified boc(inclusive).
	 * @param boc the business object context to which to return the path.
	 * @param root the root of the path.
	 * @param result the list to populate. Must not be null.
	 * @return the result.
	 */
	public static List<URI> createQualifiedPropagationPointPath(final BusinessObjectContext boc,
			final BusinessObjectContext root, List<URI> result) {
		if (boc.getParent() != root) {
			result = createQualifiedPropagationPointPath(boc.getParent(), root, result);
		}

		if (result != null) {
			final Object targetBo = boc.getBusinessObject();
			if (targetBo instanceof NamedElement) {
				result.add(EcoreUtil.getURI((NamedElement) targetBo));
			} else {
				throw new AadlGraphicalEditorException("Unexpected business object: " + targetBo);
			}
		}

		return result;
	}
}
