/*
 * Created on Sep 14, 2004
 * <copyright>
 * Copyright � 2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE �DELIVERABLES�) ARE ON AN �AS-IS� BASIS.
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
 * attorney�s fees) arising out of, or relating to Licensee�s and/or its sub licensees� negligent use or willful
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
 * @version $Id: ExternalModelAdapter.java,v 1.1 2008-01-23 23:27:47 jseibel Exp $
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