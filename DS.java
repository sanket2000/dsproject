/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.*;


 class Postfix {
    
    public int choice(String s) {
        switch(s) {
	        case "+":
	        case "-": return 1 ;
	                 
                case "*":
	        case "/": return 2;
	     
                case "$":return 0; 
                
	    }
        return 0;
    }
}

/**
 *
 * @author Acer
 */
public class DS {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
      
        String s = sc.nextLine(); //input string
        //System.out.println(s);
        int l = s.length();
        String infix[]=new String[100]; // infix string
        int j=0;
        for(int i=0 ; i < s.length() ; i++) { //converts input to infix
            char c = s.charAt(i);
            if(infix[j] == null) {
                infix[j] = "";
            }
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                j++;
                infix[j] = "";
                infix[j] += s.charAt(i);
                j++;
            }
            else {
                infix[j] += s.charAt(i);
            }
        }
             
        int i = 0;
        Stack o = new Stack();
        o.push("$");
        Postfix post = new Postfix();
        String[] pf= new String[100];
        int k = 0;
        int inst, incm;
        while(infix[k] != null) {
            //System.out.println(infix[k].equals(Character.toString('+')));
            boolean a = infix[k].equals(Character.toString('+'));
            boolean b = infix[k].equals(Character.toString('-'));
            boolean c = infix[k].equals(Character.toString('*'));
            boolean d = infix[k].equals(Character.toString('/'));
            if(a || b || c || d){
                inst = post.choice((String) o.peek());
                incm = post.choice(infix[k]);
                //System.out.print(inst +" "+ incm);
                while(incm <= inst) {
                    pf[i] = (String) o.pop();
                    inst = post.choice((String) o.peek());
                    i++;
                }
                o.push(infix[k]);       
                //System.out.println("Test1" + o + pf[i]);
            }
            
            else {
                pf[i] = (infix[k]);
                //System.out.println("Test2" + o + pf[i]);
                i++;
            }
            k++;
        }
        inst = post.choice((String) o.peek());
        while(inst != 0) {
            pf[i] = (String) o.pop();
            inst = post.choice((String) o.peek());
            i++;
        }
        
        //System.out.println(o+"stack");
        i = 0;
        while(pf[i] != null) {
             System.out.print("(" + pf[i] + ")");
             i++;
        }
    }
}

