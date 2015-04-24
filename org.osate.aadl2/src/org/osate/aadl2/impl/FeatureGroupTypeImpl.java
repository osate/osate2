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
 * $Id: FeatureGroupTypeImpl.java,v 1.42 2011-04-11 13:35:53 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.CacheAdapter;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Property;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.OsateDebug;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Group Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedFeatures <em>Owned Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getGenerals <em>General</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getGeneralizations <em>Generalization</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getExtended <em>Extended</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getInverse <em>Inverse</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedExtension <em>Owned Extension</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedBusAccesses <em>Owned Bus Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedDataAccesses <em>Owned Data Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedDataPorts <em>Owned Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedEventDataPorts <em>Owned Event Data Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedEventPorts <em>Owned Event Port</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedFeatureGroups <em>Owned Feature Group</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedParameters <em>Owned Parameter</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedSubprogramAccesses <em>Owned Subprogram Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedSubprogramGroupAccesses <em>Owned Subprogram Group Access</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.FeatureGroupTypeImpl#getOwnedAbstractFeatures <em>Owned Abstract Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureGroupTypeImpl extends ClassifierImpl implements FeatureGroupType {
	/**
	 * The cached value of the '{@link #getInverse() <em>Inverse</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInverse()
	 * @generated
	 * @ordered
	 */
	protected FeatureGroupType inverse;

	/**
	 * The cached value of the '{@link #getOwnedExtension() <em>Owned Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExtension()
	 * @generated
	 * @ordered
	 */
	protected GroupExtension ownedExtension;

	/**
	 * The cached value of the '{@link #getOwnedBusAccesses() <em>Owned Bus Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBusAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<BusAccess> ownedBusAccesses;

	/**
	 * The cached value of the '{@link #getOwnedDataAccesses() <em>Owned Data Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<DataAccess> ownedDataAccesses;

	/**
	 * The cached value of the '{@link #getOwnedDataPorts() <em>Owned Data Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDataPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<DataPort> ownedDataPorts;

	/**
	 * The cached value of the '{@link #getOwnedEventDataPorts() <em>Owned Event Data Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventDataPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDataPort> ownedEventDataPorts;

	/**
	 * The cached value of the '{@link #getOwnedEventPorts() <em>Owned Event Port</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<EventPort> ownedEventPorts;

	/**
	 * The cached value of the '{@link #getOwnedFeatureGroups() <em>Owned Feature Group</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatureGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureGroup> ownedFeatureGroups;

	/**
	 * The cached value of the '{@link #getOwnedParameters() <em>Owned Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> ownedParameters;

	/**
	 * The cached value of the '{@link #getOwnedSubprogramAccesses() <em>Owned Subprogram Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramAccess> ownedSubprogramAccesses;

	/**
	 * The cached value of the '{@link #getOwnedSubprogramGroupAccesses() <em>Owned Subprogram Group Access</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramGroupAccesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramGroupAccess> ownedSubprogramGroupAccesses;

	/**
	 * The cached value of the '{@link #getOwnedAbstractFeatures() <em>Owned Abstract Feature</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAbstractFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractFeature> ownedAbstractFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureGroupTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getFeatureGroupType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassifierFeature> getClassifierFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<ClassifierFeature> classifierFeatures = (EList<ClassifierFeature>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature());
			if (classifierFeatures == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getClassifier_ClassifierFeature(),
						classifierFeatures = new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class,
								this, Aadl2Package.FEATURE_GROUP_TYPE__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS));
			}
			return classifierFeatures;
		}
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.FEATURE_GROUP_TYPE__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getOwnedMembers() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<NamedElement> ownedMembers = (EList<NamedElement>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getNamespace_OwnedMember());
			if (ownedMembers == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getNamespace_OwnedMember(),
						ownedMembers = new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
								Aadl2Package.FEATURE_GROUP_TYPE__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.FEATURE_GROUP_TYPE__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Feature> getOwnedFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Feature> ownedFeatures = (EList<Feature>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature());
			if (ownedFeatures == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getFeatureGroupType_OwnedFeature(),
						ownedFeatures = new DerivedUnionEObjectEList<Feature>(Feature.class, this,
								Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE, OWNED_FEATURE_ESUBSETS));
			}
			return ownedFeatures;
		}
		return new DerivedUnionEObjectEList<Feature>(Feature.class, this,
				Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE, OWNED_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedFeatures() <em>Owned Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_FEATURE_ESUBSETS = new int[] {
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS, Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS,
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT, Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT,
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT, Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP,
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER, Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS,
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS,
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE };

	/**
	 * The array of subset feature identifiers for the '{@link #getClassifierFeatures() <em>Classifier Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CLASSIFIER_FEATURE_ESUBSETS = new int[] { Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE };

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] {
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ANNEX_SUBCLAUSE, Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PROTOTYPE,
			Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Classifier> getGenerals() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Classifier> generals = (EList<Classifier>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getClassifier_General());
			if (generals == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getClassifier_General(),
						generals = new DerivedUnionEObjectEList<Classifier>(Classifier.class, this,
								Aadl2Package.FEATURE_GROUP_TYPE__GENERAL, GENERAL_ESUBSETS));
			}
			return generals;
		}
		return new DerivedUnionEObjectEList<Classifier>(Classifier.class, this,
				Aadl2Package.FEATURE_GROUP_TYPE__GENERAL, GENERAL_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getGenerals() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerals()
	 * @generated
	 * @ordered
	 */
	protected static final int[] GENERAL_ESUBSETS = new int[] { Aadl2Package.FEATURE_GROUP_TYPE__EXTENDED };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Generalization> getGeneralizations() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<Generalization> generalizations = (EList<Generalization>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getClassifier_Generalization());
			if (generalizations == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getClassifier_Generalization(),
						generalizations = new DerivedUnionEObjectEList<Generalization>(Generalization.class, this,
								Aadl2Package.FEATURE_GROUP_TYPE__GENERALIZATION, GENERALIZATION_ESUBSETS));
			}
			return generalizations;
		}
		return new DerivedUnionEObjectEList<Generalization>(Generalization.class, this,
				Aadl2Package.FEATURE_GROUP_TYPE__GENERALIZATION, GENERALIZATION_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getGeneralizations() <em>Generalization</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralizations()
	 * @generated
	 * @ordered
	 */
	protected static final int[] GENERALIZATION_ESUBSETS = new int[] { Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureGroupType getExtended() {
		FeatureGroupType extended = basicGetExtended();
		return extended != null && ((EObject) extended).eIsProxy() ? (FeatureGroupType) eResolveProxy((InternalEObject) extended)
				: extended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FeatureGroupType basicGetExtended() {
		// DONE: implement this method to return the 'Extended' reference
		GroupExtension extension = getOwnedExtension();
		return extension == null ? null : ((GroupExtensionImpl) extension).basicGetExtended();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExtended(FeatureGroupType newExtended) {
		// TODO: implement this method to set the 'Extended' reference
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureGroupType getInverse() {
		if (inverse != null && ((EObject) inverse).eIsProxy()) {
			InternalEObject oldInverse = (InternalEObject) inverse;
			inverse = (FeatureGroupType) eResolveProxy(oldInverse);
			if (inverse != oldInverse) {
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Aadl2Package.FEATURE_GROUP_TYPE__INVERSE,
							oldInverse, inverse));
				}
			}
		}
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureGroupType basicGetInverse() {
		return inverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInverse(FeatureGroupType newInverse) {
		FeatureGroupType oldInverse = inverse;
		inverse = newInverse;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FEATURE_GROUP_TYPE__INVERSE, oldInverse,
					inverse));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupExtension getOwnedExtension() {
		return ownedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExtension(GroupExtension newOwnedExtension, NotificationChain msgs) {
		GroupExtension oldOwnedExtension = ownedExtension;
		ownedExtension = newOwnedExtension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION, oldOwnedExtension, newOwnedExtension);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedExtension(GroupExtension newOwnedExtension) {
		if (newOwnedExtension != ownedExtension) {
			NotificationChain msgs = null;
			if (ownedExtension != null) {
				msgs = ((InternalEObject) ownedExtension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION, null, msgs);
			}
			if (newOwnedExtension != null) {
				msgs = ((InternalEObject) newOwnedExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION, null, msgs);
			}
			msgs = basicSetOwnedExtension(newOwnedExtension, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION,
					newOwnedExtension, newOwnedExtension));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GroupExtension createOwnedExtension() {
		GroupExtension newOwnedExtension = (GroupExtension) create(Aadl2Package.eINSTANCE.getGroupExtension());
		setOwnedExtension(newOwnedExtension);
		return newOwnedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<BusAccess> getOwnedBusAccesses() {
		if (ownedBusAccesses == null) {
			ownedBusAccesses = new EObjectContainmentEList<BusAccess>(BusAccess.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS);
		}
		return ownedBusAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BusAccess createOwnedBusAccess() {
		BusAccess newOwnedBusAccess = (BusAccess) create(Aadl2Package.eINSTANCE.getBusAccess());
		getOwnedBusAccesses().add(newOwnedBusAccess);
		return newOwnedBusAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataAccess> getOwnedDataAccesses() {
		if (ownedDataAccesses == null) {
			ownedDataAccesses = new EObjectContainmentEList<DataAccess>(DataAccess.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS);
		}
		return ownedDataAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataAccess createOwnedDataAccess() {
		DataAccess newOwnedDataAccess = (DataAccess) create(Aadl2Package.eINSTANCE.getDataAccess());
		getOwnedDataAccesses().add(newOwnedDataAccess);
		return newOwnedDataAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataPort> getOwnedDataPorts() {
		if (ownedDataPorts == null) {
			ownedDataPorts = new EObjectContainmentEList<DataPort>(DataPort.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT);
		}
		return ownedDataPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataPort createOwnedDataPort() {
		DataPort newOwnedDataPort = (DataPort) create(Aadl2Package.eINSTANCE.getDataPort());
		getOwnedDataPorts().add(newOwnedDataPort);
		return newOwnedDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventDataPort> getOwnedEventDataPorts() {
		if (ownedEventDataPorts == null) {
			ownedEventDataPorts = new EObjectContainmentEList<EventDataPort>(EventDataPort.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT);
		}
		return ownedEventDataPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventDataPort createOwnedEventDataPort() {
		EventDataPort newOwnedEventDataPort = (EventDataPort) create(Aadl2Package.eINSTANCE.getEventDataPort());
		getOwnedEventDataPorts().add(newOwnedEventDataPort);
		return newOwnedEventDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventPort> getOwnedEventPorts() {
		if (ownedEventPorts == null) {
			ownedEventPorts = new EObjectContainmentEList<EventPort>(EventPort.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT);
		}
		return ownedEventPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventPort createOwnedEventPort() {
		EventPort newOwnedEventPort = (EventPort) create(Aadl2Package.eINSTANCE.getEventPort());
		getOwnedEventPorts().add(newOwnedEventPort);
		return newOwnedEventPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FeatureGroup> getOwnedFeatureGroups() {
		if (ownedFeatureGroups == null) {
			ownedFeatureGroups = new EObjectContainmentEList<FeatureGroup>(FeatureGroup.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP);
		}
		return ownedFeatureGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureGroup createOwnedFeatureGroup() {
		FeatureGroup newOwnedFeatureGroup = (FeatureGroup) create(Aadl2Package.eINSTANCE.getFeatureGroup());
		getOwnedFeatureGroups().add(newOwnedFeatureGroup);
		return newOwnedFeatureGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Parameter> getOwnedParameters() {
		if (ownedParameters == null) {
			ownedParameters = new EObjectContainmentEList<Parameter>(Parameter.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER);
		}
		return ownedParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createOwnedParameter() {
		Parameter newOwnedParameter = (Parameter) create(Aadl2Package.eINSTANCE.getParameter());
		getOwnedParameters().add(newOwnedParameter);
		return newOwnedParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramAccess> getOwnedSubprogramAccesses() {
		if (ownedSubprogramAccesses == null) {
			ownedSubprogramAccesses = new EObjectContainmentEList<SubprogramAccess>(SubprogramAccess.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS);
		}
		return ownedSubprogramAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramAccess createOwnedSubprogramAccess() {
		SubprogramAccess newOwnedSubprogramAccess = (SubprogramAccess) create(Aadl2Package.eINSTANCE
				.getSubprogramAccess());
		getOwnedSubprogramAccesses().add(newOwnedSubprogramAccess);
		return newOwnedSubprogramAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramGroupAccess> getOwnedSubprogramGroupAccesses() {
		if (ownedSubprogramGroupAccesses == null) {
			ownedSubprogramGroupAccesses = new EObjectContainmentEList<SubprogramGroupAccess>(
					SubprogramGroupAccess.class, this, Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS);
		}
		return ownedSubprogramGroupAccesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramGroupAccess createOwnedSubprogramGroupAccess() {
		SubprogramGroupAccess newOwnedSubprogramGroupAccess = (SubprogramGroupAccess) create(Aadl2Package.eINSTANCE
				.getSubprogramGroupAccess());
		getOwnedSubprogramGroupAccesses().add(newOwnedSubprogramGroupAccess);
		return newOwnedSubprogramGroupAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractFeature> getOwnedAbstractFeatures() {
		if (ownedAbstractFeatures == null) {
			ownedAbstractFeatures = new EObjectContainmentEList<AbstractFeature>(AbstractFeature.class, this,
					Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE);
		}
		return ownedAbstractFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractFeature createOwnedAbstractFeature() {
		AbstractFeature newOwnedAbstractFeature = (AbstractFeature) create(Aadl2Package.eINSTANCE.getAbstractFeature());
		getOwnedAbstractFeatures().add(newOwnedAbstractFeature);
		return newOwnedAbstractFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION:
			return basicSetOwnedExtension(null, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS:
			return ((InternalEList<?>) getOwnedBusAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS:
			return ((InternalEList<?>) getOwnedDataAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT:
			return ((InternalEList<?>) getOwnedDataPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT:
			return ((InternalEList<?>) getOwnedEventDataPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT:
			return ((InternalEList<?>) getOwnedEventPorts()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP:
			return ((InternalEList<?>) getOwnedFeatureGroups()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER:
			return ((InternalEList<?>) getOwnedParameters()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return ((InternalEList<?>) getOwnedSubprogramAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return ((InternalEList<?>) getOwnedSubprogramGroupAccesses()).basicRemove(otherEnd, msgs);
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			return ((InternalEList<?>) getOwnedAbstractFeatures()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE:
			return getOwnedFeatures();
		case Aadl2Package.FEATURE_GROUP_TYPE__EXTENDED:
			if (resolve) {
				return getExtended();
			}
			return basicGetExtended();
		case Aadl2Package.FEATURE_GROUP_TYPE__INVERSE:
			if (resolve) {
				return getInverse();
			}
			return basicGetInverse();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION:
			return getOwnedExtension();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS:
			return getOwnedBusAccesses();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS:
			return getOwnedDataAccesses();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT:
			return getOwnedDataPorts();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT:
			return getOwnedEventDataPorts();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT:
			return getOwnedEventPorts();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP:
			return getOwnedFeatureGroups();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER:
			return getOwnedParameters();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return getOwnedSubprogramAccesses();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return getOwnedSubprogramGroupAccesses();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			return getOwnedAbstractFeatures();
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
		case Aadl2Package.FEATURE_GROUP_TYPE__EXTENDED:
			setExtended((FeatureGroupType) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__INVERSE:
			setInverse((FeatureGroupType) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION:
			setOwnedExtension((GroupExtension) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS:
			getOwnedBusAccesses().clear();
			getOwnedBusAccesses().addAll((Collection<? extends BusAccess>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS:
			getOwnedDataAccesses().clear();
			getOwnedDataAccesses().addAll((Collection<? extends DataAccess>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT:
			getOwnedDataPorts().clear();
			getOwnedDataPorts().addAll((Collection<? extends DataPort>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT:
			getOwnedEventDataPorts().clear();
			getOwnedEventDataPorts().addAll((Collection<? extends EventDataPort>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT:
			getOwnedEventPorts().clear();
			getOwnedEventPorts().addAll((Collection<? extends EventPort>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP:
			getOwnedFeatureGroups().clear();
			getOwnedFeatureGroups().addAll((Collection<? extends FeatureGroup>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER:
			getOwnedParameters().clear();
			getOwnedParameters().addAll((Collection<? extends Parameter>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			getOwnedSubprogramAccesses().clear();
			getOwnedSubprogramAccesses().addAll((Collection<? extends SubprogramAccess>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			getOwnedSubprogramGroupAccesses().clear();
			getOwnedSubprogramGroupAccesses().addAll((Collection<? extends SubprogramGroupAccess>) newValue);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			getOwnedAbstractFeatures().clear();
			getOwnedAbstractFeatures().addAll((Collection<? extends AbstractFeature>) newValue);
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
		case Aadl2Package.FEATURE_GROUP_TYPE__EXTENDED:
			setExtended((FeatureGroupType) null);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__INVERSE:
			setInverse((FeatureGroupType) null);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION:
			setOwnedExtension((GroupExtension) null);
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS:
			getOwnedBusAccesses().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS:
			getOwnedDataAccesses().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT:
			getOwnedDataPorts().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT:
			getOwnedEventDataPorts().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT:
			getOwnedEventPorts().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP:
			getOwnedFeatureGroups().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER:
			getOwnedParameters().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			getOwnedSubprogramAccesses().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			getOwnedSubprogramGroupAccesses().clear();
			return;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			getOwnedAbstractFeatures().clear();
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
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE:
			return isSetOwnedFeatures();
		case Aadl2Package.FEATURE_GROUP_TYPE__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.FEATURE_GROUP_TYPE__GENERAL:
			return isSetGenerals();
		case Aadl2Package.FEATURE_GROUP_TYPE__GENERALIZATION:
			return isSetGeneralizations();
		case Aadl2Package.FEATURE_GROUP_TYPE__EXTENDED:
			return basicGetExtended() != null;
		case Aadl2Package.FEATURE_GROUP_TYPE__INVERSE:
			return inverse != null;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION:
			return ownedExtension != null;
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS:
			return ownedBusAccesses != null && !ownedBusAccesses.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS:
			return ownedDataAccesses != null && !ownedDataAccesses.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT:
			return ownedDataPorts != null && !ownedDataPorts.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT:
			return ownedEventDataPorts != null && !ownedEventDataPorts.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT:
			return ownedEventPorts != null && !ownedEventPorts.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP:
			return ownedFeatureGroups != null && !ownedFeatureGroups.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER:
			return ownedParameters != null && !ownedParameters.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS:
			return ownedSubprogramAccesses != null && !ownedSubprogramAccesses.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS:
			return ownedSubprogramGroupAccesses != null && !ownedSubprogramGroupAccesses.isEmpty();
		case Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE:
			return ownedAbstractFeatures != null && !ownedAbstractFeatures.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedFeatures() {
		return eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_BUS_ACCESS)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_ACCESS)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_DATA_PORT)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_DATA_PORT)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EVENT_PORT)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_FEATURE_GROUP)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_PARAMETER)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_ACCESS)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_SUBPROGRAM_GROUP_ACCESS)
				|| eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_ABSTRACT_FEATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassifierFeatures() {
		return super.isSetClassifierFeatures() || isSetOwnedFeatures();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || isSetOwnedFeatures();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGenerals() {
		return super.isSetGenerals() || eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__EXTENDED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGeneralizations() {
		return super.isSetGeneralizations() || eIsSet(Aadl2Package.FEATURE_GROUP_TYPE__OWNED_EXTENSION);
	}

	@Override
	public NamedElement findNamedElement(String name) {
		NamedElement searchResult = super.findNamedElement(name);
		if (searchResult != null) {
			return searchResult;
		}
		if (getOwnedFeatures().isEmpty() && getInverse() != null) {
			return getInverse().findNamedElement(name);
		}
		return null;
	}

	/**
	 * returns true of this feature group type is the inverse of the feature group type pgt
	 * @param pgt FeatureGroupType the feature group type to compare to
	 * @return boolean true if they are inverse of each other
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public boolean isInverseOf(FeatureGroupType pgt) {
		if (pgt == null) {
			OsateDebug.osateDebug("[FeatureGroupTypeImpl] isInverseOf, warning, null pgt arg");
			return false;
		}

		FeatureGroupType srct = this;
		FeatureGroupType dstt = pgt;
		final FeatureGroupType srcInv = srct.getInverse();
		final FeatureGroupType destInv = dstt.getInverse();
		return (((srcInv != null) && (srcInv == dstt)) || ((destInv != null) && (destInv == srct)));
	}

	/**
	 * return the index of the feature in the feature group type
	 * @param feature Feature
	 * @return int index of feature or -1 if not found
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public int getIndexOf(Feature feature) {
		EList<Feature> flist = getAllFeatures();
		return flist.indexOf(feature);
	}

	/**
	 * Get a list of Feature objects representing those features in the
	 * feature group type, including those from super types or inverses.
	 * In case of an inverse feature group type, we returns its ports of the inverse target.
	 * @return A list of Feature objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public EList<Feature> getAllFeatures() {
		final EList<Classifier> ancestors = getSelfPlusAllExtendedInverse();
		final BasicEList<Feature> returnlist = new BasicEList<Feature>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final FeatureGroupType current = (FeatureGroupType) li.previous();
			final EList<Feature> currentFeatures = current.getOwnedFeatures();
			if (currentFeatures != null) {
				for (Iterator<Feature> i = currentFeatures.iterator(); i.hasNext();) {
					final Feature fe = i.next();
					final Feature rfe = fe.getRefined();
					if (rfe != null) {
						returnlist.remove(rfe);
					}
					returnlist.add(fe);
				}
			}
		}
		return returnlist;
	}

	public EList<Classifier> getSelfPlusAllExtendedInverse() {
		final EList<Classifier> result = new BasicEList<Classifier>();

		FeatureGroupType current = this;
		FeatureGroupType inverseFGT = current.getInverse();
		if (current.getOwnedFeatures().isEmpty() && !Aadl2Util.isNull(inverseFGT)) {
			current = inverseFGT;
		}

		do {
			result.add(current);
			current = current.getExtended();
			if (current != null) {
				inverseFGT = current.getInverse();
				if (current.getOwnedFeatures().isEmpty() && !Aadl2Util.isNull(inverseFGT)) {
					current = inverseFGT;
				}
			}
		} while (current != null && !result.contains(current));
		return result;
	}

	@Override
	public EList<Prototype> getAllPrototypes() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Prototype> returnlist = new BasicEList<Prototype>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final FeatureGroupType current = (FeatureGroupType) li.previous();
			final EList<Prototype> currentItems = current.getOwnedPrototypes();
			if (currentItems != null) {
				for (Iterator<Prototype> i = currentItems.iterator(); i.hasNext();) {
					final Prototype fe = i.next();
					final Prototype rfe = fe.getRefined();
					if (rfe != null) {
						returnlist.remove(rfe);
					}
					returnlist.add(fe);
				}
			}
		}
		return returnlist;
	}

	/**
	 * Does this feature group type descend from the given classifier? A
	 * feature group type descends from another feature group type if they are the same
	 * type, it extends the other type, or it extends a descendant of the other
	 * type. A feature group type never descends from a component classifier.
	 *
	 * @return Whether this classifier descends from the given classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public final boolean isDescendentOf(Classifier c) {
		FeatureGroupType current = this;
		do {
			if (current == c) {
				return true;
			}
			current = current.getExtended();
			// avoid loops by stopping if we extend ourself
		} while (current != null && current != this);
		return false;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public final void getPropertyValueInternal(final Property pn, final PropertyAcc paa,
			final boolean fromInstanceSlaveCall) throws InvalidModelException {
		/*
		 * First see if the property is defined in feature group's properties
		 * subclause (could merge this with the loop below, but I want to make
		 * the steps more explicit.)
		 */
		if (paa.addLocal(this)) {
			return;
		}

		// Next walk the component type hierarchy
		FeatureGroupType currentType = getExtended();
		while (currentType != null) {
			if (paa.addLocal(currentType)) {
				return;
			}
			currentType = currentType.getExtended();
		}
	}

} // FeatureGroupTypeImpl
