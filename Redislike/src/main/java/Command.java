import java.util.List;

public interface Command {
    void setArgs(List<Object> args);

    public void run();
}
