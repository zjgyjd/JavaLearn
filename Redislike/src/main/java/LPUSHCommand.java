import java.util.List;

public class LPUSHCommand implements Command {
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
        for (Object e:args
        ) {
            String value = new String((byte[])e);
            list.add(0,value);
        }
//        for (Object o: args     ////测试
//             ) {
//            System.out.println(new String((byte[]) o));
//        }
    }
}
