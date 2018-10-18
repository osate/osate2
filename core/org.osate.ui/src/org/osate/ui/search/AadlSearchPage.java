package org.osate.ui.search;

import java.util.function.Consumer;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.search.ui.ISearchPage;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.NewSearchUI;
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
import org.osate.search.AadlSearchQuery;
import org.osate.search.AadlSearchQuery.LimitTo;
import org.osate.search.AadlSearchQuery.SearchFor;

public final class AadlSearchPage extends DialogPage implements ISearchPage {
	private ISearchPageContainer searchPageContainer;
	private Text substringText;

	private SearchFor searchFor;
	private LimitTo limitTo;

	public AadlSearchPage() {
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
		createRadioButton(searchForGroup, "Classifier", true, this::setSearchFor, SearchFor.CLASSIFIER);
		createRadioButton(searchForGroup, "Property", false, this::setSearchFor, SearchFor.PROPERTY);

		final Group limitToGroup = new Group(root, SWT.SHADOW_ETCHED_IN);
		limitToGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		limitToGroup.setText("Limit To");

		limitToGroup.setLayout(new RowLayout(SWT.VERTICAL));
		createRadioButton(limitToGroup, "All occurances", false, this::setLimitTo, LimitTo.ALL);
		createRadioButton(limitToGroup, "References", true, this::setLimitTo, LimitTo.REFERENCES);
		createRadioButton(limitToGroup, "Declarations", false, this::setLimitTo, LimitTo.DECLARATIONS);

		setControl(root);
	}

	private <T> void createRadioButton(final Group group, final String label, final boolean selected,
			final Consumer<T> setter,
			final T value) {
		final Button radio = new Button(group, SWT.RADIO);
		radio.setText(label);

		radio.setSelection(selected);
		if (selected) {
			setter.accept(value);
		}

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
		final AadlSearchQuery query = new AadlSearchQuery(substringText.getText(), searchFor, limitTo,
				AadlSearchQuery.getScope(searchPageContainer.getSelectedScope()));
		NewSearchUI.runQueryInForeground(searchPageContainer.getRunnableContext(), query);

		return true;
	}

	@Override
	public void setContainer(final ISearchPageContainer container) {
		searchPageContainer = container;
	}

}
