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
package org.osate.ge.errormodel.filters;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.osate.ge.ContentFilter;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;

import com.google.common.base.CaseFormat;

public class ErrorBehaviorEventTypeFilter implements ContentFilter {
	private final Class<?> eventInterface;
	private final String id;

	public ErrorBehaviorEventTypeFilter(final Class<?> eventInterface) {
		this.eventInterface = Objects.requireNonNull(eventInterface, "eventInterface must not be null");
		this.id = getId(eventInterface);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getParentId() {
		return ErrorBehaviorEventFilter.ID;
	}

	@Override
	public String getName() {
		return StringUtils.capitalize(StringUtils
				.join(StringUtils.splitByCharacterTypeCamelCase(eventInterface.getSimpleName()), " ")) + "s";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ErrorBehaviorStateMachine;
	}

	@Override
	public boolean test(Object bo) {
		return eventInterface.isInstance(bo);
	}

	public static String getId(final Class<?> eventInterface) {
		return "emv2." + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, eventInterface.getSimpleName()) + "s";
	}
}
