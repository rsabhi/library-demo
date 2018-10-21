# A Book Library Demo   

# clone the library-demo project to local machine using the "git clone" command
(in Windows use command tool or power shell, in mac OS, use the terminal)
git clone https://github.com/rsabhi/library-demo.git

## How to start web application?
Go to the directory where library-demo is downloaded. For eg: in mac machine I downloaded in Documents folder.
"/Users/User-name/Documents/library-demo"
then,
Run command ```mvn jetty:run``` to start the web application.

## How to access web application locally?
Open the browser and paste the following link in the address bar, http://localhost:18082/demo/

## How to insert data (users and books)?
So when starting the application and empty page will be displayed as we are storing the data in in memory. 
Using a POSTMAN to import the .json file [book-library.postman_collection.json]
in github it will be found under the following location:
(https://github.com/rsabhi/library-demo/blob/master/rest-script/book-library.postman_collection.json) 
In local machine it will be found under "/library-demo/⁨rest-script"⁩ folder.

Import the .json script in POSTMAN application. 

1. FIRST Run the script (Run POST /demo/users/batch ) - This will update the user details 
2. THEN Run the script (RUN POST /demo/books/batch). - This will list the book details 
3. Refresh http://localhost:18082/demo/
4. 
