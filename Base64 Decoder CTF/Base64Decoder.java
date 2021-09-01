//Decodes base64 code to english
//Made by Jason Bodzy

public class Base64Decoder {
    String input;
    Base64Decoder(){

    }

    String toBase64index(String input){ //Converts input string to base64 index numbers
        String output = "";

        char [] chars = input.toCharArray(); //Converts input text to array
        int [] [] ASCIItoB64 = {{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85,
                86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113,
                114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
                        28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51,
                        52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63}}; //ASCII key array and base 64 index array

        for(char c : chars){
            int i = 0; //Keeps track of where in the array we are
            for(int z : ASCIItoB64[0]){
                if(c == z){
                    output = output + ASCIItoB64[1][i] + " "; //Appends numbers to output string
                }
                i++;
            }

        }
        return(output); //Returns base64 indexes of input characters
    }

    String to6bitBinary(String base64input){ //Converts base64 index numbers to 6 bit binary notation

        String[] base64indexes = (base64input.split(" ")); //Splits up base64 index string into array of individual indexes

        int i = 0;
        String binary = "";
        String output = "";
        for(String s : base64indexes){ //loops through all indexes
            binary = Integer.toBinaryString(Integer.parseInt(base64indexes[i])); //converts index strings to ints and binary strings
            while(binary.length() < 6){
                binary = "0" + binary; //shifts all binary strings to 6 bit
            }
            output = output + binary + " "; //concatenates 6bit binary to output
            i++;
        }

        return(output);
    }

    String to8bitBinary(String my6bitBinaryInput){ //Turns 6 bit binary into 8 bit binary
        String output = "";

        char[] my6bitBinaryChars = my6bitBinaryInput.toCharArray();

        int i = 0;
        for(char c : my6bitBinaryChars){

            if(c == '1' || c == '0'){
                output = output + c;
                i++;
                if(i >= 8){
                    output = output + " ";
                    i = 0;
                }
            }
        }
        return output;
    }

    String toASCIIIndex(String my8bitBinaryInput){ //converts 8bit binary to integers
        String output = "";

        String[] my8bits = my8bitBinaryInput.split(" "); //splits 8 bit binary into string array

        for(String s : my8bits){
            output = output + Integer.parseInt(s, 2) + " "; //converts binary to integers
        }

        return output;
    }

    String toEnglish(String myASCIIIndex){ //converts ascii index to english
        String output = "";

        String[] splitASCII = myASCIIIndex.split(" "); //splits up ascii indexes to array of index

        for(String s : splitASCII){
            output = output + Character.toString(Integer.parseInt(s)); //converts individual indexes to real characters
        }

        return output; //outputs
    }

    public static void main(String[] args){

        Base64Decoder b = new Base64Decoder();

        String input = "ZmxhZ3tZMHVfNHIzX04wV180X0NURjNSISEhfQo="; //base64 encoded input

        String b64index = b.toBase64index(input); //converts base64input to base64 index numbers
        String my6bitBinary = b.to6bitBinary(b64index); //converts these index numbers to b 6bit binary
        String my8bitBinary = b.to8bitBinary(my6bitBinary); //converts 6bit binary to 8bit binary
        String ASCIIIndex = b.toASCIIIndex(my8bitBinary); //converts 8bit binary to ASCII index numbers
        String English = b.toEnglish(ASCIIIndex); //converts ASCII indexes to letters

        System.out.println(input);
        System.out.println(b64index);
        System.out.println(my6bitBinary);
        System.out.println(my8bitBinary);
        System.out.println(ASCIIIndex);
        System.out.println(English);


    }


}
