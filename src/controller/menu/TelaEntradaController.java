package controller.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.svg.SVGGlyph;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class TelaEntradaController implements Initializable{
	@FXML AnchorPane anchorTelaEntrada;
	
	@FXML JFXButton btnEntrar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources){
		customizaButton();
	}
	
	private void customizaButton() {
		btnEntrar.setStyle("-fx-background-radius: 70;-fx-background-color: #ffffff");
		btnEntrar.setPrefSize(80, 80);
		btnEntrar.setRipplerFill(Color.valueOf("#ffaa00"));
        SVGGlyph glyph = new SVGGlyph(-1,
            "test",
            "M20 33l12-9-12-9v18zm4-29C12.95 4 4 12.95 4 24s8.95 20 20 20 20-8.95 20-20S35.05 4 24 4zm0 36c-8.82 0-16-7.18-16-16S15.18 8 24 8s16 7.18 16 16-7.18 16-16 16z",
            Color.web("#ff803a"));
        glyph.setSize(50, 50);
        btnEntrar.setGraphic(glyph);
	}

	@FXML
	public void btnEntrarOnAction(ActionEvent e){
		btnEntrar.setDisable(true);
		FadeTransition fadeTransition = new FadeTransition();
		fadeTransition.setDuration(Duration.millis(2000));
		fadeTransition.setNode(anchorTelaEntrada);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished((ActionEvent event) ->{
			carregaMenuPrinciapl();
		});
		fadeTransition.play();
	}

	private void carregaMenuPrinciapl() {
		BorderPane root = new BorderPane();
		root = Main.getRoot();
		
		BorderPane toolbar = null;
		try {
			toolbar = FXMLLoader.load(getClass().getResource("/view/menu/FXMLToolbar.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		AnchorPane menuPrincipal = null;
		try {
			menuPrincipal = FXMLLoader.load(getClass().getResource("/view/menu/FXMLMenuPrincipal.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		root.setCenter(menuPrincipal);
		root.getChildren().remove(toolbar);
		root.setTop(toolbar);
	}
}
