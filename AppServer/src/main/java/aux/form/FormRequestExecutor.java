package aux.form;

import executor.Executor;
import executor.form.CreateFormRequestExecutor;
import executor.form.DeleteFormRequestExecutor;
import executor.form.ModifyFormRequestExecutor;
import model.solicitudes.Solicitud;

/**
 *
 * @date 21/03/2021
 * @time 11:41:28
 * @author asael
 */
public class FormRequestExecutor {
    
    private final CreateFormRequestExecutor createFormRE;
    private final Executor modifyFormRE;
    private final Executor deleteFormRE;
    
    public FormRequestExecutor() {
        createFormRE = new CreateFormRequestExecutor();
        modifyFormRE = new ModifyFormRequestExecutor();
        deleteFormRE = new DeleteFormRequestExecutor();
    }

    public String executeCreateForm(Solicitud s, String loggedUser) {
        return createFormRE.execute(s, loggedUser);
    }

    public String executeDeleteForm(Solicitud s) {
        return modifyFormRE.execute(s);
    }

    public String executeModifyForm(Solicitud s) {
        return deleteFormRE.execute(s);
    }
}
