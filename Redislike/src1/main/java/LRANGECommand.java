import java.util.List;

public class LRANGECommand implements Command {
    private List<Object> args;

    @Override
    public void setArgs(List<Object> args) {
        this.args = args;
    }

    @Override
    public void run() {
        DateBase dateBase = DateBase.getInstance();
        String key = new String((byte[]) args.remove(0));
        List<String> list = dateBase.getList(key);
        int start = Integer.valueOf(new String((byte[]) args.remove(0)));
        int end = Integer.valueOf(new String((byte[]) args.remove(0)));
        if (start < 0) {
            start = 0;

            if (end < 0) {
                end = 0;
            }
        } else if (end >= list.size()) {
            end = list.size() - 1;
        }
        for (int i = start; i <= end; i++) {
            System.out.println(list.get(i));
        }
    }
}
