package org.osate.asap.view;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

/**
 * Utility methods used in > 1 classes go here.
 * @author sprocter
 *
 */
public class AsapUtil {

	/**
	 * Get the root error type associated with the given type. We walk up the
	 * type's hierarchy until we're at the top, then return that.
	 * TODO: Arguably this should be in EMV2Util
	 *
	 * @param err The type to get the root type from
	 * @return The root type (which may be the 'err' parameter, if it has no supertype)
	 */
	public static ErrorType getRootType(ErrorType err) {
		ErrorType ret = err;
		while (ret.getSuperType() != null) {
			ret = ret.getSuperType();
		}
		return ret;
	}

	/**
	 * Gets the target of the user's selection and tries to cast it to what the caller wants
	 *
	 * @param <T> The type the caller wants (eg, an InstanceObject or SAFE2 System Overview)
	 * @param currentSelection The user's selection
	 * @param desiredType The type the caller wants (eg, an InstanceObject or SAFE2 System Overview)
	 * @return The user's selection as an instance of T, or null if we can't get one from
	 * what the user has selected
	 */
	public static <T> T getTarget(ISelection currentSelection, Class<T> desiredType) {
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) currentSelection;
			if (iss.size() == 1) {
				Object obj = iss.getFirstElement();
				if (desiredType.isInstance(obj)) {
					return (T) obj;
				}
				if (obj instanceof EObjectURIWrapper) {
					EObject eObject = new ResourceSetImpl().getEObject(((EObjectURIWrapper) obj).getUri(), true);
					if (eObject instanceof InstanceObject) {
						return (T) eObject;
					}
				}
				if (obj instanceof IFile) {
					URI uri = OsateResourceUtil.toResourceURI((IFile) obj);
					Resource res = new ResourceSetImpl().getResource(uri, true);
					EList<EObject> rl = res.getContents();
					if (!rl.isEmpty()) {
						return (T) rl.get(0);
					}
				}
			}
		}
		return null;
	}
}
