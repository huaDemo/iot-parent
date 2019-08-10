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
    private Date createDate;
    private Date updateDate = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
