package beacool.entity;

/**
 * Created by Administrator on 2017/8/15.
 */
public class ErrorException {
    private int errorCode = 0;
    private String msg = "请求成功";

    public ErrorException(){

    }
    public ErrorException(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorException{" +
                "errorCode=" + errorCode +
                ", msg='" + msg + '\'' +
                '}';
    }
}
