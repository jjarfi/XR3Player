package main.java.com.goxr3plus.xr3player.smartcontroller.presenter;

import java.io.IOException;
import java.util.Iterator;

import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;
import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import main.java.com.goxr3plus.xr3player.application.tools.InfoTool;

public class AlphabetBar extends StackPane {
	
	//-----------------------------------------------------
	
	@FXML
	private JFXButton leftArrow;
	
	@FXML
	private ScrollPane scrollPane;
	
	@FXML
	private HBox alphabetBox;
	
	@FXML
	private JFXButton rightArrow;
	
	// -------------------------------------------------------------
	
	/**
	 * Constructor.
	 */
	public AlphabetBar() {
		
		// ------------------------------------FXMLLOADER ----------------------------------------
		FXMLLoader loader = new FXMLLoader(getClass().getResource(InfoTool.FXMLS + "AlphabetBar.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	/**
	 * Called as soon as .fxml is initialised
	 */
	@FXML
	private void initialize() {
		changeLanguageBar(ULocale.ENGLISH);
		
		double speed = 0.10;
		
		//Left
		leftArrow.setOnAction(a -> scrollPane.setHvalue(scrollPane.getHvalue() - speed));
		
		//Right 
		rightArrow.setOnAction(a -> scrollPane.setHvalue(scrollPane.getHvalue() + speed));
	}
	
	/**
	 * @param ulocale
	 */
	public void changeLanguageBar(ULocale ulocale) {
		
		//Clear the previous buttons
		alphabetBox.getChildren().clear();
		
		Iterator<String> iterator = LocaleData.getExemplarSet(ULocale.ENGLISH, LocaleData.ES_STANDARD).iterator();
		while (iterator.hasNext()) {
			
			//Button
			JFXButton letter = new JFXButton(iterator.next());
			
			//On Action
			letter.setOnAction(a -> {
				System.out.println(letter.getText());
			});
			
			//Append on bar
			alphabetBox.getChildren().add(letter);
		}
		
	}
	
}