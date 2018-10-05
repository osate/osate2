package org.osate.ui.navigator;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.osate.aadl2.Element;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;
import org.osate.ui.UiUtil;

public class AadlElementLabelProvider extends AdapterFactoryLabelProvider implements IDescriptionProvider {

	public AadlElementLabelProvider() {
		super(UiUtil.getAdapterFactory());
	}

	@Override
	public Image getImage(Object object) {
		if (object instanceof Element) {
			return super.getImage(object);
		}
		return null;
	}

	@Override
	public String getText(Object object) {
		if (object instanceof PublicPackageSection) {
			return "public";
		}
		if (object instanceof PrivatePackageSection) {
			return "private";
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
