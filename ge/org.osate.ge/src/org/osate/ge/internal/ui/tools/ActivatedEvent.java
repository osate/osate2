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
package org.osate.ge.internal.ui.tools;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.internal.services.UiService;

import com.google.common.collect.ImmutableList;

/**
 * Stores details regarding the tool activated event and provides useful services to tools.
 *
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @noextend This class is not intended to be subclassed by clients.
 */
public final class ActivatedEvent {
	private final List<BusinessObjectContext> selectedBocs;
	private final AgeDiagram diagram;
	private final AadlModificationService aadlModService;
	private final UiService uiService;
	private final ColoringService coloringService;

	/**
	 * Creates a new instance.
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public ActivatedEvent(final ImmutableList<BusinessObjectContext> selectedBocs, final AgeDiagram diagram,
			final AadlModificationService aadlModService, final UiService uiService,
			final ColoringService coloringService) {
		this.selectedBocs = Objects.requireNonNull(selectedBocs, "selectedBocs must not be null");
		this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		this.aadlModService = Objects.requireNonNull(aadlModService, "aadlModService must not be null");
		this.uiService = Objects.requireNonNull(uiService, "uiService must not be null");
		this.coloringService = Objects.requireNonNull(coloringService, "coloringService must not be null");
	}

	/**
	 * Returns the selected business object contexts
	 * @return an immutable list containing the selected business object contexts.
	 */
	public List<BusinessObjectContext> getSelectedBocs() {
		return selectedBocs;
	}

	/**
	 * Returns the selected business object context when there is exactly one selected.
	 * @return the selected business object context. An empty optional will be returned if zero or more than 1 business object context is selected.
	 * Will not return null.
	 */
	public Optional<BusinessObjectContext> getSelectedBoc() {
		return selectedBocs.size() == 1 ? Optional.of(selectedBocs.get(0)) : Optional.empty();
	}

	/**
	 * Returns the diagram for which the tool was activated.
	 * @return the diagram for which the tool was activated.
	 */
	public AgeDiagram getDiagram() {
		return diagram;
	}

	/**
	 * Returns the AADL modification service.
	 * @return the AADL modification service.
	 */
	public AadlModificationService getAadlModificatonService() {
		return aadlModService;
	}

	/**
	 * Returns the UI service. The tool is responsible for calling {@link UiService#deactivateActiveTool()} when it has finished executing.
	 * @return the UI service.
	 */
	public UiService getUiService() {
		return uiService;
	}

	/**
	 * Returns the coloring service.
	 * @return the coloring service.
	 */
	public ColoringService getColoringService() {
		return coloringService;
	}
}
