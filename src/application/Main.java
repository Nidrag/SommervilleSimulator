package application;

import util.CustomJFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	private static BorderPane root = new BorderPane();
	public static BorderPane getRoot(){
		return root;
	}
	
	@Override
	public void start(Stage stage) {
		try {
			CustomJFXDecorator decorator = new CustomJFXDecorator(stage, root, false, false, true);
			decorator.setCustomMaximize(true); // Isso previne que o programa cubra o taskbar do windows
			AnchorPane menu = FXMLLoader.load(getClass().getResource("/view/menu/FXMLTelaEntrada.fxml"));
			root.setCenter(menu);
			
			Scene scene = new Scene(decorator, 950, 620);
			scene.getStylesheets().add(this.getClass().getResource("/style/DecoratorStyleSheet.css").toExternalForm());
			scene.getStylesheets().add(this.getClass().getResource("/style/CustomStyle.css").toExternalForm());
			stage.setTitle("Sommerville Simulator");
			stage.getIcons().add(new Image("/images/Icon.png"));
			stage.setMinWidth(450);
			stage.setMinHeight(300);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}