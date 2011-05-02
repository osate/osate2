/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * </copyright>
 * 
 *
 * $Id: SubcomponentFlowImpl.java,v 1.6 2010-04-13 17:52:31 lwrage Exp $
 */
package org.osate.aadl2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentFlow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subcomponent Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentFlowImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentFlowImpl#getFlowSpecification <em>Flow Specification</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.SubcomponentFlowImpl#getDataAccess <em>Data Access</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubcomponentFlowImpl extends FlowElementImpl implements SubcomponentFlow {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected Subcomponent context;
	/**
	 * The cached value of the '{@link #getFlowSpecification() <em>Flow Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlowSpecification()
	 * @generated
	 * @ordered
	 */
	protected FlowSpecification flowSpecification;
	/**
	 * The cached value of the '{@link #getDataAccess() <em>Data Access</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataAccess()
	 * @generated
	 * @ordered
	 */
	protected DataAccess dataAccess;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubcomponentFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getSubcomponentFlow();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent getContext() {
		if (context != null && ((EObject) context).eIsProxy()) {
			InternalEObject oldContext = (InternalEObject) context;
			context = (Subcomponent) eResolveProxy(oldContext);
			if (context != oldContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.SUBCOMPONENT_FLOW__CONTEXT,
							oldContext, context));
			}
		}
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subcomponent basicGetContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(Subcomponent newContext) {
		Subcomponent oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT_FLOW__CONTEXT, oldContext,
					context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification getFlowSpecification() {
		if (flowSpecification != null && ((EObject) flowSpecification).eIsProxy()) {
			InternalEObject oldFlowSpecification = (InternalEObject) flowSpecification;
			flowSpecification = (FlowSpecification) eResolveProxy(oldFlowSpecification);
			if (flowSpecification != oldFlowSpecification) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.SUBCOMPONENT_FLOW__FLOW_SPECIFICATION, oldFlowSpecification, flowSpecification));
			}
		}
		return flowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowSpecification basicGetFlowSpecification() {
		return flowSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlowSpecification(FlowSpecification newFlowSpecification) {
		FlowSpecification oldFlowSpecification = flowSpecification;
		flowSpecification = newFlowSpecification;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT_FLOW__FLOW_SPECIFICATION,
					oldFlowSpecification, flowSpecification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccess getDataAccess() {
		if (dataAccess != null && ((EObject) dataAccess).eIsProxy()) {
			InternalEObject oldDataAccess = (InternalEObject) dataAccess;
			dataAccess = (DataAccess) eResolveProxy(oldDataAccess);
			if (dataAccess != oldDataAccess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							Aadl2Package.SUBCOMPONENT_FLOW__DATA_ACCESS, oldDataAccess, dataAccess));
			}
		}
		return dataAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccess basicGetDataAccess() {
		return dataAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataAccess(DataAccess newDataAccess) {
		DataAccess oldDataAccess = dataAccess;
		dataAccess = newDataAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.SUBCOMPONENT_FLOW__DATA_ACCESS,
					oldDataAccess, dataAccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.SUBCOMPONENT_FLOW__CONTEXT:
			if (resolve)
				return getContext();
			return basicGetContext();
		case Aadl2Package.SUBCOMPONENT_FLOW__FLOW_SPECIFICATION:
			if (resolve)
				return getFlowSpecification();
			return basicGetFlowSpecification();
		case Aadl2Package.SUBCOMPONENT_FLOW__DATA_ACCESS:
			if (resolve)
				return getDataAccess();
			return basicGetDataAccess();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.SUBCOMPONENT_FLOW__CONTEXT:
			setContext((Subcomponent) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT_FLOW__FLOW_SPECIFICATION:
			setFlowSpecification((FlowSpecification) newValue);
			return;
		case Aadl2Package.SUBCOMPONENT_FLOW__DATA_ACCESS:
			setDataAccess((DataAccess) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.SUBCOMPONENT_FLOW__CONTEXT:
			setContext((Subcomponent) null);
			return;
		case Aadl2Package.SUBCOMPONENT_FLOW__FLOW_SPECIFICATION:
			setFlowSpecification((FlowSpecification) null);
			return;
		case Aadl2Package.SUBCOMPONENT_FLOW__DATA_ACCESS:
			setDataAccess((DataAccess) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.SUBCOMPONENT_FLOW__CONTEXT:
			return context != null;
		case Aadl2Package.SUBCOMPONENT_FLOW__FLOW_SPECIFICATION:
			return flowSpecification != null;
		case Aadl2Package.SUBCOMPONENT_FLOW__DATA_ACCESS:
			return dataAccess != null;
		}
		return super.eIsSet(featureID);
	}

} //SubcomponentFlowImpl
