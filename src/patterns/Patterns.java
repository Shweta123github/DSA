package patterns;

/*
 ****
 ****
 ****
 ****

public class Patterns {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("*");
            }

            System.out.println("  ");
        }
    }
}
*/

/*
*
**
***
****
*****

public class Patterns {
    public static void main(String[] args) {
        for (int i = 0; i <=5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }

            System.out.println("  ");
        }
    }
}
*/

/*
1
12
123
1234

public class Patterns2 {
    public static void main(String[] args) {
        for (int i = 1; i < =5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            System.out.println("  ");
        }
    }
}

*/
/*
1
22
333
4444
public class Patterns2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }

            System.out.println("  ");
        }
    }
}*/
/*
 ******
 *****
 ****
 ***
 **
 *



public class Patterns2 {
    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }

            System.out.println("  ");
        }
    }
}

 */
/*
12345
1234
123
12
1

public  class Patterns2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i+ 1; j++) {
                System.out.print(j);
            }

            System.out.println("  ");
        }
    }
}*/

/*  *
   ***
  *****
 *******
*********



public  class Patterns2 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //space
            for (int j = 0; j < 5 - i - 1; j++) {
                System.out.print(" ");
            }
            //star
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");

            }
            //space
            for (int j = 0; j < 5 - i - 1; j++) {
                System.out.print(" ");

                }
                System.out.println(" ");
            }
        }
    }
*/
/*

 *****
  ***
   *
import java.util.Scanner;

public  class Patterns2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i = 0; i < n; i++) {
            //space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            //star
            for (int j = 0; j < 2*n - (2*i + 1); j++) {
                System.out.print("*");

            }
            //space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");

            }
            System.out.println(" ");
        }
    }
}
*/

/*
  *
 ***
*****
*****
 ***
  *

public class Patterns2 {
    public static void main(String[] args) {
        int n = 3; // The height of the half-diamond

        // Upper part of the pattern
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        // Lower part of the pattern
        for (int i = 0; i < n; i++) {
            // Spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Stars
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }
            // Spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
*/

/*
 *
 **
 ***
 ****
 *****
 ****
 ***
 **
 *
public class Patterns2 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <=2 * n - 1; i++) {
            int stars = i;
            if (i > n) {
                stars = 2 * n - i;
            }
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}*/

/*
1
01
101
0101
10101

public class Patterns2 {
    public static void main(String[] args) {
        int n = 5;
        int start = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                start = 1;
            } else {
                start = 0;
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }

            System.out.println();
        }
    }
}
*/
/*
1        1
12      21
123    321
1234  4321
1234554321

public  class Patterns2 {
    public static void main(String[] args) {
        int n=5;
        int space= 2* (n-1);
        for (int i = 1; i<=n; i++) {
            //numbers
            for (int j = 1; j<=i; j++) {
                System.out.print(j);
            }
            //space
            for (int j = 1; j<=space; j++) {
                System.out.print(" ");

            }
            //numbers
            for (int j = i; j >=1; j--) {
                System.out.print(j);

            }
            System.out.println(" ");
            space-=2;
        }
    }
}

*/
/*
1
23
456
78910
1112131415

public class Patterns2 {
    public static void main(String[] args) {
        int n=5;
        int num=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
                num++;
            }

            System.out.println("  ");
        }
    }
}*/
/*
A
AB
ABC
ABCD
ABCDE

public class Patterns2 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 0; i < n; i++) {
            for (char ch='A';ch<='A'+i;ch++) {
                System.out.print(ch);
            }

            System.out.println("  ");
        }
    }
}
*/
/*
ABCDE
ABCD
ABC
AB
A

public class Patterns2 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 0; i < n; i++) {
            for (char ch='A';ch<='A'+(n-i-1);ch++) {
                System.out.print(ch);
            }

            System.out.println("  ");
        }
    }
}
*/
/*
A
BB
CCC
DDDD
EEEEE


public class Patterns2 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 0; i < n; i++) {
            char ch= (char) ('A'+ i);
            for (int j=0;j<=i;j++) {
                System.out.print(ch);
            }
            System.out.println("  ");

        }
    }
}
*/

/*
    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA

public class Patterns2 {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            char ch = 'A';
            int breakpoint = (2 * i + 1) / 2;

            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(ch);
                if (j <= breakpoint) {
                    ch++;
                } else {
                    ch--;
                }
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}*/
/*
E
DE
CDE
BCDE
ABCDE

public class Patterns2 {
    public static void main(String[] args) {
        int n=5;
        for (int i = 0; i < n; i++) {
           for (char ch=(char) ('E'-i);ch<='E';ch++) {
                System.out.print(ch);
            }

            System.out.println("  ");
        }

 */
/*
 ******
 **  **
 *    *
 *    *
 **  **
 ******

class Patterns2 {
    public static void main(String[] args) {
        int n = 3;
        int space=0;
        for (int i = 0; i < n; i++) {
            // stars
            for (int j = 1; j <= n - i ; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            space+=2;
            System.out.println();
        }
        space =2*n-2;
        for (int i = 1; i <= n; i++) {
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j <space; j++) {
                System.out.print(" ");
            }
            // stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
            space-=2;
        }
    }
}
*/
/*
 *        *
 **      **
 ***    ***
 ****  ****
 **********
 ****  ****
 ***    ***
 **      **
 *        *

public class Patterns2 {
    public static void main(String[] args) {
        int n = 5;
        int space= 2*n-2;
        for (int i = 1; i <=2 * n - 1; i++) {
            int stars = i;
            if (i > n) {
                stars = 2 * n - i;
            }
            //stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            //spaces
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            if(i<n){
                space-=2;
            }else{
                space+=2;
            }
            System.out.println();

        }
    }
}
*/

/*
*****
*   *
*   *
*   *
*****

public class Patterns {
    public static void main(String[] args) {
        //only fill boundries 0 to n-1
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print("*");
                } else {

                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
*/
/*
      *
     **
    ***
   ****
  *****

public class Patterns {
    public static void main(String[] args) {
        int n=5;
        for (int i = 0; i < n; i++) {
            //space
            for (int j = 0; j <= n-i; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}*/
/*
 *****
 ****
 ***
 **
 *

public class Patterns {
    public static void main(String[] args) {
        int n=5;
        for (int i = 0; i < n; i++) {

            //space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            //stars
            for (int j = 0; j <n-i; j++) {
                System.out.print("*");
            }


            System.out.println(" ");
        }
    }
}
* */


/*public  class Patterns {
    public static void main(String[] args) {
        int n=5;
        int star=2*n-1;
        for (int i = 0; i < n; i++) {
            //space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            //star
            for (int j = 0; j < star; j++) {
                System.out.print("*");

            }
            //space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");

            }
            star-=2;
            System.out.println(" ");

        }
    }
}
*/
/*
5
44
333
2222
11111

public class Patterns {
    public static void main(String[] args) {
        int n = 5;


        for (int i = 1; i <= n; i++) {
            int num=n-i+1;
            for (int j = 1; j <= i; j++) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}
*/
/*
0
222
44444
6666666
88888888

public class Patterns {
    public static void main(String[] args) {
        int n = 5;
        int num=0;

        for (int i = 0; i <n; i++) {
            for (int j = 0; j <=num; j++) {
                System.out.print(num);
            }
            num+=2;
            System.out.println();
        }
    }
}
*/
/*
5
54
543
5432
54321

public class Patterns {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 1; i <=n; i++) {
            //numbers
            for (int j = 5; j >=n-i+1; j--) {
                System.out.print(j);
            }
            //spaces
            for (int j = 1; j <=(n-i); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
*/

