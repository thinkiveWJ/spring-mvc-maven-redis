package beacool.service;


import beacool.entity.PatientTemp;
import beacool.param.PatientTempParam;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface PatientTempService {

    /**
     * 查询病人体温以及位置的具体信息
     * @param patientTempParam
     * @return
     */
    public List<PatientTemp> queryPatientList(PatientTempParam patientTempParam);
    /**
     * 查询病人体温以及位置的总条数
     * @param patientTempParam
     * @return
     */
    public long queryPatientListTotal(PatientTempParam patientTempParam);
    /**
     * 查询病人体温以及位置的具体信息以及其总数
     * @param patientTempParam
     * @return
     */
    public Map<String, Object> queryPatientListResult(PatientTempParam patientTempParam);

    /**
     * 添加病人
     * @param patientTemp
     * @return
     */
    public Map<String, Object> addPatientInfo(PatientTemp patientTemp);

}
