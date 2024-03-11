package com.mtit.osgi.eventservicepublisher;

import java.util.ArrayList;
import java.util.HashMap;

public interface EventService {
	
	public String LoginVerification(String username,String password);
	
	public void Book_Wedding_Hall(int no_of_halls,ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls,ArrayList Booked_Halls);
	
	public void Book_Meeting_Hall(int no_of_halls,ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls,ArrayList Booked_Halls);
	
	public void Book_Function_Hall(int no_of_halls,ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls,ArrayList Booked_Halls);
	
	public void Add_Wedding_Meeting_Function_Hall(String HallType,ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls,int hallno);
	
	public void Remove_Wedding_Meeting_Function_Hall(String HallType,ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls,int hallno);
	
	public void ReleaseHall(int Booked_Hallno,ArrayList Avaiable_Wedding_Halls,ArrayList Avaiable_Meeting_Halls,ArrayList Avaiable_Function_Halls,ArrayList Booked_Halls);
	
}
