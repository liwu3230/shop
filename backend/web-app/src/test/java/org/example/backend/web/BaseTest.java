package org.example.backend.web;

import org.example.backend.common.model.param.business.TaskOrderParam;
import org.example.backend.common.service.business.TaskOrderService;
import org.example.backend.common.service.msg.sms.SMSClient;
import org.example.backend.common.service.pay.TransferToBalanceService;
import org.example.backend.common.service.pay.model.QueryMmPay;
import org.example.backend.common.service.pay.model.QueryResponse;
import org.example.backend.common.service.pay.model.SendMmPay;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import jakarta.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collections;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/6/11 14:45
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = WebApplication.class)
@AutoConfigureMockMvc
public class BaseTest {

    @Resource
    private MockMvc mockMvc;
    @Resource
    TransferToBalanceService transferToBalanceService;
    @Resource
    private TaskOrderService taskOrderService;
    @Resource
    SMSClient smsClient;
    @Resource
    IAppUserDao iAppUserDao;

    @Test
    public void testSms() throws Exception {
        iAppUserDao.updateLocationSwitchById(3, true);
//        smsClient.sendPushTask("17621154225", "“测试项目”");
//        smsClient.sendNotifyTask("17621154225", "“测试项目”");
    }


    @Test
    public void testGetAllSimple() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders
                .get("/common/user/getAllSimple")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void testUploadFile() throws Exception {
        File file = new File("C:\\Users\\yyadmin\\Desktop\\test.png");
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "test.png", "multipart/form-data",
                new FileInputStream(file));
        String result = mockMvc.perform(
                        MockMvcRequestBuilders.multipart("/common/uploadFile")
                                .file(mockMultipartFile)
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void testSendMoney() throws Exception {
        SendMmPay sendMmPay = new SendMmPay();
        sendMmPay.setRedValue(100);
        sendMmPay.setOpenid("oNxkV7bEFGid4AnhIDYvR3kvYfJk");
        sendMmPay.setBatchName("测试");
        sendMmPay.setBatchRemark("测试");
        transferToBalanceService.sendPay(sendMmPay);
    }

    @Test
    public void testQueryPay() throws Exception {
        QueryMmPay queryMmPay = new QueryMmPay();
        queryMmPay.setPartner_trade_no("b1b76e992cda422a9cd7857402403491");
        QueryResponse result = transferToBalanceService.queryPay(queryMmPay);
        System.out.println(result);
    }

    @Test
    public void testUpdateOrder() throws Exception {
        TaskOrderParam param = new TaskOrderParam();
        param.setIds(Collections.singletonList(1));
        param.setStatus(2);
        taskOrderService.updateOrderStatus(param);
    }

}
