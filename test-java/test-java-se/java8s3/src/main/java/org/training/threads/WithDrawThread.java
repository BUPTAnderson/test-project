package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/25.
 */
public class WithDrawThread implements Runnable{
    private  Account account;

    public WithDrawThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(300);
    }
}
