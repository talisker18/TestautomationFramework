<span style="color:red"><b>IMPORTANT NOTE 1</b>: the dependencies used in this project may have vulnerabilities. Please check the versions before using them in production
</span>.<br><br>

<span style="color:red"><b>IMPORTANT NOTE 2</b>: the website that is tested in this framework is 'https://www.opencart.com/'. It's a free dummy website for practicing software testing
</span>.<br><br>

<span style="color:red"><b>IMPORTANT NOTE 3</b>: in src/main/java/com/henz/joel/config/config.properties, username and password are in clear text.
</span><br><br>

<span style="color:red"><b>IMPORTANT NOTE 4</b>: to run TestNG tests in Eclipse, download the Eclipse plugin for TestNG
</span><br><br>

# 1. Introduction

**Patterns, Approaches**

- Page Object Model (POM)

 Page Object Model (POM) is a design pattern, popularly used in test automation that creates Object Repository for web UI elements. The advantage of the model is that it reduces code duplication and improves test maintenance.

Under this model, for each web page in the application, there should be a corresponding Page Class. This Page class will identify the WebElements of that web page and also contains Page methods which perform operations on those WebElements.

- Data driven testing

Data Driven Framework is an automation testing framework in which input values are read from data files and stored into variables in test scripts. It enables testers to build both positive and negative test cases into a single test. Input data in data driven framework can be stored in single or multiple data sources like .xls, .xml, .csv and databases.

**Layers of this framework**

- Page layer, containing a class for each page
- Test layer, containing test classes using TestNG
- environment vars, like config.properties; test data e.g. testdata.xlsx; TestUtil class; reporting

**Libraries / components used**

- Selenium
- Junit5
- Maven
- Allure Report
- Log4j
- Jenkins
- Git



1. First ordered list item
2. Another item


I just love **bold text**.

At the command prompt, type `nano`.

My favorite search engine is [Duck Duck Go](https://duckduckgo.com).

\* Without the backslash, this would be a bullet in an unordered list.

* Without the backslash, this would be a bullet in an unordered list.