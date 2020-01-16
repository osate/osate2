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
package org.osate.aadl2.properties;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.PropertyExpression;

/**
 * @author lwrage
 *
 */
public class EvaluatedProperty {

	/**
	 * This class stores a reference to a modal or non-modal property value
	 * in a property association.
	 */
	public static class MpvProxy {
		static ModalPropertyValue emptyMPV = Aadl2Factory.eINSTANCE.createModalPropertyValue();

		final PropertyExpression exp;

		ModalPropertyValue mpv;

		public MpvProxy(ModalPropertyValue mpv) {
			exp = mpv.getOwnedValue();
			this.mpv = mpv;
		}

		public MpvProxy(PropertyExpression exp) {
			this.exp = exp;
		}

		public PropertyExpression getValue() {
			return exp;
		}

		@SuppressWarnings("unchecked")
		public List<Mode> getModes() {
			return mpv == null ? (List<Mode>) Collections.EMPTY_LIST : mpv.getInModes();
		}

		public boolean isModal() {
			return getModes().size() > 0;
		}

		public ModalPropertyValue getMPV() {
			return mpv;
		}

		public void setMPV(ModalPropertyValue mpv) {
			this.mpv = mpv;
		}

	}

	private List<MpvProxy> mpvList;

	public EvaluatedProperty() {
		mpvList = new LinkedList<MpvProxy>();
	}

//	public EvaluatedProperty(ModalPropertyValue mpv) {
//		this();
//		mpvList.add(new MpvProxy(mpv));
//	}

	public EvaluatedProperty(PropertyExpression pe) {
		this();
		mpvList.add(new MpvProxy(pe));
	}

//	public void add(ModalPropertyValue mpv) {
//		mpvList.add(new MpvProxy(mpv));
//	}

	public void add(PropertyExpression pe) {
		mpvList.add(new MpvProxy(pe));
	}

	public void add(EvaluatedProperty ep) {
		mpvList.addAll(ep.mpvList);
	}

	public int size() {
		return mpvList.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public MpvProxy first() {
		return mpvList.isEmpty() ? null : mpvList.get(0);
	}

	public List<MpvProxy> getProxies() {
		return Collections.unmodifiableList(mpvList);
	}
}
