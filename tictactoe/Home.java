import javax.swing.*;
public class Home{
  private FrontPage object;
  public Home(){
    object = new FrontPage();
    object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    object.setSize(400, 400);
    object.setVisible(true);
  }
}
