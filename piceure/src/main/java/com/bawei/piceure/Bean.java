package com.bawei.piceure;

/*
 *@Auther:陈浩
 *@Date: 2019/7/6
 *@Time:15:13
 *@Description:${DESCRIPTION}
 * */public class Bean
{
    /**
     * headPath : http://172.17.8.100/images/small/head_pic/2019-07-06/20190706151059.jpg
     * message : 上传成功
     * status : 0000
     */

    private String headPath;
    private String message;
    private String status;

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
