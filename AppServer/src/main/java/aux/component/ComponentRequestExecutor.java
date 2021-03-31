package aux.component;

import executor.Executor;
import executor.component.CreateComponentRequestExecutor;
import executor.component.DeleteComponentRequestExecutor;
import executor.component.ModifyComponentRequestExecutor;
import model.solicitudes.Solicitud;

/**
 *
 * @date 26/03/2021
 * @time 00:40:00
 * @author asael
 */
public class ComponentRequestExecutor {
    
    private final Executor createComponentRE;
    private final Executor modifyComponentRE;
    private final Executor deleteComponentRE;

    public ComponentRequestExecutor() {
        createComponentRE = new CreateComponentRequestExecutor();
        modifyComponentRE = new ModifyComponentRequestExecutor();
        deleteComponentRE = new DeleteComponentRequestExecutor();
    }

    public String executeAddComponent(Solicitud s) {
        return createComponentRE.execute(s);
    }

    public String executeDeleteComponent(Solicitud s) {
        return deleteComponentRE.execute(s);
    }
    
    public String executeModifyComponent(Solicitud s) {
        return modifyComponentRE.execute(s);
    }

    
}
