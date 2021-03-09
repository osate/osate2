/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.modelsupport;

import java.util.Objects;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.validation.Issue;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;

/**
 * <p>
 * Simple wrapper which is used to store the URI of an EObject instead of an EObject. One place where this is used is in
 * the AADL Navigator to represent expanded elements below the file level.
 * </p>
 * Handlers and selection listeners can load an EObject from its URI:
 * <pre>
 *     EObjectURIWrapper wrapper = [some wrapper];
 *     EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
 * </pre>
 * <p>
 * The {@link #getEClass()} method is useful for determining the type of EObject without actually having to load it.
 * This is used internally when testing the {@code org.osate.aadl2.modelsupport.wrapperSuperType} property in a
 * <a href="https://wiki.eclipse.org/Command_Core_Expressions">Command Core Expression</a>. This example tests if a
 * wrapper represents a {@link ComponentInstance}.
 * </p>
 * <pre>
 * {@code
 * <adapt
 *       type="org.osate.aadl2.modelsupport.EObjectURIWrapper">
 *    <test
 *       property="org.osate.aadl2.modelsupport.wrapperSuperType"
 *       value="ComponentInstance"
 *       forcePluginActivation="true">
 *    </test>
 * </adapt>
 * }
 * </pre>
 */
public class EObjectURIWrapper {
	private final URI uri;
	private final EClass eClass;

	private final Image image;
	private final String text;

	/**
	 * @deprecated Use {@link Factory.createWrapperFor}
	 * @param eObject
	 */
	@Deprecated
	public EObjectURIWrapper(EObject eObject) {
		this(eObject, "", null);
	}

	private EObjectURIWrapper(EObject eObject, String text, Image image) {
		uri = EcoreUtil.getURI(eObject);
		eClass = eObject.eClass();
		this.text = text;
		this.image = image;
	}

	public URI getUri() {
		return uri;
	}

	public EClass getEClass() {
		return eClass;
	}

	/**
	 * @since 6.0
	 */
	public final String getText() {
		return text;
	}

	/**
	 * @since 6.0
	 */
	public final Image getImage() {
		return image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uri);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof EObjectURIWrapper && Objects.equals(uri, ((EObjectURIWrapper) obj).uri);
	}

	/**
	 * @since 6.0
	 */
	/*
	 * Issue 2340: This class was added so that the label and image for the EObjectURIWrapper can be precomputed. Otherwise the
	 * AADLElementLabelProvider would reparse the original AADL file 2 times to resolve the URI for each item in the AADL Navigator.
	 * Once for getText() and once for getImage(). So most of the work of the AADLElementLabel provider is now moved into
	 * this factory class.
	 */
	public static final class Factory {
		/** Marker attribute for URI used by Xtext */
		private static final String XTEXT_URI = Issue.URI_KEY;

		/** Marker attribute for URI used by OSATE analysis markers */
		private static final String OSATE_URI = AadlConstants.AADLURI;

		private static final String[] DECORATIONS = { "", ISharedImages.IMG_DEC_FIELD_WARNING,
				ISharedImages.IMG_DEC_FIELD_ERROR };

		private final ILabelProvider labelProvider;

		public Factory(final ILabelProvider lp) {
			labelProvider = lp;
		}

		public EObjectURIWrapper createWrapperFor(final EObject eObject) {
			final String text = getText(eObject);
			final Image image = getImage(eObject);
			return new EObjectURIWrapper(eObject, text, image);
		}

		private String getText(final EObject eObject) {
			if (eObject instanceof PublicPackageSection) {
				return "public";
			} else if (eObject instanceof PrivatePackageSection) {
				return "private";
			} else if (eObject instanceof DefaultAnnexLibrary) {
				return ((DefaultAnnexLibrary) eObject).getName() + " Annex Library";
			} else if (eObject instanceof DefaultAnnexSubclause) {
				return ((DefaultAnnexSubclause) eObject).getName() + " Annex Subclause";
			} else {
				return labelProvider.getText(eObject);
			}
		}

		private static String getMarkerURIString(final IMarker marker) throws CoreException {
			String uri = (String) marker.getAttribute(OSATE_URI);
			if (uri == null) {
				uri = (String) marker.getAttribute(XTEXT_URI);
			}
			return uri;
		}

		private Image getImage(final EObject eObject) {
			int severity = -1;
			final URI resourceURI = eObject.eResource().getURI();
			if (resourceURI.isPlatformResource()) {
				try {
					final IFile file = OsateResourceUtil.toIFile(eObject.eResource().getURI());
					if (file.isAccessible()) {
						final ResourceSet resourceSet = eObject.eResource().getResourceSet();
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

			final Image image = labelProvider.getImage(eObject);
			if (severity > IMarker.SEVERITY_INFO) {
				final ImageDescriptor overlay = PlatformUI.getWorkbench().getSharedImages()
						.getImageDescriptor(DECORATIONS[severity]);
				/* Is it worth caching images? Hard to do because we create brand new ImageDescriptors each time. */
				return new DecorationOverlayIcon(image, overlay, IDecoration.BOTTOM_LEFT).createImage();
			} else {
				return image;
			}
		}
	}
}