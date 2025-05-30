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
package org.osate.ge.ba.ui.palette;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ge.aadl2.ui.PaletteCommandUtil;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.PaletteCategory;
import org.osate.ge.palette.PaletteCommandProviderContext;
import org.osate.ge.palette.PaletteContributor;
import org.osate.ge.palette.TargetedPaletteCommand;

/**
 * Palette contributor which contributes commands for creating behavior annex elements.
 *
 */
public class BehaviorAnnexPaletteContributor implements PaletteContributor {
	/**
	 * ID for the category containing behavior annex palette commands.
	 */
	public static final String BEHAVIOR_ANNEX_CATEGORY_ID = "org.osate.ge.ba.categories.ba";

	@Override
	public Stream<PaletteCategory> getCategories() {
		return Stream.of(new PaletteCategory(BEHAVIOR_ANNEX_CATEGORY_ID, "Behavior Annex"));
	}

	@Override
	public Stream<TargetedPaletteCommand> getTargetedCommands(final PaletteCommandProviderContext ctx) {
		final List<TargetedPaletteCommand> commands = new ArrayList<>();
		// Do not show BehaviorAnnex specification palette option when diagram bo is BehaviorAnnex
		if (PaletteCommandUtil.diagramMayContainPackageOrComponentClassifiers(ctx)) {
			commands.add(new CreateSpecificationPaletteCommand());
		} else if (!diagramIsBehaviorAnnex(ctx)) {
			// Return empty if diagram context is not valid
			return Stream.empty();
		}

		commands.add(new CreateStatePaletteCommand());
		commands.add(new CreateVariablePaletteCommand());
		return commands.stream();
	}

	@Override
	public Stream<CreateConnectionPaletteCommand> getCreateConnectionCommands(
			final PaletteCommandProviderContext ctx) {
		final List<CreateConnectionPaletteCommand> commands = new ArrayList<>();
		if (diagramIsBehaviorAnnex(ctx) || PaletteCommandUtil.diagramMayContainPackageOrComponentClassifiers(ctx)) {
			commands.add(new CreateTransitionPaletteCommand());
		}
		return commands.stream();
	}

	private static boolean diagramIsBehaviorAnnex(final PaletteCommandProviderContext ctx) {
		return ctx.getDiagramBusinessObject() instanceof BehaviorAnnex;
	}
}
