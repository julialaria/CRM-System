# CRM-System By Code Warriors

Welcome to CRM-System, the sales tracking application.


CRM will help you:

- Gather contact information from customers who may or may not be interested in your product.

- Convert leads into sales opportunities when they show interest in buying the product.

- Associate an opportunity with an account.

- Associate contacts with an opportunity.

The application instructions are detailed below:

1) At the beginning, if the user does not know which commands are available, he can enter COMMANS HELP via the console. A list like this will be displayed:

## COMMAND HELP
![Command Help](doc/commandshelp1.PNG)


The very first order will always be to create a **new lead (NEW LEAD)**, as this is the way to obtain a new customer. To create this lead, the user will be asked to enter their name, telephone number, email and the company to which the lead belongs. These variables must be entered in the appropriate format, which will be indicated in case of incorrect input.

Once one or more Leads have been created, we have the option to **SHOW LEADS**, all Leads will be displayed with their corresponding id. If you want more details of a specific lead, just enter **LOOKUP LEAD + <Lead ID>**.

When a Lead shows interest in one of the products, it will automatically become an Opportunity. To make this conversion, enter **CONVERT + <Lead ID>**, and indicate by console which product he/she is interested in (HYBRID, FLATBED, BOX) and how many of them he/she would like.

When **converting Lead to Opportunity**, two new objects will be automatically created: **Contact** and **Account**. The Contact will directly take the Lead's data (name, phoneNumber, email and companyName), while for the creation of the Account, the console will ask for the industry to which the company belongs (PRODUCE, ECOMMERCE, MANUFACTURING, MEDICAL, OTHER), the location of the company and the number of employees.

As with the Leads, the **LOOKUP OPPORTUNITY + ID** command can be entered to view information about the opportunity.

Once the customer has decided if he/she is interested in buying the products, this Opportunity can be closed, either as **CLOSE WIN** if he/she buys the products, or as **CLOSE LOST** if he/she does not want the products. 



## Class Diagram:
![Class Diagram](doc/diagrams/ClassDiagram.jpg)

## Use Case Diagram:
![Use Case Diagram](doc/diagrams/UseCaseDiagrams.jpg)
