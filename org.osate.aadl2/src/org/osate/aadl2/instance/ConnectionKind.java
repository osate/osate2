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
 *
 * $Id: ConnectionKind.java,v 1.3 2010-05-07 20:01:28 lwrage Exp $
 */
package org.osate.aadl2.instance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Connection Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.osate.aadl2.instance.InstancePackage#getConnectionKind()
 * @model
 * @generated
 */
public enum ConnectionKind implements Enumerator {
	/**
	 * The '<em><b>Feature Connection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FEATURE_CONNECTION_VALUE
	 * @generated
	 * @ordered
	 */
	FEATURE_CONNECTION(0, "featureConnection", "featureConnection"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Access Connection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESS_CONNECTION_VALUE
	 * @generated
	 * @ordered
	 */
	ACCESS_CONNECTION(1, "accessConnection", "accessConnection"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Parameter Connection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARAMETER_CONNECTION_VALUE
	 * @generated
	 * @ordered
	 */
	PARAMETER_CONNECTION(2, "parameterConnection", "parameterConnection"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Port Connection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PORT_CONNECTION_VALUE
	 * @generated
	 * @ordered
	 */
	PORT_CONNECTION(3, "portConnection", "portConnection"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Mode Transition Connection</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODE_TRANSITION_CONNECTION_VALUE
	 * @generated
	 * @ordered
	 */
	MODE_TRANSITION_CONNECTION(4, "modeTransitionConnection", "modeTransitionConnection"), /**
																							* The '<em><b>Feature Group Connection</b></em>' literal object.
																							* <!-- begin-user-doc -->
																							 * <!-- end-user-doc -->
																							* @see #FEATURE_GROUP_CONNECTION_VALUE
																							* @generated
																							* @ordered
																							*/
	FEATURE_GROUP_CONNECTION(5, "featureGroupConnection", "featureGroupConnection"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Feature Connection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Feature Connection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEATURE_CONNECTION
	 * @model name="featureConnection"
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_CONNECTION_VALUE = 0;

	/**
	 * The '<em><b>Access Connection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Access Connection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCESS_CONNECTION
	 * @model name="accessConnection"
	 * @generated
	 * @ordered
	 */
	public static final int ACCESS_CONNECTION_VALUE = 1;

	/**
	 * The '<em><b>Parameter Connection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Parameter Connection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARAMETER_CONNECTION
	 * @model name="parameterConnection"
	 * @generated
	 * @ordered
	 */
	public static final int PARAMETER_CONNECTION_VALUE = 2;

	/**
	 * The '<em><b>Port Connection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Port Connection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PORT_CONNECTION
	 * @model name="portConnection"
	 * @generated
	 * @ordered
	 */
	public static final int PORT_CONNECTION_VALUE = 3;

	/**
	 * The '<em><b>Mode Transition Connection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mode Transition Connection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODE_TRANSITION_CONNECTION
	 * @model name="modeTransitionConnection"
	 * @generated
	 * @ordered
	 */
	public static final int MODE_TRANSITION_CONNECTION_VALUE = 4;

	/**
	 * The '<em><b>Feature Group Connection</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Feature Group Connection</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FEATURE_GROUP_CONNECTION
	 * @model name="featureGroupConnection"
	 * @generated
	 * @ordered
	 */
	public static final int FEATURE_GROUP_CONNECTION_VALUE = 5;

	/**
	 * An array of all the '<em><b>Connection Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ConnectionKind[] VALUES_ARRAY = new ConnectionKind[] { FEATURE_CONNECTION, ACCESS_CONNECTION,
			PARAMETER_CONNECTION, PORT_CONNECTION, MODE_TRANSITION_CONNECTION, FEATURE_GROUP_CONNECTION, };

	/**
	 * A public read-only list of all the '<em><b>Connection Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ConnectionKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Connection Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ConnectionKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Connection Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ConnectionKind get(int value) {
		switch (value) {
		case FEATURE_CONNECTION_VALUE:
			return FEATURE_CONNECTION;
		case ACCESS_CONNECTION_VALUE:
			return ACCESS_CONNECTION;
		case PARAMETER_CONNECTION_VALUE:
			return PARAMETER_CONNECTION;
		case PORT_CONNECTION_VALUE:
			return PORT_CONNECTION;
		case MODE_TRANSITION_CONNECTION_VALUE:
			return MODE_TRANSITION_CONNECTION;
		case FEATURE_GROUP_CONNECTION_VALUE:
			return FEATURE_GROUP_CONNECTION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ConnectionKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // ConnectionKind
