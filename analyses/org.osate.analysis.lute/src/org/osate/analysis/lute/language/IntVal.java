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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.util.OsateDebug;


public class IntVal extends Val {
	final private Long i;
	
	public IntVal(Long i) {
		super();
		this.i = i;
	}
	
	public IntVal(long i) {
		super();
		//OsateDebug.osateDebug("i=" + i);
		this.i = Long.valueOf(i);
	}
	
	@Override
	public Long getInt() {
		return i;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IntVal) {
			IntVal other = (IntVal) obj;
			return getInt().equals(other.getInt());
		}
		
		if (obj instanceof RealVal)
		{
			RealVal rv = (RealVal) obj;
			return rv.getReal() == (double)this.i;		
		}
		return false;
	}

	@Override
	public int hashCode() {
		return i.hashCode();
	}
	
	@Override
	public String toString() {
		return i.toString();
	}
	
	public List<InstanceObject> getRelatedComponents ()
	{
		ArrayList<InstanceObject> ret = new ArrayList<InstanceObject>();

		return ret;
	}	
}
