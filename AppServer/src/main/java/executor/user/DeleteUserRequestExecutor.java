/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor.user;

import aux.user.UserBuilder;
import datos.CRUD;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import model.Usuario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 31/03/2021
 * @time 03:07:11
 * @author asael
 */
public class DeleteUserRequestExecutor extends Executor {

    private final CRUD<Usuario> usuarioDAO;

    public DeleteUserRequestExecutor() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();

        String nombre = s.getParametros().get(0).getValue()
                .replace("\"", "")
                .replaceAll("\\s", "");

        if (usuarioDAO.delete(nombre)) {
            response.append("Usuario ").append(nombre).append(" eliminado");
        } else {
            response.append("No se puede eliminar, usuario no existe");
        }

        return response.toString();
    }

}
