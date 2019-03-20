package com.microworld.ems.eventservice.repository;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.microworld.ems.eventservice.model.EventsTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class EventInfoAdditionalRepositoryImpl implements EventInfoAdditionalRepository {
    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

   // static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();

    @Override
    public List<EventsTable> findByEmailAddressAndType(String eventHolderEmail, String eventType) {
//        Map<String, String> expressionAttributesNames = new HashMap<>();
//        expressionAttributesNames.put("eventHolderEmail", "eventHolderEmail");
//        expressionAttributesNames.put("eventType", "eventType");
        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":eventHolderEmail", new AttributeValue().withS(eventHolderEmail));
        expressionAttributeValues.put(":eventType", new AttributeValue().withS(eventType));
        DynamoDBQueryExpression<EventsTable> queryExpression = new DynamoDBQueryExpression<EventsTable>()
                .withIndexName("Event_Index")
                .withKeyConditionExpression("eventHolderEmail = :eventHolderEmail and eventType = :eventType")
              //  .withExpressionAttributeNames(expressionAttributesNames)
                .withExpressionAttributeValues(expressionAttributeValues)
                .withConsistentRead(false);
        List<EventsTable> eventItems = mapper.query(EventsTable.class,queryExpression);
        System.out.println("=>>>>>>>" + eventItems);
      return eventItems;
    }

//    @Override
//    public List<EventsTable> findEventsByDates(OffsetDateTime startDate, OffsetDateTime endDate, int limit){
//        DynamoDBMapper mapper = new DynamoDBMapper(amazonDynamoDB);
////        2018-10-26T12:00-06:00
//        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm:ss");
//        dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
//        String startDateStr = dateFormatter.format(startDate);
//        String endDateStr = dateFormatter.format(endDate);
//        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
//        expressionAttributeValues.put(":startDate", new AttributeValue().withS(startDateStr));
//        expressionAttributeValues.put(":endDate", new AttributeValue().withS(endDateStr));
//        DynamoDBQueryExpression<EventsTable> scanExpression = new DynamoDBQueryExpression<EventsTable>()
//                .withKeyConditionExpression("ReplyDateTime between :val2 and :val3")
//                .withExpressionAttributeValues(eav);
//    }
}
