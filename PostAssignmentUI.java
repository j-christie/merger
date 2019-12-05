import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

public class PostAssignmentUI {
	PostAssignmentControl control;
	JFileChooser chooser = new JFileChooser();
	File f;
	
	Text message = new Text("Upload an Assignment");
	TextField name = new TextField("Assignment Name");
	Button selectFile = new Button("Select File");
	Text selectedFile = new Text("No File Selected");
	Button uploadButton = new Button("Upload");
	
	Button back = new Button("Back");
	
    
    public PostAssignmentUI(PostAssignmentControl control) {
    	this.control = control;
    }
    
    public Scene getScene() {
    	TilePane root = new TilePane();
		root.setHgap(5);
		root.setVgap(5);	
		root.getChildren().add(message);
		root.getChildren().add(name);
		root.getChildren().add(selectFile);
		root.getChildren().add(selectedFile);
		selectFile.setOnAction(selectAssignmentFile);
		root.getChildren().add(uploadButton);
		uploadButton.setOnAction(postAssignment);
		root.getChildren().add(back);
		back.setOnAction(goBack);
		Scene s = new Scene(root);
		
		
		return s;
	}
    
    EventHandler<ActionEvent> selectAssignmentFile = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
            		"Text File", "txt");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showOpenDialog(null);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                selectedFile.setText(chooser.getSelectedFile().getName());
            }
            
        } 
    }; 
    
    EventHandler<ActionEvent> postAssignment = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
        	int success = 0;
        	if(chooser.getSelectedFile() != null) {
        		f = chooser.getSelectedFile();
        	}
        	
        	try {
				success = control.handlePostAssignment(name.getText(), f);
			} catch (LoginException e1) {
				e1.printStackTrace();
			}
        	if(success > 0) message.setText("Upload Successful");
        	else message.setText("Upload Failed");
            
        } 
    };
    
    EventHandler<ActionEvent> goBack = new EventHandler<ActionEvent>() { 
        public void handle(ActionEvent e) 
        { 
            Driver.goBack();
        } 
    }; 
}
