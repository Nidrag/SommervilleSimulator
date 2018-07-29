package util;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class InfoSessao {
	public static ArrayList<String> capitulosSelecionados[];
	public static int pontuacaoAtual = 0;
	public static int qtdVidas;
	
	public static final Integer STARTTIME = 15;
    public static Timeline timeline;
    public static Label timerLabel = new Label();
    public static IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
	
    public static void main(String[] args) {
    	timerLabel.textProperty().bind(timeSeconds.asString());
        timerLabel.setTextFill(Color.RED);
        timerLabel.setStyle("-fx-font-size: 4em;");
        
        Button button = new Button();
        button.setText("Start Timer");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (timeline != null) {
                    timeline.stop();
                }
                timeSeconds.set(STARTTIME);
                timeline = new Timeline();
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(STARTTIME+1),
                        new KeyValue(timeSeconds, 0)));
                timeline.playFromStart();
            }
        });
    }
}
