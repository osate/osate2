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

import org.eclipse.e4.core.services.log.Logger;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;

@SuppressWarnings("restriction")
class LabelPropagator extends InstanceSwitch<Boolean> {

	private Logger logger = PlatformUI.getWorkbench().getService(org.eclipse.e4.core.services.log.Logger.class);

	private SecurityPolicy policy;

	private SystemOperationMode som;

	LabelPropagator(SecurityPolicy policy, SystemOperationMode som) {
		this.policy = policy;
		this.som = som;
	}

	void propagate(SystemInstance ci) {
		propagate(ci, Optional.empty());
	}

	private Optional<SecurityLabel> propagate(ComponentInstance ci, Optional<SecurityLabel> parentmax) {
		Optional<SecurityLabel> current = SecurityLabel.of(ci);
		LabelUtil.setLabel(ci, current);
		LabelUtil.setMaxLabel(ci, parentmax);

		Optional<SecurityLabel> max = current.isPresent() ? current : parentmax;
		Optional<SecurityLabel> min = Optional.empty();
		min = ci.getComponentInstances()
				.stream()
				.reduce(min, (l, c) -> LabelUtil.join(l, propagate(c, max)), LabelUtil::join);
		min = ci.getFeatureInstances()
				.stream()
				.reduce(min, (l, f) -> LabelUtil.join(l, propagate(f, max)), LabelUtil::join);

		LabelUtil.setMinLabel(ci, min);

		logger.info("component " + ci.getName() + ": " + min + " <= " + current + " <= " + max);
		return min;
	}

	private Optional<SecurityLabel> propagate(FeatureInstance fi, Optional<SecurityLabel> parentmax) {
		Optional<SecurityLabel> current = SecurityLabel.of(fi);
		LabelUtil.setLabel(fi, current);
		LabelUtil.setMaxLabel(fi, parentmax);

		Optional<SecurityLabel> max = current.isPresent() ? current : parentmax;
		Optional<SecurityLabel> min = Optional.empty();
		min = fi.getFeatureInstances()
				.stream()
				.reduce(min, (l, f) -> LabelUtil.join(l, propagate(f, max)), LabelUtil::join);

		LabelUtil.setMinLabel(fi, min);

		logger.info("feature " + fi.getName() + ": " + min + " <= " + current + " <= " + max);
		return min;
	}
}
