import dblibrary.project.csci230.*;
import java.io.*;
import java.util.*;

/** 
 * Before you compile in DrJava, go to Edit > Preferences > Resource Locations 
 * Press the Add button under Extra Path to add the following two jars:
 * 
 * 1- /usr/people/classes/CS230/handouts/project/DBLibraryCode/csci230databaselibrary.jar
 * 2- /usr/people/classes/Java/mysql-connector-java-3.1.10-bin.jar
 * 
 * 
 * To run, issue: java DBLibraryDriver "YourDatabaseUsername" "YourDatabasePassword" 
 * in the Interactions Pane in Dr. Java
 * 
 */ 

public class DBLibraryDriver {
  private UniversityDBLibrary univDBlib;
  
  public  DBLibraryDriver(String username, String password){
    univDBlib = new UniversityDBLibrary(username,username,password);
  }
  
  public UniversityDBLibrary getUnivDBlib(){
    return univDBlib;
  }
  
  public void display(String[][] table, PrintWriter pw, int topx) {
    
    if(table!=null){
      if (topx == -1 || topx > table.length)
        topx = table.length;      
      for (int row = 0; row < topx; row++) {         
        for (int col = 0; col < table[0].length; col++) {
          pw.print(table[row][col] + ",");
        }
        pw.println();
      }     
    }
    else{
      pw.println("Nothing to display");
    }
  }
  
  public static void main(String[] args) {
    try{
      int topx = -1;
      DBLibraryDriver dbld = new DBLibraryDriver(args[0],args[1]);
      System.out.println("university_addUniversity(x,x,x,x,1,1,1,1,1,1,1,1,1,1,1,1) : " + dbld.getUnivDBlib().university_addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1));
      System.out.println("university_deleteUniversity(x) : " + dbld.getUnivDBlib().university_deleteUniversity("x"));
      System.out.println("university_addUniversity(x,x,x,x,1,1,1,1,1,1,1,1,1,1,1,1) : " + dbld.getUnivDBlib().university_addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1));
      System.out.println("university_addUniversityEmphasis(x, 1224):"+dbld.getUnivDBlib().university_addUniversityEmphasis("x","1224"));
      System.out.println("university_addUniversityEmphasis(x, 1122):"+dbld.getUnivDBlib().university_addUniversityEmphasis("x","1122"));
      System.out.println("university_deleteUniversity(x) : " + dbld.getUnivDBlib().university_deleteUniversity("x"));
      System.out.println("university_removeUniversityEmphasis(x, 1224):"+dbld.getUnivDBlib().university_removeUniversityEmphasis("x","1224"));
      System.out.println("university_removeUniversityEmphasis(x, 1122):"+dbld.getUnivDBlib().university_removeUniversityEmphasis("x","1122"));      
      System.out.println("university_deleteUniversity(x) : " + dbld.getUnivDBlib().university_deleteUniversity("x"));      
      System.out.println("university_addUniversity(x,x,x,x,1,1,1,1,1,1,1,1,1,1,1,1) : " + dbld.getUnivDBlib().university_addUniversity("x","x","x","x",1,1,1,1,1,1,1,1,1,1,1,1));      
     
      System.out.println("user_addUser(yy, yy, yy, yy, 'a'): " + dbld.getUnivDBlib().user_addUser("yy", "yy", "yy", "yy", 'a'));
      System.out.println("user_deleteUser(yy) : " + dbld.getUnivDBlib().user_deleteUser("yy"));
      System.out.println("user_addUser(yy, yy, yy, yy, 'a'): " + dbld.getUnivDBlib().user_addUser("yy", "yy", "yy", "yy", 'a'));

      System.out.println("user_saveSchool(yy, BARD):" + dbld.getUnivDBlib().user_saveSchool("yy","BARD") );
      System.out.println("user_saveSchool(yy, BARD):" + dbld.getUnivDBlib().user_saveSchool("yy","x") );
      System.out.println("user_deleteUser(yy) : " + dbld.getUnivDBlib().user_deleteUser("yy"));
      System.out.println("university_deleteUniversity(x) : " + dbld.getUnivDBlib().university_deleteUniversity("x"));      
      System.out.println("user_removeSchool(yy, BARD):" + dbld.getUnivDBlib().user_removeSchool("yy","BARD") );
      System.out.println("user_removeSchool(yy, BARD):" + dbld.getUnivDBlib().user_removeSchool("yy","x") );
      System.out.println("user_deleteUser(yy) : " + dbld.getUnivDBlib().user_deleteUser("yy"));
      System.out.println("university_deleteUniversity(x) : " + dbld.getUnivDBlib().university_deleteUniversity("x"));
    }
    catch(Exception e){
      e.printStackTrace();
    }
    
  }
}
