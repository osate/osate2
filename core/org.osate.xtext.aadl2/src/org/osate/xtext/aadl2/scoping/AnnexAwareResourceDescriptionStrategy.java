/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
