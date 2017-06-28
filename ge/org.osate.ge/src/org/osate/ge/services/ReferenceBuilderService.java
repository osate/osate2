/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.services;

import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.impl.ReferenceEncoder;

/**
 * Service for building references to business object. 
 * @noextend
 * @noimplement
 * @see ReferenceResolutionService
 * @see org.osate.ge.di.BuildCanonicalReference
 */
public interface ReferenceBuilderService {
	/**
	 * Returns a string that can be used with the ReferenceResolutionService to retrieve the business object. 
	 * The reference will remain consistent between application executions.
	 * @param bo the business object for which to retrieve the reference.
	 * @return the reference or null if the reference could not be created
	 * @see ReferenceResolutionService#getReferencedObject(String)
	 */
	default String getReference(Object bo) {
		final CanonicalBusinessObjectReference ref = getCanonicalReference(bo);
		if(ref != null) {
			return ReferenceEncoder.encode(ref.toSegmentArray());
		}
		
		return null;
	}
	
	CanonicalBusinessObjectReference getCanonicalReference(final Object bo);	
	RelativeBusinessObjectReference getRelativeReference(final Object bo);
}
