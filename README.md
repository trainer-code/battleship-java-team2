# Battleship Java

A simple game of Battleship, written in Java.

# Getting started

This project requires a Java JDK 8 or higher. To prepare to work with it, pick one of these
options:

You can download Java Runtimes from Amazon Corretto Side
https://aws.amazon.com/corretto
We will use Java SE 17 (LTS) version for this project. So download Java 17 from https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html
We will use Windows x64 installation here. You can select an appropriate package for your operating system

## Run locally

You need gradle to run this project. Install it using the instructions in https://gradle.org/install/
Install Gradle to Windows
### Step 1:
Create a directory in C drive C:\Gradle

### Step 2: 
Download gradle-7.4.zip and unzip it to C:\Gradle. Your code will be at C:\Gradle\gradle-7.4

### Step 3: 
Add C:\Gradle\gradle-7.4.2\bin to your system path (env variable)
Enter env to your command line, then System variable then add C:\Gradle\gradle-7.4.2\bin to Path

### Step 4
Verify that gradle is running
Open a new command line, then enter 
```
 gradle -v
```
You should see Gradle 7.4.2

# Create a training project using Java 17 and Gradle 7.4.2
We will create a simple Java project with Git and Continuous integration with TravisCI

##Step 1: Create an empty directory
```
makedir trainingjava
cd trainingjava

```
##Step 2: Initialise project
```
gradle init --test-framework junit
```
Select following options:
 - Application (2)
 - Java (3)
 - Multiple (2)
 - Groovy (1)
 - No new API (no)
 
 
 Alternativelly you can run options as follows
 ```
 gradle init --type java-application --test-framework junit-jupiter --split-project --dsl groovy --project-name trainingjava --package trainingjava
 ```
 
 ## Step 3:
 Run Application, You should see hello world
 ```
 gradle run
 ```
 
  ## Step 4:
 Test Application
 ```
 gradle test
 ```

## Run battleship with Gradle
You need to delete old gradle files first. (Delete .gradle directory if exists)
Run 
```
gradle
```
in the main project directory such as from C:\repos\training\trainingjava1

We are using gradle wrapper for this project. Run following command to upgrade gradle wrapper
(https://docs.gradle.org/current/userguide/gradle_wrapper.html)

Install Gradle wrapper
```
gradle wrapper
```

Now you can run application by Gradle
```bash
./gradlew run
```

Execute tests with Gradle

```bash
./gradlew test
```

## Docker

If you don't want to install anything Java-related on your system, you can
run the game inside Docker instead.

### Run a Docker Container from the Image

```bash
docker run -it -v ${PWD}:/battleship -w /battleship java
```

# Launching the game

```bash
./gradlew run
```

# Running the Tests

```
./gradlew test
```


## Some links on JUnit 5
### Using System Rules
https://www.baeldung.com/java-system-rules-junit

### Using system Lambdas with JUnit 5
https://github.com/stefanbirkner/system-lambda/tree/master/src/test/java/com/github/stefanbirkner/systemlambda
https://github.com/stefanbirkner/system-lambda



## Step 1: Install sonarqube docker first
```
docker run -d --name sonarqube -p 9000:9000 sonarqube
```
## Step 2: Configure sonar locally
```
open sonarqube in browser http://localhost:9000, initially enter admin/admin as username/password. Sonarqube will ask you
to change password. Select a suitable new password.
```

## Step 3: Create project in sonarqube and use 'manually' as option

Enter battleship:java as project display name and key name

## Step 4: Add folowing to your build.gradle file
```
plugins {
  id "org.sonarqube" version "3.3"
}
```

## Step 5:  Click Setup and download sonarqube scanner

You can select your OS. If you select Windows, you will get a command like following
```
./gradlew sonarqube "-Dsonar.host.url=http://localhost:9000" "-Dsonar.login=<Key name>"
```
in other operating systems
```
```
./gradlew sonarqube -Dsonar.projectKey=console-app -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<Key name>
```
```

## Step 6: Display results
Open http://localhost:9000/projects and find battleship:csharp project

You can find more installation documentation here
http://localhost:9000/documentation/analysis/scan/sonarscanner-for-gradle/
 
