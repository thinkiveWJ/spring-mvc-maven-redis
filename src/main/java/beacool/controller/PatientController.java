package beacool.controller;

import beacool.entity.PatientTemp;
import beacool.param.PatientTempParam;
import beacool.service.PatientTempService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/1.
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
    private Logger logger = Logger.getLogger(PatientController.class);

   @Autowired
    private PatientTempService patientTempService;

    @RequestMapping(value = "findPatientList.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> queryPatientList(PatientTempParam patientTempParam, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charse=UTF-8");
        return patientTempService.queryPatientListResult(patientTempParam);
    }

    @RequestMapping(value = "addPatientInfo.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addPatientInfo(PatientTemp patientTemp, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charse=UTF-8");
        return patientTempService.addPatientInfo(patientTemp);
    }
}
