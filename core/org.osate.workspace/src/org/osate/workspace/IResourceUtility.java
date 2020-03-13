/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.workspace;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;

/**
 * @deprecated Will be removed in 2.7.
 */
@Deprecated
public class IResourceUtility {

	/**
	 * the qualified name for tagging an aaxl file as invalid due to syntax
	 * errors in text file
	 */
	public static final QualifiedName ResourceWithSyntaxErrors = new QualifiedName("org.osate.ResourceWithSyntaxErrors",
			"BadAadlFile");
	public static final QualifiedName ResourceDerived = new QualifiedName("org.osate.ResourceDerived",
			"IResourceDerived");
	public static final QualifiedName IsInstanceModel = new QualifiedName("org.osate.IsInstanceModel",
			"IsInstanceModel");

	/**
	 * tag the IResource of the model is tagged with syntax errors i.e., its
	 * corresponding aadl text file has syntax errors It is also touched to make
	 * sure it has a newer date than the text.
	 *
	 * @param modelfile IResource of aaxl model
	 */
	public static void tagModelWithSyntaxErrors(IResource modelfile) {
		if (modelfile != null && modelfile.exists()) {
			try {
				modelfile.setPersistentProperty(ResourceWithSyntaxErrors, "true");
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	/**
	 * untag the IResource of the model is tagged with syntax errors i.e., its
	 * corresponding aadl text file has syntax errors
	 *
	 * @param modelfile IResource of aaxl model
	 */
	public static void untagModelWithSyntaxErrors(IResource modelfile) {
		if (modelfile != null && modelfile.exists()) {
			try {
				modelfile.setPersistentProperty(ResourceWithSyntaxErrors, null);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	/**
	 * check whether the model IResource is tagged with syntax errors i.e., its
	 * corresponding aadl text file has syntax errors
	 *
	 * @param modelfile aaxl file
	 * @return true if it is tagged as its aadl text equivalent having syntax
	 *         errors; false if no syntax error or the IResource does not exist
	 */
	public static boolean isModelTaggedWithSyntaxErrors(IResource modelfile) {
		if (modelfile != null && modelfile.exists()) {
			try {
				return modelfile.getPersistentProperty(ResourceWithSyntaxErrors) != null;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
		return false;
	}

	/**
	 * check whether the ires IResource is tagged with syntax errors i.e., its
	 * corresponding aadl text file has syntax errors
	 *
	 * @param ires project, folder, or IResource
	 * @return true if it contains a IResource that is tagged as its aadl text
	 *         equivalent having syntax errors
	 */
	public static boolean containsModelTaggedWithSyntaxErrors(IResource ires) {
		if (ires != null && ires.exists()) {
			if (ires instanceof IFile) {
				try {
					if (ires.getPersistentProperty(ResourceWithSyntaxErrors) != null) {
						return true;
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
				}
			} else if (ires instanceof IContainer) {
				try {
					IResource[] reslist = ((IContainer) ires).members();
					for (int i = 0; i < reslist.length; i++) {
						if (containsModelTaggedWithSyntaxErrors(reslist[i])) {
							return true;
						}
					}
				} catch (CoreException e) {
					// TODO Auto-generated catch block
				}
			}
		}
		return false;
	}

	/**
	 * tag the IResource of the model is tagged with syntax errors i.e., its
	 * corresponding aadl text file has syntax errors It is also touched to make
	 * sure it has a newer date than the text.
	 *
	 * @param modelfile IResource of aaxl model
	 */
	public static void tagAsInstanceModel(IResource modelfile) {
		if (modelfile != null && modelfile.exists()) {
			try {
				modelfile.setPersistentProperty(IsInstanceModel, "true");
				modelfile.setDerived(true);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
	}

	public static boolean isAadlFile(IResource file) {
		if (file instanceof IFile) {
			String ext = file.getFileExtension();
			return ext != null
					&& (ext.equals(WorkspacePlugin.SOURCE_FILE_EXT));
		} else {
			return false;
		}
	}

	/**
	 * is file with aaxl extension, i.e., both decl models and instance models
	 *
	 * @param file
	 * @return true if extension is aaxl
	 */
	public static boolean isAaxlFile(IResource file) {
		if (file instanceof IFile) {
			String ext = file.getFileExtension();
			return ext != null && (ext.equals(WorkspacePlugin.MODEL_FILE_EXT));
		} else {
			return false;
		}
	}

	/**
	 * is file an AADL diagram file
	 */
	public static boolean isDiagramFile(IResource file) {
		if (file instanceof IFile) {
			String ext = file.getFileExtension();
			return ext != null && (ext.equals("aaxldi"));
		} else {
			return false;
		}
	}

	/**
	 * is file an AADL instance model
	 */
	public static boolean isInstanceFile(IResource file) {
		if (file instanceof IFile) {
			return (file.getName()
					.endsWith(WorkspacePlugin.INSTANCE_MODEL_POSTFIX + "." + WorkspacePlugin.MODEL_FILE_EXT)
					|| file.getName().endsWith(WorkspacePlugin.INSTANCE_FILE_EXT));
		}
		if (file != null && file.exists()) {
			try {
				return file.getPersistentProperty(IsInstanceModel) != null;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
		return false;
	}

	/**
	 * is file an AADL object model (aaxl file with declarative AADL model)
	 */
	public static boolean isModelFile(IResource file) {
		return isAaxlFile(file) && !isInstanceFile(file);
	}

	/**
	 * check whether the model IResource is tagged as derived
	 *
	 * @param modelfile aaxl file
	 * @return true if it is tagged as derived; false if not derived or the
	 *         IResource does not exist
	 */
	public static boolean isGenerated(IResource modelfile) {
		if (modelfile != null && modelfile.exists()) {
			try {
				return modelfile.getPersistentProperty(ResourceDerived) != null;
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
		return false;
	}

	/**
	 * set the IResource of the model as derived True/False
	 *
	 * @param modelfile IResource of aaxl model
	 */
	public static void setGenerated(IResource modelfile, boolean value) {
		if (modelfile != null && modelfile.exists()) {
			try {
				if (value) {
					modelfile.setPersistentProperty(ResourceDerived, "true");
				} else {
					modelfile.setPersistentProperty(ResourceDerived, null);
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
			}
		}
	}

}
