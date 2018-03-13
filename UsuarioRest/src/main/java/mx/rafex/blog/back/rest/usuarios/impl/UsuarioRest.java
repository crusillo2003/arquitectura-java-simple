package mx.rafex.blog.back.rest.usuarios.impl;

import static mx.rafex.blog.back.dtos.base.Constantes.CONTENT_TYPE;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import mx.rafex.blog.back.rest.usuarios.IUsuarioRest;

@Component("usuarioRest")
public class UsuarioRest implements IUsuarioRest {

    private static final Logger LOG = LogManager.getLogger(UsuarioRest.class);

    @Override
    public void routers() {

        path("/api", () -> {
            path("/v1", () -> {
                get("/usuario/works", CONTENT_TYPE, (request, response) -> "funcionando...!!!");
                post("/usuario", CONTENT_TYPE, (request, response) -> "en contruccion");
                post("/usuario/validacion", CONTENT_TYPE, (request, response) -> "en contruccion");
                post("/usuario/:document/authentication", CONTENT_TYPE, (request, response) -> "en contruccion");
                put("/usuario", CONTENT_TYPE, (request, response) -> "en contruccion");
            });
        });

    }

}
