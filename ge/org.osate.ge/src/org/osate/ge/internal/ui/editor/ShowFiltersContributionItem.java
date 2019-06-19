package org.osate.ge.internal.ui.editor;

import org.osate.ge.internal.ui.handlers.ShowContentFilterHandler;

public class ShowFiltersContributionItem extends ShowHideFiltersContributionItem {
	public ShowFiltersContributionItem() {
		super("org.osate.ge.showContentFilter", ShowContentFilterHandler.PARAM_CONTENTS_FILTER_ID);
	}
}
