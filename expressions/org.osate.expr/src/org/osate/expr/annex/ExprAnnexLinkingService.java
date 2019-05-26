package org.osate.expr.annex;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.annexsupport.AnnexLinkingService;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class ExprAnnexLinkingService implements AnnexLinkingService {

	@Inject
	private ILinkingService linkingService;

	@Inject
	private IQualifiedNameProvider nameProvider;

	public ExprAnnexLinkingService() {
		Injector injector = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.expr")).get(Injector.class);
		injector.injectMembers(this);
	}

	@Override
	public List<EObject> resolveAnnexReference(String annexName, EObject context, EReference reference, INode node) {
		if (annexName.equalsIgnoreCase("expr")) {
			return linkingService.getLinkedObjects(context, reference, node);
		} else {
			return Collections.emptyList();
		}
	}

	@Override
	public QualifiedName getFullyQualifiedName(final EObject obj) {
		return nameProvider.getFullyQualifiedName(obj);
	}

}
