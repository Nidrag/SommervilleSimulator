package controller.menu;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;
import com.jfoenix.svg.SVGGlyph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class ToolbarController implements Initializable{
	@FXML BorderPane borderToolbar;
	@FXML JFXToolbar toolbar;
	
	@FXML JFXButton estatisticasButton;
	@FXML JFXButton configButton;
	@FXML JFXButton sobreButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		customizaButtons();
	}

	private void customizaButtons() {
		
		
		estatisticasButton.setStyle("-fx-background-radius: 100;");
		estatisticasButton.setPrefSize(20, 20);
		estatisticasButton.setRipplerFill(Color.valueOf("#ffaa00"));
        SVGGlyph glyph1 = new SVGGlyph(-1,
            "test",
            "M0 26h32v4h-32zM4 18h4v6h-4zM10 10h4v14h-4zM16 16h4v8h-4zM22 4h4v20h-4z",
            Color.web("#ffffff"));
        glyph1.setSize(25, 20);
        estatisticasButton.setGraphic(glyph1);
		
		configButton.setStyle("-fx-background-radius: 100;");
		configButton.setPrefSize(20, 20);
		configButton.setRipplerFill(Color.valueOf("#ffaa00"));
        SVGGlyph glyph2 = new SVGGlyph(-1,
            "test",
            "M11.366 22.564l1.291-1.807-1.414-1.414-1.807 1.291c-0.335-0.187-0.694-0.337-1.071-0.444l-0.365-2.19h-2l-0.365 2.19c-0.377 0.107-0.736 0.256-1.071 0.444l-1.807-1.291-1.414 1.414 1.291 1.807c-0.187 0.335-0.337 0.694-0.443 1.071l-2.19 0.365v2l2.19 0.365c0.107 0.377 0.256 0.736 0.444 1.071l-1.291 1.807 1.414 1.414 1.807-1.291c0.335 0.187 0.694 0.337 1.071 0.444l0.365 2.19h2l0.365-2.19c0.377-0.107 0.736-0.256 1.071-0.444l1.807 1.291 1.414-1.414-1.291-1.807c0.187-0.335 0.337-0.694 0.444-1.071l2.19-0.365v-2l-2.19-0.365c-0.107-0.377-0.256-0.736-0.444-1.071zM7 27c-1.105 0-2-0.895-2-2s0.895-2 2-2 2 0.895 2 2-0.895 2-2 2zM32 12v-2l-2.106-0.383c-0.039-0.251-0.088-0.499-0.148-0.743l1.799-1.159-0.765-1.848-2.092 0.452c-0.132-0.216-0.273-0.426-0.422-0.629l1.219-1.761-1.414-1.414-1.761 1.219c-0.203-0.149-0.413-0.29-0.629-0.422l0.452-2.092-1.848-0.765-1.159 1.799c-0.244-0.059-0.492-0.109-0.743-0.148l-0.383-2.106h-2l-0.383 2.106c-0.251 0.039-0.499 0.088-0.743 0.148l-1.159-1.799-1.848 0.765 0.452 2.092c-0.216 0.132-0.426 0.273-0.629 0.422l-1.761-1.219-1.414 1.414 1.219 1.761c-0.149 0.203-0.29 0.413-0.422 0.629l-2.092-0.452-0.765 1.848 1.799 1.159c-0.059 0.244-0.109 0.492-0.148 0.743l-2.106 0.383v2l2.106 0.383c0.039 0.251 0.088 0.499 0.148 0.743l-1.799 1.159 0.765 1.848 2.092-0.452c0.132 0.216 0.273 0.426 0.422 0.629l-1.219 1.761 1.414 1.414 1.761-1.219c0.203 0.149 0.413 0.29 0.629 0.422l-0.452 2.092 1.848 0.765 1.159-1.799c0.244 0.059 0.492 0.109 0.743 0.148l0.383 2.106h2l0.383-2.106c0.251-0.039 0.499-0.088 0.743-0.148l1.159 1.799 1.848-0.765-0.452-2.092c0.216-0.132 0.426-0.273 0.629-0.422l1.761 1.219 1.414-1.414-1.219-1.761c0.149-0.203 0.29-0.413 0.422-0.629l2.092 0.452 0.765-1.848-1.799-1.159c0.059-0.244 0.109-0.492 0.148-0.743l2.106-0.383zM21 15.35c-2.402 0-4.35-1.948-4.35-4.35s1.948-4.35 4.35-4.35 4.35 1.948 4.35 4.35c0 2.402-1.948 4.35-4.35 4.35z",
            Color.web("#ffffff"));
        glyph2.setSize(25, 25);
        configButton.setGraphic(glyph2);
        
        sobreButton.setStyle("-fx-background-radius: 100;");
        sobreButton.setPrefSize(20, 20);
        sobreButton.setRipplerFill(Color.valueOf("#ffaa00"));
        SVGGlyph glyph3 = new SVGGlyph(-1,
            "test",
            "M14 9.5c0-0.825 0.675-1.5 1.5-1.5h1c0.825 0 1.5 0.675 1.5 1.5v1c0 0.825-0.675 1.5-1.5 1.5h-1c-0.825 0-1.5-0.675-1.5-1.5v-1z M20 24h-8v-2h2v-6h-2v-2h6v8h2z M16 0c-8.837 0-16 7.163-16 16s7.163 16 16 16 16-7.163 16-16-7.163-16-16-16zM16 29c-7.18 0-13-5.82-13-13s5.82-13 13-13 13 5.82 13 13-5.82 13-13 13z",
            Color.web("#ffffff"));
        glyph3.setSize(25, 25);
        sobreButton.setGraphic(glyph3);
	}

	@FXML
	public void estatisticasButtonOnAction(ActionEvent e){
		
	}
	
	@FXML
	public void configButtonOnAction(ActionEvent e){
		
	}
	
	@FXML
	public void sobreButtonOnAction(ActionEvent e){
		
	}
}
