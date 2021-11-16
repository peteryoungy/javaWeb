import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {


    public static void main(String[] args) {

        List<Long> lists = new ArrayList<>();

        lists.add(1L);
        lists.add(4L);
        lists.add(2L);
        lists.add(3L);
        //Integer a = new Integer(1);

        System.out.println(lists);
        lists.remove(new Integer(1));
        System.out.println(lists);
        System.out.println(lists instanceof LinkedList);

        String s = new String("1,3");
        System.out.println(s.charAt(0));
        System.out.println("11");
        String s1 = new String(((char) (s.charAt(0)+1))+","+s.charAt(2));
        System.out.println(s1);


    }

}
