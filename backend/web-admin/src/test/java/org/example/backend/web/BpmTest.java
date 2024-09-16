package org.example.backend.web;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.example.backend.bpm.domain.dto.StartForm;
import org.example.backend.bpm.service.FlowInstanceService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/19 11:33
 */
public class BpmTest extends BaseTest {

    @Resource
    private FlowInstanceService flowInstanceService;

    @Test
    public void test() throws Exception {
        StartForm startForm = new StartForm();
        startForm.setUserName("admin");
        startForm.setProcDefId("test3");
        Map<String, Object> form = new HashMap<>();
        form.put("name1", "11111222");
        form.put("name2", "东西");
        form.put("name3", "周星驰");
        Map<String, Object> extendVar = new HashMap<>();
        extendVar.put("leader", "admin");
        extendVar.put("leader2", "admin");
        startForm.setForm(form);
        startForm.setExtendVar(extendVar);
        flowInstanceService.startProcessInstanceById(startForm);
    }

    private static LoadingCache<String, Map<String, String>> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS).build(new CacheLoader<String, Map<String, String>>() {
                @Override
                public Map<String, String> load(String key) throws Exception {
                    System.out.println("load！！！！");
                    Map<String, String> map = new HashMap<>();
                    map.put("name", "张三");
                    Thread.sleep(3000);
                    return map;
                }
            });

    public static void main(String[] args) throws Exception {
        for (; ; ) {
            Map<String, String> values = cache.get("KEY");
            System.out.println(values);
        }
    }

}
