package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,700,400, Color.DARKSLATEGRAY);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Label sourceLabel = new Label("Źródło:");
			sourceLabel.setLayoutX(30);
			sourceLabel.setLayoutY(30);
			sourceLabel.getStyleClass().add("label");
			
			TextField sourceTextField = new TextField();
			sourceTextField.setLayoutX(30);
			sourceTextField.setLayoutY(70);
			sourceTextField.getStyleClass().add("textField");
			
			Button copyButton = new Button("Kopiuj");
			copyButton.setLayoutX(150);
			copyButton.setLayoutY(135);
			copyButton.getStyleClass().add("button");
			
			Label resultLabel = new Label("Wynik operacji:");
			resultLabel.setLayoutX(30);
			resultLabel.setLayoutY(200);
			resultLabel.getStyleClass().add("label");
			
			TextField resultTextField = new TextField();
			resultTextField.setLayoutX(30);
			resultTextField.setLayoutY(240);
			resultTextField.getStyleClass().add("textField");
			
			Button executeButton = new Button("Wykonaj");
			executeButton.setLayoutX(150);
			executeButton.setLayoutY(305);
			executeButton.getStyleClass().add("button");
			
			Label choiceLabel = new Label("Operacja:");
			choiceLabel.setLayoutX(500);
			choiceLabel.setLayoutY(120);
			choiceLabel.getStyleClass().add("label");
			
			RadioButton encodingRB = new RadioButton("kodowanie");
			encodingRB.setSelected(true);
			encodingRB.setLayoutX(500);
			encodingRB.setLayoutY(160);
			encodingRB.getStyleClass().add("radioButton");
			
			RadioButton decodingRB = new RadioButton("dekodowanie");
			decodingRB.setLayoutX(500);
			decodingRB.setLayoutY(190);
			decodingRB.getStyleClass().add("radioButton");
			
			ToggleGroup toggleGroup = new ToggleGroup();
			encodingRB.setToggleGroup(toggleGroup);
			decodingRB.setToggleGroup(toggleGroup);
			
			root.getChildren().addAll(sourceLabel, sourceTextField, copyButton, resultLabel, resultTextField, executeButton, choiceLabel, encodingRB, decodingRB);
			
			//=========== Execute Button Listener ========================
			executeButton.setOnAction(event -> {
				if(encodingRB.isSelected()) { // jężeli encode
					if(!sourceTextField.getText().isEmpty()) {
						resultTextField.setText(Controller.encode(sourceTextField.getText()));
						//sourceTextField.setText(null);
					} 
				}
				
				if(decodingRB.isSelected()) { //jeżeli decode
					if(!sourceTextField.getText().isEmpty()) {
						resultTextField.setText(Controller.decode(sourceTextField.getText()));
						//sourceTextField.setText(null);
					}
				}
			});
			
			//=========== Copy Button Listener ========================
			copyButton.setOnAction(event -> {
				sourceTextField.setText(resultTextField.getText());
				//resultTextField.setText(null);
			});
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Run Length Encoding");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
