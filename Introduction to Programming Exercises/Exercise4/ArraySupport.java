public class ArraySupport{
  // print the elements of an array, separated by a white space
  // and a new line after the last element
  public static void printlnArray(int[] a)
  {
    for(int i = 0; i < a.length; i++)
    {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
  public static void printlnArray(double[] a)
  {
    for(int i = 0; i < a.length; i++)
    {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }
  public static void printlnArray(long[] a, int n)
  {
    for(int j = a.length-n/2; j < n; j++)
    {
      System.out.print("  ");
    }
    for(int i = 0; i < a.length; i++)
    {
      if(a[i] < 10)
      {
        System.out.print(a[i] + "   ");
      }
      else if(a[i] < 100)
      {
        System.out.print(a[i] + "  ");
      }
      else if(a[i] < 1000)
      {
        System.out.print(a[i] + " ");
      }
    }
    System.out.println();
  }
  // compare two arrays for equality:
  // two arrays are equal if and only if they have the same length
  // and have the same elements
  public static boolean equals(int[] a, int[] b)
  {
    if(a.length <= 0)
    {
      return false;
    }
    boolean equal = true;
    if(a.length == b.length)
    {
      for(int i = 0; i < a.length && equal; i++)
      {
        if(a[i] != b[i])
        {
           equal = false;
        }
      }
    }
    else
    {
      equal = false;
    }
    return equal;
  }
  public static boolean equals(double[] a, double[] b)
  {
    if(a.length <= 0)
    {
      return false;
    }
    boolean equal = true;
    if(a.length == b.length)
    {
      for(int i = 0; i < a.length && equal; i++)
      {
        if(a[i] != b[i])
        {
           equal = false;
        }
      }
    }
    else
    {
      equal = false;
    }
    return equal;
  }
  // calculate the maximum value in an array:
  public static int max(int[] a)
  {
    if(a.length <= 0)
    {
      return 0;
    }
    int max = a[0];
    for(int i = 1; i < a.length; i++)
    {
      if(a[i] > max)
      {
        max = a[i];
      }
    }
    return max;
  }
  public static double max(double[] a)
  {
    if(a.length <= 0)
    {
      return 0;
    }
    double max = a[0];
    for(int i = 1; i < a.length; i++)
    {
      if(a[i] > max)
      {
        max = a[i];
      }
    }
    return max;
  }
  // calculate the minimum value in an array:
  public static int min(int[] a)
  {
    if(a.length <= 0)
    {
      return 0;
    }
    int min = a[0];
    for(int i = 1; i < a.length; i++)
    {
      if(a[i] < min)
      {
        min = a[i];
      }
    }
    return min;
  }
  public static double min(double[] a)
  {
    if(a.length <= 0)
    {
      return 0;
    }
    double min = a[0];
    for(int i = 1; i < a.length; i++)
    {
      if(a[i] < min)
      {
        min = a[i];
      }
    }
    return min;
  }
  // calculate the average among the values in an array:
  public static double average(double[] a)
  {
    if(a.length <= 0)
    {
      return 0;
    }
    double avg = 0;
    double sum = 0;
    for(int i = 0; i < a.length; i++)
    {
      sum += a[i];
    }
    avg = sum/a.length;
    return avg;
  }
  // read an array from standard input
  // given the number of elements that have to be read to the array
  public static int[] readIntArray(int nrOfElements)
  {
    if(nrOfElements <= 0)
    {
      nrOfElements = 0;
    }
    int[] a = new int[nrOfElements];
    for(int i = 0; i < nrOfElements; i++)
    {
      a[i] = StdIn.readInt();
    }
    return a;
  }
  public static double[] readDoubleArray(int nrOfElements)
  {
    if(nrOfElements <= 0)
    {
      nrOfElements = 0;
    }
    double[] a = new double[nrOfElements];
    for(int i = 0; i < nrOfElements; i++)
    {
      a[i] = StdIn.readDouble();
    }
    return a;
  }
}
