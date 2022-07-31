package Questions;

import java.util.Locale;

public class weekFive {
    String[] subset;
    String target;
    //Finds the subset of the given string
    weekFive(String[] subset, String target){
        this.subset = subset;
        this.target = target;
    }
  
    public int getSubset(){
  
        int targetLength =  target.length();
        boolean[] contains = new boolean[targetLength];
        int [] charFound = new int[targetLength];
        // traverse through the subset
  
        for(int i=0; i < targetLength; i++){
            char targetChar = target.toLowerCase(Locale.ROOT).charAt(i);
  
            System.out.println();
            System.out.println("Current target char : "+ targetChar);
  
            for(int j =0; j<subset.length; j++){
  
                String subString = subset[j];
                System.out.println("Current String : " + subString);
  
                int sub = subset[j].length();
                //traverse through the string
  
                for(int k =0; k< sub; k++){
                    char charSub = subString.toLowerCase(Locale.ROOT).charAt(k);
                    System.out.println(charSub);
                    // check if the char is equal to the target char
  
                    if(targetChar == charSub && !contains[i]){
                        System.out.println("Found char : " + charSub + " at "+ j + " word ") ;
                        contains[i] = true;
                        charFound[i] = j;
                        System.out.println();
                    }
                }
            }
  
        }
  
        int count = 0;
        int compare = -1;
        boolean[] indexVisit = new boolean[subset.length];
  
        for (int i =0; i < targetLength; i++){
            if(charFound[i] != compare && !indexVisit[charFound[i]]){
                indexVisit[charFound[i]] = true;
                count++;
                compare = charFound[i];
            }
        }
  
        return count;
    }
  
    public static void main(String[] args) {
        String[] subset = {"Programming", "for", "developer"};
        weekFive q5 = new weekFive(subset, "frog");
  
        int subsetNum = q5.getSubset();
        System.out.println("The number of subset to form the target word is " + subsetNum);
    }
  }
