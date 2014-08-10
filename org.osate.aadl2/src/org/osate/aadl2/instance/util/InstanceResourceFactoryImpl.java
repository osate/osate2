/**
 * <copyright>
 * </copyright>
 *
 * $Id: InstanceResourceFactoryImpl.java,v 1.3 2010-05-12 20:09:22 lwrage Exp $
 */
package org.osate.aadl2.instance.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.instance.util.InstanceResourceImpl
 * @generated
 */
public class InstanceResourceFactoryImpl extends ResourceFactoryImpl {
	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource(URI uri) {
		XMLResource result = new InstanceResourceImpl(uri);
		return result;
	}

} // InstanceResourceFactoryImpl
