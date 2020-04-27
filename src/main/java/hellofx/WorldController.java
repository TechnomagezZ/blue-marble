package hellofx;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class WorldController {
	BlueMarble marble = new BlueMarble();
	boolean enhanced = false;
	boolean unenhanced = false;
	Image image = null;
	Image greyImage = null;
	boolean futureDate = false;

    @FXML
    private Button EnhanceButton;

    @FXML
    private Button BlackWhiteButton;

    @FXML
    private Text DatePrompt;

    @FXML
    private Button EnterDate;

    @FXML
    private DatePicker DatePick;
    
    @FXML
    private ImageView WorldImage;

    @FXML
    void blackWhitePressed(ActionEvent event) {
    	if (DatePick.getValue() != null) {if (DatePick.getValue() != null) {
    		LocalDate inputDate = DatePick.getValue();
    		LocalDate currentDate = LocalDate.now();
    		try {
        		if(inputDate.isAfter(currentDate)) {
        			throw new FutureDateException();
        		}
        		if(inputDate.isEqual(currentDate)) {
        			throw new FutureDateException();
        		}
        		if(inputDate.isBefore(currentDate)) {
        			String date = DatePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            		marble.setDate(date);
            		enhanced = false;
            		unenhanced = true;
            		marble.setEnhanced(enhanced);
            		marble.setUnenhanced(unenhanced);
            		image = new Image(marble.getImage());
            		ColorAdjust monochrome = new ColorAdjust();
            		monochrome.setSaturation(-1);
            		WorldImage.setImage(image);
            		WorldImage.setEffect(monochrome);
        		}
    		}
    		catch (FutureDateException e) {
    			JOptionPane.showMessageDialog(null, "You have selected a date in the future(Only past dates available no current day available). Please try again using a previous date.");
    		}
    	}	
    	}
    }

    @FXML
    void enhancePressed(ActionEvent event) throws FutureDateException{
    	if (DatePick.getValue() != null) {
        	LocalDate inputDate = DatePick.getValue();
        	LocalDate currentDate = LocalDate.now();
        	try {
            	if(inputDate.isAfter(currentDate)) {
            		throw new FutureDateException();
            	}
            	if(inputDate.isEqual(currentDate)) {
            		throw new FutureDateException();
            	}
            	if(inputDate.isBefore(currentDate)) {
            	   	String date = DatePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            	   	marble.setDate(date);
            	   	image = new Image(marble.getImage());
            	   	enhanced = true;
            	   	unenhanced = false;
                	marble.setEnhanced(enhanced);
                	marble.setUnenhanced(unenhanced);
            	   	WorldImage.setImage(image);
            	   	WorldImage.setEffect(null);
            	}
        	}
        	catch (FutureDateException e) {
        		JOptionPane.showMessageDialog(null, "You have selected a date in the future(Only past dates available no current day available). Please try again using a previous date.");
        	}
    	}
    }

    @FXML
    void enterDatePressed(ActionEvent event) throws FutureDateException {
    	if (DatePick.getValue() != null) {
    		LocalDate inputDate = DatePick.getValue();
    		LocalDate currentDate = LocalDate.now();
    		try {
        		if(inputDate.isAfter(currentDate)) {
        			throw new FutureDateException();
        		}
        		if(inputDate.isEqual(currentDate)) {
        			throw new FutureDateException();
        		}
        		if(inputDate.isBefore(currentDate)) {
        			String date = DatePick.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        	    	marble.setDate(date);
        	    	enhanced = false;
        	    	unenhanced = true;
        	    	marble.setEnhanced(enhanced);
            		marble.setUnenhanced(unenhanced);
        	    	image = new Image(marble.getImage());
        	    	WorldImage.setImage(image);
        	    	WorldImage.setEffect(null);
        		}
    		}
    		catch (FutureDateException e) {
    			JOptionPane.showMessageDialog(null, "You have selected a date in the future(Only past dates available no current day available). Please try again using a previous date.");
    		}
    	
    	}
    }
}