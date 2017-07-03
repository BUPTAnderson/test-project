package org.training.enums;

/**
 * Created by anderson on 16-6-11.
 */
enum Directions2{
    EAST() {
        @Override
        public void show() {
            System.out.println("此枚举成员为东");
        }

        @Override
        public String getDirections() {
            return "东";
        }
    }, SOUTH() {
        @Override
        public void show() {
            System.out.println("此枚举成员为南");
        }

        @Override
        public String getDirections() {
            return "南";
        }
    }, WEST() {
        @Override
        public void show() {
            System.out.println("此枚举成员为西");
        }

        @Override
        public String getDirections() {
            return "西";
        }
    }, NORTH() {
        @Override
        public void show() {
            System.out.println("此枚举成员为北");
        }

        @Override
        public String getDirections() {
            return "北";
        }
    };
    public abstract void show();
    public abstract String getDirections();
}

public class TestDemo3 {
    public static void main(String[] args) {
        for (Directions2 dir : Directions2.values()) {
            dir.show();
            System.out.println("属性：" + dir.getDirections());
        }
    }
}
