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
import java.util.Collection;
import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.analysis.lute.LuteException;

public abstract class Val extends Expr {
	public Val eval(Environment env) {
		return this;
	}
	
	public boolean getBool() {
		throw new LuteException("Expected boolean value");
	}
	
	public String getString() {
		throw new LuteException("Expected string value");
	}
	
	public Long getInt() {
		throw new LuteException("Expected integer value");
	}
	
	public List<Val> getSet() {
		throw new LuteException("Expected set value");
	} 
	
	public NamedElement getAADL() {
		throw new LuteException("Expected AADL object value");
	}
	
	public RangeVal getRange() {
		throw new LuteException("Expected range value");
	}
	
	public Double getReal() {
		throw new LuteException( "Expected real value" );
	}
	
	@Override
	public boolean equals(Object obj) {
		throw new LuteException("Equality not defined on this value");
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
}
