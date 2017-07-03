package org.training.annotations;

import org.training.enums.Gender;

/**
 * Created by kongyunlong on 2016/6/11.
 */
@Version(big = 1, small = 0, name = "Tom", c = Integer.class,
        a = @Annotation1, g = Gender.FEMALE,  //不能使用null为属性赋值
        nums = 3, gg = Gender.FEMALE)
public class TestVersion {
}
