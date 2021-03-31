package executor.user;

import executor.Executor;
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
    private final Executor loginRE;

    public UserRequestExecutor() {
        createUserRE = new CreateUserRequestExecutor();
        modifyUserRE = new ModifyUserRequestExecutor();
        deleteUserRE = new DeleteUserRequestExecutor();
        loginRE = new LoginRequestExecutor();
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
