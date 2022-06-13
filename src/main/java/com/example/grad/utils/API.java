package com.example.grad.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.grad.bean.IpcBean;
import com.example.grad.bean.StandardBean;

import java.util.ArrayList;
import java.util.List;

public class API {

    /**
     * 处理通过标准id返回的推荐标准数据
     * @param str
     * @return
     */
    public static List<StandardBean> API1(String str){

        JSONObject jsonObject1 = JSONObject.parseObject(str);
        String response_hits1 = jsonObject1.getString("hits");
        JSONObject jsonObject2 = JSONObject.parseObject(response_hits1);
        JSONArray response_hits2 = jsonObject2.getJSONArray("hits");
        System.out.println("Standard hits!");
        System.out.println(response_hits2);
        List<StandardBean> apiStandardList = new ArrayList<StandardBean>();
        for(int i=0; i<response_hits2.size(); i++){
            StandardBean standardBean = new StandardBean();
            String str1 = response_hits2.getString(i);
            JSONObject jsonObject3 = JSONObject.parseObject(str1);
            // 获取到standard实体
            String str2 = jsonObject3.getString("_source");
            JSONObject jsonObject4 = JSONObject.parseObject(str2);
            standardBean.setId(Integer.parseInt(jsonObject4.getString("ID")));
            standardBean.setStandard_id(jsonObject4.getString("STANDARD_ID"));
            standardBean.setStandard_name_cn(jsonObject4.getString("STANDARD_NAME_CN"));
            standardBean.setStandard_name_en(jsonObject4.getString("STANDARD_NAME_EN"));
            standardBean.setCompetent_department(jsonObject4.getString("COMPETENT_DEPARTMENT"));
            standardBean.setIss(jsonObject4.getString("ISS"));
            standardBean.setRelease_date(jsonObject4.getString("RELEASE_DATE"));
            apiStandardList.add(standardBean);
        }
        return apiStandardList;
    }

    /**
     * 处理通过标准id返回的推荐专利数据
     * @param str
     * @return
     */
    public static List<IpcBean> API2(String str){

        JSONObject jsonObject1 = JSONObject.parseObject(str);
        String response_hits1 = jsonObject1.getString("hits");
        JSONObject jsonObject2 = JSONObject.parseObject(response_hits1);
        JSONArray response_hits2 = jsonObject2.getJSONArray("hits");
        List<IpcBean> apiIpcList = new ArrayList<IpcBean>();
        for(int i=0; i<response_hits2.size(); i++){
            IpcBean ipcBean = new IpcBean();
            String str1 = response_hits2.getString(i);
            JSONObject jsonObject3 = JSONObject.parseObject(str1);
            // 获取到ipc实体
            String str_ipcID = jsonObject3.getString("_id");
            ipcBean.setId(str_ipcID);
            String str2 = jsonObject3.getString("_source");
            JSONObject jsonObject4 = JSONObject.parseObject(str2);
            ipcBean.setPubid(jsonObject4.getString("pubid"));
            ipcBean.setTitle(jsonObject4.getString("title"));
            ipcBean.setInventorList(jsonObject4.getString("inventorList"));
            ipcBean.setPubDate(jsonObject4.getString("pubDate"));
            apiIpcList.add(ipcBean);
        }
        return apiIpcList;
    }

    /**
     * 获取IPC的详细信息
     * @param str
     * @return
     */
    public static IpcBean API3(String str){
        JSONObject jsonObject1 = JSONObject.parseObject(str);
        String response_hits1 = jsonObject1.getString("hits");
        // System.out.println(response_hits1);
        JSONObject jsonObject2 = JSONObject.parseObject(response_hits1);
        JSONArray response_hits2 = jsonObject2.getJSONArray("hits");
        System.out.println("Ipc hits");
        System.out.println(response_hits2);
        IpcBean ipcBean = new IpcBean();
        String str1 = response_hits2.getString(0);
        JSONObject jsonObject3 = JSONObject.parseObject(str1);
        // 获取到ipc实体
        ipcBean.setId(jsonObject3.getString("_id"));
        String str2 = jsonObject3.getString("_source");
        System.out.println(str2);
        // 获取applicationList位置
        JSONObject jsonObject4 = JSONObject.parseObject(str2);
        JSONArray app = jsonObject4.getJSONArray("applicantList");
        String app_1 = app.getString(0);
        JSONObject jsonObject5 = JSONObject.parseObject(app_1);
        ipcBean.setAppApplicationType(jsonObject5.getString("applicantType"));
        ipcBean.setAppApplication(jsonObject5.getString("applicant"));
        // 获取其余位置
        ipcBean.setAppid(jsonObject4.getString("appid"));
        ipcBean.setClaimsCount(jsonObject4.getString("claimsCount"));
        ipcBean.setPubid(jsonObject4.getString("pubid"));
        ipcBean.setPubDate(jsonObject4.getString("pubDate"));
        ipcBean.setAppDate(jsonObject4.getString("appDate"));
        ipcBean.setMainIpc3(jsonObject4.getString("mainIpc3"));
        ipcBean.setClaimsList(jsonObject4.getString("claimsList"));
        ipcBean.setTitle(jsonObject4.getString("title"));
        ipcBean.setAbst(jsonObject4.getString("abst"));
        ipcBean.setInventorList(jsonObject4.getString("inventorList"));
        return ipcBean;

    }

}
