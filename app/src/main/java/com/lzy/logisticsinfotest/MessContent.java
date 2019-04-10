package com.lzy.logisticsinfotest;

import java.util.List;

/**
 * 作者：lzy on 2018/4/3 09:37
 */

public class MessContent {


    /**
     * LogisticCode : 71541676068
     * ShipperCode : JD
     * Traces : [{"AcceptStation":"货物已交付京东物流","AcceptTime":"2018-01-22 12:46:22"},{"AcceptStation":"货物已到达【北京顺义分拣中心】","AcceptTime":"2018-01-22 12:46:22"},{"AcceptStation":"货物已完成分拣，离开【北京顺义分拣中心】","AcceptTime":"2018-01-22 12:49:36"},{"AcceptStation":"货物已到达【北京陈家营站】","AcceptTime":"2018-01-22 15:31:57"},{"AcceptStation":"货物已分配，等待配送","AcceptTime":"2018-01-22 15:31:58"},{"AcceptStation":"配送员开始配送，请您准备收货，配送员，任少华，手机号，17778170185或15340104787","AcceptTime":"2018-01-22 16:08:34"},{"AcceptStation":"货物已完成配送，感谢您选择京东物流","AcceptTime":"2018-01-22 17:20:13"}]
     * State : 2
     * EBusinessID : 1330422
     * Success : true
     */

    private String LogisticCode;
    private String ShipperCode;
    private String State;
    private String EBusinessID;
    private boolean Success;
    private List<TracesBean> Traces;

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String LogisticCode) {
        this.LogisticCode = LogisticCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String ShipperCode) {
        this.ShipperCode = ShipperCode;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    public List<TracesBean> getTraces() {
        return Traces;
    }

    public void setTraces(List<TracesBean> Traces) {
        this.Traces = Traces;
    }

    public static class TracesBean {
        /**
         * AcceptStation : 货物已交付京东物流
         * AcceptTime : 2018-01-22 12:46:22
         */

        private String AcceptStation;
        private String AcceptTime;

        public String getAcceptStation() {
            return AcceptStation;
        }

        public void setAcceptStation(String AcceptStation) {
            this.AcceptStation = AcceptStation;
        }

        public String getAcceptTime() {
            return AcceptTime;
        }

        public void setAcceptTime(String AcceptTime) {
            this.AcceptTime = AcceptTime;
        }
    }
}
