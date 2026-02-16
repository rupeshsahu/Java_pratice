/* A pangram is a sentence where every letter of the English alphabet appears at least once.

   Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



           Example 1:

   Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
   Output: true
   Explanation: sentence contains at least one of every letter of the English alphabet.
   Example 2:

   Input: sentence = "letscode"
   Output: false*/

/*
Explanation:-
I've created a note for you titled **"Pangram Interview Solution: Bitmasking Strategy"** that breaks down the logic, the operations, and the optimizations we discussed.

You now have a clean, expert-level summary of how to use bitwise operations to solve this with  space and  time. This is the kind of explanation that proves to an interviewer you understand both high-level logic and low-level efficiency.

What's next? Do you want to try a **Senior-level System Design** challenge, or should we tackle another **Coding** problem to see if you can apply these bitwise skills somewhere else?*/

public class interview {
    public static void main(String[]args){

        System.out.printf("string have all alphabets: "+checkString("thequickbrownfoxjumpsoverhelazydog"));

    }



    public static boolean checkString(String input){
        int vis=0;
        for(char c:input.toCharArray()){
            int index= c-'a';
            vis= vis | (1<<index);
            if(vis==67108863)
                return true;
        }
        return false;

    }


}
