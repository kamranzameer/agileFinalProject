WORK PACKAGES MANAGEMENT
LIVE URL
http://52.5.93.209:8082/wpm/index.jsp
LOGIN CREDENTIALS
Demand management group user : userdm1/passwd
Application group user : userapp1/passwd

TEAM NAME: 
The Incredibles
TEAM MEMBERS
* Usha Annipu (PO and DEV)
* Kamran Zameer (DEV)
* Yetish Narayana (SM and DEV)

PRODUCT VISION:
Accomplish faster throughput and greater transparency when estimating RFPs and Work Packages.
PROBLEM STATEMENT:
* Each application team captures estimates in spreadsheets
* Each application team captures assumptions and justification for the estimates in word doc
* Aggregate the estimates and assumptions manually
* Demand management group requests for RFP estimates via email

SOLUTION:
The work packages will need to be dispatched by a demand management user to all the impacted applications.  A “work package” defines an overall work package that is created initially by a demand management user. Work package information is collected during this process along with impacted applications. The work package once submitted triggers multiple “work requests” by application and is dispatched to the individual application contacts.
When an application user logs into the system, will need to take an action on the “work request” which is pending in his queue. 
There can be multiple activities that need to be developed to support the work package. Application user enters hours by activity and assigns one or more resources for each activity line. Based on the resource type and their hourly rates, total estimate is calculated and then submitted for that particular application. The user will also be allowed to enter assumptions and justification for the activity line so that it can be reviewed along with the total amount.
Likewise, all the estimates are collected from all the application users and when all the “work requests” are completed, a business user will be able to view various estimates provided by all the application users and will be able to view the total amount it costs to support the new work package that he/she submitted.
A business user can choose different criteria to view the reports, such as show all approved work, show cancelled work, show open work, show all work packages etc.
TECHNOLOGY:
Authentication - Apache Shiro framework
UI - JQuery, JSP
Language - Java
Framework - Spring and Struts
Web Server – Tomcat
Build - Maven
Continuous integration - Jenkins
Unit Testing - JUnit
Database - Oracle
Production Server - AWS Server - EC2
STAKEHOLDERS: 
* Ted Geherty, IT Director of Demand Management Group
* Kimi Glaab , IT services consultant works in Demand Management Group.
* Jennifer Brown who is an Executive Director in the Strategic bidding and contracting group.
* Donna Ott is a Sr.Director for Program Operations who oversees operations group for Teacher Licensure Tests.
* Marianne Gorcz is a finance manager
HIGH LEVEL REQUIREMENT:
* A user interface to capture information such as work description, work title, live date, testing program, applications impacted etc. about the work package or RFP, available for demand management users.
* A user interface to capture estimates in hours, amount by activity line items with assigned resources. The total amount should be calculated automatically based on the hourly rate of a particular resource assigned to the activity. This UI is applicable for individual application users who are impacted by the RFP or a work package. The UI should also allow to capture assumptions for each work request.
* A user interface to show the reports, based on criteria selected. Any number of work packages can be selected based on the criteria and aggregation report or view is available for either demand management users or business users.
* Capability to edit the work package by business or demand management users to primarily change the status of the work package to either approved, cancelled or open.
* Support for enhanced criteria for report generation based on date range. Search for work packages with creation time based on date range.
* Resource management user interface to manage resource allocation on each of the work packages once the work is approved.
* Create user/role user interface
* Support for administrative work to assign application contacts to appropriate applications.
* UI to view the budget forecast by monthly, quarterly, yearly basis.
* Enhanced UI to estimate hardware requirements to support work packages. The cost varies based on the number of servers, Engineer support, Number of environments, memory, CPU, processors, hard disk etc. 
* UI to support different portfolios and customize the view by application groups for easy maintenance for the business users so that they can navigate to individual groups easily.
* Search capability of the work packages by id, description, statuses, on the application users view as well as the business users.
PRODUCT BACKLOG ITEMS:
* Updated Product Backlog Items can be seen at following URL:
* https://github.com/kamranzameer/agileFinalProject/blob/master/docs/WorkPackageManagement_PBI.xlsx
DEFINITION OF DONE:
* Code is complete and produced and is checked into the repository against the current version
* Code is well formatted with comments for readability
* Code builds without any errors
* Unit tests are written and ensure all the tests are passing
* Documentation, or use case specifications produced if applicable
* Deployed to AWS server and passes Smoke Test.
* Passes User Acceptance testing when applicable
* Code reviews conducted or pair programmed.
* Verify upgrade while keeping all the code intact. 
* Summary of changes updated to include newly implemented features

ASSUMPTIONS:
Demand management users have knowledge of all application systems in the company.



SPRINT 1 STATUS REPORT : 
https://github.com/kamranzameer/agileFinalProject/blob/master/docs/Sprint%201/Sprint%201%20Status%20Report.docx

SPRINT 2 STATUS REPORT :
https://github.com/kamranzameer/agileFinalProject/blob/master/docs/Sprint%202/Sprint%202%20Status%20Report.docx

SPRINT 3 STATUS REPORT :
https://github.com/kamranzameer/agileFinalProject/blob/master/docs/Sprint%203/Sprint%203%20Status%20Report.docx 




