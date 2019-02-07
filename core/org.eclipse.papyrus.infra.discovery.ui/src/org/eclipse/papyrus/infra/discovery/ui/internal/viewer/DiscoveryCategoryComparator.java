/*******************************************************************************
 * Copyright (c) 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *      Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *      CEA LIST - adaptation to Papyrus
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.internal.viewer;

import java.util.Comparator;

import org.eclipse.papyrus.infra.discovery.Category;


/**
 * A comparator that orders categories by relevance and name.
 *
 * @author David Green
 */
public class DiscoveryCategoryComparator implements Comparator<Category> {

	public int compare(Category o1, Category o2) {
		if (o1 == o2) {
			return 0;
		}
		Integer r1 = o1.getRelevance();
		Integer r2 = o2.getRelevance();
		int i;
		if (r1 != null && r2 != null) {
			// don't have to worry about format, since they were already
			// validated
			// note that higher relevance appears first, thus the reverse order
			// of
			// the comparison.
			i = new Integer(r2).compareTo(new Integer(r1));
		} else if (r1 == null) {
			return 1;
		} else {
			return -1;
		}
		if (i == 0) {
			i = o1.getName().compareToIgnoreCase(o2.getName());
			if (i == 0) {
				i = o1.getName().compareTo(o2.getName());
			}
		}
		return i;
	}

}