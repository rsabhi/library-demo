# Library Book Borrower Demo

Clone the library-demo project to local machine using the "git clone" command (in Windows use command tool or power shell, in mac OS, use the terminal)

git clone https://github.com/rsabhi/library-demo.git

## How to start web application?
Go to the directory where library-demo is downloaded. For eg: in mac OS download in Documents folder.
"/Users/User-name/Documents/library-demo"
then, 
Run command from library-demo directory, ```mvn jetty:run``` to start the web application.

## How to access web application locally?
Open the browser and paste the following link in the address bar, http://localhost:18082/demo/

## How to view data (users and books)?
So when starting the application an empty page will be displayed as we are storing the data as  inmemory DB. 

To view the data, execute the REST API commands in POSTMAN application.

Using POSTMAN application,  import the .json file [book-library.postman_collection.json]
in github .json file is found under the following location:
(https://github.com/rsabhi/library-demo/blob/master/rest-script/book-library.postman_collection.json) 

In local machine .json file will be found under "/library-demo/⁨rest-script"⁩ folder.

Import the .json script (book-library.postman_collection.json) in to POSTMAN application. 

1. FIRST Run the script (Run POST /demo/users/batch ) - This will update the user details 
2. THEN Run the script (RUN POST /demo/books/batch). - This will list the book details 
3. Refresh http://localhost:18082/demo/
4. User details and books details are updated in the page
5. Click on "view" button in the Books borrowed column. This will show the list of books borrowed by the user.




