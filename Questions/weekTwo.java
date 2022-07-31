package Questions;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class weekTwo {
    public static void main(String[] args) {
        int a [] = {10,10,5,0,2,1,2,5};
        int tar = 10;
        ArrayList<Integer> fact = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();


       // to check whether the number is present in array or not
        for(int element: a){
            if(element == tar ){
                 // finding factors of the target number
                for (int i =1; i<tar; i++){
                    if(tar % i==0){
                        fact.add(i);
                    }
                }break;
            }
        }
        System.out.println(fact);
        // comparing number of given sets with the factors of the target number
        for(int i=0; i<fact.size();i++){
            for(int j =0; j< a.length;j++){
                if (fact.get(i)== a[j]){
                    //if the factorial is present in given array then add it in array list res
                    res.add(fact.get(i));
                }
            }
        }

        // to remove duplicate members
        LinkedHashSet<Integer> finalset = new LinkedHashSet<>( res);
        System.out.println("the subset is="+finalset +" and its length is: "+ finalset.size());
}
}
