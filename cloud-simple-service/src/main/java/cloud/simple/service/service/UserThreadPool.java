package cloud.simple.service.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserThreadPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserThreadPool.class);

    public static void main(String[] args) {
        push();
    }

    public static void push() {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executor.execute(new MessageThread("熊墩"));
        }


    }


    public void get(String str) {
        if (StringUtils.isEmpty(str)) {
            throw new NullPointerException("不能为空");
        }
    }

    public static class MessageThread implements Runnable {

        private String name;

        private int i;

        public MessageThread() {

        }

        public MessageThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            System.out.println("名称：" + name + "数字：" + i++);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
