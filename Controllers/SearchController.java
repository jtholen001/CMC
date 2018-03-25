/**
 * Class that will emcompass all the functionalities relating to searching
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/27/18
 */
package Controllers;

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import entityClasses.*;

public class SearchController
{ 
  /**
   * DBController that will be accessed by the SearchController
   */
  private DBController dbc;
  
  /**
   * Constructor for a SearchController
   * 
   */
  public SearchController()
  {
    this.dbc = new DBController(); 
  }
  
  /**
   * Method to search for universities
   * 
   * @param name the name of this university as a String
   * @param state the state this university is located in as a String
   * @param location  whether the university is located in and urban or rural setting
   * @param control  whether this university is publicly
   * @param numStudentsLower  the lower bound of number of students
   * @param numStudentsUpper  the upper bound of number of students
   * @param percentFemaleLower  the lower bound of the percentage of enrolled students that are female
   * @param percentFemaleUpper  the upper bound of the percentage of enrolled students that are female
   * @param SATVerbalLower  the lower bound of the average SAT Verbal score of the students enrolled at this university
   * @param SATVerbalUpper  the upper bound of the average SAT Verbal score of the students enrolled at this university
   * @param SATMathLower the lower bound of the average SAT Math score of the students enrolled at this university
   * @param SATMathUpper the upper bound of the average SAT Math score of the students enrolled at this university
   * @param expensesLower  the lower bound of the cost to attend this university
   * @param expensesUpper  the upper bound of the cost to attend this university
   * @param numApplicantsLower  the lower bound of the number of students that apply to this university
   * @param numApplicantsUpper  the upper bound of the number of students that apply to this university
   * @param academicScaleLower the lower bound of how this university rates academically 
   * @param academicScaleUpper the upper bound of how this university rates academically
   * @param socialScaleLower  the lower bound of how this university rates socially
   * @param socialScaleUpper  the upper bound of how this university rates socially
   * @param qualityOfLifeScaleLower  the lower bound of the quality of life at this university
   * @param qualityOfLifeScaleUpper  the upper bound of the quality of life at this university
   * @param percentFinancialAidLower  the lower bound of the percentage of enrolled students who recieve financial aid
   * @param percentFinancialAidUpper  the upper bound of the percentage of enrolled students who recieve financial aid
   * @param percentAdmittedLower  the lower bound of the percent of applicants that are addmitted to this university
   * @param percentAdmittedUpper  the upper bound of the percent of applicants that are addmitted to this university
   * @param percentEnrolledLower  the lower bound of the percent of addmitted students that enroll at this university
   * @param percentEnrolledUpper  the upper bound of the percent of addmitted students that enroll at this university
   * @param searchEmphases  areas of study
   * @return ArrayList<University>  found Universities
   */
  public ArrayList<University> searchUniversities(String name, String state, String location, String control, int numStudentsLower, int numStudentsUpper, int percentFemaleLower, int percentFemaleUpper,
                                 int SATVerbalLower, int SATVerbalUpper, int SATMathLower, int SATMathUpper, int expensesLower, int expensesUpper, int numApplicantsLower, int numApplicantsUpper,
                                 int academicScaleLower, int academicScaleUpper, int socialScaleLower, int socialScaleUpper, int qualityOfLifeScaleLower, int qualityOfLifeScaleUpper,  
                                 double percentFinancialAidLower, double percentFinancialAidUpper, double percentAdmittedLower, double percentAdmittedUpper, double percentEnrolledLower, 
                                 double percentEnrolledUpper, ArrayList<String> searchEmphases)
  {
	if (name == null && state == null && location == null && control == null &&
			numStudentsLower == 0 && numStudentsUpper == 0 && percentFemaleLower == 0 && percentFemaleUpper == 0 &&
			SATVerbalLower == 0 && SATVerbalUpper==0 && SATMathLower == 0 && SATMathUpper == 0 && expensesLower == 0 &&
			expensesUpper ==0 && numApplicantsLower == 0 && numApplicantsUpper == 0 && academicScaleLower == 0 && academicScaleUpper == 0 &&
			socialScaleLower == 0 && socialScaleUpper == 0 && qualityOfLifeScaleLower == 0 && qualityOfLifeScaleUpper == 0 &&
			percentFinancialAidLower == 0 && percentFinancialAidUpper == 0 && percentAdmittedLower == 0 && percentAdmittedUpper == 0 &&
			percentEnrolledLower == 0 && percentEnrolledUpper == 0 && searchEmphases == null)
	{
		return null;	
	}
    //HashMap containing all the universities in the database
    HashMap<String, University> universities = dbc.viewUniversities();
    
    //Set containing all the names of the universities in the database
    Set<String> universityNames = universities.keySet();
    
    //ArrayList to keep track of universities that match search criteria
    ArrayList<University> foundUniversities = new ArrayList<University>();
    
    for (String u : universityNames)
    {
      int match = 0;
      University currentUniversity = universities.get(u);
      
      switch (match)
      {
        //checks the name 
        case 0:
          if (name == null || u.contains(name))
        {
          match++; 
        }
          //checks the state
        case 1:
          if (state == null || currentUniversity.getState().contains(state))
        {
          match++; 
        }
          //checks the location 
        case 2:
          if (location == null || currentUniversity.getLocation().equals(location))
        {
          match++; 
        }
          //checks the control 
        case 3:
          if (control == null || currentUniversity.getControl().equals(control))
        {
          match++; 
        }
          //checks the number of students bound 
        case 4:
         match += compareStats(currentUniversity.getNumStudents(), numStudentsLower, numStudentsUpper);
          //checks the percent female bound 
        case 5:
         match += compareStats(currentUniversity.getPercentFemale(), percentFemaleLower, percentFemaleUpper);        
          //checks the SAT Verbal bound 
        case 6:
         match += compareStats(currentUniversity.getSATVerbal(), SATVerbalLower, SATVerbalUpper);
          //checks the SAT Math bound 
        case 7:
         match += compareStats(currentUniversity.getSATMath(), SATMathLower, SATMathUpper);
          //checks the expenses bound 
        case 8:
            match += compareStats(currentUniversity.getExpenses(), expensesLower, expensesUpper);
          //checks the percent financial aid bound 
        case 9:
            match += compareStats(currentUniversity.getPercentFinancialAid(), percentFinancialAidLower, percentFinancialAidUpper);
          //checks the number of applicants bound 
        case 10:
            match += compareStats(currentUniversity.getNumApplicants(), numApplicantsLower, numApplicantsUpper);
          //checks the percent admitted bound 
        case 11:
            match += compareStats(currentUniversity.getPercentAdmitted(), percentAdmittedLower, percentAdmittedUpper);
          //checks the percent enrolled bound 
        case 12:
            match += compareStats(currentUniversity.getPercentEnrolled(), percentEnrolledLower, percentEnrolledUpper);
          //checks the academic scale bound 
        case 13:
            match += compareStats(currentUniversity.getAcademicScale(), academicScaleLower, academicScaleUpper);
          //checks the social scale bound 
        case 14:
            match += compareStats(currentUniversity.getSocialScale(), socialScaleLower, socialScaleUpper);
          //checks the quality of life scale bound 
        case 15:
            match += compareStats(currentUniversity.getQualityOfLifeScale(), qualityOfLifeScaleLower, qualityOfLifeScaleUpper);
          //checks the emphases
        case 16:
          ArrayList<String> currentEmphases = currentUniversity.getEmphases();
          boolean atleastOneFound = false;
          if (searchEmphases == null || searchEmphases.isEmpty())
            match++; 
          else
          {
            for (String emphasis : searchEmphases)
            {
              if (currentEmphases.contains(emphasis) && !atleastOneFound)
                match++; 
            }
          }   
      }  
      //only if a university 'matches' all criteria will it be added
      //if the user does not put anything in a field it counts as a match for that particular field
      if (match == 17)
      {
        foundUniversities.add(currentUniversity);
      }  
    }
    return foundUniversities;
  }
  
