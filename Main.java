import java.util.*;

class String1 {

    Scanner sc = new Scanner(System.in);

    public void duplicates() {
        ArrayList<Character> arrayList = new ArrayList<>();
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length - 1; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    arrayList.add(ch[i]);
                }
            }
        }
        System.out.println("Duplicate Elements:" + arrayList);


    }

    public String Reverse(String str2) {


        if (str2.isEmpty()) {

            return str2;

        } else {
            return (Reverse(str2.substring(1)) + str2.charAt(0));
        }
    }

    public void CountCharacters() {

        int i;
        int length;
        int[] counter = new int[256];
        System.out.println("Enter new string:");
        String str3 = sc.nextLine();
        length = str3.length();
        for (i = 0; i < length; i++) {
            counter[(int) str3.charAt(i)]++;
        }
        for (i = 0; i < 256; i++) {
            if (counter[i] != 0) {
                System.out.println((char) i + " " + counter[i]);
            }
        }
    }

    public void Concatenation() {
        int length2;
        int length3;
        System.out.println("Enter any two strings:");
        String str4 = sc.nextLine();
        String str5 = sc.nextLine();
        length2 = str4.length();
        length3 = str5.length();
        if (length2 != length3) {
            if (length2 > length3) {
                str4 = str4.substring(length2 - length3);
                System.out.println(str4 + str5);
            } else {
                str5 = str5.substring(length3 - length2);
                System.out.println(str4 + str5);
            }

        } else {
            System.out.println("After concatenation:" + (str4 + str5));
        }
    }

    public int Longest(String str6) {
        int n = str6.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0;
        while (i < n && j < n) {
            if (!set.contains(str6.charAt(j)) && str6.charAt(j) != ' ') {
                set.add(str6.charAt(j++));
                max = Math.max(max, j - i);

            } else {
                set.remove(str6.charAt(i++));
            }
        }
        return max;
    }

    /* public void permutations(String str7)
     {
         List<String>result=new ArrayList<>();
         Stack<String>stack=new Stack<>();
         stack.push("");
         while(!stack.isEmpty()){
             String prefix= stack.pop();
             if(prefix.length()==str7.length()){
                 result.add(prefix);

             }else{
                 for(int i=0;i<str7.length();i++){
                     String ch=String.valueOf(str7.charAt(i));
                     if(!prefix.contains(ch))
                     {
                         stack.push(prefix+ch);
                     }
                 }
             }
         }
         System.out.println(result);
     }*/
    public String swapping(String str7, int i, int j) {
        char[] carray = str7.toCharArray();
        char b;
        b = carray[i];
        carray[i] = carray[j];
        carray[j] = b;
        return String.valueOf(carray);
    }

    public void permutation(String str7, int start, int end) {
        if (start == end - 1) {
            System.out.println(str7);
        } else {
            for (int i = start; i < end; i++) {
                str7 = swapping(str7, start, i);
                permutation(str7, start + 1, end);
                str7 = swapping(str7, start, i);
            }
        }
    }
}


    public class Main {
        public static void main(java.lang.String[] args) {
            Scanner sc = new Scanner(System.in);

            String1 str1 = new String1();
            str1.duplicates();
            System.out.println("Enter a string to reverse:");
            String str2 = sc.nextLine();
            System.out.println(str1.Reverse(str2));
            str1.CountCharacters();
            str1.Concatenation();
            System.out.println("Enter any sting containing substring:");
            String str6 = sc.nextLine();
            System.out.println(str1.Longest(str6));
            System.out.println("Enter any String:");
            String str7 = sc.nextLine();

            int end = str7.length();
            int start = 0;

            str1.permutation(str7, start, end);

        }
    }


