package hw_01.git;

import hw_01.git.boxContent.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}	

	@Override
	public void start(Stage primaryStage) {
		Button btnInformation = new Button("Information");
		btnInformation.setOnAction(e -> btn_infoClick());
		Button btnWarning = new Button("Warning");
		btnWarning.setOnAction(e -> btn_warningClick());
		Button btnAlert = new Button("Alert");
		btnAlert.setOnAction(e -> btn_alertClick());
		HBox hbox = new HBox();
		hbox.getChildren().addAll(btnInformation, btnWarning, btnAlert);
		hbox.setPadding(new Insets(25, 35, 25, 35));
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(hbox);
		primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Message Boxes");
		primaryStage.show();
	}
	
	
	private void btn_infoClick() {	
		String infoWindowText = "OneDrive is running\n"
				+ "Add files to your OneDrive to have the most\n"
				+ "up-to-date copies wherever you go.";
		String infoWindowTitle = "Information";
		MessageBox.show(infoWindowText, infoWindowTitle, MessageBoxButton.Ok, MessageBoxIcon.Information);
	}
	
	private void btn_warningClick() {	
		String warningWindowText = "Allowing active content such as script and ActiveX controls can be useful.\n"
				+ "But active content might also harm your computer.\n\n"
				+ "Are you sure you want to let this file run active content?";
		String warningWindowTitle = "Security Warning";
		MessageBoxResult result = MessageBox.show(warningWindowText, warningWindowTitle, MessageBoxButton.YesNo, MessageBoxIcon.Warning);
		if( result == MessageBoxResult.Yes) {
			Platform.exit();
		}
	}
	
	private void btn_alertClick() {	
		String alertWindowText = "Are you sure deleting this account permanently ?";
		String alertWindowTitle = "Alert!";
		MessageBox.show(alertWindowText, alertWindowTitle, MessageBoxButton.YesNoCancel, MessageBoxIcon.Alert);
	}
		
}
