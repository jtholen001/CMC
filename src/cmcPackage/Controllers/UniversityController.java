/**
 * A controller class that handles University functionalities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/26/18
 */
package cmcPackage.Controllers;

//import ArrayList
import java.util.ArrayList;

//import HashMap
import java.util.HashMap;

//import Set
import java.util.Set;
import cmcPackage.entityClasses.*;

public class UniversityController
{
  /**
   * an instance of the DBController
   */
  private DBController dbCont;
  
  /**
   * Constructor for a UniversityController object
   */
  public UniversityController(DBController temp)
  {
    this.dbCont = temp;
  }
  
  /**
   * A method that displays all University objects in the Database
   * @return a string representation of all the universities in the database
   */
  public HashMap<String, University> viewUniversities()
  {
    HashMap<String, University> listAll = dbCont.viewUniversities();
    return listAll;
  }
  
  /**
   * A method that allows an Admin to edit a University
   * 
   * @param university the University object to be edited
   * @param state a String representing the edited state of the University
   * @param location a String representing the edited location of the University
   * @param control a String representing the edited control of the University
   * @param numStudents an int representing the edited numStudents of the University
   * @param percentFemale a double representing the edited percentFemale of the University
   * @param SATVerbal an int representing the edited SATVerbal of the University
   * @param SATMath an int representing the edited SATMath of the University
   * @param expenses an int representing the edited expenses of the University
   * @param percentFinancialAid a double representing the edited percentFinancialAid of the University
   * @param numApplicants an int representing the edited numApplicants of the University
   * @param percentAdmitted a double representing the edited percentAdmitted of the University
   * @param percentEnrolled a double representing the edited percentEnrolled of the University
   * @param academicScale an int representing the edited academicScale of the University
   * @param socialScale an intrepresenting the edited socialScale of the University
   * @param qualityOfLifeScale an int representing the edited qualityOfLifeScale of the University
   * @param emphases an ArrayList<String> representing the edited emphases of the University
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int editUniversity(University university, String state, String location, String control, String numStudents, String percentFemale, String SATVerbal, String SATMath,
         String expenses, String percentFinancialAid, String numApplicants, String percentAdmitted, String percentEnrolled,
                             String academicScale, String socialScale, String qualityOfLifeScale, ArrayList<String> emphases)
  { 
    university.setState(state);
    university.setLocation(location);
    university.setControl(control);
    university.setNumStudents(Integer.parseInt(numStudents));
    university.setPercentFemale(Double.parseDouble(percentFemale));
    university.setSATVerbal(Double.parseDouble(SATVerbal));
    university.setSATMath(Double.parseDouble(SATMath));
    university.setExpenses(Double.parseDouble(expenses));
    university.setPercentFinancialAid(Double.parseDouble(percentFinancialAid));
    university.setNumApplicants(Integer.parseInt(numApplicants));
    university.setPercentAdmitted(Double.parseDouble(percentAdmitted));
    university.setPercentEnrolled(Double.parseDouble(percentEnrolled));
    university.setAcademicScale(Integer.parseInt(academicScale));
    university.setSocialScale(Integer.parseInt(socialScale));
    university.setQualityOfLifeScale(Integer.parseInt(qualityOfLifeScale));
    university.setEmphases(emphases);
    
    return dbCont.saveEditedUniversity(university);
  }
  
  /**
   * A method that allows an Admin to add a University
   * 
   * @param name a String representing the added name of the University
   * @param state a String representing the added state of the University
   * @param location a String representing the added location of the University
   * @param control a String representing the added control of the University
   * @param numStudents an int representing the added numStudents of the University
   * @param percentFemale a double representing the added percentFemale of the University
   * @param SATVerbal an int representing the added SATVerbal of the University
   * @param SATMath an int representing the added SATMath of the University
   * @param expenses an int representing the added expenses of the University
   * @param percentFinancialAid a double representing the added percentFinancialAid of the University
   * @param numApplicants an int representing the added numApplicants of the University
   * @param percentAdmitted a double representing the added percentAdmitted of the University
   * @param percentEnrolled a double representing the added percentEnrolled of the University
   * @param academicScale an int representing the addded academicScale of the University
   * @param socialScale an intrepresenting the added socialScale of the University
   * @param qualityOfLifeScale an int representing the added qualityOfLifeScale of the University
   * @param emphases an ArrayList<String> representing the added emphases of the University
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int addUniversity(String name, String state, String location, String control, String numStudents, String percentFemale, String SATVerbal, String SATMath,
         String expenses, String percentFinancialAid, String numApplicants, String percentAdmitted, String percentEnrolled,
                             String academicScale, String socialScale, String qualityOfLifeScale, ArrayList<String> emphases)
  {    
    try{
    	return dbCont.addUniversity(new University(name, state, location, control, Integer.parseInt(numStudents), Double.parseDouble(percentFemale), Double.parseDouble(SATVerbal), Double.parseDouble(SATMath), 
                                        Double.parseDouble(expenses), Double.parseDouble(percentFinancialAid), Integer.parseInt(numApplicants), Double.parseDouble(percentAdmitted), Double.parseDouble(percentEnrolled), 
                                        Integer.parseInt(academicScale), Integer.parseInt(socialScale), Integer.parseInt(qualityOfLifeScale), emphases));
    }
    catch(IllegalArgumentException illegalArg) {
    	throw illegalArg;
    }
  }
  
  public University getUniversity(String name)
  {
	  try {
		  return dbCont.getUniversity(name);
	  }
	  catch(IllegalArgumentException j)
	  {
		  throw j;
	  }
  }
  
  /**
   * this method removes a University from the database
   * 
   * @param university the university to remove from the database
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int deleteUniversity(University university)
  {
   try{
	   return dbCont.deleteUniversity(university);
   }
   catch(IllegalArgumentException illegalArg) {
	   return -1;
   }
  }
}