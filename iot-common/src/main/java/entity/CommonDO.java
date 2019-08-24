package entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName CommonDO
 * @Description TODO
 * @Auther hua
 * @Date 2019/8/2 20:57
 * @Version 1.0
 */
public class CommonDO implements Serializable {

    private Long id;
    private Date createTime;
    private Date updateTime = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
