package BasicStructure;

import java.text.SimpleDateFormat;
import java.util.Date;

//TODO 其实这里主要的就是学习一个  Date和Calendar类 java日期时间操作的相关知识
//p110 实现一个定时器
public class StopWatch {

    private Date currentTime;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

    //构造器，实例化的时候存储当前时间
    public StopWatch() {
        this.currentTime = new Date();
    }

    //获取对象实例化的时刻
    public String getCurrentTime() {
        return dateFormat.format(this.currentTime);
    }

    public long period() {
        //时间相减的毫秒数
        long period = new Date().getTime() - this.currentTime.getTime();
        return period;
    }
}
