package beacool.entity;

import beacool.entity.base.BasePage;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/8/1.
 */
public class Patient{

    private int sex;
    private String idCard;
    private String name;
    private String birthday;
    private String position;

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Patient(){

    }

    public Patient(int sex, String idCard, String name, String birthday) {
        this.sex = sex;
        this.idCard = idCard;
        this.name = name;
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
