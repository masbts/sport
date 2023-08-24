# Sport Management System

Decisions
Extra attribute of the competitor class.
I choose 4 level for competitor as numbers from 1 to 4 they represent Novice, Standard, Veteran and Expert respectively.
An array of integer scores of sizes 5 with values between 0 and 5
An age as integer
A country as string 

<img width="220" alt="image" src="https://github.com/masbts/sport/assets/124617295/acc23949-9994-4590-9fd7-062abc66bde5">


Overall score calculated by an average of top n scores where n is the level number.

<img width="348" alt="image" src="https://github.com/masbts/sport/assets/124617295/578cf183-1a0d-48ed-af96-0b260144e759">

Status report

Testing Competitor class Main Functions
Create an object by passing an argument with a parameterized constructor.
<img width="451" alt="image" src="https://github.com/masbts/sport/assets/124617295/85eca755-2050-4ea6-b1d3-805a9a7c6a8d">


Test Item	Test Data	Expected Result	Actual Result
getFullDetails()	Calling getFullDetails() Function	"Competitor number 100, name Keith John, country Uk.
Keith is a Novice aged 20 and received these scores: 5,4,5,4,3
This gives him an overall score of 4.0."	√
getShortDetails()	Calling getShortDetails() Function 	CN 100 (KJ) has overall score 4.0	√
getLevelofCompetitorName()	Calling getLevelofCompetotorName() Function	Novice	√
getOverallScore()	Calling getOverallScore() Function	4.0	√<img width="455" alt="image" src="https://github.com/masbts/sport/assets/124617295/75e4aa93-b108-42d6-8187-3f6b5fff7025">





Testing CompetitorList class Main Functions
Create an object by default constructor. 

<img width="285" alt="image" src="https://github.com/masbts/sport/assets/124617295/6c183ca5-22a4-4b6b-8e72-0cfaf02c461d">


Within default constructor reading data from the CompetitorList.txt File.

<img width="295" alt="image" src="https://github.com/masbts/sport/assets/124617295/3a25648c-b4ce-4554-9dc1-64ba16dfa5b0">


CompetitorList.txt File Content.



<img width="287" alt="image" src="https://github.com/masbts/sport/assets/124617295/a3b9d14a-2f16-40e0-9cd5-659198d3a9c4">


Test Item	Test Data	Expected Result	Actual Result
reportToFile(String FileName)	"Calling reportToFile(“report.txt”) 
Function"	Report.txt content	√
checkIsValidCompetitorNo (int number)	Calling checkIsValidCompetitorNo(101) Function 	CN 101 (JM) has overall score 3.0	√
	Calling checkIsValidCompetitorNo(10001) Function	competitor number is not valid.	√<img width="466" alt="image" src="https://github.com/masbts/sport/assets/124617295/c0ce6cfa-4f3d-41f7-9182-cfe1b667c4ef">



Diagrams

Class Diagram

<img width="451" alt="image" src="https://github.com/masbts/sport/assets/124617295/2f8e936a-c595-4c65-9e6d-cd40e2efa863">

Sequence diagram
While reading competitor records from the input file.


<img width="451" alt="image" src="https://github.com/masbts/sport/assets/124617295/afe0b8c1-4743-4f7e-bcff-13904faa2f3a">



Activity Digram,





<img width="142" alt="image" src="https://github.com/masbts/sport/assets/124617295/f7d0fe62-5542-4a9e-88f7-04b40f2601fb">



use case-diagram

![image](https://github.com/masbts/sport/assets/124617295/e94b4d69-b756-4de6-8e9e-1f7d80d2a07b)

