All items in this program must have a name composed of 2 - 256 characters, a serial number composed
of 10 alphaNumeric characters, and a numeric value in US dollars. Serial numbers within the program must be unique.

The left third of the program contains the buttons and fields for user input while the right two-thirds
of the program contain a textField that will output the result of an action as well as a textArea that
will show the inventory list.

Items will be displayed in the textArea to the right. Items are displayed one per line listing their name, serial number,
and value. All numeric values are displayed to the hundredth (e.g., 55.96) to represent their value in US dollars. The
program will try to display the data for the items organized into cleanly organized columns. If the name of an item is
long enough that it extends into the column of the serial number, the program will opt to separate the data by a space
instead and resume using columns on the next item.

From top to bottom, the sections of the program work as follows:

The Dropdown menu for files is in the top left. Clicking that gives the options of either loading a
previously created file or saving the current data within the program to a file. The program supports .tsv, .html, and
.json files. Upon clicking either Load File or Save File, a window will pop open providing the user the option to choose
where the file is being loaded from or saved to. Within that pop-up window, .tsv, .html, and .json can be specified. 
 If the option for loading a file was chosen, the textArea will be populated with the data from the file.

To the right of the File Dropdown, there is a Dropdown menu for sorting. This will sort the inventory in the file by 
name, serial number, or value depending on the option chosen. Sorting by name and serial number orders the items 
alphabetically from A to Z while value orders the items from highest to lowest value.

The next section down is the Add Item section. There are fields for the name, the serial number, and the value of the
item being added to the list. Provided the data input into these fields matches the requirements listed at the top of 
this readme, the Add Item button in this section will add an item with the input data into the list. This will also 
clear these fields so the user can easily add another item afterward.

The section after this is the search section. A Dropdown menu provides the option to search by name or by serial number.
Entering data into the textField in this section and then choosing one of those options from the Dropdown menu will 
display all items that contain the input search string within the chosen field.

The last section of the program is the Edit Item section. This section utilizes the search section above to choose the 
item to be edited. If a search yields exactly one result, the fields in the Edit Item section will automatically be 
populated with the info of that item. To edit this item, simply write over the text in these fields and press the Edit
Item button. Provided the changes do not put the item outside the boundaries of the requirements listed, the item will
be edited to match these changes and the updated information will be displayed in the textArea. Alternatively, to delete
an item, if the search has yielded only one result, pressing the DELETE button will remove the item from the inventory.