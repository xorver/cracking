package ex1713;

import java.util.ArrayList;
import java.util.List;

public class Ex1713 {

    public static void main(String[] args) {
        String s = "jesslookedjustliketimherbrother";

        Node root = new Node(false);

        // first level
        Node l = new Node(false);
        Node j = new Node(false);
        Node h = new Node(false);
        Node b = new Node(false);
        root.children.put('l', l);
        root.children.put('j', j);
        root.children.put('h', h);
        root.children.put('b', b);

        // looked
        Node o1 = new Node(false);
        Node o2 = new Node(false);
        Node k = new Node(false);
        Node e = new Node(false);
        Node d = new Node(true);
        l.children.put('o', o1);
        o1.children.put('o', o2);
        o2.children.put('k', k);
        k.children.put('e', e);
        e.children.put('d', d);

        // like
        Node i = new Node(false);
        Node k2 = new Node(false);
        Node e2 = new Node(true);
        l.children.put('i', i);
        i.children.put('k', k2);
        k2.children.put('e', e2);

        // just
        Node u = new Node(false);
        Node s2 = new Node(false);
        Node t = new Node(true);
        j.children.put('u', u);
        u.children.put('s', s2);
        s2.children.put('t', t);

        // her
        Node e3 = new Node(false);
        Node r = new Node(true);
        h.children.put('e', e3);
        e3.children.put('r', r);

        // brother
        Node r2 = new Node(false);
        Node o3 = new Node(false);
        Node t2 = new Node(false);
        Node h2 = new Node(false);
        Node e4 = new Node(false);
        Node r3 = new Node(true);
        r.children.put('r', r2);
        r2.children.put('o', o3);
        o3.children.put('t', t2);
        t2.children.put('h', h2);
        h2.children.put('e', e4);
        e4.children.put('r', r3);

        System.out.println(decompose(s, root));



    }

    private static List<String> decompose(String s, Node dict) {
        List<String> result = new ArrayList<>();
        int offset = 0;
        int unknownSize = 0;

        while(offset + unknownSize < s.length()) {
            int knownSize = findWord(offset + unknownSize, s, dict);
            if(knownSize == -1)
                unknownSize++;
            else {
                if(unknownSize > 0)
                    result.add(s.substring(offset, offset + unknownSize));
                result.add(s.substring(offset + unknownSize, offset + unknownSize + knownSize));
                offset += knownSize + unknownSize;
                unknownSize = 0;
            }
        }

        if(offset < s.length())
            result.add(s.substring(offset));
        return result;
    }

    private static int findWord(int offset, String s, Node dict) {
        if(dict == null || offset >= s.length())
            return -1;
        Node n = dict.children.get(s.charAt(offset));
        int tailSize = findWord(offset + 1, s, n);
        if(tailSize == -1)
            return dict.isTerminal ? 0 : -1;
        return 1 + tailSize;

    }

}
