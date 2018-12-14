import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class GUIBoard extends JPanel{

  private Records recordObject;
  private char[][] boardArray;
  private Icon iconX;
  private Icon iconO;
  private char[] turns = {'O', 'X'};
  private char turn;
  private static int counter = 0;
  private static int counter2 = 0;
  private String[] playerName;
  private int[] playerWins = {0, 0};
  private String currentPlayer;
  private String currentWinner;
  private int[] score = {0, 0};


  private JPanel panel1;
  private JPanel panel2;
  private JPanel panel3;
  private JTextField field0;
  private JTextField field1;
  private JTextField field2;
  private JButton button1;
  private JButton[] buttonArray;

  public GUIBoard(){
    //super("Hafiz Tictactoe");
    playerName = new String[2];
    playerName[0] = "p1";
    playerName[1] = "p1";
    turn = 'O';

    boardArray = new char[3][3];



    Icon iconX = new ImageIcon(getClass().getResource("bug.png"));
    Icon iconO = new ImageIcon(getClass().getResource("bug1.jpg"));
    field0 = new JTextField(String.format(getPlayerName1() ), 8);
    field0.setEditable(false);
    field1 = new JTextField("Changes here", 12);
    field1.setFont(new Font("Serif", Font.ITALIC, 16));
    field1.setEditable(false);
    field2 = new JTextField(String.format(getPlayerName2()), 8);
    field2.setEditable(false);
    panel1 = new JPanel();


    panel1.setLayout(new FlowLayout());
    panel1.add(field0);
    panel1.add(field1);
    panel1.add(field2);


    buttonArray = new JButton[9];

    panel2 = new JPanel();
    panel3 = new JPanel();


    panel2.setLayout(new GridLayout(3, 3, 3, 3));
    panel3.setLayout(new GridLayout(3, 3, 3, 3));
    for(int i = 0; i<9; i++){
      buttonArray[i] = new JButton(" ");
      buttonArray[i].setBackground(Color.WHITE);
      //buttonArray[i].setIcon(new ImageIcon(getClass().getResource("bug2.jpg")));

      panel2.add(buttonArray[i]);

      buttonArray[i].addActionListener(new ButtonHandler());
    }


    button1 = new JButton("Restart Game");

    button1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        restartGame();
      }
    });
  }

  private class ButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){



      JButton btn = (JButton)event.getSource();
        if(event.getActionCommand() != "X" && event.getActionCommand() != "O" &&  Color.WHITE == btn.getBackground()){
          btn.setLabel(String.format("%c", turn));

          btn.setBackground(Color.BLUE);
          if(btn.getText().equals("X")){
            btn.setIcon( new ImageIcon(getClass().getResource("xx.png")) );
          }else if(btn.getText().equals("O")){
            btn.setIcon( new ImageIcon(getClass().getResource("oo.jpg")) );
          }

          checkWin();
          counter++;
          changeTurn();
          if(counter > 8){
            field1.setText("Draw");
            restartGame();
          }
        }
    }
  }


  public void restartGame(){
    for(int i = 0; i<9; i++){
      buttonArray[i].setLabel(" ");
      buttonArray[i].setBackground(Color.WHITE);
      buttonArray[i].setIcon( new ImageIcon(getClass().getResource("bug.png")) );

    }
    counter = 0;
  }

  public void saveScore(){
      recordObject = new Records();
      String[] name = new String[2];
      int[] score = new int[2];
      recordObject.setPlayer(playerName);
      recordObject.setPlayerScore(playerWins);
      recordObject.store();
  }


  public void changeTurn(){
    turn = turns[((counter2+1)%2)];
    currentPlayer = playerName[( (counter2+1) %2)];
    currentWinner = playerName[( (counter2+1) %2)];
    counter2++;
    int j = 0;
    int ii = 0;
    while(((currentPlayer == "Computer") || j >300) && counter < 9){
      int i = (new Random()).nextInt(9);
      ii++;
      System.out.println(ii+"\n");
      if(Color.WHITE == buttonArray[i].getBackground()){
        buttonArray[i].setLabel(String.format("%c", turn));
        buttonArray[i].setBackground(Color.BLUE);
        if(buttonArray[i].getText().equals("X")){
          buttonArray[i].setIcon( new ImageIcon(getClass().getResource("xx.png")) );
        }else if(buttonArray[i].getText().equals("O")){
          buttonArray[i].setIcon( new ImageIcon(getClass().getResource("oo.jpg")) );
        }

        checkWin();
        counter++;
        changeTurn();
        if(counter > 8){
          field1.setText("Draw");
          restartGame();
        }
      }
      j++;
    }
  }

  public void checkWin(){
    String checker = "X";
    String won = String.format("%s ( %s ) won",currentPlayer, checker);
    if(buttonArray[0].getText().equals(checker) && buttonArray[1].getText().equals(checker) && buttonArray[2].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[3].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[5].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[6].getText().equals(checker) && buttonArray[7].getText().equals(checker) && buttonArray[8].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[0].getText().equals(checker) && buttonArray[3].getText().equals(checker) && buttonArray[6].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[1].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[7].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[2].getText().equals(checker) && buttonArray[5].getText().equals(checker) && buttonArray[8].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[0].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[8].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[2].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[6].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }
    checker = "O";
    won = String.format("%s ( %s ) won",currentPlayer, checker);
    if(buttonArray[0].getText().equals(checker) && buttonArray[1].getText().equals(checker) && buttonArray[2].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[3].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[5].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[6].getText().equals(checker) && buttonArray[7].getText().equals(checker) && buttonArray[8].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[0].getText().equals(checker) && buttonArray[3].getText().equals(checker) && buttonArray[6].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[1].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[7].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[2].getText().equals(checker) && buttonArray[5].getText().equals(checker) && buttonArray[8].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[0].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[8].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }else if(buttonArray[2].getText().equals(checker) && buttonArray[4].getText().equals(checker) && buttonArray[6].getText().equals(checker)){
      field1.setText(won);
			scoreUpdate();
      displayWin();
      restartGame();
      counter--;

    }
  }
  public void setScore(){

  }
  public JPanel getScore(){

    return panel1;
  }
  public JButton getRestart(){
    return button1;
  }
  public JPanel getGameBoard(){
    return panel2;
  }
  public JPanel getWinBoard(){
    for(int i = 0; i<9; i++){
      panel3.add(buttonArray[i]);
    }
    return panel3;
  }
  public void assignUserName1(String p1){
    playerName[0] = p1;
    currentPlayer = playerName[0];
    newGame();
  }

  public void assignUserName2(String p2){
    playerName[1] = p2;
    field2.setText(playerWins[1]+" : "+p2);
  }

  public String getPlayerName1(){
    return playerName[0];
  }

  public String getPlayerName2(){
    return playerName[1];
  }

  public void scoreUpdate(){
    playerWins[( (counter2) %2)]++;
    field0.setText(getPlayerName1()+" : "+playerWins[0]);
    field2.setText(playerWins[1]+" : "+getPlayerName2());
  }
  public void newGame(){
    playerWins[0]=0;
    playerWins[1]=0;
    field0.setText(getPlayerName1()+" : "+playerWins[0]);
    field1.setText("New Game");
    restartGame();
  }
  public int getPlayerScore1(){
    return playerWins[0];
  }

  public int getPlayerScore2(){
    return playerWins[1];
  }

  public void displayWin(){
    panel2.revalidate();
    panel2.repaint();
  }


}
