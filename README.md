# Learning Point(LP) and Implementaion Point(IP)


1. Define an API contract - LP:2 + IP:3
    What to define ?
    a) Post endpoint according to REST to create a event resource
    b) Get endpoint with filters and pagination(optional)
        - Filter by event type and date range
        - Filter by ZIP codes
    c) Define error model

2. Design a model with Lombok - LP:1 + IP:2
    2.1. Create a corresponding DynamoDB model

3. Implement controller and unit tests - LP:2 + IP:3

4. Introduce Queue between controller and Queue Processor - LP:2 + IP:1

5. Implement Queue processor with unit tests - LP:3 + IP:3

6. Implement paginated DynamoDB repository and DB unit - LP:3 + IP:3