public class CleanSigns{
   public static void main(String[] cmdLn){
       StdIn.readLine();
       char c = StdIn.readChar();
       while(!StdIn.isEmpty() && c != 'f'){
           if(c == '"'){System.out.print("");}
           else if(c == ';'){System.out.print(" ");}
           else System.out.print(c);
           c = StdIn.readChar();
       }
   }
}