  /**
   * helper method for comparing search criteria to universities in the database
   * @param currentSchoolValue  the value associated with the current university you are comparing
   * @param lower  the lower bound entered in the search criteria
   * @param upper  the upper bound entered in the search criteria
   * @return an int if the university matches the criteria
   */
  private int compareStats(double currentSchoolValue, double lower, double upper)
  {
      if ((lower <= currentSchoolValue) && (upper >= currentSchoolValue))       
       return 1;          
      else if (lower == 0 && upper >=  currentSchoolValue)    
       return 1;           
      else if (upper == 0 && lower <=  currentSchoolValue)
       return 1; 
      else if (lower == 0 && upper == 0)
       return 1;
   return 0;
  }
  
  /**
   * helper method for comparing search criteria to universities in the database
   * @param currentSchoolValue  the value associated with the current university you are comparing
   * @param lower  the lower bound entered in the search criteria
   * @param upper  the upper bound entered in the search criteria
   * @return an int if the university matches the criteria
   */ 
  private int compareStats(int currentSchoolValue, int lower, int upper)
  {
      if ((lower <= currentSchoolValue) && (upper >= currentSchoolValue))       
       return 1;          
      else if (lower == 0 && upper >=  currentSchoolValue)    
       return 1;           
      else if (upper == 0 && lower <=  currentSchoolValue)
       return 1; 
      else if (lower == 0 && upper == 0)
       return 1;
   return 0;
  }
  
  
  /**
   * method to get the recommended universities based off of a university
   *
   * @param university the university object to base the other schools off of
   *
   * @return an ArrayList of university objects
   */
  public ArrayList<University> getRecommendedUniversities(University university)
  {
   return dbc.getRecommendedUniversities(university);
 
  }
  
  /**
   * Method to view Universities from searching
   * 
   * @param foundUniversities the universities to be viewed from searching
   * @return a String representing all the schools to be viewed
   */
  public String viewSchools(ArrayList<University> foundUniversities)
  {
 String schools = ""; 
    for (University u : foundUniversities)
    {
      schools += u.toString() + '\n';
    }
    return schools;
  }
  
  /**
   * Method to view a specific university from searching
   * @param university the University to be viewed
   * @return a String representation of the University
   */
  public String viewUniversity(University university)
  {
    return university.toString();
  }
  
  /**
   * Method to add a new University to a Student's saved universities
   * @param student the Student to whom the university needs to be added
   * @param newUniversity the University to add the a Student's saved universities
   * @return integer representing success of save
   */
  public int saveUniversity(Student student, University newUniversity)
  {
    int success = student.addSchool(newUniversity);
    if (success == 1)
    	dbc.saveEditedUser(student);
    return success;
  }
}
