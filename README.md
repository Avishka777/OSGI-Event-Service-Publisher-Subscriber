# OSGI | Event Reservation Service | Publisher-Subscriber

In this event reservation system, there are two primary user roles: Admin and Receptionist.

1. Admin: The admin role is responsible for managing the available halls within the system. 
They have the authority to add new halls or remove existing ones from the system's 
inventory of Wedding halls, Meeting halls, and Function halls.

2. Receptionist: The receptionist role interacts directly with customers to facilitate hall 
bookings. They can book Wedding halls, Meeting halls, or Function halls for customers 
based on their preferences and requirements. Additionally, the receptionist calculates the 
total bill charge for customers based on the selected halls and any additional services 
requested. Furthermore, they have the capability to release booked halls once the 
customer's event is completed or they leave the premises.

The system maintains separate lists for each type of hall (Wedding, Meeting, Function) to manage 
their availability. The admin can modify these lists by adding or removing halls, while the 
receptionist utilizes these lists to check availability and make bookings.

# How to Setup
1. Download the com.mtit.osgi.EventServicePublisher file and com.mtit.osgi.EventServiceSubscriber file.  
2. Import file to Eclipse IDE.  
3. Right Click "com.mtit.osgi.EventServicePublisher" file -> "Run As" -> "Run Configurations" -> Select "OSGI Framework" -> Rename "OSGI_EventPublisher" -> Check Bundles (Workspace) Selcet Only "com.mtit.osgi.EventServicePublisher" -> " Run" 
4. Wait until the console has stopped.    
5. Press Enter and type "ss".
6. Find Relevent Bundle ID.  
7. Right Click "com.mtit.osgi.EventServiceSubscriber" file -> "Run As" -> "Run Configurations" -> Select "OSGI Framework" -> Rename "OSGI_EventSubscriber" -> Check Bundles (Workspace) Selcet "com.mtit.osgi.EventServicePublisher" and "com.mtit.osgi.EventServiceSubscriber" -> " Run"
8. Now you can run the program

More Reference : https://www.youtube.com/watch?v=kno5CMshHW8&list=PLtoqJbwHBeHydMImt9FrU0KCXihYylc8V&pp=iAQB
