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
  public int editUniversity(University university, String state, String location, String control, int numStudents, double percentFemale, double SATVerbal, double SATMath,
         double expenses, double percentFinancialAid, int numApplicants, double percentAdmitted, double percentEnrolled,
                             int academicScale, int socialScale, int qualityOfLifeScale, ArrayList<String> emphases)
  { 
    university.setState(state);
    university.setLocation(location);
    university.setControl(control);
    university.setNumStudents(numStudents);
    university.setPercentFemale(percentFemale);
    university.setSATVerbal(SATVerbal);
    university.setSATMath(SATMath);
    university.setExpenses(expenses);
    university.setPercentFinancialAid(percentFinancialAid);
    university.setNumApplicants(numApplicants);
    university.setPercentAdmitted(percentAdmitted);
    university.setPercentEnrolled(percentEnrolled);
    university.setAcademicScale(academicScale);
    university.setSocialScale(socialScale);
    university.setQualityOfLifeScale(qualityOfLifeScale);
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
  public int addUniversity(String name, String state, String location, String control, int numStudents, double percentFemale, double SATVerbal, double SATMath,
         double expenses, double percentFinancialAid, int numApplicants, double percentAdmitted, double percentEnrolled,
                             int academicScale, int socialScale, int qualityOfLifeScale, ArrayList<String> emphases)
  {    
    try{
    	return dbCont.addUniversity(new University(name, state, location, control, numStudents, percentFemale, SATVerbal, SATMath, 
                                        expenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, 
                                        academicScale, socialScale, qualityOfLifeScale, emphases));
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