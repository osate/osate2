package org.osate.xtext.aadl2.instance.valueconversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.ConnectionKind;

public class InstanceValueConverter extends DefaultTerminalConverters{

	@ValueConverter(rule = "ComponentCategory")
	public IValueConverter<ComponentCategory> ComponentCategory() {
		return new IValueConverter<ComponentCategory>() {
			@Override
			public ComponentCategory toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return ComponentCategory.get(string.toLowerCase());
			}

			@Override
			public String toString(ComponentCategory value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "FeatureCategory")
	public IValueConverter<FeatureCategory> FeatureCategory() {
		return new IValueConverter<FeatureCategory>() {
			@Override
			public FeatureCategory toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return FeatureCategory.get(string.toLowerCase());
			}

			@Override
			public String toString(FeatureCategory value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "DirectionType")
	public IValueConverter<DirectionType> DirectionType() {
		return new IValueConverter<DirectionType>() {
			@Override
			public DirectionType toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return DirectionType.get(string.toLowerCase());
			}

			@Override
			public String toString(DirectionType value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "ConnectionKind")
	public IValueConverter<ConnectionKind> ConnectionKind() {
		return new IValueConverter<ConnectionKind>() {
			@Override
			public ConnectionKind toValue(String string, INode node) {
				if (string == null) {
					return null;
				}
				return ConnectionKind.get(string.toLowerCase());
			}

			@Override
			public String toString(ConnectionKind value) {
				return value.getName();
			}
		};
	}

	@ValueConverter(rule = "INTVALUE")
	public IValueConverter<Long> INTVALUE() {
		return new IValueConverter<Long>() {
			@Override
			public Long toValue(String string, INode node) {
				if (string == null) {
					return 0L;
				}
				if (string.indexOf('_') != -1) {
					string = string.replaceAll("_", "");
				}
				return Long.valueOf(string);
			}

			@Override
			public String toString(Long value) {
				return value.toString();
			}
		};
	}

}
