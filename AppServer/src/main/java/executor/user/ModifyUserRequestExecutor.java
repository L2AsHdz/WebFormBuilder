package executor.user;

import aux.user.UserBuilder;
import datos.CRUD;
import datos.form.FormularioDAO;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import java.util.List;
import model.Formulario;
import model.Usuario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 31/03/2021
 * @time 03:02:00
 * @author asael
 */
public class ModifyUserRequestExecutor extends Executor {
    
    private final CRUD<Usuario> usuarioDAO;
    private final CRUD<Formulario> formDAO;
    private UserBuilder userBuilder;
    
    public ModifyUserRequestExecutor() {
        usuarioDAO = new UsuarioDAO();
        formDAO = new FormularioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();
        
        userBuilder = new UserBuilder(s);

        var u = userBuilder.buildOld();
        if (usuarioDAO.exists(u.getNombre())) {
            var oldUser = usuarioDAO.getObject(u.getNombre());
            var newUser = userBuilder.buildNew();
            newUser.setFechaCreacion(oldUser.getFechaCreacion());
            
            List<Formulario> forms = formDAO.getList();
            forms.forEach(f -> {
                if (f.getUsuarioCreacion().equals(oldUser.getNombre())) {
                    f.setUsuarioCreacion(newUser.getNombre());
                    formDAO.create(f);
                }
            });
            usuarioDAO.delete(oldUser.getNombre());
            usuarioDAO.create(newUser);
            //generar respuesta
            response.append("Se modifico el usuario ")
                    .append(oldUser.getNombre());
        } else {
            response.append("No se puede modificar, el usuario no existe");
        }
        
        return response.toString();
    }
    
}
