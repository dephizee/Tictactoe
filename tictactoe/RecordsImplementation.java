import java.util.*;
import java.io.*;
public class RecordsImplementation{
  private Scanner collect;
  private String[] playerName;
  private int[] playerScore;

  public RecordsImplementation(){
    //getRecords();
  }
  public String getRecords(){
    StringBuilder temp = new StringBuilder();
    try{
      collect = new Scanner( new File("score.dat"));
      while(collect.hasNext()){
        temp.append(collect.next() );
        temp.append(" VS ");
        temp.append(collect.next() );
        temp.append("  ");
        temp.append(collect.nextInt() );
        temp.append(" : ");
        temp.append(collect.nextInt() );
        temp.append("\n");
      }
      collect.close();
    }catch(Exception e){
      System.err.println(e);
    }
    return temp.toString();
  }
}
