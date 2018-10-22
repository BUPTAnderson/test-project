package org.training.jvm;

import java.util.ArrayList;

/**
 * Created by anderson on 18-3-4.
 *
 * VM options: -Xmx32m -Xms32m
 * java.lang.StackOverflowError
 *
 *
 *
 *
 *
 * //常见配置汇总
 //堆设置
 -Xms:初始堆大小
 -Xmx:最大堆大小
 -XX:NewSize=n:设置年轻代大小
 -XX:NewRatio=n:设置年轻代和年老代的比值.如:为3,表示年轻代与年老代比值为1:3,年轻代占整个年轻代年老代和的1/4
 -XX:SurvivorRatio=n:年轻代中Eden区与两个Survivor区的比值.注意Survivor区有两个.如:3,表示Eden:Survivor=3:2,一个Survivor区占整个年轻代的1/5
 -XX:MaxPermSize=n:设置持久代大小
 //收集器设置
 -XX:+UseSerialGC:设置串行收集器
 -XX:+UseParallelGC:设置并行收集器
 -XX:+UseParalledlOldGC:设置并行年老代收集器
 -XX:+UseConcMarkSweepGC:设置并发收集器
 //垃圾回收统计信息
 -XX:+PrintGC
 -XX:+PrintGCDetails
 -XX:+PrintGCTimeStamps
 -Xloggc:filename
 //并行收集器设置
 -XX:ParallelGCThreads=n:设置并行收集器收集时使用的CPU数.并行收集//线程数.
 -XX:MaxGCPauseMillis=n:设置并行收集最大暂停时间
 -XX:GCTimeRatio=n:设置垃圾回收时间占程序运行时间的百分比.公式为1/(1+n)
 //并发收集器设置
 -XX:+CMSIncrementalMode:设置为增量模式.适用于单CPU情况.
 -XX:ParallelGCThreads=n:设置并发收集器年轻代收集方式为并行收集时,使用的CPU数.并行收集线程数.

 -verbose:gc 表示输出虚拟机中GC的详细情况.
 ------------- hadoop namenode --------------------------
 NN_JVM_OPTS="$NN_JVM_OPTS -Xmn20g"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:SurvivorRatio=6"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:-UseAdaptiveSizePolicy"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:+UseConcMarkSweepGC"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:ParallelGCThreads=24"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:ConcGCThreads=5"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:+UseCMSInitiatingOccupancyOnly"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:MaxTenuringThreshold=20"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:CMSInitiatingOccupancyFraction=70"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:+PrintGCDetails"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:+PrintGCDateStamps"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:+HeapDumpOnOutOfMemoryError"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:ErrorFile=/data1/hadoop/logs/hadoop-hadoop-namenode-hadoop001-err.log"
 NN_JVM_OPTS="$NN_JVM_OPTS -XX:HeapDumpPath=/data1/hadoop/logs/hadoop-hadoop-namenode-hadoop001-heap-dump.log"
 NN_JVM_OPTS="$NN_JVM_OPTS -Xloggc:/data1/hadoop/logs/nn_gc_${time_suffix}"
 NN_JVM_OPTS="$NN_JVM_OPTS -Dsun.net.inetaddr.ttl=1800"

 export HADOOP_NAMENODE_OPTS="-Xms190G -Xmx190G $NN_JVM_OPTS -Dcom.sun.management.jmxremote -Dhadoop.security.logger=${HADOOP_SECURITY_LOGGER:-INFO,RFAS} -Dhdfs.audit.logger=${HDFS_AUDIT_LOGGER:-INFO,NullAppender} $HADOOP_NAMENODE_OPTS"
 -----------------kafka_2.10-0.8.2.1 ------------------
 -Xmx1G
 -Xms1G
 -XX:+UseParNewGC
 -XX:+UseConcMarkSweepGC
 -XX:+CMSClassUnloadingEnabled
 -XX:+CMSScavengeBeforeRemark
 -XX:+DisableExplicitGC
 -Djava.awt.headless=true
 -Xloggc:/export/App/kafka_2.10-0.8.2.1/bin/../logs/kafkaServer-gc.log
 -verbose:gc
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps
 -XX:+PrintGCTimeStamps
 -Dcom.sun.management.jmxremote
 -Dcom.sun.management.jmxremote.authenticate=false
 -Dcom.sun.management.jmxremote.ssl=false
 -Dcom.sun.management.jmxremote.port=9999
 -Dkafka.logs.dir=/export/App/kafka_2.10-0.8.2.1/bin/../logs
 -Dlog4j.configuration=file:bin/../config/log4j.properties

 -----------------kafka_2.10-0.8.2.1 ------------------
 -Xmx1G
 -Xms1G
 -XX:+UseG1GC
 -XX:MaxGCPauseMillis=20
 -XX:InitiatingHeapOccupancyPercent=35
 -XX:+DisableExplicitGC
 -Djava.awt.headless=true
 -Xloggc:/export/App/kafka_2.11-0.10.1.1/bin/../logs/kafkaServer-gc.log
 -verbose:gc
 -XX:+PrintGCDetails
 -XX:+PrintGCDateStamps
 -XX:+PrintGCTimeStamps
 -Dcom.sun.management.jmxremote
 -Dcom.sun.management.jmxremote.authenticate=false
 -Dcom.sun.management.jmxremote.ssl=false
 -Dcom.sun.management.jmxremote.port=9999
 -Dkafka.logs.dir=/export/App/kafka_2.11-0.10.1.1/bin/../logs
 -Dlog4j.configuration=file:bin/../config/log4j.properties
 -----------------es jvm ------------------
 使用ParNew+ConcurrentMarkSweep
 关于CMS， 参考：http://ifeve.com/useful-jvm-flags-part-7-cms-collector/
 -----------------es 5.6.4 jvm ------------------

 "jvm" : {
 "pid" : 3649,
 "version" : "1.8.0_151",
 "vm_name" : "Java HotSpot(TM) 64-Bit Server VM",
 "vm_version" : "25.151-b12",
 "vm_vendor" : "Oracle Corporation",
 "start_time_in_millis" : 1514253012224,
 "mem" : {
 "heap_init_in_bytes" : 34359738368,
 "heap_max_in_bytes" : 34159132672,
 "non_heap_init_in_bytes" : 2555904,
 "non_heap_max_in_bytes" : 0,
 "direct_max_in_bytes" : 34159132672
 },
 "gc_collectors" : [
 "ParNew",
 "ConcurrentMarkSweep"
 ],
 "memory_pools" : [
 "Code Cache",
 "Metaspace",
 "Par Eden Space",
 "Par Survivor Space",
 "CMS Old Gen"
 ],
 "using_compressed_ordinary_object_pointers" : "false",
 "input_arguments" : [
 "-Xms32g",
 "-Xmx32g",
 "-XX:+UseConcMarkSweepGC",
 "-XX:CMSInitiatingOccupancyFraction=75",
 "-XX:+UseCMSInitiatingOccupancyOnly",
 "-XX:+AlwaysPreTouch",
 "-Xss1m",
 "-Djava.awt.headless=true",
 "-Dfile.encoding=UTF-8",
 "-Djna.nosys=true",
 "-Djdk.io.permissionsUseCanonicalPath=true",
 "-Dio.netty.noUnsafe=true",
 "-Dio.netty.noKeySetOptimization=true",
 "-Dio.netty.recycler.maxCapacityPerThread=0",
 "-Dlog4j.shutdownHookEnabled=false",
 "-Dlog4j2.disable.jmx=true",
 "-Dlog4j.skipJansi=true",
 "-XX:+HeapDumpOnOutOfMemoryError",
 "-Des.path.home=/export/App/elasticsearch-5.6.4-0"
 ]
 }
 */
public class MyTest
{
    public void testHeap() {
        for (;; ) {
            ArrayList list = new ArrayList(2000);
        }
    }
    int num = 1;
    public void testStack() {
        num++;
        this.testStack();
    }

    public static void main(String[] args) {
        MyTest t  = new MyTest();
//        t.testHeap();
        t.testStack();
    }
}
