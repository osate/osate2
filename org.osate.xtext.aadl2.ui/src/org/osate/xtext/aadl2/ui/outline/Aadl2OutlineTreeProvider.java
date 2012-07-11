/*
* <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE
*/
package org.osate.xtext.aadl2.ui.outline;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.core.OsateCorePlugin;

/**
 * customization of the default outline structure
 *
 */
public class Aadl2OutlineTreeProvider extends DefaultOutlineTreeProvider {

	protected void _createChildren(DocumentRootNode parentNode,	ModelUnit aadlModel) {
		if (aadlModel instanceof AadlPackage) {
			for (Element element : aadlModel.getChildren()) {
				createNode(parentNode, element);
			}
		} else {
			createNode(parentNode, aadlModel);
		}
	}

	protected void _createChildren(DocumentRootNode parentNode, SystemInstance aadlModel) {
		createNode(parentNode, aadlModel);
	}
	protected boolean _isLeaf(SystemInstance feature) {
	    return false;
	}


	protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
			.getDefault().getBundle());

	protected void _createChildren(IOutlineNode parentNode, SystemInstance sysInstance) {
		if (sysInstance.eContents().isEmpty()){
			final InstantiateModel instantiateModel =
			new InstantiateModel(new NullProgressMonitor(),
					new AnalysisErrorReporterManager(
							internalErrorLogger,
							new MarkerAnalysisErrorReporter.Factory(
									AadlConstants.INSTANTIATION_OBJECT_MARKER)));
			instantiateModel.fillSystemInstance(sysInstance);
		}
		super._createChildren(parentNode, sysInstance);
	}

	// Uncomment the next set to limit outline for package and property set to

//	// Classifier nodes are leafs and not expandable
//	protected boolean _isLeaf(Classifier feature) {
//	    return true;
//	}
//
//	// Property nodes are leafs and not expandable
//	protected boolean _isLeaf(Property feature) {
//	    return true;
//	}
//
//	// PropertyConstant nodes are leafs and not expandable
//	protected boolean _isLeaf(PropertyConstant feature) {
//	    return true;
//	}
//
//	// PropertyType nodes are leafs and not expandable
//	protected boolean _isLeaf(PropertyType feature) {
//	    return true;
//	}



}
