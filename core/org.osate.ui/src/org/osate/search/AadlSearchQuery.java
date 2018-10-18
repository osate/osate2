package org.osate.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.osate.aadl2.Aadl2Package;

public final class AadlSearchQuery implements ISearchQuery {
	public enum SearchFor {
		CLASSIFIER {
			@Override
			public EClass declarationEClass() {
				return Aadl2Package.eINSTANCE.getClassifier();
			}
		},

		PROPERTY {
			@Override
			public EClass declarationEClass() {
				return Aadl2Package.eINSTANCE.getProperty();
			}
		};

		public abstract EClass declarationEClass();
	}

	public enum LimitTo {
		ALL {
			@Override
			public boolean references() {
				return true;
			}

			@Override
			public boolean declarations() {
				return true;
			}
		},

		REFERENCES {
			@Override
			public boolean references() {
				return true;
			}

			@Override
			public boolean declarations() {
				return false;
			}
		},

		DECLARATIONS {
			@Override
			public boolean references() {
				return false;
			}

			@Override
			public boolean declarations() {
				return true;
			}
		};

		public abstract boolean references();
		public abstract boolean declarations();
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
		// TDOD Make a proper task out of this!

		System.out.println("Searching for " + searchFor + " " + limitTo + " \"" + substring + "\"; scope = "
				+ scope);

		final AadlFinder aadlFinder = AadlFinder.getInstance();

		if (limitTo.declarations()) {
			System.out.println("== Declarations ==");
			aadlFinder.getAllObjectsOfTypeInWorkspace(searchFor.declarationEClass(), objectDesc -> {
				for (final String segment : objectDesc.getName().getSegments()) {
					System.out.print("[" + segment + "]");
				}
				System.out.println(" -- " + objectDesc.getEObjectURI());
			});
		}

		if (limitTo.references()) {
			System.out.println("== References ==");
//			aadlFinder.doStuff();
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
