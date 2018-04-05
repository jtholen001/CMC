/**
 * This class represents a University
 * @Author Michael Carroll, Brandan Kalsow, Nicholas Tawil, Jordan Tholen, Ryan Strelow
 * @Version 2/30/2018
 */

package entityClasses;

import java.util.ArrayList;

public class University
{
  /**
   * The name of this university
   */
  private String name;

  /**
   * The state this university is located in
   */
  private String state;

  /**
   * Whether this university is in an urban or rural location
   */
  private String location;

  /**
   * Whether this university is publicly or privately or owned
   */
  private String control;

  /**
   * The number of students enrolled at this university
   */
  private int numStudents;

  /**
   * The percentage of enrolled students that are female
   */
  private double percentFemale;

  /**
   * The average SAT Verbal score of students enrolled at the university
   */
  private double SATVerbal;

  /**
   * The average SAT Math score of students enrolled at the university
   */
  private double SATMath;

  /**
   * The average cost to attend the university
   */
  private double expenses;

  /**
   * The percentage of students enrolled at the university that recieve financial aid
   */
  private double percentFinancialAid;

  /**
   * The number of people who apply to the university
   */
  private int numApplicants;

  /**
   * The percentage of applicants who are admitted to the university
   */
  private double percentAdmitted;

  /**
   * The percentage of accepted applicants who enroll at the university
   */
  private double percentEnrolled;

  /**
   * How the university rates academically
   */
  private int academicScale;

  /**
   * How the university rates socially
   */
  private int socialScale;

  /**
   * How the quality of life at the university rates compared to other universities
   */
  private int qualityOfLifeScale;

  /**
   * The areas of study that the university emphasizes in
   */
  private ArrayList<String> emphases;

  /**
   * Creates a new instance of the University class
   *
   * @param name the name of this university as a String
   * @param state the state this university is located in as a String
   * @param location whether the university is located in and urban or rural setting
   * @param control whether this university is publicly
   * @param numStudents the number of students enrolled at this university
   * @param percentFemale the percentage of enrolled students that are female
   * @param SATVerbal the average SAT Verbal score of the students enrolled at this university
   * @param SATMath the average SAT Math score of the students enrolled at this university
   * @param expenses the cost to attend this university
   * @param percentFinancialAid the percentage of enrolled students who recieve financial aid
   * @param numApplicants the number of students that apply to this university
   * @param percentAdmitted the percent of applicants that are addmitted to this university
   * @param percentEnrolled the percent of addmitted students that enroll at this university
   * @param academicScale how this university rates academically
   * @param socialScale how this university rates socially
   * @param qualityOfLifeScale the quality of life at this university
   * @param emphases what areas of study this university emphasizes
   * 
   * @throws IllegalArgumentException
   */
  
  public University(String name,String state,String location, String control, int numStudents,
                    double percentFemale, double SATVerbal, double SATMath, double expenses, double percentFinancialAid,
                    int numApplicants, double percentAdmitted, double percentEnrolled, int academicScale, int socialScale,
                    int qualityOfLifeScale, ArrayList<String> emphases) throws IllegalArgumentException
  {
	  if(name == null || name.equals(""))
		  throw new IllegalArgumentException("Name cannot be empty");
	  if(state == null || state.equals(""))
		  throw new IllegalArgumentException("State cannot be empty");
	  if(location == null || location.equals(""))
		  throw new IllegalArgumentException("Location cannot be empty");
	  if(control == null || control.equals(""))
		  throw new IllegalArgumentException("Control cannot be empty");
	  if(emphases == null)
		  throw new IllegalArgumentException("emphases cannot be empty");
	  if(!(percentFemale >= -1 && percentFemale <= 100) || !(percentAdmitted >= -1.0 && percentAdmitted <= 100) ||
			  !(percentFinancialAid >= -1 && percentFinancialAid <= 100) ||
			  !(percentEnrolled >= -1 && percentEnrolled <= 100))
		  throw new IllegalArgumentException("Percentage cannot be less than negative one or greater than 100");
	  if(numStudents < -1)
		  throw new IllegalArgumentException("Number of students cannot be less than -1");
	  if((SATVerbal != -1) && !(SATVerbal >=100 && SATVerbal <= 800) || (SATMath != -1) && !(SATMath >=100 && SATMath <= 800))
		  throw new IllegalArgumentException("SAT scores cannot be less than negative one or greater than 800");
	  if(!(academicScale >= -1 && academicScale <= 5 && academicScale != 0) || !(socialScale >= -1 &&
			  socialScale <= 5 && socialScale != 0) || !(qualityOfLifeScale >= -1 && qualityOfLifeScale <= 5 && qualityOfLifeScale != 0))
		  throw new IllegalArgumentException("scales must be between negative 1 and five");
   this.name = name.toUpperCase();
   this.state = state.toUpperCase();
   this.location = location.toUpperCase();
   this.control = control.toUpperCase();
   this.numStudents = numStudents;
   this.percentFemale = percentFemale;
   this.SATVerbal = SATVerbal;
   this.SATMath = SATMath;
   this.expenses = expenses;
   this.percentFinancialAid = percentFinancialAid;
   this.numApplicants = numApplicants;
   this.percentAdmitted = percentAdmitted;
   this.percentEnrolled = percentEnrolled;
   this.academicScale = academicScale;
   this.socialScale = socialScale;
   this.qualityOfLifeScale = qualityOfLifeScale;
   this.emphases = emphases;
  }

