package cn.mrxccc.kafka.controller;

import cn.mrxccc.kafka.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author mrxccc
 * @create 2021/1/18
 */
@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @GetMapping("send/{message}")
    public void send(@PathVariable String message) {
//        this.kafkaTemplate.send("test", new Message("", message));
    }

    // @GetMapping("send/{message}")
    // public void send(@PathVariable String message) {
    // ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send("test", message);
    // future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
    // @Override
    // public void onSuccess(SendResult<String, String> result) {
    // log.info("成功发送消息：{}，offset=[{}]", message, result.getRecordMetadata().offset());
    // }
    //
    // @Override
    // public void onFailure(Throwable ex) {
    // log.error("消息：{} 发送失败，原因：{}", message, ex.getMessage());
    // }
    // });
    // }
}
