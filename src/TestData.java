import java.util.ArrayList;
import java.util.List;

public class TestData
{
    public static String item1 = "imac";
    public static String item2 = "macbook pro";
    public static String item3 = "microsoft surface";
    public static String item4 = "smart tv";
    public static String item5 = "chromebook";

    public static List<String>  getListOfItems()
    {
        List<String> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

        return list;
    }
}