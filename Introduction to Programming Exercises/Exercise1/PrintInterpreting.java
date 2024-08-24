public class PrintInterpreting
{
  public static void main(String[] args)
  {
    //Adderar 2 som en sträng till "bc", resultat = "2bc"
    System.out.println(2 + "bc");

    //Adderar 2 integers först sen adderar resultatet som en sträng till bc, resulterar i "5bc"
    System.out.println(2 + 3 + "bc");

    //Parantes onödig samma resultat som förra, "5bc" eftersom uträkningen sker först
    System.out.println((2 + 3) + "bc");

    //Resultat "bc5" då datorn tar strängen och ska addera den med nästa element som är resultatet av parantesen
    System.out.println("bc" + (2 + 3));
    //Resultat "bc23" då den går från vänster till höger och adderar integern till strängen och sedan den totala strängen med nästa integer
    System.out.println( "bc" + 2 + 3);

  }
}
