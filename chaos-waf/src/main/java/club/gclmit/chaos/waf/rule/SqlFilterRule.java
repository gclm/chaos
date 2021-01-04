package club.gclmit.chaos.waf.rule;

import club.gclmit.chaos.core.exception.ChaosException;
import club.gclmit.chaos.core.util.StringUtils;

/**
 * SQL过滤
 *
 * @author gclm
 */
public class SqlFilterRule {

    /**
     * SQL注入过滤
     *
     * @param str 待验证的字符串
     * @return 过滤后的内容
     */
    public static String filter(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.contains(keyword)) {
                throw new ChaosException("包含非法字符");
            }
        }
        return str;
    }
}