  /**
   * This method gets the name of the university for use elsewhere
   *
   * @return the name of this university as a String
   */
  public String getName()
  {
    return this.name;
  }

  /**
   * This method gets the state where this university is located
   *
   * @return the state this university is located in as a String
   */
  public String getState()
  {
    return this.state;
  }

  /**
   * This method gets what setting the university is located in
   *
   * @return the location of the university (Urban or rural) as a String
   */
  public String getLocation()
  {
    return this.location;
  }

  /**
   * This method gets the control of the university
   *
   * @return the control of the university (public, private, etc) as a String
   */
  public String getControl()
  {
    return this.control;
  }

  /**
   * This method gets the number of students enrolled at the university
   *
   * @return the number of students enrolled at the university as an integer
   */
  public int getNumStudents()
  {
    return this.numStudents;
  }

  /**
   * This method gets the percentage of enrolled students that are female
   *
   * @return the percentage of students that are female as a double
   */
  public double getPercentFemale()
  {
    return this.percentFemale;
  }

  /**
   * This method gets the average SAT Verbal score of students at the university
   *
   * @return the average SAT Verbal score of students enrolled at the university as an int
   */
  public double getSATVerbal()
  {
    return this.SATVerbal;
  }

  /**
   * This method gets the average SAT Math score of students enrolled at the university
   *
   * @return the average SAT Math score of students enrolled at the university as an int
   */
  public double getSATMath()
  {
    return this.SATMath;
  }

  /**
   * This method gets the average expenses to attend the university
   *
   * @return the average expenses to attend the university as an int
   */
  public double getExpenses()
  {
    return this.expenses;
  }

  /**
   * This method gets the percentage of students enrolled at this university that recieve financial aid
   *
   * @return the percentage of students  enrolled at this university that recieve financial aid as a double
   */
  public double getPercentFinancialAid()
  {
    return this.percentFinancialAid;
  }

  /**
   * This method gets the number of students that applied to study at the university
   *
   * @return the number of students that applied to study at this university as an int
   */
  public int getNumApplicants()
  {
    return this.numApplicants;
  }

  /**
   * This method gets the number of applicants that were addmitted to the university
   *
   * @return the percentage of applicants that were accepted to the university as a double
   */
  public double getPercentAdmitted()
  {
    return this.percentAdmitted;
  }

  /**
   * This method gets the percentage of accepted applicants that enroll at the university
   *
   * @param the percentage of accepted applicants that there enrolled at the university as a double
   * 
   * @return the percentage of applicants that enroll as a double
   */
  public double getPercentEnrolled()
  {
    return this.percentEnrolled;
  }

  /**
   * This method gets how the university rates academically
   *
   * @return the academic rating of this university as an integer
   */
  public int getAcademicScale()
  {
    return this.academicScale;
  }

  /**
   * This method gets how the university rates socially
   *
   * @return the social rating of this school as an integer
   */
  public int getSocialScale()
  {
    return this.socialScale;
  }

  /**
   * This method gets how the quality of life rates at the university
   *int, int, int, 
   * @return the rating of the quality of life at the university as an integer
   */
  public int getQualityOfLifeScale()
  {
    return this.qualityOfLifeScale;
  }

  /**
   * This method gets the areas of study that this university emphasizes in
   *
   * @return the emphases of this university as an ArrayList of Strings
   */
  public ArrayList<String> getEmphases()
  {
    return this.emphases;
  }

  /**
   * This method sets the state where this university is located
   *
   * @param newState the new state this university is located in
   * 
   * @throws IllegalArgumentException
   */
  public void setState(String newState) throws IllegalArgumentException
  {
	  if(newState == null || newState.equals(""))
		throw new IllegalArgumentException("University state cannot be null");
	  else
		  this.state = newState.toUpperCase();
  }

  /**
   * This method sets what setting the university is located in
   *
   * @param newLocation the new location of the university (Urban or rural)
   * 
   * @throws IllegalArgumentException
   */
  public void setLocation(String newLocation) throws IllegalArgumentException
  {
	  if(newLocation == null || newLocation.equals(""))
		  throw new IllegalArgumentException("University Location cannot be null");
	  else
		  this.location = newLocation.toUpperCase();
  }

