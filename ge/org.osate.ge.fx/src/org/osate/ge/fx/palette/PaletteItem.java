package org.osate.ge.fx.palette;

import java.util.Objects;

import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

class PaletteItem<I> extends Region {

	private final Button Button;
	private boolean Hovered;
	private final PaletteModel<?, ?> model;
	private final I item;
	private static final String HOVER_ITEM_STYLE = "-fx-background-color: rgba(252,228,179,1.0);";
	private static final String SELECTED_ITEM_STYLE = "-fx-background-color: rgba(207,227,250,1.0);";
	private static final String IDLE_ITEM_STYLE = "-fx-background-color: white;";

	public PaletteItem(final PaletteModel<?, I> model, I item) {
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.item = Objects.requireNonNull(item, "item must not be null");
		Hovered = false;
		Button = new Button(model.getItemLabel(item));
		Button.setPadding(new Insets(0, 0, 0, 20));
		Button.setFont(new Font(14));
		Button.setOnMouseEntered(e -> {
			Hovered = true;
			updateStyle();
		});
		Button.setOnMouseExited(e -> {
			Hovered = false;
			updateStyle();
		});
		model.activeItemProperty().addListener(new WeakChangeListener<ReadOnlyProperty<I>>() {
			public void changed(ObservableValue<ReadOnlyProperty<I>> observable, ReadOnlyProperty<I> oldValue,
					ReadOnlyProperty<I> newValue) {
				updateStyle();
			}
		});

		Button.setAlignment(Pos.BASELINE_LEFT);
		Button.setGraphic(new ImageView(model.getItemIcon(item)));
		Button.setOnAction(e -> {
			model.activateItem(item);
		});
		this.getChildren().add(Button);
		updateStyle();
	}

	private void updateStyle() {

		if (Hovered && model.getActiveItem() != item) {
			Button.setStyle(HOVER_ITEM_STYLE);
		}
		else if (!Hovered && model.getActiveItem() != item) {
			Button.setStyle(IDLE_ITEM_STYLE);
		}
		else if (model.getActiveItem() == item) {
			Button.setStyle(SELECTED_ITEM_STYLE);
		}


	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		Button.resize(width, height);
	}
}