/**
 * Class that will emcompass all the functionalities relating to searching
 * 
 * @author Michael Carroll, Nicholas Tawil, Brandan Kalsow, Jordan Tholen, Ryan Strelow
 * @version 2/27/18
 */
package cmcPackage.Controllers;

import java.util.HashMap;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

import cmcPackage.entityClasses.*;

public class SearchController
{ 
	/**
	 * DBController that will be accessed by the SearchController
	 */
	private DBController dbc;
	
	/**
	 * HashMap containing all the universities in the database
	 */
	HashMap<String, University> universities;

	/**
	 * Set containing all the names of the universities in the database
	 */
	Set<String> universityNames;
	
	/**
	 * Constructor for a SearchController
	 * 
	 */
	public SearchController()
	{
		this.dbc = new DBController(); 
		this.universities = this.dbc.viewUniversities();
		this.universityNames = this.universities.keySet();
	}
	
	public SearchController(DBController temp)
	{
		this.dbc = temp;
		this.universities = this.dbc.viewUniversities();
		this.universityNames = this.universities.keySet();
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
	 * 
	 * @return ArrayList<University>  found Universities
	 */
	public ArrayList<University> searchUniversities(String name, String state, String location, String control, String numStudentsLower, String numStudentsUpper, String percentFemaleLower, String percentFemaleUpper,
			String SATVerbalLower, String SATVerbalUpper, String SATMathLower, String SATMathUpper, String expensesLower, String expensesUpper, String percentFinancialAidLower, String percentFinancialAidUpper, 
			String numApplicantsLower, String numApplicantsUpper, String percentAdmittedLower, String percentAdmittedUpper, String percentEnrolledLower, String percentEnrolledUpper, 
			String academicScaleLower, String academicScaleUpper, String socialScaleLower, String socialScaleUpper, String qualityOfLifeScaleLower, String qualityOfLifeScaleUpper,  
		  ArrayList<String> searchEmphases) throws IllegalArgumentException, InputMismatchException
	{
		int intNumStudentsLower = 0;
		int intNumStudentsUpper = 0;
		double doublePercentFemaleLower = 0.0;
		double doublePercentFemaleUpper = 0.0;
		double doubleSATVerbalLower = 0.0;
		double doubleSATVerbalUpper = 0.0;
		double doubleSATMathLower = 0.0;
		double doubleSATMathUpper = 0.0;
		double doubleExpensesLower = 0.0;
		double doubleExpensesUpper = 0.0;
		double doublePercentFinancialAidLower = 0.0;
		double doublePercentFinancialAidUpper = 0.0;
		int intNumApplicantsLower = 0;
		int intNumApplicantsUpper = 0;
		double doublePercentAdmittedLower = 0.0;
		double doublePercentAdmittedUpper = 0.0;
		double doublePercentEnrolledLower = 0.0;
		double doublePercentEnrolledUpper = 0.0;
		int intAcademicScaleLower = 0;
		int intAcademicScaleUpper = 0;
		int intSocialScaleLower = 0;
		int intSocialScaleUpper = 0;
		int intQualityOfLifeScaleLower = 0;
		int intQualityOfLifeScaleUpper = 0;
		
		try {
			intNumStudentsLower = Integer.parseInt(numStudentsLower);				
		} catch (Exception nfe) {
			if (!numStudentsLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intNumStudentsUpper = Integer.parseInt(numStudentsUpper);				
		} catch (Exception nfe) {
			if (!numStudentsUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentFemaleLower = Double.parseDouble(percentFemaleLower);				
		} catch (Exception nfe) {
			if (!percentFemaleLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentFemaleUpper = Double.parseDouble(percentFemaleUpper);				
		} catch (Exception nfe) {
			if (!percentFemaleUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doubleSATVerbalLower = Double.parseDouble(SATVerbalLower);				
		} catch (Exception nfe) {
			if (!SATVerbalLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doubleSATVerbalUpper = Double.parseDouble(SATVerbalUpper);				
		} catch (Exception nfe) {
			if (!SATVerbalUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doubleSATMathLower = Double.parseDouble(SATMathLower);				
		} catch (Exception nfe) {
			if (!SATMathLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doubleSATMathUpper = Double.parseDouble(SATMathUpper);				
		} catch (Exception nfe) {
			if (!SATMathUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doubleExpensesLower = Double.parseDouble(expensesLower);				
		} catch (Exception nfe) {
			if (!expensesLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doubleExpensesUpper = Double.parseDouble(expensesUpper);				
		} catch (Exception nfe) {
			if (!expensesUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentFinancialAidLower = Double.parseDouble(percentFinancialAidLower);				
		} catch (Exception nfe) {
			if (!percentFinancialAidLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentFinancialAidUpper = Double.parseDouble(percentFinancialAidUpper);				
		} catch (Exception nfe) {
			if (!percentFinancialAidUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intNumApplicantsLower = Integer.parseInt(numApplicantsLower);				
		} catch (Exception nfe) {
			if (!numApplicantsLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intNumApplicantsUpper = Integer.parseInt(numApplicantsUpper);				
		} catch (Exception nfe) {
			if (!numApplicantsUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentAdmittedLower = Double.parseDouble(percentAdmittedLower);				
		} catch (Exception nfe) {
			if (!percentAdmittedLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentAdmittedUpper = Double.parseDouble(percentAdmittedUpper);				
		} catch (Exception nfe) {
			if (!percentAdmittedUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentEnrolledLower = Double.parseDouble(percentEnrolledLower);				
		} catch (Exception nfe) {
			if (!percentEnrolledLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			doublePercentEnrolledUpper = Double.parseDouble(percentEnrolledUpper);				
		} catch (Exception nfe) {
			if (!percentEnrolledUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intAcademicScaleLower = Integer.parseInt(academicScaleLower);				
		} catch (Exception nfe) {
			if (!academicScaleLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intAcademicScaleUpper = Integer.parseInt(academicScaleUpper);				
		} catch (Exception nfe) {
			if (!academicScaleUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intSocialScaleLower = Integer.parseInt(socialScaleLower);				
		} catch (Exception nfe) {
			if (!socialScaleLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intSocialScaleUpper = Integer.parseInt(socialScaleUpper);				
		} catch (Exception nfe) {
			if (!socialScaleUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intQualityOfLifeScaleLower = Integer.parseInt(qualityOfLifeScaleLower);				
		} catch (Exception nfe) {
			if (!qualityOfLifeScaleLower.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		try {
			intQualityOfLifeScaleUpper = Integer.parseInt(qualityOfLifeScaleUpper);				
		} catch (Exception nfe) {
			if (!qualityOfLifeScaleUpper.isEmpty())
			throw new NumberFormatException("Enter numbers correctly");
		}
		
		//If 1
		if (name == null || state == null || location == null || control == null || !checkBounds(intNumStudentsLower, intNumStudentsUpper) || !checkBounds(doublePercentFemaleLower, doublePercentFemaleUpper) || !checkBounds(doubleSATVerbalLower, doubleSATVerbalUpper) ||
				!checkBounds(doubleSATMathLower, doubleSATMathUpper) || !checkBounds(doubleExpensesLower, doubleExpensesUpper) || !checkBounds(intNumApplicantsLower, intNumApplicantsUpper) || 
				!checkBounds(doublePercentFinancialAidLower, doublePercentFinancialAidUpper) || !checkBounds(doublePercentAdmittedLower, doublePercentAdmittedUpper) || !checkBounds(doublePercentEnrolledLower, doublePercentEnrolledUpper) ||
				!checkBounds(intAcademicScaleLower, intAcademicScaleUpper) || !checkBounds(intSocialScaleLower, intSocialScaleUpper) || !checkBounds(intQualityOfLifeScaleLower, intQualityOfLifeScaleUpper) || searchEmphases == null)
		{
			
			throw new IllegalArgumentException("Invalid range entered");
		}
		
		//If 2
		if (name.equals("") && state.equals("") && location.equals("") && control.equals("") &&
				intNumStudentsLower == 0 && intNumStudentsUpper == 0 && doublePercentFemaleLower == 0 && doublePercentFemaleUpper == 0 &&
				doubleSATVerbalLower == 0 && doubleSATVerbalUpper==0 && doubleSATMathLower == 0 && doubleSATMathUpper == 0 && doubleExpensesLower == 0 &&
				doubleExpensesUpper == 0 && intNumApplicantsLower == 0 && intNumApplicantsUpper == 0 && intAcademicScaleLower == 0 && intAcademicScaleUpper == 0 &&
				intSocialScaleLower == 0 && intSocialScaleUpper == 0 && intQualityOfLifeScaleLower == 0 && intQualityOfLifeScaleUpper == 0 &&
				doublePercentFinancialAidLower == 0 && doublePercentFinancialAidUpper == 0 && doublePercentAdmittedLower == 0 && doublePercentAdmittedUpper == 0 &&
				doublePercentEnrolledLower == 0 && doublePercentEnrolledUpper == 0 && searchEmphases.isEmpty())
		{
			throw new InputMismatchException("All fields cannot be empty");
		}

		//ArrayList to keep track of universities that match search criteria
		ArrayList<University> foundUniversities = new ArrayList<University>();

		//For 1
		for (String u : universityNames)
		{
			University currentUniversity = universities.get(u);

			boolean matched = false;
			//If 3
			if ((name.equals("") || u.contains(name.toUpperCase())) && (state.equals("") || currentUniversity.getState().contains(state.toUpperCase())) && (location.equals("") || currentUniversity.getLocation().equalsIgnoreCase(location)) &&
					(control.equals("") || currentUniversity.getControl().equalsIgnoreCase(control)) && checkNumbers(currentUniversity.getNumStudents(), intNumStudentsLower, intNumStudentsUpper) &&
					checkNumbers(currentUniversity.getPercentFemale(), doublePercentFemaleLower, doublePercentFemaleUpper) && checkNumbers(currentUniversity.getSATVerbal(), doubleSATVerbalLower, doubleSATVerbalUpper) &&
					checkNumbers(currentUniversity.getSATMath(), doubleSATMathLower, doubleSATMathUpper) && checkNumbers(currentUniversity.getExpenses(), doubleExpensesLower, doubleExpensesUpper) &&
					checkNumbers(currentUniversity.getPercentFinancialAid(), doublePercentFinancialAidLower, doublePercentFinancialAidUpper) && checkNumbers(currentUniversity.getNumApplicants(), intNumApplicantsLower, intNumApplicantsUpper) &&
					checkNumbers(currentUniversity.getPercentAdmitted(), doublePercentAdmittedLower, doublePercentAdmittedUpper) && checkNumbers(currentUniversity.getPercentEnrolled(), doublePercentEnrolledLower, doublePercentEnrolledUpper) &&
					checkNumbers(currentUniversity.getAcademicScale(), intAcademicScaleLower, intAcademicScaleUpper) && checkNumbers(currentUniversity.getSocialScale(), intSocialScaleLower, intSocialScaleUpper) && 
					checkNumbers(currentUniversity.getQualityOfLifeScale(), intQualityOfLifeScaleLower, intQualityOfLifeScaleUpper))
			{
				ArrayList<String> currentEmphases = currentUniversity.getEmphases();
				//If 4
				if (searchEmphases.isEmpty())
					matched = true; 
				else
				{
					//For 2
					for (String emphasis : searchEmphases)
					{
						//If 5
						if (currentEmphases.contains(emphasis.toUpperCase()))
							matched = true; 
					}
				}	
			}	  
			//only if a university 'matches' all criteria will it be added
			//if the user does not put anything in a field it counts as a match for that particular field
			//If 6
			if (matched)
				foundUniversities.add(currentUniversity);			  
		}
		return foundUniversities;
	}

	/**
	 * helper method for comparing numbers
	 * @param currentSchoolValue  the value associated with the current university you are comparing
	 * @param lower  the lower bound entered in the search criteria
	 * @param upper  the upper bound entered in the search criteria
	 * @return a boolean if the currentSchoolValue is in range of the bounds
	 */
	private boolean checkNumbers(double currentSchoolValue, double lower, double upper)
	{
		if (lower == 0 && upper == 0)      
			return true;          
		else if (lower == 0 && upper >=  currentSchoolValue)    
			return true;           
		else if (upper == 0 && lower <=  currentSchoolValue)
			return true; 
		else if ((lower <= currentSchoolValue) && (upper >= currentSchoolValue))
			return true;
		return false;
	}
	
	/**
	 * helper method to make sure bounds are valid numbers	
	 * @param lower  the lower bound entered in the search criteria
	 * @param upper  the upper bound entered in the search criteria
	 * @return a boolean representing if the bounds are valid
	 */
	private boolean checkBounds(double lower, double upper)
	{
		if (lower < 0 || upper < 0)    
			return false;  
		else if (lower > upper && upper != 0)
			return false;
		return true;
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
		if (u == null)
			throw new IllegalArgumentException("University cannot be null");
		//HashMap<String, University> universities = this.dbc.viewUniversities();
		
		//HashMap<String, University> universityMap = new HashMap<String, University>();
		Set<String> keys = this.universities.keySet();
		keys.remove(u.getName());
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

		//For 1
		for (String universityName : keys)
		{
			University university = universities.get(universityName);

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
		//For 2
		for (String universityName : keys)
		{
			//If 1
			// Compares state name of parameter University with universities in database or see if its NA
			if (u.getState().equals("-1") || universities.get(universityName).getState().equals("-1") ||
					universities.get(universityName).getState().equals(u.getState()))
				stateDistance = 0; // state names equal
			else
				stateDistance = 1; // state names not equal
			
			//If 2
			// Compares location String of parameter University with universities in database or see if its NA
			if (u.getLocation().equals("-1")|| universities.get(universityName).getLocation().equals("-1") ||
					universities.get(universityName).getLocation().equals(u.getLocation()))
				locationDistance = 0; // location equal
			else
				locationDistance = 1; // location not equal

			//If 3
			// Compares control String of parameter University with universities in database or see if its NA
			if (u.getControl().equals("-1") || universities.get(universityName).getControl().equals("-1") ||
					universities.get(universityName).getControl().equals(u.getControl()))
				controlDistance = 0; // control equal
			else
				controlDistance = 1; // control not equal

			double numStudentsDistance, percentFemaleDistance, SATVerbalDistance, SATMathDistance,expensesDistance, percentFinancialAidDistance,
			numApplicantsDistance, percentAdmittedDistance, percentEnrolledDistance, academicScaleDistance, socialScaleDistance, qualityOfLifeScaleDistance;

			numStudentsDistance = calculateDistance(u.getNumStudents(), universities.get(universityName).getNumStudents(), maxNumStudents, minNumStudents);
			percentFemaleDistance = calculateDistance(u.getPercentFemale(), universities.get(universityName).getPercentFemale(), maxPercentFemale, minPercentFemale);
			SATVerbalDistance = calculateDistance(u.getSATVerbal(), universities.get(universityName).getSATVerbal(), maxSATVerbal, minSATVerbal);
			SATMathDistance = calculateDistance(u.getSATMath(), universities.get(universityName).getSATMath(), maxSATMath, minSATMath);
			expensesDistance = calculateDistance(u.getExpenses(), universities.get(universityName).getExpenses(), maxExpenses, minExpenses);
			percentFinancialAidDistance = calculateDistance(u.getPercentFinancialAid(), universities.get(universityName).getPercentFinancialAid(), maxPercentFinancialAid, minPercentFinancialAid);	        
			numApplicantsDistance = calculateDistance(u.getNumApplicants(), universities.get(universityName).getNumApplicants(), maxNumApplicants, minNumApplicants);	        
			percentAdmittedDistance = calculateDistance(u.getPercentAdmitted(), universities.get(universityName).getPercentAdmitted(), maxPercentAdmitted, minPercentAdmitted);	     
			percentEnrolledDistance = calculateDistance(u.getPercentEnrolled(), universities.get(universityName).getPercentEnrolled(), maxPercentEnrolled, minPercentEnrolled);
			academicScaleDistance = calculateDistance(u.getAcademicScale(), universities.get(universityName).getAcademicScale(), maxAcademicScale, minAcademicScale);
			socialScaleDistance = calculateDistance(u.getSocialScale(), universities.get(universityName).getSocialScale(), maxSocialScale, minSocialScale);
			qualityOfLifeScaleDistance = calculateDistance(u.getQualityOfLifeScale(), universities.get(universityName).getQualityOfLifeScale(), maxQualityOfLifeScale, minQualityOfLifeScale);

			ArrayList<String> emphases = u.getEmphases();
			double emphasesDistance = 0;
			
			//If 4
			if (!emphases.isEmpty())
			{
				int count = 0;
				//For 3
				for (String emphasis : emphases)
				{
					//If 5
					//if the potentially recommended school does not contain an emphasis
					if (!universities.get(universityName).getEmphases().contains(emphasis))
						count++; 	  
				}
				emphasesDistance = count/emphases.size();
			}	

			double totalDistance = stateDistance + locationDistance + controlDistance + numStudentsDistance + percentFemaleDistance + SATVerbalDistance +
					SATMathDistance + expensesDistance + percentFinancialAidDistance + numApplicantsDistance + percentAdmittedDistance + percentEnrolledDistance +
					academicScaleDistance + socialScaleDistance + qualityOfLifeScaleDistance + emphasesDistance;

			distanceMap.put(universityName, totalDistance);

		}

		// sorts distance map by value in ascending order, adds universityNames to ArrayList to return
		List<Double> sortedValues = new ArrayList<Double>(distanceMap.values());
		Collections.sort(sortedValues);
		Iterator<Double> values = sortedValues.iterator();

		ArrayList<University> recommendedUniversities = new ArrayList<University>();
		
		//ArrayList<Double, University> recommendedUniversities = new HashMap<Double, University>();
		
		//while 1
		while (values.hasNext() && (recommendedUniversities.size() <5))
		{
			double temp = values.next();
			//For 4
			for (String universityName : keys)
			{
				//If 6
				if (distanceMap.get(universityName) == temp)
				{
					recommendedUniversities.add(dbc.getUniversity(universityName));
					distanceMap.put(universityName,  -1.0);
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
		if (foundUniversities == null)
			throw new IllegalArgumentException("ArrayList cannot be null");
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
		if(student == null)
			throw new IllegalArgumentException("student is a null value");
		else if (newUniversity == null) 
			throw new IllegalArgumentException("newUniveristy is a null value");	
		else {
			return dbc.saveUniversityToStudent(student, newUniversity);
		}

	}
}
