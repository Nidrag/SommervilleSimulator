package controller.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.svg.SVGGlyph;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import util.InfoSessao;

public class PerguntasController implements Initializable{
	@FXML AnchorPane anchorPerguntas;
	@FXML JFXTabPane tabPanePerguntas;
	@FXML Label lblTempo;
	@FXML Pane panePerguntas;
	@FXML JFXSpinner spinnerTempo;
	
	@FXML JFXButton buttonHome;
	@FXML JFXButton buttonPausar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		customizaButtons();
		
		Tab tab = new Tab();
		
		tab.setText("Testeaaa");
		AnchorPane anchorPane = new AnchorPane();
		try {
			anchorPane = FXMLLoader.load(getClass().getResource("/view/perguntas/definicao/FXMLCap1P1.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tab.setContent(anchorPane);
		tabPanePerguntas.getTabs().add(tab);

		/*
		Timeline timeline = new Timeline();
		
		KeyValue keyValue1 = new KeyValue(progressBarTempo.progressProperty(), 0.01);
		KeyFrame frame1 = new KeyFrame(Duration.millis(500), keyValue1);
		
		KeyValue keyValue2 = new KeyValue(progressBarTempo.progressProperty(), 1);
		KeyFrame frame2 = new KeyFrame(Duration.seconds(10), keyValue2);
		
		timeline.getKeyFrames().addAll(frame1, frame2);
		timeline.play();
		*/
		
		Timeline timeline = new Timeline();
		
		KeyValue keyValue1 = new KeyValue(spinnerTempo.progressProperty(), 0.01);
		KeyFrame frame1 = new KeyFrame(Duration.millis(500), keyValue1);
		KeyValue keyValue2 = new KeyValue(spinnerTempo.progressProperty(), 1);
		KeyFrame frame2 = new KeyFrame(Duration.seconds(16), keyValue2);
		
		timeline.getKeyFrames().addAll(frame1, frame2);
		timeline.play();
		
		spinnerTempo.setStyle("-fx-text-fill: RED;");
		
		lblTempo.textProperty().bind(InfoSessao.timeSeconds.asString());
		lblTempo.textProperty().addListener((observable, oldValue, newValue) -> {
			// Isso serve para que a Label fique dentro do Spinner
			if( Integer.parseInt(newValue.toString()) >= 10 ) {
				lblTempo.setLayoutX(824.0);
			}else {
				lblTempo.setLayoutX(830.0);
			}
			
			if(newValue.equals("0")) {
				
				System.out.println("CABO O TEMPO MANO");
				
			}
		});
	}
	
	private void customizaButtons() {
		buttonHome.setStyle("-fx-background-radius: 40; -fx-background-color: transparent");
		buttonHome.setPrefSize(30, 30);
		buttonHome.setRipplerFill(Color.valueOf("#ffffff"));
        SVGGlyph glyph1 = new SVGGlyph(-1,
            "test",
            "M10 20v-6h4v6h5v-8h3L12 3 2 12h3v8z",
            Color.WHITE);
        glyph1.setSize(18, 18);
        buttonHome.setGraphic(glyph1);
        
        buttonPausar.setStyle("-fx-background-radius: 40;-fx-background-color: transparent");
        buttonPausar.setPrefSize(30, 30);
        buttonPausar.setRipplerFill(Color.valueOf("#ffffff"));
        SVGGlyph glyph2 = new SVGGlyph(-1,
            "test2",
            "M25.5,357h102V0h-102V357z M229.5,0v357h102V0H229.5z",
            Color.WHITE);
        glyph2.setSize(15, 15);
        buttonPausar.setGraphic(glyph2);
	}
	
	@FXML private void buttonHomeOnAction(ActionEvent e) {
		
	}
	
	@FXML private void buttonPausarOnAction(ActionEvent e) {
		
	}
}
