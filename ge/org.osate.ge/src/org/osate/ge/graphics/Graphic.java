/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.graphics;

/**
 * Describes the visual representation of a business object. The graphic for a business object is provided to the graphical editor by the business object handler 
 * method with the @link {org.osate.ge.di.GetGraphic} annotation. Graphics are created by business object handlers using builder classes.
 * @noextend
 * @noimplement
 * @see RectangleBuilder
 * @see EllipseBuilder
 * @see PolygonBuilder
 * @see ConnectionBuilder
 * @see org.osate.ge.di.GetGraphic
 */
public interface Graphic {
}
