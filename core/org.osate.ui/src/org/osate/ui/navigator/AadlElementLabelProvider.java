/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ui.navigator;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.UiUtil;

public class AadlElementLabelProvider extends AdapterFactoryLabelProvider implements IDescriptionProvider {
	/** Marker attribute for URI used by Xtext */
	private static final String XTEXT_URI = Issue.URI_KEY;

	/** Marker attribute for URI used by OSATE analysis markers */
	private static final String OSATE_URI = AadlConstants.AADLURI;

	private static final String[] DECORATIONS = { "", ISharedImages.IMG_DEC_FIELD_WARNING,
			ISharedImages.IMG_DEC_FIELD_ERROR };

	public AadlElementLabelProvider() {
		super(UiUtil.getAdapterFactory());
	}

	@Override
	public Image getImage(Object object) {
		if (object instanceof EObjectURIWrapper) {
			final EObjectURIWrapper wrapper = (EObjectURIWrapper) object;
			final ResourceSet resourceSet = new ResourceSetImpl();
			final EObject eObject = resourceSet.getEObject(wrapper.getUri(), true);
			int severity = -1;
			final URI resourceURI = eObject.eResource().getURI();
			if (resourceURI.isPlatformResource()) {
				try {
					final IFile file = OsateResourceUtil.toIFile(eObject.eResource().getURI());
					if (file.isAccessible()) {
						final IMarker[] markers = file.findMarkers(null, true, IResource.DEPTH_INFINITE);
						for (final IMarker marker : markers) {
							final String markerURIString = getMarkerURIString(marker);
							if (markerURIString != null) {
								final EObject markedObject = resourceSet.getEObject(URI.createURI(markerURIString),
										true);
								if (markedObject != null && EcoreUtil.isAncestor(eObject, markedObject)) {
									final int markerSeverity = (Integer) marker.getAttribute(IMarker.SEVERITY);
									if (markerSeverity > severity) {
										severity = markerSeverity;
									}
								}
							}
						}
					}
				} catch (final CoreException e) {
					OsateCorePlugin.log(e);
				}
			}

			final Image image = super.getImage(eObject);
			if (severity > IMarker.SEVERITY_INFO) {
				final ImageDescriptor overlay = PlatformUI.getWorkbench().getSharedImages()
						.getImageDescriptor(DECORATIONS[severity]);
				/* Is it worth caching images? Hard to do because we create brand new ImageDescriptors each time. */
				return new DecorationOverlayIcon(image, overlay, IDecoration.BOTTOM_LEFT).createImage();
			} else {
				return image;
			}
		} else {
			return null;
		}
	}

	private String getMarkerURIString(final IMarker marker) throws CoreException {
		String uri = (String) marker.getAttribute(OSATE_URI);
		if (uri == null) {
			uri = (String) marker.getAttribute(XTEXT_URI);
		}
		return uri;
	}

	@Override
	public String getText(Object object) {
		if (object instanceof EObjectURIWrapper) {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) object;
			EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
			if (eObject instanceof PublicPackageSection) {
				return "public";
			} else if (eObject instanceof PrivatePackageSection) {
				return "private";
			} else if (eObject instanceof DefaultAnnexLibrary) {
				return ((DefaultAnnexLibrary) eObject).getName() + " Annex Library";
			} else if (eObject instanceof DefaultAnnexSubclause) {
				return ((DefaultAnnexSubclause) eObject).getName() + " Annex Subclause";
			} else {
				return super.getText(eObject);
			}
		} else {
			return null;
		}
	}

	@Override
	public String getDescription(Object element) {
		if (element instanceof EObjectURIWrapper) {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) element;
			URI uri = wrapper.getUri();
			StringBuilder description = new StringBuilder(getText(wrapper));
			description.append(" - ");
			if (uri.isPlatformPlugin()) {
				// contributed
				String[] segments = uri.segments();
				int i = 2;
				while (segments[i].startsWith("resource") || segments[i].startsWith("package")
						|| segments[i].startsWith("propert")) {
					i++;
				}
				description.append("Plug-in Contributions/");
				description.append(Arrays.stream(segments).skip(i).collect(Collectors.joining("/")));
			} else {
				String[] segments = uri.segments();
				description.append(Arrays.stream(segments).skip(1).collect(Collectors.joining("/")));
			}
			return description.toString();
		} else {
			return null;
		}
	}
}
