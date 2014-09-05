package org.osate.ge.ui.util;

import java.util.List;

import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.ArraySizeProperty;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;

/**
 * Helper class for working with ArrayDimension objects
 * @author philip.alldredge
 *
 */
public class SimplifiedDimensionSize {
	private Long dimSize = null;
	private String dimSizeString;
	
	public SimplifiedDimensionSize(final ArrayDimension dim) {
		final ArraySize size = dim.getSize();
		
		if(size == null) {
			dimSizeString = "";
		} else {
			final ArraySizeProperty sizeProp = size.getSizeProperty();
			if(sizeProp == null) {
				dimSize = size.getSize();
			} else {
				if(sizeProp instanceof PropertyConstant) {
					final PropertyExpression pe = ((PropertyConstant) sizeProp).getConstantValue();
					if(pe instanceof IntegerLiteral) {
						dimSize = ((IntegerLiteral) pe).getValue();
					} else {
						dimSizeString = ((PropertyConstant) sizeProp).getQualifiedName();
					}
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
	
	public final Long getSize() {
		return dimSize;
	}
	
	public final String getSizeString() {
		return dimSizeString;
	}
	
	/**
	 * Returns a string suitable for display to the user containing the array dimensions
	 * @param dimensions
	 * @return
	 */
	public static final String toUserString(List<ArrayDimension> dimensions) {
		String retVal = "";
		for(final ArrayDimension dim : dimensions) {
			final SimplifiedDimensionSize size = new SimplifiedDimensionSize(dim);
			retVal += "[" + size.getSizeString() + "]";
		}
		
		return retVal;
	}
}