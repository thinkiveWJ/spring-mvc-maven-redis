package beacool.entity;

/**
 * Created by Administrator on 2017/8/1.
 */
public class PatientTemp extends Patient{
    private double temp;
    private String position;
    private int hospitalization;

    public double getTemp() {
        return temp;
    }

    @Override
    public String toString() {
        return "PatientTemp{" +
                "temp=" + temp +
                ", position='" + position + '\'' +
                ", hospitalization=" + hospitalization +
                '}';
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    public int getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(int hospitalization) {
        this.hospitalization = hospitalization;
    }



    public PatientTemp() {

    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public PatientTemp(Float temp) {
        this.temp = temp;
    }

    public PatientTemp(int sex, String idCard, String name, String birthday, Float temp) {
        super(sex, idCard, name, birthday);
        this.temp = temp;
    }



}
