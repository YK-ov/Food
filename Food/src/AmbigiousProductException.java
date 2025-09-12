import java.util.Arrays;
import java.util.List;

public class AmbigiousProductException extends RuntimeException {
    private List<String> list;

    public AmbigiousProductException(List<String> list) {
        super("Ambigious products found: ");
        this.list = list;
    }

    @Override
    public void printStackTrace() {
       super.printStackTrace();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
