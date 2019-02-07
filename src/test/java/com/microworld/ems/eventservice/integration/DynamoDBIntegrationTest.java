package com.microworld.ems.eventservice.integration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.microworld.ems.eventservice.model.EventsTable;
import com.microworld.ems.eventservice.repository.EventInfoRepository;
import com.microworld.ems.eventservice.testutil.TestConstants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.OffsetDateTime;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = "application.properties")
@WebAppConfiguration
@ActiveProfiles("local")
@TestPropertySource(properties = {
        "amazon.dynamodb.endpoint=http://localhost:8000/",
        "amazon.aws.accesskey=test1",
        "amazon.aws.secretkey=test231" })
public class DynamoDBIntegrationTest {
    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    private EventInfoRepository repository = mock(EventInfoRepository.class);

    private static final OffsetDateTime START_DATE = OffsetDateTime.parse("2018-10-26T12:00-06:00");
    private static final OffsetDateTime END_DATE = OffsetDateTime.now();
    private static final int LIMIT = 10;

    @Before
    public void setup() throws Exception {
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper
                .generateCreateTableRequest(EventsTable.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);

        /* ... */

        dynamoDBMapper.batchDelete(
                (List<EventsTable>)repository.findAll());
    }

    @Test
    public void sampleTestCase() {
        EventsTable dave = TestConstants.getAnEventFromDB();
        repository.save(dave);

        List<EventsTable> result
                = (List<EventsTable>) repository.findAll();
        System.out.println(result.get(0));
//        assertTrue("Not empty", result.size() > 0);
//        assertTrue("Contains item with expected cost",
//                result.get(0).getEventId().equals(dave.getEventId()));
    }
}
