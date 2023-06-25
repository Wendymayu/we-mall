package org.wendy.mall.common;

import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/6/24 10:17
 * @Version 1.0
 */
@Data
public class CommonPage<T> {
    /**
     * 总数
     */
    private long total;

    /**
     * 分页数据
     */
    private List<T> list;

    public CommonPage(long total, List<T> list) {
        this.total = total;
        this.list = list;
    }

    public static <T> CommonPage<T> data(long total, List<T> list) {
        return new CommonPage<T>(total, list);
    }
}
