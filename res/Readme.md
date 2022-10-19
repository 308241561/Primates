# About/Overview

This program is used for replacing the paper version of the Jungle Friends’ Monkey handling. It will be used to keep track of the monkeys that are brought in for medical attention, evaluation and then put into enclosures for better maintaining their help. This program will also be able to report the monkeys, report the species, look up some type of monkey, provide sign of a certain enclosure, produce a shopping list for the whole sanctuary.

# List of features

1. Create a new Sanctuary with given number of isolations and given number of enclosures.
2. Increase the isolation with given number
3. Increase the enclosure with given number
4. Increase the enclosure capacity with given number
5. add new monkey to the isolation for medical attendtion
6. remove monkey from the isolation and put it into an enclosure.
7. Check if a monkey in the Sanctuary can be moved into an enclosure
8. Report Species
9. Look Up a species
10. Produce a Sign for a enclosure
11. Produce Monkey List
12. Produce Shopping List
13. Adjust isolation limits for future budget increase
14. Adjust enclosures limits for future budget increase

# How To Run

1. Simply click the jar file in the res folder of the submission.
2. No input needed

# How to Use the Program

1. First of all we need to construct a sanctuary by deciding how many isolations and enclosures do you need, how much initial capacity do you need for each of the enclosure.
2. Then you will be able to create the sanctuary with the isolations and enclosures.
3. Then create the monkey using the several parameters
4. Add the monkey to the available isolations first
5. After getting medical attention/quarantined, remove them from the isolation
6. Add the quarantined monkeys to any of the available enclosure.
7. Add more monkeys and follow the above steps to put them in the isolation first for medical attention and then to the right enclosure.
8. Pay attention to the species of the enclosure because only the same species can be put together, other than that, you also need to be aware of the available space of a enclosure. Each of the enclosure’s space is predefined at the beginning.
9. At any stage of the above steps, you can ask for a monkey list, report species location in the sanctuary, produce a sign of a certain enclosure, produce a list of food.

# Description of Examples

Step 1-6 is the first test run. It includes construct a sanctuary and add the monkey to the sanctuary’s isolation first and then transport the monkey to enclosure. After that get some required information from the sanctuary.
Step 7-15 is the second test run. It also includes most of the above require steps and some other exception handling cases. For example, in step 12, we tried to add another monkey to the enclosure and it did went well, and in the next a few steps, we tested the type mismatch and the enclosure capability limit reached situation. The program did what we expected by throwing exceptions in the test classes. Also we have the work around feature that allow the monkey to be added to another available enclosure.
Step 16-24 is basically adding more case handling. It includes creating monkey, moving monkey, trying to find the right place to put the monkey, produce a lot of information about the sanctuary to inform the users.

# Design/Model Changes

Changes 1: In original design, we did not include this many enum classes. It turned out to be a great suggestion. Because it reduces the complexity of the program.
Changes 2:In original design, the isolation and enclosure did share many similar features and did not really serve the whole sanctuary in the purpose of preserving monkeys. In the revised design, each of the two parts works very good because they have different functions and those make sure the handling of the monkeys in the sanctuary goes well.
Change 3: in original design, there is no interface for isolation and enclosure. In the revised version, we have interfaces for both classes separately. It makes our design more scalable.

# Assumptions

Assumption 1: the sanctuary do need at least one sanctuary and one enclosure
Assumption 2: Monkeys will be given all attributes during construction. The way of going through the isolation is a must because they will be added another attribute that is Quarantined. Only when they have gone through the isolation, can they be added to one of the available enclosure.
Assumption 3: We assume that no duplicate monkeys will be construct because in reality, no two monkeys are the same. So we will always have unique monkeys

# Limitations

Limitation 1: It does not support duplications of monkeys. If there is a second exactly the same monkey, it program will work but won’t tell you that they are the same. Even though you can see it yourself by produce a monkey list. But it is something I can improve for the future implementation.
Limitation 2: this program only can move monkey from outside to isolation to enclosure, but not from enclosure to isolation. The specification does not require that, so it is not included in the design. In reality, it should be able to move the monkeys from one enclosure to another isolation if that monkey needs medical attention.
Limitation 3: the program only support adding monkey from isolation because that is the original purpose for the monkeys to get medical attention at first. It does not support the feature of removing monkeys from the enclosure. That is something that we can also work on in the future to make it more realistic.

# Citations

Name of the website: StackOverFlow
Title: How can I sort Map values by key in Java?
url: https://stackoverflow.com/questions/922528/how-can-i-sort-map-values-by-key-in-java
date of retrieval: Sep 30 2022
