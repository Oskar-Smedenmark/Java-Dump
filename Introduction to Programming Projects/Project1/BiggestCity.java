public class BiggestCity
{
  public static void main(String[] args)
  {
    String[] inputs = StdIn.readAllLines();
    int countryCode = 0;
    int citizens = 0;
    int cityCode = 0;
    int year = 0;

    int biggestCountryCode = 0;
    int biggestCityCode = 0;
    int biggestYear = 0;
    int maxCitizens = 0;

    for(int i = 0; i < inputs.length; i++)
    {
      String[] country = inputs[i].split(" ");
      for(int j = 0; j < country.length; j++)
      {
        double curValue = Double.parseDouble(country[j]);
        switch(j)
        {
          case 0:
            countryCode = (int)curValue;
          break;
          case 1:
            year = (int)curValue;
          break;
          case 3:
            cityCode = (int)curValue;
          break;
          case 4:
            citizens = (int)Math.round(curValue);
          break;
        }
      }
      if(maxCitizens < citizens)
      {
        biggestCountryCode = countryCode;
        biggestCityCode = cityCode;
        biggestYear = year;
        maxCitizens = citizens;
      }
    }
    StdOut.println("Country:" + biggestCountryCode + " City:" + biggestCityCode + " Year:" + biggestYear + " citizens:" + maxCitizens);
  }
}
