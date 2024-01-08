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

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.Pair;

class SecurityCheckAdapter extends AdapterImpl implements SecurityCheckData {

	protected Optional<SecurityLabel> current;

	protected Optional<SecurityLabel> highestChildLabel;

	protected Optional<SecurityLabel> upperLabelLimit;

	protected Optional<SecurityLabel> highestBindingLabel;

	protected Optional<Pair<Integer, Integer>> flowStats;

	@Override
	public void setLabel(Optional<SecurityLabel> label) {
		current = label;
	}

	@Override
	public Optional<SecurityLabel> getLabel() {
		return current;
	}

	@Override
	public void setHighestChildLabel(Optional<SecurityLabel> label) {
		highestChildLabel = label;
	}

	@Override
	public void setFlowStats(Optional<Pair<Integer, Integer>> stats) {
		flowStats = stats;
	}

	@Override
	public void setUpperLabelLimit(Optional<SecurityLabel> label) {
		upperLabelLimit = label;
	}

	@Override
	public void setHighestBindingLabel(Optional<SecurityLabel> label) {
		highestBindingLabel = label;
	}

	@Override
	public Optional<SecurityLabel> getHighestChildLabel() {
		return highestChildLabel;
	}

	@Override
	public Optional<SecurityLabel> getUpperLabelLimit() {
		return upperLabelLimit;
	}

	@Override
	public Optional<SecurityLabel> getHighestBindingLabel() {
		return highestBindingLabel;
	}

	@Override
	public Optional<Pair<Integer, Integer>> getFlowStats() {
		return flowStats;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == SecurityCheckData.class;
	}
}