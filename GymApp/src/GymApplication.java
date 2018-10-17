/*
 * This is a programming assignment that belongs to Gergo Szilagyi from Software Systems Development at WIT
 */
import java.util.*;

public class GymApplication {
	 private  Scanner input;						//Create a Scanner object called input that can be used by all methods in the class.
	    Gym gym1;
	    Date today = new Date();      //created a date object for options 5+6
	    
	    
	    
	    public GymApplication(){
	    	input = new Scanner(System.in);
	    	System.out.println("========================="); //Interface
	    	System.out.println("||  Gym Registration   ||");
	    	System.out.println("=========================");
	    	System.out.println("Please enter the gym...");
	    	System.out.print("Name: ");
	        String gymName = input.nextLine();
	        if (gymName.length() > 30 ){            //if the gym's name exceeds 30 characters it is snipped to 30characters
	        	gymName = gymName.substring (0, 30);
	        } 
	        
	        while (!gymName.matches("[a-zA-Z' ]*")|| (gymName.isEmpty())){                  //if gym name doesnt match characters only it returns an error and repeats
	        	System.out.println("***Input contains invalid characters. Try again.");
	        	System.out.print("Name: ");
		        gymName = input.nextLine();
	        }

	        
	        
	        System.out.print("Manager Name: ");
			String managerName = input.nextLine();
			while (!managerName.matches("[a-zA-Z' ]*")|| (managerName.isEmpty())){         //if the manager name does not match a-zA-Z' and space or is empty an error
	        	System.out.println("***Input contains invalid characters. Try again.");    //is printed and repeated until valid
	        	System.out.print("Manager Name: ");
		        managerName = input.nextLine();
	        }
			
			
			System.out.print("Phone Number: ");
			String phoneNumber = input.nextLine();
			 
			if (phoneNumber.isEmpty() || !phoneNumber.matches("[0-9]+")) {   //if phone number is empty or does not match the required characters 
				gym1 = new Gym(gymName,managerName);                         //it makes the gym1 with 2 attributes and sets phone number to unknown
			}
			else {                                                           //else it makes gym with 3 attributes including the input phone num.
				gym1 = new Gym(gymName,managerName,phoneNumber);
			}
			
			
	    	
	    }
	    
	    public static void main(String args[]){
	    	
			    	GymApplication app = new GymApplication();  
		        	app.runMenu();
		        	
	    		
        	
		}
	    
	    private int mainMenu()
	    { 
	    	System.out.println("\n\n============================================================");
	    	System.out.println("||                        Gym Menu                        ||");
	    	System.out.println("============================================================");
	        System.out.println("||  1) Add a member                                       ||");     
	        System.out.println("||  2) List all members                                   ||");
	        System.out.println("||  3) Remove a member (by index)                         ||");
	        System.out.println("||  4) Number of members in the gym                       ||");
	        System.out.println("||  5) Date and Time of latest login                      ||");
	        System.out.println("||  6) Gym open hours and availability                    ||");
	        System.out.println("||  7) Edit a member in the gym                           ||");
	        System.out.println("||--------------------------------------------------------||"); 
	        System.out.println("||  8) List gym details                                   ||");       
	        System.out.println("||  9) List members with ideal starting weight            ||");        
	        System.out.println("|| 10) List members with a specific BMI category          ||");
	        System.out.println("|| 11) List all members stats imperically and metrically  ||");
	        System.out.println("||--------------------------------------------------------||"); 
	        System.out.println("|| 12) Save contents to gym.xml                           ||");
	        System.out.println("|| 13) Load contents from gym.xml                         ||");
	        System.out.println("||  0) Exit                                               ||");
	        System.out.print(  "||==>>");
	         int option = input.nextInt();
	         return option;
	    }
	    
	    private void runMenu()
	    {
	        int option = mainMenu();
	        do
	        
	        {

	            switch (option)
	            {
	            case 1:    	addMember();
	           				break;
	            case 2:    	System.out.println(gym1.listMembers());
	            			break;
	            case 3:    	deleteMember();
							break;
	            case 4:    	System.out.println(gym1.numberOfMembers());
							break;
	            case 5:    	System.out.println(gym1.lastLogin());   //prints the time and date the program last began running
				            break;
	            case 6:    	System.out.println(gym1.gymOpenHours()); //the open hours of the gym including how long until it opens/closes
	                        break;
	            case 7:     updateMemberInfo();
	                        break;
	            case 8:  	System.out.println(gym1);
							break;
	            case 9:    	System.out.println(gym1.listMembersWithIdealWeight());
							break;
	            case 10:    System.out.println(gym1.listBySpecificBMICategory());
	        				break;
	            case 11:    System.out.println(gym1.listMemberDetailsImperialAndMetric());
							break;
	            case 12:  try{
    						   gym1.save();
    					   }
    					   catch(Exception e){
    						   System.out.println("Error writing to file:  " + e);
    					   }
						    break;
			    case 13:    try{
    						   gym1.load();
    					    }
    					    catch(Exception e)
    					    {
    						   System.out.println("Error reading from file: " + e);
    					    }
    					     break;
	 		
							
	                default:   System.out.println("Invalid option entered: " + option);
	                        
	            }

	            //display the main menu again
	            option = mainMenu();
	        }while (option != 0);

	        //the user chose option 0, so exit the program
	        System.out.println("Exiting the Gym... bye");
	        System.exit(0);
	    }
	    
