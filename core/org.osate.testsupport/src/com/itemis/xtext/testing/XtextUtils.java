package com.itemis.xtext.testing;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Issue;

/**
 * <p>
 * Utilities for Xtext supporting the IssueCollection
 * </p>
 *
 * @author Karsten Thoms
 * @author Lars Corneliussen
 * @author Vlad Dumitrescu
 *
 */
public class XtextUtils {

	/**
	 * Returns the ancestor of type ancestorClass of the ctx element
	 */
	public static <C extends EObject> C ancestor(final EObject ctx, final Class<C> ancestorClass) {
		return EcoreUtil2.getContainerOfType(ctx, ancestorClass);
	}

	/**
	 * like above, but using the EClass instead of the Java class object
	 */
	public static EObject ancestor(final EObject ctx, final EClass ancClass) {
		EObject anc = ctx.eContainer();
		while (true) {
			if (anc == null) {
				return null;
			}
			if (ancClass.isInstance(anc)) {
				return anc;
			}
			anc = anc.eContainer();
		}
	}

	public static List<EObject> ancestors(final EObject ctx, final EClass ancClass) {
		final List<EObject> res = new ArrayList<EObject>();
		EObject anc = ctx.eContainer();
		while (true) {
			if (anc == null) {
				return res;
			}
			if (ancClass.isInstance(anc)) {
				res.add(anc);
			}
			anc = anc.eContainer();
		}
	}

	/**
	 * compares two objects and takes into account nulls
	 */
	public static boolean nullTolerantEquals(final Object o1, final Object o2) {
		if (o1 == null) {
			if (o2 == null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (o2 == null) {
				return false;
			} else {
				return o1.equals(o2);
			}
		}
	}

	/**
	 * uses reflection to return the value of the name attribute if it exists,
	 * null otherwise
	 */
	public static String name(final EObject object) {
		final EStructuralFeature namefeature = object.eClass().getEStructuralFeature("name");
		if (namefeature == null) {
			return null;
		} else {
			return (String) object.eGet(namefeature);
		}
	}

	/**
	 * outputs a more or less useful string representation for an EObject
	 */
	public static String eString(final EObject eObject) {
		if (eObject instanceof EClass) {
			return ((EClass) eObject).getName();
		} else {
			String res;
			final String name = name(eObject);
			if (name != null) {
				res = eObject.eClass().getName() + "/" + name;
			} else {
				res = eObject.eClass().getName();
			}
			if (eObject.eIsProxy()) {
				res += "[proxy]";
			}
			return res;
		}
	}

	public static Object eget(final EObject eObject, final String featureName) {
		final Object val = eObject.eGet(eObject.eClass().getEStructuralFeature(featureName));
		return val;
	}

	public static EObject egetAndResolve(final EObject eObject, final String featureName, final ResourceSet rs) {
		final EObject val = (EObject) eget(eObject, featureName);
		return resolveProxy(val, rs);
	}

	public static EObject getEObject(final Issue issue, final Resource r) {
		final URI uri = issue.getUriToProblem();
		final EObject eObject = r.getEObject(uri.fragment());
		return eObject;
	}

	public static EObject resolveProxy(EObject eObject, final ResourceSet rs) {
		if (eObject.eIsProxy()) {
			eObject = EcoreUtil.resolve(eObject, rs);
		}
		return eObject;
	}

}
