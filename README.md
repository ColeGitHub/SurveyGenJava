# SurveyGenJava

PREAMBLE: 
This is the final project for CS350 at Drexel, focused on properly implementing software design principles that make initial design and implementation difficult, but allow and encourage easy long-term maintenance and updates.  The class covered design patterns covered by the Gang of Four book (pretty sure thats not the real name).  Most important principles focused on here were aggregation over inheritance and strong cohesion and loose coupling.  I also put more effort into using the bridge pattern since it was somewhat easy to understand/implement, and also made me truly software design and OOP in general.  While this is my first experience implementing these patterns and "properly" designing a project, hopefully it isn't the last.

WHAT IS THIS:
This program is a console application written in Java.  It is a survey/test maker, taker, and tabulater.  You can create a test or survey with a series of questions, the only difference is that a test has correct answers and the ability to be graded.  Each test or survey can be saved using a Java serialization library.  After a series of tests/surveys are taken, the results can be tabulated, so that the user can see how many people answered a question a certain way on a certain test.  

When creating a test/survey, you have the option to create six different types of questions: True/False, Multiple Choice, Ranking, Selection, Short Answer, and Essay.  Each type of question is an object that inherits from an abstract Question class, although a lot of overloading is done depending on the type of question.  Some question types, like True/False, inherit from another question type, like Multiple Choice.  Due to time constraints of the class, the Essay question does not have a grading method, however all other question types do.  

A survey can be taken, and the answers recorded.  However, a test can be taken and graded, comparing to a list of correct answers given by the test maker.  The score is returned out of 100.
