# Design a TimeMap

Design a time-based key-value store that can store multiple values for the same key at different timestamps and retrieve the value of a given key at a certain timestamp.

Time stamp is a string that has the following format: `Year:Month:Day:Hour:Minute:Second`, for example, `2017:01:01:23:59:59`. All domains are zero-padded decimal numbers.

## Public APIs

- Stores the `key` with the value `value` at the given time `timestamp`.

```json
{
  "key": "h3L0W0rLd987654321ABCD567890ZX",
  "value": "$1352.013",
  "timestamp": "2027:01:01:00:00:00"
}
```

- Retrieve the `value` of a provided `key` at a certain `timestamp`. Returns a value such that, at `some_timestamp_prev` <= `timestamp` the `key` is stored, in case of multiple such values, it should
return the `value` associated with the largest `some_timestamp_prev`. If there's no such value return 
an empty string. 

```json
{
  "key": "a6sdk284JTpqzANipaW24zx",
  "timestamp": "2017:11:21:01:43:56"
}
```
