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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.impl.NamedElementImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyAcc;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Object</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class InstanceObjectImpl extends NamedElementImpl implements InstanceObject {
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
	 * Get the closest component instance that contains this object.
	 * 
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
		final String localname = getName();

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
		final String path = ((InstanceObject) eContainer).getInstanceObjectPath();
		final String localname = getName();

		return path.length() == 0 ? localname : path + "." + localname;
	}

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
		//apv.pushCurrentComponent(getContainingComponentInstanceOrSelf());
		try {
			final List<? extends NamedElement> compDecls = getInstantiatedObjects();
			// Here we assume compDecls is empty or has only one element
			if (!compDecls.isEmpty()) {
				final NamedElement compDecl = compDecls.get(0);
				if (compDecl == null)
					return;
				compDecl.getPropertyValueInternal(property, pas, true);
			}
		} finally {
			//apv.popCurrentComponent();
		}
	}

	/**
	 * get the containing component instance of an instance object, or itself if
	 * this is a component instance
	 * 
	 * @return containing component instance
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
	protected ComponentInstance getContainingComponentInstanceOrSelf() {
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
	// XXX: [AADL 1 -> AADL 2] Added to make property lookup work.
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
		return true;
	}

} // InstanceObjectImpl
