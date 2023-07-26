package bitlab.springtask;

import bitlab.springtask.models.Item;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBManager {
    private static Long id=6L;
    @Getter
    private  static List<Item> items = new ArrayList<>();

    static{
        items.add(new Item(1L,"Iphone 11", "256gb","phone", 1000.0));
        items.add(new Item(2L,"Iphone 12", "512gb","phone", 2000.0));
        items.add(new Item(3L,"Iphone 13", "256gb","phone", 3000.0));
        items.add(new Item(4L,"Iphone 14", "512gb","phone", 4000.0));
        items.add(new Item(5L,"Iphone 15", "1024gb","phone", 5000.0));
    }
    public static void addItem(Item item){
    item.setId(id);
    id++;
    items.add(item);
    }
    public static Item getItemById(Long id){
        return items.stream()
                .filter(item -> Objects.equals(item.getId(),id))
                .findFirst()
                .orElse(null);
    }
    public static void deleteItem(Long id){
        items.removeIf(item -> Objects.equals(item.getId(),id));
    }
}
