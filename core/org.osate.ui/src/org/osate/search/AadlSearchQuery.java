package org.osate.search;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

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

	public enum Scope {
		WORKSPACE {
			@Override
			public boolean filter(final URI uri) {
				// All the URIs we get from the resource set are going in the workspace
				return true;
			}
		},

		SELECTION {
			@Override
			public boolean filter(URI uri) {
				// TODO Auto-generated method stub
				return false;
			}
		},

		WORKING_SET {
			@Override
			public boolean filter(URI uri) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		/**
		 * Is the given URI in the scope?
		 */
		public abstract boolean filter(URI uri);
	}

	/**
	 * Get the {@link Scope} object for the value returned from
	 * {@link ISearchPageContainer#getSelectedScope()}.
	 */
	public static Scope getScope(final int scope) {
		return Scope.values()[scope];
	}

	private final String substring;
	private final SearchFor searchFor;
	private final LimitTo limitTo;
	private final Scope scope;
	private final AadlSearchResult searchResult;

	public AadlSearchQuery(final String substring, final SearchFor searchFor, final LimitTo limitTo,
			final Scope scope) {
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
				if (scope.filter(objectDesc.getEObjectURI())) {
					// now check the name, which in the last segment (skip over the package names)
					final String nameToTest = objectDesc.getName().getLastSegment();
					// TODO Deal with case insensitivity
					if (nameToTest.contains(substring)) {
						for (final String segment : objectDesc.getName().getSegments()) {
							System.out.print("[" + segment + "]");
						}
						System.out.println(" -- " + objectDesc.getEObjectURI());
					}
				}
			});
		}

		if (limitTo.references()) {
			// XXX When is the best time to get the target EObject and test it's type?
			final ResourceSet resourceSet = OsateResourceUtil.getResourceSet();
			System.out.println("== References ==");
			aadlFinder.getAllReferencesToTypeInWorkspace(null, refDesc -> {
				System.out.println("  Source: " + resourceSet.getEObject(refDesc.getSourceEObjectUri(), true));
				System.out.println("  Target: " + resourceSet.getEObject(refDesc.getTargetEObjectUri(), true));
			});
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
