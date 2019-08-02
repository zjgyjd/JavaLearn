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

    }
}
