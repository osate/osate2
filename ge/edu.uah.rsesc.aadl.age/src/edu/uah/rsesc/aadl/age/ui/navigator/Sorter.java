package edu.uah.rsesc.aadl.age.ui.navigator;

import java.text.Collator;

import org.eclipse.jface.viewers.ViewerSorter;

public class Sorter extends ViewerSorter {

	public Sorter() {
		super(Collator.getInstance());
	}

}
