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
package org.osate.xtext.aadl2.errormodel.util;

import java.util.Collection;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;

public class ErrorModelStateAdapter extends AdapterImpl implements ErrorModelState {
	private class EMNode {
		protected TypeToken token;
		protected ErrorPropagation ep;

	}

	protected EMNode emnode;

	protected ErrorBehaviorState currentErrorState;

	protected Collection<EMNode> visited = new BasicEList<EMNode>();

	@Override
	public void setVisitToken(ErrorPropagation ep, TypeToken token) {
		this.emnode = new EMNode();
		emnode.ep = ep;
		emnode.token = token;
		visited.add(this.emnode);
	}

	@Override
	public void removeVisitedToken(ErrorPropagation ep,TypeToken token) {
		EMNode found = findEMNode(ep, token);
		visited.remove(found);
	}

	@Override
	public ErrorBehaviorState getErrorState() {
		return currentErrorState;
	}

	@Override
	public void setErrorState(ErrorBehaviorState errorBehaviorState) {
		currentErrorState = errorBehaviorState;
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ErrorModelState.class;
	}

	@Override
	public void unsetAll() {
		emnode = null;
		currentErrorState = null;
		visited.clear();
	}

	@Override
	public boolean visited(ErrorPropagation ep, TypeToken tt) {
		return findEMNode(ep, tt) != null;
	}

	private EMNode findEMNode(ErrorPropagation ep, TypeToken tt) {
		for (EMNode emn : visited) {
			if (emn.ep == ep && EMV2TypeSetUtil.contains(emn.token, tt)) {
				return emn;
			}
		}
		return null;
	}

}
