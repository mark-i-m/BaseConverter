package basecoversions;

import getinput.GetInput;

/**
 * @author Mark
 * This is a program that converts any integer in base 2 to 35 to any other base (2 to 35)
 */
public class BaseConverter {

    /**
     * Driver method
     */
    public static void main(String args[]) {

        // Welcome message
        System.out.println("The converter converts any integer BASE (2 to 35) to any other BASE (2 to 35).");

        // main loop
        while (true) {
        
        // attempt to get user input    
        try{
            String num;
            int from;
            int to;

            System.out.print("\n\nPlease enter the integer to be converted:\t");
            num = GetInput.getString("This is not a valid integer value. Try Again:\t\t");
            System.out.print("What base is this?\t\t\t\t");
            from = GetInput.getInt("This is not a valid base. Try Again:\t\t");
            System.out.print("What base would you like to convert to?\t\t");
            to = GetInput.getInt("This is not a valid base. Try Again:\t\t");

            System.out.println("\n------------------------------------------------------\n" + num + " (BASE-" + from + ") = " + BaseConverter.convert(num, from, to) + " (BASE-" + to + ")\n------------------------------------------------------");
        } catch(IllegalArgumentException ex){
                System.err.println("\nThe computation could not be completed because " + ex.getMessage() + ".\n");
        }

            // prompt to continue
            System.out.print("\n\nWould you like to continue (y/n) ?\t\t");
            char contin = GetInput.getChar("This is an invalid answer. Enter (y for yes or n for no): \t\t");
            while (contin != 'Y' && contin != 'y' && contin != 'N' && contin != 'n') {
                System.out.print("This is an invalid answer. Enter (y for yes or n for no): \t\t");
                contin = GetInput.getChar("This is an invalid answer. Enter (y for yes or n for no): \t\t");
            }

            // continue or exit
            if (contin != 'Y' && contin != 'y') {
                return;
            }
        }

    }

    /**
     * Driver method that dispatches the call to convert
     * @param input the input string -- the int to convert
     * @param from the base of input
     * @param to the base convert to
     * @return a string representing the converted int
     */
    public static String convert(String input, int from, int to) {

        // Check input
        if(to > 35)
            throw new IllegalArgumentException("the program is unable to convert to such a large base");
        if(to < 2 || from < 2)
            throw new IllegalArgumentException("the smallest possible base is BASE-2");
        if(from > 35)
            throw new IllegalArgumentException("the program is unable to convert from such a large base");
        
        // Split into three exhaustive cases
        if (from == 10) {//Conversion from base 10 to another base
            return convertFrom10(input, to);
        } else if (to == 10) {//Conversion to base 10 from another base
            return convertTo10(input, from);
        } else {//Neither
            // Rather than write 35! conversion functions, I simply
            // convert to base 10, then the other base            
            return convertFrom10(convertTo10(input, from), to);
        }

    }

    /**
     * Convert an integer in non-base-10 to base-10
     * @param num the number to convert
     * @param from the base of num
     * @return a string representing the converted int
     */
    private static String convertTo10(String num, int from) {

        // eliminate leading 0s
        while (num.charAt(0) == '0') {
            num = num.substring(1);
        }

        int sum = 0;//this will contain the converted number
        int exp = 0;//this is the place of the current digit

        //starting from the end of the number to convert, loop through digits
        //add to sum the product of the current digit and the base raised to 
        //the power of the digits place minus 1    
        for (int count = num.length() - 1; count >= 0; count--) {
            char c = num.charAt(count);
            sum += getEquivalent(c, from) * (int) (Math.pow(from, exp++));
        }

        return "" + sum;

    }

    /**
     * Converts a base-10 integer to non-base-10 integer
     * @param dec the number in base-10
     * @param to the base to convert to
     * @return a string representing the converted integer
     */
    private static String convertFrom10(String dec, int to) {

        // attempt to validate string and eliminate leading 0s
        try {
            dec = Integer.parseInt(dec) + "";
        } catch (Exception ex) {
            throw new IllegalArgumentException("the integer to be converted is not in decimal format");
        }
        
        return convertToBase(dec, to, "");
    }

