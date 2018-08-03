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
