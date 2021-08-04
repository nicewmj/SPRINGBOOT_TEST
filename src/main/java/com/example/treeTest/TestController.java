package com.example.treeTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestController {

    @RequestMapping("/testList")

    public List getList() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("李健", 18));
        userList.add(new User("周杰伦", 20));
        userList.add(new User("李雪健", 30));
        return userList;
    }


    @RequestMapping("/testMap")
    public Map getMap() {
        HashMap<String, User> hashMap = new HashMap<>();
        hashMap.put("1号男嘉宾", new User("卡卡罗特", 21));
        hashMap.put("2号男嘉宾", new User("贝吉塔", 22));
        hashMap.put("3号男嘉宾", new User("雅木茶", 23));
        return hashMap;
    }

//Set和List都是对应一个JS数组  除非要去重
    @RequestMapping("/testSet")
    public Set getSet() {
        HashSet<User> hashSet = new HashSet<>();
        hashSet.add(new User("刘备", 33));
        hashSet.add(new User("关羽", 32));
        hashSet.add(new User("张飞", 31));
        return hashSet;

    }

    @RequestMapping("getListTree")
    public List getListTree() {

        // 定义一个List，用来存储最终结果
        ArrayList<JsBean> superMen = new ArrayList<>();


        //------------------------七龙珠（从下往上看会好理解些，开枝散叶）------------------------

        // 孙悟饭的儿子们：悟饭儿子1、悟饭儿子2
        List<JsBean> grandChildren1 = new ArrayList<>();
        grandChildren1.add(new JsBean("悟饭儿子1", false, false, null));
        grandChildren1.add(new JsBean("悟饭儿子2", false, false, null));


        // 孙悟天的儿子们：悟天儿子1、悟天儿子2
        List<JsBean> grandChildren2 = new ArrayList<>();
        grandChildren2.add(new JsBean("悟天儿子1", false, false, null));
        grandChildren2.add(new JsBean("悟天儿子2", false, false, null));


        // 孙悟空的儿子：悟饭、悟天
        List<JsBean> children = new ArrayList<>();
        children.add(new JsBean("悟饭", false, true, grandChildren1));
        children.add(new JsBean("悟天", false, true, grandChildren2));


        // 孙悟空本人
        JsBean wukong = new JsBean("悟空", true, true, children);


        //------------------------火影忍者（从下往上看会好理解些，开枝散叶）------------------------

        // 鸣人的徒弟们：博人1、博人2
        List<JsBean> grandChildren3 = new ArrayList<>();
        grandChildren3.add(new JsBean("博人1", false, false, null));
        grandChildren3.add(new JsBean("博人2", false, false, null));


        // 佐助的徒弟们：佐良娜1、佐良娜2
        List<JsBean> grandChildren4 = new ArrayList<>();
        grandChildren4.add(new JsBean("佐良娜1", false, false, null));
        grandChildren4.add(new JsBean("佐良娜2", false, false, null));


        // 卡卡西的徒弟们：鸣人、佐助
        List<JsBean> children2 = new ArrayList<>();
        children2.add(new JsBean("鸣人", false, true, grandChildren3));
        children2.add(new JsBean("佐助", false, true, grandChildren4));

        // 卡卡西本人
        JsBean kakaxi = new JsBean("卡卡西", true, true, children2);

        //------------------------处理结果------------------------

        // 只把孙悟空和卡卡西加入List
        superMen.add(wukong);
        superMen.add(kakaxi);
        return superMen;
    }



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    class User{
        private String name;
        private Integer age;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class JsBean{
        private String name;
        private Boolean open;
        private Boolean isParent;
        // 前端JS对象的children数组(对应List)里存的还是JS对象（对应JsBean），所以是List<JsBean>
        private List<JsBean> children;

    }
}
