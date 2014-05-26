package interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class StringMinNumOfSwaps {

    public static boolean containSameCharacters(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] count = new int[256];
        int i = 0;
        int len = a.length();
        for (i = 0; i < len; ++i)
            ++count[a.charAt(i)];
        for (i = 0; i < len; ++i) {
            if (--count[b.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    public static int getMinimumSwaps(String from, String to) {
        if (!containSameCharacters(from, to))
            return -1;
        if (from == to)
            return 0;

        Map<String, Integer> fromMap = new HashMap<String, Integer>();
        Map<String, Integer> toMap = new HashMap<String, Integer>();// record
                                                                    // state
                                                                    // already
                                                                    // visited
                                                                    // and
                                                                    // how many
                                                                    // swaps
                                                                    // need to
                                                                    // transfrom
                                                                    // into this
                                                                    // state
        Queue<String> fromQueue = new LinkedList<String>();
        Queue<String> toQueue = new LinkedList<String>();// states queue
        int level = 1; // how many swaps has been done

        String tmp = "";
        int i, j, k, n, len = from.length();
        // unordered_map<string, int>::iterator iter;
        // initialize
        fromQueue.offer(from);
        fromMap.put(from, 0);
        toQueue.offer(to);
        toMap.put(to, 0);
        // binary BFS
        for (; !fromQueue.isEmpty() && !toQueue.isEmpty(); ++level) {
            // extend state in fromQueue
            for (i = 0, n = fromQueue.size(); i < n; ++i) {
                tmp = fromQueue.poll();
                for (j = 0; j < len; ++j) {
                    for (k = j + 1; k < len; ++k) {
                        tmp = swap(tmp, j, k);// try to swap tmp[j] with tmp[k]
                        // iter = toMap.find(tmp);//check if this state has been
                        // visited by 'to'
                        if (toMap.containsKey(tmp)) {
                            System.out.println("fromMap[" + tmp + "]= " + level);
                            System.out.println("toMap[" + tmp + "]= " + toMap.get(tmp));
                            return level + toMap.get(tmp);
                        } else if (fromMap.containsKey(tmp)) {// check if this
                                                              // state has been
                                                              // visited by
                                                              // 'from'
                            fromQueue.offer(tmp);
                            fromMap.put(tmp, level);
                        }
                        tmp = swap(tmp, j, k);
                    }
                }
            }
            // extend state in toQueue
            for (i = 0, n = toQueue.size(); i < n; ++i) {
                tmp = toQueue.poll();
                for (j = 0; j < len; ++j) {
                    for (k = j + 1; k < len; ++k) {
                        tmp = swap(tmp, j, k);// try to swap tmp[j] with tmp[k]
                        // iter = fromMap.find(tmp);//check if this state has
                        // been visited by 'from'
                        if (fromMap.containsKey(tmp)) {
                            System.out.println("toMap[" + tmp + "]= " + level);
                            System.out.println("fromMap[" + tmp + "]= " + fromMap.get(tmp));
                            return level + fromMap.get(tmp);
                        } else if (toMap.containsKey(tmp)) {// check if this
                                                            // state has been
                                                            // visited by 'to'
                            toQueue.offer(tmp);
                            toMap.put(tmp, level);
                        }
                        tmp = swap(tmp, j, k);
                    }
                }
            }
        }

        return -1;// actually it never reaches here
    }

    public static String swap(String s, int i, int j) {

        char[] c = s.toCharArray();
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;

        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(getMinimumSwaps("kamal", "amalk"));
    }
}
