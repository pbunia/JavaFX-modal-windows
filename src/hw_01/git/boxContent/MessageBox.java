package hw_01.git.boxContent;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {
	
	private static Stage newStage;
	private static MessageBoxResult result;
	
	public static MessageBoxResult show( String messageText, String titleText, MessageBoxButton buttons, MessageBoxIcon icons ) {
		
		Image yesImage = new Image(ClassLoader.getSystemResourceAsStream("StatusOK_32x.png"));
		ImageView yesImageView = new ImageView(yesImage);
		yesImageView.setImage(yesImage);
			    
		Image noImage = new Image(ClassLoader.getSystemResourceAsStream("StatusNo_32xLG.png"));
		ImageView noImageView = new ImageView(noImage);
		noImageView.setImage(noImage);
		
		Image cancelImage = new Image(ClassLoader.getSystemResourceAsStream("cancel_32x.png"));
		ImageView cancelImageView = new ImageView(cancelImage);
		cancelImageView.setImage(cancelImage);			
		
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		
		Label text1 = new Label();
		text1.setText(messageText);
		
		HBox hbox1 = new HBox(20);
		hbox1.setAlignment(Pos.CENTER);
		
		
		if ( icons == MessageBoxIcon.Information ) {
			Image infoImage = new Image(ClassLoader.getSystemResourceAsStream("StatusInformation_64x.png"));
			ImageView infoImageView = new ImageView(infoImage);
			infoImageView.setImage(infoImage);
			hbox1.getChildren().add(infoImageView);
		} 
		
		else if ( icons == MessageBoxIcon.Warning ) {
			Image warnImage = new Image(ClassLoader.getSystemResourceAsStream("StatusWarning_64x.png"));
			ImageView warnImageView = new ImageView(warnImage);
			warnImageView.setImage(warnImage);
			hbox1.getChildren().add(warnImageView);
		} 
		
		else if ( icons == MessageBoxIcon.Alert ) {
			Image alertImage = new Image(ClassLoader.getSystemResourceAsStream("StatusAlert_64x.png"));
			ImageView alertImageView = new ImageView(alertImage);
			alertImageView.setImage(alertImage);
			hbox1.getChildren().add(alertImageView);
		} 
		
		hbox1.getChildren().addAll(text1);
		hbox1.setPadding(new Insets(20, 20, 20, 20));
		
		HBox hbox2 = new HBox(20);
		hbox2.setAlignment(Pos.CENTER);		
		
		if ( buttons == MessageBoxButton.Ok ) {
			Button btnOk = new Button("OK", yesImageView);
			btnOk.setGraphicTextGap(10);
			btnOk.setOnAction(e -> okCallback());
			btnOk.setCancelButton(true);
			btnOk.setDefaultButton(true);
			btnOk.setFont(Font.font("Arial", FontWeight.BOLD, 16));
			hbox2.getChildren().addAll(btnOk);
		}
		
		else if ( buttons == MessageBoxButton.YesNo ) {				
			Button btnYes = new Button("YES", yesImageView);
			btnYes.setGraphicTextGap(10);			
			btnYes.setOnAction(e -> yesCallback());			
			Button btnNo = new Button("NO", noImageView);
			btnNo.setGraphicTextGap(10);
			btnNo.setFont(Font.font("Arial", FontWeight.BOLD, 16));
			btnNo.setOnAction(e -> noCallback());
			btnNo.setDefaultButton(true);
			btnNo.setCancelButton(true);				
			hbox2.getChildren().addAll(btnYes, btnNo);
		}
		
		else if ( buttons == MessageBoxButton.YesNoCancel ) {				
			Button btnYes = new Button("YES", yesImageView);
			btnYes.setGraphicTextGap(10);
			btnYes.setOnAction(e -> yesCallback());			
			Button btnNo = new Button("NO", noImageView);
			btnNo.setGraphicTextGap(10);
			btnNo.setOnAction(e -> noCallback());
			btnNo.setFont(Font.font("Arial", FontWeight.BOLD, 16));
			btnNo.setDefaultButton(true);
			btnNo.setCancelButton(true);
			Button btnCancel = new Button("Cancel", cancelImageView);
			btnCancel.setGraphicTextGap(10);
			btnCancel.setOnAction(e -> cancelCallback());
			hbox2.getChildren().addAll(btnYes, btnNo, btnCancel);
		}
		
		vbox.getChildren().addAll(hbox1, hbox2);
		
		Scene scene1 = new Scene(vbox, 600, 200);
		
		newStage = new Stage();	
		newStage.setScene(scene1);
		newStage.setTitle(titleText);
		newStage.centerOnScreen();
		newStage.setResizable(false);
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.showAndWait();			
					
		return result;
	}
	
	
	private static void okCallback() {
		result = MessageBoxResult.Ok;
		closeStage();
	}
	
	private static void yesCallback() {
		result = MessageBoxResult.Yes;
		closeStage();
	}
	
	private static void noCallback() {
		result = MessageBoxResult.No;
		closeStage();
	}
	
	private static void cancelCallback() {
		result = MessageBoxResult.Cancel;
		closeStage();
	}
	
	private static void closeStage() {
		newStage.close();
	}
	
}