    /**
     * Recursively finds the value of a decimal in another base: divide the
     * given number by the base, and store the remainder (which is a digit
     * in the result). Repeat until the divisor will not go into the dividend
     * anymore.
     * @param num the number to be converted (in base 10).
     * @param base the base to convert to
     * @param append the digits that have already been converted -- will
     * eventually contain the result
     */
    private static String convertToBase(String num, int base, String append) {  
        int div = Integer.parseInt(num) / base;                                 
        int rem = Integer.parseInt(num) % base;                                 
        append = getEquivalent(rem) + append;                                   
        if (div != 0) {
            append = convertToBase("" + div, base, append);                     
        }
        return append;                                                          
    }                                                                           

    /**
     * Converts an integer into a digit (letter)
     * @param dig the integer
     */
    private static char getEquivalent(int dig) {
        char ret = '?';                         
                                                
        switch (dig) {

            case 10:
                ret = 'A';
                break;
            case 11:
                ret = 'B';
                break;
            case 12:
                ret = 'C';
                break;
            case 13:
                ret = 'D';
                break;
            case 14:
                ret = 'E';
                break;
            case 15:
                ret = 'F';
                break;
            case 16:
                ret = 'G';
                break;
            case 17:
                ret = 'H';
                break;
            case 18:
                ret = 'I';
                break;
            case 19:
                ret = 'J';
                break;
            case 20:
                ret = 'K';
                break;
            case 21:
                ret = 'L';
                break;
            case 22:
                ret = 'M';
                break;
            case 23:
                ret = 'N';
                break;
            case 24:
                ret = 'O';
                break;
            case 25:
                ret = 'P';
                break;
            case 26:
                ret = 'Q';
                break;
            case 27:
                ret = 'R';
                break;
            case 28:
                ret = 'S';
                break;
            case 29:
                ret = 'T';
                break;
            case 30:
                ret = 'U';
                break;
            case 31:
                ret = 'V';
                break;
            case 32:
                ret = 'W';
                break;
            case 33:
                ret = 'X';
                break;
            case 34:
                ret = 'Y';
                break;
            case 35:
                ret = 'Z';
                break;
            default:
                // if the digit is a "normal" digit (0-9), then return the digit
                ret = (dig + "").charAt(0);
                break;
        }

        return ret;
    }
 
    /**
     * Changes a digit (letter) to an int. Throws an exception
     * if the character is not of the correct base. Lowercase
     * and uppercase letters are treated the same.
     * @param c the character/digit
     * @param from the base of c
     * @return the integer represented by c
     */
    private static int getEquivalent(char c, int from) {

        int ret = 0;

        switch (c) {     
            case 'A':    
            case 'a':
                ret = 10;
                break;
            case 'B':
            case 'b':
                ret = 11;
                break;
            case 'C':
            case 'c':
                ret = 12;
                break;
            case 'D':
            case 'd':
                ret = 13;
                break;
            case 'E':
            case 'e':
                ret = 14;
                break;
            case 'F':
            case 'f':
                ret = 15;
                break;
            case 'G':
            case 'g':
                ret = 16;
                break;
            case 'H':
            case 'h':
                ret = 17;
                break;
            case 'I':
            case 'i':
                ret = 18;
                break;
            case 'J':
            case 'j':
                ret = 19;
                break;
            case 'K':
            case 'k':
                ret = 20;
                break;
            case 'L':
            case 'l':
                ret = 21;
                break;
            case 'M':
            case 'm':
                ret = 22;
                break;
            case 'N':
            case 'n':
                ret = 23;
                break;
            case 'O':
            case 'o':
                ret = 24;
                break;
            case 'P':
            case 'p':
                ret = 25;
                break;
            case 'Q':
            case 'q':
                ret = 26;
                break;
            case 'R':
            case 'r':
                ret = 27;
                break;
            case 'S':
            case 's':
                ret = 28;
                break;
            case 'T':
            case 't':
                ret = 29;
                break;
            case 'U':
            case 'u':
                ret = 30;
                break;
            case 'V':
            case 'v':
                ret = 31;
                break;
            case 'W':
            case 'w':
                ret = 32;
                break;
            case 'X':
            case 'x':
                ret = 33;
                break;
            case 'Y':
            case 'y':
                ret = 34;
                break;
            case 'Z':
            case 'z':
                ret = 35;
                break;
            default:
                try {//if the digit is not a digit,
                    ret = Integer.parseInt("" + c);
                } catch (Exception ex) {
                    throw new IllegalArgumentException("the integer to be converted is not in BASE-" + from);
                }
                break;
        }

        if (ret > from) {
            //if the digit has a value greater than what is allowed by that number base, 
            throw new IllegalArgumentException("the integer to be converted is not in BASE-" + from);
        }

        return ret;

    }
}
