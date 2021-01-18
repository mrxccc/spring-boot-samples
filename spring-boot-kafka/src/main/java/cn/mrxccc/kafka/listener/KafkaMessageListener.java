package cn.mrxccc.kafka.listener;

import cn.mrxccc.kafka.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author mrxccc
 * @create 2021/1/18
 */
@Component
@Slf4j
public class KafkaMessageListener {


    // @KafkaListener(topics = "test", groupId = "test-consumer")
    // @KafkaListener(groupId = "test-consumer",
    //         topicPartitions = @TopicPartition(topic = "test",
    //                 partitionOffsets = {
    //                         @PartitionOffset(partition = "0", initialOffset = "0")
    //                 }))
    // public void listen(@Payload String message,
    //                    @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
    //     logger.info("接收消息: {}，partition：{}", message, partition);
    // }

    @KafkaListener(topics = "test", groupId = "test-consumer")
    public void listen(Message message) {
        log.info("接收消息: {}", message);
    }

}
