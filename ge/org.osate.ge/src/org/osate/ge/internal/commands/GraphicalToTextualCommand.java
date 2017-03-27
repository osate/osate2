package org.osate.ge.internal.commands;

import java.util.Objects;

import javax.inject.Named;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.di.Activate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;

public class GraphicalToTextualCommand {
	@GetLabel
	public String getLabel() {
		return "Go to AADL Source";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final Object selElement) {
		return (selElement instanceof EObject || selElement instanceof EmfContainerProvider) && !(selElement instanceof InstanceObject);
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final Object selElement) {
		final EObject boEObj;
		if(selElement instanceof EObject) {
			boEObj = (EObject)selElement;
		} else if(selElement instanceof EmfContainerProvider) {
			boEObj = ((EmfContainerProvider)selElement).getEmfContainer();
		} else {
			throw new RuntimeException("Unsupported type: " + selElement);
		}
		
		final URI uri = Objects.requireNonNull(EcoreUtil.getURI(boEObj), "Unable to get URI for business object");
		if(!(boEObj.eResource() instanceof XtextResource)) {
			throw new RuntimeException("The resource of the loaded business object resource is not an XtextResource");
		}

		final XtextResource res = (XtextResource)boEObj.eResource();
		final GlobalURIEditorOpener opener = Objects.requireNonNull((GlobalURIEditorOpener)res.getResourceServiceProvider().get(GlobalURIEditorOpener.class), "unable to get global URI Editor opener");
		opener.open(uri, true);
		return true;
	}
}
