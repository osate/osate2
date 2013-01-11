/*
Copyright (c) 2011, Rockwell Collins.
Developed with the sponsorship of the Defense Advanced Research Projects Agency (DARPA).

Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
including any software or models in source or binary form, as well as any drawings, specifications, 
and documentation (collectively "the Data"), to deal in the Data without restriction, 
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
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

package org.osate.validation.lute;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.validation.Logger;


public class LuteInterpreter {
	final private SystemInstance top;
	final private Logger log;

	public LuteInterpreter(SystemInstance top, Logger log) {
		super();
		this.log = log;
		this.top = top;
	}

	public void run(List<Command> program) {
		Environment env = createInitialEnvironment();
		for (Command cmd : program) {
			try {
				env = cmd.exec(env, log);
			}
			catch (NullPointerException npe)
			{
				log.error("Command failed: " + npe.getMessage());
				//npe.printStackTrace();	
			}
			catch (LuteException e) 
			{
				log.error("Command failed: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public void run(InputStream input) {
		run(parseStream(input));
	}

	private Environment createInitialEnvironment() {
		Environment env = new EmptyEnv();
		List<ComponentInstance> components = top.getAllComponentInstances();
		
		env = env.add("System_Set",
				filterComponents(components, ComponentCategory.SYSTEM));
		env = env.add("Data_Set",
				filterComponents(components, ComponentCategory.DATA));
		env = env.add("Thread_Set",
				filterComponents(components, ComponentCategory.THREAD));
		env = env.add("Process_Set", 
				filterComponents(components, ComponentCategory.PROCESS));
		env = env.add("Memory_Set", 
				filterComponents(components, ComponentCategory.MEMORY));
		env = env.add("Processor_Set", 
				filterComponents(components, ComponentCategory.PROCESSOR));
		env = env.add("Bus_Set", 
				filterComponents(components, ComponentCategory.BUS));
		env = env.add("Virtual_Processor_Set", 
				filterComponents(components, ComponentCategory.VIRTUAL_PROCESSOR));
		env = env.add("Virtual_Bus_Set", 
				filterComponents(components, ComponentCategory.VIRTUAL_BUS));
		env = env.add("Device_Set", 
				filterComponents(components, ComponentCategory.DEVICE));
		List<Val> conns = new ArrayList<Val>();
		for (ConnectionInstance ci : top.getAllConnectionInstances()) {
			conns.add(new AADLVal(ci));
		}
		env = env.add("Connection_Set", new SetVal(conns));
		
		return env;
	}

	private SetVal filterComponents(List<ComponentInstance> components, 
			ComponentCategory category) {
		Collection<Val> result = new ArrayList<Val>();
		for (ComponentInstance ci : components) {
			if (ci.getCategory() == category) {
				result.add(new AADLVal(ci));
			}
		}
		return new SetVal(result);
	}

	private List<Command> parseStream(InputStream stream) {
		try {
			CharStream charStream = new ANTLRInputStream(stream);
			LuteLexer lexer = new LuteLexer(charStream, log);
			TokenStream tokenStream = new CommonTokenStream(lexer);
			LuteParser parser = new LuteParser(tokenStream, log);
			return parser.rule();
		} catch (IOException e) {
			log.error("Unable to read lute program: " + e.getMessage());
			e.printStackTrace();
		} catch (RecognitionException e) {
			log.error("Unable to parse lute program: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
}
