package org.training;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anderson on 17-8-3.
 */
public class TestMatcher
{
    public static void main(String[] args)
    {
        // 要验证的字符串
        String str = "xdata.jd.instance.name";
//        str = "xdata.jd.instance.owner.name";
        // 邮箱验证规则
//        String regEx = "^(xdata.*|spark.*|instance*)";
        String regEx = "hive\\.jd\\..*|spark\\.jd\\..*|xdata\\.jd\\..*";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        System.out.println(rs);

        Map<String, String> conf = new HashMap<>();
        conf.put("hive.jd.instance.name", "hello");
        conf.put("hive.jd.instance.owner.name", "hadoop");
        String instanceName = conf.get("hive.jd.instance.name") == null ? "default" : conf.get("hive.jd.instance.name");
        String instanceOwnerName = conf.get("hive.jd.instance.owner.name") == null ? "datajingdo_M" : conf.get("hive.jd.instance.owner.name");
        System.out.println(instanceName);
        System.out.println(instanceOwnerName);
//        PrincipalType instanceOwnerType = conf.get("instanceOwnerName") == null ? PrincipalType.USER : PrincipalType.valueOf(conf.get("instanceOwnerName"));
    }
}
