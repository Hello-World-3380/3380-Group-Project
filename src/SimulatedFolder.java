import java.util.ArrayList;
import java.util.List;

public class SimulatedFolder {

    public boolean hasCustomIcon;
    public String name;
    public String color;

    public static List<SimulatedFile> contains =  new ArrayList();

    public String toString(){
        return name + " Color: " + color + " Has Custom Icon: " + true;
    }

}
