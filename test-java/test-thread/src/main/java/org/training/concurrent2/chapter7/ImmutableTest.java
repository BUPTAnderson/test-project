package org.training.concurrent2.chapter7;

import java.util.Collections;
import java.util.List;

public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> lit;

    public ImmutableTest(int age, String name, List<String> lit) {
        this.age = age;
        this.name = name;
        this.lit = lit;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getLit() {
        return Collections.unmodifiableList(lit);
    }
}
