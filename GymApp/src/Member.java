/*
 * This is a programming assignment that belongs to Gergo Szilagyi from Software Systems Development at WIT
 */



public class Member {
	//atributes
	int memberId;
	String memberName;
	String memberAddress;
	double height;
	double startingWeight;
	
	String gender;
	String printGender;
	
	
	//constructor
	public Member(int memberIdIn,String memberNameIn,String memberAddressIn,double heightIn,double startingWeightIn,String genderIn){
		memberId = memberIdIn;
		memberName = memberNameIn;
		memberAddress = memberAddressIn;
		height = heightIn;
		startingWeight = startingWeightIn;
		gender = genderIn;

	}
	
	
	//getters
	public int getMemberId()
    {
        return memberId;
    }
	public String getMemberName()
	{
		return memberName;
	}
	public String getMemberAddress()
    {
        return memberAddress;
    }
	public double getHeight()
	{
		return height;
	}
	public double getStartingWeight()
    {
        return startingWeight;
    }
	public String getGender()
	{
		return gender;
	}

	//setters
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public void setStartingWeight(double startingWeight) {
		this.startingWeight = startingWeight;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	///Methods
	public double calculateBMI(){
		double BMI = (startingWeight/height)/height;   //formula for BMI
		return BMI;	
	}
	
	public double convertHeightMetresToInches(){
		 double heightInches = height*39.37;     //from metres to inches formula
		return heightInches;
		
	}
	
	public double convertWeightKgToPounds(){
	    double startingWeightlb = startingWeight*2.2046;  //from kg to pounds formula
		return startingWeightlb;
		
	}
	
	public String determineBMICategory(){
		double BMI = (startingWeight/height)/height;  //BMI formula again
		String BMICat = null;
		if (BMI < 15){
			BMICat = "VERY SEVERELY UNDERWEIGHT";
		}
		if (BMI >= 15 && BMI < 16){
			BMICat = "SEVERELY UNDERWEIGHT";
		}
		if (BMI >=16 && BMI < 18.5){
			BMICat = "UNDERWEIGHT";
		}
		if (BMI >=18.5 && BMI < 25){
			BMICat = "NORMAL";
		}
		if (BMI >=25 && BMI < 30){
			BMICat = "OVERWEIGHT";
		}
		if (BMI >=30 && BMI < 35){
			BMICat = "MODERATELY OBESE";
		}
		if (BMI >=35 && BMI < 40){
			BMICat = "SEVERELY OBESE";
		}
		if (BMI >= 40){
			BMICat = "VERY SEVERELY OBESE";
		}
			
		return BMICat;
		
	}
	
	public boolean isIdealBodyWeight(){
		
		double idealBodyWeight;
		double heightInches = height*39.37;  //height to inches from metres
		double ans = heightInches - (5*12);  // -( 5 feet * 60 inches) because it only applies to people over 60 inches
		idealBodyWeight = ans * 2.3;   //2.3kg for every inch over 5eet
		// adds on 50 kg to result (for men /45kg to) and +-2kg for the range
        if ((gender.equalsIgnoreCase("m") && startingWeight >= idealBodyWeight+(-2+50) && startingWeight <= idealBodyWeight+(2+50)) || (gender.equalsIgnoreCase("f") && startingWeight >= idealBodyWeight+(-2+45.5) && startingWeight <= idealBodyWeight+(2+45.5))){
        	  
        	  return true ;
     		} else 
     		{
     			
     		  return false ;
     		} 
	}
	
	//if the above formula returns true, it prints a Human readable version of the boolean to the user
	public String isMemberIdealWeight() {
		if (isIdealBodyWeight()) {
		return  "Yes";
		}
		else
			return "No";
	}
	
	
	
	
	
	public String toString()
    {
		//returns a human readable version for the user instead of M/F
		if (gender.equalsIgnoreCase("m")){
			printGender ="Male";
		} else if (gender.equalsIgnoreCase("f")){
			printGender = "Female";
		} else {
			printGender = "Unspecified";
		}
    	return " MemberID:  " + memberId + "\n||     Member Name:  " + memberName + "\n||     Member Address:  " + memberAddress + "\n||     Gender:  " + printGender +"\n||     Height:  "+height+"m  \n||     Ideal Weight:  " +isMemberIdealWeight() + "\n||     Starting Weight:  "+startingWeight+"kg  \n||     BMI of:  "+calculateBMI()+" ("+determineBMICategory()+") \n";
    }


}

/*
 * This is a programming assignment that belongs to Gergo Szilagyi from Software Systems Development at WIT
 */
