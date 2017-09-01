package org.training.stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/**
 * Created by anderson on 17-8-29.
 */
public class StatDemo1
{
    public static void main(String[] args)
    {
        double total = Person.persons().stream().collect(Collectors.summingDouble(Person::getIncome));
        System.out.println(total);

        DoubleSummaryStatistics incomeStats = Person.persons().stream().collect(Collectors.summarizingDouble(Person::getIncome));
        System.out.println("average:" + incomeStats.getAverage() + ", count:" + incomeStats.getCount()
                + ", max:" + incomeStats.getMax() + ", min:" + incomeStats.getMin() + ", sum:" + incomeStats.getSum());
    }
}
