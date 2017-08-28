package org.training.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anderson on 16-9-27.
 */
public class TestGeneric2 {
    public static void main(String[] args) {
        List<? extends Season> seasonList = new LinkedList<>();
//        seasonList.add(new Spring());
        List<Spring> springs = new ArrayList<Spring>();
        springs.add(new Spring());
        seasonList = springs;
        Season spring = seasonList.get(0);
        System.out.println(spring);
    }
}

class Season{
}

class Spring extends Season{
    @Override
    public String toString() {
        return "spring";
    }
}

class Summer extends Season{
    @Override
    public String toString() {
        return "Summer";
    }
}