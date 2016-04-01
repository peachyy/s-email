package com.upsoft.email.web.support;

import java.io.Serializable;

/**
 * @author xsTao
 * @date 2016/2/2.
 * @see
 * @since 1.0
 */
public class Result<T> implements Serializable {
        private boolean success;// 是否成功
        private String msg;// 消息
        private T data;// 返回结果

        public Result(boolean success, String msg) {
            super();
            this.success = success;
            this.msg = msg;
        }

        public Result(boolean success, String msg, T data) {
            super();
            this.success = success;
            this.msg = msg;
            this.data = data;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
}
