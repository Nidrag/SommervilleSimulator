package controller.menu;

import static javafx.animation.Interpolator.EASE_BOTH;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXButton.ButtonType;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.svg.SVGGlyph;

import application.Main;
import component.CFXContainerCapitulo;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import util.InfoSessao;

public class MenuPrincipalController implements Initializable{
	@FXML AnchorPane anchorMenuPrincipal;
	@FXML JFXTabPane tabPane;
	
	@FXML JFXButton tab1NextButton;
	@FXML JFXButton tab2BackButton;
	@FXML JFXButton tab2StartButton;
	
	@FXML JFXToggleButton marcarToggle;
	
	@FXML JFXListView<CFXContainerCapitulo> listaCapitulos;
	@FXML JFXScrollPane scrollPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		customizaButtons();
		desabilitaNavegacaoTabPane();
		
		
		/*
		ArrayList<Node> children = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
            StackPane child = new StackPane();
            double width = 800;
            child.setMinWidth(width);
            child.setMaxWidth(width);
            child.setPrefWidth(width);
            double height = 100;
            child.setMinHeight(height);
            child.setMaxHeight(height);
            child.setPrefHeight(height);
            JFXDepthManager.setDepth(child, 1);
            children.add(child);

            // create content
            StackPane header = new StackPane();
            String headerColor = "#CE584A";
            header.setStyle("-fx-background-radius: 5 5 0 0; -fx-background-color: " + headerColor);
            VBox.setVgrow(header, Priority.ALWAYS);
            StackPane body = new StackPane();
            body.setMinHeight(Math.random() * 20 + 50);
            VBox content = new VBox();
            content.getChildren().addAll(header, body);
            body.setStyle("-fx-background-radius: 0 0 5 5; -fx-background-color: rgb(255,255,255,0.87);");

            // create button
            JFXButton button = new JFXButton("");
            button.setButtonType(ButtonType.RAISED);
            button.setStyle("-fx-background-radius: 40;-fx-background-color: #CE584A");
            button.setPrefSize(40, 40);
            button.setRipplerFill(Color.valueOf(headerColor));
            button.setScaleX(0);
            button.setScaleY(0);
            SVGGlyph glyph = new SVGGlyph(-1,
                "test",
                "M1008 6.286q18.857 13.714 15.429 36.571l-146.286 877.714q-2.857 16.571-18.286 25.714-8 4.571-17.714 4.571-6.286 "
                + "0-13.714-2.857l-258.857-105.714-138.286 168.571q-10.286 13.143-28 13.143-7.429 "
                + "0-12.571-2.286-10.857-4-17.429-13.429t-6.571-20.857v-199.429l493.714-605.143-610.857 "
                + "528.571-225.714-92.571q-21.143-8-22.857-31.429-1.143-22.857 18.286-33.714l950.857-548.571q8.571-5.143 18.286-5.143"
                + " 11.429 0 20.571 6.286z",
                Color.WHITE);
            glyph.setSize(20, 20);
            button.setGraphic(glyph);
            button.translateYProperty().bind(Bindings.createDoubleBinding(() -> {
                return header.getBoundsInParent().getHeight() - button.getHeight() / 2;
            }, header.boundsInParentProperty(), button.heightProperty()));
            StackPane.setMargin(button, new Insets(0, 12, 0, 0));
            StackPane.setAlignment(button, Pos.TOP_RIGHT);

            Timeline animation = new Timeline(new KeyFrame(Duration.millis(240),
                                                           new KeyValue(button.scaleXProperty(),
                                                                        1,
                                                                        EASE_BOTH),
                                                           new KeyValue(button.scaleYProperty(),
                                                                        1,
                                                                        EASE_BOTH)));
            animation.setDelay(Duration.millis(100 * i + 1000));
            animation.play();
            child.getChildren().addAll(content, button);
            
            listaCapitulos.getItems().add(child);
        }
		*/
		CFXContainerCapitulo cap1 = new CFXContainerCapitulo();
		cap1.setCapId("cap1");
		cap1.getCapName().setText("Capítulo 1 - Introdução");
		cap1.getDescricao().setText("Os objetivos deste capítulo sâo fazer uma introdução à engenharia de software e fornecer uma base para a compreensão do restante do livro.");
		listaCapitulos.getItems().add(cap1);
		
