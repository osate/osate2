package org.osate.xtext.aadl2.ui.refactoring;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;

/**
 * @author lw
 *
 */
@SuppressWarnings("restriction")
public class Aadl2DependentElementsCalculator extends DefaultDependentElementsCalculator {

	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		List<URI> dependentElementURIs = super.getDependentElementURIs(baseElement, monitor);

		if (baseElement instanceof ComponentType) {
			AadlPackage pkg = EcoreUtil2.getContainerOfType(baseElement, AadlPackage.class);
			EcoreUtil2.getAllContentsOfType(pkg, ComponentImplementation.class)
					.stream()
					.filter((impl) -> impl.getType() == baseElement)
					.map((impl) -> EcoreUtil.getURI(impl))
					.forEach(dependentElementURIs::add);
		}
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
		return dependentElementURIs;
	}

}
