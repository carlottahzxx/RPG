import java.util.ArrayList;
import java.util.List;

public class room {
    int number;
    String name;
    List<String> desc = new ArrayList<String>();
    public room(int x){
        number = x;
    }
    static ArrayList<room> room = new ArrayList<room>();
}