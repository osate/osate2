/*
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: ExternalModelAdapterFactory.java,v 1.1 2008-01-23 23:27:47 jseibel Exp $
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
