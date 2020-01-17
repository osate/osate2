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
package org.osate.ge.internal.selection;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.AadlModificationService.Modification;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ActionService;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.internal.ui.util.UiUtil;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResultBuilder;

import com.google.common.collect.ImmutableList;

class AgeBusinessObjectSelection implements BusinessObjectSelection {
	private final ImmutableList<BusinessObjectContext> bocs;
	private final AadlModificationService modificationService;

	public AgeBusinessObjectSelection(final Collection<? extends BusinessObjectContext> bocs,
			final AadlModificationService modificationService) {
		this.bocs = ImmutableList.copyOf(bocs);
		this.modificationService = Objects.requireNonNull(modificationService, "modificationService must not be null");
	}

	@Override
	public final <T> Stream<T> boStream(final Class<T> c) {
		return bocs.stream().map(boc -> c.cast(boc.getBusinessObject()));
	}

	@Override
	public final Stream<BusinessObjectContext> bocStream() {
		return bocs.stream();
	}

	@Override
	public <T extends EObject> void modify(final Function<BusinessObjectContext, T> bocToBoToModifyMapper,
			final BiConsumer<T, BusinessObjectContext> modifier) {
		final ImmutableList<Modification<BusinessObjectContext, T>> modifications = bocs.stream()
				.map(boc -> Modification.create(boc, bocToBoToModifyMapper, (boc2, liveBoToModify) -> {
					modifier.accept(liveBoToModify, boc2);
				})).collect(ImmutableList.toImmutableList());

		// Wrap the modifications in an another action so that the undo will take the user to the currently active graphical editor(if any).
		getActionExecutor().execute("Modify Model", ExecutionMode.NORMAL, () -> {
			modificationService.modify(modifications);
			return null;
		});
	}

	@Override
	public <T extends EObject> void modify(final Class<T> c, final Consumer<T> modifier) {
		modify(boc -> c.cast(boc.getBusinessObject()), (bo, boc) -> modifier.accept(bo));
	}

	@Override
	public <T extends EObject, O> void modifyWithOperation(final OperationBuilder<O> opBuilder, final Class<T> c,
			final BiConsumer<T, O> modifier) {
		boStream(c).forEachOrdered(e -> {
			opBuilder.modifyModel(null, (tag, prev) -> e, (tag, boToModify, prev) -> {
				modifier.accept(boToModify, prev);
				return StepResultBuilder.create().build();
			});
		});
	}


	/**
	 * Gets the action executor that should be used to modify the model.
	 * @return
	 */
	private static ActionExecutor getActionExecutor() {
		final AgeDiagramEditor editor = UiUtil.getActiveDiagramEditor();
		ActionExecutor executor = null;
		if (editor != null) {
			executor = editor.getActionExecutor();
		}

		if (executor == null) {
			executor = Objects.requireNonNull(PlatformUI.getWorkbench().getService(ActionService.class),
					"Unable to retrieve action service");
		}

		return executor;
	}
}
