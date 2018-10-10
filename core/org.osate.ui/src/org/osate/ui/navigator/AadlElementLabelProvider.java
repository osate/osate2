package org.osate.ui.navigator;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.UiUtil;

public class AadlElementLabelProvider extends AdapterFactoryLabelProvider implements IDescriptionProvider {
	/** Marker attribute for URI used by Xtext */
	// TODO: Find a pre-existing constant value for this
	private static final String XTEXT_URI = "URI_KEY";

	/** Marker attribute for URI used by OSATE analysis markers */
	private static final String OSATE_URI = AadlConstants.AADLURI;

	private static final String[] DECORATIONS = { "", ISharedImages.IMG_DEC_FIELD_WARNING,
			ISharedImages.IMG_DEC_FIELD_ERROR };

	public AadlElementLabelProvider() {
		super(UiUtil.getAdapterFactory());
	}

	@Override
	public Image getImage(Object object) {
		Image image = super.getImage(object);

		if (object instanceof Element) {
			final EObject eObject = (EObject) object;
			final Resource eRsrc = eObject.eResource();

			if (eRsrc == null) {
				return null;
			}

			final ResourceSet resourceSet = eRsrc.getResourceSet();

			int severity = -1;
			try {
				final IResource iRsrc = OsateResourceUtil.convertToIResource(eRsrc);
				if (iRsrc.isAccessible()) {
					final IMarker[] markers = iRsrc.findMarkers(null, true, IResource.DEPTH_INFINITE);
					for (final IMarker marker : markers) {
						final String markerURIString = getMarkerURIString(marker);
						if (markerURIString != null) {
							final EObject markedObject = resourceSet.getEObject(URI.createURI(markerURIString), false);
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

			if (severity > IMarker.SEVERITY_INFO) {
				final ImageDescriptor overlay = PlatformUI.getWorkbench().getSharedImages()
						.getImageDescriptor(DECORATIONS[severity]);
				/* Is it worth caching images? Hard to do because we create brand new ImageDescriptors each time. */
				image = new DecorationOverlayIcon(image, overlay, IDecoration.BOTTOM_LEFT).createImage();
			}

			return image;
		}
		return null;
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
		if (object instanceof PublicPackageSection) {
			return "public";
		}
		if (object instanceof PrivatePackageSection) {
			return "private";
		}
		if (object instanceof DefaultAnnexLibrary) {
			return ((DefaultAnnexLibrary) object).getName() + " Annex Library";
		}
		if (object instanceof DefaultAnnexSubclause) {
			return ((DefaultAnnexSubclause) object).getName() + " Annex Subclause";
		}
		if (object instanceof Element) {
			return super.getText(object);
		}
		return null;
	}

	@Override
	public String getDescription(Object element) {
		String description = null;
		if (element instanceof EObject) {
			final Resource eResource = ((EObject) element).eResource();
			if (eResource != null) {
				URI uri = eResource.getURI();
				if (uri.isPlatformPlugin()) {
					// contributed
					String[] segments = uri.segments();
					int i = 2;
					while (segments[i].startsWith("resource") || segments[i].startsWith("package")
							|| segments[i].startsWith("propert")) {
						i++;
					}
					description = "Plug-in Contributions/"
							+ Arrays.asList(segments).stream().skip(i).collect(Collectors.joining("/"));
				} else {
					String[] segments = uri.segments();
					description = Arrays.asList(segments).stream().skip(1).collect(Collectors.joining("/"));
				}
				description = getText(element) + " - " + description;
			}
		}
		return description;
	}
}
