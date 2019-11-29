/**
 *
 */
package org.osate.xtext.aadl2.ui.refactoring.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;

/**
 * @author lw
 *
 */
@SuppressWarnings("restriction")
public class Aadl2ClassifierRenameParticipant extends AbstractProcessorBasedRenameParticipant {

	@Override
	protected List<EObject> getRenamedElementsOrProxies(EObject originalTarget) {

		if (originalTarget instanceof ComponentType) {
			AadlPackage pkg = EcoreUtil2.getContainerOfType(originalTarget, AadlPackage.class);
			List<ComponentImplementation> impls = EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class);
			return impls.stream().filter((impl) -> impl.getType() == originalTarget).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
