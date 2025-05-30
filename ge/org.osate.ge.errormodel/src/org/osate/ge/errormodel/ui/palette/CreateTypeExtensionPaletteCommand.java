/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.errormodel.ui.palette;

import java.util.Optional;

import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResult;
import org.osate.ge.operations.StepResultBuilder;
import org.osate.ge.palette.BasePaletteCommand;
import org.osate.ge.palette.CanStartConnectionContext;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.GetCreateConnectionOperationContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

/**
 * Palette command for creating error type extensions.
 */
public class CreateTypeExtensionPaletteCommand extends BasePaletteCommand implements CreateConnectionPaletteCommand {
	/**
	 * Creates a new instance
	 */
	public CreateTypeExtensionPaletteCommand() {
		super("Error Type Extension", ErrorModelPaletteCategories.ERROR_TYPES, null);
	}

	@Override
	public boolean canStartConnection(final CanStartConnectionContext ctx) {
		return ctx.getSource().getBusinessObject(ErrorType.class).filter(t -> t.getAliasedType() == null).isPresent();
	}

	@Override
	public Optional<Operation> getOperation(final GetCreateConnectionOperationContext ctx) {
		final ErrorType subtypeReadonly = ctx.getSource().getBusinessObject(ErrorType.class).get();
		return ctx.getDestination().getBusinessObject(ErrorType.class).map(supertype -> {
			if (supertype == subtypeReadonly) {
				return null;
			}

			return Operation.createWithBuilder(createOp -> createOp.supply(() -> StepResult.forValue(subtypeReadonly))
					.modifyPreviousResult(subtype -> {
						subtype.setSuperType(supertype);
						final Object newBo = new ErrorTypeExtension(supertype, subtype);
						return StepResultBuilder.create().showNewBusinessObject(ctx.getSource(), newBo).build();
					}));
		});
	}
}
