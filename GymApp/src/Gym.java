/*
 * This is a programming assignment that belongs to Gergo Szilagyi from Software Systems Development at WIT
 */
import java.io.FileReader;                         //automatically added
import java.io.FileWriter;                         //automatically added
import java.io.ObjectInputStream;                  //automatically added
import java.io.ObjectOutputStream;                 //automatically added
import java.util.*;  //added for date and scanner and arraylists

import com.thoughtworks.xstream.XStream;           //automatically added
import com.thoughtworks.xstream.io.xml.DomDriver;  //automatically added

public class Gym {
	//attributes
	String gymName;
	String managerName;
	String phoneNumber;
     ArrayList<Member> members;
    Scanner input = new Scanner(System.in);
    Date today = new Date();
    Date open = new Date();
	
	// the constructor
    //for 2 attributes
    public Gym(String gymName, String managerName)
    {
    	this.gymName = gymName;
    	this.managerName = managerName;
    	this.phoneNumber = "Unknown";     //if this gym is made , phone number is automatically set to unknown
    	
    	members = new ArrayList<Member>();
           
    }
    //for 3 attributes
    public Gym(String gymName, String managerName, String phoneNumber)
    {
    	this.gymName = gymName;
    	this.managerName = managerName;
    	this.phoneNumber = phoneNumber;
    	
    	members = new ArrayList<Member>();
           
    }
    
  //Getters for gym
  public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getManagerName() {
		return managerName;
	}
	
	//Setters for gym
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	//New Method to return all members in the arraylist
    public ArrayList<Member> getMembers()
    {
    	return members;
    }
    
    
    public void add (Member member){
        members.add (member); 
    }
    
    public void remove(int index){
        members.remove(index);
    }
    
    public String listBySpecificBMICategory(){
    	System.out.println("\n============================================================");
    	System.out.println("||                 Members by BMI Categories               ||");
    	System.out.println("============================================================");
    	if (members.size()>0){
    		
  
    	System.out.println("|| The specific categories are: ");
    	System.out.println("|| 'Very Severely Underweight'");
    	System.out.println("|| 'Severely Underweight'");
    	System.out.println("|| 'Underweight'");
    	System.out.println("|| 'Normal'");
    	System.out.println("|| 'Overweight'");
    	System.out.println("|| 'Moderately Obese'");
    	System.out.println("|| 'Severely Obese'");
    	System.out.println("|| 'Very Severely Obese'");
    	System.out.print("|| ==>>");
    	
    	String membersByCategories = "";
    	String search = input.nextLine();
    	
        
    	for (int i=0; i <numberOfMembers();i++){
    	    if (members.get(i).determineBMICategory().contains(search.toUpperCase())){   //if there is any member in determineBMICategory method that contains the word searched , they will be printed
    	    	membersByCategories += "|| "+ i+ ": " + members.get(i).getMemberName() + ": " + members.get(i).getStartingWeight()+"kg ("+members.get(i).determineBMICategory()+") \n"; 
    	    }
    	}
		return membersByCategories;
    	} else
    	{
    		return "||There are no members in the gym";
    	}
    	
    }
    
    public String listMemberDetailsImperialAndMetric(){
    	System.out.println("\n============================================================");
    	System.out.println("||              Members' Imperial and Metric              ||");
    	System.out.println("============================================================");
    	if (members.size()>0)
    	{
    	      String listImpericallyAndMetrically = "";	 
	          for(int i=0;i<numberOfMembers();i++) {           
		      listImpericallyAndMetrically += "|| "+ i +": " + members.get(i).getMemberName() + ": " + members.get(i).getStartingWeight() +"kg" + " (" + members.get(i).convertWeightKgToPounds() + "lbs)  " +  members.get(i).getHeight() + "m " + "(" + members.get(i).convertHeightMetresToInches() + " inches)\n";
		  	  }
	          return listImpericallyAndMetrically;
    	}
    	else {
    		return "||There are no members in the gym";
    	}
    }
    
