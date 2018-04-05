/**
 * Class that will emcompass all the functionalities relating to searching
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/27/18
 */
package Controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

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
	 * @param percentFinancialAidLower  the lower bound of the percentage of enrolled students who receive financial aid
	 * @param percentFinancialAidUpper  the upper bound of the percentage of enrolled students who receive financial aid
	 * @param numApplicantsLower  the lower bound of the number of students that apply to this university
	 * @param numApplicantsUpper  the upper bound of the number of students that apply to this university
	 * @param percentAdmittedLower  the lower bound of the percent of applicants that are addmitted to this university
	 * @param percentAdmittedUpper  the upper bound of the percent of applicants that are addmitted to this university
	 * @param percentEnrolledLower  the lower bound of the percent of addmitted students that enroll at this university
	 * @param percentEnrolledUpper  the upper bound of the percent of addmitted students that enroll at this university
	 * @param academicScaleLower the lower bound of how this university rates academically 
	 * @param academicScaleUpper the upper bound of how this university rates academically
	 * @param socialScaleLower  the lower bound of how this university rates socially
	 * @param socialScaleUpper  the upper bound of how this university rates socially
	 * @param qualityOfLifeScaleLower  the lower bound of the quality of life at this university
	 * @param qualityOfLifeScaleUpper  the upper bound of the quality of life at this university
	 * @param searchEmphases  areas of study
	 * @return ArrayList<University>  found Universities
	 */
	public ArrayList<University> searchUniversities(String name, String state, String location, String control, int numStudentsLower, int numStudentsUpper, double percentFemaleLower, double percentFemaleUpper,
			double SATVerbalLower, double SATVerbalUpper, double SATMathLower, double SATMathUpper, double expensesLower, double expensesUpper, double percentFinancialAidLower, double percentFinancialAidUpper, 
			int numApplicantsLower, int numApplicantsUpper, double percentAdmittedLower, double percentAdmittedUpper, double percentEnrolledLower, double percentEnrolledUpper, 
			int academicScaleLower, int academicScaleUpper, int socialScaleLower, int socialScaleUpper, int qualityOfLifeScaleLower, int qualityOfLifeScaleUpper,  
		  ArrayList<String> searchEmphases) throws IllegalArgumentException
	{
		//If 1
		if (name == null && state == null && location == null && control == null &&
				numStudentsLower == 0 && numStudentsUpper == 0 && percentFemaleLower == 0 && percentFemaleUpper == 0 &&
				SATVerbalLower == 0 && SATVerbalUpper==0 && SATMathLower == 0 && SATMathUpper == 0 && expensesLower == 0 &&
				expensesUpper ==0 && numApplicantsLower == 0 && numApplicantsUpper == 0 && academicScaleLower == 0 && academicScaleUpper == 0 &&
				socialScaleLower == 0 && socialScaleUpper == 0 && qualityOfLifeScaleLower == 0 && qualityOfLifeScaleUpper == 0 &&
				percentFinancialAidLower == 0 && percentFinancialAidUpper == 0 && percentAdmittedLower == 0 && percentAdmittedUpper == 0 &&
				percentEnrolledLower == 0 && percentEnrolledUpper == 0 && searchEmphases == null)
		{
			throw new IllegalArgumentException("All fields cannot be empty");
		}
		//HashMap containing all the universities in the database
		HashMap<String, University> universities = this.dbc.viewUniversities();

		//Set containing all the names of the universities in the database
		Set<String> universityNames = universities.keySet();

		//ArrayList to keep track of universities that match search criteria
		ArrayList<University> foundUniversities = new ArrayList<University>();

		//For 1
		for (String u : universityNames)
		{
			University currentUniversity = universities.get(u);

			boolean matched = false;
			//If 2
			if ((name == null || u.contains(name)) && (state == null || currentUniversity.getState().contains(state)) && (location == null || currentUniversity.getLocation().equals(location)) &&
					(control == null || currentUniversity.getControl().equals(control)) && compareStats(currentUniversity.getNumStudents(), numStudentsLower, numStudentsUpper) == 1 &&
					compareStats(currentUniversity.getPercentFemale(), percentFemaleLower, percentFemaleUpper) == 1 && compareStats(currentUniversity.getSATVerbal(), SATVerbalLower, SATVerbalUpper) == 1 &&
					compareStats(currentUniversity.getSATMath(), SATMathLower, SATMathUpper) == 1 && compareStats(currentUniversity.getExpenses(), expensesLower, expensesUpper) == 1 &&
					compareStats(currentUniversity.getPercentFinancialAid(), percentFinancialAidLower, percentFinancialAidUpper) == 1 && compareStats(currentUniversity.getNumApplicants(), numApplicantsLower, numApplicantsUpper) == 1 &&
					compareStats(currentUniversity.getPercentAdmitted(), percentAdmittedLower, percentAdmittedUpper) == 1 && compareStats(currentUniversity.getPercentEnrolled(), percentEnrolledLower, percentEnrolledUpper) == 1 &&
					compareStats(currentUniversity.getAcademicScale(), academicScaleLower, academicScaleUpper) == 1 && compareStats(currentUniversity.getSocialScale(), socialScaleLower, socialScaleUpper) == 1 && 
					compareStats(currentUniversity.getQualityOfLifeScale(), qualityOfLifeScaleLower, qualityOfLifeScaleUpper) == 1)
			{
				ArrayList<String> currentEmphases = currentUniversity.getEmphases();
				//If 3
				if (searchEmphases == null)
					matched = true; 
				else
				{
					//For 2
					for (String emphasis : searchEmphases)
					{
						//If 4
						if (currentEmphases.contains(emphasis))
							matched = true; 
					}
				}	
			}	  
			//only if a university 'matches' all criteria will it be added
			//if the user does not put anything in a field it counts as a match for that particular field
			//If 5
			if (matched)
				foundUniversities.add(currentUniversity);			  
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
		if (lower == 0 && upper == 0)      
			return 1;          
		else if (lower == 0 && upper >=  currentSchoolValue)    
			return 1;           
		else if (upper == 0 && lower <=  currentSchoolValue)
			return 1; 
		else if ((lower <= currentSchoolValue) && (upper >= currentSchoolValue))
			return 1;
		return 0;
	}

	/**
	 * method to get the recommended universities based off of a university
	 *
	 * @param u the university object to base the other schools off of
	 *
	 * @return an ArrayList of university objects similar to the provided university
	 */
	public ArrayList<University> getRecommendedUniversities(University u)
	{
		HashMap<String, University> universityMap = this.dbc.viewUniversities();
		Set<String> keys = universityMap.keySet();
		HashMap<String, Double> distanceMap = new HashMap<String, Double>();

		int maxNumStudents = u.getNumStudents();
		int minNumStudents = u.getNumStudents();
		double maxPercentFemale = u.getPercentFemale();
		double minPercentFemale = u.getPercentFemale();
		double maxSATVerbal = u.getSATVerbal();
		double minSATVerbal = u.getSATVerbal();
		double maxSATMath = u.getSATMath();
		double minSATMath = u.getSATMath();
		double maxExpenses = u.getExpenses();
		double minExpenses = u.getExpenses();
		double maxPercentFinancialAid = u.getPercentFinancialAid();
		double minPercentFinancialAid = u.getPercentFinancialAid();
		int maxNumApplicants = u.getNumApplicants();
		int minNumApplicants = u.getNumApplicants();
		double maxPercentAdmitted = u.getPercentAdmitted();
		double minPercentAdmitted = u.getPercentAdmitted();
		double maxPercentEnrolled = u.getPercentEnrolled();
		double minPercentEnrolled = u.getPercentEnrolled();
		int maxAcademicScale = u.getAcademicScale();
		int minAcademicScale = u.getAcademicScale();
		int maxSocialScale = u.getSocialScale();
		int minSocialScale = u.getSocialScale();
		int maxQualityOfLifeScale = u.getQualityOfLifeScale();
		int minQualityOfLifeScale = u.getQualityOfLifeScale();


		for (String universityName : keys)
		{
			University university = universityMap.get(universityName);

			maxNumStudents = (int)findMax(university.getNumStudents(), maxNumStudents);
			minNumStudents = (int)findMin(university.getNumStudents(), minNumStudents);

			maxPercentFemale = findMax(university.getPercentFemale(), maxPercentFemale);
			minPercentFemale = findMin(university.getPercentFemale(), minPercentFemale);

			maxSATVerbal = findMax(university.getSATVerbal(), maxSATVerbal);
			minSATVerbal = findMin(university.getSATVerbal(), minSATVerbal);	      

			maxSATMath = findMax(university.getSATMath(), maxSATMath);
			minSATMath = findMin(university.getSATMath(), minSATMath);

			maxExpenses = findMax(university.getExpenses(), maxExpenses);
			minExpenses = findMin(university.getExpenses(), minExpenses);

			maxPercentFinancialAid = findMax(university.getPercentFinancialAid(), maxPercentFinancialAid);
			minPercentFinancialAid = findMin(university.getPercentFinancialAid(), minPercentFinancialAid);	      

			maxNumApplicants = (int)findMax(university.getNumApplicants(), maxNumApplicants);
			minNumApplicants = (int)findMin(university.getNumApplicants(), minNumApplicants);	      

			maxPercentAdmitted = findMax(university.getPercentAdmitted(), maxPercentAdmitted);
			minPercentAdmitted = findMin(university.getPercentAdmitted(), minPercentAdmitted);	      

			maxPercentEnrolled = findMax(university.getPercentEnrolled(), maxPercentEnrolled);
			minPercentEnrolled = findMin(university.getPercentEnrolled(), minPercentEnrolled);	    	      

			maxAcademicScale = (int)findMax(university.getAcademicScale(), maxAcademicScale);
			minAcademicScale = (int)findMin(university.getAcademicScale(), minAcademicScale);	  	      

			maxSocialScale = (int)findMax(university.getSocialScale(), maxSocialScale);
			minSocialScale = (int)findMin(university.getSocialScale(), minSocialScale);	  	      

			maxQualityOfLifeScale = (int)findMax(university.getQualityOfLifeScale(), maxQualityOfLifeScale);
			minQualityOfLifeScale = (int)findMin(university.getQualityOfLifeScale(), minQualityOfLifeScale);	  	      	      

			// emphases
		}

		int stateDistance, locationDistance, controlDistance;
		// Finds distances between all instance variables in parameter University with corresponding variables of all universities in database
		for (String universityName : keys)
		{
			// if universityName != parameter?
			if (!(u.getName().equals(universityName))) // University u can't recommend itself
			{
				// Compares state name of parameter University with universities in database
				if (universityMap.get(universityName).getState().equals(u.getState()))
					stateDistance = 0; // state names equal
				else
					stateDistance = 1; // state names not equal

				// Compares location String of parameter University with universities in database
				if (universityMap.get(universityName).getState().equals(u.getState()))
					locationDistance = 0; // location equal
				else
					locationDistance = 1; // location not equal

				// Compares control String of parameter University with universities in database
				if (universityMap.get(universityName).getControl().equals(u.getControl()))
					controlDistance = 0; // control equal
				else
					controlDistance = 1; // control not equal

				double numStudentsDistance, percentFemaleDistance, SATVerbalDistance, SATMathDistance,expensesDistance, percentFinancialAidDistance,
				numApplicantsDistance, percentAdmittedDistance, percentEnrolledDistance, academicScaleDistance, socialScaleDistance, qualityOfLifeScaleDistance;

				numStudentsDistance = calculateDistance(u.getNumStudents(), universityMap.get(universityName).getNumStudents(), maxNumStudents, minNumStudents);
				percentFemaleDistance = calculateDistance(u.getPercentFemale(), universityMap.get(universityName).getPercentFemale(), maxPercentFemale, minPercentFemale);
				SATVerbalDistance = calculateDistance(u.getSATVerbal(), universityMap.get(universityName).getSATVerbal(), maxSATVerbal, minSATVerbal);
				SATMathDistance = calculateDistance(u.getSATMath(), universityMap.get(universityName).getSATMath(), maxSATMath, minSATMath);
				expensesDistance = calculateDistance(u.getExpenses(), universityMap.get(universityName).getExpenses(), maxExpenses, minExpenses);
				percentFinancialAidDistance = calculateDistance(u.getPercentFinancialAid(), universityMap.get(universityName).getPercentFinancialAid(), maxPercentFinancialAid, minPercentFinancialAid);	        
				numApplicantsDistance = calculateDistance(u.getNumApplicants(), universityMap.get(universityName).getNumApplicants(), maxNumApplicants, minNumApplicants);	        
				percentAdmittedDistance = calculateDistance(u.getPercentAdmitted(), universityMap.get(universityName).getPercentAdmitted(), maxPercentAdmitted, minPercentAdmitted);	     
				percentEnrolledDistance = calculateDistance(u.getPercentEnrolled(), universityMap.get(universityName).getPercentEnrolled(), maxPercentEnrolled, minPercentEnrolled);
				academicScaleDistance = calculateDistance(u.getAcademicScale(), universityMap.get(universityName).getAcademicScale(), maxAcademicScale, minAcademicScale);
				socialScaleDistance = calculateDistance(u.getSocialScale(), universityMap.get(universityName).getSocialScale(), maxSocialScale, minSocialScale);
				qualityOfLifeScaleDistance = calculateDistance(u.getQualityOfLifeScale(), universityMap.get(universityName).getQualityOfLifeScale(), maxQualityOfLifeScale, minQualityOfLifeScale);

				ArrayList<String> emphases = u.getEmphases();

				int count = 0;
				for (String emphasis : emphases)
				{
					//if the potentially recommended school does not contain an emphasis
					if (!universityMap.get(universityName).getEmphases().contains(emphasis))
						count++; 	  
				}
				double emphasesDistance = 0;
				if (!emphases.isEmpty())
				 emphasesDistance = count/emphases.size();

				double totalDistance = stateDistance + locationDistance + controlDistance + numStudentsDistance + percentFemaleDistance + SATVerbalDistance +
						SATMathDistance + expensesDistance + percentFinancialAidDistance + numApplicantsDistance + percentAdmittedDistance + percentEnrolledDistance +
						academicScaleDistance + socialScaleDistance + qualityOfLifeScaleDistance + emphasesDistance;

				distanceMap.put(universityName, totalDistance);
			}
		}

		// sorts distance map by value in ascending order, adds universityNames to ArrayList to return
		List<Double> sortedValues = new ArrayList<Double>(distanceMap.values());
		Collections.sort(sortedValues);
		Iterator<Double> values = sortedValues.iterator();

		ArrayList<University> recommendedUniversities = new ArrayList<University>();
		
		//ArrayList<Double, University> recommendedUniversities = new HashMap<Double, University>();
		
		while (values.hasNext() && (recommendedUniversities.size() <5))
		{
			double temp = values.next();
			for (String universityName : keys)
				{
					if (!(u.getName().equals(universityName)))
					{
						if (distanceMap.get(universityName) == temp)
						{
							recommendedUniversities.add(dbc.getUniversity(universityName));
							distanceMap.put(universityName,  -1.0);
						}
					}
				}
		}
		return recommendedUniversities;
	}

	/**
	 * Method to find the min between two university values
	 * 
	 * @param possibleMin  a value that could replace the current min
	 * @param currentMin  the current min value 
	 * @return a int representing the new min
	 */
	private double findMin(double possibleMin, double currentMin)
	{
		if (currentMin == -1) 
			return possibleMin;
		else if (possibleMin != -1 && possibleMin < currentMin)
			return possibleMin;	    
		return currentMin;	    	
	}

	/**
	 * Method to find the max between two university values
	 * 
	 * @param possibleMax  a value that could replace the current max
	 * @param currentMax  the current max value 
	 * @return a int representing the new max
	 */
	private double findMax(double possibleMax, double currentMax)
	{
		if (possibleMax > currentMax)
			return possibleMax;
		return currentMax;
	}

	/**
	 * Method to calculate the distance between two values
	 * 
	 * @param sourceValue  the value from the original University
	 * @param matchValue  the value being calculated against the source value
	 * @param max  the maximum value taken from all the Universities
	 * @param min  the minimum value taken from all the Universities
	 * @return a int representing the distance between the two values
	 */	  
	private double calculateDistance(double sourceValue, double matchValue, double max, double min)
	{
		if(matchValue != -1 && sourceValue != -1)
			return (Math.abs(matchValue - sourceValue) / Math.abs(max - min));
		return 0;
	}	  

	/**
	 * Method to view Universities from searching
	 * 
	 * @param foundUniversities the universities to be viewed from searching
	 * @return a HashMap representing all the schools to be viewed
	 */
	public HashMap<String, University> viewUniversities(ArrayList<University> foundUniversities)
	{
		HashMap<String, University> universities = new HashMap<String, University>();
		for (University u: foundUniversities)
		{
			universities.put(u.getName(), u);
		}
		return universities;
	}

	/**
	 * Method to view a specific university from searching
	 * @param universityName  the name of the university to be viewed
	 * @return a Unviersity
	 */
	public University viewUniversity(String universityName)
	{
		return this.dbc.getUniversity(universityName);
	}

	/**
	 * Method to add a new University to a Student's saved universities
	 * @param student the Student to whom the university needs to be added
	 * @param newUniversity the University to add the a Student's saved universities
	 * @return integer representing success of save
	 */
	public int saveUniversity(Student student, University newUniversity)
	{
		try {
			student.addSchool(newUniversity);
			return dbc.saveEditedUser(student);
		}
		catch (IllegalArgumentException iae) {}
		return -1;
	}
}
