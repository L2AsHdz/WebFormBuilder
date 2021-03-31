package aux.user;

import executor.Executor;
import executor.user.CreateUserRequestExecutor;
import executor.user.DeleteUserRequestExecutor;
import executor.user.ModifyUserRequestExecutor;
import model.solicitudes.Solicitud;

/**
 *
 * @date 20/03/2021
 * @time 19:58:13
 * @author asael
 */
public class UserRequestExecutor {

    private final Executor createUserRE;
    private final Executor modifyUserRE;
    private final Executor deleteUserRE;

    public UserRequestExecutor() {
        createUserRE = new CreateUserRequestExecutor();
        modifyUserRE = new ModifyUserRequestExecutor();
        deleteUserRE = new DeleteUserRequestExecutor();
    }

    public String executeCreateUser(Solicitud s) {
        return createUserRE.execute(s);
    }

    public String executeDeleteUser(Solicitud s) {
        return deleteUserRE.execute(s);
    }

    public String executeModifyUser(Solicitud s) {
        return modifyUserRE.execute(s);
    }
}
