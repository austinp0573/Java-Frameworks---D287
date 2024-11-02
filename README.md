# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
## Austin Pelley - Performance Assessment
#### README.md created to fulfill prompt B. includes notes describing where in the code to find the changes made for each of parts C to J. Each note includes the prompt, file name, line number, and change.

Section C.  Prompt: Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

1) File: mainscreen.html - Line 14 - Changed "My Bicycle Shop" to "Austin's Car Emporium"
2) File: mainscreen.html - Line 19 - Changed "Shop" to "Austin's Car Emporium"
3) File: mainscreen.html - Line 21 - Changed "Parts" to "Car Parts"
4) File: mainscreen.html - Line 53 - Changed "Products" to "Cars"

Section D. Prompt: Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

1) File: About.html - Line All - Created a new .html file titled "About.html" in the templates section. Filled this file with a description of the business and a link that would direct users to mainscreen.html.
2) File: - AboutController.java - Line All - Created a new Java Class in the controllers section titled AboutController.java that would use the spring @GetMapping annotated method to route "@{/about}" to the About.html file.
3) File: - mainscreen.html - Line 89 - Added a line that provides a link from mainscreen.html to About.html


Section E. Prompt: Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

1) File: - BootStrapData.java - Line 41 & 42 - added long variable that would equal number of items in part and product repositories for use in coming if statement.
2) File: - BootStrapData.java - Line 61 - Inserted if statement that would only execute if the above defined variables were equal to 0  
3) File: - BootStrapData.java - Line 63 through 96 - Declared 5 outsourced parts and defined them
4) File: - BootStrapData.java - Line 98 through 102 - Added the created parts to the OutsourcedPartsRepository
5) File: - BootStrapData.java - Line 104 through 108 - Declared 5 products and defined them
6) File: - BootStrapData.java - Line 110 through 114 - Added the created products to the ProductRepository

Section F. Prompt: Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

1) File: - mainscreen.html - Line 85 and 86 - added the "Buy Now" button to the mainscreen so that it would appear to the right of the "Delete" button that was already present
2) File: - BuyNowConfirmation.html - Line All - created a basic .html page that would return a message if the buy now feature was successful
3) File: - BuyNowError.html - Line All - created a basic .html page that would return a message if the "Buy Now" feature failed
4) File: - Product.java - Line 108 through 116 - added boolean function (buyProduct) to Product.java that would check the inventory value and decrement if it was greater than 0
5) File: - AddProductController.java - Line 177 through 187 - added mapping to the AddProductController.java that would handle appropriate redirection from mainscreen.html depending on the success for failure of the newly added "Buy Now" feature


Section G. Prompt: Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

1) File: - mainscreen.html - Line 38 and 39 - added "Minimum" and "Maximum" headers to the table in the mainscreen
2) File: - mainscreen.html - Line 48 and 49 - added table data so that the Minimum and Maximum fields for a given part would be correctly populated
3) File: - Part.java - Line 35 through 37 - initialized inventoryMinimum and inventoryMaximum and used "@Min" to prevent minimum value from being negative
4) File: - Part.java - Line 51 and 52 & 60 and 61 - Added default inventoryMinimum and inventoryMaximum values to the part constructors
5) File: - Part.java - Line 96 through 103 - used the limitsValid() method to check if the value was within parameters, and in the event that it is not, to forcibly set it to the threshold value
6) File: - Part.java - Line 131 through 145 - added getter and setter functions for the inventoryMinimum and inventoryMaximum
7) File: - InhousePart.java & OutsourcedPart.java - Line 18 and 19 - added default values for inventoryMinimum and inventoryMaximum for Inhouse and Outsourced parts
8) File: - InhousePartForm.html - Line 24 through 34 - added fields so Minimum and Maximum could be input by the user as well as an error if the minimum value is less than 0
9) File: - OutsourcedPartForm.html - Line 25 through 35 - added fields so minimum and maximum could be input by the user as well as an error if the minimum value is less than 0
10) File: - application.properties - line 6 - Located the database file in system memory, deleted it, and reinitialized it with a new value "Spring-Boot-D287-Database"
11) File: - InhousePartServiceImpl.java - Line 54 - used the limitsValid() method from Part.java to ensure that the minimum & maximum value was within parameters, and in the event that it is not, to forcibly set it to the threshold value
12) File: - OutsourcedPartServiceImpl.java - Line 52 - used the limitsValid() method from Part.java to ensure that the minimum & maximum value was within parameters, and in the event that it is not, to forcibly set it to the threshold value

Section H. Prompt: Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

1) File: - minValidator.java - Lines All - created a java class in the validator section that would ensure that the value of inventory was not less than the set minimum
2) File: - Validmin.java - Lines All - created an annotation to go with the above created minValidator.java that would display an appropriate error message
3) File: - maxValidator.java - Lines All - created a java class in the validator section that would ensure that the value of the inventory was not greater than the set maximum
4) File: - Validmax.java - Lines All - created an annotation to go with the above created maxValidator.java that would display an appropriate error message
5) File: - EnufPartsValidator.java - Line 36 - added to the already existing if statement so that the validator would also check to ensure that the inventory was greater than the set minimum
6) File: - ValidEnufParts.java - Line 20 - altered the return statement in the annotation for the EnufPartsValidator.java class so that it would return an appropriate message in the event of an error
7) File: - Part.java - Lines 20 & 21 - added the "@Validmin" & "@Validmax" annotation reference to the Part.java class

Section I. Prompt: Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

1) File: - PartTest.java - Lines 104 through 120 - Added a unit test for the minimum and a unit test for the maximum to the PartTest.java class

Section J. Prompt: Remove the class files for any unused validators in order to clean your code.

1) File: - DeletePartValidator.java - Lines All - removed the validator that was unused