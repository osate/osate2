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
	private static final String HOVER_ITEM_STYLE = "-fx-background-color: rgba(252,228,179,1.0);";
	private static final String SELECTED_ITEM_STYLE = "-fx-background-color: rgba(207,227,250,1.0);";
	private static final String IDLE_ITEM_STYLE = "-fx-background-color: white;";
	private final PaletteModel<?, ?> model;
	private final Button button;
	private boolean hovered;
	private final I item;
	private ReadOnlyProperty itemListener;

	public PaletteItem(final PaletteModel<?, I> model, I item) {
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.item = Objects.requireNonNull(item, "item must not be null");
		hovered = false;
		button = new Button(model.getItemLabel(item));
		button.setPadding(new Insets(0, 0, 0, 20));
		button.setFont(new Font(12));
		button.setOnMouseEntered(e -> {
			hovered = true;
			updateStyle();
		});
		button.setOnMouseExited(e -> {
			hovered = false;
			updateStyle();
		});
		this.itemListener = model.activeItemProperty();
		this.itemListener.addListener(new WeakChangeListener<I>(this::activeItemChanged));

		button.setAlignment(Pos.BASELINE_LEFT);
		button.setGraphic(new ImageView(model.getItemIcon(item)));
		button.setOnAction(e -> {
			model.activateItem(item);
		});
		this.getChildren().add(button);
		updateStyle();
	}

	private void activeItemChanged(ObservableValue<? extends I> observable, I oldValue, I value) {
		updateStyle();
	}

	private void updateStyle() {

		if (hovered && model.getActiveItem() != item) {
			button.setStyle(HOVER_ITEM_STYLE);
		}
		else if (!hovered && model.getActiveItem() != item) {
			button.setStyle(IDLE_ITEM_STYLE);
		}
		else if (model.getActiveItem() == item) {
			button.setStyle(SELECTED_ITEM_STYLE);
		}


	}

	@Override
	public void layoutChildren() {
		final double width = this.getWidth();
		final double height = this.getHeight();

		button.resize(width, height);
	}
}