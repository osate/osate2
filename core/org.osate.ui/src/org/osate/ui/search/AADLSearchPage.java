package org.osate.ui.search;

import java.util.function.Consumer;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.osate.search.AADLSearchQuery.LimitTo;
import org.osate.search.AADLSearchQuery.SearchFor;

public final class AADLSearchPage extends DialogPage implements ISearchPage {
	private ISearchPageContainer seachPageContainer;
	private Text substringText;

	private SearchFor searchFor;
	private LimitTo limitTo;

	private Button classifierRadio;
	private Button propertyRadio;
	private Button refAndDeclRadio;
	private Button referenceRadio;
	private Button declarationRadio;

	public AADLSearchPage() {
		super();
	}

	@Override
	public void createControl(final Composite parent) {
		final Composite root = new Composite(parent, SWT.NULL);
		root.setLayout(new GridLayout(2, true));

		final Group searchTextGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		searchTextGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		searchTextGroup.setText("Identifier Substring  (AADL identifiers are Case insensitive)");

		searchTextGroup.setLayout(new GridLayout(1, true));
		substringText = new Text(searchTextGroup, SWT.BORDER);
		substringText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		final Group searchForGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		searchForGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		searchForGroup.setText("Search For");

		searchForGroup.setLayout(new RowLayout(SWT.VERTICAL));
		classifierRadio = new Button(searchForGroup, SWT.RADIO);
		classifierRadio.setText("Classifier");
		classifierRadio.setSelection(true);
		propertyRadio = new Button(searchForGroup, SWT.RADIO);
		propertyRadio.setText("Property");
//		createRadioButton(searchForGroup, "Classifier", this::setSearchFor, SearchFor.CLASSIFIER);
//		createRadioButton(searchForGroup, "Property", this::setSearchFor, SearchFor.PROPERTY);

		final Group limitToGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		limitToGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		limitToGroup.setText("Limit To");

		limitToGroup.setLayout(new RowLayout(SWT.VERTICAL));
		refAndDeclRadio = new Button(limitToGroup, SWT.RADIO);
		refAndDeclRadio.setText("All occurances");
		referenceRadio = new Button(limitToGroup, SWT.RADIO);
		referenceRadio.setText("References");
		referenceRadio.setSelection(true);
		declarationRadio = new Button(limitToGroup, SWT.RADIO);
		declarationRadio.setText("Declarations");

		setControl(root);
	}

	private <T> void createRadioButtion(final Group group, final String label, final Consumer<T> setter,
			final T value) {
		final Button radio = new Button(group, SWT.RADIO);
		radio.setText(label);
		radio.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				setter.accept(value);
			}
		});
	}

	private void setSearchFor(final SearchFor v) {
		searchFor = v;
	}

	private void setLimitTo(final LimitTo v) {
		limitTo = v;
	}

	@Override
	public boolean performAction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setContainer(final ISearchPageContainer container) {
		seachPageContainer = container;
	}

}
