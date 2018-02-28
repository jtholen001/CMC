/**
 * Class that will emcompass all the functionalities relating to searching
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/27/18
 */
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;

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
   */
  public ArrayList<University> searchUniversities(String name, String state, String location, String control, int numStudentsLower, int numStudentsUpper, int percentFemaleLower, int percentFemaleUpper,
                                 int SATVerbalLower, int SATVerbalUpper, int SATMathLower, int SATMathUpper, int expensesLower, int expensesUpper, int numApplicantsLower, int numApplicantsUpper,
                                 int academicScaleLower, int academicScaleUpper, int socialScaleLower, int socialScaleUpper, int qualityOfLifeScaleLower, int qualityOfLifeScaleUpper,  
                                 double percentFinancialAidLower, double percentFinancialAidUpper, double percentAdmittedLower, double percentAdmittedUpper, double percentEnrolledLower, 
                                 double percentEnrolledUpper, ArrayList<String> searchEmphases)
  {
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
          if ((numStudentsLower <= currentUniversity.getNumStudents()) && (numStudentsUpper >= currentUniversity.getNumStudents()))
        {        
          match++;
        }      
          else if (numStudentsLower == 0 && numStudentsUpper >=  currentUniversity.getNumStudents())
          {
            match++; 
          }
          else if (numStudentsUpper == 0 && numStudentsLower <=  currentUniversity.getNumStudents())
          {
            match++; 
          }
          else if (numStudentsLower == 0 && numStudentsUpper == 0)
          {
            match++; 
          }
          //checks the percent female bound 
        case 5:
          if ((percentFemaleLower <= currentUniversity.getPercentFemale()) && (percentFemaleUpper >= currentUniversity.getPercentFemale()))
        {        
          match++;
        }      
          else if (percentFemaleLower == 0 && percentFemaleUpper >=  currentUniversity.getPercentFemale())
          {
            match++; 
          }
          else if (percentFemaleUpper == 0 && percentFemaleLower <=  currentUniversity.getPercentFemale())
          {
            match++; 
          }
          else if (percentFemaleLower == 0 && percentFemaleUpper == 0)
          {
            match++; 
          }
          //checks the SAT Verbal bound 
        case 6:
          if ((SATVerbalLower <= currentUniversity.getSATVerbal()) && (SATVerbalUpper >= currentUniversity.getSATVerbal()))
        {        
          match++;
        }      
          else if (SATVerbalLower == 0 && SATVerbalUpper >=  currentUniversity.getSATVerbal())
          {
            match++; 
          }
          else if (SATVerbalUpper == 0 && SATVerbalLower <=  currentUniversity.getSATVerbal())
          {
            match++; 
          }
          else if (SATVerbalLower == 0 && SATVerbalUpper == 0)
          {
            match++; 
          }
          //checks the SAT Math bound 
        case 7:
          if ((SATMathLower <= currentUniversity.getSATMath()) && (SATMathUpper >= currentUniversity.getSATMath()))
        {        
          match++;
        }      
          else if (SATMathLower == 0 && SATMathUpper >=  currentUniversity.getSATMath())
          {
            match++; 
          }
          else if (SATMathUpper == 0 && SATMathLower <=  currentUniversity.getSATMath())
          {
            match++; 
          }
          else if (SATMathLower == 0 && SATMathUpper == 0)
          {
            match++; 
          }
          //checks the expenses bound 
        case 8:
          if ((expensesLower <= currentUniversity.getExpenses()) && (expensesUpper >= currentUniversity.getExpenses()))
        {        
          match++;
        }      
          else if (expensesLower == 0 && expensesUpper >=  currentUniversity.getExpenses())
          {
            match++; 
          }
          else if (expensesUpper == 0 && expensesLower <=  currentUniversity.getExpenses())
          {
            match++; 
          }
          else if (expensesLower == 0 && expensesUpper == 0)
          {
            match++; 
          }
          //checks the percent financial aid bound 
        case 9:
          if ((percentFinancialAidLower <= currentUniversity.getPercentFinancialAid()) && (percentFinancialAidUpper >= currentUniversity.getPercentFinancialAid()))
        {        
          match++;
        }      
          else if (percentFinancialAidLower == 0 && percentFinancialAidUpper >=  currentUniversity.getPercentFinancialAid())
          {
            match++; 
          }
          else if (percentFinancialAidUpper == 0 && percentFinancialAidLower <=  currentUniversity.getPercentFinancialAid())
          {
            match++; 
          }
          else if (percentFinancialAidLower == 0 && percentFinancialAidUpper == 0)
          {
            match++; 
          }
          //checks the number of applicants bound 
        case 10:
          if ((numApplicantsLower <= currentUniversity.getNumApplicants()) && (numApplicantsUpper >= currentUniversity.getNumApplicants()))
        {        
          match++;
        }      
          else if (numApplicantsLower == 0 && numApplicantsUpper >=  currentUniversity.getNumApplicants())
          {
            match++; 
          }
          else if (numApplicantsUpper == 0 && numApplicantsLower <=  currentUniversity.getNumApplicants())
          {
            match++; 
          }
          else if (numApplicantsLower == 0 && numApplicantsUpper == 0)
          {
            match++; 
          }
          //checks the percent admitted bound 
        case 11:
          if ((percentAdmittedLower <= currentUniversity.getPercentAdmitted()) && (percentAdmittedUpper >= currentUniversity.getPercentAdmitted()))
        {        
          match++;
        }      
          else if (percentAdmittedLower == 0 && percentAdmittedUpper >=  currentUniversity.getPercentAdmitted())
          {
            match++; 
          }
          else if (percentAdmittedUpper == 0 && percentAdmittedLower <=  currentUniversity.getPercentAdmitted())
          {
            match++; 
          }
          else if (percentAdmittedLower == 0 && percentAdmittedUpper == 0)
          {
            match++; 
          }
          //checks the percent enrolled bound 
        case 12:
          if ((percentEnrolledLower <= currentUniversity.getPercentEnrolled()) && (percentEnrolledUpper >= currentUniversity.getPercentEnrolled()))
        {        
          match++;
        }      
          else if (percentEnrolledLower == 0 && percentEnrolledUpper >=  currentUniversity.getPercentEnrolled())
          {
            match++; 
          }
          else if (percentEnrolledUpper == 0 && percentEnrolledLower <=  currentUniversity.getPercentEnrolled())
          {
            match++; 
          }
          else if (percentEnrolledLower == 0 && percentEnrolledUpper == 0)
          {
            match++; 
          }
          //checks the academic scale bound 
        case 13:
          if ((academicScaleLower <= currentUniversity.getAcademicScale()) && (academicScaleUpper >= currentUniversity.getAcademicScale()))
        {        
          match++;
        }      
          else if (academicScaleLower == 0 && academicScaleUpper >=  currentUniversity.getAcademicScale())
          {
            match++; 
          }
          else if (academicScaleUpper == 0 && academicScaleLower <=  currentUniversity.getAcademicScale())
          {
            match++; 
          }
          else if (academicScaleLower == 0 && academicScaleUpper == 0)
          {
            match++; 
          }
          //checks the social scale bound 
        case 14:
          if ((socialScaleLower <= currentUniversity.getSocialScale()) && (academicScaleUpper >= currentUniversity.getSocialScale()))
        {        
          match++;
        }      
          else if (socialScaleLower == 0 && socialScaleUpper >=  currentUniversity.getSocialScale())
          {
            match++; 
          }
          else if (socialScaleUpper == 0 && socialScaleLower <=  currentUniversity.getSocialScale())
          {
            match++; 
          }
          else if (socialScaleLower == 0 && socialScaleUpper == 0)
          {
            match++; 
          }
          //checks the quality of life scale bound 
        case 15:
          if ((qualityOfLifeScaleLower <= currentUniversity.getQualityOfLifeScale()) && (qualityOfLifeScaleUpper >= currentUniversity.getQualityOfLifeScale()))
        {        
          match++;
        }      
          else if (qualityOfLifeScaleLower == 0 && qualityOfLifeScaleUpper >=  currentUniversity.getQualityOfLifeScale())
          {
            match++; 
          }
          else if (qualityOfLifeScaleUpper == 0 && qualityOfLifeScaleLower <=  currentUniversity.getQualityOfLifeScale())
          {
            match++; 
          }
          else if (qualityOfLifeScaleLower == 0 && qualityOfLifeScaleUpper == 0)
          {
            match++; 
          }
          //checks the emphases
        case 16:
          ArrayList<String> currentEmphases = currentUniversity.getEmphases();
          boolean atleastOneFound = false;
          if (searchEmphases.isEmpty())
          {
            match++; 
          }
          else
          {
            for (String emphasis : searchEmphases)
            {
              if (currentEmphases.contains(emphasis) && !atleastOneFound)
              {
                match++;
              } 
            }
          }   
        default:
          break;
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
   * Method to view Universitiess from searching
   * 
   * @param foundUniversities the universities to be viewed from searching
   */
  public void viewSchools(ArrayList<University> foundUniversities)
  {
    for (University u : foundUniversities)
    {
      System.out.println(u.toString()); 
    }
  }
  
  /**
   * TODO: Method might be replaced with method in StudentUniversitiesController
   * Method to view a specific university from searching
   * @param university the University to be viewed
   */
  public void viewUniversity(University university)
  {
    System.out.println(university.toString());
  }
  
  /**
   * Method to add a new University to a Student's saved universities
   * @param student the Student to whom the university needs to be added
   * @param newUniversity the University to add the a Student's saved universities
   */
  public void saveUniversity(Student student, University newUniversity)
  {
    student.addSchool(newUniversity);
    dbc.saveEditedUser(student);
  }
}
