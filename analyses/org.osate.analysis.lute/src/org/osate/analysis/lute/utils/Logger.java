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

package org.osate.analysis.lute.utils;

import java.io.PrintStream;

import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.osate.analysis.lute.DialogConsole;

public class Logger {
	
	final public static int STATUS  = 0;
	final public static int ERROR   = 1;
	final public static int WARN    = 2;
	final public static int INFO    = 3;
	
	private int verbosity;
	private PrintStream out;
	private MessageConsole console;

	public Logger(int verbosity) {
		this.verbosity = verbosity;
		this.out = System.out;
	}
	
	public Logger(int verbosity, final String consoleName, final IWorkbenchWindow window) {
		this.verbosity = verbosity;
		this.console = findConsole(consoleName);
		showConsole(window, console);
		this.out = new PrintStream(console.newMessageStream());
	}
	
	public void status(String msg) {
		log(STATUS, msg);
	}
	
	public void error(String msg) {
		log(ERROR, msg);
	}
	
	public void warn(String msg) {
		log(WARN, msg);
	}

	public void info(String msg) {
		log(INFO, msg);
	}
	
	public void status(Object obj) {
		status(String.valueOf(obj));
	}
	
	public void error(Object obj) {
		error(String.valueOf(obj));
	}
	
	public void warn(Object obj) {
		warn(String.valueOf(obj));
	}

	public void info(Object obj) {
		info(String.valueOf(obj));
	}
	
	private void log(int priority, String msg) {
		if (verbosity >= priority) {
			
			
			switch (priority)
			{
				case ERROR:
				{
					msg = "*** ERROR: " + msg;
					DialogConsole.addResultMessage (msg, DialogConsole.ERROR);
					break;
				}
				
				case WARN:
				{
					msg = "  WARNING: "  + msg;
					DialogConsole.addResultMessage (msg, DialogConsole.ERROR);
					break;
				}
				
				default:
				{
					DialogConsole.addResultMessage (msg, DialogConsole.NONE);
					break;
				}
				
			}
			
			out.println(msg);
			
		}
	}
	
	// See: http://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F
	private static MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		for (IConsole console : conMan.getConsoles()) {
			if (name.equals(console.getName())) {
				return (MessageConsole) console;
			}
		}
		//no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[]{myConsole});
		return myConsole;
	}
	
	private static void showConsole(IWorkbenchWindow window, IConsole myConsole) {
		IWorkbenchPage page = window.getActivePage();
		String id = IConsoleConstants.ID_CONSOLE_VIEW;
		IConsoleView view;
		try {
			view = (IConsoleView) page.showView(id);
			view.display(myConsole);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	public void clear() {
		console.clearConsole();
		DialogConsole.clearLog ();

	}
}
