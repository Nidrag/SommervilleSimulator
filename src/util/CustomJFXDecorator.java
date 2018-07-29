package util;

import java.util.Optional;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CustomJFXDecorator extends JFXDecorator {
    public CustomJFXDecorator(Stage stage, Node node) { // Construtor padr�o
        this(stage, node, true, true, true);
    }

    /**
     * @param stage (Stage) � o est�gio
     * @param node (Node) � o painel que est� recebendo o decorator
     * @param fullscreen (boolean) se o bot�o de fullscreen est� habiliatado
     * @param max (boolean) se o bot�o de maximizar est� habilitado
     * @param min (boolean) se o bot�o de minimizar est� habilitado
     * */
    public CustomJFXDecorator(Stage stage, Node node, boolean fullScreen, boolean max, boolean min) {
    	super(stage, node, fullScreen, max, min); // Cria o decorador com as op��es escolhidas
        
    	Optional<Node> btnContainerOpt = this.getChildren().stream().filter(child -> {
                return child.getStyleClass().contains("jfx-decorator-buttons-container");
            }
    	).findFirst();
    	
        if (btnContainerOpt.isPresent()) {
        	final HBox buttonsContainer = (HBox) btnContainerOpt.get();

            ObservableList<Node> buttons = buttonsContainer.getChildren();
            int btnMaxIdx = 0;
            if (fullScreen) btnMaxIdx++;
            if (min) btnMaxIdx++;
            
            if (buttons.size() >= btnMaxIdx) {
                final JFXButton btnMax = (JFXButton) buttons.get(btnMaxIdx);
                buttonsContainer.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 2) {
                        btnMax.fire();
                    }
                });
            }

            // Posi��es do �cone
            HBox leftBox = new HBox();
            leftBox.setAlignment(Pos.CENTER_LEFT); // Define o alinhamento do �cone
            leftBox.setPadding(new Insets(0, 0, 0, 5)); // Define a posi��o do �cone
            leftBox.setSpacing(10); // Define o espa�amento do �cone
            
            // Cria��o da caixa de �cone
            HBox iconBox = new HBox();
            iconBox.setAlignment(Pos.CENTER_LEFT);
            iconBox.setSpacing(1);
            
            // Propriedades do �cone
            ImageView icon = new ImageView();
            Image image = new Image("/images/Icon.png");
            icon = new ImageView(image);
            icon.setFitWidth(20);
            icon.setFitHeight(20);
            iconBox.getChildren().add(icon);
            
            // T�tulo da janela
            Label title = new Label();
            title.textProperty().bindBidirectional(stage.titleProperty());
            title.setTextFill(Paint.valueOf("#ffffff"));
            final double TAMANHO = 13.0;
            title.setFont(new Font(TAMANHO));
            
            
            //---------- GAMBIARRINHA ----------
            /*
            	Explica��o: Quando compilamos e iniciamos o programa
            	o primeiro bot�o v�sivel na janela come�a pressionado,
            	para evitar isso � adicionado um bot�o "invisivel"
            	que n�o faz nada e n�o aparece
            */
            JFXButton btnInvisivel = new JFXButton("");
            Color c = Color.web("#ff803a"); // Necessita-se que seja da mesma cor que a janela
            btnInvisivel.setRipplerFill(c);
                        
            leftBox.getChildren().addAll(iconBox, title, btnInvisivel);
            HBox.setHgrow(leftBox, Priority.ALWAYS);
            buttonsContainer.getChildren().add(0, leftBox);
        }
    }
}