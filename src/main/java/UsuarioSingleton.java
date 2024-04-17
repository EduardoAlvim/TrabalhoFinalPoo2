public class UsuarioSingleton {
    private static UsuarioSingleton instancia;
    private Usuario usuario;

    private UsuarioSingleton(Usuario usuario) {
        this.usuario = usuario;
    }

    public static UsuarioSingleton getInstance(Usuario usuario) {
        if (instancia == null) {
            instancia = new UsuarioSingleton(usuario);
        }
        return instancia;
    }
}
