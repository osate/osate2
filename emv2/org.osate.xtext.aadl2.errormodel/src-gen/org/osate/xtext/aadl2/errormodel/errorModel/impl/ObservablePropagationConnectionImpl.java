/**
 * <copyright>
 * </copyright>
 *
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.impl.NamedElementImpl;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Observable Propagation Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ObservablePropagationConnectionImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.ObservablePropagationConnectionImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObservablePropagationConnectionImpl extends NamedElementImpl implements ObservablePropagationConnection
{
  /**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
  protected QualifiedObservableErrorPropagationPoint source;

  /**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
  protected QualifiedObservableErrorPropagationPoint target;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ObservablePropagationConnectionImpl()
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
		return ErrorModelPackage.Literals.OBSERVABLE_PROPAGATION_CONNECTION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public QualifiedObservableErrorPropagationPoint getSource()
  {
		return source;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetSource(QualifiedObservableErrorPropagationPoint newSource, NotificationChain msgs)
  {
		QualifiedObservableErrorPropagationPoint oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSource(QualifiedObservableErrorPropagationPoint newSource)
  {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE, newSource, newSource));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public QualifiedObservableErrorPropagationPoint getTarget()
  {
		return target;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetTarget(QualifiedObservableErrorPropagationPoint newTarget, NotificationChain msgs)
  {
		QualifiedObservableErrorPropagationPoint oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTarget(QualifiedObservableErrorPropagationPoint newTarget)
  {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET, newTarget, newTarget));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE:
				return basicSetSource(null, msgs);
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET:
				return basicSetTarget(null, msgs);
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
		switch (featureID) {
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE:
				return getSource();
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET:
				return getTarget();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE:
				setSource((QualifiedObservableErrorPropagationPoint)newValue);
				return;
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET:
				setTarget((QualifiedObservableErrorPropagationPoint)newValue);
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
		switch (featureID) {
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE:
				setSource((QualifiedObservableErrorPropagationPoint)null);
				return;
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET:
				setTarget((QualifiedObservableErrorPropagationPoint)null);
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
		switch (featureID) {
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__SOURCE:
				return source != null;
			case ErrorModelPackage.OBSERVABLE_PROPAGATION_CONNECTION__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //ObservablePropagationConnectionImpl
