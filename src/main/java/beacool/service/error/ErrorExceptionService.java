package beacool.service.error;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/15.
 */
@Service
public class ErrorExceptionService {
    private int errorCode = 0;
    private String msg = "请求成功";

    public ErrorExceptionService(){

    }
    public ErrorExceptionService(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        switch (errorCode){
            case 1001:
                this.setMsg("token不能为空！");
                break;
            case 1002:
                this.setMsg("token已过期！");
                break;
            case 1003:
                this.setMsg("数据库操作错误！");
                break;
            case 1004:
                this.setMsg("RSA密钥对生成失败！");
                break;
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
