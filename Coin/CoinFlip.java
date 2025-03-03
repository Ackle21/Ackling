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
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import java.util.Random;

 public class CoinFlip extends Application
 {
   // Fields
   private HBox hbox2;
   
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage)
   {
      // Create a Label to display a prompt.
      Label promptLabel = new Label("Heads or tails?");
   
      // Create a Button to perform the conversion.
      Button calcButton = new Button("Call");
      // Register the event handler.
      calcButton.setOnAction(new CalcButtonHandler());
      
      Image image = new Image("file:coinFlip.png");

      ImageView imageView = new ImageView(image);

      imageView.setFitWidth(200);
      imageView.setPreserveRatio(true);
      
      // Put the promptLabel and the chargeTextField in an HBox.
      HBox hbox = new HBox(10, promptLabel);
      
      // Put the promptLabel and the chargeTextField in an HBox.
      hbox2 = new HBox(imageView);
      
      // Put the HBox, calcButton, and resultLabel in a VBox.
      VBox vbox = new VBox(50, hbox, calcButton, hbox2);
      
      // Set the VBox's alignment to center.
      vbox.setAlignment(Pos.CENTER);
      
      // Set the VBox's padding to 10 pixels.
      vbox.setPadding(new Insets(10));
      
      // Create a Scene.
      Scene scene = new Scene(vbox);
      
      // Add the Scene to the Stage.
      primaryStage.setScene(scene);
      
      // Set the stage title.
      primaryStage.setTitle("Coin Flip");
      
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
         Random randomNumbers = new Random();

         int number = randomNumbers.nextInt(2) + 1;

         Image image = new Image("file:coin-" + number + ".png");

         ImageView imageView = new ImageView(image);

         imageView.setFitWidth(200);
         imageView.setPreserveRatio(true);

         hbox2.getChildren().setAll(imageView);
      }
   }
 }