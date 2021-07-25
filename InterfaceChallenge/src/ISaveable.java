import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    void readValues(List<String>savedValues);
    List<String> writeValues();
}
