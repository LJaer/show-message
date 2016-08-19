package cn.zk.ssm.po;

public class SecondCategory {
    private Integer id;

    private String name;

    private Integer firstcategoryid;

    private Integer img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getFirstcategoryid() {
        return firstcategoryid;
    }

    public void setFirstcategoryid(Integer firstcategoryid) {
        this.firstcategoryid = firstcategoryid;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}