package com.example.grad.controller;

import com.example.grad.bean.IpcBean;
import com.example.grad.bean.StandardBean;
import com.example.grad.mapper.StandardMapper;
import com.example.grad.utils.API;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;


/**
 * @author zxf
 */
@Controller
@RequestMapping(value = "/standard")
public class StandardController {

    @Autowired(required = false)
    StandardMapper standardMapper;

    /**
     * standard的update和delete
     * @param id
     * @param submit
     * @param model
     * @return
     */
    @RequestMapping(value = "/update")
    public String changeStandard(@RequestParam("id") int id, @RequestParam("submit") String submit, Model model){
        if(submit.equals("进入修改")){
            StandardBean standardDetail = standardMapper.selectDetail(id);
            model.addAttribute("standardDetail", standardDetail);
            return "standard_change1";
        }else if(submit.equals("删除")){
            int deleteCount = standardMapper.deleteStandardM(id);
            List<StandardBean> standardList = standardMapper.selectStandard10();
            model.addAttribute("standardList", standardList);
            int max_id = standardMapper.selectMaxID() + 1;
            model.addAttribute("maxID", max_id);
            return "standard_manage1";
        }
        return "standard_manage1";
    }

    /**
     * 通过所属领域查找标准
     * @param optFeature
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryByFeature")
    public String byFeature(@RequestParam("optFeature") String optFeature, Model model){
        List<StandardBean> standardList1 = standardMapper.selectStandardByFeature(optFeature);
        model.addAttribute("standardList1", standardList1);
        return "standard_by1";
    }

    /**
     * 通过主管部门查找标准数据
     * @param optComp
     * @param submit
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryByComp")
    public String byComp(@RequestParam("optComp") String optComp, @RequestParam("submit") String submit, Model model){
        List<StandardBean> standardList1 = standardMapper.selectStandardByComp(optComp);
        model.addAttribute("standardList1", standardList1);
        return "standard_by1";
    }

    /**
     * 标准详情,推荐的标准数据和专利数据
     * @param id
     * @param submit
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/standard")
    public String standard(@RequestParam("id") int id, @RequestParam("submit") String submit, Model model) throws IOException {
        if(submit.equals("标准详情")){
            StandardBean standardDetail = standardMapper.selectDetail(id);
            model.addAttribute("standardDetail", standardDetail);

            // 通过id推荐标准的API接口
            //String url_standByID = "http://180.76.242.135:19997/DOC_preStandByID?ID=" + id;
            String url_standByID = "http://180.76.242.135:19995/CF_Recommend?ID=" +id;
            CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(url_standByID);
            CloseableHttpResponse response = closeableHttpClient.execute(httpGet);
            // HttpEntity msg = response.getEntity();
            // 当前响应的状态
            // System.out.println(response.getStatusLine());
            // 获取服务器响应信息,每个方法只能使用一次
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            List<StandardBean> apiStandList =  API.API1(result);
            model.addAttribute("apiStandardList", apiStandList);

            // 通过id推荐专利的API接口
            // String url_ipcByID = "http://180.76.242.135:19996/DOC_preIpcByStandID?ID=" + id;
            String url_ipcByID = "http://180.76.242.135:19996/DOC_preIpcByStandID_1?ID=" + id;
            CloseableHttpClient closeableHttpClient2 = HttpClientBuilder.create().build();
            HttpGet httpGet2 = new HttpGet(url_ipcByID);
            CloseableHttpResponse response2 = closeableHttpClient2.execute(httpGet2);
            String result2 = EntityUtils.toString(response2.getEntity(), "utf-8");
            List<IpcBean> apiIpcList =  API.API2(result2);
            model.addAttribute("apiIpcList", apiIpcList);
            return "standard_detail1";
        }
        return "home1";
    }

    /**
     * home1的换页操作
     * @param submit
     * @param lastID
     * @param model
     * @return
     */
    @RequestMapping(value = "/changePage")
    public String changePage(@RequestParam("submit") String submit, @RequestParam("lastID") int lastID, Model model){
        int count = standardMapper.selectCount();
        if(submit.equals("上一页")){
            if(lastID <= 20){
                lastID = 0;
            }else {
                lastID = lastID - 20;
            }
        }else if(submit.equals("下一页")){
            if(lastID >= count){
                lastID = (count / 10) * 10;
            }
        }else if(submit.equals("跳转")){
            if(lastID <= 10){
                lastID = 0;
            }else if(lastID >= count){
                lastID = (count / 10) * 10;
            }else {
                lastID = lastID - 10;
            }
        }
        List<StandardBean> standardList = standardMapper.selectStandardChange(lastID);
        model.addAttribute("standardList", standardList);
        List<String> featureList = standardMapper.selectDistinctFeature();
        model.addAttribute("featureList", featureList);
        List<String> compList = standardMapper.selectDistinctComp();
        model.addAttribute("compList", compList);
        return "home1";
    }

