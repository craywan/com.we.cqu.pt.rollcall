package edu.uddp.controller;

import com.baidu.aip.face.AipFace;
import edu.uddp.model.ClassInfo;
import edu.uddp.model.StuInfo;
import edu.uddp.service.ClassInfoService;
import edu.uddp.service.StuInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: rollcall-ai
 * @description: 人脸识别点名
 * @author: yangxinyu
 * @create: 2018-08-26
 **/
@Api(description = "人脸")
@RestController
@RequestMapping("/ai")
public class AipFaceController {
    @Autowired
    StuInfoService stuInfoService;
    @Autowired
    ClassInfoService stuClassService;

    AipFace client = new AipFace("11729204","0g0oX6nB336OsqVuN2RLXmbs", "wRmNdG35jvlVX4Nvip73GhnUIx96WGcj");

    @ApiOperation(value = "人脸批量注册")
    @GetMapping("/register")
    public void register() {
        List<ClassInfo> stuClasses = stuClassService.showAll();
        for (int j = 0; j < stuClasses.size(); j++) {
            List<StuInfo> stuInfos = stuInfoService.selectByClassId(stuClasses.get(j).getClassId());
            for (int i = 0; i < stuInfos.size(); i++) {
                StuInfo stuInfo = stuInfos.get(i);
                // 传入可选参数调用接口
                HashMap<String, String> options = new HashMap<String, String>();
                options.put("user_info", "user's info");
                options.put("quality_control", "NORMAL");
                options.put("liveness_control", "LOW");

                String imageType = "URL";
                String image = "https://we.cqu.pt/jwzx/showstuPic.php?xh=" + stuInfo.getStuId();
                String groupId = stuInfo.getClassId();
                String userId = stuInfo.getStuId();

                // 人脸注册
                JSONObject res = client.addUser(image, imageType, groupId, userId, options);
                System.out.println(res.toString(2));
            }
        }
    }

    @ApiOperation(value = "查看最相似")
    @GetMapping("/search/{stuId}")
    public Map<String,Object> search(@PathVariable String stuId) {
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> list = new ArrayList<>();
        String classId = stuInfoService.selectByStuId(stuId).getClassId();
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("quality_control", "NORMAL");
        options.put("liveness_control", "LOW");
        options.put("users_id", stuId);
        options.put("max_user_num", "4");

        String image = "https://we.cqu.pt/jwzx/showstuPic.php?xh=" + stuId;
        String imageType = "URL";
        String groupIdList = classId;

        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);
        Map<String,Object> userListMap = (Map<String, Object>) res.toMap().get("result");
        userListMap.remove("face_token");
        List userList = (List) userListMap.get("user_list");
        for (int i = 1; i < 4; i++) {
            Map<String,String> user = (Map<String, String>) userList.get(i);
            String userId = String.valueOf(user.get("user_id"));
            String score = String.valueOf(user.get("score"));
            String name = stuInfoService.selectByStuId(userId).getName();
            Map<String,Object> userMap = new HashMap<String , Object>();
            userMap.put("name", name);
            userMap.put("score",score);
            list.add(userMap);
        }
        result.put("status",200);
        result.put("message","ok");
        result.put("data",list);
        return result;
    }


}