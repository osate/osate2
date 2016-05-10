package org.osate.assure.ui.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.jobs.ISchedulingRule;

public class AssureScheduleRule implements ISchedulingRule {

	private IFile origfile;

	public AssureScheduleRule(IFile file) {
		origfile = file;
	}

	@Override
	public boolean contains(ISchedulingRule rule) {
		System.out.println("AssureScheduleRule.contains() " + rule);
		// Just to pass check
		if (this == rule)
			return true;
		System.out.println("AssureScheduleRule.contains()  111 " + rule);
		// Only prevent changes in the same file
		if (origfile == rule)
			return true;

		System.out.println("AssureScheduleRule.contains()  222 " + rule);
		// Resource.class
		// must allow notifications to nest in all resource rules
//		if (rule.getClass().equals(WorkManager.NotifyRule.class))
//			return true;
//		if (rule instanceof MultiRule) {
//			MultiRule multi = (MultiRule) rule;
//			ISchedulingRule[] children = multi.getChildren();
//			for (int i = 0; i < children.length; i++)
//				if (!contains(children[i]))
//					return false;
//			return true;
//		}
//		if (!(rule instanceof IResource))
//			return false;
//		IResource resource = (IResource) rule;
//		if (!workspace.equals(resource.getWorkspace()))
//			return false;
//		return path.isPrefixOf(resource.getFullPath());
		return false;
	}

	@Override
	public boolean isConflicting(ISchedulingRule rule) {
		System.out.println("AssureScheduleRule.isConflicting() " + rule);
		// Just to pass check
		if (this == rule)
			return true;

		System.out.println("AssureScheduleRule.isConflicting()  111 " + rule);

		if (origfile == rule)
			return true;

		System.out.println("AssureScheduleRule.isConflicting()  222 " + rule);
		// must not schedule at same time as notification
//		if (rule.getClass().equals(WorkManager.NotifyRule.class))
//			return true;
//		if (rule instanceof MultiRule) {
//			MultiRule multi = (MultiRule) rule;
//			ISchedulingRule[] children = multi.getChildren();
//			for (int i = 0; i < children.length; i++)
//				if (isConflicting(children[i]))
//					return true;
//			return false;
//		}
//		if (!(rule instanceof IResource))
//			return false;
//		IResource resource = (IResource) rule;
//		if (!workspace.equals(resource.getWorkspace()))
//			return false;
//		IPath otherPath = resource.getFullPath();
//		return path.isPrefixOf(otherPath) || otherPath.isPrefixOf(path);

		return false;
	}

}
