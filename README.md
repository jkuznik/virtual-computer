Langue: <br>
[PL](readme/readme-pl.md)

# Virtual-computer
This project was created to allow individuals learning Java to work together as a team on a single application from the very beginning of their learning journey. <br>
This requires understanding the basics of Git, which in turn provides additional experience and is a key skill for future developers.

#  How to start

First step as a collaborator read [this](readme/instructions/howToStart/collaboratorHowToStart-en.md) . <br>
First step as a contributor read [this](readme/instructions/howToStart/contributorHowToStart-en.md) .

# In-app programs

The best way to learn is through practice. This project allows you to make your own changes that will noticeably
impact the entire project, and these changes will be readily available when you run the application. This refers
to simple CLI-style programs or games of your own design that can be integrated into the project and later 
accessed from the main application's user interface, "Computer."
Here are the basic [details](readme/instructions/inAppPrograms/inAppInterfaces-en.md) you need to know.

# chatServer Package
This package contains the code for the entire application serving as a chat feature available
as a subprogram of the main application, "Computer." To ensure the chat subprogram functions
correctly, the server instance must first be started in the local environment. Each class in
the chatServer package has a default access modifier, which prevents these classes from being
used in the main application’s classes.

