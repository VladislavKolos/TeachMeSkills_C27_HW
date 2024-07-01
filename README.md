# TeachMeSkills_C27_Lesson_41_HW
Homework for lesson #41

1. **Task #1**

Developed a web-application using "Spring MVC".
Web-app contains:
- "Spring MVC" configuration class **"AppConfig"** with **"addViewControllers"** and **"viewResolver"** methods. Configures components to work with the web-interface, including scanning components, configuring view controllers and "ViewResolvers";
- A web-application initializer class **"MainWebAppInitializer"** with **"onStartup"** method. This class replaces "web.xml" by setting up the "Spring context" and servlet manager programmatically;
- Utility class **"PostgresUtil"** for managing "PostgreSQL" database connections;
- Class-model **"User"** - class describing the user;
- Service class **"UserService"** with **"createUser"**, **"getUser"**, **"updateUser"** and **"deleteUser"** methods for working with users. Provides methods for creating, getting, updating, and deleting users in a database;
- Controller class **"UserController"** for user management;
- Exception handler class **"UserExceptionHandler"** for controllers. Provides methods for handling various types of exceptions and returning appropriate views.

- JSP-pages **"create_user.jsp"**, **"user_info.jsp"**, **"change_user_login.jsp"** and **"delete_user.jsp"** for user interaction;
- JSP-pages **"RuntimeException_error.jsp"**, **"NullPointerException_error.jsp"**, **"IOException_error.jsp"** and **"ServletException_error.jsp"** to display error messages to users when exceptions occur.

- Resources **"TMS_C27.sql"** and **"TMS_C27.txt"** files contain a script for creating the **"users"** table in the **"TMS_C27 database"**.


