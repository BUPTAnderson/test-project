package org.training.concurrent2.chapter11;

public class ExecutionTask implements Runnable {
    private QueryFromDBAction queryAction = new QueryFromDBAction();
    private QueryFromHttpAction httpAction = new QueryFromHttpAction();
    @Override
    public void run() {
        final Context context = ActionContext.getActionContext().getContext();
        queryAction.execute();
        System.out.println("The name query successfully");
        httpAction.execute();
        System.out.println("The card id query successfully");
        System.out.println("The name is " + context.getName() + " and card id " + context.getCardId());
    }
}
