import javax.swing.*;
public class One
{
  public static void main(String[] args)
  {
    JFrame f = new JFrame("My First Window Frame");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel mes = new JLabel("Here we are: in a label in the content pane of a window frame!");
    f.add(mes);

    f.add(new JButton("Click me!"));

    f.pack();
    f.setVisible(true);
  }
}
