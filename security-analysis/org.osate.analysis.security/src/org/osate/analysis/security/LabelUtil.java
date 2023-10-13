/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.analysis.security;

import java.util.Optional;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.osate.aadl2.instance.InstanceObject;

final class LabelUtil {

	private LabelUtil() {
	}

	private static AdapterFactory adapterFactory = SecurityCheckAdapterFactory.INSTANCE;

	static void setLabel(InstanceObject io, Optional<SecurityLabel> label) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		data.setLabel(label);
	}

	static Optional<SecurityLabel> getLabel(InstanceObject io) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		return data.getLabel();
	}

	static void setMinLabel(InstanceObject io, Optional<SecurityLabel> label) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		data.setMinLabel(label);
	}

	static Optional<SecurityLabel> getMinLabel(InstanceObject io) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		return data.getMinLabel();
	}

	static void setMaxLabel(InstanceObject io, Optional<SecurityLabel> label) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		data.setMaxLabel(label);
	}

	static Optional<SecurityLabel> getMaxLabel(InstanceObject io) {
		SecurityCheckData data = (SecurityCheckData) adapterFactory.adapt(io, SecurityCheckData.class);
		return data.getMaxLabel();
	}

	static Optional<SecurityLabel> meet(Optional<SecurityLabel> l1, Optional<SecurityLabel> l2) {
		if (l1.isPresent() && l2.isPresent()) {
			return Optional.of(l1.get().meet(l2.get()));
		}
		if (l1.isPresent()) {
			return l1;
		}
		if (l2.isPresent()) {
			return l2;
		}
		return Optional.empty();
	}

	static Optional<SecurityLabel> join(Optional<SecurityLabel> l1, Optional<SecurityLabel> l2) {
		if (l1.isPresent() && l2.isPresent()) {
			return Optional.of(l1.get().join(l2.get()));
		}
		if (l1.isPresent()) {
			return l1;
		}
		if (l2.isPresent()) {
			return l2;
		}
		return Optional.empty();
	}

}
