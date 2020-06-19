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
/*
 * Created on Aug 11, 2004
 *
 */
package org.osate.aadl2.modelsupport.adapter;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

/**
 * This class implements an ExternalModelAdapter factory: It attaches an adapter
 * that handles an external model reference. This adapter does not listen to
 * notifications from changes to the Aadl Object model. The adapter is being
 * created through the createAdapter method. This method can be overwritten to
 * create an ExternalModelAdapter with an active notifyChanged method. If a
 * different adapter type is used, the isFactoryForType method must be
 * overwritten as well
 *
 * <p>Does not support {@link #adaptAllNew(Notifier)} because we cannot know
 * all the type keys that might be used to create adapters with this factory.
 * Specifically, the method {@link #adaptAllNew(Notifier)} does nothing, and
 * the helper method {@link AdapterFactoryImpl#createAdapter(Notifier)}
 * always returns an adapter with a <code>null</code> type.
 * @author phf
 *
 */
public class ExternalModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * Static singleton instance of the factory.
	 */
	public static final AdapterFactory INSTANCE = new ExternalModelAdapterFactory();

	public ExternalModelAdapterFactory() {
		super();
	}

	@Override
	public boolean isFactoryForType(Object type) {
		return true;
	}

	@Override
	public void adaptAllNew(final Notifier target) {
		// do nothing because we cannot know all the types we create
	}

	@Override
	public Adapter createAdapter(final Notifier target, final Object type) {
		return new ExternalModelAdapter(type);
	}

	@Override
	protected Adapter createAdapter(Notifier target) {
		return new ExternalModelAdapter(null);
	}
}
