import java.util.*;
import java.io.*;
public class Records{
  private String[] playerName;
  private int[] playerScore;

  public Records(){
    playerName = new String[2];
    playerScore = new int[2];
  }

  public void setPlayer(String[] val){
    playerName = val;
  }
  public String[] getPlayerName(){
    return playerName;
  }
  public void setPlayerScore(int[] val){
    playerScore = val;
  }
  public int[] getPlayerScore(){
    return playerScore;
  }
  public void store(){
    try{
      Formatter output = new Formatter(new FileWriter("score.dat", true));
      output.format("%s %s %d %d\n",playerName[0],playerName[1],playerScore[0], playerScore[1] );
      output.close();
    }catch(Exception e){
      System.err.println(e);
    }
  }
}
