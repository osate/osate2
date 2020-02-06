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
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.aadl2.impl.AnnexSubclauseImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPath;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getTypeEquivalence <em>Type Equivalence</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getTypeMappingSet <em>Type Mapping Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getPropagations <em>Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getFlows <em>Flows</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getUseTransformation <em>Use Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getOutgoingPropagationConditions <em>Outgoing Propagation Conditions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getErrorDetections <em>Error Detections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getErrorStateToModeMappings <em>Error State To Mode Mappings</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getTypeTransformationSet <em>Type Transformation Set</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getConnectionErrorSources <em>Connection Error Sources</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getPaths <em>Paths</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelSubclauseImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ErrorModelSubclauseImpl extends AnnexSubclauseImpl implements ErrorModelSubclause
{
  /**
   * The cached value of the '{@link #getUseTypes() <em>Use Types</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseTypes()
   * @generated
   * @ordered
   */
  protected EList<ErrorModelLibrary> useTypes;

  /**
   * The cached value of the '{@link #getTypeEquivalence() <em>Type Equivalence</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeEquivalence()
   * @generated
   * @ordered
   */
  protected TypeMappingSet typeEquivalence;

  /**
   * The cached value of the '{@link #getTypeMappingSet() <em>Type Mapping Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeMappingSet()
   * @generated
   * @ordered
   */
  protected TypeMappingSet typeMappingSet;

  /**
   * The cached value of the '{@link #getUseBehavior() <em>Use Behavior</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseBehavior()
   * @generated
   * @ordered
   */
  protected ErrorBehaviorStateMachine useBehavior;

  /**
   * The cached value of the '{@link #getPropagations() <em>Propagations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPropagations()
   * @generated
   * @ordered
   */
  protected EList<ErrorPropagation> propagations;

  /**
   * The cached value of the '{@link #getFlows() <em>Flows</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFlows()
   * @generated
   * @ordered
   */
  protected EList<ErrorFlow> flows;

  /**
   * The cached value of the '{@link #getUseTransformation() <em>Use Transformation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUseTransformation()
   * @generated
   * @ordered
   */
  protected TypeTransformationSet useTransformation;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorEvent> events;

  /**
   * The cached value of the '{@link #getTransitions() <em>Transitions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransitions()
   * @generated
   * @ordered
   */
  protected EList<ErrorBehaviorTransition> transitions;

  /**
   * The cached value of the '{@link #getOutgoingPropagationConditions() <em>Outgoing Propagation Conditions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingPropagationConditions()
   * @generated
   * @ordered
   */
  protected EList<OutgoingPropagationCondition> outgoingPropagationConditions;

  /**
   * The cached value of the '{@link #getErrorDetections() <em>Error Detections</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorDetections()
   * @generated
   * @ordered
   */
  protected EList<ErrorDetection> errorDetections;

  /**
   * The cached value of the '{@link #getErrorStateToModeMappings() <em>Error State To Mode Mappings</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorStateToModeMappings()
   * @generated
   * @ordered
   */
  protected EList<ErrorStateToModeMapping> errorStateToModeMappings;

  /**
   * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStates()
   * @generated
   * @ordered
   */
  protected EList<CompositeState> states;

  /**
   * The cached value of the '{@link #getTypeTransformationSet() <em>Type Transformation Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypeTransformationSet()
   * @generated
   * @ordered
   */
  protected TypeTransformationSet typeTransformationSet;

  /**
   * The cached value of the '{@link #getConnectionErrorSources() <em>Connection Error Sources</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnectionErrorSources()
   * @generated
   * @ordered
   */
  protected EList<ErrorSource> connectionErrorSources;

  /**
   * The cached value of the '{@link #getPoints() <em>Points</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPoints()
   * @generated
   * @ordered
   */
  protected EList<PropagationPoint> points;

  /**
   * The cached value of the '{@link #getPaths() <em>Paths</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaths()
   * @generated
   * @ordered
   */
  protected EList<PropagationPath> paths;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<EMV2PropertyAssociation> properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ErrorModelSubclauseImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ErrorModelPackage.Literals.ERROR_MODEL_SUBCLAUSE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorModelLibrary> getUseTypes()
  {
    if (useTypes == null)
    {
      useTypes = new EObjectResolvingEList<ErrorModelLibrary>(ErrorModelLibrary.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TYPES);
    }
    return useTypes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMappingSet getTypeEquivalence()
  {
    if (typeEquivalence != null && typeEquivalence.eIsProxy())
    {
      InternalEObject oldTypeEquivalence = (InternalEObject)typeEquivalence;
      typeEquivalence = (TypeMappingSet)eResolveProxy(oldTypeEquivalence);
      if (typeEquivalence != oldTypeEquivalence)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE, oldTypeEquivalence, typeEquivalence));
      }
    }
    return typeEquivalence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMappingSet basicGetTypeEquivalence()
  {
    return typeEquivalence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeEquivalence(TypeMappingSet newTypeEquivalence)
  {
    TypeMappingSet oldTypeEquivalence = typeEquivalence;
    typeEquivalence = newTypeEquivalence;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE, oldTypeEquivalence, typeEquivalence));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMappingSet getTypeMappingSet()
  {
    if (typeMappingSet != null && typeMappingSet.eIsProxy())
    {
      InternalEObject oldTypeMappingSet = (InternalEObject)typeMappingSet;
      typeMappingSet = (TypeMappingSet)eResolveProxy(oldTypeMappingSet);
      if (typeMappingSet != oldTypeMappingSet)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET, oldTypeMappingSet, typeMappingSet));
      }
    }
    return typeMappingSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeMappingSet basicGetTypeMappingSet()
  {
    return typeMappingSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeMappingSet(TypeMappingSet newTypeMappingSet)
  {
    TypeMappingSet oldTypeMappingSet = typeMappingSet;
    typeMappingSet = newTypeMappingSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET, oldTypeMappingSet, typeMappingSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorStateMachine getUseBehavior()
  {
    if (useBehavior != null && useBehavior.eIsProxy())
    {
      InternalEObject oldUseBehavior = (InternalEObject)useBehavior;
      useBehavior = (ErrorBehaviorStateMachine)eResolveProxy(oldUseBehavior);
      if (useBehavior != oldUseBehavior)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR, oldUseBehavior, useBehavior));
      }
    }
    return useBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ErrorBehaviorStateMachine basicGetUseBehavior()
  {
    return useBehavior;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseBehavior(ErrorBehaviorStateMachine newUseBehavior)
  {
    ErrorBehaviorStateMachine oldUseBehavior = useBehavior;
    useBehavior = newUseBehavior;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR, oldUseBehavior, useBehavior));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorPropagation> getPropagations()
  {
    if (propagations == null)
    {
      propagations = new EObjectContainmentEList<ErrorPropagation>(ErrorPropagation.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS);
    }
    return propagations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorFlow> getFlows()
  {
    if (flows == null)
    {
      flows = new EObjectContainmentEList<ErrorFlow>(ErrorFlow.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__FLOWS);
    }
    return flows;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformationSet getUseTransformation()
  {
    if (useTransformation != null && useTransformation.eIsProxy())
    {
      InternalEObject oldUseTransformation = (InternalEObject)useTransformation;
      useTransformation = (TypeTransformationSet)eResolveProxy(oldUseTransformation);
      if (useTransformation != oldUseTransformation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION, oldUseTransformation, useTransformation));
      }
    }
    return useTransformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformationSet basicGetUseTransformation()
  {
    return useTransformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseTransformation(TypeTransformationSet newUseTransformation)
  {
    TypeTransformationSet oldUseTransformation = useTransformation;
    useTransformation = newUseTransformation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION, oldUseTransformation, useTransformation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorEvent> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<ErrorBehaviorEvent>(ErrorBehaviorEvent.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__EVENTS);
    }
    return events;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorBehaviorTransition> getTransitions()
  {
    if (transitions == null)
    {
      transitions = new EObjectContainmentEList<ErrorBehaviorTransition>(ErrorBehaviorTransition.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TRANSITIONS);
    }
    return transitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<OutgoingPropagationCondition> getOutgoingPropagationConditions()
  {
    if (outgoingPropagationConditions == null)
    {
      outgoingPropagationConditions = new EObjectContainmentEList<OutgoingPropagationCondition>(OutgoingPropagationCondition.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS);
    }
    return outgoingPropagationConditions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorDetection> getErrorDetections()
  {
    if (errorDetections == null)
    {
      errorDetections = new EObjectContainmentEList<ErrorDetection>(ErrorDetection.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS);
    }
    return errorDetections;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorStateToModeMapping> getErrorStateToModeMappings()
  {
    if (errorStateToModeMappings == null)
    {
      errorStateToModeMappings = new EObjectContainmentEList<ErrorStateToModeMapping>(ErrorStateToModeMapping.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS);
    }
    return errorStateToModeMappings;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CompositeState> getStates()
  {
    if (states == null)
    {
      states = new EObjectContainmentEList<CompositeState>(CompositeState.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__STATES);
    }
    return states;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformationSet getTypeTransformationSet()
  {
    if (typeTransformationSet != null && typeTransformationSet.eIsProxy())
    {
      InternalEObject oldTypeTransformationSet = (InternalEObject)typeTransformationSet;
      typeTransformationSet = (TypeTransformationSet)eResolveProxy(oldTypeTransformationSet);
      if (typeTransformationSet != oldTypeTransformationSet)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET, oldTypeTransformationSet, typeTransformationSet));
      }
    }
    return typeTransformationSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeTransformationSet basicGetTypeTransformationSet()
  {
    return typeTransformationSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTypeTransformationSet(TypeTransformationSet newTypeTransformationSet)
  {
    TypeTransformationSet oldTypeTransformationSet = typeTransformationSet;
    typeTransformationSet = newTypeTransformationSet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET, oldTypeTransformationSet, typeTransformationSet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ErrorSource> getConnectionErrorSources()
  {
    if (connectionErrorSources == null)
    {
      connectionErrorSources = new EObjectContainmentEList<ErrorSource>(ErrorSource.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES);
    }
    return connectionErrorSources;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PropagationPoint> getPoints()
  {
    if (points == null)
    {
      points = new EObjectContainmentEList<PropagationPoint>(PropagationPoint.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__POINTS);
    }
    return points;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<PropagationPath> getPaths()
  {
    if (paths == null)
    {
      paths = new EObjectContainmentEList<PropagationPath>(PropagationPath.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PATHS);
    }
    return paths;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EMV2PropertyAssociation> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<EMV2PropertyAssociation>(EMV2PropertyAssociation.class, this, ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS:
        return ((InternalEList<?>)getPropagations()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__FLOWS:
        return ((InternalEList<?>)getFlows()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TRANSITIONS:
        return ((InternalEList<?>)getTransitions()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS:
        return ((InternalEList<?>)getOutgoingPropagationConditions()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS:
        return ((InternalEList<?>)getErrorDetections()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS:
        return ((InternalEList<?>)getErrorStateToModeMappings()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__STATES:
        return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES:
        return ((InternalEList<?>)getConnectionErrorSources()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__POINTS:
        return ((InternalEList<?>)getPoints()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PATHS:
        return ((InternalEList<?>)getPaths()).basicRemove(otherEnd, msgs);
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TYPES:
        return getUseTypes();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE:
        if (resolve) return getTypeEquivalence();
        return basicGetTypeEquivalence();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET:
        if (resolve) return getTypeMappingSet();
        return basicGetTypeMappingSet();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
        if (resolve) return getUseBehavior();
        return basicGetUseBehavior();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS:
        return getPropagations();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__FLOWS:
        return getFlows();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION:
        if (resolve) return getUseTransformation();
        return basicGetUseTransformation();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__EVENTS:
        return getEvents();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TRANSITIONS:
        return getTransitions();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS:
        return getOutgoingPropagationConditions();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS:
        return getErrorDetections();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS:
        return getErrorStateToModeMappings();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__STATES:
        return getStates();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET:
        if (resolve) return getTypeTransformationSet();
        return basicGetTypeTransformationSet();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES:
        return getConnectionErrorSources();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__POINTS:
        return getPoints();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PATHS:
        return getPaths();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
        return getProperties();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TYPES:
        getUseTypes().clear();
        getUseTypes().addAll((Collection<? extends ErrorModelLibrary>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE:
        setTypeEquivalence((TypeMappingSet)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET:
        setTypeMappingSet((TypeMappingSet)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
        setUseBehavior((ErrorBehaviorStateMachine)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS:
        getPropagations().clear();
        getPropagations().addAll((Collection<? extends ErrorPropagation>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__FLOWS:
        getFlows().clear();
        getFlows().addAll((Collection<? extends ErrorFlow>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION:
        setUseTransformation((TypeTransformationSet)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends ErrorBehaviorEvent>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TRANSITIONS:
        getTransitions().clear();
        getTransitions().addAll((Collection<? extends ErrorBehaviorTransition>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS:
        getOutgoingPropagationConditions().clear();
        getOutgoingPropagationConditions().addAll((Collection<? extends OutgoingPropagationCondition>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS:
        getErrorDetections().clear();
        getErrorDetections().addAll((Collection<? extends ErrorDetection>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS:
        getErrorStateToModeMappings().clear();
        getErrorStateToModeMappings().addAll((Collection<? extends ErrorStateToModeMapping>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__STATES:
        getStates().clear();
        getStates().addAll((Collection<? extends CompositeState>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET:
        setTypeTransformationSet((TypeTransformationSet)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES:
        getConnectionErrorSources().clear();
        getConnectionErrorSources().addAll((Collection<? extends ErrorSource>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__POINTS:
        getPoints().clear();
        getPoints().addAll((Collection<? extends PropagationPoint>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PATHS:
        getPaths().clear();
        getPaths().addAll((Collection<? extends PropagationPath>)newValue);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends EMV2PropertyAssociation>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TYPES:
        getUseTypes().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE:
        setTypeEquivalence((TypeMappingSet)null);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET:
        setTypeMappingSet((TypeMappingSet)null);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
        setUseBehavior((ErrorBehaviorStateMachine)null);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS:
        getPropagations().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__FLOWS:
        getFlows().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION:
        setUseTransformation((TypeTransformationSet)null);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__EVENTS:
        getEvents().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TRANSITIONS:
        getTransitions().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS:
        getOutgoingPropagationConditions().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS:
        getErrorDetections().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS:
        getErrorStateToModeMappings().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__STATES:
        getStates().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET:
        setTypeTransformationSet((TypeTransformationSet)null);
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES:
        getConnectionErrorSources().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__POINTS:
        getPoints().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PATHS:
        getPaths().clear();
        return;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
        getProperties().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TYPES:
        return useTypes != null && !useTypes.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_EQUIVALENCE:
        return typeEquivalence != null;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_MAPPING_SET:
        return typeMappingSet != null;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_BEHAVIOR:
        return useBehavior != null;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPAGATIONS:
        return propagations != null && !propagations.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__FLOWS:
        return flows != null && !flows.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__USE_TRANSFORMATION:
        return useTransformation != null;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__EVENTS:
        return events != null && !events.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TRANSITIONS:
        return transitions != null && !transitions.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__OUTGOING_PROPAGATION_CONDITIONS:
        return outgoingPropagationConditions != null && !outgoingPropagationConditions.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_DETECTIONS:
        return errorDetections != null && !errorDetections.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__ERROR_STATE_TO_MODE_MAPPINGS:
        return errorStateToModeMappings != null && !errorStateToModeMappings.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__STATES:
        return states != null && !states.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__TYPE_TRANSFORMATION_SET:
        return typeTransformationSet != null;
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__CONNECTION_ERROR_SOURCES:
        return connectionErrorSources != null && !connectionErrorSources.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__POINTS:
        return points != null && !points.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PATHS:
        return paths != null && !paths.isEmpty();
      case ErrorModelPackage.ERROR_MODEL_SUBCLAUSE__PROPERTIES:
        return properties != null && !properties.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ErrorModelSubclauseImpl
