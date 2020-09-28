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

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.osate.aadl2.AadlPackage;
import org.osate.ge.BusinessObjectContext;
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
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class ErrorModelGeUtil {
	private ErrorModelGeUtil() {
	}

	private static ErrorModelLibrary getOrCreateErrorModelLibrary(final AadlPackage pkg) {
		return (ErrorModelLibrary) GraphicalAnnexUtil.getOrCreateParsedAnnexLibrary(pkg, EMV2Util.ErrorModelAnnexName,
				ErrorModelPackage.eINSTANCE.getErrorModelLibrary());
	}

	public static Optional<ErrorModelLibrary> getErrorModelLibrary(final AadlPackage pkg) {
		return Optional.ofNullable((ErrorModelLibrary) GraphicalAnnexUtil.getFirstParsedAnnexLibrary(pkg,
				EMV2Util.ErrorModelAnnexName, ErrorModelPackage.eINSTANCE.getErrorModelLibrary()));
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
}
