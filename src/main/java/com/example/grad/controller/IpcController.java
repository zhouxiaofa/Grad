package com.example.grad.controller;

import com.example.grad.bean.IpcBean;
import com.example.grad.utils.API;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * @author zxf
 */
@RequestMapping(value = "/IPC")
@Controller
public class IpcController {

    /**
     * 获取IPC数据详细信息
     * @param id
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/detail")
    public String getIPCDetail(@RequestParam("id") String id, Model model) throws IOException {

        String url_getIPC = "http://180.76.242.135:19996/getIpcByID?ID=" + id;
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url_getIPC);
        CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity(), "utf-8");
        IpcBean ipcBean = API.API3(result);
        model.addAttribute("ipcDetail", ipcBean);
        return "ipc_detail1";
    }

}
