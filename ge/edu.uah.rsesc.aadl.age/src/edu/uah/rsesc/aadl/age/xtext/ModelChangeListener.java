package edu.uah.rsesc.aadl.age.xtext;

/**
 * Interface for listening to changes to the AADL model. It's intent it to try to prevent unnecessary dependencies on Xtext objects/APIs.
 * @author philip.alldredge
 *
 */
public interface ModelChangeListener {
	void modelChanged();
}
