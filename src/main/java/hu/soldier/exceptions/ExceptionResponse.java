package hu.soldier.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionResponse {
    private String time;
    private String msg;
    private String details;

    public ExceptionResponse(Date time, String msg, String details) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        this.time = format.format(time);
        this.msg = msg;
        this.details = details;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
