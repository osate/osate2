package org.osate.xtext.aadl2.scoping;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.scoping.EClassGlobalScopeProvider;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * This class is simply here for convenience.
 *
 * @deprecated Will be removed in 2.3.5
 */
@Deprecated
public class Aadl2GlobalScopeProvider extends EClassGlobalScopeProvider {
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	/**
	 * @deprecated Will be removed in 2.3.5
	 */
	@Deprecated
	public boolean hasDuplicates(final NamedElement target) {
		Resource context = target.eResource();
		if (context == null || context.getResourceSet() == null) {
			return false;
		}
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context));
		Collections.reverse(containers);
		Iterator<IContainer> iter = containers.iterator();
		QualifiedName qn = qualifiedNameConverter.toQualifiedName(target.getName());
		boolean foundOne = false;
		while (iter.hasNext()) {
			IContainer container = iter.next();
			Iterable<IEObjectDescription> res = container.getExportedObjects(target.eClass(), qn, true);
			Iterator<IEObjectDescription> it = res.iterator();
			if (it.hasNext()) {
				if (foundOne) {
					return true;
				}
				foundOne = true;
				it.next();
				if (it.hasNext()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @deprecated Will be removed in 2.3.5
	 */
	@Deprecated
	public List<IEObjectDescription> getDuplicates(final NamedElement target) {
		if (target.getName() == null || target.getName().isEmpty()) {
			return Collections.emptyList();
		}
		Resource context = target.eResource();
		if (context == null || context.getResourceSet() == null) {
			return Collections.emptyList();
		}
		List<IContainer> containers = Lists.newArrayList(getVisibleContainers(context));
		QualifiedName qn = qualifiedNameConverter.toQualifiedName(target.getName());
		boolean foundOne = false;
		List<IEObjectDescription> ielist = new Stack<IEObjectDescription>();
		for (IContainer container : containers) {
			Iterable<IEObjectDescription> res = container.getExportedObjects(target.eClass(), qn, true);
			for (IEObjectDescription ieObjectDescription : res) {
				if (foundOne) {
					ielist.add(ieObjectDescription);
				}
				foundOne = true;
			}
		}
		return ielist;
	}

}