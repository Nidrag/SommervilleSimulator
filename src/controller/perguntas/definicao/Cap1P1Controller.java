package controller.perguntas.definicao;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;

import application.Main;
import controller.menu.PerguntasController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Cap1P1Controller {
	@FXML private JFXButton proximaPerguntaButton;
	
	@FXML
	public void proximaPerguntaOnAction(ActionEvent e) {
		Tab tab = new Tab();
		
		tab.setText("Testeaaa");
		AnchorPane anchorPane = new AnchorPane();
		try {
			anchorPane = FXMLLoader.load(getClass().getResource("/view/perguntas/definicao/FXMLCap1P1.fxml"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		tab.setContent(anchorPane);
		
		AnchorPane ap = (AnchorPane) Main.getRoot().getCenter();
		Pane p = (Pane) ap.getChildren().get(0);
		JFXTabPane tp = (JFXTabPane) p.getChildren().get(0);
		
		tp.getTabs().add(tab);
		tp.getSelectionModel().selectNext();
		
		System.out.println(tab.getTabPane());
		// PerguntasController.tabPanePerguntas.getTabs().add(tab);
	}
}
