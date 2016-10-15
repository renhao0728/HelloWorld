package com.example.citru.helloworld.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by citrus on 2016/8/14.
 */
public class Json2Entity implements Serializable {


    public List<Double> queryLocation;
    /**
     * type : doorPlate
     * status : 0
     * name :
     * admCode :
     * admName :
     * nearestPoint : []
     * distance : -1
     */

    public List<AddrListBean> addrList;



    public static class AddrListBean {
        public String type;
        public int status;
        public String name;
        public String admCode;
        public String admName;
        public int distance;
        public List<?> nearestPoint;


    }
}
