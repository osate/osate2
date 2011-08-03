/*
 * <copyright>
 * Copyright  2006 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.eclipse.ui.views.navigator.ResourceNavigator;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.ui.navigator.AadlElementImageDescriptor.ModificationFlag;


public class AadlNavigator extends ResourceNavigator implements IResourceChangeListener
{
	private String lastResourceName = "";
	private ModificationFlag lastDecorator = null;
	
	public void createPartControl(Composite parent)
	{
		super.createPartControl(parent);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}

	public void dispose()
	{
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
		super.dispose();
	}
	
	protected void initContentProvider(TreeViewer viewer)
	{
		viewer.setContentProvider(new AadlNavigatorContentProvider());
	}
	
	protected void initLabelProvider(TreeViewer viewer)
	{
		viewer.setLabelProvider(new AadlNavigatorLabelProvider(
				new WorkbenchLabelProvider(), getPlugin().getWorkbench().getDecoratorManager().getLabelDecorator()));
	}
	
	protected void initResourceComparator()
	{
		super.initResourceComparator();
		setComparator(
				new ResourceComparator(getComparator().getCriteria())
				{
					public int compare(Viewer viewer, Object o1, Object o2)
					{
						if (o1 instanceof IProject && ((IProject)o1).getName().equals(OsateResourceManager.PLUGIN_RESOURCES_DIRECTORY_NAME))
							return 1;
						else if (o2 instanceof IProject &&
								((IProject)o2).getName().equals(OsateResourceManager.PLUGIN_RESOURCES_DIRECTORY_NAME))
						{
							return -1;
						}
						else
							return super.compare(viewer, o1, o2);
					}
				});
	}
	
	protected void initFilters(TreeViewer viewer)
	{
		super.initFilters(viewer);
		viewer.addFilter(
				new ViewerFilter()
				{
					public boolean select(Viewer viewer, Object parentElement, Object element)
					{
						if (element instanceof IResource)
						{
							IResource elementAsIResource = (IResource)element;
							return !elementAsIResource.getName().startsWith(".") ;
						}
						else
							return true;
					}
				});
	}
	
	protected void makeActions()
	{
		setActionGroup(new AadlNavigatorActionGroup(this));
	}
	
	private boolean hasChangedDelta(IResourceDelta delta)
	{
		IResourceDelta[] children = delta.getAffectedChildren();
		
		if (hasChanged(delta))
			return true;
		for (int i = 0; i < children.length; i++)
			if (hasChangedDelta(children[i]))
				return true;
		return false;
	}
	
	private boolean hasChanged(IResourceDelta delta)
	{
		if ((delta.getKind() & IResourceDelta.REMOVED) != 0 || (delta.getKind() & IResourceDelta.REPLACED) != 0)
			return true;
		if ((delta.getKind() & IResourceDelta.CHANGED) != 0)
		{
			IResource res = delta.getResource();
			if (res instanceof IFile)
			{
				ModificationFlag mod = AadlNavigatorLabelProvider.getModification(res);
				if (res.getName().equals(lastResourceName))
					if (mod.equals(lastDecorator))
						return false;
				lastResourceName = res.getName();
				lastDecorator = mod;
			}
			else
				return false;
		}
		return true;
	}
	
	public void resourceChanged(IResourceChangeEvent event)
	{
		processDelta(event.getDelta());
		final Control ctrl = getTreeViewer().getControl();
		if (ctrl != null && !ctrl.isDisposed())
		{
			IResourceDelta delta = event.getDelta();
			if (delta != null)
			{
				if (!hasChangedDelta(event.getDelta()))
					return;
			}
			else if (event.getResource() != null)
			{
				IResource res = event.getResource();
				ModificationFlag mod = AadlNavigatorLabelProvider.getModification(res);
				if (res.getName().equals(lastResourceName))
					if (mod.equals(lastDecorator))
						return;
				lastResourceName = res.getName();
				lastDecorator = mod;
			}
			
			ctrl.getDisplay().asyncExec(
					new Runnable()
					{
						public void run()
						{
							if (!ctrl.isDisposed())
								getTreeViewer().refresh();
						}
					});
		}
	}
	
	private void processDelta(IResourceDelta delta)
	{
		if (delta != null)
		{
			IResourceDelta[] children = delta.getAffectedChildren();
			
			for (int i = 0; i < children.length; i++)
				processDelta(children[i]);
			processChanged(delta);
		}
	}
	
	private void processChanged(IResourceDelta delta)
	{
		if ((delta.getKind() & IResourceDelta.ADDED) != 0 && (delta.getFlags() & IResourceDelta.MOVED_FROM) != 0)
		{
			IResource added = delta.getResource();
			IPath moved = delta.getMovedFromPath();
			if (added instanceof IFile)
			{
			}
			else if (added instanceof IFolder)
			{
			}
		}
	}
}