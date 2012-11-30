What software does my system run on:

I use eclipse JUNO to implement this system. For some reason it only work on JUNO so please be sure that you use it to execute the system. I put all my work on my git hub account. My account name is KaiCheihHsu under project.

Step-by-step intall process:

First of all create a project in eclipse. Create a class a java file named CharBot and copy all the codes in my CharBot.java and paste it on your file. Save the file and do the same thing for the Question.java file. Please make sure that all the java file are in src folder. All the text file (SystemQuestions.txt, SystemAnswer.txt, UserAnswers.txt, UserQuestions.txt, and KeyWords.txt) are in the project folder (right outside of src folder). At this point the system should be ready to run.


Summary of the system:

My system can interact with the user by talking about basketball as a friend. My system have two parts. First the system will ask some question to the user. It will scan the user¡¯s answer and see if it make sense and if it is what answer that it is looking for. If it does not understand the answer it will output ¡°I don¡¯t understand what you are talking about¡±. If it make sense and it is similar to the answer key I given it t will output ¡°I agree too¡± or it is going to output ¡°no, ¡± and the answer key I provided it.
Once it finish asking questions the user will have the chance to ask questions. The system will see if it make sense again. If it does make sense it will see you the question is already been asked by the user. If it find the question it will output the answer of that question. If it does not have it, it will ask the user for the answer and remember the answer so if the user asked the question again it will know what to output. However, please make sure you answer the question starting with "the answer is" in order for the system to read the answer.
My system can also scan for swear words. If the user¡¯s sentence contains swear words the system will detect that and reply ¡°hey be nice¡±. If the user swear 5 times it will output ¡°you know what!!! I have nothing to say to you¡±. Also, if the system disagree with the user¡¯s input up to 5 times it will do the same thing.

Files:

CharBot.java: This file makes a simple chat frame.
Question.java: This file stores the questions and answers into array and scan user input to see if it make sense. If it make sense output the answer if it has one. It also stores unknown questions and the answer for that question.
SystemAnswers.txt: This file is all the answers that the system have for the questions it is going to ask the user.
SystemQuestion.txt: This file contains all the questions that the system is going to ask the user.
UserQuestion.txt: This file contains all the unknown questions that he user asks.
UserAnswer.txt: This file contains all the answer the user input as the answer for the unknown questions they asks.

Problems with the system:

-There is no constrain on what type of question the user can ask the system and there are also no constrain on the correctness of the answer the user input as an answer. The user can ask ¡°how to ride a bicycle¡± and answer ¡°I am the best¡± as the answer for ¡°who is the best play in NBA¡±.
-Please answer the unkown question starting with "the answer is".
