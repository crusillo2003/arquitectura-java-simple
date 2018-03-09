package mx.rafex.blog.back.daos.sql.mapers.usuarios;

interface UsuarioConsultas {

    String SELECT_USUARIOS = "<script>SELECT * FROM ejemplo_java_1.Usuarios</script>";

    String INSERT_USUARIO = "<script>INSERT INTO ejemplo_java_1.Usuarios (alias,correo,contrasenya<if test=\"acceso != null\">,acceso</if><if test=\"modificacion != null\">,modificacion</if>) VALUES(#{alias,jdbcType=VARCHAR},#{correo,jdbcType=VARCHAR},PASSWORD(#{contrasenya,jdbcType=VARCHAR})<if test=\"acceso != null\">,#{acceso,jdbcType=TIMESTAMP}</if><if test=\"modificacion != null\">,#{modificacion,jdbcType=TIMESTAMP}</if>)</script>";

    String UPDATE_USUARIO = "<script>UPDATE ejemplo_java_1.Usuarios <set><if test=\"alias != null\">alias=#{alias,jdbcType=VARCHAR},</if><if test=\"correo != null\">correo=#{correo,jdbcType=VARCHAR},</if><if test=\"contrasenya != null\">contrasenya=#{contrasenya,jdbcType=VARCHAR},</if><if test=\"acceso != null\">acceso=#{acceso,jdbcType=TIMESTAMP},</if><if test=\"modificacion != null\">modificacion=#{modificacion,jdbcType=TIMESTAMP}</if></set>  where id=#{id,jdbcType=INTEGER}</script>";

    String DELETE_USUARIO = "<script>DELETE FROM ejemplo_java_1.Usuarios  <where><if test=\"id != null\">id=#{id,jdbcType=INTEGER}</if><if test=\"alias != null\"> AND alias=#{alias,jdbcType=VARCHAR}</if><if test=\"correo != null\"> AND correo=#{correo,jdbcType=VARCHAR}</if></where></script>";

}
