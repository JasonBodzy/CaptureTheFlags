Base64 Decoder

This program is a part of a capture the flag challenge through Purdue University's group B01lers.

The program intends to take a base64 encrypted string as input and return a readable string. 
The input string provided is "mxhZ3tZMHVfNHIzX04wV180X0NURjNSISEhfQo=" which is base64 encrypted.
It returns the string "flag{Y0u_4r3_N0W_4_CTF3R!!!}" as the reward "flag" for completing the challenge.

The program prints every step of decryption from base64.

It first prints out the base64 index for every character in the input.
The program then prints these indexes converted to 6bit binary.
Next it prints the 6bit binary converted to 8bit binary.
The 8bit binary is then converted to ASCII index.
Finally the ASCII index is converted to a final output string which is printed.

To edit the output, simply change the input variable to put in whatever encrypted base64 text you would like to decrypt.
The program should succesfully decrypt the base64 string to its original form.






