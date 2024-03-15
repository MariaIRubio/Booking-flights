
### Exercise: Booking Flights with validation in Spring

#### Objective:
To develop a flight booking system for an airline company's website, including validation for input fields using regular expressions.

#### Scenario:
You should build a flight booking system for an airline company's website. The booking form should collect passenger information such as name, email, phone number, departure date, destination, etc. Furthermore, you need to validate the input fields using regular expressions and integrate default security configuration provided by Spring Boot to secure the application.

#### Instructions:

#### Set up a Spring Boot project with Maven:
  - Create a new Maven project and include the necessary dependencies for Spring.

#### Create a flight booking form:
  - Design a booking form using HTML and Thymeleaf. Include fields for passenger information such as name, email, phone number, departure date, destination, etc.

#### Implement Java-based validation using regular expressions:
  - Create a Java class to represent the booking. Add validation annotations to validate each field. Use regular expressions where necessary, for example, to validate email addresses, phone numbers, etc.

#### Integrate default security configuration provided by Spring Boot:
  - Spring Boot provides default security configuration out of the box. Configure your application to leverage this default security configuration to secure the booking form and other endpoints.

#### Save booking data in the database:
  - Configure your application to connect to a database using Spring Data JPA or any other preferred persistence framework. Create a repository interface for the booking entity to perform CRUD operations.

#### Display appropriate error messages for invalid input fields:
  - Handle validation errors in your controller. If any field fails validation, return the user back to the booking form with error messages indicating the invalid fields.

#### Set up a controller to handle form submission and process the booking:
  - Create a controller class to handle form submissions. Define methods to display the booking form, process form submissions.

#### Display a success message or redirect to a confirmation page:
  - After successfully saving the booking data, redirect the user to a confirmation page or display a success message indicating that the booking was successful.
