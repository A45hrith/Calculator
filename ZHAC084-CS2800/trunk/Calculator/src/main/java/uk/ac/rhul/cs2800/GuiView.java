package uk.ac.rhul.cs2800;

import java.util.function.Consumer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class GuiView extends Application implements GuiViewInterface {

  Stage primaryStage;
  String expression;
  String answer;
  Consumer<OpType> changeType = null; //to identify the type
  
  //All fxml variables identify the correct object in the gui.
  
  @FXML
  private ToggleGroup type;
  
  @FXML
  private TextField input; //input box
  
  @FXML
  private TextField result;// holds the result
  
  @FXML
  private RadioButton infix;// radio button for infix
   
  @FXML
  private RadioButton postfix;

  @FXML
  private Button calcBtnResult;//the button that will handle execution
  
  
  /**Start method for javafx. Not implemented since its handled in main method.
 * 
 */

  public void start(Stage primaryStage) {
    try {
      FXMLLoader load = new FXMLLoader();
      load.setLocation(getClass().getResource("GuiBuilder.fxml"));
      Parent root = load.load();
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  //gets the expression from textbox
  public String getExpression() {
    return input.getText();
  }
  /**This method will determine the type of expression.
   * 
   */
  
  public boolean expressionType() {
    if (infix.isPressed()) {
      return (true);
    } else {
      return (false); //False returns if the radiobutton revpolish has been selected
     
    }
  }  
  
  
  //sets the answer to gui
  public void setAnswer(String str) {
    result.setText(str);
  }
  //variable will be used to check if an object exists
  
  public static volatile GuiView instance = null;
  
  @FXML //initializes it here
  void initialize() {
    instance = this;
  }
  /**
   * This will create a new thread for the class to run on and calls the start method.
   */
  
  public static synchronized GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
    }
    while (instance == null) {
    }
    return instance;
  }
  /**
   * this method will assigns an observer. calls made from CalcController class.
   */
  
  public void addCalcObserver(Observer obs) {
    calcBtnResult.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        obs.tell();
      }
    });
  }
  /**
   * This observer is responsible for the type, infix.
   */
  
  public void addTypeObserver(Observer obs) {
    System.out.println("gui view line 117");
    infix.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        obs.tell(); //this tells the observer of any activity
      }
    });
    
  }

  /**
   * This observer is responsible for the type, postfix.
   */
  @Override
  public void addTypeObserver(Consumer<OpType> l) {
    System.out.println("gui view line 124");
    postfix.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        changeType = l;//Sets the consumer type here
      }
    });   
  }
  
  //Method inherired from guiview interface
  @Override
  public String getQuestion() { 
    return null;
  }
}