		cap1.setOnMouseClicked(e -> {
			if(cap1.getCheckBox().isSelected()) {
				cap1.getCheckBox().setSelected(false);
			} else {
				cap1.getCheckBox().setSelected(true);
			}
		});
		
		for(int i = 0; i < 5; i++) {
			CFXContainerCapitulo cap = new CFXContainerCapitulo();
			
			listaCapitulos.getItems().add(cap);
		}
		
		listaCapitulos.setMaxHeight(3400);

        JFXScrollPane.smoothScrolling((ScrollPane) scrollPane.getChildren().get(0));

		
        scrollPane.setStyle("-fx-background-color: RED");
		
	}
	
	private void customizaButtons() {
		tab1NextButton.setStyle("-fx-background-radius: 40; -fx-background-color: #ff803a");
		tab1NextButton.setPrefSize(40, 40);
		tab1NextButton.setRipplerFill(Color.valueOf("#ffaa00"));
        SVGGlyph glyph1 = new SVGGlyph(-1,
            "test",
            "M12 4l-1.41 1.41L16.17 11H4v2h12.17l-5.58 5.59L12 20l8-8z",
            Color.WHITE);
        glyph1.setSize(20, 18);
        tab1NextButton.setGraphic(glyph1);
        
        tab2BackButton.setStyle("-fx-background-radius: 40;-fx-background-color: #ff803a");
        tab2BackButton.setPrefSize(40, 40);
        tab2BackButton.setRipplerFill(Color.valueOf("#ffaa00"));
        SVGGlyph glyph2 = new SVGGlyph(-1,
            "test2",
            "M20 11H7.83l5.59-5.59L12 4l-8 8 8 8 1.41-1.41L7.83 13H20v-2z",
            Color.WHITE);
        glyph2.setSize(20, 18);
        tab2BackButton.setGraphic(glyph2);
        
        tab2StartButton.setStyle("-fx-background-radius: 40;-fx-background-color: #ff803a");
        tab2StartButton.setPrefSize(40, 40);
        tab2StartButton.setRipplerFill(Color.valueOf("#ffaa00"));
        SVGGlyph glyph3 = new SVGGlyph(-1,
            "test",
            "M22 2l-10 10h-6l-6 8c0 0 6.357-1.77 10.065-0.94l-10.065 12.94 13.184-10.255c1.839 4.208-1.184 10.255-1.184 10.255l8-6v-6l10-10 2-10-10 2z",
            Color.WHITE);
        glyph3.setSize(20, 18);
        tab2StartButton.setGraphic(glyph3);

	}
	
	private void desabilitaNavegacaoTabPane() {
		tabPane.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                event.consume();
            }else{
            	if (event.getCode() == KeyCode.LEFT) {
                    event.consume();
                }
            }
        });
	}

	@FXML
	public void tab1NextButtonOnAction(ActionEvent e){
		tabPane.getSelectionModel().selectNext();
	}
	
	@FXML
	public void tab2BackButtonOnAction(ActionEvent e){
		tabPane.getSelectionModel().selectPrevious();
	}
	
	@FXML
	public void tab2StartButtonOnAction(ActionEvent e){
		BorderPane root = new BorderPane();
		root = Main.getRoot();
		
		BorderPane toolbar = null;
		try {
			toolbar = FXMLLoader.load(getClass().getResource("/view/menu/FXMLToolbar.fxml"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		AnchorPane perguntas = new AnchorPane();
		try {
			perguntas = FXMLLoader.load(getClass().getResource("/view/menu/FXMLPerguntas.fxml"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		root.setCenter(perguntas);
		root.getChildren().remove(toolbar);
		root.setTop(toolbar);
		
		if (InfoSessao.timeline != null) {
			InfoSessao.timeline.stop();
		}
		InfoSessao.timeSeconds.set(InfoSessao.STARTTIME);
		InfoSessao.timeline = new Timeline();
		InfoSessao.timeline.getKeyFrames().add(
			new KeyFrame(Duration.seconds(InfoSessao.STARTTIME+1),
			new KeyValue(InfoSessao.timeSeconds, 0)));
		InfoSessao.timeline.playFromStart();
	}
	
	@FXML
	public void marcarToggleOnAction(ActionEvent e){
		
	}
}
