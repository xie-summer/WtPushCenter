package com.woting.push.config;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.spiritdata.framework.jsonconf.JsonConfig;
import com.woting.audioSNS.calling.CallingConfig;
import com.woting.audioSNS.mediaflow.MediaflowConfig;

public abstract class ConfigLoadUtils {
    private final static FelEngine fel=new FelEngineImpl();

    public static PushConfig getPushConfig(JsonConfig jc) {
        PushConfig pc=new PushConfig();
        try {
            pc.set_ControlTcpPort((int)fel.eval(jc.getString("pushserver.ctlTcpPort")));
        } catch(Exception e) {}
        try {
            pc.set_DsispatchThreadCount((int)fel.eval(jc.getString("pushserver.dispatchThread")));
        } catch(Exception e) {}
        try {
            pc.set_CleanInterval((int)fel.eval(jc.getString("pushserver.cleanInterval")));
        } catch(Exception e) {}
        return pc;
    }

    public static SocketHandleConfig getSocketHandleConfig(JsonConfig jc) {
        SocketHandleConfig shc=new SocketHandleConfig();
        try {
            shc.set_ExpireTime((int)fel.eval(jc.getString("socketmonitor.expireTime")));
        } catch(Exception e) {}
        try {
            shc.set_MonitorDelay((int)fel.eval(jc.getString("socketmonitor.monitorDelay")));
        } catch(Exception e) {}
        try {
            shc.set_TryDestoryAllCount((int)fel.eval(jc.getString("socketmonitor.tryDestoryAllCount")));
        } catch(Exception e) {}
        try {
            shc.set_BeatDelay((int)fel.eval(jc.getString("socketmonitor.beatDelay")));
        } catch(Exception e) {}
        try {
            shc.set_Err_ContinueCount((int)fel.eval(jc.getString("socketmonitor.errContinueCount")));
        } catch(Exception e) {}
        try {
            shc.set_Err_SumCount((int)fel.eval(jc.getString("socketmonitor.errSumCount")));
        } catch(Exception e) {}
        try {
            shc.set_Recieve_LogPath(jc.getString("socketenviron.recieveLogPath"));
        } catch(Exception e) {}
        try {
            shc.set_Send_LogPath(jc.getString("socketenviron.sendLogPath"));
        } catch(Exception e) {}
        return shc;
    }

    public static CallingConfig getCallingConfig(JsonConfig jc) {
        CallingConfig cc=new CallingConfig();
        try {
            cc.set_DealThreadCount((int)fel.eval(jc.getString("calling.dealThread")));
        } catch(Exception e) {}
        try {
            cc.set_ExpireOnline((long)fel.eval(jc.getString("calling.expireOnline")));
        } catch(Exception e) {}
        try {
            cc.set_ExpireAck((long)fel.eval(jc.getString("calling.expireAck")));
        } catch(Exception e) {}
        try {
            cc.set_ExpireTime((long)fel.eval(jc.getString("calling.expireTime")));
        } catch(Exception e) {}
        return cc;
    }

    public static MediaflowConfig getMediaFlowConfig(JsonConfig jc) {
        MediaflowConfig mfc=new MediaflowConfig();
        try {
            mfc.set_DealThreadCount((int)fel.eval(jc.getString("mediaflow.dealThread")));
        } catch(Exception e) {}
        return mfc;
    }
}