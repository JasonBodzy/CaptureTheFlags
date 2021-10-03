public class xorConversion {


    /*
    Can you find the character I XOR'd this entire flag with.
     Format: flag{.*}

     69636e68747c3e61683e6a506d767b3c50773f7d72

     input 69636e68747c3e61683e6a506d767b3c50773f7d72
     input icnht|>ah>jPmv{<Pw?}r
     */



    public static void main(String[] args) {

        String input = "icnht|>ah>jPmv{<Pw?}r";

        for(int i = 0; i < 256; i++){
            System.out.println("        " + i);
            for(int j = 0; j < input.length(); j++){
                System.out.print((char)(input.charAt(j) ^ i)); //Converts xor'd value to character
            }


        }


    }
}
