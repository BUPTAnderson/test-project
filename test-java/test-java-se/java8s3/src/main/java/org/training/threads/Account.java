package org.training.threads;

/**
 * Created by kongyunlong on 2016/6/25.
 */
public class Account
{
    private int money = 1000;

    public synchronized void withdraw(int money)
    {
        if (money <= 0) {
            System.out.println("取款金额必须大于0");
            return;
        }
        if (money > this.money) {
            System.out.println("取款金额不能高于当前余额");
            return;
        }
        try {
            Thread.sleep(2000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.money -= money;
        System.out.println("取款成功！取款：" + money);
    }

    public int getMoney()
    {
        return this.money;
    }
}
