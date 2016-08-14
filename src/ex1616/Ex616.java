package ex1616;

import java.util.Arrays;
import java.util.List;

public class Ex616 {

    public static Indices getIndices(List<Integer> list) {
        Indices result = new Indices();
        if (list.isEmpty())
            return result;

        //compute end
        int i = 0;
        while (list.size() > i + 1 && list.get(i + 1) >= list.get(i))
            ++i;
        int limit = list.get(i);
        for (int j = i + 1; j < list.size(); ++j)
            if (list.get(j) <= limit)
                result.end = j;

        //compute begin
        i = list.size() - 1;
        while (i - 1 >= 0 && list.get(i - 1) <= list.get(i))
            --i;
        limit = list.get(i);
        for (int j = i - 1; j >= 0; --j)
            if (list.get(j) >= limit)
                result.begin = j;

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19);
//        List<Integer> list = Arrays.asList(1, 2, 4, 7, 10, 11, 12, 16, 18, 19);

        System.out.println(getIndices(list));
    }
}
