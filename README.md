# TeachMeSkills_C27_Lesson_35_HW
Homework for lesson #35

1. **Task #2**

Developed a web-application based on servlets.
Web-app contains:
- Class **"User"** - class describing the user;
- Utility class **"PostgresUtil"** for managing "PostgreSQL" database connections;
  
- **"CRUD"** classes:
- **"CreateUser"** - class for creating a new user in the database;
- **"DeleteUser"** - class for removing a user from the database;
- **"ReadUser"** - class for getting user from database;
- **"UpdateUser"** - class for updating field values in the database.
  
- Servlet classes:
- **"ChangeLoginServlet"** - this servlet class processes requests to change the login of an existing user;
- **"CreateUserServlet"** - this servlet class processes requests to create a new user;
- **"DeleteUserServlet"** - this servlet class processes requests to delete users from the database;
- **"GetUserServlet"** - this servlet class processes requests to retrieve user information based on the user ID.

- Resources:
- **"TMS_C27.sql"** and **"TMS_C27.txt"** files contain a script for creating the **"users"** table in the **"TMS_C27 database"**.

- The **"webapp/WEB-INF"** directory contains JSP-pages:
- **"change_user_login.jsp"**;
- **"create_user.jsp"**;
- **"delete_user.jsp"**;
- **"user_info.jsp"**.
