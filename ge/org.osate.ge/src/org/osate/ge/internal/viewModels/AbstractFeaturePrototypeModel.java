package org.osate.ge.internal.viewModels;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.FeaturePrototype;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.util.AadlPrototypeUtil;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.selectors.SelectorModel;

import com.google.common.base.Strings;

/**
 * View model for setting the feature prototype for abstract features.
 */
public class AbstractFeaturePrototypeModel extends BaseObservableModel
implements SelectorModel<Set<FeaturePrototype>> {
	private BusinessObjectSelection bos;

	public AbstractFeaturePrototypeModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	@Override
	public Stream<Set<FeaturePrototype>> getElements() {
		final Classifier containingClassifier = getCommonContainingClassifier();
		if (containingClassifier == null) {
			return Stream.empty();
		}

		return Stream
				.concat(Stream.of((FeaturePrototype) null),
						AadlPrototypeUtil.getAllPrototypes(containingClassifier)
						.filter(FeaturePrototype.class::isInstance).map(FeaturePrototype.class::cast))
				.map(Collections::singleton);
	}

	@Override
	public Set<FeaturePrototype> getSelectedElement() {
		return bos.boStream(AbstractFeature.class).map(f -> f.getFeaturePrototype()).collect(Collectors.toSet());
	}

	/**
	 * Return the containing classifier which is shared between the selected abstract features.
	 * @return the containing classifier which is shared between the selected abstract features. Returns null if the containing classifier does not match.
	 */
	private Classifier getCommonContainingClassifier() {
		final Iterator<Classifier> it = bos.boStream(AbstractFeature.class).map(f -> f.getContainingClassifier())
				.iterator();
		if (!it.hasNext()) {
			return null;
		}

		final Classifier classifier = it.next();
		while (it.hasNext()) {
			if (classifier != it.next()) {
				return null;
			}
		}

		return classifier;
	}

	@Override
	public void setSelectedElement(final Set<FeaturePrototype> value) {
		final FeaturePrototype fpValue = value == null || value.size() == 0 ? null : value.iterator().next();
		bos.modify(AbstractFeature.class, (Consumer<AbstractFeature>) f -> {
			f.setFeaturePrototype(fpValue);
			f.setAbstractFeatureClassifier(null);
		});
	}

	@Override
	public String getLabel(final Set<FeaturePrototype> elements) {
		if (elements.size() == 1) {
			final FeaturePrototype element = elements.iterator().next();
			if (element == null) {
				return "<None>";
			}

			return Strings.nullToEmpty(((FeaturePrototype) element).getQualifiedName());
		} else {
			return "<Multiple>";
		}
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");
		triggerChangeEvent();
	}

}
