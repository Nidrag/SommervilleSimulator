package component;

import static javafx.animation.Interpolator.EASE_BOTH;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.svg.SVGGlyph;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class CFXContainerCapitulo extends StackPane{
	private String capId;
	private boolean checked;
	private double width = 800;
	private double height = 100;
	private Label capName = new Label();
	private JFXCheckBox checkBox = new JFXCheckBox();
	private Label descricao = new Label();
	
	public CFXContainerCapitulo() {
		this.setMinWidth(width);
		this.setMaxWidth(width);
		this.setPrefWidth(width);
		
		this.setMinHeight(height);
		this.setMaxHeight(height);
		this.setPrefHeight(height);
		
		JFXDepthManager.setDepth(this, 1);
		
		// Conteudo
		StackPane header = new StackPane();
		
		checkBox.setUnCheckedColor(Color.WHITE);
		checkBox.setCheckedColor(Color.web("#1ab3ce"));
		StackPane.setMargin(checkBox, new Insets(0, 0, 0, 12));
        StackPane.setAlignment(checkBox, Pos.CENTER_LEFT);
		
		capName.setText("Teste");
		capName.setStyle("-fx-text-fill: white; -fx-font-size: 20px;");
		StackPane.setMargin(capName, new Insets(0, 0, 0, 40));
        StackPane.setAlignment(capName, Pos.CENTER_LEFT);
		
        header.getChildren().addAll(checkBox, capName);
		
        String headerColor = "#ff803a";
        header.setStyle("-fx-background-radius: 5 5 0 0; -fx-background-color: " + headerColor);
        VBox.setVgrow(header, Priority.ALWAYS);
        StackPane body = new StackPane();
        
        descricao.setStyle("-fx-font-size: 13px;");
        descricao.setWrapText(true);
        descricao.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        StackPane.setMargin(descricao, new Insets(0, 0, 25, 10));
        StackPane.setAlignment(descricao, Pos.CENTER_LEFT);
        
        body.getChildren().add(descricao);
        
        body.setMinHeight(1.1 * 20 + 50);
        VBox content = new VBox();
        content.getChildren().addAll(header, body);
        body.setStyle("-fx-background-radius: 0 0 5 5; -fx-background-color: rgb(255,255,255,0.87);");

        this.getChildren().addAll(content);
	}
	
	public String getCapId() {
		return capId;
	}

	public void setCapId(String capId) {
		this.capId = capId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public Label getCapName() {
		return capName;
	}

	public void setCapName(Label capName) {
		this.capName = capName;
	}

	public JFXCheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JFXCheckBox checkBox) {
		this.checkBox = checkBox;
	}

	public Label getDescricao() {
		return descricao;
	}

	public void setDescricao(Label descricao) {
		this.descricao = descricao;
	}
}
