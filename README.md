# Level Up with Object Oriented Programming in Java!

This repository contains the exercises and demos we'll work through as part of this course!   If taking the course, you dont need to clone this repository ahead of time, as we will work through the demonstration portions together.  But if you'd like to try some of the exercises out youself after the course, feel free to clone this repo and have at it!

## Get Java working

This course requires Java 8 or higher to follow along or run the code examples offline before or after the course.

First, check to see if you have an appropriate version of Java already installed and accesssible.  Open up your terminal (Mac or Linux) or command prompot (windows) and type "java -version", like so:

```
$ java -version
openjdk version "11.0.7" 2020-04-14
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.7+10)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.7+10, mixed mode)
```
In this case, we have OpenJDK 11, and we'd be good to go.

If you don't have Java installed, try these links.  Either Oracle JDK or Open JDK is fine.

* [OpenJdk](https://openjdk.java.net/install/index.html)
* [Oracle Java](https://www.java.com/en/download/help/download_options.html)

It's possible you may also need to set the Java Home environment variable:

* [Setting Java Home](https://www.baeldung.com/java-home-on-windows-7-8-10-mac-os-x-linux)

Once this is all setup, you should be abble to go to a command prompt, as shown above, and get "java -version" to respond appropriately.

## Clone this repo

You will need git on your client box to clone this repository.  You can confirm you have git already (most machines will) by tryng the "git --version" commmand.  If you don't seem to have git installed, follow the directions here: [Installing Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

Click the green "Code" button on the main page of this repository to get the command to clone the main branch to your machine.  If you're having trouble, check the documentation here:  [Cloning a github repository](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository-from-github/cloning-a-repository)

## Compile and run the application

The easiest way to run this application, modify it, and rerun with your changes, is to import it into a Java IDE like IntelliJ or Eclipse.

The starting point to run the application is in src/ui/App.  This is the class to run.

If you would like to compile and run it from the command line, step down into the root directory (the src directory) and try:

```
javac -d out ui/App.java
```
That should compile all of the class files and put them into an "out" subdirectory from the root.  To run, step down into that out directory and try: 

```
java -cp . ui.App
```