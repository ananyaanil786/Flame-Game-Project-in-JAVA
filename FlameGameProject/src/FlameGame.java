import java.util.Scanner;
class FlameGame {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name1 = scan.nextLine();
        System.out.println("Enter other name: ");
        String name2 = scan.nextLine();
        String string1 = name1.toLowerCase();
        String string2 = name2.toLowerCase();
        StringBuilder sb1 = new StringBuilder(string1);
        StringBuilder sb2 = new StringBuilder(string2);
        int sb1_len = sb1.length();
        int sb2_len = sb2.length();
        // Finding the uncommon characters count using a function. 
        int uncommon_char_count = uncommon_characters_count(sb1, 
                                          sb1_len, sb2, sb2_len);
        // Storing the word "FLAMES" as a string.
        StringBuilder str = new StringBuilder("FLAMES");
        int str_len = str.length();
        int idx = 0, flames_count = 0;
        /* Starting the counting from F. 
           Repeating the counting from F, when the counting reaches S.
           Shifting the characters until it reaches the string length.
           Removing the eliminated character from the string "FLAMES"
           Repeating the process until the string length reaches 0.
        */
        while(str_len > 0)
        {
            flames_count++;            
            if(idx == str_len-1)
            {
                idx = 0;
            }
            else{
                idx++;
            }
            if(flames_count == uncommon_char_count)
            {   
                int j = 0;
                if(idx == 0)
                {
                   j = str_len - 1; 
                }
                else{
                  j = --idx;  
                }
                while(j < str_len - 1)
                {
                    str.setCharAt(j, str.charAt(j + 1));
                    j++;
                }
                flames_count = 0;
                str_len--;
            }
        }
        // Storing the last character from the string "FLAMES".
        char ch = str.charAt(0);
        // Using the switch case construct to print the relationship.         
        switch(ch)
        {
            case 'F':
            {
                System.out.print("Friends");
                break;
            }
            case 'L':
            {
                System.out.print("Love");
                break;
            }
            case 'A':
            {
                System.out.print("Affection");
                break;
            }
            case 'M':
            {
                System.out.print("Marriage");
                break;
            }
            case 'E':
            {
                System.out.print("Enemy");
                break;
            }
            case 'S':
            {
                System.out.print("Sibling");
                break;
            }
        }
    }
    // Returns the count of uncommon characters
    public static int uncommon_characters_count(StringBuilder sb1, 
                   int sb1_len,  StringBuilder sb2, int sb2_len){        
        for(int i = 0; i < sb1_len; i++)
        {
            for(int j = 0; j < sb2_len; j++)
            {
                if(sb1.charAt(i)== sb2.charAt(j))
                {
                    sb1.setCharAt(i,'$');
                    sb2.setCharAt(j,'$'); 
                    break;
                }
            }
        }
        int count = 0;
        for(int i =0; i < sb1_len; i++)
        {
            if(sb1.charAt(i) != '$')
            {
                count++; 
            }
        }
        for(int i =0; i < sb2_len; i++)
        {
            if(sb2.charAt(i) != '$')
            {
                count++; 
            }
        }
        return count;
    }
}
