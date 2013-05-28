/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.image;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IFileEditorInput;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;
import org.osate.imv.aadldiagram.viewer.AadlPersistentDiagramViewer;


public class ImageSaver {

	public static final String AUTO_IMAGE_TYPE_PROPERTY = "autoImageType";

	private static final String PNG_EXTENSION = ".png";
	private static final String JPG_EXTENSION = ".jpg";

	private static final AutoImageType DEFAULT_AUTO_IMAGE_TYPE = AutoImageType.NONE;

	private static int[] SWT_IMAGE_TYPES = {SWT.IMAGE_PNG, SWT.IMAGE_JPEG, SWT.IMAGE_GIF};

	private AutoImageType autoImageType = DEFAULT_AUTO_IMAGE_TYPE;

	private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	private ImageLoader imageLoader;

	private IFolder imvFolder;

	private AadlPersistentDiagramViewer viewer;

	public ImageSaver(IFileEditorInput editorInput, AadlPersistentDiagramViewer viewer) {
		this.viewer = viewer;
		// Get reference to "imv" folder.
		this.imvFolder = editorInput.getFile().getProject().getFolder("imv");
		try {
			if (!imvFolder.exists())
				imvFolder.create(true, true, null);
		} catch (CoreException e) {
			this.imvFolder = null;
		}

		this.imageLoader = new ImageLoader();
	}

	public AutoImageType getAutoImageType() {
		return autoImageType;
	}

	public void setAutoImageType(AutoImageType autoImageType) {
		this.propertyChangeSupport.firePropertyChange(AUTO_IMAGE_TYPE_PROPERTY, this.autoImageType, this.autoImageType = autoImageType);
	}

	public void save() {

		IAadlElementAdapter adapter = viewer.getAadlDiagram().getRootAdapter();

		setImageLoaderData(adapter.getFigure());

		// Get file location.
		final FileDialog dialog = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
		dialog.setFilterNames(new String[] { "PNG File", "JPEG File" });
		dialog.setFilterExtensions(new String[] { "*.png", "*.jpg" });
		//dialog.setFilterPath(null);
		dialog.setFileName(getImageName(adapter));
		final String path = dialog.open();

		new Job("Save As") {
			protected IStatus run(IProgressMonitor monitor) {
				if (path != null) {
					imageLoader.save(path, SWT_IMAGE_TYPES[dialog.getFilterIndex()]);
				}
				return Status.OK_STATUS;
			}
		}.schedule();

	}

	public void forceAutomaticSave() {
		switch(this.getAutoImageType()) {
		case PNG:
			this.forceAutomaticSave(SWT.IMAGE_PNG, PNG_EXTENSION);
			break;
		case JPG:
			this.forceAutomaticSave(SWT.IMAGE_JPEG, JPG_EXTENSION);
			break;
		case GIF:
			//this.forceAutomaticSave(SWT.IMAGE_GIF);
			break;
		}
	}

	private void forceAutomaticSave(final int type, final String extension) {
		if(this.imvFolder == null)
			return;

		// Get all dirty adapters while we are still in the context of the main thread.
		final List<AadlComponentAdapter> dirtyAdapters = new ArrayList<AadlComponentAdapter>();
		for(Iterator<AadlComponentAdapter> it = viewer.getDirtyAdapters(); it.hasNext();)
			dirtyAdapters.add(it.next());

		new Job("Image Auto Save") {
			protected IStatus run(IProgressMonitor monitor) {

				try {

					for(Iterator<AadlComponentAdapter> it = dirtyAdapters.iterator(); it.hasNext();) {
						IAadlElementAdapter adapter = it.next();

						setImageLoaderData(adapter.getFigure());

						IFolder imagesFolder = imvFolder.getFolder("images");
						if (!imagesFolder.exists())
							imagesFolder.create(true, true, null);

						IFolder instanceFolder = imagesFolder.getFolder(getSystemInstanceName(adapter));
						if(!instanceFolder.exists())
							instanceFolder.create(true, true, null);

						IFile imageFile = instanceFolder.getFile(getImageName(adapter) + extension);
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

						imageLoader.save(outputStream, type);

						if(imageFile.exists())
							imageFile.setContents(new ByteArrayInputStream(outputStream.toByteArray()), true, false, null);
						else
							imageFile.create(new ByteArrayInputStream(outputStream.toByteArray()), true, null);
					}

				} catch (CoreException e) {
					e.printStackTrace();
				}

				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private void setImageLoaderData(final IFigure figure) {
		// We MUST create the image from the UI thread.
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				Image image = ImageUtils.getImage(figure);
				imageLoader.data = new ImageData[] {image.getImageData()};
			}
		});
	}

	private String getSystemInstanceName(IAadlElementAdapter adapter) {
		return ((InstanceObject)adapter.getModelElement()).getSystemInstance().getFullName();
	}

	private String getImageName(IAadlElementAdapter adapter) {
		return ((NamedElement)adapter.getModelElement()).getFullName();
	}

	public void addPropertyChangeListener(String propertyName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
	}


	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
	}

}
