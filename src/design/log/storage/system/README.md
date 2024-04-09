# Design a log storage system

Given several logs that each log contains a unique id, timestamp and a value string. Timestamp is a string that has the following format: `Year:Month:Day:Hour:Minute:Second`, for example, `2017:01:01:23:59:59`. All domains are zero-padded decimal numbers. Design a storage solution that can 
store the logs and query logs based on their unique id within a certain time period. 

# Roadmap:

## Log store: 
Given a log, store the log in the storage system.

```json
{
    "_id": 136584,
    "timestamp": "2017:01:01:23:59:59",
    "value": "abcd"
}

```
## Query:
A query consist of a time period defined by [start, end] and a granularity. Granularity means the time level for consideration or how precise the range should be (i.e. to the exact Day, Minute, etc.). Return the id of logs whose timestamps are within the range from start to end inclusive

```json
{ 
    "start": "2017:01:01:23:59:59",
    "end": "2017:01:02:23:59:59",
    "granularity": "Day"
}
```

## Optimization
Optimize query based retrieval of logs using TreeMap.

## Persistence
Add persistence using a database, mongoDB preferably. 
