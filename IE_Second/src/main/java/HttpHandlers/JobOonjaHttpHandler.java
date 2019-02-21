package HttpHandlers;

import Page.Page;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

public class JobOonjaHttpHandler implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(httpExchange.getRequestURI().getPath(), "/");
        System.out.println(httpExchange.getRequestURI().getPath());
        String context = tokenizer.nextToken();

        if(tokenizer.hasMoreTokens()){
            if(context.equals("project"))
                new SpecifiedProjectShowHandler().handle(httpExchange);
            else if(context.equals("user")){
                new SpecifiedUserShowHandler().handle(httpExchange);
            }
        }
        else{
            if(context.equals("project")){
                new AllProjectShowHandler().handle(httpExchange);
            }
        }
        System.out.println("abstract");
    }
}
