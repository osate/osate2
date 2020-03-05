/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba;

import org.osate.aadl2.Element;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.visitor.IBAVisitable ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An element is a constituent of a model.
 * An element is a constituent of a model. As such, it has the capability of owning other elements.
 * <!-- end-model-doc -->
 *
 *
 * @see org.osate.ba.aadlba.AadlBaPackage#getBehaviorElement()
 * @model abstract="true"
 * @generated
 */
public interface BehaviorElement extends Element
{
  public AadlBaLocationReference getAadlBaLocationReference();
} // BehaviorElement
