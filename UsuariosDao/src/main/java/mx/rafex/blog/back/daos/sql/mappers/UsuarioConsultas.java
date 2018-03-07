package mx.rafex.blog.back.daos.sql.mappers;

interface UsuarioConsultas {

    String SELECT_USUARIOS = "<script>SELECT * FROM ejemplo_java_1.Usuarios</script>";

    String INSERT_USUARIO = "<script>\n" + "INSERT INTO ejemplo_java_1.Usuarios \n" + "(alias,\n" + "correo,\n"
            + "contrasenya\n" + "<if test=\"acceso != null\">\n" + "    ,acceso\n" + "</if>\n"
            + "<if test=\"modificacion != null\">\n" + "    ,modificacion\n" + "</if>\n" + ") \n"
            + "VALUES(#{alias,jdbcType=VARCHAR},\n" + "#{correo,jdbcType=VARCHAR},\n"
            + "PASSWORD(#{contrasenya,jdbcType=VARCHAR})\n" + "<if test=\"acceso != null\">\n"
            + "    ,#{acceso,jdbcType=DATE}\n" + "</if>\n" + "<if test=\"modificacion != null\">\n"
            + "    ,#{modificacion,jdbcType=DATE}\n" + "</if>\n" + ")\n" + "</script>";

}
