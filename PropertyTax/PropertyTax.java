//Alex Miller
 
 import javafx.application.Application;
 import javafx.stage.Stage;
 import javafx.scene.Scene;
 import javafx.scene.layout.HBox;
 import javafx.scene.layout.VBox;
 import javafx.geometry.Pos;
 import javafx.geometry.Insets;
 import javafx.scene.control.Label;
 import javafx.scene.control.TextField;
 import javafx.scene.control.Button;
 import javafx.event.EventHandler;
 import javafx.event.ActionEvent;

 public class PropertyTax extends Application
 {
   // Fields
   private TextField chargeTextField;
   private Label resultLabel;
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Create a Label to display a prompt.
      Label promptLabel = new Label("Enter Property Value:");
      
      // Create a TextField for input.
      chargeTextField = new TextField();
   
      // Create a Button to perform the conversion.
      Button calcButton = new Button("Calculate");
      // Register the event handler.
      calcButton.setOnAction(new CalcButtonHandler());
      
      // Create an empty Label to display the result.
      resultLabel = new Label();
      
      // Put the promptLabel and the chargeTextField in an HBox.
      HBox hbox = new HBox(10, promptLabel, chargeTextField);
      
      // Put the HBox, calcButton, and resultLabel in a VBox.
      VBox vbox = new VBox(50, hbox, calcButton, resultLabel);
      
      // Set the VBox's alignment to center.
      vbox.setAlignment(Pos.CENTER);
      
      // Set the VBox's padding to 10 pixels.
      vbox.setPadding(new Insets(10));
      
      // Create a Scene.
      Scene scene = new Scene(vbox);
      
      // Add the Scene to the Stage.
      primaryStage.setScene(scene);
      
      // Set the stage title.
      primaryStage.setTitle("Property Tax");
      
      // Show the window.
      primaryStage.show();
   }
      
   /**
   Event handler class for calcButton
   */
   
   class CalcButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         // Get the charge.
         double value = Double.parseDouble(chargeTextField.getText());
            
         // Get tip amount.
         double assess = value * 0.60;
         
         //Get tax
         double tax = value * .0064;
         
         
         // Display the results.
         resultLabel.setText(String.format("Assessment: %,.2f\t\tTax is: %,.2f", assess, tax));
      }
   }
 }