/*
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

package org.osate.analysis.lute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;


public class CustomLuteAction extends LuteAction {
	@Override
	public InputStream getLuteInput() {
		String filename = promptFile(getShell(), "*.lute");
		if (filename == null) {
			return null;
		}

		try {
			return new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			luteLogger.error("Lute file not found: " + filename);
			e.printStackTrace(System.err);
			return null;
		}
		
	}
	
	public static String promptFile(final Shell shell, final String extension) {
		// Need to use array so that the inner class can assign it
		final String[] result = { null };
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				final FileDialog fd = new FileDialog(shell);
				fd.setFilterExtensions(new String[]{extension});
				result[0] = fd.open();
			}
		});
		return result[0];
	}
}
