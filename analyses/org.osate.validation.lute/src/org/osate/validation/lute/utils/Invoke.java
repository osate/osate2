package org.osate.validation.lute.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.osate.aadl2.instance.SystemInstance;
import org.osate.validation.Logger;
import org.osate.validation.lute.LuteInterpreter;

public class Invoke {

	
	public static void invoke (SystemInstance systemInstance, String theorem, Logger log)
	{
		
		LuteInterpreter interpreter;
		InputStream stream;
		
		interpreter = new LuteInterpreter(systemInstance, log);
		stream = new ByteArrayInputStream(theorem.getBytes());
		
		interpreter.run(stream);
	}
	
	
}
