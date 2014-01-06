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
import java.util.Collection;
import java.util.List;

import org.osate.aadl2.instance.InstanceObject;



public class FilterMapExpr extends Expr {
	final private Expr map;
	final private String id;
	final private Expr domain;
	final private Expr filter;

	public FilterMapExpr(Expr map, String id, Expr domain, Expr filter) {
		super();
		
		if (map == null) {
			map = new IdExpr(id);
		}
		if (filter == null) {
			filter = new BoolVal(true);
		}
		
		this.map = map;
		this.id = id;
		this.domain = domain;
		this.filter = filter;
	}

	@Override
	public Val eval(Environment env) {
		List<Val> domainValues = domain.eval(env).getSet();
		List<Val> result = new ArrayList<Val>();
		for (Val v : domainValues) {
			if (filter.eval(env.add(id, v)).getBool()) {
				result.add(map.eval(env.add(id, v)));
			}
		}
		return new SetVal(result);
	}
	
	public List<InstanceObject> getRelatedComponents ()
	{
		return new ArrayList<InstanceObject>();
	}

}
