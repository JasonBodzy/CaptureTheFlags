//Decrypts any Roman Cypher by testing input against all possible shift values
//By Jason Bodzy


public class RomanCipher {

    String input;
    RomanCipher(){

    }


    String decode2(String input, int shiftValue){ // Function to test a case of a Roman Cipher given the encrypted text and a shift value
        String output = "";
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); // Reference alphabet array
        String[] newInput = (input.toUpperCase()).split(" "); // Ensures that multi-word inputs are split properly

        for(String s : newInput){ // Loops through each string for multi-string input
            char[] inputChars = s.toCharArray(); // Converts Strings to character arrays
            for(char c : inputChars){ //Loops through each character of each string
                int i = 0;
                while (i < 26){ // Loops through alphabet
                    if(i - shiftValue >= 0 && alphabet[i] == c){ //Compares input characters to alphabet characters with regular shift
                        output = output + alphabet[i - shiftValue]; //Regular shift
                    } else if ( alphabet[i] == c) { //Checks for leftover characters
                        output = output + alphabet[(26 - shiftValue) + i]; //Leftover shift
                    }
                    i++;
                }
            }
            output = output + " "; //Adds appropriate spaces to output
        }

        return(output);
    }


    public static void main (String[] args){

        RomanCipher r = new RomanCipher();

        String input = "AOPZ PZ LUJYFWALK ALEA";

        int s = 0;
        while (s < 26) { //Iterates through all possible shift values
            System.out.println(r.decode2(input, s));
            s++;
        }





    }

}

