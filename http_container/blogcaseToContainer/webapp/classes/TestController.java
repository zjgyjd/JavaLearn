import com.zjgyjd.controller.Controller;
import com.zjgyjd.Request;
import com.zjgyjd.Response;

public class TestController extends Controller{
    public void doGet(Request request , Response response) throws Exception {
        response.println("<head>");
        response.println("<h1>Hello World</h1>");
        response.println("/<head>");
    }
}