package uk.ac.rhul.cs2800;

import java.util.function.Consumer;

public interface GuiViewInterface {


  public void addCalcObserver(Observer f);
  
  public void addTypeObserver(Consumer<OpType> l);
     
  public String getQuestion();

  public void setAnswer(String a);
     
 
}
