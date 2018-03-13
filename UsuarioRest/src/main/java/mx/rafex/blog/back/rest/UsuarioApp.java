package mx.rafex.blog.back.rest;

import static spark.Spark.after;
import static spark.Spark.before;
import static spark.Spark.get;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mx.rafex.blog.back.dtos.rest.ResultResponse;
import mx.rafex.blog.back.rest.usuarios.IUsuarioRest;
import spark.Request;
import spark.Response;
import spark.servlet.SparkApplication;

public class UsuarioApp implements SparkApplication {

    private static final Logger LOG = LogManager.getLogger(UsuarioApp.class);

    private final AbstractApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");

    @Override
    public void init() {
        final IUsuarioRest usuarioRest = (IUsuarioRest) context.getBean("usuarioRest");

        beforeServer();
        get("/hello", (request, response) -> new ResultResponse.Builder().code(200)
                .message("Works!! " + UUID.randomUUID().toString()).build());

        usuarioRest.routers();

        afterServer();

    }

    @Override
    public void destroy() {
        context.close();
        context.registerShutdownHook();
    }

    private void beforeServer() {
        before((request, response) -> {
            if (LOG.isInfoEnabled()) {
                LOG.info(requestInfoToString(request));
            }
        });
    }

    private void afterServer() {
        after((request, response) -> {
            response.header("Content-Encoding", "gzip");
            if (LOG.isInfoEnabled()) {
                LOG.info(responseInfoToString(response));
            }
        });
    }

    private String responseInfoToString(final Response response) {
        final StringBuilder sb = new StringBuilder();
        sb.append("RESPONSE [");
        sb.append("\n");
        sb.append("\n");
        // sb.append("Headers: " + response.);
        sb.append("\n");
        sb.append("Status: " + response.status());
        sb.append("\n");
        sb.append("Body. " + response.body());
        sb.append("\n");
        sb.append("]");
        return sb.toString();
    }

    private String requestInfoToString(final Request request) {

        final UUID uuid = UUID.randomUUID();
        final StringBuilder sb = new StringBuilder();
        sb.append("REQUEST [");
        sb.append("\n");
        sb.append("UUID: " + uuid.toString());
        sb.append("\n");
        sb.append("Headers: " + request.headers());
        sb.append("Method: " + request.requestMethod());
        sb.append("\n");
        sb.append("URL: " + request.url());
        sb.append("\n");
        sb.append("Body. " + request.body());
        sb.append("\n");
        sb.append("]");
        return sb.toString();
    }

}
