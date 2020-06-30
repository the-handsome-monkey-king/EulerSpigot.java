/*************************************************

   EulerSpigot.java

   An implementation of a spigot algorithm to find 
   Euler's constant to n digits.

   @author Ryan Morehouse
   @license MIT

****************************************************/


class EulerSpigot {
	public static void main(String []args) {

    // get and verify args
    if(args.length < 1) {
      System.err.println("Usage: java EulerSpigot [n]");
      System.exit(1);
    }

    int n = 0;
    try {
      n = Integer.parseInt(args[0]);
    } catch (NumberFormatException e) {
      System.err.println("Usage: java EulerSpigot [n]");
      System.exit(1);
    }

    if (n < 1) {
      System.err.println("Usage: java EulerSpigot [n]");
      System.exit(1);
    }

    // initialize array
    int l = n+2;
    int a[] = new int[l];
    for(int i = 0; i < l; i++) {
      a[i] = 1;
    }

    // first digit is 2
    System.out.print(2);

    if (n > 1) {
      for(int i = 0; i < n-1; i++) {
        int q = 0;
        for(int j = l-1; j > -1; j--) {
          int denom = j+2;
          int nom = (10 * a[j]) + q;
          q = nom / denom;
          int r = nom % denom;
          a[j] = r;
          if(j == 0) {
            System.out.print(q);
          }
        }
      }
    }
    System.out.print("\n");
  }
}
