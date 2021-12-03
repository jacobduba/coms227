# Topics and review problems for Exam 2

## Problem 1
### A
```
public static double findAverage(double[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    return sum / arr.length;
}
```
### B
```
public static String findLongestWord(String sentence) {
    String longest = "";

    Scanner scan = new Scanner(sectence);
    while (scan.hasNext()) {
        String next = scan.next();
        if (next.length() > longest.length()) {
            longest = next;
        }
    }
    return longest;
}

private static String longestWord(String sentence) {
    Scanner scan = new Scanner(sentence);
    
    String longest = scan.next();
    while (scan.hasNext()) {
        String nextWord = scan.next();

        if (nextWord.length() > longest.length()) {
            longest = nextWord;
        }
    }

    return longest;
}
```
### C
```
private static String replaceNonAlphabetic(String input) {
    String returnVal = ""';
    for (int ii = 0; i < input.length(); i++) {
        if (!Character.isAlphabetic(input.charAt(i)) {
            returnVal += "#";
        } else {
            returnVal += input.charAt(i);
        }
    }

    return returnVal;
}
```
### D
```
public static int monthsToDouble(double interest, double balance) {
    double doubled = balance * 2;
    int months = 0;
    while (doubled > balance) {
       balance += balance * interest; 
       months += 12;
    }
    return months;
}
```
### E X
```
public static boolean isIncreasingOrder(ArrayList<Integers> ordered) {
    for (int i = 1; i < ordered.size(); i++) {
        if (ordered.get(i - 1) > ordered.get(i)) {
            return false;
        }
    }
    return true;
}
```
### F
```
public static int firstVowel(String st) {
    for (int i = 0; i < st.length(); i++) {
        if ("AEIOUaeiou".indexOf(st.charAt(i)) != -1) {
            return i;
        }
    }
    return -1;
}
```
### G
```
public static boolean repeats(String st) {
    for (int x = 0; x < st.length(); x++) {
        for (y = x + 1; y < st.length(); y++) {
            if (st.charAt(x) == st.charAt(y)) {
                return true;
            }
        }
    }
    return false;
}

private static boolean areThereDuplicateLetters(String word) {
    for (int i = 0; i < word.length; i++ ) {
        for (int j = i + 1; k < word.length; j++) {
            if (word.charAt(i) == word.charAt(j)) {
                return true;
            }
        }
    }

    return false;
}
```
### H
```
public static int[] reverse(int[] arr) {
    int temp;
    for (int i = 0; i < arr.length / 2; i++) {
        temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 -i] = temp;
    }
    return temp;
}
```
### I
```
public static boolean isPerm(int[] arr) {
    for (int x = 0; x < arr.length; x++) {
        boolean okay = false;
        for (int y = 0; y < arr.length; y++) {
            if (arr[y] == x) {
                okay = true;
            }
        }
        if (!okay) {
            return false;
        }
    }
    return true;
}
```          
### J
```
public static void stars(int n) {
    for (int x = 0; x < n; x++) {
        for (int y = 0; y < n - x - 1; y--) {
            System.out.print(" ");
        }
        System.out.println("*");
    }
}
```
### K
```
public static double[] averages(double[][] arr) {
    double[] temp = new double[arr.length];
    for (int row = 0; row < arr.length; row++) {
        double average = 0;
        for (int col = 0; col < arr[row].length; col++) {
            average += arr[row][col];
        }
        temp[row] = average / arr[row].length;
    }
    return temp;
}
```
### L
```
public static int maxColSum(int[][] arr) {
    int[] colSums = new int[arr[0].length];
    for (int col = 0; col < arr[0].length; col++) {
        for (int row = 0; row < arr.length; row++) {
            colSums[col] += arr[row][col];
        }
    }
    int maxCol = 0;
    for (int i = 0; i < colSums.length; i++) {
        if (colSums[maxCol] < colSums[i]) {
            maxCol = i;
        }
    }
    return maxCol;
}
```
### M
```
public static int[][] soidfsduonfjajdioasndjosandj(int w, int h, int[] arr) {
    int[][] temp = new int[w][h];
    int row = 0;
    int col = 0;
    for (int i = 0, i < arr.length, i++) {
        temp[row][col] = arr[i];
        row = (row + 1) % w;
        col = (col + 1) % h;
    }
    return temp;
}
```
### N
```
public static int findPrime(int n) {
    n++;
    for (int i = 2; i < n; i++) {
        if (n % i == 0) {
            return findPrime(n);
        }
    }
    return n;
}
```
### O
```
// Efficient
private static void collapseArray(int[] arr) {\
    int[] temp = new int[arr.length];
    int temp_size;

    for (int i = 0;i < arr.length; i++) {
        boolean flag = true;
        for (int j = 0; j < temp_size; j++) {
            if (temp[j] == arr[i]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            temp[temp_size] = arr[i];
            temp_size++;
        }
    }
    // Change everything below for part P
    for (int i = temp_size - 1; i < temp.length; i++) {
        temp[i] = 0;
    }

    for (int i = 0; i < arr.length; i++) {
        arr[i] = temp[i];
    }
}

// Easier to write
public static void collapse(int[] arr) {
    ArrayList<Integer> temp = new ArrayList<>();
    for (int num : arr) {
	if (!temp.contains(num)) {
	    temp.add(num);
	}
    }

    int index = 0;
    for (int num: temp) {
	arr[index] = num;
	index += 1;
    }

    for (int i = index; i < arr.length; i++) {
	arr[i] = 0;
    }
}
```
### P
```
public static int[] withoutDupes(int[] arr) {
    ArrayList<Integer> arrlst = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
        if (!arrlst.contains(arr[i]) {
            arrlst.add(arr[i]);
        }
    }
    int[] temp = arlst.toArray();
}
```
### Q
```
public static ArrayList<Integer> randomList(Random rand) {
    ArrayList<Integer> temp = new ArrayList<Integer>();
    int next = rand.nextInt(100);
    while (!temp.contains(next)) {
        temp.add(next);
        next = rand.nextInt(100);
    }
    return temp;
}
```
### R
```
public static String reverse(String st) {
    String[] words = st.split(" ");
    String temp = "";
    for (int i = words.length - ; i > 0; i--) {
        temp += words[i] + " ";
    }
    temp += words[0];
    return temp;
}
```
### S
```
public static void rebereiufndjafnsjodnsdiofjnsfijnfdzspjfnds(int[] arr) {
    int midway = arr.length / 2;
    for (int i = 0; i < midway; i++) {
        int temp = arr[midway + i];
        arr[midway + i] = arr[i];
        arr[i] = temp;
    }
}
```
## Problem #2 (!!!!!!!!)
```
public static void main(String[] args) {
    System.out.println("Enter a filename:");
    Scanner input = new Scanner(System.in);

    String filename = input.nextLine();
    Scanner javaFile = new Scanner(new File(filename));
    
    ArrayList<String> uncommentedCode = new ArrayList<String>();

    while (javaFile.hasNextLine()) {
        String line = javaFile.nextLine();
        int index = line.indexOf("//");

        if (index == -1) {
            uncommentedCode.add(line);
        } else {
            uncommentedCode.add(line.substring(0, index));
        }
    }

    String outputFilename = filename.substring(0, filename.length() - 5) + ".out";
    PrinterWriter output = new PrinterWriter(new File(outputFilename));

    for (String line : uncommentCode) {
        output.println(line);
    }

    javaFile.close();
    output.close();
}
```
## Problem #3
```
11, 1
12, 1
10, 2
7, 3
6, 3
2, 4
-3, 5
```
## Problem #4
```
{7, 3, 5, 7, 9, 0, 0, 0, 0}
```
## Problem #5
```
public static String getPassword() {
    Scanner scan = new Scanner(System.in);
    String pass1;
    String pass2;
    do {
        System.out.println("Enter password");
        pass1 = scan.next();
        System.out.println("Enter pass again");
        pass2 = scan.next();
    } while (!pass1.equals(pass2));
    return pass1;
}

public static String getPassword() {
    Scanner scan = new Scanner(System.in);

    boolean success = false;
    while (!success) {
        System.out.println("Enter password:");
        String try1 = scan.next();
        System.out.println("Again:");
        System try2 = scan.next();

        if (try1.equals(try2)) {
            success = true;
            scan.close();
            return try1;
        }
    }
}
```
## Problem #6
### A
```

```
### B
```
public class ContactDirectory {
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void addContact(Contact c) {
        contactList.add(c);
    }

    public void addFromFile(String filename) throw FileNotFoundException {
        File f = new File(filename);
        Scanner scan = new Scanner(f);
        
        while (scan.hasNextLine()) {
            ScanLine.useDelimiter(", ");
            String line = scan.nextLine();
            Scanner scanLine = new Scanner(line);
            while (scanLine.hasNext()) {
                String name = scanLine.next();
                String number = scanLine.next();
                Contact c = new Contact(name, number);
                addContact(c);
            }
            scanLine.close();
        }
        scan.close();
    }

    public String lookUp(String name) {
        for (int i = 0; i< contactList.size(); i++) {
            if (name.equal(contactList.get(i).getName())) {
                return contactList.get(i).getPhoneNumber();
            }
        }
        return null;
    }
}
```
## Problem #7
### A
10
4
2
Pooh
### B
Pooh
2
4
10
### C
Never gonna end: Stackoverflow error
## Problem #8
```
public static boolean whoKnows2(int[] arr, int i, int j) {
    for (int k = i; k < j; k++) {
        if (arr[k] > arr[k + 1]) {
            return false;
        }
    }
    
    return true;
}
```
