package org.training.enums;

/**
 * Created by anderson on 16-6-11.
 */
interface EnumInterface
{
    void show();
}

enum Direction
        implements EnumInterface
{
    EAST(), SOUTH, WEST, NORTH;    //写成 EAST(),SOUTH(),WEST(),NORTH(); 也可以

    //可以统一实现一个接口
    @Override
    public void show()
    {
    }
}

enum Directions
        implements EnumInterface
{
    //各自实现抽象方法
    EAST() {    //EAST或者EAST()都可以

        @Override
        public void show()
        {
        }
    }, SOUTH {
    @Override
    public void show()
    {
    }
}, WEST {
    @Override
    public void show()
    {
    }
}, NORTH {
    @Override
    public void show()
    {
    }
}
}

public class TestDemo2
{
}
