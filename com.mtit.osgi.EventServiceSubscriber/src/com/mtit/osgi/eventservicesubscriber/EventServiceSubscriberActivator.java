package com.mtit.osgi.eventservicesubscriber;

import java.util.ArrayList;
import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import com.mtit.osgi.eventservicepublisher.EventService;
import com.mtit.osgi.eventservicepublisher.EventServicePublishImpl;




public class EventServiceSubscriberActivator implements BundleActivator {

	private static BundleContext context = null;
	
	private ServiceTracker m_tracker = null;

	static BundleContext getContext() {
		return context;
	}
	
	
	public void start(BundleContext bundleContext) throws Exception {
		
		EventServiceSubscriberActivator.context = bundleContext;
		
		m_tracker = new ServiceTracker(context, context.createFilter("(&(objectClass="+EventService.class.getName()+")"+"(Language=*))"),null);   
	    m_tracker.open();
	    System.out.println("Event Subscriber Service Start Successfully");
	    
	    try 
	    {
	    	String Book_Release_Hall,username,password,choice,Hall_Add_type;
	    	int Booked_Hall_No,Add_Hall_No,Remove_Hall_No;
	    	String Hall_type = null;
			int no_of_halls = 0;
			float Total_Hall_Charge;
			 
			
			ArrayList<Integer> Avaiable_Wedding_Halls  = new ArrayList<Integer>();
			ArrayList<Integer> Avaiable_Meeting_Halls  = new ArrayList<Integer>();
			ArrayList<Integer> Avaiable_Function_Halls  = new ArrayList<Integer>();
			
			ArrayList<Integer> Booked_Halls = new ArrayList<Integer>();
			 
			 
			Avaiable_Wedding_Halls.add(1);
			Avaiable_Wedding_Halls.add(2);
			Avaiable_Wedding_Halls.add(3);
			Avaiable_Wedding_Halls.add(4);
			Avaiable_Wedding_Halls.add(5);
			 
			Avaiable_Meeting_Halls.add(6);
			Avaiable_Meeting_Halls.add(7);
			Avaiable_Meeting_Halls.add(8);
			Avaiable_Meeting_Halls.add(9);
			Avaiable_Meeting_Halls.add(10);
			 
			Avaiable_Function_Halls.add(11);
			Avaiable_Function_Halls.add(12);
			Avaiable_Function_Halls.add(13);
			Avaiable_Function_Halls.add(14);
			Avaiable_Function_Halls.add(15);
		 
			System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
			System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
			System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
			 
			Scanner scan = new Scanner(System.in);
			EventService hallservice = new EventServicePublishImpl();
			
			while(true)	
			{		
				System.out.println("====== Login =========================");
				System.out.print("Enter UserName : ");
				username = scan.next();
				
				if(username.equals("end"))
				{
					System.out.println("Ending The service ");
					break;
				}
				

				System.out.print("Enter Password : ");
				password = scan.next();
				System.out.println("======================================\n");
				
				choice = hallservice.LoginVerification(username, password);
			  
				if(choice=="admin")
				{
					System.out.println("~~~~~~~~~~~ Welcome Admin ~~~~~~~~~~~");
					System.out.println("Available Wedding Halls:"+Avaiable_Wedding_Halls);
					System.out.println("Available Meeting Halls:"+Avaiable_Meeting_Halls);
					System.out.println("Available Function Halls:"+Avaiable_Function_Halls);
					
					System.out.print("Do You Wont Add Hall or Remove Hall or logout (add / remove / 0) :");
					choice = scan.next();
					
					//Add Halls
					if(choice.equals("add"))
					{
						  System.out.print("Enter Hall Type(Wedding / Meeting / Function ):");
				          Hall_Add_type = scan.next();
				          
				          System.out.print("Enter Add Hall No :");
				          Add_Hall_No = scan.nextInt();
				          
				          hallservice.Add_Wedding_Meeting_Function_Hall(Hall_Add_type,Avaiable_Wedding_Halls,Avaiable_Meeting_Halls,Avaiable_Function_Halls,Add_Hall_No);
						
					}
					
					//Remove Halls
					else if(choice.equals("remove"))
					{
						  System.out.print("Enter Hall Type(Wedding / Meeting / Function ):");
				          Hall_Add_type = scan.next();
				          
				          System.out.print("Enter Remove Hall No:");
				          Remove_Hall_No = scan.nextInt();
							
				          hallservice.Remove_Wedding_Meeting_Function_Hall(Hall_Add_type, Avaiable_Wedding_Halls, Avaiable_Meeting_Halls,Avaiable_Function_Halls,Remove_Hall_No);
					}	
					
				}
				else if(choice=="reception")
				{
			    	System.out.println("~~~~~~~~~~~ Welcome Hall Reservation ~~~~~~~~~~~");
			    	
			    	System.out.println("Wedding Hall Charge: Rs 100 000/=");
			    	System.out.println("Meeting Hall Charge: Rs 50 000/=");
					System.out.println("Function Hall Charge: Rs 30000/=");
					
					System.out.println("Available Wedding Halls: "+Avaiable_Wedding_Halls);
					System.out.println("Available Meeting Halls: "+Avaiable_Meeting_Halls);
					System.out.println("Available Function Halls: "+Avaiable_Function_Halls);
					
				    System.out.print("Enter Hall Service Type (Book / Release):");
			        Book_Release_Hall = scan.next();
			        
			        if((Book_Release_Hall.equals("Book") || Book_Release_Hall.equals("book")) )
			        { 
			        	System.out.print("Enter Hall Type(Wedding / Meeting / Function ):");
				        Hall_type = scan.next();
				
				        System.out.print("Enter No of Halls:");
				        no_of_halls = scan.nextInt();
			        }
			    
					 if(Hall_type.length() == 0 || Book_Release_Hall.length() == 0)
					 {
						 break;
					 }	 
					 else if(hallservice == null)
					 {
						 System.out.println("No Service Available");
					 }		 
				 
					 else if((Book_Release_Hall.equals("Book") || Book_Release_Hall.equals("book")) )
					 {  
					
						 if(Hall_type.equals("Wedding") || Hall_type.equals("wedding"))
						 { 
						 hallservice.Book_Wedding_Hall(no_of_halls,Avaiable_Wedding_Halls,Avaiable_Meeting_Halls,Avaiable_Function_Halls,Booked_Halls);
						 }
						 
						 else if(Hall_type.equals("Meeting") || Hall_type.equals("meeting"))
						 {
							 hallservice.Book_Meeting_Hall(no_of_halls,Avaiable_Wedding_Halls,Avaiable_Meeting_Halls,Avaiable_Function_Halls,Booked_Halls);
						 }
						 
						 else if(Hall_type.equals("Function") || Hall_type.equals("function"))
						 {
							 hallservice.Book_Function_Hall(no_of_halls,Avaiable_Wedding_Halls,Avaiable_Meeting_Halls,Avaiable_Function_Halls, Booked_Halls);
						 }
						 
						 else
						 {
							 System.out.println("Hall Type is not Available");
						 }	 
		  
					 }	 
					 
					 else if((Book_Release_Hall.equals("Release") || Book_Release_Hall.equals("release")))
					 {
				 
						 System.out.print("Enter Release Hall No:");
	                     Booked_Hall_No = scan.nextInt();
		
						 hallservice.ReleaseHall(Booked_Hall_No,Avaiable_Wedding_Halls,Avaiable_Meeting_Halls,Avaiable_Function_Halls,Booked_Halls);
			    
					 }
					 else
					 {
						 System.out.println("Type is Not Available");
						 
					 }	
			 
				}   
			}	 
	    }			
	    catch (Exception e)
	    {
	    	// handle exception 
	    }
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		EventServiceSubscriberActivator.context = null;
		
		System.out.println("Event Subscriber Service Stop Successfully");
	}

}


