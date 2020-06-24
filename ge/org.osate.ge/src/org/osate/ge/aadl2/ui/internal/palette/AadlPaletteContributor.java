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
package org.osate.ge.aadl2.ui.internal.palette;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.ComponentCategory;
import org.osate.ge.aadl2.internal.util.AadlConnectionUtil;
import org.osate.ge.aadl2.internal.util.AadlFeatureUtil;
import org.osate.ge.aadl2.internal.util.AadlSubcomponentUtil;
import org.osate.ge.palette.CreateConnectionPaletteCommand;
import org.osate.ge.palette.PaletteCategory;
import org.osate.ge.palette.PaletteCommandProviderContext;
import org.osate.ge.palette.PaletteContributor;
import org.osate.ge.palette.TargetedPaletteCommand;

public class AadlPaletteContributor implements PaletteContributor {
	@Override
	public Stream<PaletteCategory> getCategories() {
		return Stream.of(new PaletteCategory(AadlPaletteCategories.CLASSIFIERS,
				"Classifiers"),
				new PaletteCategory(AadlPaletteCategories.CONNECTIONS, "Connections"),
				new PaletteCategory(AadlPaletteCategories.FEATURES, "Features"),
				new PaletteCategory(AadlPaletteCategories.FLOWS, "Flows"),
				new PaletteCategory(AadlPaletteCategories.MODES, "Modes"),
				new PaletteCategory(AadlPaletteCategories.SUBCOMPONENTS,
						"Subcomponents"),
				new PaletteCategory(AadlPaletteCategories.SUBPROGRAM_CALLS, "Subprogram Calls"));
	}

	@Override
	public Stream<TargetedPaletteCommand> getTargetedCommands(final PaletteCommandProviderContext ctx) {
		final List<TargetedPaletteCommand> commands = new ArrayList<>();

		if (PaletteCommandUtil.diagramMayContainPackageOrClassifiers(ctx)) {
			if (PaletteCommandUtil.diagramMayContainPackage(ctx)) {
				commands.add(new CreateAnnexLibraryPaletteCommand());
			}

			commands.add(new CreateAnnexSubclausePaletteCommand());
			commands.add(CreateFlowSourceSinkSpecificationPaletteCommand.createFlowSourceCommand());
			commands.add(CreateFlowSourceSinkSpecificationPaletteCommand.createFlowSinkCommand());

			for (EClass featureType : AadlFeatureUtil.getFeatureTypes()) {
				commands.add(new CreateFeaturePaletteCommand(featureType));
			}
		}

		if (PaletteCommandUtil.diagramMayContainPackageOrComponentClassifiers(ctx)) {
			commands.add(new CreateModePaletteCommand());
		}

		if (PaletteCommandUtil.diagramMayContainPackageOrComponentImplementations(ctx)) {
			// Create palette entries for each subcomponent EClass
			for (final EClass subcomponentType : AadlSubcomponentUtil.getSubcomponentTypes()) {
				commands.add(new CreateSubcomponentPaletteCommand(subcomponentType));
			}

			commands.add(new CreateSubprogramCallSequencePaletteCommand());
			commands.add(new CreateSubprogramCallCommand());
		}

		if (PaletteCommandUtil.diagramMayContainPackage(ctx)) {
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.ABSTRACT, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.ABSTRACT, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.BUS, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.BUS, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.DATA, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.DATA, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.DEVICE, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.DEVICE, true));
			commands.add(CreateClassifierPaletteCommand.createFeatureGroupTypeCommand());
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.MEMORY, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.MEMORY, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.PROCESS, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.PROCESS, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.PROCESSOR, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.PROCESSOR, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.SUBPROGRAM, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.SUBPROGRAM, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.SUBPROGRAM_GROUP, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.SUBPROGRAM_GROUP, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.SYSTEM, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.SYSTEM, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.THREAD, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.THREAD, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.THREAD_GROUP, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.THREAD_GROUP, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.VIRTUAL_BUS, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.VIRTUAL_BUS, true));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.VIRTUAL_PROCESSOR, false));
			commands.add(new CreateClassifierPaletteCommand(ComponentCategory.VIRTUAL_PROCESSOR, true));
		}

		return commands.stream();
	}

	@Override
	public Stream<CreateConnectionPaletteCommand> getCreateConnectionCommands(final PaletteCommandProviderContext ctx) {
		final List<CreateConnectionPaletteCommand> commands = new ArrayList<>();

		if (PaletteCommandUtil.diagramMayContainPackageOrClassifiers(ctx)) {
			commands.add(new CreateFlowPathSpecificationPaletteCommand());
		}

		if (PaletteCommandUtil.diagramMayContainPackage(ctx)) {
			commands.add(new CreateGeneralizationPaletteCommand());
		}

		if (PaletteCommandUtil.diagramMayContainPackageOrComponentClassifiers(ctx)) {
			commands.add(new CreateModeTransitionPaletteCommand());
		}

		if (PaletteCommandUtil.diagramMayContainPackageOrComponentImplementations(ctx)) {
			// Create palette entries for each connection type
			for (final EClass connectionType : AadlConnectionUtil.getConnectionTypes()) {
				commands.add(new CreateAadlConnectionPaletteCommand(connectionType));
			}
		}

		return commands.stream();
	}
}