  /**
   * This method sets the control of the university
   *
   * @param newControl the new control of the university (public, private, etc)
   * 
   * @throws IllegalArgumentException
   */
  public void setControl(String newControl) throws IllegalArgumentException
  {
	  if(newControl == null || newControl.equals(""))
		  throw new IllegalArgumentException("University Control cannot be null");
	  else
		  this.control = newControl.toUpperCase();
  }

  /**
   * This method sets the number of students enrolled at the university
   *
   * @param newNumStudents the  new number of students enrolled at the university
   * 
   * @throws IllegalArgumentException
   */
  public void setNumStudents(int newNumStudents) throws IllegalArgumentException
  {
	  if(newNumStudents < -1)
		  throw new IllegalArgumentException("Number of students cannot be less than -1");
	 else
		 this.numStudents = newNumStudents;
  }

  /**
   * This method sets the percentage of enrolled students that are female
   *
   * @param newPercentFemale the new percentage of students that are female
   * 
   * @throws IllegalArgumentException
   */
  public void setPercentFemale(double newPercentFemale) throws IllegalArgumentException
  {
	  if(newPercentFemale < -1 || newPercentFemale > 100)
		  	throw new IllegalArgumentException("Percentages must be between zero and one hundred");
	  else
		  this.percentFemale = newPercentFemale;
  }

  /**
   * This method sets the average SAT Verbal score of students at the university
   *
   * @param newSATVerbal the new average SAT Verbal score of students enrolled at the university
   * 
   * @throws IllegalArgumentException
   */
  public void setSATVerbal(double newSATVerbal) throws IllegalArgumentException
  {
	  if(newSATVerbal < -1 || newSATVerbal > 800)
		  throw new IllegalArgumentException("SAT Scores must be between negative one and 800");
	  else
		  this.SATVerbal = newSATVerbal;
  }

  /**
   * This method sets the average SAT Math score of students enrolled at the university
   *
   * @param newSATMath the new average SAT Math score of students enrolled at the university
   * 
   * @throws IllegalArgumentException
   */
  public void setSATMath(double newSATMath) throws IllegalArgumentException
  {
	  if(newSATMath < -1 || newSATMath > 800)
		  throw new IllegalArgumentException("SAT Scores must be between negative one and 800");
	  else
		  this.SATMath = newSATMath;
  }

  /**
   * This method sets the average expenses to attend the university
   *
   * @param newExpenses the average expenses to attend the university
   * @throws IllegalArgumentException
   */
  public void setExpenses(double newExpenses) throws IllegalArgumentException
  {
	  if(newExpenses < -1)
		  throw new IllegalArgumentException("expenses cannot be less than negative one");
    this.expenses = newExpenses;
  }

  /**
   * This method sets the percentage of students enrolled at this university that recieve financial aid
   *
   * @param newPercentFinancialAid the new percentage of students  enrolled at this university that recieve financial aid
   * @throws IllegalArgumentException
   */
  public void setPercentFinancialAid(double newPercentFinancialAid) throws IllegalArgumentException
  {
	  if(newPercentFinancialAid < -1 || newPercentFinancialAid > 100)
		  throw new IllegalArgumentException("Percentages cannot be less than -1 or greater than 100");
	  else
		  this.percentFinancialAid = newPercentFinancialAid;
  }

  /**
   * This method sets the number of students that applied to study at the university
   *
   * @param newNumApplicants the new number of students that applied to study at this university
   * @throws IllegalArgumentException
   */
  public void setNumApplicants(int newNumApplicants) throws IllegalArgumentException
  {
	  if(newNumApplicants < -1)
		  throw new IllegalArgumentException("Number of applicants cannot be less than zero");
	  else
		  this.numApplicants = newNumApplicants;
  }

  /**
   * This method sets the number of applicants that were addmitted to the university
   *
   * @param newPercentAdmitted the new percentage of applicants that were accepted to the university
   * @throws IllegalArgumentException
   */
  public void setPercentAdmitted(double newPercentAdmitted) throws IllegalArgumentException
  {
	  if(newPercentAdmitted < -1 || newPercentAdmitted > 100)
		  throw new IllegalArgumentException("percentages cannot be less than -1 or greater than 100");
	  else
		this.percentAdmitted = newPercentAdmitted;
  }

  /**
   * This method sets the percentage of accepted applicants that enroll at the university
   *
   * @param newPercentEnrolled the new percentage of accepted applicants that there enrolled at the university
   * @throws IllegalArgumentException
   */
  public void setPercentEnrolled(double newPercentEnrolled) throws IllegalArgumentException
  {
	  if(newPercentEnrolled < -1 || newPercentEnrolled > 100)
		  throw new IllegalArgumentException("Percentages must be between -1 and 100");
	  else
		  this.percentEnrolled = newPercentEnrolled;
  }

