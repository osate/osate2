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
package org.osate.aadl2.modelsupport.adapter;

import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 *
 * This adapter can be attached to Aadl Object Models Its role is to keep a
 * reference to a Java object of a model that is external to the AADL model. This
 * can be used to create an external model (e.g., a timing model) from an AADL
 * model, run analysis on it, and then via adapter retrieve information from
 * that external model. You can overwrite the default implementation of
 * notifyChanged to take action on notifications.
 * @author phf
 */
public class ExternalModelAdapter extends AdapterImpl {
	/** My adapter type key.  A component can have multiple
	 * external model adapters, as long as they have different types.
	 */
	private final Object myType;

	/** The payload */
	private Object externalModelObject;

	public ExternalModelAdapter(final Object type) {
		super();
		myType = type;
	}

	public ExternalModelAdapter(final Object type, Object object) {
		super();
		myType = type;
		externalModelObject = object;
	}

	/**
	 * Returns <code>false</code>
	 * @param type the type.
	 * @return <code>false</code>
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return myType == type;
	}

	/**
	 * get External Model Object - an object of the external model attached to
	 * the AADL instance model
	 *
	 * @return Object External Model Object
	 */
	public Object getExternalModelObject() {
		return externalModelObject;
	}

	/**
	 * get External Model Object - an object of the external model attached to
	 * the AADL instance model
	 */
	public void setExternalModelObject(Object external) {
		externalModelObject = external;
	}
}