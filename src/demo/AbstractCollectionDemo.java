package demo;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AbstractCollectionDemo {

  public static void main(String[] args) {
    
    Map<String, String> map = new HashMap<String, String>();
    map.put("Gaurav", "Yadav");
    map.put(null, "Yadav");
    map.put(null, "Paras");
    //System.out.println(map.get(null));
    
    AbstractCollection<Integer> ab = new TreeSet<Integer>();
    ab.add(1);
    ab.add(190);
    ab.add(144);
    ab.add(31);
    ab.add(13);
    ab.add(12);
    ab.add(14);
    
    AbstractCollection<Integer> ab1 = new TreeSet<Integer>();
    ab1.add(1);
    //ab.clear();

//    ab.forEach((element) -> {
//      ab.remove(1);
//    });

    System.out.print(ab);
  }

}
