package entity;

import java.util.List;

/**
 * @ClassName IPage
 * @Description TODO
 * @Auther hua
 * @Date 2019/5/5 17:25
 * @Version 1.0
 */
public interface IPage<T> {

    public int getPageNo();

    public int getPageSize();

    public int getCount();

    public int getTotalPageNo();

    public List<T> getData();

    public boolean hasNext();

    public boolean hasPrevious();

    public String getMsg();

    public int getCode();

}
