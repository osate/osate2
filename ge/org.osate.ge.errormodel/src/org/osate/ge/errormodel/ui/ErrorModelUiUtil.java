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
package org.osate.ge.errormodel.ui;

import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.AadlPackage;
import org.osate.ge.ProjectUtil;
import org.osate.ge.errormodel.ui.swt.TypeTokenListEditorDialog;
import org.osate.ge.errormodel.ui.viewmodels.BasicTypeTokenListEditorModel;
import org.osate.ge.errormodel.ui.viewmodels.ProjectErrorTypesProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

/**
 * Utility function for implementing the error model graphical editor user interface
 *
 */
public class ErrorModelUiUtil {
	private ErrorModelUiUtil() {
	}

	/**
	 * Prompts for type tokens and returns a type set.
	 * @param pkg the package to use to determine the project.
	 * @return the type set containing the selected type tokens
	 */
	public static final Optional<TypeSet> promptForTypeSet(final AadlPackage pkg) {
		final IProject project = ProjectUtil.getProjectForBoOrThrow(pkg);
		final BasicTypeTokenListEditorModel model = new BasicTypeTokenListEditorModel(
				new ProjectErrorTypesProvider(project),
				Collections.emptyList(), false);
		if (TypeTokenListEditorDialog.open(Display.getDefault().getActiveShell(), "Select Type Tokens",
				model)) {
			final TypeSet newTypeSet = (TypeSet) EcoreUtil.create(ErrorModelPackage.eINSTANCE.getTypeSet());
			newTypeSet.getTypeTokens().addAll(model.getTypeTokenList());
			return Optional.of(newTypeSet);
		} else {
			return Optional.empty();
		}
	}

	/**
	 * Builds a string representing a type token using the names provided by the supplier. The name of the type
	 * is not used because it may not be valid due to being a proxy.
	 * @param value the token to get the name for
	 * @param typeNameSupplier is the supplier of names for types
	 * @return the label that was created.
	 */
	public static String getTypeTokenLabel(final TypeToken value, final Function<ErrorTypes, String> typeNameSupplier) {
		return value.getType().stream().map(v -> {
			final String label = typeNameSupplier.apply(v);
			return label == null ? "<Unknown Error Type>" : label;
		}).collect(Collectors.joining(" * "));
	}

	/**
	 * Builds a string representing the type tokens in the specified string. Names of individual tokanes are created
	 * using {@link #getTypeTokenLabel(TypeToken, Function)}
	 * @param typeTokens the stream of tokens to get the label for
	 * @param typeNameSupplier is the supplier of names for types
	 * @return the label that was created.
	 */
	public static String getTypeTokensLabel(final Stream<TypeToken> typeTokens,
			final Function<ErrorTypes, String> typeNameSupplier) {
		return typeTokens.map(t -> getTypeTokenLabel(t, typeNameSupplier)).collect(Collectors.joining(", "));
	}
}
