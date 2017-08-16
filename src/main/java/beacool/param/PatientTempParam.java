package beacool.param;

import beacool.entity.base.BasePage;

/**
 * Created by Administrator on 2017/8/15.
 */
public class PatientTempParam extends BasePage {
    private int sex;
    private String idCard;
    private String name;
    private String position;
    private int tempDic;
    private int hospitalization;

    public PatientTempParam(){

    }

    public PatientTempParam(int sex, String idCard, String name, String position, int tempDic, int hospitalization) {
        this.sex = sex;
        this.idCard = idCard;
        this.name = name;
        this.position = position;
        this.tempDic = tempDic;
        this.hospitalization = hospitalization;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTempDic() {
        return tempDic;
    }

    public void setTempDic(int tempDic) {
        this.tempDic = tempDic;
    }

    public int getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(int hospitalization) {
        this.hospitalization = hospitalization;
    }

    @Override
    public String toString() {
        return "PatientTempParam{" +
                "sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", tempDic=" + tempDic +
                ", hospitalization=" + hospitalization +
                '}';
    }
}
