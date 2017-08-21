package beacool.dao;

import beacool.entity.PatientTemp;
import beacool.entity.base.BasePage;
import beacool.param.PatientTempParam;
import org.springframework.stereotype.Repository;

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
}
