package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName CommonPage
 * @Description TODO
 * @Auther hua
 * @Date 2019/5/5 17:26
 * @Version 1.0
 */
public class CommonPage<T> implements IPage<T>, Serializable {

    private List<T> items;

    private int pageNo;

    private int pageSize;

    private int count;

    public CommonPage(List<T> items, int pageNo, int pageSize, int count) {
        this.items = items;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
    }

    public int getPageNo() {
        return 0;
    }

    public int getPageSize() {
        return 0;
    }

    public int getCount() {
        return 0;
    }

    public int getTotalPageNo() {
        return 0;
    }

    public List<T> getData() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public String getMsg() {
        return null;
    }

    public int getCode() {
        return 0;
    }
}
