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

 public class TipTaxTotal extends Application
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
      Label promptLabel = new Label("Enter food charge:");
      
      // Create a TextField for input.
      chargeTextField = new TextField();
   
      // Create a Button to perform the conversion.
      Button calcButton = new Button("Tax, tip, and total");
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
      primaryStage.setTitle("Tip, Tax, and Total");
      
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
         double charge = Double.parseDouble(chargeTextField.getText());
            
         // Get tip amount.
         double tip = charge * 0.18;
         
         //Get tax
         double tax = charge * .07;
         
         //Gets total from sum of tax, tip, and charge
         double total = charge + tax + tip;
         
         // Display the results.
         resultLabel.setText(String.format("Tip is: %,.2f\tTax is: %,.2f\tTotal is: %,.2f", tip, tax, total));
      }
   }
 }