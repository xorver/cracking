package ex1711;

public class Ex1711 {

    public static boolean checkMajor(int[] tab, int n) {
        int count = 0;
        for (int i = 0; i < tab.length; i++)
            if (tab[i] == n)
                count++;
        return count > (tab.length / 2);
    }

    private static int findMajor(int[] tab) {
        if(tab.length == 0)
            return -1;
        int major = tab[0];
        int state = 1;
        for(int i=1; i<tab.length - 1; i++){
            state += tab[i] == major ? 1 : -1;
            if(state == 0)
                major = tab[i+1];
        }
        return checkMajor(tab, major) ? major : -1;
    }

    public static void main(String[] args) {
        int[] tab = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println(findMajor(tab));
    }

}