    /**
     * 管理员的换页操作
     * @param submit
     * @param lastID
     * @param model
     * @return
     */
    @RequestMapping(value = "/changePageAdmin")
    public String changePageAdmin(@RequestParam("submit") String submit, @RequestParam("lastID") int lastID, Model model){
        int count = standardMapper.selectCount();
        if(submit.equals("上一页")){
            if(lastID <= 20){
                lastID = 0;
            }else {
                lastID = lastID - 20;
            }
        }else if(submit.equals("下一页")){
            if(lastID >= count){
                lastID = (count / 10) * 10;
            }
        }else if(submit.equals("跳转")){
            if(lastID <= 10){
                lastID = 0;
            }else if(lastID >= count){
                lastID = (count / 10) * 10;
            }else {
                lastID = lastID - 10;
            }
        }
        List<StandardBean> standardList = standardMapper.selectStandardChange(lastID);
        model.addAttribute("standardList", standardList);
        return "standard_manage1";
    }

    /**
     * Forget?
     * @param model
     * @return
     */
    @RequestMapping(value = "/standardManage")
    public String standardManage(Model model){
        List<StandardBean> standardList = standardMapper.selectStandard10();
        model.addAttribute("standardList", standardList);
        int max_id = standardMapper.selectMaxID() + 1;
        model.addAttribute("maxID", max_id);
        return "standard_manage1";
    }

    /**
     * 换页操作
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/standardHome")
    public String standardHome(@RequestParam("id") int id, Model model){
        int returnID;
        // 如果是最后一条,则id-10
        if(id % 10 == 0){
            returnID = id - 10;
        }else {
            returnID = (id / 10) * 10;
        }
        List<StandardBean> standardList = standardMapper.selectStandardChange(returnID);
        model.addAttribute("standardList", standardList);
        return "home1";
    }

    /**
     * 插入新的standard数据
     * @param id
     * @param standard_id
     * @param standard_name_cn
     * @param standard_name_en
     * @param standard_class
     * @param standard_state
     * @param standard_adopt
     * @param release_date
     * @param impl_date
     * @param css
     * @param iss
     * @param competent_department
     * @param technical_comm
     * @param standard_feature
     * @param model
     * @return
     */
    @RequestMapping(value = "/insert")
    public String insert(@RequestParam("id") int id, @RequestParam("standard_id") String standard_id, @RequestParam("standard_name_cn") String standard_name_cn, @RequestParam("standard_name_en") String standard_name_en, @RequestParam("standard_class") String standard_class, @RequestParam("standard_state") String standard_state, @RequestParam("standard_adopt") String standard_adopt, @RequestParam("release_date") String release_date,
                         @RequestParam("impl_date") String impl_date, @RequestParam("CSS") String css, @RequestParam("ISS") String iss, @RequestParam("competent_department") String competent_department, @RequestParam("technical_comm") String technical_comm, @RequestParam("standard_feature") String standard_feature, Model model){
        if(standard_id.isEmpty() || standard_name_cn.isEmpty()){
            int max_id = standardMapper.selectMaxID() + 1;
            model.addAttribute("maxID", max_id);
            List<StandardBean> standardList = standardMapper.selectStandard10();
            model.addAttribute("standardList", standardList);
            return "standard_manage1";
        }
        int insertCount = standardMapper.insert(id, standard_id, standard_name_cn, standard_name_en, standard_class, standard_state, standard_adopt, release_date, impl_date, css, iss, competent_department, technical_comm, standard_feature);
        List<StandardBean> standardList = standardMapper.selectStandard10();
        model.addAttribute("standardList", standardList);
        int max_id = standardMapper.selectMaxID() + 1;
        model.addAttribute("maxID", max_id);
        return "standard_manage1";
    }

    /**
     * 测试(test)使用接口
     * @param model
     * @return
     */
    @RequestMapping(value = "/test")
    public String test(Model model){
        List<StandardBean> standardList = standardMapper.selectStandard10();
        model.addAttribute("standardList", standardList);
        return "test";
    }

    /**
     * 推荐页面的standard数据详细信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail")
    public String detail(@RequestParam("id") int id, Model model){
        StandardBean standardDetail = standardMapper.selectDetail(id);
        model.addAttribute("standardDetail",standardDetail);
        return "standard_detail2";
    }

    /**
     * 修改标准的详情页
     * @param id
     * @param standard_class
     * @param standard_state
     * @param standard_adopt
     * @param release_date
     * @param impl_date
     * @param css
     * @param iss
     * @param competent_department
     * @param technical_comm
     * @param standard_feature
     * @param submit
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateDetail")
    public String updateDetail(@RequestParam("id") int id, @RequestParam("standard_class") String standard_class, @RequestParam("standard_state") String standard_state, @RequestParam("standard_adopt") String standard_adopt, @RequestParam("release_date") String release_date, @RequestParam("impl_date") String impl_date,
                               @RequestParam("CSS") String css, @RequestParam("ISS") String iss, @RequestParam("competent_department") String competent_department, @RequestParam("technical_comm") String technical_comm, @RequestParam("standard_feature") String standard_feature, @RequestParam("submit") String submit, Model model){
        if(submit.equals("修改")){
            int updateCount = standardMapper.updateDetail(standard_class, standard_state, standard_adopt,release_date, impl_date, css, iss, competent_department, technical_comm, standard_feature, id);
            StandardBean standardDetail = standardMapper.selectDetail(id);
            model.addAttribute("standardDetail", standardDetail);
            return "standard_change1";
        }else if(submit.equals("返回标准管理页")){
            List<StandardBean> standardList = standardMapper.selectStandard10();
            model.addAttribute("standardList", standardList);
            int max_id = standardMapper.selectMaxID() + 1;
            model.addAttribute("maxID", max_id);
            return "standard_manage1";
        }
        return "standard_change1";
    }

}
