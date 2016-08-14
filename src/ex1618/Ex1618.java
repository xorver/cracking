package ex1618;

public class Ex1618 {

    public static boolean matches(String pattern, String string) {
        Hasher hasher = new Hasher(string);

        int countA = 0;
        int countB = 0;
        for(int i=0 ; i< pattern.length(); i++)
            if(pattern.charAt(i) == 'a')
                countA++;
            else
                countB++;
        if(countB > countA) {
            char[] array = pattern.toCharArray();
            for(int i=0; i<pattern.length() ;i++)
                if(array[i] == 'a')
                    array[i] = 'b';
                else
                    array[i] = 'a';
            int tmp = countA;
            countA = countB;
            countB = tmp;
        }

        for(int aLength=0; aLength * countA < string.length(); aLength++) {
            int bLength = (string.length() - aLength * countA) / countB;
            if (aLength * countA + bLength * countB == string.length())
                if(matches(pattern, hasher, 0, aLength, -1, bLength, -1))
                    return true;
        }
        return false;
    }

    private static boolean matches(String pattern, Hasher hasher, int offset,
                                   int aLength, int aHash, int bLength, int bHash) {
        if(pattern.length() == 0)
            return offset == hasher.string.length();
        if(pattern.charAt(0) == 'a') {
            if(aHash == -1)
                aHash = hasher.hash(offset,  offset + aLength);
            if(aHash != hasher.hash(offset, offset + aLength))
                return false;
            return matches(pattern.substring(1), hasher, offset + aLength, aLength, aHash, bLength, bHash);
        }
        else {
            if(bHash == -1)
                bHash = hasher.hash(offset, offset + bLength);
            if(bHash != hasher.hash(offset, offset + bLength))
                return false;
            return matches(pattern.substring(1), hasher, offset + bLength, aLength, aHash, bLength, bHash);
        }
    }

    public static void main(String[] args) {

        System.out.println(matches("bbaabab", "gocatcatgocatgo"));
    }
}
