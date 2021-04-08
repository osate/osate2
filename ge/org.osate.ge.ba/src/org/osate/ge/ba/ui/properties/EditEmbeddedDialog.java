package org.osate.ge.ba.ui.properties;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.function.BiFunction;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ge.swt.SwtUtil;

public class EditEmbeddedDialog extends MessageDialog {
	public static String WIDGET_ID_TEXT = "org.osate.ge.ba.behaviortransition.editdialog.text";
	public static String WIDGET_ID_CONFIRM = "org.osate.ge.ba.behaviortransition.editdialog.confirmation";
	private final String label;
	private final EmbeddedXtextAdapter xtextAdapter;
	private final ExtendedModifyListener textValidator;
	private final int styledTextStyle;
	private final GridData layoutData;
	private StyledText styledText;
	private String replacementText;

	EditEmbeddedDialog(final Shell parentShell, final String dialogMessage, final String label,
			final EmbeddedXtextAdapter xtextAdapter, final int styledTextStyle, final GridData layoutData,
			final BehaviorTransition behaviorTransition,
			final BiFunction<EObject, String, String> getModifiedSrc,
			final BiFunction<BehaviorTransition, String, Boolean> isValidModification) {
		super(parentShell, "Edit Behavior Transition", null, dialogMessage, MessageDialog.CONFIRM, 0, "OK", "Cancel");
		this.label = Objects.requireNonNull(label, "label cannot be null");
		this.xtextAdapter = Objects.requireNonNull(xtextAdapter, "xtextAdapter cannot be null");
		this.styledTextStyle = Objects.requireNonNull(styledTextStyle, "styledTextStyle must not be null");
		this.layoutData = Objects.requireNonNull(layoutData, "layoutData cannot be null");
		this.textValidator = Objects.requireNonNull(
				getTextValidator(behaviorTransition, getModifiedSrc, isValidModification),
				"textValidator cannot be null");
		setShellStyle(SWT.CLOSE | SWT.PRIMARY_MODAL | SWT.BORDER | SWT.TITLE | SWT.RESIZE);
	}

	@Override
	protected Control createCustomArea(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		final GridLayout layout = getGridLayout();
		composite.setLayout(layout);
		composite.setLayoutData(GridDataFactory.fillDefaults().grab(true, true).create());
		composite.setFont(parent.getFont());

		new Label(composite, SWT.NONE).setText(label);

		styledText = new StyledText(composite, styledTextStyle);
		final GridData gd = GridDataFactory.copyData(layoutData);
		gd.horizontalIndent = 10;
		styledText.setLayoutData(gd);
		styledText.addExtendedModifyListener(textValidator);
		SwtUtil.setTestingId(styledText, WIDGET_ID_TEXT);
		xtextAdapter.adapt(styledText);
		new UndoRedoHelper(styledText);

		return composite;
	}

	private GridLayout getGridLayout() {
		final GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		layout.horizontalSpacing = 0;
		layout.numColumns = 2;
		return layout;
	}

	@Override
	public void create() {
		super.create();
		final Button okBtn = getButton(IDialogConstants.OK_ID);
		okBtn.setEnabled(false);
		SwtUtil.setTestingId(okBtn, WIDGET_ID_CONFIRM);
	}

	// Text modification listener that sets the OK button as enabled
	// or disabled based on if the new text is valid
	private ExtendedModifyListener getTextValidator(final BehaviorTransition behaviorTransition,
			final BiFunction<EObject, String, String> getModifiedSrc,
			final BiFunction<BehaviorTransition, String, Boolean> isValidModification) {
		final String originalText = xtextAdapter.getEditableText();
		return event -> {
			final Button okBtn = getButton(IDialogConstants.OK_ID);
			final String newText = styledText.getText().trim();
			// Disable if text has not changed
			if (newText.equals(originalText)) {
				okBtn.setEnabled(false);
				return;
			}

			// Update save button based on whether the text entered into the
			// styled text is a serializable condition
			final EObject rootElement = xtextAdapter.getXtextParseResult().getRootASTElement();
			final XtextResource fakeResource = xtextAdapter.getFakeResource();
			// Link model
			fakeResource.getLinker().linkModel(rootElement, new ListBasedDiagnosticConsumer());

			// Original source text
			final String originalSrc = xtextAdapter.getText();

			try {
				// Modified source text
				final String modifiedSrc = getModifiedSrc.apply(rootElement, styledText.getText().trim());
				// Load for error checking
				loadResource(fakeResource, modifiedSrc);
				boolean isEnabled = false;
				// Check if BehaviorTransition still exists, meaning the modification did not break serialization
				final BehaviorTransition tmpBehaviorTransition = (BehaviorTransition) fakeResource
						.getEObject(EcoreUtil.getURI(behaviorTransition).fragment());
				if (tmpBehaviorTransition != null) {
					isEnabled = isValidModification.apply(tmpBehaviorTransition, newText);
				}

				okBtn.setEnabled(isEnabled);
			} catch (final Exception ex) {
				okBtn.setEnabled(false);
			} finally {
				// Load original source
				loadResource(fakeResource, originalSrc);
			}
		};
	}

	private void loadResource(final XtextResource resource, final String src) {
		try {
			resource.unload();
			resource.load(new ByteArrayInputStream(src.getBytes()), null);
		} catch (final IOException e) {
			throw new RuntimeException("Serialized source cannot be loaded");
		}
	}

	@Override
	protected void buttonPressed(final int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			// Set return text
			replacementText = styledText.getText();
		}
		super.buttonPressed(buttonId);
	}

	@Override
	public boolean close() {
		xtextAdapter.dispose();
		return super.close();
	}

	String getText() {
		return replacementText;
	}
}

