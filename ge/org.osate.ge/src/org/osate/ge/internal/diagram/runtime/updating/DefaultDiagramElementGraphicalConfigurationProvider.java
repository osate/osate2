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
package org.osate.ge.internal.diagram.runtime.updating;

import java.util.Objects;

import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.businessObjectHandlers.BusinessObjectHandlerProvider;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.ExtensionService;
import org.osate.ge.internal.services.ProjectReferenceService;
import org.osate.ge.internal.util.BusinessObjectContextHelper;

/**
 * DiagramElementGraphicalConfigurationProvider implementation that uses business object handlers.
 *
 */
public class DefaultDiagramElementGraphicalConfigurationProvider implements DiagramElementInformationProvider, AutoCloseable {
	private final BusinessObjectHandlerProvider bohProvider;
	private final BusinessObjectContextHelper bocHelper;

	public DefaultDiagramElementGraphicalConfigurationProvider(final ProjectReferenceService refService,
			final ExtensionService extService) {
		this.bohProvider = Objects.requireNonNull(extService, "extService must not be null");
		this.bocHelper = new BusinessObjectContextHelper(extService);
	}

	@Override
	public void close() {
		bocHelper.close();
	}

	@Override
	public String getLabelName(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		return bocHelper.getNameForLabel(element, boh);
	}

	@Override
	public String getUserInterfaceName(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		return bocHelper.getNameForUserInterface(element, boh);
	}

	@Override
	public AgeGraphicalConfiguration getGraphicalConfiguration(final DiagramElement element) {
		final Object boh = element.getBusinessObjectHandler();
		return bocHelper.getGraphicalConfiguration(element, boh);
	}

	@Override
	public Object getApplicableBusinessObjectHandler(final Object bo) {
		return bohProvider.getApplicableBusinessObjectHandler(bo);
	}
}
