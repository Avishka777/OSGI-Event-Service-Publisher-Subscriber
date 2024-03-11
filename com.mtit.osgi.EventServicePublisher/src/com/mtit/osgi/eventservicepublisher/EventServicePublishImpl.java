package com.mtit.osgi.eventservicepublisher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EventServicePublishImpl implements EventService {
	
	float Total_Hall_Charge = (float) 0.0;
	int Release_Hall;
	
	public String LoginVerification(String username,String password){
		
		if((username.equals("admin")) && (password.equals("admin"))){
			return "admin";
		}
		else if((username.equals("reception")) && (password.equals("reception"))){
			return "reception";
		}
		else{
			return "invalid";
		}	
	 }

	@Override
	//Book Wedding Hall
	public void Book_Wedding_Hall(int no_of_halls, ArrayList Avaiable_Wedding_Halls, ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls, ArrayList Booked_Halls) {
		
		if(no_of_halls <= Avaiable_Wedding_Halls.size())
		{
			for(int i=0;i<no_of_halls;i++)
			{
			  int j=0;
			  int hall = (int) Avaiable_Wedding_Halls.remove(j);
			  Booked_Halls.add(hall);
			}
			
			Total_Hall_Charge = no_of_halls * 100000;
			
		    System.out.println("Total Hall Charge:"+Total_Hall_Charge);
		    System.out.print("\n");
		    
		    Collections.sort(Avaiable_Wedding_Halls);
		    Collections.sort(Avaiable_Meeting_Halls);
		    Collections.sort(Avaiable_Function_Halls);
		  
		    
		    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
		    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
		    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
		    System.out.print("\n");
			
		}
		else
		{
			System.out.println("Sorry...Number of Available Wedding Halls less than Number of Halls that You want.");
		}
		
	}

	@Override
	public void Book_Meeting_Hall(int no_of_halls, ArrayList Avaiable_Wedding_Halls, ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls, ArrayList Booked_Halls) {
		
		if(no_of_halls <= Avaiable_Meeting_Halls.size())
		{
			for(int i=0;i<no_of_halls;i++)
			{  
				int j=0;
			    int hall = (int) Avaiable_Meeting_Halls.remove(j);
			    Booked_Halls.add(hall);
			    
			}
			
			Total_Hall_Charge = no_of_halls * 50000;
			
		    System.out.println("Total Hall Charge:"+Total_Hall_Charge);
		    System.out.print("\n");
		    
		    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
		    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
		    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
		    System.out.print("\n");
		}
		else
		{
			System.out.println("Sorry...Number of Available Meeting Halls less than Number of Halls that You want.");
		}
		
	}

	@Override
	public void Book_Function_Hall(int no_of_halls, ArrayList Avaiable_Wedding_Halls, ArrayList Avaiable_Meeting_Halls,	ArrayList Avaiable_Function_Halls, ArrayList Booked_Halls) {
		
		if(no_of_halls <= Avaiable_Function_Halls.size())
		{
			for(int i=0;i<no_of_halls;i++)
			{  
				int j=0;
			    int hall = (int) Avaiable_Function_Halls.remove(j);
			    Booked_Halls.add(hall);
			    
			}
			
			Total_Hall_Charge = no_of_halls * 30000;
			
			System.out.println("Total Hall Charge:"+Total_Hall_Charge);
		    System.out.print("\n");
		    
		    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
		    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
		    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
		    System.out.print("\n");
		}
		else
		{
			System.out.println("Sorry...Number of Available Function Halls less than Number of Halls that You want.");
		}	
	}

	@Override
	public void Add_Wedding_Meeting_Function_Hall(String HallType, ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls, ArrayList Avaiable_Function_Halls, int hallno) {
		
		//Add Wedding Halls
		if(HallType.equals("Wedding") || HallType.equals("wedding"))
		{
			Avaiable_Wedding_Halls.add(hallno);
			System.out.println("New Wedding Hall Added "+hallno);  
					
			Collections.sort(Avaiable_Wedding_Halls);
			Collections.sort(Avaiable_Meeting_Halls);
			Collections.sort(Avaiable_Function_Halls);
					  
			System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
		    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
		    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
		    System.out.print("\n");
				
		}
				
		//Add Meeting Halls
		else if(HallType.equals("Meeting") || HallType.equals("meeting"))
		{
			Avaiable_Meeting_Halls.add(hallno);
		    System.out.println("New Meeting Hall Added"+hallno);  
		       	  
		 	Collections.sort(Avaiable_Wedding_Halls);
		    Collections.sort(Avaiable_Meeting_Halls);
		    Collections.sort(Avaiable_Function_Halls);
				
		    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
		    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
		    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
		    System.out.print("\n");
			
		}	 
				
		//Add Function Halls
		else if(HallType.equals("Function") || HallType.equals("function"))
		{
			Avaiable_Function_Halls.add(hallno);
			System.out.println("New Function Hall Added"+hallno);  
			       	  
			Collections.sort(Avaiable_Wedding_Halls);
		    Collections.sort(Avaiable_Meeting_Halls);
		    Collections.sort(Avaiable_Function_Halls);
				
		    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
		    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
		    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
		    System.out.print("\n");
					 
		}	 	
	}

	@Override
	public void Remove_Wedding_Meeting_Function_Hall(String HallType, ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls, ArrayList Avaiable_Function_Halls, int hallno) {
		
		//Remove Wedding Halls
		if(HallType.equals("Wedding") || HallType.equals("wedding"))
		{
			for(int i=0;i<Avaiable_Wedding_Halls.size();i++)
			{
				if(hallno == (int)Avaiable_Wedding_Halls.get(i))
				{
					Avaiable_Wedding_Halls.remove(i);
					System.out.println("Wedding Hall Removed "+hallno);  
					       	  
					Collections.sort(Avaiable_Wedding_Halls);
				    Collections.sort(Avaiable_Meeting_Halls);
				    Collections.sort(Avaiable_Function_Halls);
						
				    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
				    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
				    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
				    System.out.print("\n");
						   
				}
			}
		}
				
		//Remove Meeting Hall
		else if(HallType.equals("Meeting") || HallType.equals("meeting"))
		{ 
			for(int i=0;i<Avaiable_Meeting_Halls.size();i++)
			{
				if(hallno == (int)Avaiable_Meeting_Halls.get(i))
				{
					Avaiable_Meeting_Halls.remove(i);
					System.out.println("Meeting Hall Removed "+hallno);  
						       	
					Collections.sort(Avaiable_Wedding_Halls);
				    Collections.sort(Avaiable_Meeting_Halls);
				    Collections.sort(Avaiable_Function_Halls);
						
				    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
				    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
				    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
				    System.out.print("\n");
							
				}	
			}
        }	
				
		//Remove Function Hall
		else if(HallType.equals("Function") || HallType.equals("function"))
		{ 
			for(int i=0;i<Avaiable_Function_Halls.size();i++)
			{
				if(hallno == (int)Avaiable_Function_Halls.get(i))
				{
					Avaiable_Function_Halls.remove(i);
					System.out.println("Function Hall Removed "+hallno);  
							       					
					Collections.sort(Avaiable_Wedding_Halls);
				    Collections.sort(Avaiable_Meeting_Halls);
				    Collections.sort(Avaiable_Function_Halls);
						
				    System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
				    System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
				    System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
				    System.out.print("\n");
							
				}	
			}
        }

	}
	

	@Override
	public void ReleaseHall(int Booked_Hallno, ArrayList Avaiable_Wedding_Halls, ArrayList Avaiable_Meeting_Halls, ArrayList Avaiable_Function_Halls, ArrayList Booked_Halls) {
		
		for(int i=0;i<Booked_Halls.size();i++)
		  {
			   if(Booked_Hallno == (int)Booked_Halls.get(i))
			   {
				 //Booked Wedding Halls
				   if((int)Booked_Halls.get(i) <= 5)
				   {
					   Avaiable_Wedding_Halls.add((int)Booked_Halls.get(i));
					   Booked_Halls.remove(i);
					   
					   Collections.sort(Avaiable_Wedding_Halls);
					   Collections.sort(Avaiable_Meeting_Halls);
					   Collections.sort(Avaiable_Function_Halls);
					   
					   System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
					   System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
					   System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
					   System.out.print("\n");
				   }
				   
				   //Booked Meeting Halls
				   else if((int)Booked_Halls.get(i) >=5 && (int)Booked_Halls.get(i) <=10 )
				   {
					   Avaiable_Meeting_Halls.add((int)Booked_Halls.get(i));
					   Booked_Halls.remove(i);
					   
					   Collections.sort(Avaiable_Wedding_Halls);
					   Collections.sort(Avaiable_Meeting_Halls);
					   Collections.sort(Avaiable_Function_Halls);
					 
					   
					   System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
					   System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
					   System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
					   System.out.print("\n");
				   }
				   
				   //Booked Function Halls
				   else if((int)Booked_Halls.get(i) >=10 && (int)Booked_Halls.get(i) <=15 )
				   {
					   Avaiable_Function_Halls.add((int)Booked_Halls.get(i));
					   Booked_Halls.remove(i);
					   
					   Collections.sort(Avaiable_Wedding_Halls);
					   Collections.sort(Avaiable_Meeting_Halls);
					   Collections.sort(Avaiable_Function_Halls);					 
					   
					   System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
					   System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
					   System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
					   System.out.print("\n");
				   }
				
			   }
		  }
		
	}

}
