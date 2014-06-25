/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helloWorld;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Administrator1
 */
@Path("helloworld")
public class HelloWorld {

    private  final HashMap<String, String> ParamsMap = new HashMap<String, String>() {{
    put("Email Address", "elnar.ismayilov@gmail.com");
    put("Ping", "OK");
    put("Degree", "Master of MBA in Computer Information System");
    put("Position", "Sr. Software Engineer");
    put("Source", "https://github.com/elnar-ismayilov/Test-Your-Service.git");
    put("Referrer", "http://careers.stackoverflow.com/");
    put("Years", "10");
    put("Phone", "+994502310045");
    put("Status", "I require a visa sponsorship.");
    put("Resume", "http://www.megafileupload.com/en/file/544975/Elnar-Ismayilov-doc.html;"
            + "http://www.megafileupload.com/en/file/544976/Elnar-Ismayilov-S-doc.html");
    put("Name", "Elnar Ismayilov");
}};
    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }

    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml(@Context UriInfo ui) {
        
        if(ui.getQueryParameters().getFirst("q").toString().equals("Puzzle")){
          return SolvePuzzle(ui.getQueryParameters().getFirst("d").toString());   
        }else{
            return ParamsMap.get(ui.getQueryParameters().getFirst("q").toString());
        }

        

    }
    
       
    
 private   String SolvePuzzle(String s){             
     s=s.substring(s.indexOf("ABCD")+5,s.length());     
     String A=s.substring(1, 5);     
     String B=s.substring(7, 11);     
     String C=s.substring(13, 17);     
     String D=s.substring(19, 23);
              
     HashMap<String, int[]> arrayMap = new HashMap<String, int[]>();
     arrayMap.put("A", convertToNumber(A));
     arrayMap.put("B", convertToNumber(B));
     arrayMap.put("C", convertToNumber(C));
     arrayMap.put("D", convertToNumber(D));
     
     
     String answ= " ABCD";
     
     for (int i = 1; i < 5; i++) {
         int [] pr=arrayMap.get(String.valueOf(answ.charAt(i)));
         answ=answ+"\n"+String.valueOf(answ.charAt(i));
            for(int j = 1; j < 5; j++)
            {                
                if (i != j) {
                    int [] pr1=arrayMap.get(String.valueOf(answ.charAt(j)));
                    if (pr[4] > pr1[4]) {
                        answ = answ + ">";
                    } else if (pr[4] < pr1[4]) {
                        answ = answ + "<";
                    } else if (pr[4] == pr1[4]) {
                        if (pr[j-1] == 2) {
                            answ = answ + ">";
                        }
                        if (pr1[i-1] == 2) {
                            answ = answ + "<";
                        }
                    }
                } else
                {
                 answ=answ+"=";   
                }
            }        
             System.out.println(answ);
     }
     
     return answ;
    }
    
   private  int[] convertToNumber(String s){
     int[] answ = new int[5];
     for (int i=0;i<4;i++){
     switch (s.charAt(i)) {
            case '>':  answ[i]=2;answ[4]=answ[4]+2;
                     break;
            case '<':  answ[i]=0;answ[4]=answ[4]+0;
                     break;
            case '-':  answ[i]=1;answ[4]=answ[4]+1;
                     break;
            case '=':  answ[i]=1;answ[4]=answ[4]+1;
                     break;
            default: answ[i]=-1;answ[4]=answ[4]-1;
                     break;
        }
     } 
     return answ;
    }
}
