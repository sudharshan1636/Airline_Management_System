# AirlineManagementSystem
## Introduction
This repository contains the source code for the project 'Airline Management System' which was developed using JavaFX, Scenebuilder and MySQL. The system provides details such as passenger information, flight information, payment information etc.

## Modules
It consists of the following modules:
### 1. Login Module:
This module acts as the login page of the application which allows the user to proceed further only when valid credentials for username and password have been entered. On entering the incorrect details, a ‘Login Failed’ label is displayed and only when valid username and password are entered is when the user proceeds to the home page.<br>
<b>Username</b>: user<br>
<b>Password</b>: pass<br>
<img src="https://user-images.githubusercontent.com/109339459/230628314-5e82e486-9107-4520-985a-f24585fcb356.png" width=600 height=400><br><br><br>

### 2. Home Page:
The Home Page is the landing page where the user is directed after logging successfully. It consists of two tabs, the Welcome tab and the Show Flight Details. The Show Flight Details tab displays the details of the flights stored such as Flight Code, Name , Source, Destination etc.<br>
<img src="https://user-images.githubusercontent.com/109339459/230628545-32597cd0-2dfe-4ab3-aa2e-36af04b934a5.png" width=600 height=400><br>
<img src="https://user-images.githubusercontent.com/109339459/230630622-8a480bd8-c30a-4a50-bb2e-ab73f9e57631.png" width=600 height=400><br><br><br>

### 3. Add Flight Details Module:
The add flight module enables the user to add a flight along with its details to the database. Details such as flight code, flight name, source, destination, capacity and date of journey have to entered and on clicking the ‘Add Flight’ button, a message prompt is displayed and the flight details get successfully added into the database and can be verified by viewing the flight details on the home page of the application.<br>
<img src="https://user-images.githubusercontent.com/109339459/230628908-418b1497-8a73-4279-bbf8-c19a76c2b373.png" width=600 height=400><br><br><br>

### 4. Remove Flight Details Module:
The remove flight module enables the user to remove a flight along with its details from the database. The user has to choose the flight code to be deleted from a list of flight codes and upon choosing the desired flight code, the details of that particular flight get loaded automatically into their respective fields which 
are non-editable. On clicking the ‘Remove Flight’ button, a message prompt is displayed and the flight details get successfully removed from the database and the same can be verified by viewing the flight details on the home page of the application.<br>
<img src="https://user-images.githubusercontent.com/109339459/230628981-6d68b343-7d1e-4f2b-afa3-b840c139f13e.png" width=600 height=400><br><br><br>

### 5. Modify Flight Details Module:
The modify flight module enables the user to modify the flight details of a flight which is already existing in the database. The user has to choose the flight code to be modified from a list of flight codes displayed and upon choosing the desired flight code, the details of that particular flight get loaded automatically into their respective fields which are modifiable. The user can now modify the desired details and click on the ‘Modify Flight’ button to proceed further. Upon successful modification of the flight details, a message prompt is displayed and the same changes can be verified by viewing the flight details on the home page of the application.<br>
<img src="https://user-images.githubusercontent.com/109339459/230629739-2549a3b1-0f2e-4803-af23-1e17fcaffa1b.png" width=600 height=400><br><br><br>

### 6. Book Ticket Module:
This module enables the user to book a ticket for a flight which exists in the database. The user can view all the flight details of all flights available in the form of a table after which he can select the desired flight code from a list of flight codes available. Now the user has to enter passenger details such as passenger name, phone number nationality and passport number. Further, the user has to enter payment details such as the card number. The amount to be paid by the user and the payment date get loaded automatically and cannot be modified where the payment date is set as the current date. On clicking the ‘Book Ticket’ button, a message prompt is displayed and the booking can be verified by visiting the passenger details and payment details modules of the application.<br>
<img src="https://user-images.githubusercontent.com/109339459/230629826-d853eb8a-d4cb-4bc6-b053-d629819bd28a.png" width=600 height=400><br><br><br>

### 7. Cancel Ticket Module:
The cancel ticket module enables the user to cancel a booked ticket for a flight which exists in the database. The user has to choose the PNR number from the list of options available after which passenger details get loaded automatically in the respective fields which are non-editable. On clicking, the ‘Cancel Ticket’ button, a message prompt is displayed and the cancellation of ticket can be verified by visiting the passenger details and payment details modules of the application.<br>
<img src="https://user-images.githubusercontent.com/109339459/230629930-f018b1e8-b32b-45a1-bf8c-cdbdcf9045b1.png" width=600 height=400><br><br><br>

### 8. Passenger Details Module:
The passenger details module enables the user to view the details of each and every passenger who has booked a ticket for a flight existing in the database. The details such as PNR number, name, phone number, nationality, passport number and the flight code of the flight booked are displayed in theform of a table for the user to view.<br>
<img src="https://user-images.githubusercontent.com/109339459/230630106-2c63acd3-3a8d-4d99-aa69-65406e9ed245.png" width=600 height=400><br><br><br>

### 9. Payment Details Module:
The payment details module enables the user to view the payment details of every passenger who has booked a ticket for a flight existing in the database. The details such as PNR number, phone number, card number, amount paid and payment date are displayed in the form of a table for the user to view.<br>
<img src="https://user-images.githubusercontent.com/109339459/230630224-94977c00-03d2-4d67-9c33-2a6a5bd1a318.png" width=600 height=400><br><br><br>

<b>Frontend:</b> JavaFX, Scenebuilder<br>
<b>Database:</b> MySQL
