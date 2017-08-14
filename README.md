# TODO-List-Tech-Module
TODO List (in C#, Java, JS and PHP) - Exam Preparation for the Tech Module @ SoftUni (August 2017)

You are assigned to create a **Simple TODO List App**. The application should hold **tasks**, which are the main app entities.
The functionality of the app should support creating, listing, editing and deleting tasks. The application should persist the data into a database.

## Overview
Your application should be built on each one of the following technologies:

### PHP
* **Symfony** framework
* **Twig** view engine
* **MySQL** database

### JavaScript
* **NodeJS** + **ExpressJS** frameworks
* **Handlebars.js** view engine
* **MongoDB** database

### Java
* **Spring** framework (Spting MVC + Spring Boot + Spring Data)
* **Thymeleaf** view engine
* **MySQL** database

### C#
* **ASP.NET** framework (ASP.NET MVC + Entity Framework)
* **Razor** view engine
* **MSSQL Server** database

## Data Model
The `Task` entity holds 3 properties:
* `id` - technology-dependent identifier (`ObjectID` for JavaScript, `int` for all other technologies)
* `title` - nonempty text
* `comments` - nonempty text

## User Interface
This is the user interface or how the application’s pages should look in their final form (fully implemented). You should have 3 pages:

### Index Page
Route: “/” (GET)
List all tasks.
 
### Create Page
Route: `/create` (GET and POST)
`GET` shows a form to create a task. `POST` saves the form data into the database as new task.
 
### Delete Page
Route: `/delete/{id}` (GET and POST)
`GET` shows a form to delete a certain task. `POST` confirms deleting a task and removes the task from the database.

### Edit Page
Route: `/edit/{id}` (GET and POST)
`GET` shows a form to edit a certain task. `POST` confirms editing a task and modifies the task in the database.
 
## Languages and Technologies
Implement the **TODO List App** on all mentioned 4 technology stacks.

## Setup
Before you start working, make sure you download all the dependencies (packages) required for each technology and set up the databases! Below are instructions on how to do this:

### PHP
1. Go into the root directory of the project (where the bin folder resides)
2. Make sure you’ve started your MySQL server (either from XAMPP or standalone)
3. Open a shell / command prompt / PowerShell window in that directory (shift + right click --> open command window here)
4. Enter the `php composer.phar install` command
5. Enter the `php bin/console doctrine:database:create` command
6. Done!

### JavaScript
1. Go into the root directory of the project (where the bin folder resides)
2. Make sure you’ve started your MongoDB server: `mongod.exe --dbpath path/to/db/directory`
3. Open a shell / command prompt / PowerShell window in the root directory (shift + right click --> open command window here)
4. Enter the `npm install` command
5. Done!

### C# and Java
C# and Java projects automatically resolve their dependencies when the project is built.
