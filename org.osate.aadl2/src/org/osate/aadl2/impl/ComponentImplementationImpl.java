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
 * $Id: ComponentImplementationImpl.java,v 1.62 2011-04-11 13:35:51 lwrage Exp $
 */
package org.osate.aadl2.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
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
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EventDataSource;
import org.osate.aadl2.EventSource;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortProxy;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Property;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramProxy;
import org.osate.aadl2.operations.ComponentImplementationOperations;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.aadl2.util.NonNotifyingEObjectEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Component Implementation</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getGenerals <em>General</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedSubcomponents <em>Owned Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getClassifierFeatures <em>Classifier Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedMembers <em>Owned Member</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedConnections <em>Owned Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getGeneralizations <em>Generalization</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedProcessorFeatures <em>Owned Processor Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedInternalFeatures <em>Owned Internal Feature</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getExtended <em>Extended</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedFlowImplementations <em>Owned Flow Implementation</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedExtension <em>Owned Extension</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedRealization <em>Owned Realization</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedEndToEndFlows <em>Owned End To End Flow</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedAbstractSubcomponents <em>Owned Abstract Subcomponent</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedAccessConnections <em>Owned Access Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedParameterConnections <em>Owned Parameter Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedPortConnections <em>Owned Port Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedFeatureConnections <em>Owned Feature Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedFeatureGroupConnections <em>Owned Feature Group Connection</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#isNoSubcomponents <em>No Subcomponents</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#isNoConnections <em>No Connections</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#isNoCalls <em>No Calls</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedEventSources <em>Owned Event Source</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedEventDataSources <em>Owned Event Data Source</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedPortProxies <em>Owned Port Proxy</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.ComponentImplementationImpl#getOwnedSubprogramProxies <em>Owned Subprogram Proxy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentImplementationImpl extends ComponentClassifierImpl implements ComponentImplementation {
	/**
	 * The cached value of the '{@link #getOwnedFlowImplementations() <em>Owned Flow Implementation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFlowImplementations()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowImplementation> ownedFlowImplementations;

	/**
	 * The cached value of the '{@link #getOwnedExtension() <em>Owned Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedExtension()
	 * @generated
	 * @ordered
	 */
	protected ImplementationExtension ownedExtension;

	/**
	 * The cached value of the '{@link #getOwnedRealization() <em>Owned Realization</em>}' containment reference.
	 * <!-- begin-user-doc-->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRealization()
	 * @generated
	 * @ordered
	 */
	protected Realization ownedRealization;

	/**
	 * The cached value of the '{@link #getOwnedEndToEndFlows() <em>Owned End To End Flow</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEndToEndFlows()
	 * @generated
	 * @ordered
	 */
	protected EList<EndToEndFlow> ownedEndToEndFlows;

	/**
	 * The cached value of the '{@link #getOwnedAbstractSubcomponents() <em>Owned Abstract Subcomponent</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAbstractSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractSubcomponent> ownedAbstractSubcomponents;

	/**
	 * The cached value of the '{@link #getOwnedAccessConnections() <em>Owned Access Connection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAccessConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<AccessConnection> ownedAccessConnections;

	/**
	 * The cached value of the '{@link #getOwnedParameterConnections() <em>Owned Parameter Connection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedParameterConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterConnection> ownedParameterConnections;

	/**
	 * The cached value of the '{@link #getOwnedPortConnections() <em>Owned Port Connection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPortConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<PortConnection> ownedPortConnections;

	/**
	 * The cached value of the '{@link #getOwnedFeatureConnections() <em>Owned Feature Connection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatureConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureConnection> ownedFeatureConnections;

	/**
	 * The cached value of the '{@link #getOwnedFeatureGroupConnections() <em>Owned Feature Group Connection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedFeatureGroupConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureGroupConnection> ownedFeatureGroupConnections;

	/**
	 * The default value of the '{@link #isNoSubcomponents() <em>No Subcomponents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_SUBCOMPONENTS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoSubcomponents() <em>No Subcomponents</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected boolean noSubcomponents = NO_SUBCOMPONENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoConnections() <em>No Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoConnections()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_CONNECTIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoConnections() <em>No Connections</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoConnections()
	 * @generated
	 * @ordered
	 */
	protected boolean noConnections = NO_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoCalls() <em>No Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoCalls()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NO_CALLS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoCalls() <em>No Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoCalls()
	 * @generated
	 * @ordered
	 */
	protected boolean noCalls = NO_CALLS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedEventSources() <em>Owned Event Source</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventSources()
	 * @generated
	 * @ordered
	 */
	protected EList<EventSource> ownedEventSources;

	/**
	 * The cached value of the '{@link #getOwnedEventDataSources() <em>Owned Event Data Source</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedEventDataSources()
	 * @generated
	 * @ordered
	 */
	protected EList<EventDataSource> ownedEventDataSources;

	/**
	 * The cached value of the '{@link #getOwnedPortProxies() <em>Owned Port Proxy</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPortProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<PortProxy> ownedPortProxies;

	/**
	 * The cached value of the '{@link #getOwnedSubprogramProxies() <em>Owned Subprogram Proxy</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubprogramProxies()
	 * @generated
	 * @ordered
	 */
	protected EList<SubprogramProxy> ownedSubprogramProxies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getComponentImplementation();
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
								Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS));
			}
			return ownedSubcomponents;
		}
		return new DerivedUnionEObjectEList<Subcomponent>(Subcomponent.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBCOMPONENT, OWNED_SUBCOMPONENT_ESUBSETS);
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
								this, Aadl2Package.COMPONENT_IMPLEMENTATION__CLASSIFIER_FEATURE,
								CLASSIFIER_FEATURE_ESUBSETS));
			}
			return classifierFeatures;
		}
		return new DerivedUnionEObjectEList<ClassifierFeature>(ClassifierFeature.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__CLASSIFIER_FEATURE, CLASSIFIER_FEATURE_ESUBSETS);
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
								Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS));
			}
			return ownedMembers;
		}
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_MEMBER, OWNED_MEMBER_ESUBSETS);
	}

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
								Aadl2Package.COMPONENT_IMPLEMENTATION__GENERAL, GENERAL_ESUBSETS));
			}
			return generals;
		}
		return new DerivedUnionEObjectEList<Classifier>(Classifier.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__GENERAL, GENERAL_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getGenerals() <em>General</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGenerals()
	 * @generated
	 * @ordered
	 */
	protected static final int[] GENERAL_ESUBSETS = new int[] { Aadl2Package.COMPONENT_IMPLEMENTATION__TYPE,
			Aadl2Package.COMPONENT_IMPLEMENTATION__EXTENDED };

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedSubcomponents() <em>Owned Subcomponent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSubcomponents()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_SUBCOMPONENT_ESUBSETS = new int[] { Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT };

	/**
	 * The array of subset feature identifiers for the '{@link #getClassifierFeatures() <em>Classifier Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifierFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] CLASSIFIER_FEATURE_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_MODE,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_MODE_TRANSITION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBCOMPONENT,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_CONNECTION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_INTERNAL_FEATURE };

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Member</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBER_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ANNEX_SUBCLAUSE,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PROTOTYPE, Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_MODE,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_MODE_TRANSITION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBCOMPONENT,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_CONNECTION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_INTERNAL_FEATURE };

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
								Aadl2Package.COMPONENT_IMPLEMENTATION__GENERALIZATION, GENERALIZATION_ESUBSETS));
			}
			return generalizations;
		}
		return new DerivedUnionEObjectEList<Generalization>(Generalization.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__GENERALIZATION, GENERALIZATION_ESUBSETS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoSubcomponents() {
		return noSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoSubcomponents(boolean newNoSubcomponents) {
		boolean oldNoSubcomponents = noSubcomponents;
		noSubcomponents = newNoSubcomponents;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_IMPLEMENTATION__NO_SUBCOMPONENTS, oldNoSubcomponents, noSubcomponents));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoCalls() {
		return noCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoCalls(boolean newNoCalls) {
		boolean oldNoCalls = noCalls;
		noCalls = newNoCalls;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CALLS,
					oldNoCalls, noCalls));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventSource> getOwnedEventSources() {
		if (ownedEventSources == null) {
			ownedEventSources = new EObjectContainmentEList<EventSource>(EventSource.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE);
		}
		return ownedEventSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventSource createOwnedEventSource() {
		EventSource newOwnedEventSource = (EventSource) create(Aadl2Package.eINSTANCE.getEventSource());
		getOwnedEventSources().add(newOwnedEventSource);
		return newOwnedEventSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EventDataSource> getOwnedEventDataSources() {
		if (ownedEventDataSources == null) {
			ownedEventDataSources = new EObjectContainmentEList<EventDataSource>(EventDataSource.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE);
		}
		return ownedEventDataSources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventDataSource createOwnedEventDataSource() {
		EventDataSource newOwnedEventDataSource = (EventDataSource) create(Aadl2Package.eINSTANCE.getEventDataSource());
		getOwnedEventDataSources().add(newOwnedEventDataSource);
		return newOwnedEventDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PortProxy> getOwnedPortProxies() {
		if (ownedPortProxies == null) {
			ownedPortProxies = new EObjectContainmentEList<PortProxy>(PortProxy.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY);
		}
		return ownedPortProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortProxy createOwnedPortProxy() {
		PortProxy newOwnedPortProxy = (PortProxy) create(Aadl2Package.eINSTANCE.getPortProxy());
		getOwnedPortProxies().add(newOwnedPortProxy);
		return newOwnedPortProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SubprogramProxy> getOwnedSubprogramProxies() {
		if (ownedSubprogramProxies == null) {
			ownedSubprogramProxies = new EObjectContainmentEList<SubprogramProxy>(SubprogramProxy.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY);
		}
		return ownedSubprogramProxies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubprogramProxy createOwnedSubprogramProxy() {
		SubprogramProxy newOwnedSubprogramProxy = (SubprogramProxy) create(Aadl2Package.eINSTANCE.getSubprogramProxy());
		getOwnedSubprogramProxies().add(newOwnedSubprogramProxy);
		return newOwnedSubprogramProxy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isNoConnections() {
		return noConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNoConnections(boolean newNoConnections) {
		boolean oldNoConnections = noConnections;
		noConnections = newNoConnections;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CONNECTIONS, oldNoConnections, noConnections));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ComponentImplementation getExtended() {
		ComponentImplementation extended = basicGetExtended();
		extended = extended != null && ((EObject) extended).eIsProxy() ? (ComponentImplementation) eResolveProxy((InternalEObject) extended)
				: extended;
		return extended != null && ((EObject) extended).eIsProxy() ? null // unresolved
																			// proxy
				: extended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public ComponentImplementation basicGetExtended() {
		// DONE: implement this method to return the 'Extended' reference
		ImplementationExtension extension = getOwnedExtension();
		return extension == null ? null : ((ImplementationExtensionImpl) extension).basicGetExtended();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setExtended(ComponentImplementation newExtended) {
		if (newExtended == null) {
			setOwnedExtension(null);
		} else {
			if (getOwnedExtension() == null) {
				createOwnedExtension();
			}

			getOwnedExtension().setExtended(newExtended);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FlowImplementation> getOwnedFlowImplementations() {
		if (ownedFlowImplementations == null) {
			ownedFlowImplementations = new EObjectContainmentEList<FlowImplementation>(FlowImplementation.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION);
		}
		return ownedFlowImplementations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FlowImplementation createOwnedFlowImplementation() {
		FlowImplementation newOwnedFlowImplementation = (FlowImplementation) create(Aadl2Package.eINSTANCE
				.getFlowImplementation());
		getOwnedFlowImplementations().add(newOwnedFlowImplementation);
		return newOwnedFlowImplementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public EList<Connection> getOwnedConnections() {
		// DONE: Implemented
		// DB: The returned list must be an EStructuralFeature.Setting
		final EList<Connection> connections = new NonNotifyingEObjectEList<Connection>(Connection.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_CONNECTION);
		// BasicInternalEList<Connection> connections = new BasicInternalEList<Connection>(
		// Connection.class);
		connections.addAll(getOwnedAccessConnections());
		connections.addAll(getOwnedFeatureConnections());
		connections.addAll(getOwnedFeatureGroupConnections());
		connections.addAll(getOwnedParameterConnections());
		connections.addAll(getOwnedPortConnections());
		return connections;
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedConnections() <em>Owned Connection</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedConnections()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_CONNECTION_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION };

	/**
	 * The array of subset feature identifiers for the '{@link #getGeneralizations() <em>Generalization</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralizations()
	 * @generated
	 * @ordered
	 */
	protected static final int[] GENERALIZATION_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ProcessorFeature> getOwnedProcessorFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<ProcessorFeature> ownedProcessorFeatures = (EList<ProcessorFeature>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature());
			if (ownedProcessorFeatures == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedProcessorFeature(),
						ownedProcessorFeatures = new DerivedUnionEObjectEList<ProcessorFeature>(ProcessorFeature.class,
								this, Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE,
								OWNED_PROCESSOR_FEATURE_ESUBSETS));
			}
			return ownedProcessorFeatures;
		}
		return new DerivedUnionEObjectEList<ProcessorFeature>(ProcessorFeature.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE, OWNED_PROCESSOR_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedProcessorFeatures() <em>Owned Processor Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedProcessorFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_PROCESSOR_FEATURE_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InternalFeature> getOwnedInternalFeatures() {
		CacheAdapter cache = getCacheAdapter();
		if (cache != null) {
			Resource eResource = eResource();
			@SuppressWarnings("unchecked")
			EList<InternalFeature> ownedInternalFeatures = (EList<InternalFeature>) cache.get(eResource, this,
					Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature());
			if (ownedInternalFeatures == null) {
				cache.put(eResource, this, Aadl2Package.eINSTANCE.getComponentImplementation_OwnedInternalFeature(),
						ownedInternalFeatures = new DerivedUnionEObjectEList<InternalFeature>(InternalFeature.class,
								this, Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_INTERNAL_FEATURE,
								OWNED_INTERNAL_FEATURE_ESUBSETS));
			}
			return ownedInternalFeatures;
		}
		return new DerivedUnionEObjectEList<InternalFeature>(InternalFeature.class, this,
				Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_INTERNAL_FEATURE, OWNED_INTERNAL_FEATURE_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedInternalFeatures() <em>Owned Internal Feature</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInternalFeatures()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_INTERNAL_FEATURE_ESUBSETS = new int[] {
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE,
			Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE };

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public ComponentType getType() {
		ComponentType type = basicGetType();
		type = type != null && ((EObject) type).eIsProxy() ? (ComponentType) eResolveProxy((InternalEObject) type)
				: type;
		return type != null && ((EObject) type).eIsProxy() ? null // unresolved
																	// proxy
				: type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public ComponentType basicGetType() {
		// DONE: implement this method to return the 'ComponentType' reference
		Realization realization = getOwnedRealization();
		return realization == null ? null : ((RealizationImpl) realization).basicGetImplemented();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setType(ComponentType newType) {
		if (newType == null) {
			setOwnedRealization(null);
		} else {
			if (getOwnedRealization() == null) {
				createOwnedRealization();
			}

			getOwnedRealization().setImplemented(newType);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImplementationExtension getOwnedExtension() {
		return ownedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedExtension(ImplementationExtension newOwnedExtension, NotificationChain msgs) {
		ImplementationExtension oldOwnedExtension = ownedExtension;
		ownedExtension = newOwnedExtension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION, oldOwnedExtension, newOwnedExtension);
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
	public void setOwnedExtension(ImplementationExtension newOwnedExtension) {
		if (newOwnedExtension != ownedExtension) {
			NotificationChain msgs = null;
			if (ownedExtension != null) {
				msgs = ((InternalEObject) ownedExtension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION, null, msgs);
			}
			if (newOwnedExtension != null) {
				msgs = ((InternalEObject) newOwnedExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION, null, msgs);
			}
			msgs = basicSetOwnedExtension(newOwnedExtension, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION, newOwnedExtension, newOwnedExtension));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImplementationExtension createOwnedExtension() {
		ImplementationExtension newOwnedExtension = (ImplementationExtension) create(Aadl2Package.eINSTANCE
				.getImplementationExtension());
		setOwnedExtension(newOwnedExtension);
		return newOwnedExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Realization getOwnedRealization() {
		return ownedRealization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedRealization(Realization newOwnedRealization, NotificationChain msgs) {
		Realization oldOwnedRealization = ownedRealization;
		ownedRealization = newOwnedRealization;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION, oldOwnedRealization, newOwnedRealization);
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
	public void setOwnedRealization(Realization newOwnedRealization) {
		if (newOwnedRealization != ownedRealization) {
			NotificationChain msgs = null;
			if (ownedRealization != null) {
				msgs = ((InternalEObject) ownedRealization).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION, null, msgs);
			}
			if (newOwnedRealization != null) {
				msgs = ((InternalEObject) newOwnedRealization).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION, null, msgs);
			}
			msgs = basicSetOwnedRealization(newOwnedRealization, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION, newOwnedRealization, newOwnedRealization));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Realization createOwnedRealization() {
		Realization newOwnedRealization = (Realization) create(Aadl2Package.eINSTANCE.getRealization());
		setOwnedRealization(newOwnedRealization);
		return newOwnedRealization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractSubcomponent> getOwnedAbstractSubcomponents() {
		if (ownedAbstractSubcomponents == null) {
			ownedAbstractSubcomponents = new EObjectContainmentEList<AbstractSubcomponent>(AbstractSubcomponent.class,
					this, Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT);
		}
		return ownedAbstractSubcomponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractSubcomponent createOwnedAbstractSubcomponent() {
		AbstractSubcomponent newOwnedAbstractSubcomponent = (AbstractSubcomponent) create(Aadl2Package.eINSTANCE
				.getAbstractSubcomponent());
		getOwnedAbstractSubcomponents().add(newOwnedAbstractSubcomponent);
		return newOwnedAbstractSubcomponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AccessConnection> getOwnedAccessConnections() {
		if (ownedAccessConnections == null) {
			ownedAccessConnections = new EObjectContainmentEList<AccessConnection>(AccessConnection.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION);
		}
		return ownedAccessConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AccessConnection createOwnedAccessConnection() {
		AccessConnection newOwnedAccessConnection = (AccessConnection) create(Aadl2Package.eINSTANCE
				.getAccessConnection());
		getOwnedAccessConnections().add(newOwnedAccessConnection);
		return newOwnedAccessConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ParameterConnection> getOwnedParameterConnections() {
		if (ownedParameterConnections == null) {
			ownedParameterConnections = new EObjectContainmentEList<ParameterConnection>(ParameterConnection.class,
					this, Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION);
		}
		return ownedParameterConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterConnection createOwnedParameterConnection() {
		ParameterConnection newOwnedParameterConnection = (ParameterConnection) create(Aadl2Package.eINSTANCE
				.getParameterConnection());
		getOwnedParameterConnections().add(newOwnedParameterConnection);
		return newOwnedParameterConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PortConnection> getOwnedPortConnections() {
		if (ownedPortConnections == null) {
			ownedPortConnections = new EObjectContainmentEList<PortConnection>(PortConnection.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION);
		}
		return ownedPortConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortConnection createOwnedPortConnection() {
		PortConnection newOwnedPortConnection = (PortConnection) create(Aadl2Package.eINSTANCE.getPortConnection());
		getOwnedPortConnections().add(newOwnedPortConnection);
		return newOwnedPortConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FeatureConnection> getOwnedFeatureConnections() {
		if (ownedFeatureConnections == null) {
			ownedFeatureConnections = new EObjectContainmentEList<FeatureConnection>(FeatureConnection.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION);
		}
		return ownedFeatureConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureConnection createOwnedFeatureConnection() {
		FeatureConnection newOwnedFeatureConnection = (FeatureConnection) create(Aadl2Package.eINSTANCE
				.getFeatureConnection());
		getOwnedFeatureConnections().add(newOwnedFeatureConnection);
		return newOwnedFeatureConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FeatureGroupConnection> getOwnedFeatureGroupConnections() {
		if (ownedFeatureGroupConnections == null) {
			ownedFeatureGroupConnections = new EObjectContainmentEList<FeatureGroupConnection>(
					FeatureGroupConnection.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION);
		}
		return ownedFeatureGroupConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureGroupConnection createOwnedFeatureGroupConnection() {
		FeatureGroupConnection newOwnedFeatureGroupConnection = (FeatureGroupConnection) create(Aadl2Package.eINSTANCE
				.getFeatureGroupConnection());
		getOwnedFeatureGroupConnections().add(newOwnedFeatureGroupConnection);
		return newOwnedFeatureGroupConnection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EndToEndFlow> getOwnedEndToEndFlows() {
		if (ownedEndToEndFlows == null) {
			ownedEndToEndFlows = new EObjectContainmentEList<EndToEndFlow>(EndToEndFlow.class, this,
					Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW);
		}
		return ownedEndToEndFlows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EndToEndFlow createOwnedEndToEndFlow() {
		EndToEndFlow newOwnedEndToEndFlow = (EndToEndFlow) create(Aadl2Package.eINSTANCE.getEndToEndFlow());
		getOwnedEndToEndFlows().add(newOwnedEndToEndFlow);
		return newOwnedEndToEndFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			return ((InternalEList<?>) getOwnedFlowImplementations()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION:
			return basicSetOwnedExtension(null, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION:
			return basicSetOwnedRealization(null, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			return ((InternalEList<?>) getOwnedEndToEndFlows()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			return ((InternalEList<?>) getOwnedAbstractSubcomponents()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			return ((InternalEList<?>) getOwnedAccessConnections()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			return ((InternalEList<?>) getOwnedParameterConnections()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			return ((InternalEList<?>) getOwnedPortConnections()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			return ((InternalEList<?>) getOwnedFeatureConnections()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			return ((InternalEList<?>) getOwnedFeatureGroupConnections()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			return ((InternalEList<?>) getOwnedEventSources()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			return ((InternalEList<?>) getOwnedEventDataSources()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY:
			return ((InternalEList<?>) getOwnedPortProxies()).basicRemove(otherEnd, msgs);
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			return ((InternalEList<?>) getOwnedSubprogramProxies()).basicRemove(otherEnd, msgs);
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return getOwnedSubcomponents();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_CONNECTION:
			return getOwnedConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			return getOwnedProcessorFeatures();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			return getOwnedInternalFeatures();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__TYPE:
			if (resolve) {
				return getType();
			}
			return basicGetType();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__EXTENDED:
			if (resolve) {
				return getExtended();
			}
			return basicGetExtended();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			return getOwnedFlowImplementations();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION:
			return getOwnedExtension();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION:
			return getOwnedRealization();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			return getOwnedEndToEndFlows();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			return getOwnedAbstractSubcomponents();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			return getOwnedAccessConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			return getOwnedParameterConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			return getOwnedPortConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			return getOwnedFeatureConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			return getOwnedFeatureGroupConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_SUBCOMPONENTS:
			return isNoSubcomponents();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CONNECTIONS:
			return isNoConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CALLS:
			return isNoCalls();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			return getOwnedEventSources();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			return getOwnedEventDataSources();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY:
			return getOwnedPortProxies();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			return getOwnedSubprogramProxies();
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION__TYPE:
			setType((ComponentType) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__EXTENDED:
			setExtended((ComponentImplementation) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			getOwnedFlowImplementations().clear();
			getOwnedFlowImplementations().addAll((Collection<? extends FlowImplementation>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION:
			setOwnedExtension((ImplementationExtension) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION:
			setOwnedRealization((Realization) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			getOwnedEndToEndFlows().clear();
			getOwnedEndToEndFlows().addAll((Collection<? extends EndToEndFlow>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			getOwnedAbstractSubcomponents().clear();
			getOwnedAbstractSubcomponents().addAll((Collection<? extends AbstractSubcomponent>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			getOwnedAccessConnections().clear();
			getOwnedAccessConnections().addAll((Collection<? extends AccessConnection>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			getOwnedParameterConnections().clear();
			getOwnedParameterConnections().addAll((Collection<? extends ParameterConnection>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			getOwnedPortConnections().clear();
			getOwnedPortConnections().addAll((Collection<? extends PortConnection>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			getOwnedFeatureConnections().clear();
			getOwnedFeatureConnections().addAll((Collection<? extends FeatureConnection>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			getOwnedFeatureGroupConnections().clear();
			getOwnedFeatureGroupConnections().addAll((Collection<? extends FeatureGroupConnection>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_SUBCOMPONENTS:
			setNoSubcomponents((Boolean) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CONNECTIONS:
			setNoConnections((Boolean) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CALLS:
			setNoCalls((Boolean) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			getOwnedEventSources().clear();
			getOwnedEventSources().addAll((Collection<? extends EventSource>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			getOwnedEventDataSources().clear();
			getOwnedEventDataSources().addAll((Collection<? extends EventDataSource>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY:
			getOwnedPortProxies().clear();
			getOwnedPortProxies().addAll((Collection<? extends PortProxy>) newValue);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			getOwnedSubprogramProxies().clear();
			getOwnedSubprogramProxies().addAll((Collection<? extends SubprogramProxy>) newValue);
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION__TYPE:
			setType((ComponentType) null);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__EXTENDED:
			setExtended((ComponentImplementation) null);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			getOwnedFlowImplementations().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION:
			setOwnedExtension((ImplementationExtension) null);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION:
			setOwnedRealization((Realization) null);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			getOwnedEndToEndFlows().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			getOwnedAbstractSubcomponents().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			getOwnedAccessConnections().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			getOwnedParameterConnections().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			getOwnedPortConnections().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			getOwnedFeatureConnections().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			getOwnedFeatureGroupConnections().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_SUBCOMPONENTS:
			setNoSubcomponents(NO_SUBCOMPONENTS_EDEFAULT);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CONNECTIONS:
			setNoConnections(NO_CONNECTIONS_EDEFAULT);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CALLS:
			setNoCalls(NO_CALLS_EDEFAULT);
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			getOwnedEventSources().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			getOwnedEventDataSources().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY:
			getOwnedPortProxies().clear();
			return;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			getOwnedSubprogramProxies().clear();
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
		case Aadl2Package.COMPONENT_IMPLEMENTATION__GENERAL:
			return isSetGenerals();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBCOMPONENT:
			return isSetOwnedSubcomponents();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__CLASSIFIER_FEATURE:
			return isSetClassifierFeatures();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_MEMBER:
			return isSetOwnedMembers();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_CONNECTION:
			return isSetOwnedConnections();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__GENERALIZATION:
			return isSetGeneralizations();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PROCESSOR_FEATURE:
			return isSetOwnedProcessorFeatures();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_INTERNAL_FEATURE:
			return isSetOwnedInternalFeatures();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__TYPE:
			return basicGetType() != null;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__EXTENDED:
			return basicGetExtended() != null;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION:
			return ownedFlowImplementations != null && !ownedFlowImplementations.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION:
			return ownedExtension != null;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION:
			return ownedRealization != null;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW:
			return ownedEndToEndFlows != null && !ownedEndToEndFlows.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT:
			return ownedAbstractSubcomponents != null && !ownedAbstractSubcomponents.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION:
			return ownedAccessConnections != null && !ownedAccessConnections.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION:
			return ownedParameterConnections != null && !ownedParameterConnections.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION:
			return ownedPortConnections != null && !ownedPortConnections.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION:
			return ownedFeatureConnections != null && !ownedFeatureConnections.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION:
			return ownedFeatureGroupConnections != null && !ownedFeatureGroupConnections.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_SUBCOMPONENTS:
			return noSubcomponents != NO_SUBCOMPONENTS_EDEFAULT;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CONNECTIONS:
			return noConnections != NO_CONNECTIONS_EDEFAULT;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__NO_CALLS:
			return noCalls != NO_CALLS_EDEFAULT;
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE:
			return ownedEventSources != null && !ownedEventSources.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE:
			return ownedEventDataSources != null && !ownedEventDataSources.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY:
			return ownedPortProxies != null && !ownedPortProxies.isEmpty();
		case Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY:
			return ownedSubprogramProxies != null && !ownedSubprogramProxies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (noSubcomponents: ");
		result.append(noSubcomponents);
		result.append(", noConnections: ");
		result.append(noConnections);
		result.append(", noCalls: ");
		result.append(noCalls);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGenerals() {
		return super.isSetGenerals() || eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__TYPE)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__EXTENDED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedSubcomponents() {
		return eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ABSTRACT_SUBCOMPONENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetClassifierFeatures() {
		return super.isSetClassifierFeatures() || isSetOwnedSubcomponents()
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FLOW_IMPLEMENTATION) || isSetOwnedConnections()
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW)
				|| isSetOwnedProcessorFeatures() || isSetOwnedInternalFeatures();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers() || isSetOwnedSubcomponents() || isSetOwnedConnections()
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_END_TO_END_FLOW)
				|| isSetOwnedProcessorFeatures() || isSetOwnedInternalFeatures();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedConnections() {
		return eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_ACCESS_CONNECTION)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PARAMETER_CONNECTION)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_CONNECTION)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_CONNECTION)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_FEATURE_GROUP_CONNECTION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetGeneralizations() {
		return super.isSetGeneralizations() || eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EXTENSION)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_REALIZATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedProcessorFeatures() {
		return eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_PORT_PROXY)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_SUBPROGRAM_PROXY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedInternalFeatures() {
		return eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_SOURCE)
				|| eIsSet(Aadl2Package.COMPONENT_IMPLEMENTATION__OWNED_EVENT_DATA_SOURCE);
	}

	@Override
	public void addConnection(Connection c) {
		if (c instanceof AccessConnection) {
			getOwnedAccessConnections().add((AccessConnection) c);
		} else if (c instanceof FeatureConnection) {
			getOwnedFeatureConnections().add((FeatureConnection) c);
		} else if (c instanceof FeatureGroupConnection) {
			getOwnedFeatureGroupConnections().add((FeatureGroupConnection) c);
		} else if (c instanceof ParameterConnection) {
			getOwnedParameterConnections().add((ParameterConnection) c);
		} else if (c instanceof PortConnection) {
			getOwnedPortConnections().add((PortConnection) c);
		}
	}

	@Override
	public String getTypeName() {
		String n = getName();
		int idx = n.indexOf('.');
		if (idx < 0) {
			return n;
		} else {
			return n.substring(0, idx);
		}
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public String getImplementationName() {
		String n = getName();
		int idx = n.indexOf('.');
		if (idx < 0) {
			return n;
		} else {
			return n.substring(idx + 1);
		}
	}

	/**
	 * get list of all connection objects of a component implementation,
	 * including ancestor features In case of refined connections the refined
	 * connection is returned in the list.
	 *
	 * @return List of connection objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public EList<Connection> getAllConnections() {
		final EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Connection> returnlist = new BasicEList<Connection>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentImplementation current = (ComponentImplementation) li.previous();
			final EList<Connection> currentItems = current.getOwnedConnections();
			if (currentItems != null) {
				for (Iterator<Connection> i = currentItems.iterator(); i.hasNext();) {
					final Connection fe = i.next();
					final Connection rfe = fe.getRefined();
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
	 * get ingoing connections to subcomponents from a specified feature of the
	 * component impl
	 * XXX will not find the correct connection if it is a feature inside a feature group
	 * and there are two feature groups with the same feature group type, i.e., feature.
	 * See AadlUtil.getIngoingConnection for a methods handling this scenario.
	 *
	 * @param feature component impl feature that is the source of a connection
	 * @return EList connections with feature as source
	 */
	@Override
	public EList<Connection> getIngoingConnections(Feature feature) {
		EList<Connection> result = new BasicEList<Connection>();

		for (Connection conn : getAllConnections()) {
			List<Feature> features = feature.getAllFeatureRefinements();

			if (features.contains(conn.getAllSource())
					|| (conn.isBidirectional() && features.contains(conn.getAllDestination()))) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * get list of all subcomponents of a component impl, including ancestor
	 * features In case of refined connections the refined connection is
	 * returned in the list.
	 *
	 * @return List of connections
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	/*
	 * public EList<Subcomponent> getAllSubcomponents() {
	 * final EList<Classifier> ancestors = getAllExtendPlusSelf();
	 * final BasicEList<Subcomponent> returnlist = new BasicEList<Subcomponent>();
	 * // Process from farthest ancestor to self
	 * for (ListIterator<Classifier> li = ancestors.listIterator(ancestors
	 * .size()); li.hasPrevious();) {
	 * final ComponentImplementation current = (ComponentImplementation) li
	 * .previous();
	 * final EList<Subcomponent> currentItems = current
	 * .getOwnedSubcomponents();
	 * if (currentItems != null) {
	 * for (Iterator<Subcomponent> i = currentItems.iterator(); i
	 * .hasNext();) {
	 * final Subcomponent fe = i.next();
	 * final Subcomponent rfe = fe.getRefined();
	 * if (rfe != null)
	 * returnlist.remove(rfe);
	 * returnlist.add(fe);
	 * }
	 * }
	 * }
	 * return returnlist;
	 * }
	 */

	@Override
	public EList<Subcomponent> getAllSubcomponents() {
		return ComponentImplementationOperations.getAllSubcomponents(this);
	}

	/**
	 * get all features including inherited features
	 *
	 * @return EList of features
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public EList<Feature> getAllFeatures() {
		ComponentType type = getType();
		if (type != null) {
			EList<Feature> result = type.getAllFeatures();
			return result;
		} else {
			return ECollections.emptyEList();
		}
	}

	/**
	 * Returns all the mode objects of a given implementation, including
	 * ancestor.
	 *
	 * @return EList of all mode objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	@Override
	public EList<Mode> getAllModes() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Mode> returnlist = new BasicEList<Mode>();
		for (Iterator<Classifier> it = ancestors.iterator(); it.hasNext();) {
			final ComponentImplementation current = (ComponentImplementation) it.next();
			returnlist.addAll(current.getOwnedModes());
		}
		ComponentType type = getType();
		if (Aadl2Util.isNull(type)) {
			return returnlist;
		}
		ancestors = getType().getSelfPlusAllExtended();
		for (Iterator<Classifier> it = ancestors.iterator(); it.hasNext();) {
			final ComponentType current = (ComponentType) it.next();
			returnlist.addAll(current.getOwnedModes());
		}
		return returnlist;
	}

	/**
	 * Returns all the mode transition objects of a given implementation,
	 * including ancestor.
	 *
	 * @return EList of all mode transition objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public EList<ModeTransition> getAllModeTransitions() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<ModeTransition> returnlist = new BasicEList<ModeTransition>();
		for (Iterator<Classifier> it = ancestors.iterator(); it.hasNext();) {
			final ComponentImplementation current = (ComponentImplementation) it.next();
			returnlist.addAll(current.getOwnedModeTransitions());
		}
		if (getType() == null) {
			return returnlist;
		}
		ancestors = getType().getSelfPlusAllExtended();
		for (Iterator<Classifier> it = ancestors.iterator(); it.hasNext();) {
			final ComponentType current = (ComponentType) it.next();
			returnlist.addAll(current.getOwnedModeTransitions());
		}
		return returnlist;
	}

	/**
	 * Returns all the mode objects of a given implementation, including
	 * ancestor.
	 *
	 * @return EList of all mode objects
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation and property lookup
	// work.
	@Override
	public EList<Prototype> getAllPrototypes() {
		EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Prototype> returnlist = new BasicEList<Prototype>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentImplementation current = (ComponentImplementation) li.previous();
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
		ComponentType type = getType();
		if (Aadl2Util.isNull(type)) {
			return returnlist;
		}
		ancestors = getType().getSelfPlusAllExtended();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentType current = (ComponentType) li.previous();
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
	 * get list of all end to end flows of a component impl, including ancestor
	 * features In case of refined end to end flows the refined end to end flow
	 * is returned in the list.
	 *
	 * @return Lis of end to end flows
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public EList<EndToEndFlow> getAllEndToEndFlows() {
		final EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<EndToEndFlow> returnlist = new BasicEList<EndToEndFlow>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentImplementation current = (ComponentImplementation) li.previous();
			final EList<EndToEndFlow> currentItems = current.getOwnedEndToEndFlows();
			if (currentItems != null) {
				for (Iterator<EndToEndFlow> i = currentItems.iterator(); i.hasNext();) {
					final EndToEndFlow fe = i.next();
					final EndToEndFlow rfe = fe.getRefined();
					if (rfe != null) {
						returnlist.remove(rfe);
					}
					returnlist.add(fe);
				}
			}
		}
		return returnlist;
	}

	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	@Override
	public EList<FlowImplementation> getAllFlowImplementations() {
		final BasicEList<FlowImplementation> result = new BasicEList<FlowImplementation>();

		for (Classifier current : getSelfPlusAllExtended()) {
			result.addAll(((ComponentImplementation) current).getOwnedFlowImplementations());
		}
		return result;
	}

	/**
	 * Does this component implementation descend from the given classifier? A
	 * component implementation descends from another component implementation
	 * if they are the same implementation, it extends the other implementation,
	 * or it extends a descendant of the other implementation. A component
	 * implementation descends from a component type if the implementation's
	 * component type descends from the type.
	 *
	 * @return Whether this classifier descends from the given classifier.
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	@Override
	public final boolean isDescendentOf(Classifier c) {
		ComponentImplementation current = this;
		do {
			if (current == c) {
				return true;
			}
			current = current.getExtended();
			// Avoid loops by stopping if we extend ourself
		} while (current != null && current != this);
		// try the type hierarchy
		return getType().isDescendentOf(c);
	}

	@Override
	public void getPropertyValueInternal(Property property, final PropertyAcc pas, final boolean fromInstanceSlaveCall)
			throws InvalidModelException {
		// this implementation's properties subclause
		if (pas.addLocal(this)) {
			return;
		}

		// extended implementations
		// avoid loops
		ComponentImplementation currentImpl = getExtended();
		while (currentImpl != null && currentImpl != this) {
			if (pas.addLocal(currentImpl)) {
				return;
			}
			currentImpl = currentImpl.getExtended();
		}

		// the type
		if (getType() != null) {
			getType().getPropertyValueInternal(property, pas, fromInstanceSlaveCall);
		} else {
			// XXX we have an unresolved implementation or alias throw new InvalidModelException(this,
			// "Component implementation is missing its component type reference.");
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.ComponentClassifier#lookupPrototypeBinding(edu
	 * .cmu.sei.aadl.aadl2.Prototype)
	 */
	@Override
	public PrototypeBinding lookupPrototypeBinding(Prototype proto) {
		PrototypeBinding pb = lookupPrototypeBindingHelper(proto);
		if (pb == null) {
			try {
				pb = getType().lookupPrototypeBinding(proto);
			} catch (NullPointerException npe) {
				return null;
			}
		}
		return pb;
	}

	protected PrototypeBinding lookupPrototypeBindingHelper(Prototype proto) {
		PrototypeBinding result = null;

		for (PrototypeBinding pb : getOwnedPrototypeBindings()) {
			Prototype refinedProto = pb.getFormal();
			while (refinedProto != proto && refinedProto.getRefined() != null) {
				refinedProto = refinedProto.getRefined();
			}
			if (refinedProto == proto) {
				result = pb;
				break;
			} else {
				refinedProto = proto;
				while (pb.getFormal() != refinedProto && refinedProto.getRefined() != null) {
					refinedProto = refinedProto.getRefined();
				}
				if (pb.getFormal() == refinedProto) {
					result = pb;
					break;
				}
			}
		}
		if (result == null) {
			ComponentImplementationImpl extended = (ComponentImplementationImpl) getExtended();

			if (extended != null) {
				result = extended.lookupPrototypeBindingHelper(proto);
			}
		}
		return result;
	}

	/**
	 * Returns the connection objects of a given implementation for a given mode.
	 *
	 * @param mode Mode for which connections are retrieved.
	 * @return EList of connection objects (possibly empty).
	 */
	@Override
	public EList<Connection> getOwnedConnections(Mode mode) {
		EList<Connection> cl = getOwnedConnections();
		EList<Connection> result = new BasicEList<Connection>();
		for (Connection cn : cl) {
			EList<Mode> inModes = cn.getAllInModes();
			if (inModes.isEmpty() || inModes.contains(mode)) {
				result.add(cn);
			}
		}
		return result;
	}

	/**
	 * Get list of all connections of a component implementation in a given mode, including ancestor
	 * implementations.  In case of refined connections the refined connection is returned in the list.
	 *
	 * @param mode Mode for which connections are to be retrieved.
	 * @return List of connections
	 */
	@Override
	public EList<Connection> getAllConnections(Mode mode) {
		final EList<Classifier> ancestors = getSelfPlusAllExtended();
		final BasicEList<Connection> returnlist = new BasicEList<Connection>();
		// Process from farthest ancestor to self
		for (ListIterator<Classifier> li = ancestors.listIterator(ancestors.size()); li.hasPrevious();) {
			final ComponentImplementation current = (ComponentImplementation) li.previous();
			final EList<Connection> currentItems = current.getOwnedConnections(mode);
			for (final Connection fe : currentItems) {
				final Connection rfe = fe.getRefined();
				if (rfe != null) {
					returnlist.remove(rfe);
				}
				returnlist.add(fe);
			}
		}
		return returnlist;
	}

	@Override
	/**
	 * According to Legality Rule 3 and Semantic Rule 9 in section 4.2 (Packages), a single component
	 * implementation can be defined in both the public and private sections of a package.  This
	 * specialized lookup method allows elements in the private section of a component implementation
	 * to refer to elements in the public section of the component implementation.
	 */
	public NamedElement findNamedElement(String name) {
		// first find in implementation as classifier and its extensions
		NamedElement searchResult = super.findNamedElement(name);
		if (searchResult != null) {
			return searchResult;
		}
		if (getType() != null) {
			searchResult = getType().findNamedElement(name);
		}
		// now look in type and its extensions
		if (searchResult != null) {
			return searchResult;
		}
		// Checks if this component implementation is in a private section and a
		// component implementation with
		// the same name exists in the public section. If so, search in that
		// component implementation.
		if (getOwner() instanceof PrivatePackageSection) {
			PrivatePackageSection privateSection = (PrivatePackageSection) getOwner();
			if (privateSection.getPublicSection() != null) {
				NamedElement publicComponentImplementation = privateSection.getPublicSection().findNamedElement(
						getName());
				if (publicComponentImplementation instanceof ComponentImplementation) {
					return ((ComponentImplementation) publicComponentImplementation).findNamedElement(name);
				}
			}
		}
		return null;
	}
} // ComponentImplementationImpl
