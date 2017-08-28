package beacool.dao;

import beacool.entity.Patient;
import beacool.entity.PatientTemp;
import beacool.entity.base.BasePage;
import beacool.param.PatientTempParam;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/1.
 */
@Repository
public interface PatientTempDao {
    List<PatientTemp> queryPatientList(PatientTempParam patientTempParam);
    long queryPatientListTotal(PatientTempParam patientTempParam);
    Map<String,Object> queryPatientListResult(PatientTempParam patientTempParam);


    //查询是否已存在病人信息
    List<PatientTemp> queryPatientExit(PatientTemp patientTemp);
    //添加病人体温信息
    void addPatientTemp(PatientTemp patientTemp);
    //添加病人信息
    void addPatient(PatientTemp patientTemp);
    //添加病人位置信息
    void addPatientPosition(PatientTemp patientTemp);

    Map<String, Object> addPatientInfo(PatientTemp patientTemp);
}
