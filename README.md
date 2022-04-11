# Hospital Records
## A database for the record of patients at a hospital

The main purpose of this application is for a hospital 
to keep a record of each of its patients. By the end of 
the project, I aim for the application to have a variety 
of functionalities, including but not limited to;
 
- Storing a patient's contact information
- Recording the patient's diagnosis and suggested 
treatment
- Calculating the total cost for all patients 
(this is essentially the revenue earned by a hospital)
- Keeping the date and time of the next appointment

**Note**: These are the features I would like to add as
of right now, however this might change in the future
depending on how feasible it is to add them.

I intend for this database to be used by the *Medical
Records Department* (MRD) in a hospital. Instead of
having inefficient paper records, this database would
provide the same functionalities (if not more), it
would be far more efficient/robust, and environmentally
friendly. Moreover, if many hospitals adopt the
database, then the data for each of these hospitals
can be collected by the government of the country, and
they can provide statistics (such as an estimate for
the number of patients diagnosed with a given disease).

With the current state of the world due to the COVID-19
pandemic, the poor management and inefficiencies of
nationwide healthcare systems has been brought to light.
Hospitals are desperately trying to keep up with the
influx of patients, and MRDs are struggling to keep up.
With many of my family members being doctors, this idea
stood out for me. I was immediately interested in
trying to make a simple, yet effective and realistic
database to keep records of patients in order to make
others' lives easier. Furthermore, being a student
majoring in Statistics, I was also interested in the
idea that governments could use the data from each
hospital's database in order to provide statistics
regarding a given disease. This further solidified my
desire to make database for the record of patients at
a hospital.

##User Stories

As a user, I want to be able to:

- add multiple patients to a hospital's record
- delete (a) patient(s) from a hospital's record
- find the sum of the costs for all patients in a hospital
- get the average rating for the hospital

- save the Record to file
- load that Record from file and resume exactly where I left off at some earlier time

##Phase 4: Task 2

I have chosen to test and design a robust method in my Record class under the model package. 
It has a method cost() that throws an OutOfBoundsException (an unchecked exception). The RecordTest class has a test
for the case where the exception is expected and another where the exception is not expected.

##Phase 4: Task 3

Had I been given more time, I would've broken down my RecordPanel class so that it
called on other classes, each of which did one button-related function. This would've
made my code easier to read and less prone to checkstyle errors.