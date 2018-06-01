package org.osate.xtext.aadl2.errormodel.parsing;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.xtext.aadl2.errormodel.naming.ErrorModelQualifiedNameProvider;
import org.osate.xtext.aadl2.errormodel.ui.internal.ErrorModelActivator;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class EMV2AnnexLinkingService implements AnnexLinkingService {

	@Inject
	private DefaultLinkingService linkingService;

	@Inject
	private ErrorModelQualifiedNameProvider nameProvider;

	public EMV2AnnexLinkingService() {
		Injector injector = ErrorModelActivator.getInstance()
				.getInjector(ErrorModelActivator.ORG_OSATE_XTEXT_AADL2_ERRORMODEL_ERRORMODEL);
		injector.injectMembers(this);
	}

	@Override
	public List<EObject> resolveAnnexReference(String annexName, EObject context, EReference reference, INode node) {
		if (annexName.equalsIgnoreCase(EMV2Util.ErrorModelAnnexName)) {
			return linkingService.getLinkedObjects(context, reference, node);
		} else {
			return Collections.<EObject> emptyList();
		}
	}

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		return nameProvider.getFullyQualifiedName(obj);
	}
}
