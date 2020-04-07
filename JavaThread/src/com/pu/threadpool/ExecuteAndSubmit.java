package com.pu.threadpool;

import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;

/**
 * Description:
 * Created By @Author my on @Date 2020/4/7 16:07
 */
public class ExecuteAndSubmit {
    //execute
    public void execute(Runnable command){
        //没有返回值，无法判断任务是否被线程池执行成功与否
    }

    public Future<?> submit(Runnable task){
        //可以根据返回的Future对象判断任务是否成功
        //利用Future的get()可以获取返回值
        return null;
    }
}