    public String listMembers(){
    	
    	System.out.println("============================================================");
    	System.out.println("||                      List Of Members                   ||");
    	System.out.println("============================================================");
         if (members.size() > 0){
           	 
                String listOfMembers = "";
                for (int i = 0; i < numberOfMembers(); i++){
                    listOfMembers +="|| "+ i + ": " + members.get(i) + "\n";   
                }
                return listOfMembers;
            }
            else{
                return "||There are no members in the gym";
            }
        } 
    
    public String listMembersWithIdealWeight(){
    	
    	System.out.println("============================================================");
    	System.out.println("||               Members with ideal weight                ||");
    	System.out.println("============================================================");
    	
    	 if (members.size() > 0 ){
    		 String listIdealWeightMembers= "";
             for (int i = 0; i < numberOfMembers(); i++){
            	if (members.get(i).isIdealBodyWeight()==true){                                  //if the member has ideal body weight
            		listIdealWeightMembers +="|| " + i + ": " + members.get(i).toString()+"\n"; //their names are added to listIdealWeightMembers and printed when needed
            	}
             }
             return listIdealWeightMembers;
         }
         else{
             return "||There are no members in the gym";
         }
    	
    }
    public int memberIdChecker(){
    	if (members.size()>0){
    		for (int i = 0; i < numberOfMembers(); i++){
    			if (members.get(i).memberId == (members.get(i).memberId)){    //if the member ID of one member is the same of that of another's, 1 is 
    				members.get(i).memberId +=1;                              //added to the ID until it doesnt match anyone else's
    			}
    		}
    	}
		return 0;	
    }
    
    public int numberOfMembers(){
		return members.size();
    }
    
    public String gymOpenHours() {
    	System.out.println("\n\n================================================================");
    	System.out.println("||                          Open Hours                        ||");
    	System.out.println("================================================================");
    	String availability ;
    	int availableUntil;
    	System.out.println("|| Mon:\t9:00  -  21:00                                       ||");
    	System.out.println("|| Tue:\t9:00  -  21:00                                       ||");
    	System.out.println("|| Wed:\t9:00  -  21:00                                       ||");
    	System.out.println("|| Thu:\t9:00  -  21:00                                       ||");
    	System.out.println("|| Fri:\t9:00  -  21:00                                       ||");
    	System.out.println("|| Sat:\t9:00  -  21:00                                       ||");
    	System.out.println("|| Sun:\t9:00  -  21:00                                       ||");
    	int hours = today.getHours();    //couldnt use the new Calendar method so i used date, it still works. This gets the hour for now
    	if (hours > 9 && hours < 21) {   // and if it is within 9 and 21 the shop is open else its closed
    		availability = " Open";      // also prints how long one has to wait until the gym is open or closed
    		availableUntil = 21 - today.getHours();
    	} else {
    		availability = "Closed";
    		availableUntil = today.getHours() - 9 ;
    	}
    	return "\n|| Availability: "+availability+ "  for "+availableUntil+" hour(s)";
    }
    
    public String lastLogin() {
    	
    	String lastLoginDate = "";
    	lastLoginDate ="\n\n|| The last login was on: "+ today;  //prints the time the program was started
		return lastLoginDate;
    	
    }
    
    @SuppressWarnings("unchecked")
	public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("gym.xml"));
        members = (ArrayList<Member>) is.readObject();
        is.close();
    }
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("gym.xml"));
        out.writeObject(members);
        out.close();    
    }
    
    public String toString()
    {
    	System.out.println("\n============================================================");
    	System.out.println("||                        Gym Details                     ||");
    	System.out.println("============================================================");
    	return "|| Gym Name: " + gymName + " \n|| Manager: " + managerName + "\n|| Phone Number: " + phoneNumber + "\n||\n|| List of members in the gym: \n "+listMembers();
    }
    
}
/*
 * This is a programming assignment that belongs to Gergo Szilagyi from Software Systems Development at WIT
 */