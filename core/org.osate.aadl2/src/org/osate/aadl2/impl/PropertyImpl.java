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
package org.osate.aadl2.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyOwner;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyEvaluationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.impl.PropertyImpl#isInherit <em>Inherit</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyImpl#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyImpl#getAppliesToMetaclasses <em>Applies To Metaclass</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyImpl#getAppliesToClassifiers <em>Applies To Classifier</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyImpl#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.aadl2.impl.PropertyImpl#isEmptyListDefault <em>Empty List Default</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyImpl extends BasicPropertyImpl implements Property {
	/**
	 * The default value of the '{@link #isInherit() <em>Inherit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInherit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INHERIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInherit() <em>Inherit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInherit()
	 * @generated
	 * @ordered
	 */
	protected boolean inherit = INHERIT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDefaultValue() <em>Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultValue()
	 * @generated
	 * @ordered
	 */
	protected PropertyExpression defaultValue;

	/**
	 * The cached value of the '{@link #getAppliesTos() <em>Applies To</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliesTos()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyOwner> appliesTos;

	/**
	 * The default value of the '{@link #isEmptyListDefault() <em>Empty List Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEmptyListDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EMPTY_LIST_DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEmptyListDefault() <em>Empty List Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEmptyListDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean emptyListDefault = EMPTY_LIST_DEFAULT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Aadl2Package.eINSTANCE.getProperty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInherit() {
		return inherit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInherit(boolean newInherit) {
		boolean oldInherit = inherit;
		inherit = newInherit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PROPERTY__INHERIT, oldInherit, inherit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression getDefaultValue() {
		return defaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultValue(PropertyExpression newDefaultValue, NotificationChain msgs) {
		PropertyExpression oldDefaultValue = defaultValue;
		defaultValue = newDefaultValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Aadl2Package.PROPERTY__DEFAULT_VALUE, oldDefaultValue, newDefaultValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultValue(PropertyExpression newDefaultValue) {
		if (newDefaultValue != defaultValue) {
			NotificationChain msgs = null;
			if (defaultValue != null)
				msgs = ((InternalEObject) defaultValue).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.PROPERTY__DEFAULT_VALUE, null, msgs);
			if (newDefaultValue != null)
				msgs = ((InternalEObject) newDefaultValue).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - Aadl2Package.PROPERTY__DEFAULT_VALUE, null, msgs);
			msgs = basicSetDefaultValue(newDefaultValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PROPERTY__DEFAULT_VALUE, newDefaultValue,
					newDefaultValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyOwner> getAppliesTos() {
		if (appliesTos == null) {
			appliesTos = new EObjectContainmentEList<PropertyOwner>(PropertyOwner.class, this,
					Aadl2Package.PROPERTY__APPLIES_TO);
		}
		return appliesTos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyOwner createAppliesTo(EClass eClass) {
		PropertyOwner newAppliesTo = (PropertyOwner) create(eClass);
		getAppliesTos().add(newAppliesTo);
		return newAppliesTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEmptyListDefault() {
		return emptyListDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmptyListDefault(boolean newEmptyListDefault) {
		boolean oldEmptyListDefault = emptyListDefault;
		emptyListDefault = newEmptyListDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT,
					oldEmptyListDefault, emptyListDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyExpression createDefaultValue(EClass eClass) {
		PropertyExpression newDefaultValue = (PropertyExpression) create(eClass);
		setDefaultValue(newDefaultValue);
		return newDefaultValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<MetaclassReference> getAppliesToMetaclasses() {
		// DONE: implement this method to return the 'Applies To Metaclass'
		// reference list
		EList<MetaclassReference> result = new BasicEList<MetaclassReference>();

		for (PropertyOwner po : getAppliesTos()) {
			if (po instanceof MetaclassReference) {
				result.add((MetaclassReference) po);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Classifier> getAppliesToClassifiers() {
		// DONE: implement this method to return the 'Applies To Classifier'
		// reference list
		EList<Classifier> result = new BasicEList<Classifier>();

		for (PropertyOwner po : getAppliesTos()) {
			if (po instanceof Classifier) {
				result.add((Classifier) po);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case Aadl2Package.PROPERTY__DEFAULT_VALUE:
			return basicSetDefaultValue(null, msgs);
		case Aadl2Package.PROPERTY__APPLIES_TO:
			return ((InternalEList<?>) getAppliesTos()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case Aadl2Package.PROPERTY__INHERIT:
			return isInherit();
		case Aadl2Package.PROPERTY__DEFAULT_VALUE:
			return getDefaultValue();
		case Aadl2Package.PROPERTY__APPLIES_TO_METACLASS:
			return getAppliesToMetaclasses();
		case Aadl2Package.PROPERTY__APPLIES_TO_CLASSIFIER:
			return getAppliesToClassifiers();
		case Aadl2Package.PROPERTY__APPLIES_TO:
			return getAppliesTos();
		case Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT:
			return isEmptyListDefault();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case Aadl2Package.PROPERTY__INHERIT:
			setInherit((Boolean) newValue);
			return;
		case Aadl2Package.PROPERTY__DEFAULT_VALUE:
			setDefaultValue((PropertyExpression) newValue);
			return;
		case Aadl2Package.PROPERTY__APPLIES_TO_METACLASS:
			getAppliesToMetaclasses().clear();
			getAppliesToMetaclasses().addAll((Collection<? extends MetaclassReference>) newValue);
			return;
		case Aadl2Package.PROPERTY__APPLIES_TO_CLASSIFIER:
			getAppliesToClassifiers().clear();
			getAppliesToClassifiers().addAll((Collection<? extends Classifier>) newValue);
			return;
		case Aadl2Package.PROPERTY__APPLIES_TO:
			getAppliesTos().clear();
			getAppliesTos().addAll((Collection<? extends PropertyOwner>) newValue);
			return;
		case Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT:
			setEmptyListDefault((Boolean) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case Aadl2Package.PROPERTY__INHERIT:
			setInherit(INHERIT_EDEFAULT);
			return;
		case Aadl2Package.PROPERTY__DEFAULT_VALUE:
			setDefaultValue((PropertyExpression) null);
			return;
		case Aadl2Package.PROPERTY__APPLIES_TO_METACLASS:
			getAppliesToMetaclasses().clear();
			return;
		case Aadl2Package.PROPERTY__APPLIES_TO_CLASSIFIER:
			getAppliesToClassifiers().clear();
			return;
		case Aadl2Package.PROPERTY__APPLIES_TO:
			getAppliesTos().clear();
			return;
		case Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT:
			setEmptyListDefault(EMPTY_LIST_DEFAULT_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case Aadl2Package.PROPERTY__INHERIT:
			return inherit != INHERIT_EDEFAULT;
		case Aadl2Package.PROPERTY__DEFAULT_VALUE:
			return defaultValue != null;
		case Aadl2Package.PROPERTY__APPLIES_TO_METACLASS:
			return !getAppliesToMetaclasses().isEmpty();
		case Aadl2Package.PROPERTY__APPLIES_TO_CLASSIFIER:
			return !getAppliesToClassifiers().isEmpty();
		case Aadl2Package.PROPERTY__APPLIES_TO:
			return appliesTos != null && !appliesTos.isEmpty();
		case Aadl2Package.PROPERTY__EMPTY_LIST_DEFAULT:
			return emptyListDefault != EMPTY_LIST_DEFAULT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (inherit: ");
		result.append(inherit);
		result.append(", emptyListDefault: ");
		result.append(emptyListDefault);
		result.append(')');
		return result.toString();
	}

	public PropertyEvaluationResult evaluate(EvaluationContext ctx, int depth) {
		List<PropertyAssociation> pas = getPropertyValue(ctx).getAssociations();
		List<EvaluatedProperty> vals = new LinkedList<EvaluatedProperty>();

		for (PropertyAssociation pa : pas) {
			// OsateDebug.osateDebug("pa" + pa);
			vals.add(pa.evaluate(ctx, depth));

			if ((!(ctx.getInstanceObject() instanceof ConnectionReference)) && (!pa.isAppend())) {
				break;
			}
		}
		return new PropertyEvaluationResult(pas.isEmpty() ? null : pas.get(0), vals);
	}

	private PropertyAcc getPropertyValue(EvaluationContext ctx) throws IllegalStateException, InvalidModelException,
			PropertyDoesNotApplyToHolderException, IllegalArgumentException {
		// Error if the property is not acceptable
		final PropertyAcc pas = new PropertyAcc(this);
		getPropertyValueInternal(ctx, pas);
		return pas;
	}

	public final void getPropertyValueInternal(EvaluationContext ctx, final PropertyAcc paa)
			throws InvalidModelException {
		InstanceObject io = ctx.getInstanceObject();
		// OsateDebug.osateDebug("here1 " + io + paa);

		/*
		 * Only relevant for connection instances
		 */
		if (ctx.getSCProp() != null) {
			if (paa.add(ctx.getSCProp())) {

				return;
			}
		}
		/*
		 * First see if the property is defined locally in the instance. Such
		 * local property associations arise from component property
		 * associations in the declarative spec, from explicit programmatic
		 * setting of the property, or as cached results from earlier property
		 * lookups.
		 */
		if (paa.addLocal(io)) {
			return;
		}

		getPropertyValueFromDeclarativeModel(ctx, paa);

		/*
		 * If the property is "inherit", get it from the enclosing component
		 * instance. Don't short-circuit this step because the property caching
		 * during instantiation doesn't catch contained property values that may
		 * be attached to an ancestor instance and that might be inherited by
		 * this instance.
		 *
		 * However, we avoid to call it for connection reference because in that
		 * case, for a connection reference, we call that method on the contained
		 * ConnectionInstance that returns the value of the potential other
		 * contained references.
		 */
		if (isInherit() && (!(io instanceof ConnectionReference))) {
			io = (InstanceObject) io.eContainer();
			if (io != null) {
				getPropertyValueInternal(new EvaluationContext(io, ctx.getClassifierCache()), paa);
			}
		}
	}

	protected void getPropertyValueFromDeclarativeModel(EvaluationContext ctx, PropertyAcc pas)
			throws InvalidModelException {
		InstanceObject io = ctx.getInstanceObject();
		List<? extends NamedElement> compDecls = io.getInstantiatedObjects();
		// FIXME: compDecls == null for connection instances
		// OsateDebug.osateDebug("[PropertyImpl] getPropertyValueFromDeclarativeModel" + compDecls);

		if (compDecls == null) {
		}
		// Here we assume compDecls is empty or has only one element
		if (!compDecls.isEmpty()) {
			NamedElement compDecl = compDecls.get(0);
			if (compDecl == null) {
				return;
			}
			InstantiatedClassifier ic = ctx.getClassifierCache().get(io);
			Classifier cl = (ic == null) ? null : ic.classifier;
			// OsateDebug.osateDebug("compDecls" + compDecl);

			if (compDecl instanceof Subcomponent) {
				((SubcomponentImpl) compDecl).getPropertyValue(this, pas, cl, false);
			} else if (compDecl instanceof FeatureGroup) {
				((FeatureGroupImpl) compDecl).getPropertyValue(this, pas, cl, false);
			} else if (compDecl instanceof Feature) {
				((FeatureImpl) compDecl).getPropertyValue(this, pas, cl, false);
			} else if (compDecl instanceof PortConnection) {
				((PortConnectionImpl) compDecl).getPropertyValue(this, pas);
			} else {
				compDecl.getPropertyValueInternal(this, pas, true);
			}
		}
	}

	public EvaluatedProperty evaluateDefault(EvaluationContext ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	// public final AadlPropertyValue evaluate(final OperationKind sign, final
	// NamedElement context)
	// throws InvalidModelException {
	// // Obtained value will already be evaluated
	// /* Should only get here if we know the property applies to property
	// * holder, so we ignore the possibility of a null return from
	// * getPropertyValue.
	// */
	//
	// /* Check for circular property reference. Here, we actually catch
	// * the 2nd (!) loop in the circularity. To catch the first loop, we
	// * would have to initialize the stack in the property value accumulator,
	// * and it is too much work to make the stack available there and here.
	// * So to keep everything self-contained, we don't do that. Catching
	// * the 2nd loop doesn't really matter, just as long as we detect it.
	// */
	// final LinkedList<Property> stack = lookupStack.get();
	// final int idx = stack.indexOf(this);
	// if (idx != -1) {
	// final StringBuilder sb = new StringBuilder();
	// for (int i = idx; i >= 0; i--) {
	// final Property pd = stack.get(i);
	// sb.append(pd.getQualifiedName());
	// sb.append(" -> ");
	// }
	// sb.append(getQualifiedName());
	// throw new IllegalStateException("Circular property reference dependency "
	// + sb);
	// } else {
	// try {
	// stack.addFirst(this);
	// return context.getPropertyValue(this).getValue();
	// } finally {
	// stack.removeFirst();
	// }
	// }
	// }

	public boolean equals(Object p) {
		if (p instanceof Property) {
			String p1Name = getQualifiedName();
			String p2Name = ((Property) p).getQualifiedName();
			if (p1Name != null) {
				return p1Name.equalsIgnoreCase(p2Name);
			}
		}
		return this == p;
	}

	public int hashCode() {
		if (eIsProxy()) {
			return eProxyURI().toString().hashCode();
		}
		return getQualifiedName() != null ? getQualifiedName().hashCode() : super.hashCode();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.AbstractNamedValue#sameAs(org.osate.aadl2.AbstractNamedValue)
	 */
	public boolean sameAs(AbstractNamedValue namedValue) {
		return this == namedValue;
	}

} // PropertyImpl
