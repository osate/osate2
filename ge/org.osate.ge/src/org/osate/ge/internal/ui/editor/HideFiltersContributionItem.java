package org.osate.ge.internal.ui.editor;

import org.osate.ge.internal.ui.handlers.HideContentFilterHandler;

public class HideFiltersContributionItem extends ShowHideFiltersContributionItem {
	public HideFiltersContributionItem() {
		super("org.osate.ge.hideContentFilter", HideContentFilterHandler.PARAM_CONTENTS_FILTER_ID);
	}
}
