package org.osate.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;

public final class AADLSearchQuery implements ISearchQuery {
	public enum SearchFor {
		CLASSIFIER, PROPERTY;
	}

	public enum LimitTo {
		ALL, REFERENCES, DECLARATIONS;
	}

	private final String substring;
	private final SearchFor searchFor;
	private final LimitTo limitTo;
	private final int scope;
	private final AADLSearchResult searchResult;

	public AADLSearchQuery(final String substring, final SearchFor searchFor, final LimitTo limitTo, final int scope) {
		this.substring = substring;
		this.searchFor = searchFor;
		this.limitTo = limitTo;
		this.scope = scope;
		this.searchResult = new AADLSearchResult(this);
	}

	@Override
	public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
		System.out.println("Searching for " + searchFor + " " + limitTo + " \"" + substring + "\"; scope = "
				+ scope);
		return Status.OK_STATUS;
	}

	@Override
	public String getLabel() {
		return "Search for \"" + substring + "\" in " + searchFor + " " + limitTo;
	}

	@Override
	public boolean canRerun() {
		return true;
	}

	@Override
	public boolean canRunInBackground() {
		return true;
	}

	@Override
	public ISearchResult getSearchResult() {
		return searchResult;
	}

}