	    private void addMember()
	    {
	    	System.out.println("\n\n================================================================");
	    	System.out.println("||                    Member Registration                     ||");
	    	System.out.println("================================================================");
	        System.out.println("|| Please enter the following account details...");
	       
	        int memberId = 0;
	    	boolean goodInput2 = false;
	        while (!goodInput2){
	        	try{                                                                        //if alphabetic characters are entered instead of integers, it will return 
	        		System.out.print("||\tMember ID Number (between 100000 and 999999): "); // an error and ask again until goodInput = true
	    	        memberId = input.nextInt();
	    	        goodInput2 = true ;
	        	}
	        	catch(Exception e) {
	        		String throwOut = input.nextLine(); //swallows
	        		System.out.println("||**Invalid input entered.Try Again.");	
	        	}
	        }
	        if (memberId < 100000  || memberId > 999999){   //limits the number to between 100000 and 999999, if its outside of those boundaries, it is set to 100000
	        	memberId = 100000;                          //by default
	        }
	        gym1.memberIdChecker();
	        
	        System.out.print("||\tName (max 30 chars): ");
	        String memberName = input.nextLine();
	        memberName = input.nextLine();
	        
	        while (!memberName.matches("[a-zA-Z' ]*")|| (memberName.isEmpty())){           //if member name is empty or doesnt contain alphabetic characters or ' or space
	        	System.out.println("||***Input contains invalid characters. Try again.");  //returns an error and repeats until valid
	        	System.out.print("||\tName (max 30 chars): ");
		        memberName = input.nextLine();
	        }
	        
	        System.out.print("||\tAddress: ");
	        String memberAddress = input.nextLine();

	        double height =0;                        
	        boolean goodInput = false;
	        while (!goodInput){
	        	try{
	        		System.out.print("||\tHeight (between 1 and 3 metres): ");
	        		height = input.nextDouble();
	 	    	    goodInput = true;
	 	    	    
	        	}
	        	catch  (Exception e) {
	        		String throwOut = input.nextLine(); //swallows
	        		System.out.println("||**Invalid input entered.Try Again.");
	        	}
	        	
	        }
	        while (height < 1 || height > 3){                                                         //if height isnt within 1 and 3m ,repeats or if anything apart from
	        	System.out.println("||**Invalid number entered. Height must be between 1m and 3m.");  //a number is entered
    			System.out.print("\tHeight (between 1 and 3 metres): ");
    	        height = input.nextDouble();
	        }
	        
	        
	        
	        
	        
	        
	        double startingWeight = 0;
	        boolean goodInput1 = false;
	        while (!goodInput1){
	        	try{
	        		System.out.print("||\tStarting weight(Between 35kg and 250kg): ");
	        		startingWeight = input.nextDouble();
	        		goodInput1 = true;
	        	}
	        	catch  (Exception e) {
	        		String throwOut = input.nextLine(); //swallows
	        		System.out.println("||**Invalid input entered.Try Again.");
	        	}
	        }
	        while  (startingWeight < 35 || startingWeight > 250)
			{
				System.out.println("||**Invalid weight entered. Weight must be between 35kg and 250kg");
				System.out.print("||\tStarting Weight: ");
		        startingWeight = input.nextDouble();
			}
	        
	        System.out.print("||\tGender (M/F): ");
	        String gender = input.next();
	        
	        /*if (!gender.equalsIgnoreCase("m") || !gender.equalsIgnoreCase("f"))
			{
				gender = "Unspecified";
			}*/
	        
	        if (gender.equalsIgnoreCase("m")) {         //if gender isnt male or female , it is set to unspecified
				gender = "m"; 
			} else if (gender.equalsIgnoreCase("f")) {
				gender = "f";
			} else {
				gender = "Unspecified";
			}
			
	      
	        gym1.add(new Member(memberId, memberName, memberAddress, height, startingWeight, gender));
	    }
	    
