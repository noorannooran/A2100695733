# COMP3074 Android App Development Assignment 2
## TO-DO

[x] classes for tables
	[x] User
	[x] Doctor
	[x] Nurse
	[x] Patient
	[x] Test
[ ] Activities
	[ ] welcome activity - home screen: logo + login button
		[ ] layout
			[X] add placeholder logo
			[ ] add button
			[ ] general styling
		[ ] add onClickFunctionality -> triggers LoginActivity
	[ ] login activity
		[ ] layout
			[ ] add text boxes
			[ ] add labels
			[ ] add login button
			[ ] general styling
		[ ] add onClickFunctionality -> check authentication -> triggers MainMenu activity
	[ ] main menu activity
		[ ] list view - Enter Patient, Enter Test
		[ ] Submit Button -> Enter Patient Activity or Enter Test Activity
	[ ] enter patient activity
		[ ] layout
			[ ] text boxes
			[ ] dropdown for doctor
			[ ] add patient button
		[ ] validation of patient information -> create new Patient
		[ ] onClick functionality -> insert Patient into db
		[ ] Toast message : errors, success
	[ ] enter test activity
		[ ] layout
			[ ] text boxes
			[ ] dropdown for patient
			[ ] add test button
		[ ] validation of test information -> create new Test
		[ ] onClick functionality -> insert Test into db
		[ ] Toast message : errors, success
	[ ] display information
		[ ] layout
			[ ] spinner or radio? patient or test
			[ ] on select -> fragment? with spinner: patients by name, tests by patient name?
			[ ] submit button -> displays fragment? with information on it
[ ] SQLiteOpenHelper custom class
	[x] execSQL statements create each table
	[x] insert methods for each table
	[ ] insert dummy data
	[ ] select statements
		[ ] user (authentication)
		[ ] patient
		[ ] tests - by patient id, by doctor? 
[ ] styling
	[x] add custom colors to colors.xml file
	[ ] GIMP transparent medic logo - text and image
	[ ] general styling for each layout
