/*
Copyright (c) 2011, Rockwell Collins.
Developed with the sponsorship of the Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Data.

THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
*/
package org.osate.analysis.lute.language;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.InstanceObject;

public class RealVal extends Val {
	
	private final Double value;
	
	public RealVal( Double p_value ) {
		super();
		
		value = p_value;
	}
	
	public RealVal(double  p_value ) {
		super();

		value = Double.valueOf( p_value );
	}
	
	@Override
	public Double getReal() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RealVal) {
			RealVal other = (RealVal) obj;
			
			return getReal().equals( other.getReal() );
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public List<InstanceObject> getRelatedComponents() {
		// TODO Auto-generated method stub
		return new ArrayList<InstanceObject>();
	}
}
