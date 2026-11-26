package part2_decomposition;

import common.Input;
/* PSEUDOCODE:
   REPEAT: read name, age and genre; choose a book using age AND genre;
   print recommendation; ask whether to repeat; UNTIL answer is not Y.
*/
public class Main {
    public static void print(String message) { System.out.println(message); }
    public static String getUserString(String prompt) { return Input.text(prompt); }
    public static int getAge() {
        while(true) {
            try { int age=Integer.parseInt(getUserString("Age (0-120): "));
                if(age>=0 && age<=120) return age;
            } catch(NumberFormatException ignored) { }
            print("Please enter a valid age.");
        }
    }
    public static boolean askToContinue() { return getUserString("Continue? (Y/N): ").equalsIgnoreCase("y"); }
    public static String recommend(int age,String genre) {
        if(genre.equalsIgnoreCase("detective")) return age<17?"The Westing Game":"The Hound of the Baskervilles";
        if(genre.equalsIgnoreCase("fantasy")) return age<17?"The Hobbit":"The Lord of the Rings";
        if(genre.equalsIgnoreCase("non-fiction")) return age<17?"A Short History of Nearly Everything":"The Design of Everyday Things";
        return age<17?"The Little Prince":"Animal Farm";
    }
    public static void runConversation() {
        String name=getUserString("Name: ");
        int age=getAge();
        String genre=getUserString("Genre (detective/fantasy/non-fiction/other): ");
        print(name+", try reading: "+recommend(age,genre));
    }
    public static void main(String[] args) { do { runConversation(); } while(askToContinue()); }
}
