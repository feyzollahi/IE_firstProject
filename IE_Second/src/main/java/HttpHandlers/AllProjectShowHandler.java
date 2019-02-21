package HttpHandlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.Arrays;

public class AllProjectShowHandler implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        System.out.println("AllProj");
        String[] parts = httpExchange.getRequestURI().toString().split("/");
        System.out.println(Arrays.deepToString(parts));
    }
}
