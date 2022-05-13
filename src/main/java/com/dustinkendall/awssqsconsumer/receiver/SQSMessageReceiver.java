package com.dustinkendall.awssqsconsumer.receiver;

import com.dustinkendall.awssqsconsumer.domain.MessagePojo;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SQSMessageReceiver
{

    @SqsListener(value = "https://sqs.us-east-1.amazonaws.com/675152124436/DemoQueue.fifo", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receivePojo(@Headers Map<String, String> sqsMessageHeader, @Payload MessagePojo pojo)//, @NotificationMessage MessagePojo pojo)
    {
        //This line throws a classcast exception due to some odd spring depe
        //String mimeType = sqsMessageHeader.get("contentType").toString();
        System.out.println("The pojo was automatically deserialized by jackson/spring because ");
        System.out.println("contentType = " + "application/json");
        System.out.println(pojo);
    }

    //@SqsListener(value = "https://sqs.us-east-1.amazonaws.com/675152124436/DemoQueue.fifo", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receivePojoMap(@Headers Map<String, String> sqsMessageHeader, @Payload Map<String,MessagePojo> pojoMap)
    {
        for(Map.Entry<String, MessagePojo> entry : pojoMap.entrySet())
        {
            System.out.println("Entry Key = " + entry.getKey());
            System.out.println("Entry Value = " + entry.getValue());
        }

    }


}
