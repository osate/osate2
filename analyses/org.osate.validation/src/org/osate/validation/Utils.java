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

package org.osate.validation;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Property;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class Utils {
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

	public static <T, S extends T> Collection<S> filterSubclass(Collection<T> original, Class<S> klass) {
		Collection<S> subcollection = new LinkedList<S>();
		for (T e : original) {
			if (klass.isInstance(e)) {
				subcollection.add(klass.cast(e));
			}
		}
		return subcollection;
	}
	
	final public static String CONTRACT_NAME = "PSL_Properties::Contract";
	final public static String FACTS_NAME = "PSL_Properties::Facts";
	
	final public static Property CONTRACT = EMFIndexRetrieval.getPropertyDefinitionInWorkspace(CONTRACT_NAME);
	final public static Property FACTS = EMFIndexRetrieval.getPropertyDefinitionInWorkspace(FACTS_NAME);
}
