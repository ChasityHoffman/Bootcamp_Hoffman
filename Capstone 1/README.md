Budget Tracker
Description
Budget Tracker is a Java console application that allows users to track deposits and payments using a transaction ledger. Transaction data is stored in a CSV file and can be viewed through multiple reporting and search features.


Features
Add Deposits
Add Payments
Store Transactions in a CSV File
View All Transactions
View Deposits Only
View Payments Only
Month To Date Report
Previous Month Report
Year To Date Report
Previous Year Report
Vendor Search
Custom Multi-Criteria Search
Input Validation
ANSI Colorized User Interface

Interesting Code
One of the most interesting parts of this project is the Custom Search feature. Users can search transactions using any combination of:

Start Date
End Date
Description
Vendor
Amount
If a field is left blank, the application ignores that field and continues filtering based on the values that were entered. This allows users to perform flexible searches similar to a real budgeting application.

Example:

Start Date: 2026-11-01
End Date: 2026-11-30
Vendor: Shell
This search would return transactions that occurred in November 2026 where the vendor contains "Shell".

Technologies Used
Java
IntelliJ IDEA
Git
GitHub
CSV File Storage
Object-Oriented Programming (OOP)

How to Run
Open the project in IntelliJ IDEA.
Run the Main.java file.
Use the menu options to add deposits, make payments, view transactions, and run reports.
Transaction data is stored in transactions.csv.

Future Enhancements
Export reports to a file
Add transaction categories
Create charts and graphs
Add a graphical user interface (GUI)
Add user accounts and authentication