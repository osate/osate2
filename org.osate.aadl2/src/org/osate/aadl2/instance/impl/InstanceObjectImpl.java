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
 * $Id: InstanceObjectImpl.java,v 1.20 2010-06-14 17:29:03 lwrage Exp $
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
import org.eclipse.ocl.ecore.OCL;
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
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Object</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.osate.aadl2.instance.impl.InstanceObjectImpl#getAnnexInstances <em>Annex Instance</em>}</li>
 *   <li>{@link org.osate.aadl2.instance.impl.InstanceObjectImpl#getOwnedPropertyAssociations <em>Owned Property Association</em>}</li>
 * </ul>
 * </p>
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
	@Override
	protected EClass eStaticClass() {
		return InstancePackage.Literals.INSTANCE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
	public PropertyAssociation createOwnedPropertyAssociation() {
		PropertyAssociationInstance newOwnedPropertyAssociation = (PropertyAssociationInstance) create(InstancePackage.Literals.PROPERTY_ASSOCIATION_INSTANCE);
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	 * The cached environment for evaluating OCL expressions.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final OCL EOCL_ENV = OCL.newInstance();

	/**
	 * Get the closest component instance that contains this object.
	 * If the object is a component instance, get its enclosing instance
	 * @return Closest containing component instance
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
	public String getComponentInstancePath() {
		if (this instanceof SystemInstance) {
			return "";
		}
		final String path = ((InstanceObject) eContainer).getComponentInstancePath();
		final String localname = getFullName();

		return path.length() == 0 ? localname : path + "." + localname;
	}

	@Override
	public final void getPropertyValueInternal(final Property property, final PropertyAcc pas,
			final boolean fromInstanceSlaveCall) throws InvalidModelException {
		/*
		 * First see if the property is defined locally in the instance. Such
		 * local property associations arise from component property
		 * associations in the declarative spec, from explicit programmatic
		 * setting of the property, or as cached results from earlier property
		 * lookups.
		 */
		if (pas.addLocal(this)) {
			return;
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
				ph.getPropertyValueInternal(property, pas, false);
			}
		}
	}

	/**
	 * Returns the System Operation Modes in which the element exists, or
	 * <code>null</code> if the element always exists.
	 *
	 * @return
	 */
	@Override
	public List<SystemOperationMode> getExistsInModes() {
		return null;
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
	@Override
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
	@Override
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
	@Override
	public boolean acceptsProperty(Property property) {
		// OsateDebug.osateDebug ("[InstanceObjectImpl] property=" + property);

		for (NamedElement ne : getInstantiatedObjects()) {
			if (!ne.acceptsProperty(property)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Iterable<ConnectionInstance> allEnclosingConnectionInstances() {
		final InstanceObject target = this;
		return new Iterable<ConnectionInstance>() {

			@Override
			public Iterator<ConnectionInstance> iterator() {
				return new Iterator<ConnectionInstance>() {
					ConnectionInstance next;
					ComponentInstance head = target instanceof ComponentInstance ? (ComponentInstance) target : target
							.getContainingComponentInstance();
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

					@Override
					public boolean hasNext() {
						return next != null || advance();
					}

					@Override
					public ConnectionInstance next() {
						if (next == null && !advance()) {
							throw new NoSuchElementException();
						}
						ConnectionInstance result = next;
						next = null;
						return result;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}

		};
	}

	@Override
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
	@Override
	public List<InstanceObject> findInstanceObjects(EList<ContainmentPathElement> referencePath) {
		List<InstanceObject> result = new LinkedList<InstanceObject>();

		findInstanceObjectsHelper(referencePath.listIterator(), result);
		return result;
	}

	protected boolean findInstanceObjectsHelper(ListIterator<ContainmentPathElement> pathIter, List<InstanceObject> ios) {
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

					if (next.getName().equalsIgnoreCase(ne.getName())) {
						EList<ArrayRange> ranges = cpe.getArrayRanges();

						if (next.matchesIndex(ranges)) {
							next.findInstanceObjectsHelper(pathIter, ios);
						}
						result = true;
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
	@Override
	public boolean matchesIndex(List<ArrayRange> ranges) {
		return ranges.isEmpty();
	}
} // InstanceObjectImpl
