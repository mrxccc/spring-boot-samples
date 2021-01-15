package cn.mrxccc.mybatis.domain;

import javax.persistence.*;

@Table(name = "`student`")
public class Student {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "`sno`")
    private String sno;

    @Column(name = "`sname`")
    private String sname;

    @Column(name = "`ssex`")
    private String ssex;

    @Column(name = "`database`")
    private String database;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return sno
     */
    public String getSno() {
        return sno;
    }

    /**
     * @param sno
     */
    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }

    /**
     * @return sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * @param sname
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * @return ssex
     */
    public String getSsex() {
        return ssex;
    }

    /**
     * @param ssex
     */
    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    /**
     * @return database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database
     */
    public void setDatabase(String database) {
        this.database = database == null ? null : database.trim();
    }
}