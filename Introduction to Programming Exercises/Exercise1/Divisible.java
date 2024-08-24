public class Divisible
{
  public static void main(String[] args)
  {
    int div1 = Integer.parseInt(args[0]);
    int div2 = Integer.parseInt(args[1]);
    boolean divis = div1 % div2 == 0 || div2 % div1 == 0;
    System.out.println(divis);
  }
}
