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

package org.osate.validation.lute;

import java.io.InputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.validation.AadlAction;
import org.osate.validation.Logger;


public abstract class LuteAction extends AadlAction {
	protected Logger log;
	
	@Override
	public IStatus runJob(Element sel, IProgressMonitor monitor, Logger log) {
		log.info("");

		if (!(sel instanceof SystemImplementation)) 
		{
			log.error("Must select a system implementation");
			return Status.CANCEL_STATUS;
		}
		
		final SystemImplementation sysimpl = (SystemImplementation) sel;

		monitor.beginTask("Running Lute", IProgressMonitor.UNKNOWN);
		InstantiateModel im = new InstantiateModel(new NullProgressMonitor(), getErrorManager());
		URI uri = OsateResourceUtil.getInstanceModelURI(sysimpl);
		Resource resource = OsateResourceUtil.getEmptyAaxl2Resource(uri);
		
		try
		{
			SystemInstance si = im.createSystemInstance(sysimpl, resource);
			LuteInterpreter interpreter = new LuteInterpreter(si, log);
			InputStream stream = getLuteInput();
			if (stream == null) return Status.CANCEL_STATUS;
			interpreter.run(stream);
			return Status.OK_STATUS;
		}
		catch (Exception e)
		{
			Dialog.showError("Model Instantiate", "Error while re-instantiating the model: " + e.getMessage());
			return Status.CANCEL_STATUS;
		}
		

	}
	
	abstract public InputStream getLuteInput();
}
