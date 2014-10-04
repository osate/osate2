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
 * </copyright>
 *
 * $Id: AbstractImplementationImpl.java,v 1.30 2009-06-05 16:43:25 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.VirtualBusSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedBusSubcomponents <em>Owned Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedDataSubcomponents <em>Owned Data Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedDeviceSubcomponents <em>Owned Device Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedMemorySubcomponents <em>Owned Memory Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedProcessSubcomponents <em>Owned Process Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedProcessorSubcomponents <em>Owned Processor Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedSystemSubcomponents <em>Owned System Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedSubprogramSubcomponents <em>Owned Subprogram Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedSubprogramGroupSubcomponents <em>Owned Subprogram Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedThreadSubcomponents <em>Owned Thread Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedThreadGroupSubcomponents <em>Owned Thread Group Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedVirtualBusSubcomponents <em>Owned Virtual Bus Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getOwnedVirtualProcessorSubcomponents <em>Owned Virtual Processor Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.AbstractImplementationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AbstractImplementationImpl extends BehavioredImplementationImpl implements AbstractImplementation {
	/**
	 * The cached value of the '{@link #getOwnedBusSubcomponents() <em>Owned Bus Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBusSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<BusSubcomponent> ownedBusSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedDataSubcomponents() <em>Owned Data Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<DataSubcomponent> ownedDataSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedDeviceSubcomponents() <em>Owned Device Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDeviceSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<DeviceSubcomponent> ownedDeviceSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedMemorySubcomponents() <em>Owned Memory Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMemorySubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<MemorySubcomponent> ownedMemorySubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedProcessSubcomponents() <em>Owned Process Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessSubcomponent> ownedProcessSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedProcessorSubcomponents() <em>Owned Processor Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessorSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessorSubcomponent> ownedProcessorSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedSystemSubcomponents() <em>Owned System Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSystemSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<SystemSubcomponent> ownedSystemSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramSubcomponents() <em>Owned Subprogram Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramSubcomponent> ownedSubprogramSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedSubprogramGroupSubcomponents() <em>Owned Subprogram Group Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramGroupSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramGroupSubcomponent> ownedSubprogramGroupSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedThreadSubcomponents() <em>Owned Thread Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadSubcomponent> ownedThreadSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedThreadGroupSubcomponents() <em>Owned Thread Group Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedThreadGroupSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<ThreadGroupSubcomponent> ownedThreadGroupSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedVirtualBusSubcomponents() <em>Owned Virtual Bus Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualBusSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualBusSubcomponent> ownedVirtualBusSubcomponents;
	/**
	 * The cached value of the '{@link #getOwnedVirtualProcessorSubcomponents() <em>Owned Virtual Processor Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedVirtualProcessorSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualProcessorSubcomponent> ownedVirtualProcessorSubcomponents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getAbstractImplementation();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Subcomponent> getOwnedSubcomponents() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Subcomponent> ownedSubcomponents = (EList<Subcomponent>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent());
			if (ownedSubcomponents == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedSubcomponent(),
						ownedSubcomponents = new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
								Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS));
			}
			return ownedSubcomponents;
		}
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedSubcomponents() <em>Owned Subcomponent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_SUBCOMPONENT_ESUBSETS = new int[] {
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT,
			Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BusSubcomponent> getOwnedBusSubcomponents() {
		if (ownedBusSubcomponents == null) {
			ownedBusSubcomponents = new EObjectContainmentEList<BusSubcomponent>(BusSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT);
		}
		return ownedBusSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BusSubcomponent createOwnedBusSubcomponent() {
		BusSubcomponent newOwnedBusSubcomponent = (BusSubcomponent) create(Aadl2Package.eINSTANCE.getBusSubcomponent());
		getOwnedBusSubcomponents().add(newOwnedBusSubcomponent);
		return newOwnedBusSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataSubcomponent> getOwnedDataSubcomponents() {
		if (ownedDataSubcomponents == null) {
			ownedDataSubcomponents = new EObjectContainmentEList<DataSubcomponent>(DataSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT);
		}
		return ownedDataSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataSubcomponent createOwnedDataSubcomponent() {
		DataSubcomponent newOwnedDataSubcomponent = (DataSubcomponent) create(Aadl2Package.eINSTANCE
				.getDataSubcomponent());
		getOwnedDataSubcomponents().add(newOwnedDataSubcomponent);
		return newOwnedDataSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DeviceSubcomponent> getOwnedDeviceSubcomponents() {
		if (ownedDeviceSubcomponents == null) {
			ownedDeviceSubcomponents = new EObjectContainmentEList<DeviceSubcomponent>(DeviceSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT);
		}
		return ownedDeviceSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DeviceSubcomponent createOwnedDeviceSubcomponent() {
		DeviceSubcomponent newOwnedDeviceSubcomponent = (DeviceSubcomponent) create(Aadl2Package.eINSTANCE
				.getDeviceSubcomponent());
		getOwnedDeviceSubcomponents().add(newOwnedDeviceSubcomponent);
		return newOwnedDeviceSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MemorySubcomponent> getOwnedMemorySubcomponents() {
		if (ownedMemorySubcomponents == null) {
			ownedMemorySubcomponents = new EObjectContainmentEList<MemorySubcomponent>(MemorySubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT);
		}
		return ownedMemorySubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MemorySubcomponent createOwnedMemorySubcomponent() {
		MemorySubcomponent newOwnedMemorySubcomponent = (MemorySubcomponent) create(Aadl2Package.eINSTANCE
				.getMemorySubcomponent());
		getOwnedMemorySubcomponents().add(newOwnedMemorySubcomponent);
		return newOwnedMemorySubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessSubcomponent> getOwnedProcessSubcomponents() {
		if (ownedProcessSubcomponents == null) {
			ownedProcessSubcomponents = new EObjectContainmentEList<ProcessSubcomponent>(ProcessSubcomponent.class,
					this, Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT);
		}
		return ownedProcessSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessSubcomponent createOwnedProcessSubcomponent() {
		ProcessSubcomponent newOwnedProcessSubcomponent = (ProcessSubcomponent) create(Aadl2Package.eINSTANCE
				.getProcessSubcomponent());
		getOwnedProcessSubcomponents().add(newOwnedProcessSubcomponent);
		return newOwnedProcessSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessorSubcomponent> getOwnedProcessorSubcomponents() {
		if (ownedProcessorSubcomponents == null) {
			ownedProcessorSubcomponents = new EObjectContainmentEList<ProcessorSubcomponent>(
					ProcessorSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT);
		}
		return ownedProcessorSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProcessorSubcomponent createOwnedProcessorSubcomponent() {
		ProcessorSubcomponent newOwnedProcessorSubcomponent = (ProcessorSubcomponent) create(Aadl2Package.eINSTANCE
				.getProcessorSubcomponent());
		getOwnedProcessorSubcomponents().add(newOwnedProcessorSubcomponent);
		return newOwnedProcessorSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SystemSubcomponent> getOwnedSystemSubcomponents() {
		if (ownedSystemSubcomponents == null) {
			ownedSystemSubcomponents = new EObjectContainmentEList<SystemSubcomponent>(SystemSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT);
		}
		return ownedSystemSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SystemSubcomponent createOwnedSystemSubcomponent() {
		SystemSubcomponent newOwnedSystemSubcomponent = (SystemSubcomponent) create(Aadl2Package.eINSTANCE
				.getSystemSubcomponent());
		getOwnedSystemSubcomponents().add(newOwnedSystemSubcomponent);
		return newOwnedSystemSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramSubcomponent> getOwnedSubprogramSubcomponents() {
		if (ownedSubprogramSubcomponents == null) {
			ownedSubprogramSubcomponents = new EObjectContainmentEList<SubprogramSubcomponent>(
					SubprogramSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT);
		}
		return ownedSubprogramSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramSubcomponent createOwnedSubprogramSubcomponent() {
		SubprogramSubcomponent newOwnedSubprogramSubcomponent = (SubprogramSubcomponent) create(Aadl2Package.eINSTANCE
				.getSubprogramSubcomponent());
		getOwnedSubprogramSubcomponents().add(newOwnedSubprogramSubcomponent);
		return newOwnedSubprogramSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramGroupSubcomponent> getOwnedSubprogramGroupSubcomponents() {
		if (ownedSubprogramGroupSubcomponents == null) {
			ownedSubprogramGroupSubcomponents = new EObjectContainmentEList<SubprogramGroupSubcomponent>(
					SubprogramGroupSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT);
		}
		return ownedSubprogramGroupSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramGroupSubcomponent createOwnedSubprogramGroupSubcomponent() {
		SubprogramGroupSubcomponent newOwnedSubprogramGroupSubcomponent = (SubprogramGroupSubcomponent) create(Aadl2Package.eINSTANCE
				.getSubprogramGroupSubcomponent());
		getOwnedSubprogramGroupSubcomponents().add(newOwnedSubprogramGroupSubcomponent);
		return newOwnedSubprogramGroupSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ThreadSubcomponent> getOwnedThreadSubcomponents() {
		if (ownedThreadSubcomponents == null) {
			ownedThreadSubcomponents = new EObjectContainmentEList<ThreadSubcomponent>(ThreadSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT);
		}
		return ownedThreadSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreadSubcomponent createOwnedThreadSubcomponent() {
		ThreadSubcomponent newOwnedThreadSubcomponent = (ThreadSubcomponent) create(Aadl2Package.eINSTANCE
				.getThreadSubcomponent());
		getOwnedThreadSubcomponents().add(newOwnedThreadSubcomponent);
		return newOwnedThreadSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ThreadGroupSubcomponent> getOwnedThreadGroupSubcomponents() {
		if (ownedThreadGroupSubcomponents == null) {
			ownedThreadGroupSubcomponents = new EObjectContainmentEList<ThreadGroupSubcomponent>(
					ThreadGroupSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT);
		}
		return ownedThreadGroupSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThreadGroupSubcomponent createOwnedThreadGroupSubcomponent() {
		ThreadGroupSubcomponent newOwnedThreadGroupSubcomponent = (ThreadGroupSubcomponent) create(Aadl2Package.eINSTANCE
				.getThreadGroupSubcomponent());
		getOwnedThreadGroupSubcomponents().add(newOwnedThreadGroupSubcomponent);
		return newOwnedThreadGroupSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VirtualBusSubcomponent> getOwnedVirtualBusSubcomponents() {
		if (ownedVirtualBusSubcomponents == null) {
			ownedVirtualBusSubcomponents = new EObjectContainmentEList<VirtualBusSubcomponent>(
					VirtualBusSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT);
		}
		return ownedVirtualBusSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VirtualBusSubcomponent createOwnedVirtualBusSubcomponent() {
		VirtualBusSubcomponent newOwnedVirtualBusSubcomponent = (VirtualBusSubcomponent) create(Aadl2Package.eINSTANCE
				.getVirtualBusSubcomponent());
		getOwnedVirtualBusSubcomponents().add(newOwnedVirtualBusSubcomponent);
		return newOwnedVirtualBusSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VirtualProcessorSubcomponent> getOwnedVirtualProcessorSubcomponents() {
		if (ownedVirtualProcessorSubcomponents == null) {
			ownedVirtualProcessorSubcomponents = new EObjectContainmentEList<VirtualProcessorSubcomponent>(
					VirtualProcessorSubcomponent.class, this,
					Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT);
		}
		return ownedVirtualProcessorSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VirtualProcessorSubcomponent createOwnedVirtualProcessorSubcomponent() {
		VirtualProcessorSubcomponent newOwnedVirtualProcessorSubcomponent = (VirtualProcessorSubcomponent) create(Aadl2Package.eINSTANCE
				.getVirtualProcessorSubcomponent());
		getOwnedVirtualProcessorSubcomponents().add(newOwnedVirtualProcessorSubcomponent);
		return newOwnedVirtualProcessorSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AbstractType getType() {
		ComponentType ct = super.getType();
		return ct instanceof AbstractType ? (AbstractType) ct : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public AbstractType basicGetType() {
		// DB: Avoid stack trace overflow
		ComponentType ct = super.basicGetType();
		return ct instanceof AbstractType ? (AbstractType) ct : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setType(ComponentType newType) {
		super.setType(newType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetType() {
		return basicGetType() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedBusSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDataSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedDeviceSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedMemorySubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedProcessSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedProcessorSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSystemSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedSubprogramGroupSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedThreadSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedThreadGroupSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedVirtualBusSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedVirtualProcessorSubcomponents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return getOwnedBusSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return getOwnedDataSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			return getOwnedDeviceSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return getOwnedMemorySubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			return getOwnedProcessSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			return getOwnedProcessorSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			return getOwnedSystemSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return getOwnedSubprogramSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return getOwnedSubprogramGroupSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return getOwnedThreadSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return getOwnedThreadGroupSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return getOwnedVirtualBusSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return getOwnedVirtualProcessorSubcomponents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			getOwnedBusSubcomponents().addAll((Collection<? extends BusSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			getOwnedDataSubcomponents().addAll((Collection<? extends DataSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			getOwnedDeviceSubcomponents().clear();
			getOwnedDeviceSubcomponents().addAll((Collection<? extends DeviceSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			getOwnedMemorySubcomponents().clear();
			getOwnedMemorySubcomponents().addAll((Collection<? extends MemorySubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			getOwnedProcessSubcomponents().clear();
			getOwnedProcessSubcomponents().addAll((Collection<? extends ProcessSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			getOwnedProcessorSubcomponents().clear();
			getOwnedProcessorSubcomponents().addAll((Collection<? extends ProcessorSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			getOwnedSystemSubcomponents().clear();
			getOwnedSystemSubcomponents().addAll((Collection<? extends SystemSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			getOwnedSubprogramSubcomponents().addAll((Collection<? extends SubprogramSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
			getOwnedSubprogramGroupSubcomponents().addAll((Collection<? extends SubprogramGroupSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			getOwnedThreadSubcomponents().clear();
			getOwnedThreadSubcomponents().addAll((Collection<? extends ThreadSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			getOwnedThreadGroupSubcomponents().clear();
			getOwnedThreadGroupSubcomponents().addAll((Collection<? extends ThreadGroupSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			getOwnedVirtualBusSubcomponents().addAll((Collection<? extends VirtualBusSubcomponent>) newValue);
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			getOwnedVirtualProcessorSubcomponents().clear();
			getOwnedVirtualProcessorSubcomponents().addAll(
					(Collection<? extends VirtualProcessorSubcomponent>) newValue);
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
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			getOwnedBusSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			getOwnedDataSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			getOwnedDeviceSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			getOwnedMemorySubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			getOwnedProcessSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			getOwnedProcessorSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			getOwnedSystemSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			getOwnedSubprogramSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			getOwnedSubprogramGroupSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			getOwnedThreadSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			getOwnedThreadGroupSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			getOwnedVirtualBusSubcomponents().clear();
			return;
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			getOwnedVirtualProcessorSubcomponents().clear();
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
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT:
			return ownedBusSubcomponents != null && !ownedBusSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT:
			return ownedDataSubcomponents != null && !ownedDataSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT:
			return ownedDeviceSubcomponents != null && !ownedDeviceSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT:
			return ownedMemorySubcomponents != null && !ownedMemorySubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT:
			return ownedProcessSubcomponents != null && !ownedProcessSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT:
			return ownedProcessorSubcomponents != null && !ownedProcessorSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT:
			return ownedSystemSubcomponents != null && !ownedSystemSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT:
			return ownedSubprogramSubcomponents != null && !ownedSubprogramSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT:
			return ownedSubprogramGroupSubcomponents != null && !ownedSubprogramGroupSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT:
			return ownedThreadSubcomponents != null && !ownedThreadSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT:
			return ownedThreadGroupSubcomponents != null && !ownedThreadGroupSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT:
			return ownedVirtualBusSubcomponents != null && !ownedVirtualBusSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT:
			return ownedVirtualProcessorSubcomponents != null && !ownedVirtualProcessorSubcomponents.isEmpty();
		case Aadl2Package.ABSTRACT_IMPLEMENTATION__TYPE:
			return isSetType();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedSubcomponents() {
		return super.isSetOwnedSubcomponents() || eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DATA_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_DEVICE_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_MEMORY_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_PROCESSOR_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SYSTEM_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_SUBPROGRAM_GROUP_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_THREAD_GROUP_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_BUS_SUBCOMPONENT)
				|| eIsSet(Aadl2Package.ABSTRACT_IMPLEMENTATION__OWNED_VIRTUAL_PROCESSOR_SUBCOMPONENT);
	}

	@Override
	public ComponentCategory getCategory() {
		return ComponentCategory.ABSTRACT;
	}
} // AbstractImplementationImpl
