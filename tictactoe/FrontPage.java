import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FrontPage extends JFrame{
  private GUIBoard boardPanel;
  private RecordsImplementation recordObject;
  private JMenuBar bar;
  private JMenu menu;
  private JMenu menuNewGame;
  private JMenuItem menuItemHVH;
  private JMenuItem menuItemHVC;
  private JMenuItem menuItemHighScore;
  private JMenuItem menuItemExit;
  private JLabel welcomeLabel;
  private JPanel panelHVH;
  private JPanel panelHVC;
  private JDesktopPane theDesktop;
  private JTextArea recordsField;
  private Icon iconWelcome;
  private boolean hSToggle;
  private boolean gameStart;
  private String player1;
  private String player2;

  public FrontPage(){
    super("Tictactoe");

    hSToggle = true;
    gameStart = true;

    welcomeLabel = new JLabel();
    panelHVH = new JPanel();
    panelHVC = new JPanel();
    iconWelcome = new ImageIcon(getClass().getResource("welcome.png"));
    welcomeLabel.setIcon(iconWelcome);


    setLayout(new BorderLayout());
    bar = new JMenuBar();

    menu = new JMenu("Start");
    bar.add(menu);

    menuNewGame = new JMenu("New Game");
    menuItemHVH = new JMenuItem("Human Vs Human");
    menuItemHVC = new JMenuItem("Human Vs Computer");
    menuItemHighScore = new JMenuItem("Highscore");
    menuItemExit = new JMenuItem("Exit");
    menu.add(menuNewGame);
    menuNewGame.add(menuItemHVH);
    menuNewGame.add(menuItemHVC);
    menu.add(menuItemHighScore);
    menu.add(menuItemExit);
    setJMenuBar(bar);

    theDesktop = new JDesktopPane(); // create desktop pane
    add( theDesktop );

    recordObject = new RecordsImplementation();
    recordsField = new JTextArea(10, 15);
    recordsField.setText(recordObject.getRecords());

    add(welcomeLabel, BorderLayout.CENTER);

    panelHVH.setLayout(new BorderLayout());
    panelHVC.setLayout(new BorderLayout());

    boardPanel = new GUIBoard();




    menuItemExit.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          if((boardPanel.getPlayerScore1() != 0 || boardPanel.getPlayerScore2() != 0)){
            boardPanel.saveScore();
            upDateScore();
          }
          System.exit(0);
        }
      }
    );

    menuItemHVH.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          if((boardPanel.getPlayerScore1() != 0 || boardPanel.getPlayerScore2() != 0)){
            boardPanel.saveScore();
            upDateScore();
          }

          boardPanel.assignUserName1(JOptionPane.showInputDialog("player1: "));
          boardPanel.assignUserName2(JOptionPane.showInputDialog("player2: "));
          if(gameStart){
            remove(welcomeLabel);
            remove(panelHVC);
            add(panelHVH);
            panelHVH.add(boardPanel.getScore(), BorderLayout.NORTH);
            panelHVH.add(boardPanel.getGameBoard(), BorderLayout.CENTER);
            panelHVH.add(boardPanel.getRestart(), BorderLayout.SOUTH);
          }
          revalidate();
          repaint();
          gameStart = false;
        }
      }
    );

    menuItemHVC.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          if((boardPanel.getPlayerScore1() != 0 || boardPanel.getPlayerScore2() != 0)){
            boardPanel.saveScore();
            upDateScore();
          }
          boardPanel.assignUserName1(JOptionPane.showInputDialog("player: "));
          boardPanel.assignUserName2("Computer");
          if(gameStart){
            remove(welcomeLabel);
            remove(panelHVC);
            add(panelHVH);
            panelHVH.add(boardPanel.getScore(), BorderLayout.NORTH);
            panelHVH.add(boardPanel.getGameBoard(), BorderLayout.CENTER);
            panelHVH.add(boardPanel.getRestart(), BorderLayout.SOUTH);
          }
          revalidate();
          repaint();
          gameStart = false;
        }
      }
    );

    menuItemHighScore.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          if(hSToggle){
            add(recordsField, BorderLayout.EAST);
            revalidate();
            repaint();
          }else{
            remove(recordsField);
            revalidate();
            repaint();
          }
          hSToggle = !hSToggle;
        }
      }
    );


  }

  public void upDateScore(){
    RecordsImplementation recordObjUpdate = new RecordsImplementation();
    recordsField.setText("");
    recordsField.setText(recordObjUpdate.getRecords());
  }
}
