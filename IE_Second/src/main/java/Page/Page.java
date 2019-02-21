package Page;


import com.sun.net.httpserver.HttpExchange;

public interface Page {
    public void HandleRequest(HttpExchange httpExchange);
}
