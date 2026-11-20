Car Dealership System Part 2
Description
Car Dealership System Part 2 is a Java console application that allows dealership employees to manage vehicle inventory, process vehicle sales and leases, and store contract information in a file. The application loads dealership inventory from a CSV file and allows users to search, add, remove, sell, and lease vehicles.

This project builds upon Workshop 4 by adding contract management through inheritance, abstract classes, file persistence, and pricing calculations for sales and lease agreements.

Features
Vehicle Searches
Search By Price Range
Search By Make and Model
Search By Year Range
Search By Color
Search By Mileage Range
Search By Vehicle Type
Display All Vehicles
Vehicle Inventory Management
Add Vehicle
Remove Vehicle
Save Inventory Changes To File
Sales and Leasing
Create Sales Contracts
Create Lease Contracts
Finance Option For Sales
Automatic Tax, Fee, and Payment Calculations
Automatic Lease Fee and End Value Calculations
Save Contracts To contracts.csv
Remove Sold/Leased Vehicles From Inventory
Technologies Used
Java
IntelliJ IDEA
Object-Oriented Programming (OOP)
Inheritance
Abstract Classes
File I/O
CSV File Storage
ArrayLists
Project Structure
Vehicle
Stores information about a vehicle including:

VIN
Year
Make
Model
Vehicle Type
Color
Odometer
Price
Dealership
Maintains the dealership inventory and contains methods used to search, add, remove, and retrieve vehicles.

DealershipFileManager
Responsible for reading and writing dealership inventory data from inventory.csv.

Contract
Abstract base class that stores common contract information.

SalesContract
Extends Contract and calculates:

Sales Tax
Recording Fee
Processing Fee
Total Price
Monthly Payment
LeaseContract
Extends Contract and calculates:

Expected Ending Value
Lease Fee
Total Price
Monthly Payment
ContractDataManager
Responsible for saving sales and lease contracts to contracts.csv.

UserInterface
Handles user interaction, menu navigation, searching, adding vehicles, removing vehicles, and processing vehicle sales and leases.

Main
Starts the application.

How To Run
Open the project in IntelliJ IDEA.
Ensure inventory.csv exists in:

src/main/resources

Ensure contracts.csv exists in:

src/main/resources

Run Main.java.
Use the dealership menu to search inventory, add vehicles, remove vehicles, process sales, and process leases.