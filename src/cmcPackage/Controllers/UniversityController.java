/**
 * A controller class that handles University functionalities
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 5/2/18
 */
package cmcPackage.Controllers;

//import ArrayList
import java.util.ArrayList;

//import HashMap
import java.util.HashMap;

//import Set
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
	  try {
	if(state.equals(""))
		university.setState("-1");
	else
    	university.setState(state);
	
	if(location.equals(""))
		university.setLocation("-1");
	else
		university.setLocation(location);
	
	if(control == null || control.equals(""))
		university.setControl("-1");
	else
		university.setControl(control);
	
	if(numStudents.equals(""))
		university.setNumStudents(-1);
	else
		university.setNumStudents(Integer.parseInt(numStudents));
	
	if(percentFemale.equals(""))
		university.setPercentFemale(-1.0);
	else
		university.setPercentFemale(Double.parseDouble(percentFemale));
	
	if(SATVerbal.equals(""))
		university.setSATVerbal(-1.0);
	else
		university.setSATVerbal(Double.parseDouble(SATVerbal));
	
	if(SATMath.equals(""))
		university.setSATMath(-1.0);
	else
		university.setSATMath(Double.parseDouble(SATMath));
	
	if(expenses.equals(""))
		university.setExpenses(-1.0);
	else
		university.setExpenses(Double.parseDouble(expenses));
	
	if(percentFinancialAid.equals(""))
		university.setPercentFinancialAid(-1.0);
	else
		university.setPercentFinancialAid(Double.parseDouble(percentFinancialAid));
	
	if(numApplicants.equals(""))
		university.setNumApplicants(-1);
	else
		university.setNumApplicants(Integer.parseInt(numApplicants));
	
	if(percentAdmitted.equals(""))
		university.setPercentAdmitted(-1.0);
	else
		university.setPercentAdmitted(Double.parseDouble(percentAdmitted));
	
	if(percentEnrolled.equals(""))
		university.setPercentEnrolled(-1.0);
	else
		university.setPercentEnrolled(Double.parseDouble(percentEnrolled));
	
	if(academicScale == null || academicScale.equals(""))
		university.setAcademicScale(-1);
	else
		university.setAcademicScale(Integer.parseInt(academicScale));
	
	if(socialScale == null || socialScale.equals(""))
		university.setSocialScale(-1);
	else
		university.setSocialScale(Integer.parseInt(socialScale));
	
	if(qualityOfLifeScale == null || qualityOfLifeScale.equals(""))
		university.setQualityOfLifeScale(-1);
	else
		university.setQualityOfLifeScale(Integer.parseInt(qualityOfLifeScale));
	
    university.setEmphases(emphases);
    
    return dbCont.saveEditedUniversity(university);
	}
	  catch(NumberFormatException | NullPointerException ex)
	  {
		  return -1;
	  }
  }
  
  /**
   * A method that allows an Admin to add a University
   * 
   * @param name a String representing the added name of the University
   * @param state a String representing the added state of the University
   * @param location a String representing the added location of the University
   * @param control a String representing the added control of the University
   * @param numStudents a String representing the added numStudents of the University
   * @param percentFemale a string representing the added percentFemale of the University
   * @param SATVerbal a string representing the added SATVerbal of the University
   * @param SATMath a string representing the added SATMath of the University
   * @param expenses a string representing the added expenses of the University
   * @param percentFinancialAid a string representing the added percentFinancialAid of the University
   * @param numApplicants a string representing the added numApplicants of the University
   * @param percentAdmitted a string representing the added percentAdmitted of the University
   * @param percentEnrolled a string representing the added percentEnrolled of the University
   * @param academicScale a string representing the addded academicScale of the University
   * @param socialScale a string representing the added socialScale of the University
   * @param qualityOfLifeScale a string representing the added qualityOfLifeScale of the University
   * @param emphases an ArrayList<String> representing the added emphases of the University
   * 
   * @return -1 if unsucessfull, 0 otherwise
   */
  public int addUniversity(String name, String state, String location, String control, String numStudents, String percentFemale, String SATVerbal, String SATMath,
         String expenses, String percentFinancialAid, String numApplicants, String percentAdmitted, String percentEnrolled,
                             String academicScale, String socialScale, String qualityOfLifeScale, ArrayList<String> emphases)
  {
	  if(name.equals(""))
		  throw new IllegalArgumentException();
	  if(state.equals(""))
		  	state = "-1";
	  if(location.equals(""))
		  	location = "-1";
	  if(control == null || control.equals(""))
		  	control = "Public";
	  if(numStudents.equals(""))
		  	numStudents = "-1";
	  if(percentFemale.equals(""))
		  	percentFemale = "-1";
	  if(SATVerbal.equals(""))
		  	SATVerbal = "-1";
	  if(SATMath.equals(""))
		  	SATMath = "-1";
	  if(expenses.equals(""))
		  	expenses = "-1";
	  if(percentFinancialAid.equals(""))
		  	percentFinancialAid = "-1";
	  if(numApplicants.equals(""))
		  	numApplicants = "-1";
	  if(percentAdmitted.equals(""))
		  	percentAdmitted = "-1";
	  if(percentEnrolled.equals(""))
		  	percentEnrolled = "-1";
	  if(academicScale == null || academicScale.equals(""))
		  	academicScale = "-1";
	  if(socialScale == null || socialScale.equals(""))
		  	socialScale = "-1";
	  if(qualityOfLifeScale == null || qualityOfLifeScale.equals(""))
		  	qualityOfLifeScale = "-1";
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