	    public void deleteMember()
	    {
	    	
	    	System.out.println("\n============================================================");
	    	System.out.println("||                      Remove a member                   ||");
	    	System.out.println("============================================================");
	    	//List the Members and ask the user to choose which account to delete
	    	System.out.println(gym1.listMembers());
	    	if(gym1.getMembers().size()!=0)
	    	{
	    		//Only process the delete if products exist in the Arraylist
	    	   	System.out.println("||Index of member to remove ==>");
	    	   	int index = input.nextInt();
	        
	    	   	if(index<gym1.getMembers().size())
	    	   	{
	    	   		//If the index number exists in the Arraylist, delete it from the arraylist
	    	   		gym1.getMembers().remove(index);
	    	   		System.out.println("||**Member Removed**");
	    	   	}
	    	   	else
	    	   	{
	    	   		System.out.println("||**There is no Member for this index number");
	    	   	}
	       	}
	    }
	    
	    private void updateMemberInfo(){
	    	System.out.println("\n============================================================");
	    	System.out.println("||                      Update a member                   ||");
	    	System.out.println("============================================================");
			System.out.println(gym1.listMembers());

	        if (gym1.numberOfMembers() != 0){   
	            //only process the delete if account exist in the ArrayList
	            System.out.print("|| Index of member to update ==>");
	            int index = input.nextInt();
	            if (index < gym1.numberOfMembers() ){    
	                //if the index number exists in the ArrayList, delete it from the ArrayList
	            	int memberId = 0;
	    	    	boolean goodInput2 = false;
	    	        while (!goodInput2){
	    	        	try{
	    	        		System.out.print("||\tMember ID Number (between 100000 and 999999): ");
	    	    	        memberId = input.nextInt();
	    	    	        goodInput2 = true ;
	    	        	}
	    	        	catch(Exception e) {
	    	        		String throwOut = input.nextLine(); //swallows
	    	        		System.out.println("||**Invalid input entered.Try Again.");	
	    	        	}
	    	        }
	    	        if (memberId < 100000  || memberId > 999999){
	    	        	memberId = 100000;
	    	        }
	    	        gym1.memberIdChecker();
	            	
	    	        
	            	System.out.println("||\tChange the member name: ");
	            	String memberName = input.nextLine();
	     	        memberName = input.nextLine();
	     	       
	     	        while (!memberName.matches("[a-zA-Z' ]*")|| (memberName.isEmpty())){
	     	        	System.out.println("||***Input contains invalid characters. Try again.");
	     	        	System.out.print("||\tName (max 30 chars): ");
	     		        memberName = input.nextLine();
	     	        }
	     	        
	     	        
	            	
	            	System.out.println("|| Change the member address: ");
	            	String memberAddress = input.nextLine();
	            	
	            	double height =0;
	    	        boolean goodInput = false;
	    	        while (!goodInput){
	    	        	try{
	    	        		System.out.print("||\tHeight (between 1 and 3 metres): ");
	    	        		height = input.nextDouble();
	    	 	    	    goodInput = true;
	    	 	    	    
	    	        	}
	    	        	catch  (Exception e) {
	    	        		String throwOut = input.nextLine(); //swallows
	    	        		System.out.println("||**Invalid input entered.Try Again.");
	    	        	}
	    	        	
	    	        }
	    	        while (height < 1 || height > 3){
	    	        	System.out.println("||**Invalid number entered. Height must be between 1m and 3m.");
	        			System.out.print("|| \tHeight (between 1 and 3 metres): ");
	        	        height = input.nextDouble();
	    	        }

	            	
	            	double startingWeight = 0;
	    	        boolean goodInput1 = false;
	    	        while (!goodInput1){
	    	        	try{
	    	        		System.out.print("||\tStarting weight(Between 35kg and 250kg): ");
	    	        		startingWeight = input.nextDouble();
	    	        		goodInput1 = true;
	    	        	}
	    	        	catch  (Exception e) {
	    	        		String throwOut = input.nextLine(); //swallows
	    	        		System.out.println("||**Invalid input entered.Try Again.");
	    	        	}
	    	        }
	    	        while  (startingWeight < 35 || startingWeight > 250)
	    			{
	    				System.out.println("||**Invalid weight entered. Weight must be between 35kg and 250kg");
	    				System.out.print("||\tStarting Weight: ");
	    		        startingWeight = input.nextDouble();
	    			}
	    	        
	    	        
	            	System.out.println("|| Change the member gender: ");
	            	String gender = input.next();
	            	if (gender.equalsIgnoreCase("m")) {
	    				gender = "m"; 
	    			} else if (gender.equalsIgnoreCase("f")) {
	    				gender = "f";
	    			} else {
	    				gender = "Unspecified";
	    			}
	            	
	            	
	            	
	            	
	            	
	                gym1.members.remove(index);
	                gym1.members.add(index,new Member(memberId, memberName, memberAddress, height, startingWeight, gender));
	                System.out.println("|| **Member edited.");
	            }
	            else
	            {
	                System.out.println("|| **There is no account for this index number");
	            }
	        }
	    
	    }
	    
}
/*
 * This is a programming assignment that belongs to Gergo Szilagyi from Software Systems Development at WIT
 */
