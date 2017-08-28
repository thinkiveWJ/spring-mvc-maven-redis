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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        logger.error("【findPatientList.do】############################入参："+patientTempParam);
        ErrorExceptionService errorExceptionService = new ErrorExceptionService();
        Map<String, Object> map = new HashedMap();
        int pageNum = patientTempParam.getPageNum();
        int pageSize = patientTempParam.getPageSize();
        pageSize = pageSize > 0 ? pageSize : patientTempParam.getPageSizeDefault();
        pageNum = pageNum > 0 ? pageNum : 1;
        long start = (pageNum - 1) * pageSize;
        patientTempParam.setStart(start);
        List<PatientTemp> patientTemps = new ArrayList<PatientTemp>();
        long total = 0L;
        long totalPage = 0L;
        try {
            patientTemps = queryPatientList(patientTempParam);
            total = queryPatientListTotal(patientTempParam);
        }catch (Exception e){
            logger.error("【findPatientList.do】========异常信息:"+e);
            errorExceptionService.setErrorCode(1003);
        }finally {
            int index = (int)total%pageSize;
            totalPage = total/pageSize;
            totalPage = index == 0 ? totalPage : totalPage+1;
            map.put("list", patientTemps);
            map.put("total", total);
            map.put("totalPages", totalPage);
            map.put("errorCode", errorExceptionService.getErrorCode());
            map.put("message", errorExceptionService.getMsg());
            logger.error("【findPatientList.do】###########################出参："+ map);
            return map;
        }
    }

    /**
     * 添加病人
     * @param patientTemp
     * @return
     */
    @Override
    public Map<String, Object> addPatientInfo(PatientTemp patientTemp){
        logger.error("【addPatientTemp.do】############################入参："+patientTemp);
        Map<String, Object> map = new HashedMap();

        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String now = dateFormat.format( date );
        patientTemp.setUpdateTime(now);

        String idCard = patientTemp.getIdCard();
        String name = patientTemp.getName();
        String position = patientTemp.getPosition();
        double temp = patientTemp.getTemp();
        patientTemp.setHospitalization(1);//默认住院

        String pattern = "^(\\d{14}|\\d{17})([0-9]|X)$";
        if(!idCard.matches(pattern)){
            map.put("errorCode", -1);
            map.put("msg", "身份证号码不正确！");
            return map;
        }
        String birthday;
        if(idCard.length() == 15){
            birthday = idCard.substring(6, 12);
        }else{
            birthday = idCard.substring(8, 14);
        }
        if(name == null || name.isEmpty()){
            map.put("errorCode", -1);
            map.put("msg", "姓名不能为空！");
            return map;
        }
        if(position == null || position.isEmpty()){
            map.put("errorCode", -1);
            map.put("msg", "位置不能为空！");
            return map;
        }
        if(temp == 0){
            map.put("errorCode", -1);
            map.put("msg", "温度不能为空！");
            return map;
        }

        //查询病人信息是否存在
        List<PatientTemp> list = patientTempDao.queryPatientExit(patientTemp);
        if(list.size() > 0){
            map.put("errorCode", -1);
            map.put("msg", "病人信息已存在");
            logger.error("【addPatientTemp.do】###########################出参："+ map);
            return map;
        }
//        插入病人信息
        patientTempDao.addPatientTemp(patientTemp);
        patientTempDao.addPatient(patientTemp);
        patientTempDao.addPatientPosition(patientTemp);
        return map;
    }
}


