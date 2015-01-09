package org.osate.alisa.common.ui.views;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.FailResult;

public class AlisaResultLabelProvider implements ILabelProvider {
	private static final Image VALID_IMAGE = loadImage("/icons/valid.png");
	private static final Image INVALID_IMAGE = loadImage("/icons/invalid.png");

	// private static final Image ERROR_IMAGE = loadImage("/icons/error.png");

	private static Image loadImage(String filename) {
		try (InputStream stream = AlisaResultLabelProvider.class.getResourceAsStream(filename)) {
			return new Image(null, new ImageData(stream));
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof ClaimResult) {
			ClaimResult claim = (ClaimResult) element;
			return claim.isValid() ? VALID_IMAGE : INVALID_IMAGE;
		} else if (element instanceof FailResult) {
			return INVALID_IMAGE;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String getText(Object element) {
		if (element instanceof ClaimResult) {
			ClaimResult claim = (ClaimResult) element;
			return trim(claim.getText());
		} else if (element instanceof FailResult) {
			FailResult fail = (FailResult) element;
			return trim(fail.getText());
		} else {
			throw new IllegalArgumentException();
		}
	}

	private String trim(String text) {
		if (text.contains("\n")) {
			return text.substring(0, text.indexOf("\n")) + " ...";
		} else {
			return text;
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}
}
