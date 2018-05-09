package org.osate.ge.internal.util;

import java.util.Collection;
import java.util.Collections;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.ProjectProvider;

public class BusinessObjectContextUtil {
	public static BusinessObjectContext getRootContextForProject(final ProjectProvider projectProvider) {
		return new BusinessObjectContext() {
			@Override
			public Collection<? extends Queryable> getChildren() {
				return Collections.emptyList();
			}

			@Override
			public BusinessObjectContext getParent() {
				return null;
			}

			@Override
			public Object getBusinessObject() {
				return projectProvider.getProject();
			}
		};
	}
}
