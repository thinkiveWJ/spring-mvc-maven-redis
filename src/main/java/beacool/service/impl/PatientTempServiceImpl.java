package beacool.service.impl;

import beacool.dao.PatientTempDao;
import beacool.entity.PatientTemp;
import beacool.param.PatientTempParam;
import beacool.service.error.ErrorExceptionService;
import beacool.service.PatientTempService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/1.
 */
@Service
public class PatientTempServiceImpl implements PatientTempService {
    private Logger logger = Logger.getLogger(PatientTempServiceImpl.class);


    @Autowired
    private PatientTempDao patientTempDao;

    /**
     * 查询病人体温以及位置的具体信息
     * @param patientTempParam
     * @return
     */
    public List<PatientTemp> queryPatientList(PatientTempParam patientTempParam){
        List<PatientTemp> patientTemps = patientTempDao.queryPatientList(patientTempParam);
        return patientTemps;
    }
    /**
     * 查询病人体温以及位置的总数
     * @param patientTempParam
     * @return
     */
    public long queryPatientListTotal(PatientTempParam patientTempParam){
        long total = patientTempDao.queryPatientListTotal(patientTempParam);
        return total;
    }
    /**
     * 查询病人体温以及位置的具体信息以及其总数
     * @param patientTempParam
     * @return
     */
    public Map<String, Object> queryPatientListResult(PatientTempParam patientTempParam){
        ErrorExceptionService errorExceptionService = new ErrorExceptionService();
        Map<String, Object> map = new HashedMap();
        int pageNum = patientTempParam.getPageNum();
        int pageSize = patientTempParam.getPageSize();
        pageSize = pageSize > 0 ? pageSize : patientTempParam.getPageSizeDefault();
        pageNum = pageNum > 0 ? pageNum : 1;
        long start = (pageNum - 1) * pageSize;
        patientTempParam.setStart(start);
        logger.error("【findPatientList.do params】############################入参信息:"+patientTempParam);
        List<PatientTemp> patientTemps = new ArrayList<PatientTemp>();
        long total = 0L;
        long totalPage = 0L;
        try {
            patientTemps = queryPatientList(patientTempParam);
            total = queryPatientListTotal(patientTempParam);
        }catch (Exception e){
            logger.error("【Exception】========异常信息:"+e);
            errorExceptionService.setErrorCode(1003);
        }
        int index = (int)total%pageSize;
        totalPage = total/pageSize;
        totalPage = index == 0 ? totalPage : totalPage+1;
        map.put("list", patientTemps);
        map.put("total", total);
        map.put("totalPages", totalPage);
        map.put("errorCode", errorExceptionService.getErrorCode());
        map.put("message", errorExceptionService.getMsg());
        logger.error("【result】###########################返回数据："+ map);
        return map;
    }
}
