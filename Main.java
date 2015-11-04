package project5;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Java FX Critters");
			
			// Add a grid pane to lay out the buttons and text fields.
			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));
			
			int row = 0;
			
			// Add Field for Critter type.
			Label critName = new Label("Critter Name (e.g. Algae):");
			grid.add(critName, 0, row);
			TextField critNameField = new TextField();
			//row++;
			grid.add(critNameField, 1, row);
			
			// Add Field for No. of Critters
			Label numCrits = new Label("No of critters:");
			row++;
			grid.add(numCrits, 0, row);
			TextField critNumField = new TextField();
			//row++;
			grid.add(critNumField, 1, row);
			
			// Add Button to add Critters.
			Button addBtn = new Button("Add critters");
			HBox hbAddBtn = new HBox(10);
			hbAddBtn.setAlignment(Pos.BOTTOM_RIGHT);
			hbAddBtn.getChildren().add(addBtn);
			row += 2;
			grid.add(hbAddBtn, 1, row);
			
			// Action when Add Critters Button is pressed.
			final Text actionTarget = new Text();
			row += 2;
			grid.add(actionTarget, 1, row);
			
			//grid.setGridLinesVisible(true);
			
			Scene scene = new Scene(grid, 500, 1000);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// Action when add critters button is pressed. Call makeCritter.
			// Uses something called an anonymous class of type EventHandler<ActionEvent>, which is a class that is
			// defined inline, in the curly braces.
			addBtn.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					boolean input_error = false;
					String name = critNameField.getText(); 
					String preserve_name = name;
					if(name.equals("Hound"))name = "project5.MyCritter1";
					else if(name.equals("Bunny"))name = "project5.MyCritter2";
					else if(name.equals("Craig")) name = "project5.Craig";
					else if(name.equals("Algae")) name = "project5.Algae";
					else {
						input_error = true;
					}
					String numString = critNumField.getText();
					//TODO: Call Critter.makeCritter as many times as requested.
					try{
						//only make critters if there is no error
						if(!input_error){
							for (int i = 0; i < Integer.parseInt(numString);i++){
								Critter.makeCritter(name);
							}
						}
					}catch(Exception e){
						//something to implement later
					}
    					actionTarget.setFill(Color.FIREBRICK);
					actionTarget.setText((input_error) ? "YOU MESSED UP"
							: numString + " " + preserve_name + " Critters added to population");	
					Critter.displayWorld(); // Optional
				}			
			});
			

		} catch(Exception e) {
			e.printStackTrace();		
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}