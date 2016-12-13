package com.woting.push;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.spiritdata.framework.jsonconf.JsonConfig;
import com.woting.audioSNS.calling.CallingConfig;
import com.woting.audioSNS.mediaflow.MediaflowConfig;
import com.woting.audioSNS.notify.NotifyMessageConfig;
import com.woting.audioSNS.sync.SyncMessageConfig;
import com.woting.push.core.SocketHandleConfig;
import com.woting.audioSNS.intercom.IntercomConfig;

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
            shc.set_LogPath(jc.getString("socketenviron.logPath"));
        } catch(Exception e) {}
        return shc;
    }

    public static IntercomConfig getIntercomConfig(JsonConfig jc) {
        IntercomConfig ic=new IntercomConfig();
        try {
            ic.set_DealThreadCount((int)fel.eval(jc.getString("intercom.dealThread")));
        } catch(Exception e) {}
        try {
            ic.set_ExpireTime((int)fel.eval(jc.getString("intercom.expireTime")));
        } catch(Exception e) {}
        return ic;
    }

    public static CallingConfig getCallingConfig(JsonConfig jc) {
        CallingConfig cc=new CallingConfig();
        try {
            cc.set_DealThreadCount((int)fel.eval(jc.getString("calling.dealThread")));
        } catch(Exception e) {}
        try {
            cc.set_ExpireOnline((int)fel.eval(jc.getString("calling.expireOnline")));
        } catch(Exception e) {}
        try {
            cc.set_ExpireAck((int)fel.eval(jc.getString("calling.expireAck")));
        } catch(Exception e) {e.printStackTrace();}
        try {
            cc.set_ExpireTime((int)fel.eval(jc.getString("calling.expireTime")));
        } catch(Exception e) {}
        try {
            cc.set_CleanInternal((int)fel.eval(jc.getString("calling.clean.cleanInternal")));
        } catch(Exception e) {}
        try {
            cc.set_CleanDataExpire((int)fel.eval(jc.getString("calling.clean.dataExpire")));
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

    public static NotifyMessageConfig getNotifyMessageConfig(JsonConfig jc) {
        NotifyMessageConfig nmc=new NotifyMessageConfig();
        try {
            nmc.set_DealThreadCount((int)fel.eval(jc.getString("notify.dealThread")));
        } catch(Exception e) {}
        return nmc;
    }

    public static SyncMessageConfig getSyncMessageConfig(JsonConfig jc) {
        SyncMessageConfig smc=new SyncMessageConfig();
        try {
            smc.set_DealThreadCount((int)fel.eval(jc.getString("notify.dealThread")));
        } catch(Exception e) {}
        return smc;
    }
}