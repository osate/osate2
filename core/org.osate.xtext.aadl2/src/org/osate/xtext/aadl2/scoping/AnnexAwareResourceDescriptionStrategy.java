/**
 *
 */
package org.osate.xtext.aadl2.scoping;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy;
import org.eclipse.xtext.util.IAcceptor;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexUtil;
import org.osate.annexsupport.ParseResultHolder;

import com.google.inject.ConfigurationException;
import com.google.inject.Injector;

/**
 * @since 6.2
 */
public class AnnexAwareResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	/**
	 * @see org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy#createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor)
	 */
	@Override
	public boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		IDefaultResourceDescriptionStrategy rds = getAnnexResourceDescriptionStrategy(eObject);

		if (rds != null) {
			return rds.createEObjectDescriptions(eObject, acceptor);
		}
		return super.createEObjectDescriptions(eObject, acceptor);

	}

	/**
	 * @see org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy#createReferenceDescriptions(EObject eObject, URI exportedContainerURI, IAcceptor<IReferenceDescription> acceptor)
	 */
	@Override
	public boolean createReferenceDescriptions(EObject eObject, URI exportedContainerURI,
			IAcceptor<IReferenceDescription> acceptor) {
		IDefaultResourceDescriptionStrategy rds = getAnnexResourceDescriptionStrategy(eObject);

		if (rds != null) {
			return rds.createReferenceDescriptions(eObject, exportedContainerURI, acceptor);
		}
		return super.createReferenceDescriptions(eObject, exportedContainerURI, acceptor);
	}

	private static final Map<String, IDefaultResourceDescriptionStrategy> rdsCache = new HashMap<>();

	protected IDefaultResourceDescriptionStrategy getAnnexResourceDescriptionStrategy(EObject element) {
		EObject annexRoot = AnnexUtil.getAnnexRoot(element);
		IDefaultResourceDescriptionStrategy rds = null;

		if (annexRoot != null) {
			String name = ((NamedElement) annexRoot).getName();

			if (rdsCache.containsKey(name)) {
				rds = rdsCache.get(name);
			} else {
				Injector injector = AnnexUtil.getInjector(name);
				if (injector == null) {
					// fallback if there is a parse result available
					IParseResult annexParseResult = ParseResultHolder.Factory.INSTANCE.adapt(element).getParseResult();
					if (annexParseResult != null) {
						injector = AnnexUtil.getInjector(annexParseResult);
					}
				}
				if (injector != null) {
					try {
						rds = injector.getInstance(IDefaultResourceDescriptionStrategy.class);
						rdsCache.put(name, rds);
					} catch (ConfigurationException e) {
						// ignore, no resource description strategy for this annex
					}
				}
			}
		}

		return rds;
	}

}
