package org.osate.ge.errormodel.filters;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;
import org.osate.ge.ContentFilter;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;

import com.google.common.base.CaseFormat;

public class ErrorBehaviorEventTypeFilter implements ContentFilter {
	private final Class<?> eventInterface;
	private final String id;

	public ErrorBehaviorEventTypeFilter(final Class<?> eventInterface) {
		this.eventInterface = Objects.requireNonNull(eventInterface, "eventInterface must not be null");
		this.id = getId(eventInterface);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getParentId() {
		return ErrorBehaviorEventFilter.ID;
	}

	@Override
	public String getName() {
		return StringUtils.capitalize(StringUtils
				.join(StringUtils.splitByCharacterTypeCamelCase(eventInterface.getSimpleName()), " ")) + "s";
	}

	@Override
	public boolean isApplicable(final Object bo) {
		return bo instanceof ErrorBehaviorStateMachine;
	}

	@Override
	public boolean test(Object bo) {
		return eventInterface.isInstance(bo);
	}

	public static String getId(final Class<?> eventInterface) {
		return "emv2." + CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, eventInterface.getSimpleName()) + "s";
	}
}
