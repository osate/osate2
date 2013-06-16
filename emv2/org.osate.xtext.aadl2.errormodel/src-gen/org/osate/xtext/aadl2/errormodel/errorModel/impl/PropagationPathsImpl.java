/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.impl.ElementImpl;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPaths;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Propagation Paths</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationPathsImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.impl.PropagationPathsImpl#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropagationPathsImpl extends ElementImpl implements PropagationPaths
{
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
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
  protected EList<PropagationPointConnection> connections;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected PropagationPathsImpl()
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
		return ErrorModelPackage.Literals.PROPAGATION_PATHS;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PropagationPoint> getPoints()
  {
		if (points == null) {
			points = new EObjectContainmentEList<PropagationPoint>(PropagationPoint.class, this, ErrorModelPackage.PROPAGATION_PATHS__POINTS);
		}
		return points;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<PropagationPointConnection> getConnections()
  {
		if (connections == null) {
			connections = new EObjectContainmentEList<PropagationPointConnection>(PropagationPointConnection.class, this, ErrorModelPackage.PROPAGATION_PATHS__CONNECTIONS);
		}
		return connections;
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
			case ErrorModelPackage.PROPAGATION_PATHS__POINTS:
				return ((InternalEList<?>)getPoints()).basicRemove(otherEnd, msgs);
			case ErrorModelPackage.PROPAGATION_PATHS__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
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
			case ErrorModelPackage.PROPAGATION_PATHS__POINTS:
				return getPoints();
			case ErrorModelPackage.PROPAGATION_PATHS__CONNECTIONS:
				return getConnections();
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
		switch (featureID) {
			case ErrorModelPackage.PROPAGATION_PATHS__POINTS:
				getPoints().clear();
				getPoints().addAll((Collection<? extends PropagationPoint>)newValue);
				return;
			case ErrorModelPackage.PROPAGATION_PATHS__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends PropagationPointConnection>)newValue);
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
			case ErrorModelPackage.PROPAGATION_PATHS__POINTS:
				getPoints().clear();
				return;
			case ErrorModelPackage.PROPAGATION_PATHS__CONNECTIONS:
				getConnections().clear();
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
			case ErrorModelPackage.PROPAGATION_PATHS__POINTS:
				return points != null && !points.isEmpty();
			case ErrorModelPackage.PROPAGATION_PATHS__CONNECTIONS:
				return connections != null && !connections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PropagationPathsImpl
