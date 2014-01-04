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

import java.util.List;

import org.osate.analysis.lute.LuteException;
import org.slf4j.Logger;


public class FunctionDefinition extends Command {
	final private String fn;
	final private List<String> args;
	final private Expr body;
	private Environment env;

	public FunctionDefinition(String fn, List<String> args, Expr body) {
		super();
		this.fn = fn;
		this.args = args;
		this.body = body;
	}

	@Override
	public Environment exec(Environment env, Logger log) {
		this.env = env.addFn(fn, this);
		return this.env;
	}
	
	public Val eval(List<Val> actuals) {
		if (args.size() != actuals.size()) {
			throw new LuteException("Function " + fn + " expects " +
					args.size() + " arguments, but got " + actuals.size());
		}
		
		Environment extEnv = env;
		for (int i = 0; i < args.size(); i++) {
			extEnv = extEnv.add(args.get(i), actuals.get(i));
		}
		return body.eval(extEnv);
	}
}
