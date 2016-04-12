package org.osate.xtext.aadl2.errormodel.parsing;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.annexsupport.AnnexLinkingService;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.errormodel.linking.EMLinkingService;
import org.osate.xtext.aadl2.errormodel.naming.ErrorModelQualifiedNameProvider;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

import com.google.inject.Injector;

public class EMV2AnnexLinkingService implements AnnexLinkingService {

	final private Injector injector = OsateCorePlugin.getDefault()
			.getInjector("org.osate.xtext.aadl2.errormodel.ErrorModel");

	private ILinkingService linkingService;

	private IQualifiedNameProvider nameProvider;

	protected ILinkingService getLinkingService() {
		if (linkingService == null) {
			linkingService = injector.getInstance(EMLinkingService.class);
		}
		return linkingService;
	}

	protected IQualifiedNameProvider getNameProvider() {
		if (nameProvider == null) {
			nameProvider = injector.getInstance(ErrorModelQualifiedNameProvider.class);
		}
		return nameProvider;
	}

	@Override
	public List<EObject> resolveAnnexReference(String annexName, EObject context, EReference reference, INode node) {
		if (annexName.equalsIgnoreCase(EMV2Util.ErrorModelAnnexName)) {
			return getLinkingService().getLinkedObjects(context, reference, node);
		} else {
			return Collections.<EObject> emptyList();
		}
	}

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		return getNameProvider().getFullyQualifiedName(obj);
	}
}
