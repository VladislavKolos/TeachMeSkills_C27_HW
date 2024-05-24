# TeachMeSkills_C27
Homework for lesson #30

1. **Task**

The **"save-request.jsp"** page has been created, containing a form for entering a application. The form sends data in a POST-request to the servlet, which validates it. If one of the fields not specified, the servlet redirects to the data entry page again. If are specified correctly, the servlet redirects to the page on which the text: "Application successfully saved" with information from the form displayed.
The web-project contains:
- Servlet class **"SaveRequestServlet"** with **"doGet"** method that processes a GET-request to open a page containing a form for entering an application and with **"doPost"** method that processes a POST-request to check the data sent by the form:
- if one of the fields not specified, the servlet redirects to the data entry page;
- if the fields are correct, the servlet redirects to successful save page.
- **"save-request.jsp"** page, containing a form for entering a application;
- **"successful-save.jsp"** page on which the text: “Application successfully saved” with information from the form displayed.
