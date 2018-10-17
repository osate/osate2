package org.osate.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.xtext.resource.IEObjectDescription;

public final class AadlSearchQuery implements ISearchQuery {
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
	private final AadlSearchResult searchResult;

	public AadlSearchQuery(final String substring, final SearchFor searchFor, final LimitTo limitTo, final int scope) {
		this.substring = substring;
		this.searchFor = searchFor;
		this.limitTo = limitTo;
		this.scope = scope;
		this.searchResult = new AadlSearchResult(this);
	}

	@Override
	public IStatus run(final IProgressMonitor monitor) throws OperationCanceledException {
		final AadlFinder aadlFinder = AadlFinder.getInstance();

		System.out.println("Searching for " + searchFor + " " + limitTo + " \"" + substring + "\"; scope = "
				+ scope);

		System.out.println("== Classifier Declarations ==");
		for (final IEObjectDescription objectDesc : aadlFinder.getAllClassifiersInWorkspace()) {
			for (final String segment : objectDesc.getName().getSegments()) {
				System.out.print("[" + segment + "]");
			}
			System.out.println(" -- " + objectDesc.getEObjectURI());
		}

		System.out.println("== Property Declarations ==");
		for (final IEObjectDescription objectDesc : aadlFinder.getAllPropertyDeclarationsInWorkspace()) {
			for (final String segment : objectDesc.getName().getSegments()) {
				System.out.print("[" + segment + "]");
			}
			System.out.println(" -- " + objectDesc.getEObjectURI());
		}

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
