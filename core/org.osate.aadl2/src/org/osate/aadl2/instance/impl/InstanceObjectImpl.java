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
package org.osate.aadl2.instance.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osate.aadl2.ArrayRange;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.impl.NamedElementImpl;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.PropertyAssociationInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Object</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.InstanceObjectImpl#getAnnexInstances <em>Annex Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.InstanceObjectImpl#getOwnedPropertyAssociations <em>Owned Property Association</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InstanceObjectImpl extends NamedElementImpl implements InstanceObject {
	/**
	 * The cached value of the '{@link #getAnnexInstances() <em>Annex Instance</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnexInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnexInstance> annexInstances;

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected InstanceObjectImpl() {
		super();
	}

	/*
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected EClass eStaticClass() {
		return InstancePackage.Literals.INSTANCE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnexInstance> getAnnexInstances() {
		if (annexInstances == null) {
			annexInstances = new EObjectContainmentEList<AnnexInstance>(AnnexInstance.class, this,
					InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE);
		}
		return annexInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyAssociation> getOwnedPropertyAssociations() {
		if (ownedPropertyAssociations == null) {
			ownedPropertyAssociations = new EObjectContainmentEList<PropertyAssociation>(
					PropertyAssociationInstance.class, this,
					InstancePackage.INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION);
		}
		return ownedPropertyAssociations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyAssociation createOwnedPropertyAssociation() {
		PropertyAssociationInstance newOwnedPropertyAssociation = (PropertyAssociationInstance) create(
				InstancePackage.Literals.PROPERTY_ASSOCIATION_INSTANCE);
		getOwnedPropertyAssociations().add(newOwnedPropertyAssociation);
		return newOwnedPropertyAssociation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOwnedPropertyAssociations() {
		return ownedPropertyAssociations != null && !ownedPropertyAssociations.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE:
			return ((InternalEList<?>) getAnnexInstances()).basicRemove(otherEnd, msgs);
		case InstancePackage.INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION:
			return ((InternalEList<?>) getOwnedPropertyAssociations()).basicRemove(otherEnd, msgs);
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
		case InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE:
			return getAnnexInstances();
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
		case InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE:
			getAnnexInstances().clear();
			getAnnexInstances().addAll((Collection<? extends AnnexInstance>) newValue);
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
		case InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE:
			getAnnexInstances().clear();
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
		case InstancePackage.INSTANCE_OBJECT__ANNEX_INSTANCE:
			return annexInstances != null && !annexInstances.isEmpty();
		case InstancePackage.INSTANCE_OBJECT__OWNED_PROPERTY_ASSOCIATION:
			return isSetOwnedPropertyAssociations();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Get the closest component instance that contains this object.
	 * If the object is a component instance, get its enclosing instance
	 * @return Closest containing component instance
	 */
	public ComponentInstance getContainingComponentInstance() {
		EObject eobj = this;

		do {
			eobj = eobj.eContainer();
		} while (eobj != null && !(eobj instanceof ComponentInstance));

		return (ComponentInstance) eobj;
	}

	/**
	 * Find the enclosing system instance.
	 *
	 * @return The system instance object
	 */
	public SystemInstance getSystemInstance() {
		EObject eobj = this;

		while (eobj != null && !(eobj instanceof SystemInstance)) {
			eobj = eobj.eContainer();
		}
		return (SystemInstance) eobj;
	}

	/*
	 * construct a string path from the systeminstance as root
	 *
	 * @return path as string
	 */
	public String getInstanceObjectPath() {
		if (this instanceof SystemInstance) {
			return getName();
		}
		final String path = ((InstanceObject) eContainer).getInstanceObjectPath();
		final String localname = getFullName();

		return path.length() == 0 ? localname : path + "." + localname;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.InstanceObject#getComponentInstancePath()
	 */
	public String getComponentInstancePath() {
		if (this instanceof SystemInstance) {
			return "";
		}
		final String path = ((InstanceObject) eContainer).getComponentInstancePath();
		final String localname = getFullName();

		return path.length() == 0 ? localname : path + "." + localname;
	}
	public void getPropertyValueInternal(final Property property, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall, final boolean all) throws InvalidModelException {
		/*
		 * First see if the property is defined locally in the instance. Such
		 * local property associations arise from component property
		 * associations in the declarative spec, from explicit programmatic
		 * setting of the property, or as cached results from earlier property
		 * lookups.
		 */
		if (pas.addLocal(this)) {
			if (!all) {
				return;
			}
		}

		/*
		 * If we don't find the property locally we defer to the declarative
		 * specifications.
		 */
		getPropertyValueFromDeclarativeModel(property, pas);

		/*
		 * If we still don't have a value, and the property is "inherit", get it
		 * from the enclosing component instance. Don't short-circuit this step
		 * because the property caching during instantiation doesn't catch
		 * contained property values that may be attached to an ancestor
		 * instance and that might be inherited by this instance.
		 */
		if (property.isInherit()) {
			final NamedElement ph = (NamedElement) eContainer();
			if (ph != null) {
				ph.getPropertyValueInternal(property, pas, false, all);
			}
		}
	}

	/**
	 * Get the property value from the declarative model elements associated
	 * with the instance object. This implementation works for everything but
	 * ConnectionInstances; this method is overridden in ConnectionInstance to
	 * handle the problem of dealing with all the connections that make up the
	 * semantic connection.
	 *
	 * @param property The property to lookup
	 * @param pva The property value accumulator to use to build the property
	 *            value
	 * @throws InvalidModelException Thrown if the property value cannot be
	 *             retrieved because the model is incomplete or otherwise
	 *             invalid.
	 */
	protected void getPropertyValueFromDeclarativeModel(final Property property, final PropertyAcc pas)
			throws InvalidModelException {
		// apv.pushCurrentComponent(getContainingComponentInstanceOrSelf());
		try {
			final List<? extends NamedElement> compDecls = getInstantiatedObjects();
			// Here we assume compDecls is empty or has only one element
			if (!compDecls.isEmpty()) {
				final NamedElement compDecl = compDecls.get(0);
				if (compDecl == null) {
					return;
				}
				compDecl.getPropertyValueInternal(property, pas, true);
			}
		} finally {
			// apv.popCurrentComponent();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.InstanceObject#getComponentInstance()
	 */
	public ComponentInstance getComponentInstance() {
		EObject current = this;
		while (current != null && !(current instanceof ComponentInstance)) {
			current = current.eContainer();
		}
		return (ComponentInstance) current;
	}

	/**
	 * Return the declarative objects that define this instance. Most of the
	 * time this will return a singleton list. But in the case of semantic
	 * connections, it will return a list of connection objects.
	 *
	 * @return A List of NamedElement objects that should be declarative model
	 *         elements. Returns an empty list if no named declarative object
	 *         exists, such as in the case of {@link ModeTransitionInstance}s.
	 */
	public List<? extends NamedElement> getInstantiatedObjects() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.impl.NamedElementImpl#acceptsProperty(edu.cmu.
	 * sei.aadl.aadl2.Property)
	 */
	public boolean acceptsProperty(Property property) {
		// OsateDebug.osateDebug ("[InstanceObjectImpl] property=" + property);

		for (NamedElement ne : getInstantiatedObjects()) {
			if (!ne.acceptsProperty(property)) {
				return false;
			}
		}
		return true;
	}

	public Iterable<ConnectionInstance> allEnclosingConnectionInstances() {
		final InstanceObject target = this;
		return new Iterable<ConnectionInstance>() {

			public Iterator<ConnectionInstance> iterator() {
				return new Iterator<ConnectionInstance>() {
					ConnectionInstance next;
					ComponentInstance head = target instanceof ComponentInstance ? (ComponentInstance) target
							: target.getContainingComponentInstance();
					Iterator<ConnectionInstance> iter = head.getConnectionInstances().iterator();

					private boolean advance() {
						next = null;
						if (iter.hasNext()) {
							next = iter.next();
							return true;
						}
						while (head != null) {
							head = head.getContainingComponentInstance();
							if (head == null) {
								return false;
							} else {
								iter = head.getConnectionInstances().iterator();
								if (iter.hasNext()) {
									next = iter.next();
									return true;
								}
							}
						}
						return false;
					}

					public boolean hasNext() {
						return next != null || advance();
					}

					public ConnectionInstance next() {
						if (next == null && !advance()) {
							throw new NoSuchElementException();
						}
						ConnectionInstance result = next;
						next = null;
						return result;
					}

					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}

	public EList<ConnectionInstance> getAllEnclosingConnectionInstances() {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();

		for (ConnectionInstance conni : allEnclosingConnectionInstances()) {
			result.add(conni);
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.InstanceObject#findInstanceObjects(org.eclipse.emf.common.util.EList)
	 */
	public List<InstanceObject> findInstanceObjects(EList<ContainmentPathElement> referencePath) {
		List<InstanceObject> result = new LinkedList<InstanceObject>();

		findInstanceObjectsHelper(referencePath.listIterator(), result);
		return result;
	}

	protected boolean findInstanceObjectsHelper(ListIterator<ContainmentPathElement> pathIter,
			List<InstanceObject> ios) {
		boolean result = false;

		if (!pathIter.hasNext()) {
			ios.add(this);
			result = true;
		} else {
			ContainmentPathElement cpe = pathIter.next();
			NamedElement ne = cpe.getNamedElement();

			for (EObject eo : eContents()) {
				if (eo instanceof InstanceObjectImpl) {
					InstanceObjectImpl next = (InstanceObjectImpl) eo;
					List<? extends NamedElement> decls = next.getInstantiatedObjects();

					if (decls != null && !decls.isEmpty()) {
						NamedElement decl = decls.get(0);

						if (decl.getName() != null && decl.getName().equalsIgnoreCase(ne.getName())) {
							EList<ArrayRange> ranges = cpe.getArrayRanges();

							if (next.matchesIndex(ranges)) {
								next.findInstanceObjectsHelper(pathIter, ios);
							}
							result = true;
						}
					}
				}
			}
			pathIter.previous();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.osate.aadl2.instance.InstanceObject#matchesIndex(java.util.List)
	 */
	public boolean matchesIndex(List<ArrayRange> ranges) {
		return ranges.isEmpty();
	}
} // InstanceObjectImpl
