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
package org.osate.ge.errormodel.ui.palette;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.osate.aadl2.DirectionType;
import org.osate.ge.aadl2.ui.PaletteCommandUtil;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.PaletteCategory;
import org.osate.ge.palette.PaletteCommandProviderContext;
import org.osate.ge.palette.PaletteContributor;
import org.osate.ge.palette.TargetedPaletteCommand;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

public class ErrorModelPaletteContributor implements PaletteContributor {
	@Override
	public Stream<PaletteCategory> getCategories() {
		return Stream.of(new PaletteCategory(ErrorModelPaletteCategories.ERROR_BEHAVIOR, "Error Behavior"),
				new PaletteCategory(ErrorModelPaletteCategories.ERROR_FLOWS, "Error Flows"),
				new PaletteCategory(ErrorModelPaletteCategories.ERROR_PROPAGATION, "Error Propagation"),
				new PaletteCategory(ErrorModelPaletteCategories.ERROR_TYPES, "Error Types"));
	}

	@Override
	public Stream<TargetedPaletteCommand> getTargetedCommands(final PaletteCommandProviderContext ctx) {
		final List<TargetedPaletteCommand> commands = new ArrayList<>();

		if (PaletteCommandUtil.diagramMayContainPackage(ctx)) {
			commands.add(new CreateErrorTypePaletteCommand());
			commands.add(new CreateTypeAliasPaletteCommand());
			commands.add(new CreateTypeSetPaletteCommand());
			commands.add(new CreateTypeSetAliasPaletteCommand());
		}

		commands.add(new CreateErrorPropagationPaletteCommand(DirectionType.IN, true));
		commands.add(new CreateErrorPropagationPaletteCommand(DirectionType.IN, false));
		commands.add(new CreateErrorPropagationPaletteCommand(DirectionType.OUT, true));
		commands.add(new CreateErrorPropagationPaletteCommand(DirectionType.OUT, false));
		commands.add(CreateErrorSourceOrSinkPaletteCommand.createErrorSinkPaletteCommand());
		commands.add(CreateErrorSourceOrSinkPaletteCommand.createErrorSourcePaletteCommand());

		commands.add(new CreateEventPaletteCommand(ErrorModelPackage.eINSTANCE.getErrorEvent()));
		commands.add(new CreatePropagationPointPaleteCommand());
		commands.add(new CreateEventPaletteCommand(ErrorModelPackage.eINSTANCE.getRepairEvent()));
		commands.add(new CreateEventPaletteCommand(ErrorModelPackage.eINSTANCE.getRecoverEvent()));
		commands.add(new CreateStatePaletteCommand());
		commands.add(new CreateStateMachinePaletteCommand());

		return commands.stream();
	}

	@Override
	public Stream<CreateConnectionPaletteCommand> getCreateConnectionCommands(
			final PaletteCommandProviderContext ctx) {
		final List<CreateConnectionPaletteCommand> commands = new ArrayList<>();

		if (PaletteCommandUtil.diagramMayContainPackage(ctx)) {
			commands.add(new CreateTypeExtensionPaletteCommand());
		}

		commands.add(new CreateErrorPathPaletteCommand());
		commands.add(new CreatePropagatonPathPaletteCommand());
		commands.add(new CreateTransitionPaletteCommand());

		return commands.stream();
	}
}
