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
package org.osate.ge.internal.util;

import java.util.List;

import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.ArraySizeProperty;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.RefinableElement;

public class AadlArrayUtil {
	public static String getDimensionUserString(final ArrayableElement ae) {
		ArrayableElement tmpEl = ae;
		List<ArrayDimension> dims;
		// Get the first element that has dimensions defined
		do {
			dims = tmpEl.getArrayDimensions();
			final RefinableElement re = tmpEl instanceof RefinableElement ? ((RefinableElement) tmpEl).getRefinedElement() : null;
			tmpEl = re instanceof ArrayableElement ? (ArrayableElement)re : null;
		} while(tmpEl != null && dims.size() == 0);
		
		return SimplifiedDimensionSize.toUserString(dims);
	}
	
	/**
	 * Helper class for working with ArrayDimension objects
	 *
	 */
	private static class SimplifiedDimensionSize {
		private String dimSizeString;
		
		public SimplifiedDimensionSize(final ArrayDimension dim) {
			final ArraySize size = dim.getSize();
			Long dimSize = null;
			
			if(size == null) {
				dimSizeString = "";
			} else {
				final ArraySizeProperty sizeProp = size.getSizeProperty();
				
				if(sizeProp == null) {
					dimSize = size.getSize();
				} else {
					if(sizeProp instanceof PropertyConstant) {
						dimSizeString = ((PropertyConstant) sizeProp).getQualifiedName();
					} else if(sizeProp instanceof Property) {
						dimSizeString = ((Property) sizeProp).getQualifiedName();
					} else {
						dimSizeString = "?";
					}
				}				
			}
						
			// Store a string version of the long
			if(dimSize != null) {
				dimSizeString = Long.toString(dimSize);
			}
		}
		
		public final String getSizeString() {
			return dimSizeString;
		}
		
		/**
		 * Returns a string suitable for display to the user containing the array dimensions
		 * @param dimensions
		 * @return
		 */
		private static final String toUserString(List<ArrayDimension> dimensions) {
			String retVal = "";
			for(final ArrayDimension dim : dimensions) {
				final SimplifiedDimensionSize size = new SimplifiedDimensionSize(dim);
				retVal += "[" + size.getSizeString() + "]";
			}
			
			return retVal;
		}
	}
}