  /**
   * This method sets how the university rates academically
   *
   * @param newAcademicScale the new academic rating of this university
   * @throws IllegalArgumentException
   */
  public void setAcademicScale(int newAcademicScale) throws IllegalArgumentException
  {
	  if(newAcademicScale < -1 || newAcademicScale > 5)
		  throw new IllegalArgumentException("Scales must be between -1 and 5");
	  else
		  this.academicScale = newAcademicScale;
  }

  /**
   * This method sets how the university rates socially
   *
   * @param newSocialScale the new social rating of this school
   * @throws IllegalArgumentException
   */
  public void setSocialScale(int newSocialScale) throws IllegalArgumentException
  {
	  if(newSocialScale < -1 || newSocialScale > 5)
		  throw new IllegalArgumentException("Scales must be between -1 and 5");
	  else
		  this.socialScale = newSocialScale;
  }

  /**
   * This method sets how the quality of life rates at the university
   *
   * @param newQualityOfLifeScale the new rating of the quality of life at the university
   * @throws IllegalArgumentException
   */
  public void setQualityOfLifeScale(int newQualityOfLifeScale) throws IllegalArgumentException
  {
	  if(newQualityOfLifeScale < -1 || newQualityOfLifeScale > 5)
		  throw new IllegalArgumentException("Scales must be between -1 and 5");
	  else
		  this.qualityOfLifeScale = newQualityOfLifeScale;
  }

  /**
   * This method sets the areas of study that this university emphasizes in
   *
   * @param newEmphases the new emphases of this university
   * @throws IllegalArgumentException
   */
  public void setEmphases(ArrayList<String> newEmphases) throws IllegalArgumentException
  {
	  if(newEmphases == null)
		  throw new IllegalArgumentException("Emphases cannot be null");
	  else
		  this.emphases = newEmphases;
  }

  /**
   * Method to display a University's data
   * @return a concatenated string representing a University and its attributes
   */
  @Override
  public String toString()
  {
    return ("name: " + this.getName() + "\n" +
           "state: " + this.getState() + "\n" +
           "location: " + this.getLocation() + "\n" +
           "control: " + this.getControl() + "\n" +
           "numStudents: " + this.getNumStudents() + "\n" +
           "percentFemale: " + this.getPercentFemale() + "\n" +
           "SATVerbal: " + this.getSATVerbal() + "\n" +
           "SATMath: " + this.getSATMath() + "\n" +
           "expenses: " + this.getExpenses() + "\n" +
           "percentFinancialAid: " + this.getPercentFinancialAid() + "\n" +
           "numApplicants: " + this.getNumApplicants() + "\n" +
           "percentAdmitted: " + this.getPercentAdmitted() + "\n" +
           "percentEnrolled: " + this.getPercentEnrolled() + "\n" +
           "academicScale: " + this.getAcademicScale() + "\n" +
           "socialScale: " + this.getSocialScale() + "\n" +
           "qualityOfLifeScale: " + this.getQualityOfLifeScale() + "\n" +
           "emphases: " + this.getEmphases());
  }

@Override
public boolean equals(Object obj)
{
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (!(obj instanceof University))
		return false;
	University other = (University) obj;
	if (Double.doubleToLongBits(SATMath) != Double.doubleToLongBits(other.SATMath))
		return false;
	if (Double.doubleToLongBits(SATVerbal) != Double.doubleToLongBits(other.SATVerbal))
		return false;
	if (academicScale != other.academicScale)
		return false;
	if (control == null) {
		if (other.control != null)
			return false;
	} else if (!control.equals(other.control))
		return false;
	if (emphases == null) {
		if (other.emphases != null)
			return false;
	} else if (!emphases.equals(other.emphases))
		return false;
	if (Double.doubleToLongBits(expenses) != Double.doubleToLongBits(other.expenses))
		return false;
	if (location == null) {
		if (other.location != null)
			return false;
	} else if (!location.equals(other.location))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (numApplicants != other.numApplicants)
		return false;
	if (numStudents != other.numStudents)
		return false;
	if (Double.doubleToLongBits(percentAdmitted) != Double.doubleToLongBits(other.percentAdmitted))
		return false;
	if (Double.doubleToLongBits(percentEnrolled) != Double.doubleToLongBits(other.percentEnrolled))
		return false;
	if (Double.doubleToLongBits(percentFemale) != Double.doubleToLongBits(other.percentFemale))
		return false;
	if (Double.doubleToLongBits(percentFinancialAid) != Double.doubleToLongBits(other.percentFinancialAid))
		return false;
	if (qualityOfLifeScale != other.qualityOfLifeScale)
		return false;
	if (socialScale != other.socialScale)
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	return true;
}
}
