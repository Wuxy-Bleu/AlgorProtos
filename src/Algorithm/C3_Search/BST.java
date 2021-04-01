package Algorithm.C3_Search;

public class BST {

    public StringBuilder replceAll(String A, String B, String C) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < A.length(); ) {
            if (containsB(A, i, B)) {
                i += B.length();
                res.append(C);
            } else {
                res.append(A.charAt(i));
                i++;
            }
        }
        return res;
    }

    public boolean containsB(String A, int index, String B) {
        boolean exist = true;
        for (int i = index, j = 0; i < A.length() && j < B.length(); i++, j++)
            if (A.charAt(i) != B.charAt(j)) {
                exist = false;
                break;
            }
        return exist;
    }


    public static void main(String[] args) {
        BST test = new BST();
        System.out.println(test.replceAll("123456", "12345678", "r,.lp,pl,lp")) ;
    }
}
