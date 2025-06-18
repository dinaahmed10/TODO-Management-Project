Build REST APIs for the TODO management project.

In this project, the APIs will allow users to perform CRUD operations (Create, Read, Update, Delete) and additional operations like marking a TODO as complete or incomplete.

The operations include:

Add a TODO: Create a new task.

Get a TODO: Retrieve a specific task by its ID.

Get all TODOs: Retrieve a list of all tasks.

Update a TODO: Modify an existing task
.
Delete a TODO: Remove a task.

Complete a TODO: Mark a task as completed.

Incomplete a TODO: Mark a task as not completed.






Secure the REST APIs using role-based authorization.

implementing a security mechanism where access to certain APIs is restricted based on user roles. 

There are two roles: Admin and User. Only users with the Admin role can access the APIs for adding, updating, and deleting TODOs.

Other APIs (e.g., getting TODOs) are accessible to both Admin and User roles.
