

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Question {
  
    private ArrayList<String> SystemQuestion = new ArrayList<String>();
    private ArrayList<String> SystemAnswers = new ArrayList<String>();
    private ArrayList<String> UserQuestion = new ArrayList<String>();
    private ArrayList<String> UserAnswers = new ArrayList<String>();
    private ArrayList<String> newQuestions = new ArrayList<String>();
    private ArrayList<String> newAnswers = new ArrayList<String>();
    private ArrayList<String> badWords = new ArrayList<String>();
    private ArrayList<String> keyWords = new ArrayList<String>();
    private int mood = 5;
    private String[] answers;
    private String[] yes;
    private String[] no;
    int index = 0;
    private ArrayList<String> unknownQuestion = new ArrayList<String>();
	
    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
}

public static int distance(String str1,
                String str2) {
		str1.toLowerCase();
		str2.toLowerCase();
        int[][] distance = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++)
                distance[i][0] = i;
        for (int j = 1; j <= str2.length(); j++)
                distance[0][j] = j;

        for (int i = 1; i <= str1.length(); i++)
                for (int j = 1; j <= str2.length(); j++)
                        distance[i][j] = minimum(
                                        distance[i - 1][j] + 1,
                                        distance[i][j - 1] + 1,
                                        distance[i - 1][j - 1]
                                                        + ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
                                                                        : 1));
        System.out.println(distance[str1.length()][str2.length()]);
        return distance[str1.length()][str2.length()];
}

	


    Question () throws FileNotFoundException {        
        yes= new String[] {"I agree too","I agree too"};
        no= new String[] {"no way","I don� think so"};
        
        Scanner in = new Scanner(new File("SystemQuestions.txt"));        
        while(in.hasNext())
        {
            SystemQuestion.add(in.nextLine());            
        }            
        in.close();
        
        in = new Scanner(new File("SystemAnswers.txt"));        
        while(in.hasNext())
        {
            SystemAnswers.add(in.nextLine());            
        }            
        in.close(); 
        
        in = new Scanner(new File("UserQuestions.txt"));        
        while(in.hasNext())
        {
            UserQuestion.add(in.nextLine());            
        }            
        in.close();
        
        in = new Scanner(new File("UserAnswers.txt"));        
        while(in.hasNext())
        {
            UserAnswers.add(in.nextLine());            
        }            
        in.close();
        
        in = new Scanner(new File("newQuestions.txt"));        
        while(in.hasNext())
        {
            newQuestions.add(in.nextLine());            
        }            
        in.close();
        
        in = new Scanner(new File("newAnswers.txt"));        
        while(in.hasNext())
        {
            newAnswers.add(in.nextLine());            
        }            
        in.close();
        
        in = new Scanner(new File("swearWords.txt"));        
        while(in.hasNext())
        {
            badWords.add(in.nextLine());            
        }            
        in.close();
        
        in = new Scanner(new File("KeyWords.txt"));        
        while(in.hasNext())
        {
            keyWords.add(in.nextLine());            
        }            
        in.close();
    }
    
    public String getAnswer(String question)
    {
    	if(question.toLowerCase().contains("bye")){
    		 try {
                 PrintWriter out = new PrintWriter(new File("UserQuestions.txt").getAbsoluteFile());
                 try {                       
                 for(String s : UserQuestion)
                     out.print(s+"\r\n");
                 } finally {
                     out.close();
                 }
             } catch(IOException e) {
                 throw new RuntimeException(e);
             }
    		 try {
                 PrintWriter out = new PrintWriter(new File("UserAnswers.txt").getAbsoluteFile());
                 try {                       
                 for(String s : UserAnswers)
                     out.print(s+"\r\n");
                 } finally {
                     out.close();
                 }
             } catch(IOException e) {
                 throw new RuntimeException(e);
             }
    		return "Goodbye!!!";
    	}
    	if(question.toLowerCase().contains("the answer is")){
    		UserAnswers.add(question);
    		 try {
                 PrintWriter out = new PrintWriter(new File("UserAnswers.txt").getAbsoluteFile());
                 try {                       
                
                     out.print(question+"\r\n");
                 } finally {
                     out.close();
                 }
             } catch(IOException e) {
                 throw new RuntimeException(e);
             }
    		return "ok i will remember that!!! any more questions?";
    	}
    	for(int i = 0; i < badWords.size();i++){
    		if(question.contains(badWords.get(i))){
    			mood--;
    			if(mood==0){
    				return"you know what? i have not thing to say to you!!!!";
    			}
    			return "hey, be nice";
    		}
    	}
        if(index == 0) return SystemQuestion.get(index++);
                
        if(index > 0 && index < SystemQuestion.size()+1)
        {
            if(distance(question,SystemAnswers.get(index-1))<20 && question.contains(keyWords.get(index-1)))
            {
                if(index < SystemQuestion.size())
                {
                    return yes[index%2]+"\n"+"agent: "+SystemQuestion.get(index++);
                }else
                {
                    index++;
                    return yes[index%2]+"\n"+"Maby you want ask me?";
                }
            }else
            {
            	if(distance(question,SystemAnswers.get(index-1))>30){
            		return "What are you talking about?";
            	}
                String rez = "";
                if(index < SystemQuestion.size())
                {
                    rez += no[index%2]+SystemAnswers.get(index-1);
                    rez += "\n"+"agent: "+SystemQuestion.get(index++);
                    mood--;
                    if(mood==0){
        				return"you know what? i have not thing to say to you!!!!";
        			}
                }
                else
                {
                	if(distance(question,SystemAnswers.get(index-1))>20){
                		return "What are you talking about?";
                	}
                    rez += no[index%2]+". "+SystemAnswers.get(index-1)+"\n"+"Is there any questions you want ask me?";
                    index++;
                    mood--;
                    if(mood==0){
        				return"you know what? i have not thing to say to you!!!!";
        			}
                }
                return rez;
            }
        }else
        {
            for(String t : UserQuestion)
            {
                if(distance(question,t)<3)
                {
                    return UserAnswers.get(UserQuestion.indexOf(t));
                }
            }
            
            unknownQuestion.add(question);
             try {
                PrintWriter out = new PrintWriter(new File("UserQuestions.txt").getAbsoluteFile());
                try {
                    out.print(question+"\r\n");
                } finally {
                    out.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
             UserQuestion.add(question);
            return "I dont know answer for this question, what is the answer?";
            
        }     
    }

}
